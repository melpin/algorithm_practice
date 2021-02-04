def solution(board, moves):
    tmp = [-1]
    answer = 0
    size = len(board)
    
    
    for i in moves:
        line = i - 1
        for j in range(size):
            if board[j][line] != 0:
                if tmp[-1] == board[j][line]:
                    tmp.pop()
                    answer += 2
                # same dolls check, and pop
                else:
                    tmp.append(board[j][line])
                board[j][line] = 0
                break
                #tmp array append
            #empty box pass
    return answer