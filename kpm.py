from collections import Counter


def anangram(S, P):
    res = ""
    # converting counter obj to dictionary
    s = Counter(S)
    # s = dict(Counter(S))
    p = Counter(P)
    # p = dict(Counter(P))
    # freq of a in S - freq od a in P anagram -> same length
    fn = s-p
    fn = dict(fn)
    print(fn)
    # print('uniques elements', list(fn))
    # make a string for s with new frequency
    news = ""
    for i in fn.keys():
        news += i*s[i]
    news = ''.join(sorted(news))

    for i in range(len(S)):
        if news[i] > P[0]:
            res = news[:i]+P+news[i:]
            # print(res)
            break
        else:
            res = news+P
    print(res)


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        S = input()
        P = input()
        anangram(S, P)
