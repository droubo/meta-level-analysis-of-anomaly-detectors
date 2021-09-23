import numpy as np
from sklearn.metrics import average_precision_score, roc_auc_score
import matplotlib.pyplot as plt
data = np.genfromtxt("http_shuffleStratified.csv", delimiter=',')
x = data[:, 0]
y = data[:, 1]
z = data[:, 2]
plt.violinplot(x)
plt.show()
plt.violinplot(y)
plt.show()
plt.violinplot(z)
plt.show()