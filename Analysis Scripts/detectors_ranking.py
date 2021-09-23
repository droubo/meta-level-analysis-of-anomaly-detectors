import pandas as pd
import numpy as np
from scipy.stats import friedmanchisquare, rankdata
from scikit_posthocs import posthoc_nemenyi_friedman

diff = [ [], [], [], [], [], [] ]
wins = np.zeros(6)

#diff = [ [], [], [], [], [], [], [], [], [], [], [], [] ]
#wins = np.zeros(12)

#diff = [ [], [], [], [], [], [], [], [], [], [], [], [], [] ]
#wins = np.zeros(13)
def alg_rank_dataset(scores):
    final_scores = scores[0, 1:].copy()
    j = 0
    l = len(final_scores)
    '''
    for score in scores[0, 1:]:
        for i in range(len(final_scores)):
            if(score == final_scores[i]):
                ranks[j] = i+1
                j += 1
                break
    '''
    i = 0
    ranks = rankdata(final_scores)
    print(ranks)
    #print(ranks)
    max_s = max(final_scores)
    for i in range(len(ranks)):
        ranks[i] = 7 - ranks[i]
        if(ranks[i] != 1 and ranks[i] != 1.5):
            diff[i].append(max_s - final_scores[i])
        else:
            diff[i].append(max_s - final_scores[i])
            wins[i] += 1
    '''
    with open("test2.csv", "a") as fp:
        for i in range(5):
            fp.write(str(diff[i]) + ";")
        fp.write(str(diff[5]) + "\n")
    print(diff)
    '''
    return ranks

data = pd.read_csv("AP_SCORES.csv", delimiter=";")
algorithms = data.columns[1:]
print(algorithms)
n = len(data)
k = len(data.loc[0:0].to_numpy()[0]) - 1
print(n)
print(k)
ranks = np.zeros((n,k))
for i in range(n):
    ranks[i] = alg_rank_dataset(data.loc[i:i].to_numpy())
print(ranks[:,0])
overall_ranks = np.zeros(k)

for rank in ranks:
    for i in range(len(rank)):
        overall_ranks[i] += rank[i]
#print(overall_ranks)
print(wins)
for diff_ in diff:
    print(np.mean(diff_))
#decision rule = 12.59 for alpha = 0.05
avg_ranks = overall_ranks/n
print(avg_ranks)

'''
minus_part = 3*n*(k+1)
mul_part = (12*n) / (k*(k+1))
r2 = 0
for i in range(k):
    r2 += (avg_ranks[i]**2)
print(r2)
print(((k*((k+1)**2))/4))
xr = mul_part * (r2 - ((k*((k+1)**2))/4))
print("Friendman: " + str(xr))
'''

CD = 2.948319908 * np.sqrt((k*(k+1))/ (6*n))
print("CD: " + str(CD))
#print(friedmanchisquare(ranks[:, 0],ranks[:, 1],ranks[:, 2],ranks[:, 3],ranks[:, 4],ranks[:, 5],ranks[:, 6]))
#print(posthoc_nemenyi_friedman(ranks))

avg_ranks.sort()
print("Maximum distance: " + str(avg_ranks[k-1] - avg_ranks[0]))

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from autorank import autorank, plot_stats, create_report, latex_table, latex_report
del(data["DATASETS"])

dat = pd.DataFrame()
for i in range(k):
    dat[algorithms[i]] = ranks[:, i]
result = autorank(data, alpha=0.05, verbose=False)
print(result)
create_report(result)
plot_stats(result, allow_insignificant=True)
plt.show()

latex_report(result, prefix="report")
