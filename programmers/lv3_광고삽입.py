def timetosec(time):
    hour, mint, sec = time.split(":")
    return int(hour)*60*60 + int(mint)*60 + int(sec)

def sectotime(time):
    sec = time % 60
    time //= 60
    mint = time % 60
    hour = time // 60
    return str(hour).zfill(2)+":"+str(mint).zfill(2)+":"+str(sec).zfill(2)


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
    for t in range(at, ptime):
        if maxsum < timelist[t] - timelist[t - at]:
            maxsum = timelist[t] - timelist[t - at]
            saveat = t - at+1
    
    return sectotime(saveat)

play_time = "02:03:55"
adv_time = "00:14:15"
logs = ["01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"]
#ans "01:30:59"
pt2="99:59:59"
adt2="25:00:00"
logs2=["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]

pt3="50:00:00"
adt3="50:00:00"
logs3=["15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"]
r1=solution(play_time, adv_time, logs)
r2=solution(pt2, adt2, logs2)
r3=solution(pt3, adt3, logs3)

print(r1,r2,r3)
