def kill(n, k):
    if n == 1:
        return n
    else:
        return kill(n-1)
