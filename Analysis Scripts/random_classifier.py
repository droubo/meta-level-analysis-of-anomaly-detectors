import numpy as np
from sklearn.metrics import average_precision_score, roc_auc_score
import os
files = os.listdir('datasets')
#print(files)

def new_average_precision_at_k(y_true, y_scores, k):
    size = len(y_true)
    size_ones = np.ndarray.tolist(y_true).count(1)
    relevant = 0
    ap = []
    item_counter = 0
    ap_at_k = 0
    for sp in np.argsort(y_scores)[::-1]:
        item_counter += 1
        if y_true[sp] == 1:
            relevant += 1
            ap = ap + [relevant / item_counter]
        else:
            ap = ap + [0]
        if item_counter == min(size, k):
            sum_ap = sum(ap)
            ap_at_k = sum_ap / size_ones if sum_ap > 0 else 0
            break
    return ap_at_k
    
for file in files:
    break
    data = np.genfromtxt('datasets/'+file, delimiter=",", skip_header=1)
    if(file == 'Cardiotocography_shuffleStratified.csv'):
        labels = data[:, -1]
    else:
        labels = data[:, -2]
    ap = []
    auc = []
    for i in range(30):

        shuffled_labels = np.copy(labels)
        np.random.shuffle(shuffled_labels)

        ap.append(average_precision_score(labels, shuffled_labels))
        auc.append(roc_auc_score(labels, shuffled_labels))
        
    print(file + ": " + str(np.mean(ap)) + " - " + str(np.mean(auc)))
    
    
zr = np.zeros(500)
ons = np.ones(15)

labels = np.concatenate((ons,zr))

scores = np.copy(labels)

for i in range(10):
    scores[104-i] = 1

print(average_precision_score(labels, scores))
print(roc_auc_score(labels, scores))

