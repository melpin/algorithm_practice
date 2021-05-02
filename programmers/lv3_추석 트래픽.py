from datetime import datetime, timedelta

def solution(lines):
    fulltimeline = []
    ziptimeline = []
    for line in lines:
        date, time, T = line.split(" ")
        Y, M, D = date.split("-")
        h, m, s =  time.split(":")
        s, ms = s.split(".")
        T = T.replace("s", "")
        sT = T
        msT = 0
        if "." in T:
            sT, msT = T.split(".")
        Y, M, D, h, m, s, ms, sT, msT = int(Y), int(M), int(D), int(h), int(m), int(s), int(ms), int(sT), int(msT)
        ms, msT = ms * 1000, (msT-1) * 1000
        T = timedelta(seconds=sT, microseconds=msT)
        end = datetime(Y,M,D,h,m,s,ms)
        start = end - T
        fulltimeline.append(start)
        fulltimeline.append(end)
        ziptimeline.append([start,end])
    
    ans = 0
    for start in fulltimeline:
        cnt = 0
        end = start + timedelta(seconds=1)
        for ziptime in ziptimeline:
            if start <= ziptime[0] and ziptime[0] < end:
                cnt+=1
            elif start <= ziptime[1] and ziptime[1] < end:
                cnt+=1
            elif ziptime[0] <= start and end < ziptime[1]:
                cnt+=1
        ans = max(ans,cnt)
        
    return ans