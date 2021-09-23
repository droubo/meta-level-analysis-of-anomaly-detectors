import os
import math
import warnings
import sys
import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.gridspec as gridspec
from matplotlib import pyplot as plt
from sklearn.neighbors import NearestNeighbors
from sklearn.ensemble import IsolationForest
from sklearn.neighbors import LocalOutlierFactor
#from sklearn.ensemble import OneClassRF
from sklearn.metrics import precision_recall_curve
from sklearn.model_selection import train_test_split
from mpl_toolkits.mplot3d import Axes3D
from sklearn.metrics import roc_curve
from sklearn.metrics import roc_auc_score
from _myLib import common as cm
from _myLib import metrics as mtr
from _myLib import exhaustive_refout_parser as erp
from _myLib import exhaustive_hics_parser as ehp
from _myLib.PIDForest.forest import Forest
from _myLib.Xstream.Chains import Chains
from pyod.models.loda import LODA
from distutils.util import strtobool
import shutil
from sklearn.model_selection import cross_validate
import time

if not sys.warnoptions:
    warnings.simplefilter("ignore")

# =============================================================================================== #
#                                       ** SYSTEM OUTPUT **
# =============================================================================================== #

# PATHS
input_dir_datasets = '../Dataset/output/'
input_dir_macrobase_results = '../Macrobase_Results/'
output_dir_experimental_evaluation = '../Evaluation_Results/'

# EXPERIMENT
experiment_id = "Experiment"
window_experiment_id = "model"

# =============================================================================================== #
#                                  ** USER DEFINED VARIABLES **
# =============================================================================================== #

# Do you want to normalize the scores resulted by the algorithms?
normalize_scores = False
# ANOMALY SCORE DISTRIBUTION OF A DETECTOR OVER ALL DATA POINTS
scores_performance_evaluation_per_data_point = False
# MIN/MAX SCORE OF A DETECTOR
scores_rank_evaluation_per_data_point = False
# ROC PERFORMANCE (PROTOCOL 1 - AT ONCE)
protocol_1_auc_roc = True
# AP PERFORMANCE (PROTOCOL 1 - AT ONCE)
protocol_1_ap = True
# AVERAGE AUC ROC (PROTOCOL 2 - OVER WINDOWS)
protocol_2_auc_roc = False
# MEAN AVERAGE PRECISION (PROTOCOL 2 - OVER WINDOWS)
protocol_2_ap = False
# THE DETECTED OUTLIERS OVER DIFFERENT SUBSPACE DIMENSIONALITY [e.g. HiCS]
subspace_outliers_per_window = False
# NUMBER OF TRUE OUTLIERS PER WINDOW
outlier_ratio_evaluation_per_window = False
# SCORE RANK DISTRIBUTION OF INLIERS AND OUTLIERS
points_score_distribution = False
#PLOT DATASET
plot_dataset = False
#PLOT DATASET OVER WINDOWS
plot_dataset_window = False
# DETECTORS PERFORMANCE RANKING USING (Earth's Mover Distance)
statistical_comparison_per_data = False

# INCLUDE CATEGORICAL ATTRIBUTES
include_categorical = 0

# BASELINE ALGORITHM EVALUATION:
execute_batch_algorithms = True
batch_window_id = 1.0


parameters_filename = "parameters.txt"

if_params = {}
knn_params = {}
lof_params = {}
ocrf_params = {}
pid_params = {}
loda_params = {}
xstream_params = {}

# =============================================================================================== #
#                                    MACROBASE PLATFORM MIRROR
# =============================================================================================== #
label_ground_truth = "is_anomaly"
label_predict_score = "_OUTLIER"
label_window_number = '_WINDOW'
label_tree = "_TREE"
label_features = "_FEATURES"
label_scores = "_SCORES"
label_classification = 'classification'
label_ranking = 'ranking'
label_information = 'information'
label_ratio_outliers = 'outlier_ratio'
label_relevant_features = 'relevant_features'
label_relevant_subspaces = 'relevant_subspaces'
label_tree_importance = 'tree_importance'
label_subspaces = 'subspaces'
label_subspaces2 = 'subspace'
label_data = 'data'
outlier_class_value = 1
inlier_class_value = 0
# =============================================================================================== #
#                                           FUNCTIONS
# =============================================================================================== #


def macrobase_result_file_name(algorithm_id, dataset_id):
    return algorithm_id + "#" + dataset_id.replace(".csv", "") + "#" + experiment_id + ".csv"


def find_algorithm_dataset_names(filePathName):
    fname = filePathName.replace(".csv", "")
    return (fname.split('#'))[0], (fname.split('#'))[1]


def sort_me(list):
    list.sort()
    return list


def is_evaluation_performance_format(filePathName):
    fname = filePathName.replace(".csv", "").split('#')
    if experiment_id in fname[-1]:
        return True
    else:
        return False


def is_window_features_format(filePathName):
    fname = filePathName.replace(".csv", "").split('#')
    if window_experiment_id in fname[-1]:
        return True
    else:
        return False


def is_file_match(aID, dID, file):
    if file.split('#')[0] == aID and file.split('#')[1] == dID:
        return True
    else:
        return False


def is_algorithm_name_matched(filePathName, algorithmName):
    if algorithmName == (filePathName.split("#"))[0]:
        return True
    else:
        return False


def is_dataset_name_matched(filePathName, datasetName):
    if datasetName == (filePathName.split("#"))[1]:
        return True
    else:
        return False


def matched_model_relevant_subspaces(selectedFeatures, relevantSubspaces):
    sf_model = []
    model_rsf = []
    # Model's selected features
    for r in selectedFeatures:
        sf_model += [r.replace(' ', '').split(';')]
    # For each Tree's selected features
    for sf_tree in sf_model:
        cnt_tree_rsf = 0
        # For each Dataset's relevant space
        for rs_data in relevantSubspaces:
            # Calculate the total relevant subspaces found in the selected features of the current tree
            if set(list(set(sf_tree) & set(rs_data))) == set(rs_data):
                cnt_tree_rsf += 1
        model_rsf += [cnt_tree_rsf]
    return model_rsf


def calculate_bar_pos(groupSize, algorithmSize, groupWidth, groupSpace):
    pos = []
    for m in range(groupSize):
        pos += [m + (m * groupSpace)]
    algorithms_pos = [pos]
    for p in range(algorithmSize):
        algorithms_pos.append([x + groupWidth for x in algorithms_pos[p]])
    return algorithms_pos[-1]


def calculate_tag_pos(groupSize, algorithmSize, groupWidth, groupSpace):

    tag_center = (algorithmSize * groupWidth) / 2
    tag_width = algorithmSize * groupWidth
    tag_list = [tag_center]
    for m in range(groupSize):
        tag_list += [tag_list[m] + tag_width + groupSpace]
    return tag_list


def find_outliers(data_labels):
    outliers = []
    for idx in range(len(data_labels)):
        if data_labels[idx] == outlier_class_value:
            outliers += [idx]
    return outliers


def performance_evaluation_files(fpe):
    f_ret = []
    for ff in fpe:
        if is_evaluation_performance_format(ff):
            f_ret += [ff]
    return f_ret




def avg_forest_outliers(forestScores, outlierIndices):
    forest_scores_outliers_avg = []
    f_scores_list = []
    # Forest anomaly scores:
    for r in forestScores:
        f_scores_list += [r.replace(' ', '').split(';')]
    # For each Tree's anomaly score:
    for t_scores in f_scores_list:
        t_scores_outliers = [float(t_scores[idx]) for idx in outlierIndices]
        if len(t_scores_outliers) > 0:


            forest_scores_outliers_avg += [np.average(t_scores_outliers)]
        else:
            forest_scores_outliers_avg += [0]
    return forest_scores_outliers_avg


# ====================================================================== #
#                        DATASET GLOBAL VARIABLES                        #
# ====================================================================== #
dict_data = {}

# ====================================================================== #
#               READ ALL CSV FILES FROM THE DATASET FOLDER               #
# ====================================================================== #

dataset_files = []
try:
    dataset_files = [csv for csv in os.listdir(input_dir_datasets) if csv.endswith(".csv")]
except FileNotFoundError:
    pass
dataset_info_files = []
try:
    dataset_info_files = [info for info in os.listdir(input_dir_datasets) if info.endswith(".info")]
except FileNotFoundError:
    pass

for file in dataset_files:
    fileID = file.replace(".csv", "")
    dict_data[fileID] = {}
    dataset = pd.read_csv(input_dir_datasets + file)
    dataset_labels = dataset[label_ground_truth]
    dataset_ratio_outliers = len(dataset.loc[dataset_labels == outlier_class_value])
    dict_data[fileID][label_data] = dataset
    dataset_relevant_features = []
    dict_data[fileID][label_information] = {}
    for f in dataset_info_files:
        fID = f.replace(".info", "")
        fPath = input_dir_datasets + f
        if fID in fileID:

            print("FID = " + fID + " FILE ID = " + fileID + " FILE PATH = "+fPath)
            data_info_REFOUT = erp.refout_exhaustive_search_parser(fPath, dataset_labels, outlier_class_value)
            data_info_HICS = ehp.hics_exhaustive_search_parser(fPath)
            if len(data_info_REFOUT) > 0:
                dataset_relevant_features = data_info_REFOUT
                print("REFOUT DATASET INFO HAS BEEN FOUND. FID = " + fID + " FILE ID = " + fileID + " FILE PATH = "+fPath)
            elif len(data_info_HICS) > 0:
                dataset_relevant_features = data_info_HICS
                print("HICS DATASET INFO HAS BEEN FOUND. FID = " + fID + " FILE ID = " + fileID + " FILE PATH = "+fPath)
            break
    dict_data[fileID][label_information][label_relevant_features] = dataset_relevant_features
    dict_data[fileID][label_information][label_ratio_outliers] = dataset_ratio_outliers

print("[COMPLETED] READ ALL CSV FILES FROM THE DATASET FOLDER")

# ====================================================================== #
#                        BATCH ALGORITHM EVALUATION                      #
# ====================================================================== #
def read_spam(f):
    for i in range(3):
        f.readline()
def if_read_params(f):
    read_spam(f)
    for i in range(5):
        param = f.readline()
        param = param[:-1]
        tokenized = param.split(" = ")
        if_params[tokenized[0]] = tokenized[1]
