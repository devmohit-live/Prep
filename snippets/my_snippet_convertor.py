# t = input()
''' A simple code that converts your Language specific code to the code that can be added in the body of user defined snippets
for the code having special escape sequences like \n \t etc use \\(double) instead of single
Changes to be made in the upcoming version to remove all manual steps | Mohit Singh 
Still a Noob ;_; @devmohit-live
'''

with open('a.txt', 'r') as reader:
    data = reader.read()
    m = data.split("\n")
    s = ""
    for i in m:
        s += '"{}",\n'.format(i)
    with open('res', 'a') as writer:
        writer.writelines(s)
