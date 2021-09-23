import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.patches as mpatches


info = pd.read_csv("DATASET_INFO.csv", delimiter=";")
samples  = info['#Samples']
features  = info['#Features']

for i in range(len(samples)):
    if(info['TYPE'][i] == 'Minority'):
        plt.scatter(samples[i],features[i], color='blue', edgecolor='black')
    elif(info['TYPE'][i] == 'Implanted'):
        plt.scatter(samples[i], features[i], color='red',edgecolor='black')
    else:
        plt.scatter(samples[i], features[i], color='orange',edgecolor='black')


type_a = mpatches.Patch(color='blue', label='Minority')
type_b = mpatches.Patch(color='red', label='Implanted')
type_c = mpatches.Patch(color='orange', label='Real')

plt.legend(handles=[type_a,type_b,type_c])

plt.xscale('symlog')
plt.yscale('symlog')
plt.xlabel('#Samples')
plt.ylabel('#Features')
plt.show()
