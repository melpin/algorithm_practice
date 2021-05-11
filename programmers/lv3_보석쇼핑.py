def solution(gems):
    types = len(set(gems))
    length = len(gems)
    answer =[]
    l = 0
    r = 0
    ansl = 0
    ansr = length - 1
    
    current = {gems[0]:1}
    while l < length and r < length:
        if len(current) < types:
            r += 1
            if r == length:
                break
            current[gems[r]] = current.get(gems[r],0) + 1
        else:
            answer.append((r - l, [l+1, r+1]))
            current[gems[l]] -= 1
            if current[gems[l]] == 0:
                del current[gems[l]]
            l += 1
    
    answer = sorted(answer, key=lambda x: (x[0], x[1]))
    return answer[0][1]