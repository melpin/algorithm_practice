def init(DictTree, info, idx):
    if idx == 3:
        if info[idx] not in DictTree:
            DictTree[info[idx]] = list()
        DictTree[info[idx]].append(int(info[idx+1]))

        if '-' not in DictTree:
            DictTree['-'] = list()
        DictTree['-'].append(int(info[idx+1]))
        return

    if '-' not in DictTree:
        DictTree['-'] = dict()
    init(DictTree['-'], info, idx+1)

    if info[idx] not in DictTree:
        DictTree[info[idx]] = dict()
    init(DictTree[info[idx]], info, idx+1)

def lower_bound(arr, length, value):
    start = 0
    end = length
    while start < end:
        mid = (start + end) // 2
        if(arr[mid] < value):
            start = mid+1
        else:
            end = mid
    return end

def search(DictTree, query, idx):
    count = 0

    if idx == 3:
        if query[idx] in DictTree:
            numlist = DictTree[query[idx]]
            length = len(numlist)
            sNum = int(query[idx+1])
        return length - lower_bound(numlist, length, sNum)

    if query[idx] in DictTree:
        count = search(DictTree[query[idx]],query,idx+1)
    return count
    
def init_sort(DictTree,idx):
    if idx == 3:
        for k in DictTree.keys():
            DictTree[k].sort()
        return
    for k in DictTree.keys():
        init_sort(DictTree[k],idx+1)

def solution(info, query):
    tree = dict()
    answer = []
    for i in info:
        i = i.split(" ")
        init(tree,i,0)
    init_sort(tree,0)

    for q in query:
        q = q.split(" and ")
        q.extend(q.pop().split(" "))
        answer.append(search(tree,q,0))
        
    return answer

info = ["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"]
a=solution(info,query)
print(a)
# answer = 	[1, 1, 1, 1, 2, 4]