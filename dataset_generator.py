# =============================================================================================== #
#                                               LIBRARIES
# =============================================================================================== #
import os
import sys
import warnings
import seaborn as sns
from scipy.io import arff
import pandas as pd
import numpy as np
from sklearn.utils import shuffle
from _myLib import common as cm
from scipy.io import loadmat
if not sys.warnoptions:
    warnings.simplefilter("ignore")

# =============================================================================================== #
#                                    ** USER DEFINED VARIABLES **
# =============================================================================================== #
input_data_path = './Dataset/original/'
output_data_path = './Dataset/output/'


input_folders_concept_drift = ["concept_drift/electricity"]

input_folders_gloss = ["subspace_outliers/gloss"]
input_folders_hics = [] #["subspace_outliers/hics"]
input_folders_refout = ["subspace_outliers/breast_diagnostic", "subspace_outliers/breast", "subspace_outliers/electricity_meter"]
input_folders_subspace = input_folders_hics + input_folders_refout + input_folders_gloss

input_folders_class = ["class_outliers/mulcross", "class_outliers/shuttle", "class_outliers/sine", "class_outliers/taxi", "class_outliers/isolet", "class_outliers/gisette", "class_outliers/wilt",
"class_outliers/smtp", "class_outliers/http", "class_outliers/adult", "class_outliers/pima", "class_outliers/magic_telescope", "class_outliers/madelon", "class_outliers/letterRecognition", "class_outliers/breastw",
"class_outliers/annythyroid", "class_outliers/real"]
input_folders = input_folders_subspace + input_folders_class

pre_processing = True
pre_processing_remove_alerted_columns = False
pre_processing_normalize = False
pre_processing_shuffle = False
pre_processing_shuffle_stratified = True
pre_processing_variable_train_stratified = False
pre_processing_variable_test_stratified = False

pre_processing_fixed_outliers = 1.0 # How many (percentage) of outliers you want to keep/discard on the train or test set ?
pre_processing_train_size = 0.5     # How many (percentage) of data points you want to the train set ?


# =============================================================================================== #
#                                  ** EXTRA PARAMETERS HELPFUL **
# =============================================================================================== #
no_pre_processing_fileNames = ['Sine.csv', 'NYCTaxi.csv']


# =============================================================================================== #

# =============================================================================================== #
matDataName = "X"
matLabelName = "y"

ground_truth_outlier = 1
ground_truth_inlier = 0

attributeNameFinal = "d"
attributeNames = ["att", "v", "d"]

outputNameFinal = "is_anomaly"
outputNames = ["outlier", "class", "target", "is_anomaly"]

anomaly_values = ["anomaly", "false", "no"]
normal_values = ["normal", "true", "yes"]


# =============================================================================================== #
#                                           FUNCTIONS
# =============================================================================================== #

def variable_stratified_test_outliers(dfs, trainp, vperc):
    # ===================================================================================================== #
    df_outliers = dfs.loc[dfs[outputNameFinal] == ground_truth_outlier]                                     # original
    df_inliers = dfs.loc[dfs[outputNameFinal] == ground_truth_inlier]                                       # original
    # ===================================================================================================== #
    extra = int(vperc * len(df_outliers))                                                                   # extra
    # ===================================================================================================== #
    split_inliers = int(trainp * len(df_inliers))                                                           # split inliers
    df_train_inliers_final = df_inliers.iloc[:split_inliers, :]                                             # final
    df_test_inliers_variable = df_inliers.iloc[split_inliers:, :]                                           # variable
    # ===================================================================================================== #
    df_test_outliers_final = df_outliers.iloc[:extra, :]                                                    # final (variable)
    # ===================================================================================================== #
    df_test_inliers_final = df_test_inliers_variable.iloc[extra:, :]                                        # final
    # ===================================================================================================== #
    df_train = df_train_inliers_final                                                                       # train data
    if len(df_test_outliers_final) > 0:                                                                     #
        df_test = simple_stratify(df_test_inliers_final, df_test_outliers_final)                            # test data
    else:                                                                                                   #
        df_test = df_test_inliers_final                                                                     #
    # ===================================================================================================== #
    df_final = df_train.append(df_test, ignore_index=True)                                                  # dataset
    return df_final


