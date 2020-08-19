from collections import Counter


def solver(n, fm, k):
    minval = k*n  # every one sits on diff chair
    repeators = 0
    c = Counter(fm)
    for i in dict(c).values():
        if i > 1:
            repeators += 1
    unique = n-repeators
    mstcmn = c.most_common(repeators)
    print(mstcmn)


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n, k = map(int, input().split())
        fm = list(map(int, input().split()))
        solver(n, fm, k)