def knn_read_params(f):
    read_spam(f)
    for i in range(3):
        param = f.readline()
        param = param[:-1]
        tokenized = param.split(" = ")
        knn_params[tokenized[0]] = tokenized[1]
def lof_read_params(f):
    read_spam(f)
    for i in range(3):
        param = f.readline()
        param = param[:-1]
        tokenized = param.split(" = ")
        lof_params[tokenized[0]] = tokenized[1]
def ocrf_read_params(f):
    read_spam(f)
    for i in range(4):
        param = f.readline()
        param = param[:-1]
        tokenized = param.split(" = ")
        ocrf_params[tokenized[0]] = tokenized[1]
def pid_read_params(f):
    read_spam(f)
    for i in range(8):
        param = f.readline()
        param = param[:-1]
        tokenized = param.split(" = ")
        pid_params[tokenized[0]] = tokenized[1]
def loda_read_params(f):
    read_spam(f)
    for i in range(2):
        param = f.readline()
        param = param[:-1]
        tokenized = param.split(" = ")
        loda_params[tokenized[0]] = tokenized[1]
def xstream_read_params(f):
    read_spam(f)
    for i in range(5):
        param = f.readline()
        param = param[:-1]
        tokenized = param.split(" = ")
        xstream_params[tokenized[0]] = tokenized[1]

def load_parameters():
    f = open(parameters_filename, "r")
    if_read_params(f)
    lof_read_params(f)
    knn_read_params(f)
    ocrf_read_params(f)
    pid_read_params(f)
    loda_read_params(f)
    xstream_read_params(f)

def metrics_score(results_directory):
    auc_final = {}
    ap_final = {}
    frames = {}
    frames_performance_scores = {}
    experiment_algorithms = []
    experiment_datasets = []

    # ====================================================================== #
    #            READ ALL CSV FILES FROM THE MACROBASE RESULTS FOLDER        #
    # ====================================================================== #
    files_all = [csv for csv in os.listdir(results_directory) if csv.endswith(".csv")]
    files_performance_evaluation = performance_evaluation_files(files_all)

    # ====================================================================== #
    #                    PERFORMANCE EVALUATION EXPERIMENTS                  #
    # ====================================================================== #
    for file in files_performance_evaluation:
        # find the current algorithm & dataset name
        algorithm_name, dataset_name = find_algorithm_dataset_names(file)
        # save the current algorithm name
        experiment_algorithms.append(algorithm_name) if algorithm_name not in experiment_algorithms else experiment_algorithms
        # save the current dataset name
        experiment_datasets.append(dataset_name) if dataset_name not in experiment_datasets else experiment_datasets
        # read the current csv file as a data frame
        df = pd.read_csv(results_directory+file)
        # store the data frame (a data frame per csv)
        frames[file] = df

    for key, df in frames.items():
        algorithmID, datasetID = find_algorithm_dataset_names(key)
        frames_performance_scores[key] = {}
        raw_labels = df[label_ground_truth].values
        raw_scores = df[label_predict_score].values
        raw_windows = df[label_window_number].values
        if label_subspaces in df.columns:
            raw_subspaces = df[label_subspaces].values
        else:
            raw_subspaces = []
        raw_model_info = []
        raw_df = df[df.columns.difference([label_predict_score])]
        if normalize_scores:
            final_scores = cm.normalize_scores(raw_scores)
        else:
            final_scores = raw_scores
        frames_performance_scores[key][label_information] = [final_scores, raw_labels, raw_windows, raw_model_info, raw_df, raw_subspaces]
        raw_scores_sorted, raw_labels_sorted = zip(*sorted(zip(final_scores, raw_labels)))
        scores = np.asarray(raw_scores_sorted)
        labels = np.asarray(raw_labels_sorted)

        precision, recall, _ = precision_recall_curve(labels, scores)

        fpr, tpr, _ = roc_curve(labels, scores, pos_label=outlier_class_value)

        roc_auc = roc_auc_score(labels, scores)

        frames_performance_scores[key][label_classification] = [recall, precision, fpr, tpr, roc_auc]

        ap = mtr.average_precision_at_k(labels, scores, k=len(labels))

        frames_performance_scores[key][label_ranking] = [ap]
        # ------------------------------------------- #
    dict_algorithms = {}
    for algorithm_name in experiment_algorithms:
        dict_algorithms[algorithm_name] = {}
        for frameID, frameDICT in frames_performance_scores.items():
            if is_algorithm_name_matched(frameID, algorithm_name):
                _, dataset_name = find_algorithm_dataset_names(frameID)
                dict_algorithms[algorithm_name][dataset_name] = {}
                dict_algorithms[algorithm_name][dataset_name][label_classification] = frameDICT.get(label_classification)
                dict_algorithms[algorithm_name][dataset_name][label_ranking] = frameDICT.get(label_ranking)
                dict_algorithms[algorithm_name][dataset_name][label_information] = frameDICT.get(label_information)
    # ====================================================================== #
    #              [ROC] PERFORMANCE EVALUATION PER DATA POINT               #
    # ====================================================================== #
    if protocol_1_auc_roc:
        roc_evaluation_dir = output_dir_experimental_evaluation + 'roc/'
        if not os.path.exists(roc_evaluation_dir):
            os.makedirs(roc_evaluation_dir)
        # For each Algorithm
        for aID, aDatasets in dict_algorithms.items():
            # For each Dataset
            for dID, metrics in aDatasets.items():
                cMetricList = metrics[label_classification]
                auc_final[aID] = cMetricList[4]
    # ====================================================================== #
    #               [PR] PERFORMANCE EVALUATION PER DATA POINT               #
    # ====================================================================== #
    if protocol_1_ap:
        # For each Algorithm
        for aID, aDatasets in dict_algorithms.items():
            # For each Dataset
            for dID, metrics in aDatasets.items():
                cMetricList = metrics[label_classification]
                rMetricList = metrics[label_ranking]
                ap_final[aID] = rMetricList[0]
        return auc_final, ap_final