def variable_stratified_train_outliers(dfs, trainp, vperc):
    # ===================================================================================================== #
    df_outliers = dfs.loc[dfs[outputNameFinal] == ground_truth_outlier]                                     # original
    df_inliers = dfs.loc[dfs[outputNameFinal] == ground_truth_inlier]                                       # original
    # ===================================================================================================== #
    extra = int(vperc * int(trainp * len(df_outliers)))                                                     # update
    extra_max = int(trainp * len(df_outliers))
    # ===================================================================================================== #
    df_inliers_extra = df_inliers.iloc[:extra, :]                                                           # update
    df_inliers_rest = df_inliers.iloc[extra_max:, :]                                                        # rest
    # ===================================================================================================== #
    split_inliers = int(trainp * len(df_inliers_rest))                                                      # split inliers
    df_train_inliers_variable = df_inliers_rest.iloc[:split_inliers, :]                                     # variable
    df_test_inliers_final = df_inliers_rest.iloc[split_inliers:, :]                                         # final
    # ===================================================================================================== #
    split_outliers = int(trainp * len(df_outliers))                                                         # split outliers
    df_train_outliers_variable = df_outliers.iloc[:split_outliers, :]                                       # variable
    df_test_outliers_final = df_outliers.iloc[split_outliers:, :]                                           # final
    # ===================================================================================================== #
    df_train_outliers_final = df_train_outliers_variable.iloc[extra:]                                       # final
    df_train_inliers_final = df_train_inliers_variable.append(df_inliers_extra, ignore_index=True)          # final
    # ===================================================================================================== #
    if len(df_train_outliers_final) > 0:                                                                    #
        df_train = simple_stratify(df_train_inliers_final, df_train_outliers_final)                         # train data
    else:                                                                                                   #
        df_train = df_train_inliers_final                                                                   #
    df_test = simple_stratify(df_test_inliers_final, df_test_outliers_final)                                # test data
    # ===================================================================================================== #
    df_final = df_train.append(df_test, ignore_index=True)                                                  # dataset
    return df_final                                                                                         # return




def simple_stratify(df_inliers, df_outliers):
    original_size = len(df_inliers) + len(df_outliers)
    #print("ALL SIZE DATA = "+str(len(df_so)) + " DATA SIZE = "+str(len(df_outliers)))
    step_outlier = int(original_size / len(df_outliers))
    df_sso = df_inliers.copy()
    index = 0
    print("ORIGINAL DATAFRAME SIZE = "+str(original_size))
    for _, row in df_outliers.iterrows():
        df_sso = insert_row(index*step_outlier, df_sso, row)
        index += 1
        if index % 10 == 0:
            print("\t Stratified process info: " +
                  "ADDED OUTLIERS = " + str(len(df_sso.loc[df_sso[outputNameFinal] == ground_truth_outlier])) + " / " + str(len(df_outliers)) + " " +
                  "PERIOD (POINTS) = " + str(step_outlier))
    critical_position = step_outlier * len(df_outliers)
    last_part = df_sso.iloc[:critical_position]
    first_part = df_sso.iloc[critical_position:]
    df_sso_final = first_part.append(last_part, ignore_index=True)
    print("FINAL DATAFRAME SIZE = " + str(len(df_sso_final)))
    return df_sso_final





def simple_shuffle(df):
    df_inliers = df.loc[df[outputNameFinal] == ground_truth_inlier]
    df_outliers = df.loc[df[outputNameFinal] == ground_truth_outlier]
    split = int(len(df_inliers) / 2)
    df_inliers1 = df_inliers[:split]
    df_inliers2 = df_inliers[split:]
    df_builder = shuffle(df_outliers.append(df_inliers2))
    df_builder.reset_index(inplace=True, drop=True)
    return df_inliers1.append(df_builder)


