import numpy as np


def average_precision_at_k(y_true, y_scores, k):
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

def new_average_precision_at_k(y_true, y_scores, k):
    size = len(y_true)
    size_ones = np.ndarray.tolist(y_true).count([1])
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

def precision_at_k(y_true, y_scores, k):
    size = len(y_true)
    relevant = 0
    item_counter = 0
    p_at_k = 0
    for sp in np.argsort(y_scores)[::-1]:
        item_counter += 1
        if y_true[sp] == 1:
            relevant += 1
        if item_counter == min(size, k):
            p_at_k = relevant / item_counter
            break
    return p_at_k






