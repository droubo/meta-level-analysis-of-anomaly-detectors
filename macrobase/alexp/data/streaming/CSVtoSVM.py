"""
Convert CSV file to libsvm format. Works only with numeric variables.
Put -1 as label index (argv[3]) if there are no labels in your file.
Expecting no headers. If present, headers can be skipped with argv[4] == 1.

"""

import sys
import csv
import operator
from collections import defaultdict
import glob
import numpy as np
import os

def construct_line(label, line, labels_dict):
    new_line = []
    if label.isnumeric():
        if float(label) == 0.0:
            label = "0"
        else:
            label = "1"
        new_line.append(label)
    else:
        if label in labels_dict:
            new_line.append(labels_dict.get(label))
        else:
            label_id = str(len(labels_dict))
            labels_dict[label] = label_id
            new_line.append(label_id)

    for i, item in enumerate(line):
        if item == '' or float(item) == 0.0:
            continue
        elif item=='NaN':
            item="0.0"
        new_item = "%s:%s" % (i + 1, item)
        new_line.append(new_item)
    new_line = " ".join(new_line)
    new_line += "\n"
    return new_line

# ---
def convertToSvm(input_file,output_file,label_index,skip_headers):
    i = open(input_file, 'rt')
    o = open(output_file, 'wb')

    reader = csv.reader(i)

    if skip_headers:
        headers = reader.__next__()

    labels_dict = {}
    for line in reader:
        if label_index == -1:
            label = '1'
        else:
            label = line.pop(label_index)

        new_line = construct_line(str(label), line, labels_dict)
        o.write(new_line.encode('utf-8'))

files = glob.glob("datasets/*.csv")
for file_ in files:
    dt = np.genfromtxt(file_, delimiter=",")
    convertToSvm(file_, "datasets\\"+os.path.splitext(os.path.basename(file_))[0]+".svm", len(dt[0])-2, 1)