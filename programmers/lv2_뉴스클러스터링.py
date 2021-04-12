from collections import Counter

def splitstring(str):
    str = str.lower()
    r = []
    for i in range(0, len(str)-1):
        tmp = str[i:i+2]
        if tmp.isalpha():
            r.append(tmp)
    return r

def solution(str1, str2):
    splitstr1 = splitstring(str1)
    splitstr2 = splitstring(str2)
    
    str1conuter = Counter(splitstr1)
    str2conuter = Counter(splitstr2)
    
    str1set = set(str1conuter)
    str2set = set(str2conuter)
    
    interval = 0
    for split in str1set.intersection(str2set):
        interval += min(str1conuter[split], str2conuter[split])
    
    unionval = 0
    for split in str1set.union(str2set):
        unionval += max(str1conuter[split], str2conuter[split])
    
    
    if interval == 0 and  unionval == 0:
        interval = 1
        unionval = 1
    return int((interval / unionval) * 65536)