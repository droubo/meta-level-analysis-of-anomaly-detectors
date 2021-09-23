import re
import numpy as np
# ------------------------------------------------------------------------------------- #
#                   FIND THE FREQUENCY OF EACH FEATURE IN THE SUB SPACES
# ------------------------------------------------------------------------------------- #


def refout_exhaustive_search_parser(fname, labels, outlier_class_value):
    with open(fname, 'r') as f:
       lines = f.readlines()
    subspaces = []
    subspaces_relevant = []
    # find the subspaces that describes all the data points
    for line in lines:
        r1 = re.findall('\((.*?)\)', line)
        r2 = list({x.replace('0.0;', '').replace(';', ',').replace(" ","") for x in r1})
        r3 = []
        for r in r2:
            if len(r) > 0:
                r3 += [(r.split(','))[1:]]
        subspaces += [r3]
    # find the relevant subspaces (describes only outliers)
    outliers = [i for i, x in enumerate(labels) if x == outlier_class_value]
    for oID in outliers:
        subspaces_relevant += subspaces[oID]
    return [list(t) for t in set(tuple(element) for element in subspaces_relevant)] # example output: [['4', '5' '22'], ['10'], ..., ['3', '42', '45']]
