''' Count the no. of bit set for a number , ex:
8=>1 , 6=>2, 3=>2 
'''


def countBits(n) -> int:
    ''' Python way: Counting number of 1's in a string
    s = str(bin(n)).replace('0b', "")
    return s.count('1')  #=> O(n)
    Used Approach => O(s) s=no. of Set Bits (Brian Karnighan), here we jump to the set bit from the right directly using property as:
    n=n&(n-1), ex: n=26 => 11010 , n-1 =>11001 , n&n-1 => 11000 => last set bit is set to 0, only two left
    now, n=11000, n-1=10111 , AND=> 10000,
    last step=> n=10000 , n-1 => 01111 => AND=> 00000
    '''
    res = 0
    while(n > 0):
        n = n & (n-1)
        res += 1
    return res


t = int(input())
for i in range(t):
    n = int(input())
    print(countBits(n))
