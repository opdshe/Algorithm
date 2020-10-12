def solution(*args):
    if len(args) == 0:
        print("no input")
        return

    total_words = set()
    if args[len(args)-1] == "u" or args[len(args)-1] == "l":
        for idx in range(0, len(args) - 1):
            input_string = args[idx]
            if args[len(args) - 1] == "u":
                input_string = input_string.upper()
            elif args[len(args) - 1] == "l":
                input_string = input_string.lower()
            words = input_string.split(" ")
            for word in words:
                total_words.add(word)
    else:
        for input_string in args:
            words = input_string.split(" ")
            for word in words:
                total_words.add(word)

    total_words = sorted(total_words)
    print(total_words)


solution("my Name is", "your Name is")
solution("my Name is", "your Name is", "u")
solution("my Name is", "your Name is", "l")
