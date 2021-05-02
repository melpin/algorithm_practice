num = '0123456789ABCDEF'

def ntypenumber(n, types):
    divn, modn = n//types, n % types
    modn = num[modn]
    return ntypenumber(divn, types) + modn if divn else modn

def solution(n, t, m, p):
    answer = ''
    
    rnum = 0
    totalstring = ''
    
    while len(totalstring) < p + m * t:
        totalstring += str(ntypenumber(rnum, n))
        rnum += 1
    for i in range(t):
        answer += totalstring[p - 1 + i * m]
    return answer