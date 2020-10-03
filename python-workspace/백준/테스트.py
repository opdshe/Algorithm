input_string = input()
edited_string = "*" + input_string + "*"
for idx in range(len(edited_string)):
    if idx == 0 or idx == 1 or idx == len(edited_string) - 1 or idx == len(edited_string) - 2:
        print(edited_string[idx], end='')
    else:
        print(" ", end='')
