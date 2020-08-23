''' Given an array of walls of height i , How much water can be trapped insise the walls
ie sum of all the water between all the walls
approach to find water bw 2 walls is => min(max(walls to the ledt of i),max(walls to the right of i))
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


t = int(input())
for _ in range(t):
    l = list(map(int, input().split()))
    print(naive(l))
