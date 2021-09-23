import numpy as np
import matplotlib.pyplot as plt
import os
files = os.listdir('datasets')
for file in files:
    print(file)
for file in files:
    if (file[0] == '.'):
        continue
    data = np.genfromtxt('datasets/'+file, delimiter=",", skip_header=1)
    if(file == 'Cardiotocography_shuffleStratified.csv'):
        labels = data[:, -1]
    else:
        labels = data[:, -2]
    inliers = data[labels == 0]
    outliers = data[labels == 1]
    data = data[:, :-2]
    
    print(np.percentile(data,95) - np.percentile(data, 5))
    in_avg = []
    out_avg = []
    for i in range(len(inliers[0, :]) - 2):
        in_avg.append(np.median(inliers[:, i]))
        out_avg.append(np.median(outliers[:, i]))
        
    sm = 0
    for i in range(len(in_avg)):
        sm += (in_avg[i] - out_avg[i]) ** 2

    #print(np.sqrt(sm))


