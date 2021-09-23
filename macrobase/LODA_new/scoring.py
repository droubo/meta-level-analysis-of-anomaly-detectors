import numpy as np
from sklearn.metrics import average_precision_score, roc_auc_score

scores = np.genfromtxt("scores", delimiter=',')
score = scores *-1
labels = np.genfromtxt("labels.csv", delimiter=',')
print(len(score))
print(average_precision_score(labels,score))
print(roc_auc_score(labels,score))