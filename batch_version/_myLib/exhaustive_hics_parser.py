import re
import numpy as np
import pandas as pd
# ------------------------------------------------------------------------------------- #
#                   FIND THE FREQUENCY OF EACH FEATURE IN THE SUB SPACES
# ------------------------------------------------------------------------------------- #


def hics_exhaustive_search_parser(fname):
    hics_info = pd.read_csv(fname)
    lines = hics_info[hics_info.columns[0]].values
    relevant_subspaces = []
    for line in lines:
        r1 = line.split(";")
        r2 = [x.replace('-', '') for x in r1]
        r3 = []
        for r in r2:
            if len(r) > 0:
                r3 += [r.split(' ')]
        relevant_subspaces += r3
    return [list(t) for t in set(tuple(element) for element in relevant_subspaces)]  # example output: [['4', '5' '22'], ['10'], ..., ['3', '42', '45']]
