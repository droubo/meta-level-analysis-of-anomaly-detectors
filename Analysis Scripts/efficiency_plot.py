import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.patches as mpatches
def type_to_color(info, i):

    if(info['TYPE'][i] == 'Minority'):
        return 'o'
    elif(info['TYPE'][i] == 'Implanted'):
        return 'd'
    else:
        return '^'

data = pd.read_csv("AP_SCORES.csv", delimiter=";")
algorithms = data.columns[1:]
print(algorithms)
n = len(data)


times_csv = pd.read_csv("TIMES.csv", delimiter=";")
algorithms = times_csv.columns[1:]
print(algorithms)
n_t = len(times_csv)

info = pd.read_csv("DATASET_INFO.csv", delimiter=";")
print(info['TYPE'][0])

scores = []
for i in range(n):
    scores.append(data.loc[i:i].to_numpy()[0][1:])
 
times = []
for i in range(n):
    times.append(times_csv.loc[i:i].to_numpy()[0][1:])
    
scores = np.array(scores)
times = np.array(times)

print(scores[:,0])

print(times[:,0])

times_final = []
scores_final = []
algorithm_names = []
tradeoff = []

for i in range(6):
    tradeoff.append(np.mean(scores[:, i]/times[:, i]))
print(tradeoff)

algo_i = 0
for i in range(6):
    if(i == algo_i):
        continue
    times_final.append((times[:, algo_i] - times[:, i]) / times[:, i])
    scores_final.append((scores[:, i] - scores[:, algo_i]) / scores[:, i])
    algorithm_names.append(algorithms[i])
  
markers = ['o', '^', 'd']
colors = ['green', 'blue', 'black', 'purple', 'red']
algorithms = ['ΗSΤ', 'HSTF', 'RRCF','MCOD', 'L-S']

dominating = 0
dominated = 0
grey_1 = 0
grey_2 = 0
for i in range(5):
    for j in range(24):
        if(scores_final[i][j] > 0):
            if(times_final[i][j] > 0):
                dominated += 1
            else:
                grey_1 += 1
        else:
            if(times_final[i][j] > 0):
                grey_2 += 1
            else:
                dominating += 1
                
print(dominated)
print(dominating)
print(grey_1)
print(grey_2)
#for i in range(5):
#    for j in range(24):
#        plt.scatter((scores_final[i][j]), (times_final[i][j]), color=type_to_color(info,j), edgecolors='black')
#    print(np.sum(np.array((scores_final[i])) >= 0, axis=0))

#type_a = mpatches.Patch(color='green', label='Low #Samples - #Low Feat.')
#type_b = mpatches.Patch(color='blue', label='High #Samples - #Low Feat.')
#type_c = mpatches.Patch(color='black', label='Low #Samples - #High Feat.')
#type_d = mpatches.Patch(color='red', label='High #Samples - #High Feat.')

types = []

for i in range(5):
    types.append(mpatches.Patch(color=colors[i], label=algorithms[i]))

#plt.legend(handles=[type_a,type_b,type_c,type_d])

for i in range(5):
    for j in range(24):
        plt.scatter((scores_final[i][j]), (times_final[i][j]), color=colors[i], edgecolors='black', marker=type_to_color(info, j), s = 70, alpha=0.7)
plt.axhline(0, color='black')
plt.axvline(0, color='black')
#plt.xscale('symlog')

#plt.yscale('symlog')
plt.xlabel( 'Relative effectiveness = ( (MAP_Detector - MAP_X-S) / MAP_X-S)' )
plt.ylabel( 'Relative efficiency = ( (TIME_X-S - TIME_Detector) / TIME_X-S)' )
plt.title('Trade-off plot')

f = lambda m,c: plt.plot([],[],marker=m, color=c, ls="none")[0]

handles = [f("s", colors[i]) for i in range(5)]
handles += [f(markers[i], "k") for i in range(3)]

labels = algorithms + ['Minority', 'Real', 'Implanted']
plt.legend(handles, labels)
plt.show()
