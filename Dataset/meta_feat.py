# Load a dataset
from sklearn.datasets import load_iris
from pymfe.mfe import MFE
import numpy as np
from os import listdir
from os.path import isfile, join
import pandas as pd
import scipy.stats as sstats

import csv
with open('DatasetDetails.csv', 'w', newline='') as csvfile:

    dataset_path = "output/loda_done/"
    dataset_names = [f for f in listdir(dataset_path) if isfile(join(dataset_path, f))]
    for i in range(len(dataset_names)):
        data = pd.read_csv(dataset_path+dataset_names[i], delimiter=",")
        y = data["is_anomaly"].to_numpy()
        del data["is_anomaly"]
        if 'subspace' in data:
            del data["subspace"]
        X = data.to_numpy()

        # Extract default measures
        mfe = MFE(groups=["statistical"])
        mfe.fit(X, y)
        ft = mfe.extract()


        spamwriter = csv.writer(csvfile, delimiter=',',
                                quotechar='|', quoting=csv.QUOTE_MINIMAL)
        #spamwriter.writerow(ft[0])
        spamwriter.writerow(ft[1])
