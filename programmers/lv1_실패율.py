def solution(N, stages):
    answer = []
    stage_count = [0] * (N + 2)
    sum_arr = [0]
    percent_arr = []
    
    for i in stages:
        stage_count[i] += 1
    # count stage clear
    
    for i in range(1, N + 2):
        sum_arr.append(stage_count[i] +sum_arr[i-1])
    
    #print(sum_arr)
    
    for i in range(1, N + 1):
        numerator = sum_arr[i] - sum_arr[i-1]
        denominator = sum_arr[-1] - sum_arr[i-1]
        if numerator == 0:
            percent_arr.append(0)
        else:
            percent_arr.append(numerator / denominator)
    sort_arr = sorted(enumerate(percent_arr), key=lambda arr: (-arr[1],arr[0]))
    answer = [i[0] + 1 for i in sort_arr]
    
    return answer