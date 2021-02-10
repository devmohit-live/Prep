# getting or setting kth bit of any number


def getKthBit(n, k) -> bool:
    if n & 1 << (k-1) == 0:
        return 0
    return 1


def setKthBit(n, k) -> int:
    n = n | 1 << (k-1)
    return n

def unSetKthBit(n, k) -> int:
    n = n & ~(1 << (k - 1))
    return n


print(getKthBit(4, 1))  # =>0
print(getKthBit(4, 3))  # =>1
print(setKthBit(4, 1))  # 5 setting lastbit change 4 to 5
print(unSetKthBit(3, 1))  # will make it 2    000011 ==> 000010
print(unSetKthBit(4, 3))  # will make it 0    000100 ==> 000000


# # python way @_@
# # bin() -> covert decimal to binary ex 4=> 0b100 , int(bin(x),2) -> binary to decimal here base=2.


# def getbit(n, k) -> int:
#     a = str(bin(n).replace('0b', ''))
#     # print(a)
#     if a[-(k)] == '1':
#         return 1
#     return 0


# print(getbit(4, 1))
# print(getbit(4, 2))
# print(getbit(4, 3))
