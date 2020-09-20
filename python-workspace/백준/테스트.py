def print_str_statistics(*text):
    count = 0
    for i in text:
        count += len(i)
    print("total length:", count)
    print("average length:", count / len(text))

    total = 0
    for i in text:
        total += int(i)
    print("average value:", total / len(text))


number_list = []
while True:
    s = input('Please give a number : ')
    if int(s) == 0:
        break
    else:
        number_list.append(s)
print_str_statistics(*number_list)
