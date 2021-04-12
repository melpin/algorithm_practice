from itertools import *

def calc(com, n, exp):
    if n == 2:
        return str(eval(exp))
    return str(eval("{}".format(com[n]).join(calc(com,n+1,e) for e in exp.split(com[n]))))
    
def solution(expression):
    sign = ["*","-","+"]
    ans = 0
    for com in permutations(sign):
        ans = max(ans, abs(int(calc(com,0, expression))))
    return ans

exp1 = "100-200*300-500+20"

print(solution(exp1))