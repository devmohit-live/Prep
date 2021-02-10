def kill(n, k):
    if n == 1:
        return 0
    else:
        x = kill(n-1, k)
        return (x+k) % n


t = int(input())
for _ in range(t):
    n, k = map(int, input().split())
    print(kill(n, k))
