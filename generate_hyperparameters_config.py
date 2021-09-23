from config_generator import configurator
import numpy as np
from random import uniform, randint

algorithms = ['xstream']
TuningMode = True
if TuningMode is False:
    names = []
    for i in range(24):
        name = input()
        names.append(name)
    for algo in algorithms:
        if(algo == 'xstream'):
            for i in range(24):
                k = int(input())
                chains = int(input())
                configurator('xstream', [k, chains], str(i), names[i])
        elif(algo == 'hst'):
            for i in range(24):
                trees = int(input())
                configurator('hst', [trees], str(i), names[i])
        elif(algo == 'hstf'):
            for i in range(24):
                trees = input()
                forget = input()
                configurator('hstf', [trees, forget], str(i), names[i])
        elif(algo == 'rrcf'):
            for i in range(24):
                trees = int(input())
                forget = input()
                configurator('rrcf', [trees, forget], str(i), names[i])
        elif(algo == 'mcod'):
            for i in range(24):
                dist = (input())
                neighbor = (input())
                configurator('mcod', [dist, neighbor], str(i), names[i])
        elif(algo == 'loda'):
            for i in range(24):
                configurator('loda', [0, 0], '0', names[i])

    quit()
for algo in algorithms:
    
    if(algo == 'xstream'):
        algorithm = 'xstream'
        chains = [25,50,100]
        k =  [25,50,100]
        xs, ys = np.meshgrid(chains, k)
        tmp = (np.dstack([xs, ys]))
        params = []
        for i in range(1, len(tmp)):
            if(params == []):
                params = np.concatenate((tmp[i-1], tmp[i]))
            else:
                params = np.concatenate((params, tmp[i]))
        i = 0
        for param in params:
            configurator(algorithm, param, str(i))
            i += 1
    elif(algo == 'hst'):
        params = [[50]] #[[25],[50],[100]]
        i = 0
        for param in params:
            configurator('hst', param, str(i))
            i += 1
    elif(algo == 'hstf'):
        n_trees = [50] #[25,50,100]
        forget = [64,128,256,512, 'max']
        xs, ys = np.meshgrid(n_trees, forget)
        tmp = (np.dstack([xs, ys]))
        
        params = []
        for i in range(1, len(tmp)):
            if(params == []):
                params = np.concatenate((tmp[i-1], tmp[i]))
            else:
                params = np.concatenate((params, tmp[i]))
        i = 0
        for param in params:
            configurator('hstf', param, str(i))
            i += 1

    elif(algo == 'rrcf'):
        
        n_trees = [50] #[25,50,100]
        forget = ['max', 'max'] #[64,128,256,512, 'max']
        xs, ys = np.meshgrid(n_trees, forget)
        tmp = (np.dstack([xs, ys]))
        params = []
        for i in range(1, len(tmp)):
            if(params == []):
                params = np.concatenate((tmp[i-1], tmp[i]))
            else:
                params = np.concatenate((params, tmp[i]))
        i = 0
        for param in params:
            configurator('rrcf', param, str(i))
            i += 1   
    elif(algo == 'mcod'):
        #for i in range(100):
        #    configurator('mcod', [uniform(0.1, 4), randint(1, 64)], str(i))  
        configurator('mcod', [0.741, 22], str(i))
    elif(algo == 'loda'):
        configurator('loda', [0, 0], '0')