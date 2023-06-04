def solution(enroll, referral, seller, amount):
    rootName = '-'
    dictTree = dict()
    dictTree[rootName] = ['', 0]
    
    for en, ref in zip(enroll, referral):
        dictTree[en] = [ref, 0]
    
    for sel, amount in zip(seller, amount):
        currentNode = sel
        currentAmount = amount * 100
        
        while currentNode != rootName:
            parent, currentSum = dictTree[currentNode]
            
            pay = currentAmount // 10
            currentAmount = currentAmount - pay   
            dictTree[currentNode] = [parent, currentSum + currentAmount]
            
            if pay == 0:
                break
            currentNode = parent
            currentAmount = pay
            
    answer = [dictTree[en][1] for en in enroll]
    return answer

'''
dict tree 로 구성해서 노드갯수 상관없게


현재 가지고 있는 값에다가 합산하는 방식으로 쭉 타고 올라감

필요한거

리프부터 타고올라와서 절사하면서 값을 계산해야함
자신의 금액, 자식들 자신의 부모가 누구인지?
셀러가 누구인지, 셀러부터 시작하면되는듯?


'''