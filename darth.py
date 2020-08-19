def death(h: int, p: int) -> int:
    # print(h,p)
    if int(h) <= 0:
        return 1
    if int(p) <= 0:
        return 0
    return death(h-p, p/2)


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        H, P = map(int, input().split())
        r = death(H, P)
        print(r)
