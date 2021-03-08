''' Given an array of walls of height i , How much water can be trapped inside the walls
ie sum of all the water between all the walls
approach to find water bw 2 walls is => min(max(walls to the left of i),max(walls to the right of i))
ex: [3,0,1,2,5] => 6
[2,0,2] => 2
'''


def naive(l) -> int:
    # O(n**2)
    s = min(l[0], max(l[1:]))-l[0]
    # min(left max till i , right max till i)-height of current wall
    for i in range(1, len(l)-1):
        s += min(max(l[:i]), max(l[i+1:]))-l[i]
    return s


def better(l):
    pass
    # TODO:
    lmax = [l[0]]
    rmax = [l[-1]]
    # leftmax upto i
    for i in range(1, len(l)):
        # current element is greater than the lmax array's elemey
        lmax.append(max(lmax[i-1], l[i]))

    # right max upto i
    for j in range(1, len(l)):
        # comparing from the right of the array with the last element of rmax(initially set to l[-1])
        rmax.append(max(rmax[j-1], l[len(l)-j-1]))

    print('lmax is {}  and rmax is {} '.format(lmax, rmax))
    s = 0
    for i in range(len(l)):
        s += min(lmax[i], rmax[i])-l[i]

    if s < 0:
        s = 0
    print('Water stored is {} units'.format(s))


t = int(input())
for _ in range(t):
    l = list(map(int, input().split()))
    # print(naive(l))
    better(l)
