def approach1(n) -> int:
    globalcount, localcount = 0, 0
    s = bin(n).replace('0b', '')
    for i in s:
        if i == '1':
            localcount += 1
        else:
            if localcount > globalcount:
                globalcount = localcount
                localcount = 0
    # when else case osn't reached => 1) all are ones, 2) last subsequence is one  => 10111000011111111
    # if localcount > globalcount:  # this case when all are 1 ex: 255 global=0 , local=8 and else case is never reached
    #     globalcount = localcount
    # or
    return max(globalcount, localcount)


def approach2(N):
    #print('********* Approach using using Right shifting of numbers ********')
    maxm = 0
    cnt = 0
    while(N):
        if(N & 1):
            cnt += 1
            N >>= 1
            maxm = max(maxm, cnt)
        else:
            maxm = max(maxm, cnt)
            cnt = 0
            N >>= 1

    return maxm


''' fincd the length of the longest substring in binary representation having all ones, ex:
x=(220)=>11011100 answer will be 3 longest subsequnece is 111.
x=25=>11001 ans=2s, x=1531=> 10111111011
Approaches=> 1) count the local longest running 1's in binary  and update the global count if local>global,
2) use shift operator 
'''


t = int(input())
for _ in range(t):
    n = int(input())
    # a, b = map(int, input().split())
    # l = list(map(int, input().split()))
    print('Approach 1: ', approach1(n))
    print('Approach 2: ', approach2(n))
