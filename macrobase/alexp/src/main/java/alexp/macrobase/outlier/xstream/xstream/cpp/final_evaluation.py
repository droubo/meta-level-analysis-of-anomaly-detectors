#!/usr/bin/env python

import numpy as np
from sklearn.datasets import load_svmlight_file
from sklearn.metrics import average_precision_score, roc_auc_score
from sklearn.ensemble import IsolationForest
import sys

if __name__ == "__main__":
    filename = sys.argv[1]

    ap = []
    auc = []
    with open(filename+"_Results.txt", "r") as f:
        fields = f.readline().strip().split(" ")
        while(fields != ['']):
            scores = list((map(float, fields[1].split(" "))))
            
            anomalyscores = -1.0 * np.array(scores)
            ap.append(average_precision_score(y[:len(scores)], anomalyscores))
            auc.append(roc_auc_score(y[len(scores)-256:len(scores)], anomalyscores[len(scores)-256:len(scores)]))
            fields = f.readline().strip().split("\t")


    print("xstream: AP =", np.mean(ap), "AUC =", np.mean(auc))
    result = str(np.mean(ap)) + " " + str(np.mean(auc)) + "\n"
    file1 = open("Results.txt","a")
    file1.write(result)
    file1.close()

