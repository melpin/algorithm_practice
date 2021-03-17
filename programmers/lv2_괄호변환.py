def balance(p):
    if p == "" or correct_check(p):
        return p
    # 1

    u=""
    v=""
    ans = ""
    for i in range(2, len(p)+1, 2):
        if balance_check(p[:i]):
            u = p[:i]
            v = p[i:]
            break

    #2
    
    if correct_check(u):
        ans = u + balance(v)
        #level 3
        #level 3-1
    else:
        ans += "(" # 4-1
        ans += balance(v) # 4-2
        ans += ")" # 4-3
        
        for c in u[1:-1]: #4-4-1
            if c=='(': 
                ans+=')'
            else: 
                ans+='('
            # 4-4-2
        
    return ans
        
def balance_check(p):
    s = 0
    
    for bk in p:
        if bk == '(':
            s+=1
        else:
            s -= 1
    if s == 0:
        return True
    else:
        return False


def correct_check(p):
    stack = []
    for bk in p:
        if bk == '(':
            stack.append(bk)
        elif bk == ')' and len(stack) != 0:
            stack.pop()
        else:
            return False
    return True
    

def solution(p):

    return balance(p)

p1 = "(()())()"
p2 = ")("
p3 = "()))((()"

print(solution(p1))
print(solution(p2))
print(solution(p3))
