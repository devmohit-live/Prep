def winsm(l, k) -> int:
    i = 0
    mxsum = sum(l[:k])  # sum of first k elements
    cursm = mxsum
    while(i+k < len(l)):  # no.of window slides
        # this is sliding window removinf first window element and adding new
        cursm = cursm - l[i]+l[i+k]
        if cursm > mxsum:
            mxsum = cursm
        i += 1
    return max(mxsum, cursm)


''' Find the maximum sum of K consecutive elements,ex:
k=3, l=[1,2,3,1,4,5] => 10 (1+4+5)
k=3, l=[5,2-,1,0,3] => 6 (5,2,-1)
Whenever we see the question saying consecutive sum, we use the approach of Sliding Window=> Steps:
1. calculate the sum of first k elements store it in maxsum var
2. for every iteration delete the previous element and add the next element
3. compare the new calculated sum current sum with maxsum
'''
t = int(input())
for _ in range(t):
    #   a,b=map(int,input().split())
    l = list(map(int, input().split()))
    k = int(input())
    print(winsm(l, k))
