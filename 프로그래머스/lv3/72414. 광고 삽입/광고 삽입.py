def timetosec(time):
    hour, mint, sec = time.split(":")
    return int(hour)*60*60 + int(mint)*60 + int(sec)

def sectotime(time):
    sec = time % 60
    time //= 60
    mint = time % 60
    hour = time // 60
    return str(hour).zfill(2)+":"+str(mint).zfill(2)+":"+str(sec).zfill(2)


#마지막 for문 실행 시 adv_time_s-1 

def solution(play_time, adv_time, logs):
    ptime = timetosec(play_time)
    timelist = [0] * (ptime+1)
    
    for log in logs:
        sttime, endtime = log.split("-")
        timelist[timetosec(sttime)] += 1
        timelist[timetosec(endtime)] -= 1
    
    for t in range(1, ptime):
        timelist[t] += timelist[t-1]
    
    for t in range(1, ptime):
        timelist[t] += timelist[t-1]
        
    at = timetosec(adv_time)
    maxsum = 0
    saveat = 0
    for t in range(at-1, ptime):
        if maxsum < timelist[t] - timelist[t - at]:
            maxsum = timelist[t] - timelist[t - at]
            saveat = t - at+1
    
    return sectotime(saveat)