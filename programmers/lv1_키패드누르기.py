def solution(numbers, hand):
    answer = ''
    
    lhand = [3,0]
    rhand = [3,2]
    
    if hand == "left":
        h = "L"
    else:
        h = "R"
    
    lgroup = [1,4,7]
    rgroup = [3,6,9]
    
    positions = {}
    cnt = 1
    for i in range(3):
        for j in range(3):
            positions[cnt] = [i,j]
            cnt += 1
    positions[0] = [3,1]
    
    #abs
    
    for number in numbers:
        if number in lgroup:
            answer += "L"
            lhand = positions[number]
        elif number in rgroup:
            answer += "R"
            rhand = positions[number]
        else:
            target = positions[number]
            ldistance = abs(target[0] - lhand[0]) + abs(target[1] - lhand[1])
            rdistance = abs(target[0] - rhand[0]) + abs(target[1] - rhand[1])
            if h == "L":
                if ldistance <= rdistance:
                    answer += "L"
                    lhand = positions[number]
                else:
                    answer += "R"
                    rhand = positions[number]
            elif h == "R":
                if ldistance >= rdistance:
                    answer += "R"
                    rhand = positions[number]
                else:
                    answer += "L"
                    lhand = positions[number]
        

    return answer