if execute_batch_algorithms:
    load_parameters()
    for key, value in dict_data.items():
        print("================= " + key + " ==================")
        df = value[label_data].copy()
        df_data = df.loc[:, ~df.columns.isin([label_ground_truth, label_subspaces, label_subspaces2])]
        from random import seed
        from random import randrange, randint
        #for i in range(100):
            #irrelevant_feat = np.random.normal(randint(0,len(dataset)), randint(0, len(dataset)), len(dataset))
            #irrelevant_feat = np.reshape(irrelevant_feat, (len(irrelevant_feat),1))
            #name = "d" + str(i+1000)
            #df_data[name] = irrelevant_feat
        #print(df_data)
        df_labels = df.loc[:, df.columns == label_ground_truth]
        df_contamination = len(df.loc[df[label_ground_truth] == outlier_class_value]) / len(df_labels)
        X_train, X_test, y_train, y_test = train_test_split(df_data, df_labels, test_size=0.6)
        # ------------------------------------------------ #
        #             ISOLATION FOREST (IFOREST)
        # ------------------------------------------------ #
        if strtobool(if_params["run_if"]):
            trees = if_params["if_trees"]
            trees = trees.split(",")
            if_scores_reps = []
            auc_scores = []
            ap_scores = []
            for n_trees in trees:
                auc_scores_tmp = []
                ap_scores_tmp = []
                for ir in range(3):
                    X_train_val, X_test_val, y_train_val, y_test_val = train_test_split(X_train, y_train, test_size = 0.6)
                    print("IFOREST current round = "+str(ir))
                    if_sub_sample_size_final = float(if_params["if_sub_sample_size"]) if float(if_params["if_sub_sample_size"]) > 1 else int(len(df) *float(if_params["if_sub_sample_size"]))
                    clf = IsolationForest(n_estimators=int(n_trees), max_samples=if_sub_sample_size_final)
                    clf.fit(X_train_val)
                    clf_scores = clf.score_samples(X_test_val) * -1
                    auc_scores_tmp.append(roc_auc_score(y_test_val, clf_scores))
                    ap_scores_tmp.append(mtr.new_average_precision_at_k(y_test_val.to_numpy(), clf_scores, k=len(y_test_val)))
                auc_scores.append(np.mean(auc_scores_tmp))
                ap_scores.append(np.mean(ap_scores_tmp))
                
                # I-FOREST DATAFRAME
                print("IF Evaluated for " + n_trees + " number of trees")
            # PARAMETER TUNING #
            best = ap_scores.index(max(ap_scores))
            auc_scores_final = []
            ap_scores_final = []
            for ir in range(int(if_params["if_run_times"])):
                print("IFOREST current round = "+str(ir))
                if_sub_sample_size_final = float(if_params["if_sub_sample_size"]) if float(if_params["if_sub_sample_size"]) > 1 else int(len(df) *float(if_params["if_sub_sample_size"]))
                clf = IsolationForest(n_estimators=int(trees[best]), max_samples=if_sub_sample_size_final)
                clf.fit(X_train)
                clf_scores = clf.score_samples(X_test) * -1
                auc_scores_final.append(roc_auc_score(y_test, clf_scores))
                ap_scores_final.append(mtr.new_average_precision_at_k(y_test.to_numpy(), clf_scores, k=len(y_test)))
                if_scores_reps += [clf_scores]
            print("==== IF AUC =====")
            print(np.mean(auc_scores_final))
            print(np.std(auc_scores))
            print("==== IF AP =====")
            print(np.mean(ap_scores_final))
            print(np.std(ap_scores))
            
            df_if = X_test.copy()
            df_if["is_anomaly"] = y_test.copy()
            if_scores_reps_sum = [sum(x) for x in zip(*if_scores_reps)]
            if_scores_reps_avg = [x / (int(if_params["if_run_times"])) for x in if_scores_reps_sum]
            df_if[label_predict_score] = if_scores_reps_avg
            df_if[label_window_number] = batch_window_id
                # I-FOREST CSV
            csv_name = macrobase_result_file_name("if"+n_trees, key)
            df_if.to_csv(input_dir_macrobase_results+csv_name, index=None, header=True)
            with open('RESULTS.csv', 'a') as f:
                f.write(key + "," +'IF,'+str(np.mean(auc_scores_final)) + "," + str(np.mean(ap_scores_final)) + "," + str(np.std(auc_scores)) + "," + str(np.std(auc_scores_final))+"\n")

            print("IForest has been evaluated. Best parameter was " + trees[best])
        # ------------------------------------------------ #
        #             LOCAL OUTLIER FACTOR (LOF)
        # ------------------------------------------------ #
        if strtobool(lof_params["run_lof"]):
            neighbors = lof_params["lof_n_neighbors"]
            neighbors = neighbors.split(",")
            auc_scores = []
            ap_scores = []
            X_train_val, X_test_val, y_train_val, y_test_val = train_test_split(X_train, y_train, test_size = 0.6)
            for n_neighbors in neighbors:  
                clf = LocalOutlierFactor(n_neighbors=int(n_neighbors), metric=lof_params["lof_distance_metric"])
                clf.fit_predict(X_train)
                clf_scores = clf.negative_outlier_factor_ * -1
                auc_scores.append(roc_auc_score(y_train, clf_scores))
                ap_scores.append(mtr.new_average_precision_at_k(y_train.to_numpy(), clf_scores, k=len(y_train)))
                print("LOF Evaluated for " + n_neighbors + " number of neighbors")
                # LOF DATAFRAME

            best = ap_scores.index(max(ap_scores))
            clf = LocalOutlierFactor(n_neighbors=int(neighbors[best]), metric=lof_params["lof_distance_metric"])
            clf.fit_predict(df_data)
            clf_scores = clf.negative_outlier_factor_ * -1
            final_auc = roc_auc_score(df_labels, clf_scores)
            final_ap = mtr.new_average_precision_at_k(df_labels.to_numpy(), clf_scores, k=len(df_labels))
            print(final_auc)
            print(final_ap)
            df_lof = df.copy()
            df_lof[label_predict_score] = clf_scores
            df_lof[label_window_number] = batch_window_id
                # LOF CSV
            csv_name = macrobase_result_file_name("lof"+n_neighbors, key)
            df_lof.to_csv(input_dir_macrobase_results+csv_name, index=None, header=True)
            
            with open('RESULTS.csv', 'a') as f:
                f.write(key + "," +'LOF,'+str(final_auc) + "," + str(final_ap) + "," +str(np.std(auc_scores))+ "," + str(np.std(auc_scores_final))+"\n")
            
            print("LOF has been evaluated. Best parameter was " + str(neighbors[best]))
        # ------------------------------------------------ #
        #             K NEAREST NEIGHBORS (KNN)
        # ------------------------------------------------ #
        if strtobool(knn_params["run_knn"]):
            neighbors = knn_params["knn_n_neighbors"]
            neighbors = neighbors.split(",")
            auc_scores = []
            ap_scores = []
            X_train_val, X_test_val, y_train_val, y_test_val = train_test_split(X_train, y_train, test_size = 0.6)
            for n_neighbors in neighbors:
                #X_train_val, X_test_val, y_train_val, y_test_val = train_test_split(X_train, y_train, test_size = 0.6)
                clf = NearestNeighbors(n_neighbors=int(n_neighbors), metric=knn_params["knn_distance_metric"])
                clf.fit(X_train)
                clf_neighbors = (clf.kneighbors(X_train)[0]).tolist()
                clf_neighbors_sorted = [sort_me(point_neighbors) for point_neighbors in clf_neighbors]
                clf_scores = [point_neighbors[-1] for point_neighbors in clf_neighbors_sorted]
                auc_scores.append(roc_auc_score(y_train, clf_scores))
                ap_scores.append(mtr.new_average_precision_at_k(y_train.to_numpy(), clf_scores, k=len(y_train)))
                print("KNN Evaluated for " + n_neighbors + " number of neighbors")

            best = ap_scores.index(max(ap_scores))
            clf = NearestNeighbors(n_neighbors=int(neighbors[best]), metric=knn_params["knn_distance_metric"])
            clf.fit(df_data)
            clf_neighbors = (clf.kneighbors(df_data)[0]).tolist()
            clf_neighbors_sorted = [sort_me(point_neighbors) for point_neighbors in clf_neighbors]
            clf_scores = [point_neighbors[-1] for point_neighbors in clf_neighbors_sorted]
            final_auc = roc_auc_score(df_labels, clf_scores)
            final_ap = mtr.new_average_precision_at_k(df_labels.to_numpy(), clf_scores, k=len(df_labels))
            print(final_auc)
            print(final_ap)
            df_knn = df.copy()
            df_knn[label_predict_score] = clf_scores
            df_knn[label_window_number] = batch_window_id
                # KNN CSV
            csv_name = macrobase_result_file_name("knn"+n_neighbors, key)
            df_knn.to_csv(input_dir_macrobase_results+csv_name, index=None, header=True)
            print("KNN has been evaluated. Best parameter was " + str(neighbors[best]))
            with open('RESULTS.csv', 'a') as f:
                f.write(key + "," +'KNN,'+str(final_auc) + "," + str(final_ap) + "," +str(np.std(auc_scores))+ "," + str(np.std(auc_scores_final))+"\n")

        if(strtobool(xstream_params["run_xstream"])):
            k = xstream_params["k"]
            k = k.split(",")
            chains = xstream_params["nchains"]
            chains = chains.split(",")

            i = 0
            auc_scores = []
            ap_scores = []
            for n_k in k:
                for nchains in chains:
                    xstream_scores_reps = []
                    auc_scores_tmp = []
                    ap_scores_tmp = []
                    for i in range(3):
                        X_train_val, X_test_val, y_train_val, y_test_val = train_test_split(X_train, y_train, test_size = 0.6)
                        print("XSTREAM current round = "+str(i))
                        clf = Chains(k=int(n_k), nchains=int(nchains), depth=math.ceil(math.log(0.4*len(df_data))))
                        clf.fit(X_train_val)
                        clf_scores = -clf.score(X_test_val)
                        auc_scores_tmp.append(roc_auc_score(y_test_val, clf_scores))
                        ap_scores_tmp.append(mtr.new_average_precision_at_k(y_test_val.to_numpy(), clf_scores, k=len(y_test_val)))

                    auc_scores.append(np.mean(auc_scores_tmp))
                    ap_scores.append(np.mean(ap_scores_tmp))
                    print("Xstream Evaluated for " + n_k + " number of k and " + nchains + " number of chains")
            
            best = ap_scores.index(max(ap_scores))
            best_k = int(best/3)
            best_chains = best % 3
            print(best)
            print("Best parameters were k: " + k[best_k] + " and chains: " + chains[best_chains])

            xstream_scores_reps = []
            auc_scores_final = []
            ap_scores_final = []

            
            for i in range(int(xstream_params["xstream_run_times"])):
                print("XSTREAM current round = "+str(i))
                clf = Chains(k=int(k[best_k]), nchains=int(chains[best_chains]), depth=math.ceil(math.log(0.4*len(df_data))))
                clf.fit(X_train)
                clf_scores = -clf.score(X_test)
                auc_scores_final.append(roc_auc_score(y_test, clf_scores))
                ap_scores_final.append(mtr.new_average_precision_at_k(y_test.to_numpy(), clf_scores, k=len(y_test)))
                xstream_scores_reps += [clf_scores]

            print("==== XSTREAM AUC =====")
            print(np.mean(auc_scores_final))
            print(np.std(auc_scores))
            print("==== XSTREAM AP =====")
            print(np.mean(ap_scores_final))
            print(np.std(ap_scores))

            df_xstream = X_test.copy()
            df_xstream["is_anomaly"] = y_test.copy()
            xstream_scores_reps_sum = [sum(x) for x in zip(*xstream_scores_reps)]
            xsteam_scores_reps_avg = [x / (int(xstream_params["xstream_run_times"])) for x in xstream_scores_reps_sum]
            df_xstream[label_predict_score] = xsteam_scores_reps_avg
            df_xstream[label_window_number] = batch_window_id

            csv_name = macrobase_result_file_name("xstream"+n_k+"_"+nchains, key)
            df_xstream.to_csv(input_dir_macrobase_results+csv_name, index=None, header=True)

            with open('RESULTS.csv', 'a') as f:
                f.write(key + "," +'XSTREAM,'+str(np.mean(auc_scores_final)) + "," + str(np.mean(ap_scores_final)) + "," + str(np.std(auc_scores)) + "," + str(np.std(auc_scores_final)) +"\n")

        # ------------------------------------------------ #
        #                       LODA
        # ------------------------------------------------ #


        if strtobool(loda_params["run_loda"]):
            loda_scores_reps = []
            auc_scores = []
            ap_scores = []
            training_time = []
            scoring_time = []
            for i in range(int(loda_params["loda_run_times"])):
                print("LODA current round = "+str(i))
                clf = LODA()
                start = time.time()
                clf.fit(df_data)
                end = time.time()
                training_time.append(end - start)
                start = time.time()
                clf_scores = clf.decision_function(df_data)
                end = time.time()
                scoring_time.append(end - start)
                auc_scores.append(roc_auc_score(df_labels, clf_scores))
                ap_scores.append(mtr.new_average_precision_at_k(df_labels.to_numpy(), clf_scores, k=len(df_labels)))
                loda_scores_reps += [clf_scores]
            # LOF DATAFRAME

            print("==== LODA AUC =====")
            print(np.mean(auc_scores))
            print(np.std(auc_scores))
            print("==== LODA AP =====")
            print(np.mean(ap_scores))
            print(np.std(ap_scores))

            df_lof = df.copy()
            loda_scores_reps_sum = [sum(x) for x in zip(*loda_scores_reps)]
            xsteam_scores_reps_avg = [x / (int(loda_params["loda_run_times"])) for x in loda_scores_reps_sum]
            df_lof[label_predict_score] = clf_scores
            df_lof[label_window_number] = batch_window_id
            # LOF CSV
            csv_name = macrobase_result_file_name("loda", key)
            df_lof.to_csv(input_dir_macrobase_results+csv_name, index=None, header=True)
            print("LODA has been evaluated. More info can be found in "+csv_name+"...")
            
            with open('RESULTS.csv', 'a') as f:
                f.write(key + "," +'LODA,'+str(np.mean(auc_scores)) + "," + str(np.mean(ap_scores)) + ',' + str(np.mean(training_time)) + ',' + str(np.mean(scoring_time))+"\n")

        # ------------------------------------------------ #
        #             ONE CLASS RANDOM FOREST (OCRF)
        # ------------------------------------------------ #
        '''
        if strtobool(ocrf_params["run_ocrf"]):
            trees = ocrf_params["ocrf_trees"]
            trees = trees.split(",")
            ocrf_scores_reps = []
            for n_trees in trees:
                for ir in range(int(ocrf_params["ocrf_run_times"])):
                    print("OCRF current round = "+str(ir))
                    ocrf_sub_sample_size_final = float(ocrf_params["ocrf_sub_sample_size"]) if float(ocrf_params["ocrf_sub_sample_size"]) > 1 else int(len(df) *float(ocrf_params["ocrf_sub_sample_size"]))
                    clf = OneClassRF(n_estimators=int(n_trees), max_samples=ocrf_sub_sample_size_final)
                    clf.fit(X_train_val)
                    clf_scores = clf.predict(X_test_val)
                    auc_scores_tmp.append(roc_auc_score(y_test_val, clf_scores))
                    ap_scores_tmp.append(mtr.new_average_precision_at_k(y_test_val.to_numpy(), clf_scores, k=len(y_test_val)))
                auc_scores.append(np.mean(auc_scores_tmp))
                ap_scores_tmp.append(np.mean(ap_scores_tmp))
                # I-FOREST DATAFRAME
                print("OCRF Evaluated for " + n_trees + " number of trees")
            # PARAMETER TUNING #
            best = auc_scores.index(max(auc_scores))
            auc_scores = []
            ap_scores = []
            for ir in range(int(if_params["if_run_times"])):
                print("OCRF current round = "+str(ir))
                if_sub_sample_size_final = float(ocrf_params["ocrf_sub_sample_size"]) if float(ocrf_params["ocrf_sub_sample_size"]) > 1 else int(len(df) *float(ocrf_params["ocrf_sub_sample_size"]))
                clf = OneClassRF(n_estimators=int(trees[best]), max_samples=if_sub_sample_size_final)
                clf.fit(X_train)
                clf_scores = clf.score_samples(X_test) * -1
                auc_scores.append(roc_auc_score(y_test, clf_scores))
                ap_scores.append(mtr.new_average_precision_at_k(y_test.to_numpy(), clf_scores, k=len(y_test)))
                if_scores_reps += [clf_scores]
            print("==== OCRF AUC =====")
            print(np.mean(auc_scores))
            print(np.std(auc_scores))
            print("==== OCRF AP =====")
            print(np.mean(ap_scores))
            print(np.std(ap_scores))
            
            df_if = X_test.copy()
            df_if["is_anomaly"] = y_test.copy()
            if_scores_reps_sum = [sum(x) for x in zip(*if_scores_reps)]
            if_scores_reps_avg = [x / (int(ocrf_params["ocrf_run_times"])) for x in if_scores_reps_sum]
            df_if[label_predict_score] = if_scores_reps_avg
            df_if[label_window_number] = batch_window_id
                # I-FOREST CSV
            csv_name = macrobase_result_file_name("ocrf"+n_trees, key)
            df_if.to_csv(input_dir_macrobase_results+csv_name, index=None, header=True)

            print("OCRF has been evaluated. Best parameter was " + trees[best])
'''
        # ------------------------------------------------ #
        #             PID FOREST (PID)
        # ------------------------------------------------ #
        if strtobool(pid_params["run_pid"]):
            trees = pid_params["pid_trees"]
            trees = trees.split(",")
            buckets = pid_params["pid_buckets"]
            buckets = buckets.split(",")            
            pid_scores_reps = []
            auc_scores = []
            ap_scores = []
            auc_scores_tmp = []
            ap_scores_tmp = []
            for bucket in buckets:
                for n_trees in trees:
                    for ir in range(3):
                        X_train_val, X_test_val, y_train_val, y_test_val = train_test_split(X_train, y_train, test_size = 0.6)
                        print("PIDForest current round = "+str(ir))
                        pid_sub_sample_size_final = float(pid_params["pid_sub_sample_size"]) if float(pid_params["pid_sub_sample_size"])  > 1 else int(len(X_train_val) * float(pid_params["pid_sub_sample_size"]) )
                        kwargs = {'max_depth': math.ceil(math.log(0.4*len(X_train_val))), 'n_trees':int(n_trees),  'max_samples': pid_sub_sample_size_final, 'max_buckets': int(bucket), 'epsilon': float(pid_params["pid_epsilon"]), 'sample_axis': 1, 
                        'threshold': 0}
                        clf = Forest(**kwargs)
                        clf.fit(np.transpose(X_train_val.to_numpy()))
                        indices, outliers, scores , pst, clf_scores = clf.predict(np.transpose(X_test_val.to_numpy()), err = 0.1, pct=50)
                        #clf_scores = - clf_scores
                        auc_scores_tmp.append(roc_auc_score(y_test_val, clf_scores))
                        ap_scores_tmp.append(mtr.new_average_precision_at_k(y_test_val.to_numpy(), clf_scores, k=len(y_test_val)))
                    auc_scores.append(np.mean(auc_scores_tmp))
                    ap_scores.append(np.mean(ap_scores_tmp))
                    print("PID Evaluated for " + n_trees + " number of trees and " + bucket + " buckets")
            # PARAMETER TUNING #
            best = ap_scores.index(max(ap_scores))
            best_bucket = int(best/3)
            best_trees = int(best % 3)
            auc_scores_final = []
            ap_scores_final = []
            print("Best parameters were buckets: " + str(buckets[best_bucket]) + " and trees: " + str(trees[best_trees]))
            for ir in range(10):
                print("PIDForest current round = "+str(ir))
                pid_sub_sample_size_final = float(pid_params["pid_sub_sample_size"]) if float(pid_params["pid_sub_sample_size"])  > 1 else int(len(df) * float(pid_params["pid_sub_sample_size"]) )
                kwargs = {'max_depth': math.ceil(math.log(0.4*len(X_train))), 'n_trees':int(trees[best_trees]),  'max_samples': pid_sub_sample_size_final, 'max_buckets': int(buckets[best_bucket]), 'epsilon': float(pid_params["pid_epsilon"]), 'sample_axis': 1, 
                'threshold': 0}
                clf = Forest(**kwargs)
                clf.fit(np.transpose(X_train.to_numpy()))
                indices, outliers, scores , pst, clf_scores = clf.predict(np.transpose(X_test.to_numpy()), err = 0.1, pct=50)
                auc_scores_final.append(roc_auc_score(y_test, clf_scores))
                ap_scores_final.append(mtr.new_average_precision_at_k(y_test.to_numpy(), clf_scores, k=len(y_test)))
                #clf_scores = - clf_scores
                pid_scores_reps += [clf_scores]
            # PID-FOREST DATAFRAME
            print("==== PID AUC =====")
            print(np.mean(auc_scores_final))
            print(np.std(auc_scores))
            print("==== PID AP =====")
            print(np.mean(ap_scores_final))
            print(np.std(ap_scores))

            df_pid = X_test.copy()
            df_pid["is_anomaly"] = y_test.copy()
            pid_scores_reps_sum = [sum(x) for x in zip(*pid_scores_reps)]
            pid_scores_reps_avg = [x / (int(pid_params["pid_run_times"])) for x in pid_scores_reps_sum]
            df_pid[label_predict_score] = pid_scores_reps_avg
            df_pid[label_window_number] = batch_window_id

            # PID-FOREST CSV
            csv_name = macrobase_result_file_name("pid", key)
            df_pid.to_csv(input_dir_macrobase_results+csv_name, index=None, header=True)
            print("PIDForest has been evaluated. More info can be found in "+csv_name+"...")
            with open('RESULTS.csv', 'a') as f:
                f.write(key + "," +'PID,'+str(np.mean(auc_scores_final)) + "," + str(np.mean(ap_scores_final)) + "," + str(np.std(auc_scores)) + "," + str(np.std(auc_scores_final))+"\n")

        print('')
