S = input()
T = input()

ans = 0
while len(S) != len(T):
	if T[-1] == "B":
		T = T[:-1][::-1]
	else:
		T = T[:-1]
	if T == S:
		ans = 1
		break
print(ans)