def shuffle_stratified_outliers(df_so):
    dfs = shuffle(df_so)
    dfs.reset_index(inplace=True, drop=True)
    df_inliers = dfs.loc[dfs[outputNameFinal] == ground_truth_inlier]
    df_outliers = dfs.loc[dfs[outputNameFinal] == ground_truth_outlier]
    #print("ALL SIZE DATA = "+str(len(df_so)) + " DATA SIZE = "+str(len(df_outliers)))
    step_outlier = int(len(df_so) / len(df_outliers))
    df_sso = df_inliers.copy()
    index = 0
    print("ORIGINAL DATAFRAME SIZE = "+str(len(df_so)))
    for _, row in df_outliers.iterrows():
        df_sso = insert_row(index*step_outlier, df_sso, row)
        index += 1
        if index % 10 == 0:
            print("\t Stratified process info: " +
                  "ADDED OUTLIERS = " + str(len(df_sso.loc[df_sso[outputNameFinal] == ground_truth_outlier])) + " / " + str(len(df_outliers)) + " " +
                  "PERIOD (POINTS) = " + str(step_outlier))
    critical_position = step_outlier * len(df_outliers)
    last_part = df_sso.iloc[:critical_position]
    first_part = df_sso.iloc[critical_position:]
    df_sso_final = first_part.append(last_part, ignore_index=True)
    print("FINAL DATAFRAME SIZE = " + str(len(df_sso_final)))
    return df_sso_final


def insert_row(row_number, df_ir, row_value):
    # Starting value of upper half
    start_upper = 0
    # End value of upper half
    end_upper = row_number
    # Start value of lower half
    start_lower = row_number
    # End value of lower half
    end_lower = df_ir.shape[0]
    # Create a list of upper_half index
    upper_half = [*range(start_upper, end_upper, 1)]
    # Create a list of lower_half index
    lower_half = [*range(start_lower, end_lower, 1)]
    # Increment the value of lower half by 1
    lower_half = [x.__add__(1) for x in lower_half]
    # Combine the two lists
    index_ = upper_half + lower_half
    # Update the index of the dataframe
    df_ir.index = index_
    # Insert a row at the end
    df_ir.loc[row_number] = row_value
    # Sort the index labels
    df_ir = df_ir.sort_index()
    # return the dataframe
    return df_ir


def mat_to_df(path):
    mat_df = pd.DataFrame()
    mat = loadmat(path)
    mat_data = mat[matDataName]
    mat_data_transpose = [list(i) for i in zip(*mat_data)]
    mat_labels = mat[matLabelName]
    for i in range(len(mat_data_transpose)):
        mat_df[attributeNames[0]+str(i+1)] = mat_data_transpose[i]
    mat_df[outputNames[0]] = mat_labels
    return mat_df


def fix_target_values(target_column):
    ftv = []
    try:
        ttv = [x.decode('utf-8') for x in target_column]
    except AttributeError:
        ttv = target_column
    for x in ttv:
        xl = str(x).lower().replace("'", "").replace(".", "")
        if xl.isnumeric():
            ftv += [int(float(x))]
        else:
            if xl in anomaly_values:
                ftv += [ground_truth_outlier]
            elif xl in normal_values:
                ftv += [ground_truth_inlier]
            else:
                print(xl+" not found")
    if len(ftv) != len(target_column):
        print("[System Error] error occurred while fixing the target values")
    if ftv.count(ground_truth_outlier) == 0:
        print("[System Warning] No Outliers found in the dataset!")
    return ftv


def is_processable_file(pfile):
    if pfile in no_pre_processing_fileNames:
        return False
    else:
        return True

# =============================================================================================== #
#                                             MAIN SCRIPT
# =============================================================================================== #

