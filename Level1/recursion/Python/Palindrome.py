def isPalindrome(s, start, end) -> bool:
    if(start == end or start > end):  # start=end ex: abba(even) start>end aba(odd)
        return True
    if s[start] == s[end]:
        return isPalindrome(s, start+1, end-1)
    if s[start] != s[end]:
        return False


t = int(input())
for _ in range(t):
    s = input()
    print(isPalindrome(s, 0, len(s)-1))
