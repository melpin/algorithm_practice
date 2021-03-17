def solution(dartResult):
    before = 0
    arr = []
    count = 0
    
    for i in range(len(dartResult)):
        if count == 2:
            arr.append(dartResult[before:])
            break
        if dartResult[i] == 'S' or dartResult[i] == 'D' or dartResult[i] == 'T':
            if dartResult[i+1] == '*' or dartResult[i+1] == '#':
                arr.append(dartResult[before:i+2])
                before = i + 2
            else:
                arr.append(dartResult[before:i+1])
                before = i + 1
            count += 1
    
    result =[0,0,0]
    for result_idx in range(len(result)):
        for idx in range(len(arr[result_idx])):
            if arr[result_idx][idx] == 'S' or arr[result_idx][idx] == 'D' or arr[result_idx][idx] == 'T':
                result[result_idx] = int(arr[result_idx][0:idx])
            if arr[result_idx][idx] == 'D':
                result[result_idx] = result[result_idx] ** 2
            elif arr[result_idx][idx] == 'T':
                result[result_idx] = result[result_idx] ** 3
                
        if '*' in arr[result_idx]:
            result[result_idx] *= 2
            if result_idx != 0:
                result[result_idx-1] *= 2
        elif '#' in arr[result_idx]:
            result[result_idx] *= -1
    
    
    return sum(result)