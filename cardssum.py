import math


def digit(n):
    ''' logic for minimum x digit number to get the sum of n '''
    q = math.floor(n/9)
    r = n % 9
    if r == 0:
        return q
    else:
        return q+1


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        mindigit = 0
        winner = -1
        C, R = map(int, input().split())
        Cp = digit(C)
        Rp = digit(R)
        if Cp >= Rp:
            mindigit = Rp
            winner = 1
        else:
            mindigit = Cp
            winner = 0
        # print(winner, len(str(mindigit)))
        print(winner, mindigit)
