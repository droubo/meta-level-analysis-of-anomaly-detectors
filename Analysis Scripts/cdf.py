import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

data = pd.read_csv("AUC_SCORES.csv", delimiter=";")
datasets = data['DATASETS'].tolist()
print(datasets)
n = len(data)
scores = []
for i in range(n):
    scores.append(data.loc[i:i].to_numpy()[0][1:])
for i in range(len(datasets)):
    print(datasets[i])
occs = []
for i in range(len(datasets)):
    tmp = 0
    for s in scores[i]:
        if(s < 0.6):
            tmp += 1
    
    print(tmp)
    occs.append(tmp)


x = []
y = []
#for i in range(24):
    #occs.append(int(input()))
for i in range(13):
    y.append(occs.count(i) / 24)
    x.append(i)
cdf=np.cumsum(y)
print(y)
plt.plot(x,y, marker="o",label="PMF")
plt.plot(x,cdf,marker="o",label="CDF")
plt.xlim(0,12)
plt.ylim(0,1.1)

tmp = []
for i in range(0,11):
    tmp.append(i/10)
plt.yticks(tmp)
plt.axvline(x=6, ymax=0.45, color='red', linestyle='--')
plt.hlines(y=0.5, xmin = 0, xmax= 6, color='red', linestyle='dashed')
tmp = []
for i in range(0,13):
    tmp.append(i)
plt.xticks(tmp)
plt.xlabel("#Detectors that exhibit similar performance to the Random Classifier (AUC)")
plt.ylabel("Probability Values")
plt.legend()
plt.show()