for input_folder in input_folders:
    input_data = input_data_path + input_folder + "/"
    files_arff = []
    files_csv = []
    files_mat = []
    try:
        files_arff = [arff for arff in os.listdir(input_data) if arff.endswith(".arff")]
        files_csv = [csv for csv in os.listdir(input_data) if csv.endswith(".csv")]
        files_mat = [csv for csv in os.listdir(input_data) if csv.endswith(".mat")]
    except FileNotFoundError:
        pass
    files = files_arff + files_csv + files_mat
    for file in files:
        print("[0] Reading the dataset "+file+"..")
        input_data_file = input_data + file
        df = pd.DataFrame()
        if '.csv' in file:
            df = (pd.read_csv(input_data_file)).copy()
        elif '.arff' in file:
            data = arff.loadarff(input_data_file)
            df = pd.DataFrame(data[0]).copy()
        elif '.mat' in file:
            df = mat_to_df(input_data_file).copy()
        # CONSTRUCT FEATURE NAMES OF THE DATASET
        alertedColumns = []
        features = []
        cnt = 1
        for col in df.columns:
            if any(attName in col.lower() for attName in attributeNames):
                features = features + [attributeNameFinal + str(cnt)]
                cnt += 1
            elif any(outName in col.lower() for outName in outputNames):
                features = features + [outputNameFinal]
            else:
                features = features + [col]
                alertedColumns = alertedColumns + [col]
        df.columns = features

        # [0.1] REMOVE ALL THE ALERTED COLUMNS (OPTIONAL)
        if pre_processing_remove_alerted_columns:
            print("The alerted columns that allowed are: " + str(alertedColumns))
            df = df.drop(columns=alertedColumns)

        # [0.2] REPLACE ALL THE (EXPECTED) NON-NUMERICAL VALUES
        df[outputNameFinal] = fix_target_values(df[outputNameFinal])
        if pre_processing and is_processable_file(file):
            # [1] NORMALIZE THE FEATURE VALUES OF THE DATASET, PER COLUMN (as proposed in this paper)
            if pre_processing_normalize:
                df = cm.normalize(df)
                print("[1] Normalization process has been completed.")
            # [2.1] SHUFFLE THE DATA POINTS OF THE DATASET (as proposed in this paper)
            if pre_processing_shuffle:
                shuffledDF = simple_shuffle(df)
                print("[2.1] Shuffle process has been completed.")
                shuffledDF.to_csv(output_data_path + file.replace(".csv", "_shuffle.csv").replace(".arff", "_shuffle.csv").replace(".mat", "_shuffle.csv"), index=None, header=True)
            # [2.2] STRATIFIED PERMUTATION OF THE DATA POINTS OF THE DATASET, BY CLASS (as proposed in this paper)
            if pre_processing_shuffle_stratified:
                stratifiedDF = shuffle_stratified_outliers(df)
                print("[2.2] Stratified shuffle process has been completed.")
                stratifiedDF.to_csv(output_data_path + file.replace(".csv", "_shuffleStratified.csv").replace(".arff", "_shuffleStratified.csv").replace(".mat", "_shuffleStratified.csv"), index=None, header=True)

            # [2.3] FIXED OUTLIERS ON TEST SET AND VARIABLE OUTLIERS ON TRAIN SET
            if pre_processing_variable_train_stratified:
                stratifiedFDF = variable_stratified_train_outliers(df, pre_processing_train_size, pre_processing_fixed_outliers)
                print("[2.3] Stratified variable train process has been completed.")
                stratifiedFDF.to_csv(output_data_path + file.replace("_shuffleStratified", "").replace(".csv", "_"+str(pre_processing_fixed_outliers)+"variableTrainStratified.csv").replace(".arff","_"+str(pre_processing_fixed_outliers)+"variableTrainStratified.csv").replace(".mat", "_"+str(pre_processing_fixed_outliers)+"variableTrainStratified.csv"), index=None, header=True)

            # [2.4] FIXED OUTLIERS ON TRAIN SET AND VARIABLE OUTLIERS ON TEST SET
            if pre_processing_variable_test_stratified:
                stratifiedFDF = variable_stratified_test_outliers(df, pre_processing_train_size, pre_processing_fixed_outliers)
                print("[2.4] Stratified variable test process has been completed.")
                stratifiedFDF.to_csv(output_data_path + file.replace("_shuffleStratified", "").replace(".csv", "_" + str(pre_processing_fixed_outliers) + "variableTestStratified.csv").replace(".arff", "_" + str(pre_processing_fixed_outliers) + "variableTestStratified.csv").replace(".mat", "_" + str(pre_processing_fixed_outliers) + "variableTestStratified.csv"), index=None,header=True)

        else:
            df.to_csv(output_data_path + file.replace(".arff", "_original.csv").replace(".mat", "_original.csv"), index=None, header=True)
            print("\tThe file "+file+" has been converted to csv without being pre-processed..")
        print('')
