''' Leaders are those which don't have any greater number on right side of it, ex:
ar=[5,3,20,15,8,3] => 20 ,15 ,8, 3 are the leaders => for first element (5) we have 20 greater,
for 20 there isn't any greater element =>20,
for 15 there isn't any greater element =>15,
similar with 8 and 3
ex 2: arar=[5,3,20,15,8,25,3] => 25,3
'''
import sys
from collections import deque


def leaders(l):
    ''' Naive approach would require O(n^2), here we can do it in O(n), the idea here is just start trversing array from last
    if we find element larger then the current element we print the current element first and update the maxnum
    '''
    maxnum = -1
    for i in range(len(l)-1, -1, -1):
        if l[i] > maxnum:
            maxnum = l[i]
            print(maxnum, end=" ")


def leaders_in_order(l):
    d = deque()  # for stack(bydefault works as stack using pop method)
    maxnum = -1
    for i in range(len(l)-1, -1, -1):
        if l[i] > maxnum:
            maxnum = l[i]
            d.append(maxnum)
    n = d.__len__()
    # print(n)
    while(n > 0):
        print(d.pop(), end=" ")
        n -= 1


t = int(input('Cases # :'))
for _ in range(t):
    l = list(map(int, input().split()))
    leaders(l)
    print('In order: ')
    leaders_in_order(l)
