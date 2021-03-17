# programers pallendrom

def pallendrom(string):
    for i in range(0, int(len(string) / 2)):
        if string[i] != string[-1 - i]:
            return False
    return True

def solution(s):
    counter = []
    answer = 0
    
    ans = 0
    for i in range(len(s) + 1): # 1~ N pallendrom length check
        for stpos in range(len(s) - i + 1):
            if pallendrom(s[stpos: stpos+i]):
                ans = i
                break
    return ans

# station install

def solution(n, stations, w):
    ans = 0
    dif = w * 2 + 1
    cpos = 1
    for station in stations:
        left = station - w
        right = station + w
        
        if left <= cpos and cpos <= right:
            cpos = right + 1
            continue
    
        ans += (left - cpos) // dif
        if (left - cpos) % dif > 0:
            ans += 1
        cpos = right + 1
    
    if cpos < n:
        ans += (n - cpos) // dif
        if (n - cpos) % dif > 0:
            ans += 1
        
    return ans