print("[COMPLETED] BATCH DETECTION EVALUATION")

# ====================================================================== #
#                        EXPERIMENT GLOBAL VARIABLES                     #
# ====================================================================== #
frames = {}
frames_performance_scores = {}
experiment_algorithms = []
experiment_datasets = []

# ====================================================================== #
#            READ ALL CSV FILES FROM THE MACROBASE RESULTS FOLDER        #
# ====================================================================== #
files_all = [csv for csv in os.listdir(input_dir_macrobase_results) if csv.endswith(".csv")]
files_performance_evaluation = performance_evaluation_files(files_all)

# ====================================================================== #
#                    PERFORMANCE EVALUATION EXPERIMENTS                  #
# ====================================================================== #
for file in files_performance_evaluation:
    # find the current algorithm & dataset name
    algorithm_name, dataset_name = find_algorithm_dataset_names(file)
    # save the current algorithm name
    experiment_algorithms.append(algorithm_name) if algorithm_name not in experiment_algorithms else experiment_algorithms
    # save the current dataset name
    experiment_datasets.append(dataset_name) if dataset_name not in experiment_datasets else experiment_datasets
    # read the current csv file as a data frame
    df = pd.read_csv(input_dir_macrobase_results+file)
    # store the data frame (a data frame per csv)
    frames[file] = df

