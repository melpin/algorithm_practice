def solution(participant, completion):
    answer = ''
    participant = sorted(participant)
    completion = sorted(completion)
    
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            return participant[i]
    return participant.pop()