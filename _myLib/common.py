# https://stackoverflow.com/questions/26414913/normalize-columns-of-pandas-data-frame/48651066
def normalize(df):
    result = df.copy()
    for feature_name in df.columns:
        max_value = df[feature_name].max()
        min_value = df[feature_name].min()
        if max_value > min_value:
            result[feature_name] = (df[feature_name] - min_value) / (max_value - min_value)
        else:
            result[feature_name] = df[feature_name]
    return result


def normalize_scores(scores):
    smax = max(scores)
    smin = min(scores)
    if smax > smin:
        scores_norm = [(x - smin) / (smax - smin) for x in scores]
        return scores_norm
    else:
        return scores











def evaluator_csv_output(alg_ID, dataset_ID, experiment_ID):
    return alg_ID+'_'+dataset_ID+'_'+experiment_ID+'.csv'

def transformToBinaryClassification(labels, scores):
    '''
    :param labels: the ground truth of each data point
    :param scores: the predicted score of each data point
    :return: 2x 2D lists
    Example:
    labels = [0, 0, 1]
    scores = [0.25, 0.15, 0.9]
    Result:
        iLabel = [[1, 0], [1, 0], [0, 1]]
        bScores = [[0.75, 0.25], [0.85, 0.15], [0.1, 0.9]]
    '''
    # calculate the binary [inlier, outlier] class list, according to the ground truth of each data point
    iLabels = []
    for label in labels:
        if label == 0:
            iLabels.append([1, 0])
        else:
            iLabels.append([0, 1])
    # calculate the binary [inlier, outlier] score list, according to the predicted outlier score of each sample
    bScores = []
    for score in scores:
        bScores.append([1-score, score])
    return iLabels, bScores

def beautifySTR(str):
    return str.replace("_", " ").upper()

def beautifyDataset(dset):
    return dset.replace('shuffleStratified', '').replace('shuffle', '').replace('_', ' ').replace('csv', '').upper()


def findAlgorithmAndDataset(filePathName):
    algorithmName = (filePathName.replace(" ", "").split("_"))[0]
    datasetName = filePathName.replace(algorithmName+"_", "").replace(algorithmName, "").replace(".csv", "")
    return algorithmName, datasetName

def matchedAlgorithm(filePathName, algorithmName):
    if algorithmName == (filePathName.replace(" ", "").split("_"))[0]:
        return True
    else:
        return False
def matchedDataset(filePathName, datasetName):
    algorithmName = (filePathName.replace(" ", "").split("_"))[0]
    currentDatasetName = filePathName.replace(algorithmName+"_", "").replace(algorithmName, "").replace(".csv", "")
    if datasetName == currentDatasetName:
        return True
    else:
        return False

######################################################################################################################################################
###########################################################################################################################################################
###########################################################################################################################################################
###########################################################################################################################################################
###########################################################################################################################################################

# https://stackoverflow.com/questions/31575399/dynamically-add-subplots-in-matplotlib-with-more-than-one-column/31575923
import matplotlib.pyplot as plt
import numpy as np


def add_subplot(fig = None, layout = 'grid'):
    """
    Add a subplot, and adjust the positions of the other subplots appropriately.
    Lifted from this answer: http://stackoverflow.com/a/29962074/851699

    :param fig: The figure, or None to select current figure
    :param layout: 'h' for horizontal layout, 'v' for vertical layout, 'g' for approximately-square grid
    :return: A new axes object
    """
    if fig is None:
        fig = plt.gcf()
    n = len(fig.axes)
    n_rows, n_cols = (1, n+1) if layout in ('h', 'horizontal') else (n+1, 1) if layout in ('v', 'vertical') else \
        vector_length_to_tile_dims(n+1) if layout in ('g', 'grid') else bad_value(layout)
    for i in range(n):
        fig.axes[i].change_geometry(n_rows, n_cols, i+1)
    ax = fig.add_subplot(n_rows, n_cols, n+1)
    return ax, fig


_subplots = {}


def set_named_subplot(name, fig=None, layout='grid'):
    """
    Set the current axes.  If "name" has been defined, just return that axes, otherwise make a new one.

    :param name: The name of the subplot
    :param fig: The figure, or None to select current figure
    :param layout: 'h' for horizontal layout, 'v' for vertical layout, 'g' for approximately-square grid
    :return: An axes object
    """
    if name in _subplots:
        plt.subplot(_subplots[name])
    else:
        _subplots[name] = add_subplot(fig=fig, layout=layout)
    return _subplots[name]


def vector_length_to_tile_dims(vector_length):
    """
    You have vector_length tiles to put in a 2-D grid.  Find the size
    of the grid that best matches the desired aspect ratio.

    TODO: Actually do this with aspect ratio

    :param vector_length:
    :param desired_aspect_ratio:
    :return: n_rows, n_cols
    """
    n_cols = np.ceil(np.sqrt(vector_length))
    n_rows = np.ceil(vector_length/n_cols)
    grid_shape = int(n_rows), int(n_cols)
    return grid_shape


def bad_value(value, explanation = None):
    """
    :param value: Raise ValueError.  Useful when doing conditional assignment.
    e.g.
    dutch_hand = 'links' if eng_hand=='left' else 'rechts' if eng_hand=='right' else bad_value(eng_hand)
    """
    raise ValueError('Bad Value: %s%s' % (value, ': '+explanation if explanation is not None else ''))



###########################################################################################################################################################
###########################################################################################################################################################
###########################################################################################################################################################