for key, df in frames.items():
    algorithmID, datasetID = find_algorithm_dataset_names(key)
    frames_performance_scores[key] = {}
    # ------------------------------------------- #
    # 0. INFORMATION
    # ------------------------------------------- #
    # - - - - - - - - - - - - - - - - - - - - - - #
    # 0.1 MODEL RAW LABELS
    # - - - - - - - - - - - - - - - - - - - - - - #
    raw_labels = df[label_ground_truth].values
    # - - - - - - - - - - - - - - - - - - - - - - #
    # 0.2 MODEL RAW SCORES
    # - - - - - - - - - - - - - - - - - - - - - - #
    raw_scores = df[label_predict_score].values
    # - - - - - - - - - - - - - - - - - - - - - - #
    # 0.3 MODEL RAW WINDOWS
    # - - - - - - - - - - - - - - - - - - - - - - #
    raw_windows = df[label_window_number].values
    # - - - - - - - - - - - - - - - - - - - - - - #
    # 0.4 MODEL RAW SUBSPACES
    # - - - - - - - - - - - - - - - - - - - - - - #
    if label_subspaces in df.columns:
        raw_subspaces = df[label_subspaces].values
    else:
        raw_subspaces = []
    # - - - - - - - - - - - - - - - - - - - - - - #
    # 0.3 MODEL RAW INFORMATION
    # - - - - - - - - - - - - - - - - - - - - - - #
    raw_model_info = []
    # - - - - - - - - - - - - - - - - - - - - - - #
    # 0.3 MODEL RAW FEATURE VALUES
    # - - - - - - - - - - - - - - - - - - - - - - #
    raw_df = df[df.columns.difference([label_predict_score])]
    # - - - - - - - - - - - - - - - - - - - - - - #
    # SCORE NORMALIZATION
    # - - - - - - - - - - - - - - - - - - - - - - #
    if normalize_scores:
        final_scores = cm.normalize_scores(raw_scores)
    else:
        final_scores = raw_scores
    # ------------------------------------------- #
    # SAVE
    # ------------------------------------------- #
    frames_performance_scores[key][label_information] = [final_scores, raw_labels, raw_windows, raw_model_info, raw_df, raw_subspaces]
    # ------------------------------------------- #
    #      SCORES PRE-PROCESS BEFORE METRICS      #
    # ------------------------------------------- #
    raw_scores_sorted, raw_labels_sorted = zip(*sorted(zip(final_scores, raw_labels)))
    scores = np.asarray(raw_scores_sorted)
    labels = np.asarray(raw_labels_sorted)
    labels_outlier_ratio = np.ndarray.tolist(labels).count(outlier_class_value)
    # ------------------------------------------- #
    # 1. CLASSIFICATION
    # ------------------------------------------- #
    # - - - - - - - - - - - - - - - - - - - - - - #
    # 1.1 PR CURVE
    # - - - - - - - - - - - - - - - - - - - - - - #
    precision, recall, _ = precision_recall_curve(labels, scores)
    # - - - - - - - - - - - - - - - - - - - - - - #
    # 1.2 AUC ROC CURVE
    # - - - - - - - - - - - - - - - - - - - - - - #
    fpr, tpr, _ = roc_curve(labels, scores, pos_label=outlier_class_value)
    # - - - - - - - - - - - - - - - - - - - - - - #
    # 1.3 AUC ROC SCORE
    # - - - - - - - - - - - - - - - - - - - - - - #
    roc_auc = roc_auc_score(labels, scores)
    # ------------------------------------------- #
    # SAVE
    # ------------------------------------------- #
    print("[COMPLETED] CLASSIFICATION PERFORMANCE EVALUATION ON " + algorithmID + " " + datasetID)
    frames_performance_scores[key][label_classification] = [recall, precision, fpr, tpr, roc_auc]
    # ------------------------------------------- #
    # ------------------------------------------- #
    # 2. RANKING
    # ------------------------------------------- #
    # - - - - - - - - - - - - - - - - - - - - - - #
    # 2.1 AVERAGE PRECISION
    # - - - - - - - - - - - - - - - - - - - - - - #
    ap = mtr.average_precision_at_k(labels, scores, k=len(labels))
    # ------------------------------------------- #
    # SAVE
    # ------------------------------------------- #
    print("[COMPLETED] RANKING PERFORMANCE EVALUATION ON " + algorithmID + " " + datasetID)
    frames_performance_scores[key][label_ranking] = [ap]
    # ------------------------------------------- #

print("[COMPLETED] PERFORMANCE EXPERIMENT EVALUATION")
# ====================================================================== #
#                    JOIN PERFORMANCES PER ALGORITHM                     #
# ====================================================================== #
dict_algorithms = {}
for algorithm_name in experiment_algorithms:
    dict_algorithms[algorithm_name] = {}
    for frameID, frameDICT in frames_performance_scores.items():
        if is_algorithm_name_matched(frameID, algorithm_name):
            _, dataset_name = find_algorithm_dataset_names(frameID)
            dict_algorithms[algorithm_name][dataset_name] = {}
            dict_algorithms[algorithm_name][dataset_name][label_classification] = frameDICT.get(label_classification)
            dict_algorithms[algorithm_name][dataset_name][label_ranking] = frameDICT.get(label_ranking)
            dict_algorithms[algorithm_name][dataset_name][label_information] = frameDICT.get(label_information)
# ---------------------------------------------------------------------- #
#                              EXAMPLE                                   #
# ---------------------------------------------------------------------- #
# {
#   'hst':
#       {
#           'mulcross_config':
#               {
#                   'classification': [...],
#                   'ranking': [...],
#                   'information': [...]
#               },
#           'shuttle_config':
#               {
#                   'classification': [...],
#                   'ranking': [...],
#                   'information': [...]
#               }
#       },
#   'rrcf':
#       {
#           'mulcross_config':
#               {
#                   'classification': [...],
#                   'ranking': [...],
#                   'information': [...]
#               },
#           'shuttle_config':
#               {
#                   'classification': [...],
#                   'ranking': [...],
#                   'information': [...]
#               }
#       },
#   'mcod':
#       {
#       },
#   'iforest':
#       {
#       }
# }
# print(dictAlgorithms)
# ---------------------------------------------------------------------- #
print("[COMPLETED] DICT TYPE 1")

# ====================================================================== #
#                      JOIN PERFORMANCES PER DATASET                     #
# ====================================================================== #
dict_datasets = {}
for dataset_name in experiment_datasets:
    dict_datasets[dataset_name] = {}
    for frameID, frameDICT in frames_performance_scores.items():
        if is_dataset_name_matched(frameID, dataset_name):
            algorithm_name, _ = find_algorithm_dataset_names(frameID)
            dict_datasets[dataset_name][algorithm_name] = {}
            dict_datasets[dataset_name][algorithm_name][label_classification] = frameDICT.get(label_classification)
            dict_datasets[dataset_name][algorithm_name][label_ranking] = frameDICT.get(label_ranking)
            dict_datasets[dataset_name][algorithm_name][label_information] = frameDICT.get(label_information)
# ---------------------------------------------------------------------- #
#                              EXAMPLE                                   #
# ---------------------------------------------------------------------- #
# {
#   'mulcross_config':
#       {
#           'hst':
#               {
#                   'classification': [...],
#                   'ranking': [...],
#                   'information': [...]
#               },
#           'rrcf':
#               {
#                   'classification': [...],
#                   'ranking': [...],
#                   'information': [...]
#               },
#           'mcod':
#               {},
#           'iforest':
#               {}
#       },
#   'shuttle_config':
#       {
#           'hst':
#               {
#                   'classification': [...],
#                   'ranking': [...],
#                   'information': [...]
#               },
#           'rrcf':
#               {
#                   'classification': [...],
#                   'ranking': [...],
#                   'information': [...]
#               },
#           'mcod':
#               {},
#           'iforest':
#               {}
# }
# print(dictDatasets)
# ---------------------------------------------------------------------- #
print("[COMPLETED] DICT TYPE 2")


# ====================================================================== #
#                [ROC] PERFORMANCE EVALUATION PER WINDOW                 #
# ====================================================================== #
if protocol_2_auc_roc:
    # For each Algorithm:
    for aID, aDatasets in dict_algorithms.items():
        # For each Dataset:
        for dID, metrics in aDatasets.items():
            p_scores = metrics[label_information][0]
            p_labels = metrics[label_information][1]
            p_windows = metrics[label_information][2]
            model_info_scores = []
            p_windows_roc_auc = []
            unique_windows = list(set(p_windows))
            print('ALGORITHM = '+aID+' DATASET = '+dID)

            avg_roc = 0
            w_num = len(unique_windows)

            for master_w in unique_windows:
                master_w_indexes = [index for index, w in enumerate(p_windows) if w == master_w]
                master_w_scores = [p_scores[idx] for idx in master_w_indexes]
                master_w_labels = [p_labels[idx] for idx in master_w_indexes]
                master_w_roc_auc = roc_auc_score(master_w_labels, master_w_scores) if master_w_labels.count(outlier_class_value) > 0 else 0
                avg_roc += master_w_roc_auc
                p_windows_roc_auc += [master_w_roc_auc]

            avg_roc = avg_roc / w_num
            print('Windows '+str(w_num) +' AVG ROC curve (area = %0.3f)' % avg_roc)
            print("------------")

            # the learning process of detector
            learning_gap = ((p_windows_roc_auc[-1] - p_windows_roc_auc[0]) / max(p_windows_roc_auc)) * 100

            if len(unique_windows) > 1:
                # plot the AP per window.
                plt.plot(unique_windows, p_windows_roc_auc, 'o-', )
                # plot the boundary of the first window AUC ROC
                plt.axhline(y=p_windows_roc_auc[0], color='r', linestyle='--', lw=1, label='W'+str(int(unique_windows[0]))+' AUC ROC', alpha=0.8)
                # plot the boundary of the last window AUC ROC
                plt.axhline(y=p_windows_roc_auc[-1], color='g', linestyle='--', lw=1, label='W'+str(int(unique_windows[-1]))+' AUC ROC', alpha=0.8)

                # plot settings
                plt.title(cm.beautifySTR(aID) + ' - ' + cm.beautifyDataset(dID) + ' {Learning GAP = ' + str(round(learning_gap, 2)) + '%}')
                plt.grid('on', linestyle='--', alpha=0.3)
                plt.legend(loc='best')
                plt.xlabel("Window")
                plt.ylabel("AUC ROC")
                #plt.show()

