'''
Given a String print it's Power Set, ex s="abc" => "",a,b,c,ab,ac,bc,abc => len(s)=3, subsets= 2**3
Done this question using recursive approach, here we will use bit maipulation
for every string of length n there are 2**n subsets, here we fix the place of every character ,ex s=_ _ _, first is for a,
second is for b, third is for c, and 0,1 will mark there presence, ex 100 represents a. 111 =>abc, 000 -> ""
'''


def powerSet(s):
    n = len(s)
    power = (1 << n)  # 2**n
    for i in range(power):
        for j in range(n):  # Binary representaion of i (0 to 8) for n =3
            if(i & (1 << j) > 0):  # checks if jth(each) bit is set or not
                # if jth bit is set print s[j] s[0]=>a, s[1]=>B from original string
                print(s[j], end="")
        print()


# Time complexity is

t = int(input())
for _ in range(t):
    s = input()
    powerSet(s)
    # powerSet1(s)
