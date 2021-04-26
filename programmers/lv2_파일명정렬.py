def splitdigit(string):
    for i in range(len(string)):
        if string[i].isdigit():
            for j in range(i+1, len(string)):
                if not string[j].isdigit():
                    return string[i:j]
            return string[i:]
                
def solution(files):
    alist = []
    for file in files:
        number = splitdigit(file)
        numindex = file.index(number)
        head = file[:numindex]
        tail = file[numindex+len(number):]
        alist.append([head, number, tail])
    alist = sorted(alist, key=lambda x: (x[0].lower(),int(x[1])))
    alist = ["".join(f) for f in alist]
    return alist