# ====================================================================== #
#        OUTLIERS FOUND PER WINDOW, GROUP BY SUBSPACE DIMENSIONALITY     #
# ====================================================================== #
if subspace_outliers_per_window:
    # For each Algorithm:
    for aID, aDatasets in dict_algorithms.items():
        # For each Dataset:
        for dID, metrics in aDatasets.items():
            p_scores = metrics[label_information][0]
            p_labels = metrics[label_information][1]
            p_windows = metrics[label_information][2]
            p_subspaces = metrics[label_information][5]
            print('ALGORITHM = ' + aID + ' DATASET = ' + dID)
            unique_windows = list(set(p_windows))
            unique_subspaces = list(set(p_subspaces))
            b = dict([(key, []) for key in unique_subspaces])
            b_freq = dict([(key, []) for key in unique_subspaces])
            # FOR EACH WINDOW
            for master_w in unique_windows:
                master_w_indexes = [index for index, w in enumerate(p_windows) if w == master_w]
                master_w_scores = [p_scores[idx] for idx in master_w_indexes]
                master_w_labels = [p_labels[idx] for idx in master_w_indexes]
                master_w_subspaces = [p_subspaces[idx] for idx in master_w_indexes]
                master_w_subspaces_unique = list(set(master_w_subspaces))
                #number_of_outliers_in_window = master_w_labels.count(outlier_class_value)
                master_w_num_outliers = int(len(master_w_scores)*0.25) # Threshold of an outlier to assumed detected (in top 25% of the window size)
                # ----------------------------------------------------------------------------- #
                a = dict([(key, []) for key in master_w_subspaces_unique])
                a_freq = dict([(key, []) for key in master_w_subspaces_unique])
                # ----------------------------------------------------------------------------- #
                # COMPUTE THE FREQUENCY OF EACH DIFFERENT CONTAMINATED SUBSPACE
                for i in range(len(master_w_subspaces_unique)):
                    a_freq[master_w_subspaces_unique[i]] = master_w_subspaces.count(master_w_subspaces_unique[i])
                # ----------------------------------------------------------------------------- #
                # FOR EACH DESCENDING ORDER BY SCORE SORTED DATA POINT:
                cnt = 0
                for x in np.argsort(master_w_scores)[::-1]:
                    if cnt >= master_w_num_outliers:
                        break
                    a[master_w_subspaces[x]].append(1)
                    cnt += 1
                # ----------------------------------------------------------------------------- #
                # PERCENTAGE OF DATA POINTS PER SUBSPACE CONTAMINATION (0 MEANS NO CONTAMINATED)
                print("Window {"+str(master_w)+"} In the first " + str(master_w_num_outliers) + " (total outliers in window) positions: ")
                for su in master_w_subspaces_unique:
                    b[su].append(len(a[su]))
                    b_freq[su].append(a_freq[su])
                    print("--> SUBSPACE ID [" + str(su) + "]" + " FOUND " + str(len(a[su])) + " OUT OF " + str(a_freq[su]) + " ")
            print(" --------------------------------------------------------- ")
            for su in unique_subspaces:
                print("--> SUBSPACE ID [" + str(su) + "]" + " IN TOTAL, FOUND " + str(sum(b.get(su))) + " OUT OF " + str(sum(b_freq.get(su))) + " ")

# ====================================================================== #
#                [AP] PERFORMANCE EVALUATION PER WINDOW                  #
# ====================================================================== #
if protocol_2_ap:
    # For each Algorithm:
    for aID, aDatasets in dict_algorithms.items():
        # For each Dataset:
        for dID, metrics in aDatasets.items():
            p_scores = metrics[label_information][0]
            p_labels = metrics[label_information][1]
            p_windows = metrics[label_information][2]
            model_info_scores = []
            unique_windows = list(set(p_windows))
            print('ALGORITHM = '+aID+' DATASET = '+dID)
            avg_ap = 0
            w_num = len(unique_windows)
            p_windows_ap = []
            for master_w in unique_windows:
                master_w_indexes = [index for index, w in enumerate(p_windows) if w == master_w]
                master_w_scores = [p_scores[idx] for idx in master_w_indexes]
                master_w_labels = [p_labels[idx] for idx in master_w_indexes]
                master_w_ap = mtr.average_precision_at_k(np.asarray(master_w_labels), master_w_scores, k=len(master_w_labels))
                avg_ap += master_w_ap
                p_windows_ap += [master_w_ap]
            avg_ap = avg_ap / w_num
            print('Windows '+str(w_num) +' | Mean AP = %0.3f' % avg_ap)
            print("The maximum average precision (of any window) = " + str(round(max(p_windows_ap),3)))
            print("------------")
            # the learning process of detector
            learning_gap = ((p_windows_ap[-1] - p_windows_ap[0]) / max(p_windows_ap)) * 100
            if len(unique_windows) > 1:
                # plot the AP per window.
                plt.plot(unique_windows, p_windows_ap, 'o-', )
                # plot the boundary of the first window AP
                plt.axhline(y=p_windows_ap[0], color='r', linestyle='--', lw=1, label='W'+str(int(unique_windows[0]))+' AP', alpha=0.8)
                # plot the boundary of the last window AP
                plt.axhline(y=p_windows_ap[-1], color='g', linestyle='--', lw=1, label='W'+str(int(unique_windows[-1]))+' AP', alpha=0.8)
                # plot settings
                plt.title(cm.beautifySTR(aID) + ' - ' + cm.beautifyDataset(dID) + ' {Learning GAP = ' + str(round(learning_gap, 2)) + '%}')
                plt.grid('on', linestyle='--', alpha=0.3)
                plt.legend(loc='best')
                plt.xlabel("Window")
                plt.ylabel("Average Precision")
                #plt.show()


# ====================================================================== #
#              [ROC] PERFORMANCE EVALUATION PER DATA POINT               #
# ====================================================================== #
if protocol_1_auc_roc:
    roc_evaluation_dir = output_dir_experimental_evaluation + 'roc/'
    if not os.path.exists(roc_evaluation_dir):
        os.makedirs(roc_evaluation_dir)
    # For each Algorithm
    for aID, aDatasets in dict_algorithms.items():
        # For each Dataset
        for dID, metrics in aDatasets.items():
            #print("THE ALGORITHM ID = " + str(aID) + "the dataset id = " + str(dID))
            cMetricList = metrics[label_classification]
            plt.figure()
            plt.rcParams.update({'font.size': 8})
            lw = 1
            plt.plot(cMetricList[2], cMetricList[3], color='darkorange', lw=lw, label='ROC curve (area = %0.3f)' % cMetricList[4])
            plt.plot([0, 1], [0, 1], color='grey', lw=lw, linestyle='--')
            plt.fill_between(cMetricList[2], cMetricList[3], alpha=0.2, color='grey')
            plt.xlabel('False Positive Rate')
            plt.ylabel('True Positive Rate')
            plt.title('[ROC Curve] ' + cm.beautifySTR(aID) + ' / ' + cm.beautifySTR(dID))
            plt.grid('on', linestyle='--', alpha=0.3)
            plt.legend(loc='best')
            performance_evaluation_png = aID + '_' + dID + '_roc_performance_evaluation.png'
            plt.savefig(roc_evaluation_dir + performance_evaluation_png, bbox_inches='tight', dpi=300)
            #print("Performance Evaluation of " + aID + " saved as " + performance_evaluation_png + ", please open it..")
            print("DATASET = " + str(dID) + " ALGORITHM = " + str(aID) + " AUC = " + str(cMetricList[4]))
        print("--------------------------------------------------------------")
    print('')


# ====================================================================== #
#               [PR] PERFORMANCE EVALUATION PER DATA POINT               #
# ====================================================================== #
if protocol_1_ap:
    pr_evaluation_dir = output_dir_experimental_evaluation + 'pr/'
    if not os.path.exists(pr_evaluation_dir):
        os.makedirs(pr_evaluation_dir)
    # For each Algorithm
    for aID, aDatasets in dict_algorithms.items():
        # For each Dataset
        for dID, metrics in aDatasets.items():
            cMetricList = metrics[label_classification]
            rMetricList = metrics[label_ranking]
            plt.figure()
            plt.rcParams.update({'font.size': 8})
            lw = 1
            plt.plot(cMetricList[0], cMetricList[1], color='darkorange', lw=lw, label='AP = % 0.3f' % rMetricList[0])
            plt.fill_between(cMetricList[0], cMetricList[1], alpha=0.2, color='grey')
            plt.xlabel('Recall')
            plt.ylabel('Precision')
            plt.title('[PR Curve] ' + cm.beautifySTR(aID) + ' / ' + cm.beautifySTR(dID))
            plt.grid('on', linestyle='--', alpha=0.3)
            plt.legend(loc='best')
            performance_evaluation_png = aID + '_' + dID + '_pr_performance_evaluation.png'
            plt.savefig(pr_evaluation_dir + performance_evaluation_png, bbox_inches='tight', dpi=300)
            #print("Performance Evaluation of " + aID + " saved as " + performance_evaluation_png + ", please open it..")
            print("DATASET = " + str(dID) + " ALGORITHM = " + str(aID) + " AP = " + str(rMetricList[0]))
        print("--------------------------------------------------------------")
    print('')

# ====================================================================== #
#                 [SCORES] INLIERS AND OUTLIERS DISTRIBUTIONS            #
# ====================================================================== #
if points_score_distribution:
    # For each Algorithm
    for aID, aDatasets in dict_algorithms.items():
        print(aID)
        # For each Dataset
        for dID, metrics in aDatasets.items():
            active = True
            # if plots are activated:
            if active:
                pe_scores = metrics[label_information][0]
                pe_labels = metrics[label_information][1]
                pe_windows = metrics[label_information][2]
                outliers = [pe_scores[index] for index, item in enumerate(pe_labels) if item == outlier_class_value]
                outliers.sort(reverse=True)
                inliers_all = [pe_scores[index] for index, item in enumerate(pe_labels) if item == inlier_class_value]
                inliers_all.sort(reverse=True)
                inliers = inliers_all[:len(outliers)]
                pe_points = range(len(outliers))

                plt.figure()
                plt.plot(pe_points, outliers, color='red', marker='o', lw=1, label='Outliers', markersize=5)
                plt.plot(pe_points, inliers, color='blue', marker='o', lw=1, label='Inliers', markersize=5)
                plt.grid('on', linestyle='--', alpha=0.3)
                plt.xlabel('Data point')
                plt.ylabel('Anomaly Score')
                plt.title('The top ' + str(len(outliers)) + ' outlier and inlier scores of ' + cm.beautifySTR(aID) + ' on ' + cm.beautifyDataset(dID))
                plt.legend(loc='best')
                plt.tight_layout()
                plt.show()
                print("OVER ALL = "+str(len(pe_scores)) + "points | outliers = " + str(len(outliers)) + " inliers = "+str(len(inliers)))



