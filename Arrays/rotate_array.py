''' Given an array rotate with d times and print the result, ex:
ar= 5,8,10,12,15, d=2 => 10,12,15,5,8 

Simple approach we get the net rotation as nr= d%len(l), we create a new array(newarr) with first nr elements only and , in our original array
we remove the first nr elements from the front and add the newarr elements at last of original array => O(N) space

'''


def simple(l, d) -> list:
    nr = d % len(l)
    k = l[:nr]
    l = l[nr:]
    l.extend(k)
    return l


def reverse(l, low, high):
    while(low < high):
        l[low], l[high] = l[high], l[low]
        low += 1
        high -= 1


def better_approach(l, d):
    ''' Simplest way is to reverse the parts of array multiple times, and at the end complete array, space = O(1), time 3*O(n/2)
    reverse(l,0,d-1) => starting ones to be rotated
    reverse(l,d,n-1) => rest part
    reverse(l,0,n-1) => complete array 
    '''
    print('### Better Approach ###')
    nr = d % len(l)  # net rotations
    reverse(l, 0, nr-1)  # d parts
    reverse(l, nr, len(l)-1)  # rest part
    reverse(l, 0, len(l)-1)  # complete array
    print(l)


t = int(input('Enter test cases numbers: '))
for _ in range(t):
    l = list(map(int, input().split()))
    d = int(input())
    print(simple(l, d))
    better_approach(l, d)
