''' Given an array we have to find sum of elements in an array from (a,b) inclusive=>[a,b],
there are given n queries we have to optimize the calulation so that it can be done in O(N)

'''

#  O(N)


def sumsubset(l) -> list:
    ar = [l[0]]
    k = l[0]
    for i in range(1, len(l)):
        k += l[i]  # cumulative sum array or prefix array
        ar.append(k)
    print(ar)
    return ar
    # calculating sum from a to b in cumulative array is sum till ar[b] - sum till ar[a -1] if a!=0
    # if a==0  then ar[b]


t = int(input())
for _ in range(t):
    l = list(map(int, input().split()))
    l = sumsubset(l)
    q = int(input())  # no. of queries
    for x in range(q):
        a, b = map(int, input().split())
        if a == 0:
            print(l[b])
        else:
            print(l[b]-l[a-1])
