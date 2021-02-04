def solution(new_id):
    answer = ''
    
    for i in range(len(new_id)):
        if 'A' <= new_id[i] and new_id[i]<= 'Z':
            answer += chr(ord(new_id[i]) + 32)
        elif ('0' <= new_id[i] and new_id[i] <= '9') :
            answer += new_id[i]
        elif ('a' <= new_id[i] and new_id[i]<= 'z') :
            answer += new_id[i]
        elif new_id[i] == '-' or new_id[i] == '_' or new_id[i] == '.':
            answer += new_id[i]
    # level 1, 2
    
    while answer.find("..") > -1:
        answer = answer.replace("..", ".")
    # level 3
    
    if len(answer) >0 and answer[0] == '.':
        answer = answer[1:]
    if len(answer) >0 and answer[-1] == ".":
        answer = answer[:-1]
    # level 4
    
    if answer == "":
        answer = "a"
    # level 5
    
    if len(answer) > 15:
        answer = answer[:15]
        if answer[-1] == ".":
            answer = answer[: -1]
    # level 6
    
    while len(answer) < 3:
        answer = answer + answer[-1]
    # level 7
        
    print(answer) 
    
    
    return answer

id1 = "...!@BaT#*..y.abcdefghijklm"
id2= "z-+.^."
id3="=.="
id4="123_.def"
id5="abcdefghijklmn.p"
a=solution(id3)
print(a)
