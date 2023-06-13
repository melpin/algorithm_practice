import itertools
from collections import deque
from collections import defaultdict
import copy
mov_r = [0, 0, -1, 1] # right left up down
mov_c = [1, -1, 0, 0]

def outofblock(x, y):
    return x>3 or y>3 or x<0 or y<0

# bfs
def how_many_times(board, current_position, position_to_move): 
    # print(f'current_position, position_to_move : {current_position, position_to_move}')
    # input format : board, [1,0], [0,1]
    q = deque()
    new_current_position = current_position[:]
    new_current_position.append(0)
    q.append(new_current_position) # [1,0,0] 0-> move count

    while q:
        r, c, k = q.popleft()

        if r == position_to_move[0] and c == position_to_move[1]:
            # print(f'return value : {k}')
            return k

        for i in range(4):
            # without ctrl
            new_r = r + mov_r[i]
            new_c = c + mov_c[i]
            if not outofblock(new_r, new_c):
                q.append([new_r, new_c, k+1])

            # with ctrl
            flag = 0
            while(not outofblock(new_r, new_c) and board[new_r][new_c] == 0):
                flag = 1
                new_r += mov_r[i]
                new_c += mov_c[i]
                # print(f'newr, newc = {new_r, new_c}')
            if flag == 1:
                if outofblock(new_r, new_c):
                    q.append([new_r-mov_r[i], new_c-mov_c[i], k+1])
                else:
                    q.append([new_r, new_c, k+1])
    
    # not reachable
    return -1

def solution(board, r, c):
    # print(board)
    d = defaultdict(list)
    for i in range(4):
        for j in range(4):
            if board[i][j] != 0:
                d[board[i][j]].append([i,j])
    d = dict(d)
    card = d.keys()
    nPr = list(itertools.permutations(card, len(card)))

    answer_list = []
    for i in nPr:
        initp = [r,c]
        new_board1 = copy.deepcopy(board) # for A->B
        new_board2 = copy.deepcopy(board) # for B->A
        cnt = 0
        # print("-----------------------")
        # print(i)
        for j in i: 
            # print(f'initp : {initp}')
            # A->B
            time1 = how_many_times(new_board1, initp, d[j][0])
            new_board1[d[j][0][0]][d[j][0][1]] = 0
            time1 += how_many_times(new_board1, d[j][0], d[j][1])
            new_board1[d[j][1][0]][d[j][1][1]] = 0
            # B->A
            time2 = how_many_times(new_board2, initp, d[j][1])
            new_board2[d[j][1][0]][d[j][1][1]] = 0
            time2 += how_many_times(new_board2, d[j][1], d[j][0])
            new_board2[d[j][0][0]][d[j][0][1]] = 0
            # eventually new_board 1 and 2 are same
            if time1 <= time2:
                # print(f'time1 : {time1}, time2 : {time2}')
                # print(f'before cnt : {cnt}\n+= time1 :{time1+2}')
                cnt+=(time1+2)
                initp = d[j][1]
            else:
                # print(f'time1 : {time1}, time2 : {time2}')
                # print(f'before cnt : {cnt}\n+= time2 :{time2+2}')
                cnt+=(time2+2)
                initp = d[j][0]
        answer_list.append(cnt)
    # print(answer_list)
    return min(answer_list)