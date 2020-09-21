text = "오늘도 밥을 먹었다. 생각보다 맛이 없었다. 나는 배가 고프다"
longest_word = ''
for sentence in text.split("."):
    for word in sentence.strip().split(" "):
        if len(word) > len(longest_word):
            longest_word = word
print(longest_word)
