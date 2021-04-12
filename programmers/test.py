mapr = 0
mapc = 0
boardmap = []
drl = [1, 0, 1]
dcl = [0, 1, 1]

def rangecheck(r, c):
    global mapr, mapc
    if 0<= r <= mapr and 0<= c <= mapc:
        return True
    return False

def removeblock(r, c, character):
    global drl, dcl, boardmap
    for dr, dc in zip(drl, dcl):
        if not (rangecheck(r+dr,c+dc) and boardmap[r+dr][c+dc] == character):
            return False
    
    for dr, dc in zip(drl, dcl):
        removeblock(r+dr, c+dc, character)
    
    for dr, dc in zip(drl, dcl):
        boardmap[r+dr][c+dc] = '0'
    boardmap[r][c] = 0
    return True

def solution(m, n, board):
    global mapr, mapc, boardmap
    mapr, mapc = m, n

    boardmap = [[c for c in line] for line in board]
    
    while True:
        flag = False
        for r in range(mapr):
            for c in range(mapc):
                if removeblock(r,c,boardmap[r][c]):
                    flag = True
        if flag:
            pass # drop down block
        else:
            break
        
    return 0

m = 4
n = 5
board = ["CCBDE", "AAADE", "AAABF", "CCBBF"]

solution(m,n,board)