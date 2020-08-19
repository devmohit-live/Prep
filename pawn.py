import math
import sys
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        moves = sys.maxsize
        item = sys.maxsize
        N, K = map(int, input().split())
        players = list(map(int, input().split()))
        for i in players:
            if K % i == 0:
                crmv = math.floor(K/i)
                if crmv < moves:
                    moves = crmv
                    item = i
        if moves == sys.maxsize:
            print(-1)
        else:
            print(item)