"""
rrcf
hst
hstf
knn
iforest
lof
mcod

Breast_Diagnostic_KNN_005_shuffleStratified
Breast_Diagnostic_LOF_005_shuffleStratified
HiCS100_shuffleStratified
HiCS14_shuffleStratified
HiCS23_shuffleStratified
HiCS39_shuffleStratified
HiCS70_shuffleStratified
Mulcross_shuffleStratified
Shuttle_shuffleStratified

"""


# ====================================================================== #
#              [SCORES] RANK TRUE OUTLIERS PER POINT                     #
# ====================================================================== #
if scores_rank_evaluation_per_data_point:
    scores_evaluation_dir = output_dir_experimental_evaluation + 'scores/'
    if not os.path.exists(scores_evaluation_dir):
        os.makedirs(scores_evaluation_dir)
    # For each Algorithm
    for aID, aDatasets in dict_algorithms.items():
        # For each Dataset
        for dID, metrics in aDatasets.items():
            pe_scores = metrics[label_information][0]
            pe_labels = metrics[label_information][1]
            pe_windows = metrics[label_information][2]
            pe_points = range(len(pe_labels))
            pe_points_outliers = find_outliers(pe_labels)
            list1, list2 = (list(t) for t in zip(*sorted(zip(pe_scores, pe_labels), reverse=True)))
            print("DATASET = " + dID + " ALGORITHM = " + aID)
            print(" FIRST POINT SCORE = "+ str(list1[0]) + " MAXIMUM SCORE = " + str(max(list1)) + "FIRST POINT LABEL = "+str(list2[0]))


# ====================================================================== #
#  PLOT [PER WINDOW] THE DATA POINTS OF SUBSPACE CONTAMINATED DATASETS   #
# ====================================================================== #
if plot_dataset_window:
    for aID, aDatasets in dict_algorithms.items():
        print("ALGORITHM ID = "+aID)
        for dID, metrics in aDatasets.items():
            print("DATASET ID = " + dID)
            da_df = metrics[label_information][4]
            pe_windows = metrics[label_information][2].tolist()

            if dID == "HiCS100PD_shuffleStratified":

                for wID in set(pe_windows):
                    print("WINDOW ID = " + str(wID))

                    df = da_df.loc[da_df[label_window_number] == wID]

                    # ============================================================================================== #
                    #BD KNN 010 2D RELEVANT SUBSPACES : [d11, d13]

                    #BD LOF 010 2D RELEVANT SUBPSACES : [d19, d30]

                    #breast knn 010: [1, 16]
                    #breast lof 010: [16, 20]

                    #em knn [5, 19]
                    #em lof [1, 21]

                    #HiCS14 2D RELEVANT SUBPSACES : [d1, d2]
                    #HiCS14 3D RELEVANT SUBSPACES : [d12, d13, d14]

                    #HiCS23 2D RELEVANT SUBPSACES : [d12, d13]
                    #HiCS23 3D RELEVANT SUBSPACES : [d17, d18, d19]

                    #HiCS39 2D RELEVANT SUBPSACES : [d31, d32]
                    #HiCS39 3D RELEVANT SUBSPACES : [d33, d34, d35]

                    #HiCS70 2D RELEVANT SUBPSACES : [d36, d37]
                    #HiCS70 3D RELEVANT SUBSPACES : [d19, d20, d21]

                    #HiCS100 2D RELEVANT SUBPSACES : [d45, d46]
                    #HiCS100 3D RELEVANT SUBSPACES : [d98, d99, d100]
                    # ============================================================================================== #
                    plot_type = '2D'
                    x_feature = 'd36'
                    y_feature = 'd37'
                    z_feature = 'd14'

                    inliers = df.loc[df[label_ground_truth] == inlier_class_value]
                    outliers = df.loc[df[label_ground_truth] == outlier_class_value]

                    if plot_type == '3D':
                        fig = plt.figure()
                        ax = fig.add_subplot(111, projection='3d')
                        ax.scatter(inliers[x_feature].values, inliers[y_feature].values, inliers[z_feature].values, c='k', marker='o')
                        ax.scatter(outliers[x_feature].values, outliers[y_feature].values, outliers[z_feature].values, c='r', marker='x')
                        ax.set_xlabel(x_feature)
                        ax.set_ylabel(y_feature)
                        ax.set_zlabel(z_feature)
                    if plot_type == '2D':
                        plt.plot(inliers[x_feature].values, inliers[y_feature].values, c='k', marker='o', linestyle='None')
                        plt.plot(outliers[x_feature].values, outliers[y_feature].values, c='r', marker='x', linestyle='None')
                        plt.xlabel(x_feature)
                        plt.ylabel(y_feature)
                    plt.title(cm.beautifySTR(aID) + ' - ' + cm.beautifyDataset(dID) + ' - W' + str(int(wID)))
                    #plt.title(cm.beautifyDataset(dID))

                    if wID == min(set(pe_windows)) or wID == min(set(pe_windows))+1 or wID == max(set(pe_windows)) or wID == 4 or wID == 5:
                        plt.show()



# ====================================================================== #
#           PLOT THE DATA POINTS OF SUBSPACE CONTAMINATED DATASETS       #
# ====================================================================== #
import random
if plot_dataset:
    for i in range (0, 1):
        for key, value in dict_data.items():

            #print(key)
            df = value[label_data].copy()
            inliers = df.loc[df[label_ground_truth] == inlier_class_value]
            outliers = df.loc[df[label_ground_truth] == outlier_class_value]
            o_ratio = round(len(outliers) / len(df) * 100, 3)
            c_avg_vr = 0

            # Bins
            bin1 = []
            bin1_outliers = []
            bin2 = []
            bin2_outliers = []
            bin3 = []
            bin3_outliers = []
            bin4 = []
            bin4_outliers = []

            # For each feature column
            for c in df.columns:
                c_col = df[c].values                # feature column values
                c_col_min = min(c_col)              # minimum feature value
                c_col_max = max(c_col)              # maximum feature value
                c_col_vr = c_col_max - c_col_min    # value range

                if c == label_ground_truth:
                    continue

                # 0. Compute the Sum Value Range for all feature columns
                c_avg_vr += c_col_vr

                # A. Find the true outliers that have the maximum feature value of the current feature column
                c_col_max_outliers = [index for index, value in enumerate(c_col) if value == c_col_max and df[label_ground_truth][index] == 1]

                # B. Find the bin that the current feature column fells to, according to its value range
                if c_col_vr >= 0 and c_col_vr < 0.5:         # BIN1 [0, 10)
                    bin1 += [c]
                    if len(c_col_max_outliers) > 0:
                        bin1_outliers += c_col_max_outliers
                elif c_col_vr >= 0.5 and c_col_vr < 1:     # BIN2 [10, 100)
                    bin2 += [c]
                    if len(c_col_max_outliers) > 0:
                        bin2_outliers += c_col_max_outliers
                elif c_col_vr >= 1 and c_col_vr < 1.5:   # BIN3 [100, 1000)
                    bin3 += [c]
                    if len(c_col_max_outliers) > 0:
                        bin3_outliers += c_col_max_outliers
                elif c_col_vr >= 1.5:                      # BIN4 [1000, ~)
                    bin4 += [c]
                    if len(c_col_max_outliers) > 0:
                        bin4_outliers += c_col_max_outliers
                else:
                    exit(-1)

            # Compute the Average Value Range for all feature columns
            c_avg_vr = c_avg_vr / (len(df.columns) - 1)

            # Find the unique true outliers (because a true outlier can be described by more than one feature columns) that fell into a bin and devide them with the total number of true outliers.
            bin1_outliers_ratio = round((len(list(set(bin1_outliers))) / len(outliers)) * 100, 2)
            bin2_outliers_ratio = round((len(list(set(bin2_outliers))) / len(outliers)) * 100, 2)
            bin3_outliers_ratio = round((len(list(set(bin3_outliers))) / len(outliers)) * 100, 2)
            bin4_outliers_ratio = round((len(list(set(bin4_outliers))) / len(outliers)) * 100, 2)

            #if key == "electricity_original":
                #search_dimension = "d1"
                #if search_dimension in bin1:
                #    print("FOUND in Bin 1")
                #elif search_dimension in bin2:
                #    print("FOUND in Bin 2")
                #elif search_dimension in bin3:
                #    print("FOUND in Bin 3")
                #elif search_dimension in bin4:
                #    print("FOUND in Bin 4")

            print("DATASET = " + key)
            print(" Average Value Range = "+str(round(c_avg_vr, 3)))
            print(" BIN1 = " + str(len(bin1)) + " BIN2 = " + str(len(bin2)) + " BIN3 = " + str(len(bin3)) + " BIN4 = " + str(len(bin4)))
            print(" BIN1_outliers = " + str(bin1_outliers_ratio) + " BIN2_outliers = " + str(bin2_outliers_ratio) + " BIN3_outliers = " + str(bin3_outliers_ratio) + " BIN4_outliers = " + str(bin4_outliers_ratio))
            print("- - - - - - - - - - - - - -")

            if key == "HiCS100_shuffleStratified":

                plot_type = '3D'

                # RANDOM SELECTION OF DIMENSIONS
                #x_feature = 'd'+str(random.randint(1, len(df.columns)-1))
                #y_feature = 'd'+str(random.randint(1, len(df.columns)-1))
                #z_feature = 'd'+str(random.randint(1, len(df.columns)-1))

                # USER-DEFINED DIMENSIONS
                x_feature = 'd19'
                y_feature = 'd20'
                z_feature = 'd21'

                #BD KNN 005 2D RELEVANT SUBSPACES : [d16, d17], [d10, d12], [d20, d23]
                #BD KNN 005 3D RELEVANT SUBSPACES : [d16, d17, d19], [d10, d12, d13] [d13, d20, d23]

                #BD LOF 005 2D RELEVANT SUBPSACES : [d18, d29], [d16, d28], [d10, d13]
                #BD LOF 005 3D RELEVANT SUBSPACES : [d3, d16, d23], [d10, d12, d17], [d10, d13, d28]

                #HiCS14 2D RELEVANT SUBPSACES : [d1, d2]
                #HiCS14 005 3D RELEVANT SUBSPACES : [d12, d13, d14]

                #HiCS23 2D RELEVANT SUBPSACES : [d12, d13]
                #HiCS23 005 3D RELEVANT SUBSPACES : [d17, d18, d19]

                #HiCS39 2D RELEVANT SUBPSACES : [d31, d32]
                #HiCS39 005 3D RELEVANT SUBSPACES : [d33, d34, d35]

                #HiCS70 2D RELEVANT SUBPSACES : [d36, d37]
                #HiCS70 005 3D RELEVANT SUBSPACES : [d19, d20, d21]

                #HiCS100 2D RELEVANT SUBPSACES : [d45, d46]
                #HiCS100 005 3D RELEVANT SUBSPACES : [d98, d99, d100]

                if plot_type == '3D':
                    print("Selected Dimensions: X = "+ x_feature +" Y = "+ y_feature +" Z = "+ z_feature)
                    fig = plt.figure()
                    ax = fig.add_subplot(111, projection='3d')
                    ax.scatter(inliers[x_feature].values, inliers[y_feature].values, inliers[z_feature].values, c='k', marker='o')
                    ax.scatter(outliers[x_feature].values, outliers[y_feature].values, outliers[z_feature].values, c='r', marker='x')
                    ax.set_xlabel(x_feature)
                    ax.set_ylabel(y_feature)
                    ax.set_zlabel(z_feature)

                if plot_type == '2D':
                    print("Selected Dimensions: X = " + x_feature +" Y = " +y_feature)
                    plt.plot(inliers[x_feature].values, inliers[y_feature].values, c='k', marker='o', linestyle='None')
                    plt.plot(outliers[x_feature].values, outliers[y_feature].values, c='r', marker='x', linestyle='None')
                    plt.xlabel(x_feature)
                    plt.ylabel(y_feature)
                plt.title(cm.beautifyDataset(key))
                plt.show()











