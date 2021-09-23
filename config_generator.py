
# =============================================================================================== #
#                                              LIBRARIES
# =============================================================================================== #
import os
import sys
import warnings
import yaml
import pandas as pd
import numpy as np
from sklearn.utils import shuffle
import math
if not sys.warnoptions:
    warnings.simplefilter("ignore")

def configurator(algorithm, params, exp_id, flag_dataset=None):
    # =============================================================================================== #
    #                                   ALGORITHM HYPER PARAMETERS
    # =============================================================================================== #
    if(algorithm == 'hst'):
        params.append(0)
    dynamic_tag = "dynamic"
    # DYNAMIC VALUES {TRAIN SIZE, WINDOW SIZE, WINDOW SLIDE} OF DATASET PROPERTIES
    algorithm_train_size_dynamic = 0.5
    algorithm_sub_sample_size_dynamic = 0.4
    algorithm_window_size_dynamic = 0
    algorithm_window_slide_dynamic = 0
    if((algorithm == 'hstf' or algorithm == 'rrcf') and params[1] == 'max'):
        algorithm_forget_threshold_dynamic =  1 #algorithm_sub_sample_size_dynamic
    else:
        algorithm_forget_threshold_dynamic = 0

    # COMMON HYPER-PARAMETERS
    number_of_trees = "100"
    window_size = '128'
    window_slide = '64'
    forget_threshold = "999"

    # HST
    hst_trainSize = "0"             # Automatically
    hst_subSampleSize = "0"         # Automatically
    hst_treesCount = str(params[0])
    hst_depthLimit = dynamic_tag
    hst_windowSize = window_size
    hst_windowType = "tumbling"
    hst_windowMode = "count"
    hst_contamination = "1.0"
    hst_subDimensionSize = "0"      # Automatically
    hst_forgetThreshold = "0"

    # HSTf ( HST using the forgetting mechanism )
    hstf_forgetThreshold = str(params[1])

    # RRCF
    rrcf_trainSize = "0"            # Automatically
    rrcf_subSampleSize = "0"        # Automatically
    rrcf_treesCount = str(params[0])
    rrcf_forgetThreshold = str(params[1])
    rrcf_windowSize = window_size
    rrcf_windowSlide = window_slide
    rrcf_windowType = "sliding"
    rrcf_windowMode = "count"
    rrcf_max_number_leaves = 5000

    # MCOD
    mcod_maxDistance = str(params[0])        # Automatically
    mcod_minNeighborCount = str(params[1])    # Automatically
    mcod_allowDuplicates = "false"
    mcod_windowSize = window_size
    mcod_windowSlide = window_slide
    mcod_windowType = "sliding"
    mcod_windowMode = "count"

    #xstream

    xstream_k = params[1]
    xstream_chains = params[0]
    xstream_train_size = 0.5
    xstream_window_size = window_size
    xstream_windowType = "tumbling"
    xstream_windowMode = "count"

    loda_train_size = 0.5
    loda_window_size = window_size
    loda_windowType = "tumbling"
    loda_windowMode = "count"

    # =============================================================================================== #
    #                                  ** USER DEFINED VARIABLES **
    # =============================================================================================== #

    # PATHS
    dataset_dir = './Dataset/output/'
    configuration_dir = "./Configuration/"
    macrobase_dataset_dir = "csv://alexp/data/streaming/datasets/"

    # EXPERIMENT
    eName = "Experiment" + exp_id

    # ALGORITHMS ['hst', 'hstf', 'rrcf', 'mcod']
    algorithmNames = [algorithm] #['hst', 'hstf', 'rrcf', 'mcod', 'xstream']


    # DATASETS
    attributeNameFinal = "d"
    outputNameFinal = "is_anomaly"

    # =============================================================================================== #
    #                                             YAML TAGS
    # =============================================================================================== #
    yaml_tab = "  "
    yaml_is = ": "
    yaml_has = "- "
    yaml_space = "  "
    yaml_nl = "\n"
    yaml_str = '"'
    yaml_dataset = "dataset"
    yaml_uri = "uri"
    yaml_metricColumns = "metricColumns"
    yaml_labelColumn = "labelColumn"
    yaml_classifiers = "classifiers"
    yaml_id = "id"
    yaml_parameters = "parameters"
    yaml_windowType = "windowType"
    yaml_windowMode = "windowMode"
    yaml_windowSize = "windowSize"
    yaml_windowSlide = "windowSlide"
    yaml_treesCount = "treesCount"
    yaml_contamination = "contamination"
    yaml_subSampleSize = "subSampleSize"
    yaml_trainSize = "trainSize"
    yaml_subDimensionSize = "subDimensionSize"
    yaml_forgetThreshold = "forgetThreshold"
    yaml_depthLimit = "depthLimit"
    yaml_allowDuplicates = "allowDuplicates"
    yaml_maxDistance = "maxDistance"
    yaml_minNeighborCount = "minNeighborCount"
    yaml_k = "k"
    yaml_chains = "chains"
    # =============================================================================================== #
    #                                             FUNCTIONS
    # =============================================================================================== #

    window_sizes = ["128", "256"] # DEFAULT ["128", "256"]
    window_slides = ["64", "128"] # DEFAULT ["64", "128"]



    def set_algorithm_parameters(algorithm_name, dataset_length, dataset_columns):
        # --------------------------------------------------- #
        sub_sample_size = str(int(algorithm_sub_sample_size_dynamic * dataset_length))
        train_size = str(int(algorithm_train_size_dynamic * dataset_length))
        window_size = str(int(algorithm_window_size_dynamic * dataset_length))
        window_slide = str(int(algorithm_window_slide_dynamic * dataset_length))
        forget_threshold = str(int(algorithm_forget_threshold_dynamic * dataset_length))
        # --------------------------------------------------- #
        if algorithm_name == 'hst':
            hst_sub_sample_size = sub_sample_size if algorithm_sub_sample_size_dynamic > 0.0 else hst_subSampleSize
            hst_train_size = train_size if algorithm_train_size_dynamic > 0.0 else hst_trainSize
            hst_window_size = window_size if algorithm_window_size_dynamic > 0.0 else hst_windowSize

            if hst_window_size == "auto":
                if dataset_length > 15000:
                    hst_window_size = window_sizes[1]
                else:
                    hst_window_size = window_sizes[0]

            params[0] = hst_windowType
            params[1] = hst_windowMode
            params[2] = hst_window_size
            params[4] = hst_treesCount
            params[5] = hst_contamination
            params[6] = hst_sub_sample_size
            params[7] = hst_subDimensionSize
            params[8] = hst_forgetThreshold
            params[9] = str(math.ceil(math.log2(int(hst_sub_sample_size)))) if hst_depthLimit == dynamic_tag else hst_depthLimit
            params[14] = hst_train_size
        elif algorithm_name == 'hstf':
            hst_sub_sample_size = sub_sample_size if algorithm_sub_sample_size_dynamic > 0.0 else hst_subSampleSize
            hst_train_size = train_size if algorithm_train_size_dynamic > 0.0 else hst_trainSize
            hst_window_size = window_size if algorithm_window_size_dynamic > 0.0 else hst_windowSize
            hstf_forget_size = forget_threshold if algorithm_forget_threshold_dynamic > 0.0 else hstf_forgetThreshold

            if hst_window_size == "auto":
                if dataset_length > 15000:
                    hst_window_size = window_sizes[1]
                else:
                    hst_window_size = window_sizes[0]

            params[0] = hst_windowType
            params[1] = hst_windowMode
            params[2] = hst_window_size
            params[4] = hst_treesCount
            params[5] = hst_contamination
            params[6] = hst_sub_sample_size
            params[7] = hst_subDimensionSize
            params[8] = hstf_forget_size
            params[9] = str(math.ceil(math.log2(int(hst_sub_sample_size)))) if hst_depthLimit == dynamic_tag else hst_depthLimit
            params[14] = hst_train_size
        elif algorithm_name == 'rrcf':
            rrcf_sub_sample_size = sub_sample_size if algorithm_sub_sample_size_dynamic > 0.0 else rrcf_subSampleSize
            rrcf_forget_size = forget_threshold if algorithm_forget_threshold_dynamic > 0.0 else rrcf_forgetThreshold
            if int(rrcf_sub_sample_size) > rrcf_max_number_leaves and False:
                rrcf_sub_sample_size = str(rrcf_max_number_leaves)
                rrcf_forget_size = str(rrcf_max_number_leaves)
            rrcf_train_size = train_size if algorithm_train_size_dynamic > 0.0 else rrcf_trainSize
            rrcf_window_size = window_size if algorithm_window_size_dynamic > 0.0 else rrcf_windowSize
            rrcf_window_slide = window_slide if algorithm_window_slide_dynamic > 0.0 else rrcf_windowSlide

            if rrcf_window_size == "auto":
                if dataset_length > 15000:
                    rrcf_window_size = window_sizes[1]
                    rrcf_window_slide = window_slides[1]
                else:
                    rrcf_window_size = window_sizes[0]
                    rrcf_window_slide = window_slides[0]
            params[0] = rrcf_windowType
            params[1] = rrcf_windowMode
            params[2] = rrcf_window_size
            params[3] = rrcf_window_slide
            params[4] = rrcf_treesCount
            params[6] = rrcf_sub_sample_size
            params[8] = rrcf_forget_size
            params[10] = str(0)
            params[14] = rrcf_train_size
        elif algorithm_name == 'mcod':

            mcod_window_size = window_size if algorithm_window_size_dynamic > 0.0 else mcod_windowSize
            mcod_window_slide = window_slide if algorithm_window_slide_dynamic > 0.0 else mcod_windowSlide

            if mcod_window_size == "auto":
                if dataset_length > 15000:
                    mcod_window_size = window_sizes[1]
                    mcod_window_slide = window_slides[1]
                else:
                    mcod_window_size = window_sizes[0]
                    mcod_window_slide = window_slides[0]

            params[0] = mcod_windowType
            params[1] = mcod_windowMode
            params[2] = mcod_window_size
            params[3] = mcod_window_slide
            params[11] = mcod_allowDuplicates
            params[12] = mcod_maxDistance
            params[13] = mcod_minNeighborCount
        elif algorithm_name == "xstream":
            #xstream_window_size = window_size

            params[0] = xstream_windowType
            params[1] = xstream_windowMode
            params[2] = xstream_window_size
            params[9] = str(math.ceil(math.log2(int(sub_sample_size)))) if hst_depthLimit == dynamic_tag else hst_depthLimit
            params[15] = str(xstream_k)
            params[16] = str(xstream_chains)
            params[14] = xstream_window_size

        elif algorithm_name == "loda":

            params[0] = loda_windowType
            params[1] = loda_windowMode
            params[2] = loda_window_size
            params[14] = train_size
        else:
            print("[SYSTEM MESSAGE] THERE IS NO ALGORITHM WITH THE REQUESTED NAME: "+algorithm_name)
            pass


    def write(file, string):
        if '""' not in string:
            file.write(string + "\n")


    def write_parameters(file, key, value):
        if value.replace(".", "").isnumeric():
            write(file, yaml_tab + yaml_tab + yaml_tab + key + yaml_is + value)
        elif value in ['true', 'false']:
            write(file, yaml_tab + yaml_tab + yaml_tab + key + yaml_is + value)
        else:
            write(file, yaml_tab + yaml_tab + yaml_tab + key + yaml_is + yaml_str + value + yaml_str)


    def configuration_file_name(algorithm_id, dataset_id, experiment_id):
        return configuration_dir + "" + algorithm_id + "#" + dataset_id.replace(".csv", "") + "#" + experiment_id + ".yaml"


    # =============================================================================================== #
    #                                             MAIN SCRIPT
    # =============================================================================================== #


    for aName in algorithmNames:
        # --------------------------------------------------------------- #
        #                        ALGORITHM PARAMETERS
        # --------------------------------------------------------------- #
        parameter_windowType = ""
        parameter_windowMode = ""
        parameter_windowSize = ""
        parameter_windowSlide = ""
        parameter_treesCount = ""
        parameter_contamination = ""
        parameter_subSampleSize = ""
        parameter_subDimensionSize = ""
        parameter_forgetThreshold = ""
        parameter_depthLimit = ""
        parameter_shingle = ""
        parameter_allowDuplicates = ""
        parameter_maxDistance = ""
        parameter_minNeighborCount = ""
        parameter_trainSize = ""
        parameter_k = ""
        parameter_chains = ""
        params = [parameter_windowType, parameter_windowMode, parameter_windowSize, parameter_windowSlide,
                parameter_treesCount, parameter_contamination, parameter_subSampleSize, parameter_subDimensionSize,
                parameter_forgetThreshold, parameter_depthLimit, parameter_shingle, parameter_allowDuplicates,
                parameter_maxDistance, parameter_minNeighborCount, parameter_trainSize, parameter_k, parameter_chains]

        # --------------------------------------------------------------- #
        #                              DATASETS
        # --------------------------------------------------------------- #
        datasetNames = [csv for csv in os.listdir(dataset_dir) if csv.endswith(".csv")]
        for dName in datasetNames:
            if(flag_dataset is not None and flag_dataset != dName):
                continue
            
            dLength = sum(1 for line in open(dataset_dir+dName)) - 1
            cLength = len((open(dataset_dir+dName).readline().rstrip()).split(","))

            config_filename = configuration_file_name(aName, dName, eName)
            f = open(config_filename, "w")
            write(f, yaml_dataset + yaml_is)
            write(f, yaml_tab + yaml_uri + yaml_is + yaml_str + macrobase_dataset_dir + dName + yaml_str)
            write(f, yaml_tab + yaml_metricColumns + yaml_is)
            df = pd.read_csv(dataset_dir + dName)
            dimensions = [x for x in df.columns if attributeNameFinal in x]
            for d in dimensions:
                write(f, yaml_tab + yaml_tab + yaml_has + yaml_str + d + yaml_str)
            write(f, yaml_tab + yaml_labelColumn + yaml_is + yaml_str + outputNameFinal + yaml_str)
            write(f, yaml_classifiers + yaml_is)
            write(f, yaml_tab + yaml_has + yaml_id + yaml_is + aName)
            write(f, yaml_tab + yaml_space + yaml_parameters + yaml_is)

            set_algorithm_parameters(aName, dLength, cLength)

            write_parameters(f, yaml_windowType, params[0])
            write_parameters(f, yaml_windowMode, params[1])
            write_parameters(f, yaml_windowSize, params[2])
            write_parameters(f, yaml_windowSlide, params[3])
            write_parameters(f, yaml_treesCount, params[4])
            write_parameters(f, yaml_contamination, params[5])
            write_parameters(f, yaml_subSampleSize, params[6])
            write_parameters(f, yaml_subDimensionSize, params[7])
            write_parameters(f, yaml_forgetThreshold, params[8])
            write_parameters(f, yaml_depthLimit, params[9])
            write_parameters(f, yaml_allowDuplicates, params[11])
            write_parameters(f, yaml_maxDistance, params[12])
            write_parameters(f, yaml_minNeighborCount, params[13])
            write_parameters(f, yaml_trainSize, params[14])
            write_parameters(f, yaml_k, params[15])
            write_parameters(f, yaml_chains, params[16])
            f.close()
            print("The configuration file " + config_filename + " has been generated...")
