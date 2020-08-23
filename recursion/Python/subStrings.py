def subs(s, curr="", index=0):
    if index == len(s):
        if curr == "":
            print('""')
        else:
            print(curr)
        return
    subs(s, curr, index+1)
    subs(s, curr+s[index], index+1)


if __name__ == "__main__":
    subs("ABC")
