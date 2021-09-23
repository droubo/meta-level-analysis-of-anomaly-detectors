package alexp.macrobase;

import alexp.macrobase.pipeline.Pipeline;
import alexp.macrobase.pipeline.benchmark.config.AlgorithmConfig;
import alexp.macrobase.pipeline.benchmark.config.ExecutionType;
import alexp.macrobase.pipeline.benchmark.result.ResultFileWriter;
import alexp.macrobase.pipeline.config.StringObjectMap;
import alexp.macrobase.utils.CollectionUtils;
import com.google.common.collect.Lists;
import alexp.macrobase.pipeline.benchmark.BenchmarkPipeline;
import alexp.macrobase.pipeline.benchmark.config.BenchmarkConfig;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Benchmark {
    PrintStream out = System.out;
    PrintStream err = System.err;

    private final OptionParser optionParser = new OptionParser();
    private final OptionSpec<String> benchmarkOption;
    private final OptionSpec<String> outputOption;
    private final OptionSpec clearOutputOption;
    private final OptionSpec streamOption;
    private final OptionSpec explanationOption;
    private final OptionSpec<String> dataDirOption;
    private final OptionSpec<String> classifierOption;
    private final OptionSpec<String> explainerOption;

    private OptionSet options;

    private String outputDir = Pipeline.defaultOutputDir();

    Benchmark() {
        benchmarkOption = optionParser.acceptsAll(Arrays.asList("benchmark", "b"), "Run benchmark for outlier detection algorithms. Outputs time and raw scores.")
                .withRequiredArg().describedAs("config_file_path");
        outputOption = optionParser.acceptsAll(Arrays.asList("save-output", "so"), "Save output (outliers, charts, etc.) to files in the specified dir (alexp/output by default)")
                .withRequiredArg().describedAs("dir_path");
        clearOutputOption = optionParser.acceptsAll(Arrays.asList("clear-output", "co"), "Clear the output dir");
        streamOption = optionParser.accepts("s", "Run in streaming mode (default batch)")
                .availableIf(benchmarkOption);
        explanationOption = optionParser.accepts("e", "Run in explanation mode (default non explanation)")
                .availableIf(benchmarkOption);
        dataDirOption = optionParser.accepts("data-dir", "Path of the root data dir that will be prepended for paths from the config file")
                .availableIf(benchmarkOption).withRequiredArg().describedAs("root_dir_path");
        classifierOption = optionParser.acceptsAll(Arrays.asList("classification-algorithm", "ca"), "Run only the specified classifier")
                .availableIf(benchmarkOption).withRequiredArg().describedAs("classifier");
        explainerOption = optionParser.acceptsAll(Arrays.asList("explanation-algorithm", "ea"), "Run only the specified explainer")
                .availableIf(explanationOption).withRequiredArg().describedAs("explainer");
    }

    private void runBenchmark(String confFilePath) throws Exception {
        BenchmarkConfig config = BenchmarkConfig.load(StringObjectMap.fromYamlFile(confFilePath));

        ExecutionType type = ExecutionType.BATCH_CLASSIFICATION;
        if (options.has(streamOption)) {
            type = ExecutionType.STREAMING_CLASSIFICATION;
        } else if (options.has(explanationOption)) {
            type = ExecutionType.EXPLANATION;
        }

        if (config.getClassifierConfigs().isEmpty()) {
            err.println("Classifiers were not specified");
        }
        if (type == ExecutionType.EXPLANATION && config.getExplainerConfigs().isEmpty()) {
            err.println("Explainers were not specified");
        }

        List<AlgorithmConfig> classifiers = config.getClassifierConfigs();
        List<AlgorithmConfig> explainers = config.getExplainerConfigs();

        if (options.has(classifierOption)) {
            String id = classifierOption.value(options);
            classifiers = classifiers.stream()
                    .filter(a -> a.getAlgorithmId().equals(id))
                    .collect(Collectors.toList());
            if (classifiers.isEmpty()) {
                err.println(String.format("Classifier '%s' not found", id));
                System.exit(1);
            }
        }

        if (options.has(explainerOption)) {
            String id = explainerOption.value(options);
            explainers = explainers.stream()
                    .filter(a -> a.getAlgorithmId().equals(id))
                    .collect(Collectors.toList());
            if (explainers.isEmpty()) {
                err.println(String.format("Explainer '%s' not found", id));
                System.exit(1);
            }
        }

        for (AlgorithmConfig classifierConf : classifiers) {
            for (AlgorithmConfig explainerConf : CollectionUtils.listOrSingleNullElement(explainers)) {
                BenchmarkPipeline pipeline = new BenchmarkPipeline(type, config.getExecutionConfig(classifierConf, explainerConf), dataDirOption.value(options),
                        new ResultFileWriter(type)
                                .setOutputDir(outputDir)
                                .setBaseFileName(FilenameUtils.getBaseName(confFilePath)));
                pipeline.setOutputDir(outputDir);
                pipeline.setOutputStream(out);

                pipeline.run();
            }
        }
    }

    private void showUsage() throws IOException {
        optionParser.printHelpOn(out);
        out.println("Examples:");
        out.println("  -b alexp/data/outlier/config.yaml");
        out.println("  -b alexp/data/outlier/config.yaml --data-dir ../datasets");
        out.println("  -b alexp/data/outlier/config.yaml --co");
        out.println("  -b alexp/data/outlier/config.yaml --so ../my-output-folder --co");
        out.println("  -b alexp/data/outlier/exlpanationConfig.yaml --e");
        out.println("  -b alexp/data/outlier/streamingConfig.yaml --s");
        out.println("  -b alexp/data/outlier/config.yaml --ca iforest");
        out.println("  -b alexp/data/outlier/config.yaml -e --ca iforest --ea lookout");
    }

    int run(String[] args) throws Exception {
        try {
            validateObtainOptions(args);
        } catch (Exception ex) {
            return 1;
        }

        if (options.has(outputOption)) {
            outputDir = outputOption.value(options);
        }

        if (options.has(clearOutputOption)) {
            if (!StringUtils.isEmpty(outputDir) && Files.exists(Paths.get(outputDir))) {
                try {
                    FileUtils.cleanDirectory(new File(outputDir));
                } catch (IOException ex) {
                    err.println(ex.getMessage());
                }
            }
        }

        if (options.has(benchmarkOption)) {
            // THE YAML CONFIGURATION OF BENCHMARK OPTION (MUST BE INCLUDED)
            String confPath = benchmarkOption.value(options);
            System.out.println(confPath);
            if (!Files.exists(Paths.get(confPath))) {
                err.println("Config file not found");
                return 3;
            }

            List<String> confFilePaths = Lists.newArrayList(confPath);

            // run for all config files if a directory is given
            boolean isDir = Files.isDirectory(Paths.get(confPath));
            if (isDir) {
                out.println("Running for all configs in " + confPath);
                out.println("This should not be used for time/memory measurements");
                confFilePaths = Files.walk(Paths.get(confPath))
                        .map(Path::toString)
                        .filter(s -> s.endsWith("yaml"))
                        .collect(Collectors.toList());
            }
            java.util.Collections.sort(confFilePaths); 
            System.out.println(confFilePaths);
            for (String confFilePath : confFilePaths) {
                if (isDir) {
                    out.println();
                    out.println(confFilePath);
                }

                runBenchmark(confFilePath);
            }
        }

        return 0;
    }

    private void validateObtainOptions(String[] args) throws IOException {
        if (args.length == 0) {
            err.println("Not enough parameters");
            showUsage();
            throw new IllegalStateException("args.length == 0");
        }

        // FETCH ALL USER DEFINED OPTIONS
        try {
            options = optionParser.parse(args);
        } catch (Exception ex) {
            err.println(ex.getMessage());
            showUsage();
            throw new IllegalStateException("parse error");
        }

        if (!options.has(benchmarkOption)) {
            err.println("Not enough parameters");
            showUsage();
            throw new IllegalStateException("!options.has(benchmarkOption) && !options.has(gsOption)");
        }
    }

    public static void main(String[] args) throws Exception {
        int exitCode = new Benchmark().run(args);
        System.exit(exitCode);
    }
}
