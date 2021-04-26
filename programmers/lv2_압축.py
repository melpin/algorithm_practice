def solution(msg):
    answer = []
    compdic = dict()
    
    for i in range(1, 27):
        compdic[chr(65+i - 1)] = i
    
    idx = 0
    nextnum = 27
    length = 0
    
    while True:
        length += 1
        if not msg[idx:idx+length] in compdic:
            answer.append(compdic[msg[idx:idx+length-1]])
            compdic[msg[idx:idx+length]] = nextnum
            nextnum += 1
            idx += length - 1
            length = 0
        else:
            if idx + length - 1 == len(msg):
                answer.append(compdic[msg[idx:idx+length-1]])
                # 마지막글자
                break
    return answer