def replacemelody(melody):
    melody = melody.replace("C#", "H")
    melody = melody.replace("D#", "I")
    melody = melody.replace("F#", "J")
    melody = melody.replace("G#", "K")
    melody = melody.replace("A#", "L")
    return melody

def getfullmelody(melody, runtime):
    return melody * (runtime // len(melody)) + melody[0:runtime%len(melody)]

def getminute(time):
    hour, minute = time.split(":")
    return int(hour) * 60 + int(minute)

def getruntime(stt, endt):
    return getminute(endt) - getminute(stt)

def solution(m, musicinfos):
    m = replacemelody(m)
    resultdict = dict()
    result = ''
    
    for musicinfo in musicinfos:
        stt, endt, title, melody = musicinfo.split(",")
        runtime = getruntime(stt, endt)
        melody = replacemelody(melody)
        melody = getfullmelody(melody,runtime)
        resultdict[melody] = title

    for melody in resultdict.keys():
        print(melody)
        if m in melody:
            if result == '':
                result = melody
            else:
                if len(result) < len(melody):
                    result = melody
    if result == '':
        return "(None)"

    return resultdict[result]