# ====================================================================== #
#              [SCORES] PERFORMANCE EVALUATION PER DATA POINT            #
# ====================================================================== #
if scores_performance_evaluation_per_data_point:
    plt_space_axis = 0.1
    plt_y_axis_level = -0.05
    lw = 2
    scores_evaluation_dir = output_dir_experimental_evaluation + 'scores/'
    if not os.path.exists(scores_evaluation_dir):
        os.makedirs(scores_evaluation_dir)
    # For each Algorithm
    for aID, aDatasets in dict_algorithms.items():
        # For each Dataset
        for dID, metrics in aDatasets.items():
            pe_scores = metrics[label_information][0]
            pe_labels = metrics[label_information][1]
            pe_windows = metrics[label_information][2]
            pe_points = range(len(pe_labels))
            pe_points_outliers = find_outliers(pe_labels)
            """
            plt.figure()
            plt.rcParams.update({'font.size': 6})
            #plt.scatter(pe_points, np.zeros(len(pe_points)), s=lw, c=pe_windows, alpha=0.8, label='Windows')
            #pe_labels_outliers = [outlier_class_value * max(pe_scores)] * len(pe_points_outliers)
            #_, stemlines, _ = plt.stem(pe_points_outliers, pe_labels_outliers, linefmt='y:', basefmt=" ", markerfmt=" ", bottom=plt_y_axis_level, label='Anomalies')
            #plt.setp(stemlines, 'linewidth', 0.7)
            plt.plot(pe_points, pe_scores, color='C1', lw=lw, label='Anomaly Scores')

            if len(dict_data[dID][label_data].columns) <= 2:
                univariateDF = dict_data[dID][label_data]
                stream_data = univariateDF[univariateDF.columns[0]].tail(len(pe_points))
                plt.plot(pe_points, stream_data, color='C0', lw=lw, label='Stream')

            #plt.ylim(-plt_space_axis, max(pe_scores) + plt_space_axis)
            plt.xlabel('Data Points')
            plt.ylabel('Estimations')
            plt.title('[SCORES] ' + cm.beautifySTR(aID) + ' / ' + cm.beautifySTR(dID))
            plt.grid('on', linestyle='--', alpha=0.3)
            plt.legend(loc='best')
            plt.tight_layout()
            """
            fig = plt.figure()
            plt.rcParams.update({'font.size': 9})
            ax1 = plt.subplot(2, 1, 1)
            if len(dict_data[dID][label_data].columns) <= 2:
                univariateDF = dict_data[dID][label_data]
                stream_data = univariateDF[univariateDF.columns[0]].tail(len(pe_points))
                pe_labels_outliers = [outlier_class_value * max(stream_data)] * len(pe_points_outliers)
                plt.scatter(pe_points, np.zeros(len(pe_points)), s=1, c=pe_windows, alpha=0.4, label='Windows')
                plt.stem(pe_points_outliers, pe_labels_outliers, linefmt='tab:orange', basefmt=" ", markerfmt=" ", bottom=plt_y_axis_level, label='Anomalies')
                plt.plot(pe_points, stream_data, color='C0', lw=lw, label='Stream')
            else:
                pe_labels_outliers = [outlier_class_value * max(pe_scores)] * len(pe_points_outliers)
                plt.scatter(pe_points, np.zeros(len(pe_points)), s=1, c=pe_windows, alpha=0.4, label='Windows')

                plt.stem(pe_points_outliers, pe_labels_outliers, linefmt='tab:orange', basefmt=" ", markerfmt=" ", bottom=plt_y_axis_level, label='Anomalies')
            plt.ylabel('True Outliers')
            ax2 = plt.subplot(2, 1, 2)
            plt.rcParams.update({'font.size': 9})
            plt.plot(pe_points, pe_scores, color='C3', lw=lw, label='Anomaly Scores')
            plt.ylabel('Anomaly Scores')
            plt.xlabel('Stream (Data Points)')
            ax1.set_xlim([(0-2), (len(pe_points)+2)])
            ax2.set_xlim([(0-2), (len(pe_points)+2)])
            #fig.suptitle('[Anomaly Detection] ' + cm.beautifySTR(aID) + ' / ' + cm.beautifySTR(dID))
            performance_evaluation_png = aID + '_' + dID + '_scores_performance_evaluation.png'
            plt.savefig(scores_evaluation_dir + performance_evaluation_png, bbox_inches='tight', dpi=300)
            #plt.show()
            print("Performance Evaluation of " + aID + " saved as " + performance_evaluation_png + ", please open it..")
    print('')

# ====================================================================== #
#                       OUTLIER RATIO PER WINDOW                         #
# ====================================================================== #
if outlier_ratio_evaluation_per_window:
    or_evaluation_dir = output_dir_experimental_evaluation + 'or/'
    if not os.path.exists(or_evaluation_dir):
        os.makedirs(or_evaluation_dir)
    # For each Algorithm:
    for aID, aDatasets in dict_algorithms.items():
        # For each Dataset:
        for dID, metrics in aDatasets.items():
            pe_labels = metrics[label_information][1].tolist()
            pe_windows = metrics[label_information][2].tolist()
            pe_outlier_ratio = []
            pe_outliers = []
            # For each Window:
            for wID in set(pe_windows):
                indices_wID = [i for i, x in enumerate(pe_windows) if x == wID]
                labels_wID = [pe_labels[idx] for idx in indices_wID]
                outliers_WID = labels_wID.count(outlier_class_value)
                outlier_ratio_WID = (outliers_WID / len(labels_wID)) * 100
                pe_outlier_ratio += [outlier_ratio_WID]
                pe_outliers += [outliers_WID]
            # PLOT THE MODEL'S WINDOWS OUTLIER RATIO PER DATASET
            plt.figure()
            plt.rcParams.update({'font.size': 8})
            lw = 1
            unique_windows = list(set(pe_windows))

            print("ALGORITHM " +str(aID)+ " DATASET: "+str(dID)+" NUMBER OF WINDOWS " + str(len(unique_windows)) + " AVERAGE OUTLIER RATIO = "+ str(np.average(pe_outliers)))

            plt.plot(unique_windows, pe_outlier_ratio, 'g^', lw=lw)
            for i, txt in enumerate(pe_outliers):
                plt.annotate(txt, (unique_windows[i], pe_outlier_ratio[i]))
            plt.xlabel('Window')
            plt.ylabel('Outlier Ratio (%)')
            plt.title('Outlier Ratio per window of ' + cm.beautifySTR(aID) + ' on ' + cm.beautifySTR(dID))
            plt.grid('on', linestyle='--', alpha=0.3)
            plt.tight_layout()
            plt.show()
            #performance_evaluation_png = aID + '_' + dID + '_outlier_ratio_evaluation.png'
            #plt.savefig(or_evaluation_dir + performance_evaluation_png, bbox_inches='tight', dpi=300)
            #print("Outlier Ratio Evaluation of " + aID + " saved as " + performance_evaluation_png + ", please open it..")
    print('')


# ====================================================================== #
#                STATISTICAL COMPARISON BETWEEN ALGORITHMS               #
# ====================================================================== #
# https://docs.scipy.org/doc/scipy/reference/generated/scipy.stats.wasserstein_distance.html
from scipy.stats import wasserstein_distance
if statistical_comparison_per_data:
    comparison_algorithms = []
    comparison_algorithms_names = []
    comparison_algorithms_weights = []
    # For each algorithm
    for aID, aDatasets in dict_algorithms.items():
        metric_result_list = []
        metric_dataset_list = []
        sample_algorithm = []
        # For each dataset
        for dID, metrics in aDatasets.items():
            ap = metrics[label_ranking][0]
            sample_algorithm += [ap]
        comparison_algorithms += [sample_algorithm]
        comparison_algorithms_names += [cm.beautifySTR(aID)]
    for i in range(len(comparison_algorithms)):
        sample = comparison_algorithms[i]
        sample_name = comparison_algorithms_names[i]
        baseline = np.ones(len(sample))
        comparison_algorithms_weights += [wasserstein_distance(baseline, sample)]
    detector_weights_sorted, detector_names_sorted = (list(t) for t in zip(*sorted(zip(comparison_algorithms_weights, comparison_algorithms_names))))
    print("DETECTOR RANKING : " + str(detector_names_sorted))
    print("DETECTOR WEIGHTS : " + str(detector_weights_sorted))
    print(' ')
