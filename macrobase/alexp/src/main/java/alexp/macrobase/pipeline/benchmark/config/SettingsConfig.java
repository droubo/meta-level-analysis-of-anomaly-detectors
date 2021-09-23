package alexp.macrobase.pipeline.benchmark.config;

import alexp.macrobase.pipeline.config.StringObjectMap;
import alexp.macrobase.pipeline.benchmark.config.settings.ExplanationSettings;
import joptsimple.internal.Strings;

import java.io.IOException;

public class SettingsConfig {

    private final ExplanationSettings explanationSettings;

    private static final String EXPLANATION_SETTINGS_TAG = "explanationSettings";

    public SettingsConfig(ExplanationSettings explanationSettings) {
        this.explanationSettings = explanationSettings;
    }

    public static SettingsConfig load(String settingsFilePath) throws IOException {
        if(Strings.isNullOrEmpty(settingsFilePath))
            return null;
        StringObjectMap conf = StringObjectMap.fromYamlFile(settingsFilePath);
        return new SettingsConfig(ExplanationSettings.load(conf.getMap(EXPLANATION_SETTINGS_TAG)));
    }

    public ExplanationSettings getExplanationSettings() {
        return explanationSettings;
    }
}
