from collections import defaultdict

def makeTree(links):
    dictTree = defaultdict(list)

    for a, b in links:
        dictTree[a].append(b)

    return dictTree

def dfs(node, dictTree, dp):
    if not dictTree[node]:
        return

    leafCnt, zero_cnt, min_val, min_diff = 0, 0, 0, float('inf')
    for leaf in dictTree[node]:
        dfs(leaf, dictTree, dp)
        min_val += min(dp[leaf])
        leafCnt += 1

        # 주의할 점은, 평균 매출값 sales[node]가 0일 때가 존재한다.
        # DP[node][0] == DP[node][1]인 예외상황이 발생할 수 있으므로,
        # 확실히 DP[node][0] < DP[node][1]일 때만 체크하도록 한다.
        if dp[leaf][0] < dp[leaf][1]:
            zero_cnt += 1
            min_diff = min(min_diff, dp[leaf][1] - dp[leaf][0])

    dp[node][1] += min_val
    dp[node][0] += min_val + min_diff if leafCnt == zero_cnt else min_val

def solution(sales, links):
    # 초기화
    dp = [[0, 0]] + [[0, sale] for sale in sales]

    dictTree = makeTree(links)
    dfs(1, dictTree, dp)
    return min(dp[1]) # ceo 기준으로 가장 작은값이 닶