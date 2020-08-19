def chpow(n) -> bool:
    '''
    Property for every power of 2 , only the first bit is set to 1 all others are 0:
    8=>1000, 16=> 10000, so here we have to check : a) first bit is set, b) others bit are zero =>
    Simply way to aceive this is x*(x-1) say x=8 =>  1000 AND (0111) see ther AND operation gives ZERO(0),
    say x=6 => 110 AND (011) = 010(4) not all zero.
    Exception => 0(Zero) it isn' power of 2. 
    '''
    if n == 0:
        return False
    elif n & (n-1) == 0:
        return True
    return False


'''Check wheter the given number is power of 2 or not : 2**n 
    we can't do with this approach as 6 isn't a powe of 2 but has last bit 0,
    if n & 1 == 0:
        print(True)
    else:
        print(False)
'''

t = int(input())
for i in range(t):
    n = int(input())
    print(chpow(n))
