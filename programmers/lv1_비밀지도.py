def solution(n, arr1, arr2):
    tmp = [i|j for i,j in zip(arr1, arr2)]
    print(bin(tmp[0])[2:])
    tmp = ['0'*(n-len(bin(i)[2:]))+ bin(i)[2:] for i in tmp]
    tmp = [i.replace('1','#').replace('0',' ') for i in tmp]
    
    return tmp