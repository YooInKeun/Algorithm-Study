def solution(arrangement):
    answer = 0
    stack = []
    my_dict = {}
    buffer = ''
    
    for el in arrangement:
        if(len(stack) == 0 and el == '('):
            stack.append(el)
        elif(buffer == '(' and el == '('):
            my_dict[len(my_dict) + 1] = 1
            stack.append(el)
        elif(buffer == '(' and el == ')'):
            stack.pop()
            answer += len(my_dict)
        elif(stack[len(stack) - 1] == '(' and el == ')'):
            answer += my_dict[len(my_dict)]
            del my_dict[len(my_dict)]
        else:
            stack.append(el)
        buffer = el

    return answer