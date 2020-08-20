def gcd(a, b) -> int:
    if a % b == 0:
        return b
    return gcd(b, a % b)


t = int(input())
for _ in range(t):
    #   n=int(input())
    a, b = map(int, input("Input two space seperated integers: ").split())
#   l=list(map(int,input().split()))
    print(gcd(a, b))
