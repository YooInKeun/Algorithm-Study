def solution(cookie):
    answer = -1
    newCookie = []
    newCookieList = []
    sumItem = 0
    loopFlag = True

    # dynamic programming
    # newCookieList에 누적된 값 저장
    for i in range(len(cookie)):
        for j in range(i):
            newCookie.append(0)
        for k in range(i, len(cookie)):
            sumItem += cookie[k]
            newCookie.append(sumItem)
        newCookieList.append(newCookie)
        sumItem = 0
        newCookie = []
    
    for i in range(1, len(newCookieList)):
        for j in range(len(newCookieList)-1, i-1, -1):
            # 최대값을 구하기 때문에 현재 answer보다 작으면 순회 필요 없음(시간복잡도면에서 중요)
            if(newCookieList[i][j] > answer):
                for k in range(0, i):
                    # newCookieList[i][j] 값은 정렬된 형태기 때문에 newCookieList[k][i-1]보다 작으면 순회 필요 없음(시간복잡도면에서 중요)
                    if(newCookieList[k][i-1] < newCookieList[i][j]):
                        break
                    if(newCookieList[i][j] == newCookieList[k][i-1]):
                        if(answer < newCookieList[i][j]):
                            answer = newCookieList[i][j]
    
    if(answer == -1):
        answer = 0
    return answer