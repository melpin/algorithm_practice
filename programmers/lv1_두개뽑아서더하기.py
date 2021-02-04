def solution(numbers):
    ans = set()
    for i in range(len(numbers)):
        for j in range(len(numbers)):
            if i == j:
                continue
            ans.add(numbers[i] + numbers[j])
    ans = list(ans)
    ans.sort()
    
    return ans