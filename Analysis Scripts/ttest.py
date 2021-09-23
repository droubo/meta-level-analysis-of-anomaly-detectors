from scipy.stats import pearsonr, spearmanr
import pandas as pd
import numpy as np


data = np.genfromtxt("TT.csv", delimiter=';')
print(data)
y  = data[:, -1]

names = []
for i in range(43):
    names.append(input())

for i in range(len(data[0])-1):
    r, p = spearmanr(data[:, i], y)
    if(p < 10.05):
        if(i<43):
            print(names[i], i, p, r)
        else:
            print('CORR', i, p, r)
