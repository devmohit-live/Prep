''' Reversing the array O(N) => runtime= O(n/2) half of the siz
using two pointers approach one starting from left and one from right
'''


def reverse_array(l):
    low, high = 0, len(l)-1
    while low < high:
        l[low], l[high] = l[high], l[low]
        low += 1
        high -= 1


t = int(input())
for _ in range(t):
    #   n=int(input())
    #   a,b=map(int,input().split())
    l = list(map(int, input().split()))
    reverse_array(l)
    print(l)
