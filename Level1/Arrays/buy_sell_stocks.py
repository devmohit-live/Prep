''' Solution is based on finding all the local minima and maxima, and summation of thier differences
sigma(localmaxs-localmins)
'''
import sys


def bss(l) -> int:
    lmax = []
    # since we want to compare l[i-1] and l[i+1] element and also want to include first and last element in coparison
    lmin = [l[0]]
    l.append(-1)  # to get last element included in comparison
    s = 0
    # localmax,localmin=l[0]
    for i in range(1, len(l)-1):
        if l[i-1] < l[i] > l[i+1]:
            lmax.append(l[i])
        if l[i-1] > l[i] < l[i+1]:
            lmin.append((l[i]))
    # print('lmax is {} lmin is  {} '.format(lmax, lmin))
    for i, j in zip(lmax, lmin):
        s += i-j
        # print(j, i)

    if s < 0:
        return -1
    return s


t = int(input())
for _ in range(t):
    l = list(map(int, input().split()))
    print(bss(l))
