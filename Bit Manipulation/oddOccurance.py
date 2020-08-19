def isBitSet(n, k) -> bool:
    if n & 1 << (k-1):
        return True
    return False


l = list(map(int, input().split()))

k = 1  # first bit
netxor = 0
for i in l:
    if(isBitSet(i, k)):
        netxor ^= i  # in case of only one numer occuring odd no. of time this netxor will be the answer

# checking which bit of xor (from right) is 1 as only x^x=0 and this can't be in the case of odd occurance
while(not(isBitSet(netxor, k))):
    k += 1

st = 0
nst = 0

# making partitions for numers having kth bit set and off and calculating their xor seperately
for i in l:
    if isBitSet(i, k):
        st ^= i
    else:
        nst ^= i
print(st, nst)
