import itertools

def solution(orders, course):
    answer = []
    dictlist = []
    
    for c in course:
        dictlist.append(dict())
    for o in orders:
        o = "".join(sorted(o))
        for c in range(len(course)):
            for m in itertools.combinations(o,course[c]):
                comb = "".join(m)
                if comb in dictlist[c]:
                    dictlist[c][comb] += 1
                else:
                    dictlist[c][comb] = 1
    for c in range(len(course)):
        if len(dictlist[c]) == 0:
            continue
        maxvalue = max(dictlist[c].values())
        if maxvalue == 1:
            continue
        answer.extend([k for k, v in dictlist[c].items() if v == maxvalue])
        
    return sorted(answer)