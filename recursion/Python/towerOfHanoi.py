def tower(n):
    pass


t = int(input())
for _ in range(t):
    n = int(input())
    a, b = map(int, input().split())
    l = list(map(int, input().split()))
    print(tower(n))
