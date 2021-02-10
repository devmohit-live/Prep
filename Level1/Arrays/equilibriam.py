''' Given an array we have to find whether the array contains the equilibrium point or not if yes print the quilibrium point else print NO
ex: [4,2,-2] yes => 4 ex sum of elements before it =0=> no element , sum of elements after it =0=? 2-2
3 4 8 -9 20 6 => 20 , before =>3+4+8-9=6 after 6
4 2 2 => NO
-2 2 4 => 4 left sum(-2+2)=0 and rigt sum(no elements) =>0

'''
import sys
''' Naive solution O(N^2) => calculating left and right sum for each element anf comparing

for i in range(len(l)):
    leftsum,rightsum=0,0
    for j in range(i):
        leftsum+=l[j]
    for k in range(i+1,len(l)):
        rightsum+=l[k]
    if leftsum==rightsum:
        return true
    return flase

'''
''' Second prefix and suffeix sum => cumulative sum aaray =>  arrays prefixsum[i+1]=suffixsum[i+1] return true
O(N) but requires to calculate prefix and syffexis also two extra arrays are required, and 3 O(N) time as 
3 traverasal of array for prefix, suffexis and calculation

'''


def cal(ar) -> int:
    ''' O(n) and O(1) extra space
    at any time at index i  left sum will be sum(0 to i) and right sum woulbe be totalsum-a[i], window technique
    initially leftsum=0 and all will go to right sum except current element, at i=1
    now they would be : leftsum=previous leftsum+a[0] , rightsum= previous rightsum-a[0]- a[1](current element) updated already at the ebd of previous iteration
    '''
    netsum = sum(ar)  # netsum of array
    left = 0
    for i in range(len(ar)):
        # print(i, "left is ", left, "right is", netsum-ar[i])
        if left == netsum-ar[i]:
            return ar[i]  # current element id equilibrium
            # return True  # current element id equilibrium
        else:
            # update left sum and right sum
            left += ar[i]
            netsum -= ar[i]
    return -sys.maxsize
    # return False


t = int(input())
for _ in range(t):
    l = list(map(int, input().split()))
    # print(cal(l))
    k = cal(l)
    if k == -(sys.maxsize):
        print('NO')
    else:
        print('Yes', k)
