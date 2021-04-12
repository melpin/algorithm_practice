mapr = 0
mapc = 0
boardmap = []
drr = [0, 1, 1]
dcr = [1, 0, 1]
drl = [0, 1, 1]
dcl = [-1,0,-1]
delchar = '0'

def rangecheck(r, c):
    global mapr, mapc
    if 0<= r < mapr and 0<= c < mapc:
        return True
    return False

def removeblock(r, c, character):
    global drr, dcr, boardmap, delchar
    rflag = True
    for dr, dc in zip(drr, dcr):
        if not rangecheck(r+dr,c+dc) or not boardmap[r+dr][c+dc] == character:
            rflag = False
            break
    # 오른쪽아래로 4칸성립되는지
    
    lflag = True
    if not rflag:
        for dr, dc in zip(drl, dcl):
            if not rangecheck(r+dr,c+dc) or not boardmap[r+dr][c+dc] == character:
                lflag = False
                break
    # 왼쪽아래로 4칸성립되는지
    if not lflag:
        return
    
    if rflag:
        deltar = drr
        deltac = dcr
    else:
        deltar = drl
        deltac = dcl

    boardmap[r][c] = delchar
    for dr, dc in zip(deltar, deltac):
        removeblock(r+dr, c+dc, character)
    
    for dr, dc in zip(deltar, deltac):
        boardmap[r+dr][c+dc] = delchar
    return True

def dropblock():
    global mapr, mapc, boardmap, delchar
    
    for c in range(mapc):
        swapR = -1
        for r in range(mapr -1, -1, -1):
            if boardmap[r][c] == delchar and swapR == -1:
                swapR = r
            elif boardmap[r][c] != delchar and swapR != -1:
                boardmap[swapR][c] = boardmap[r][c]
                boardmap[r][c] = delchar
                swapR-=1

def getzero():
    global boardmap, delchar
    cnt = 0
    for b in boardmap:
        for c in b:
            if c == delchar:
                cnt+=1
    return cnt

def solution(m, n, board):
    global mapr, mapc, boardmap, delchar
    mapr, mapc = m, n

    boardmap = [[c for c in line] for line in board]
    
    while True:
        flag = False
        for r in range(mapr):
            for c in range(mapc):
                if boardmap[r][c] != delchar and removeblock(r,c,boardmap[r][c]):
                    flag = True
        
        if flag:
            print("delete block")
            debug()
            dropblock()
            print("drop block")
            debug()
        else:
            break

    print("result")
    debug()
    print(getzero())

    return getzero()


def debug():
    global boardmap
    for b in boardmap:
        print(b)
    print()

m1 = 4
n1 = 5
board1 = ["CCBDE", "AAADE", "AAABF", "CCBBF"]

m2 = 6
n2 = 6
board2 = ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]

m3 = 6
n3 = 6
board3 = ["IIIIOO", 
          "IIIOOO", 
          "IIIOOI", 
          "IOOIII", 
          "OOOIII", 
          "OOIIII"] # 32

#solution(5,6, ["AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"]) #24
#solution(6,6, ["AABBEE", "AAAEEE", "VAAEEV", "AABBEE", "AACCEE", "VVCCEE"]) # 32
solution(m3,n3,board3) # 32