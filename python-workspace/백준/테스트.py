이름 = input("이름을 입력하세요. ")
평점 = float(input("평균 학점을 입력하세요. :"))
C학점 = int(input("C 학점의 개수를 입력하세요. :"))
토익 = int(input("토익 점수를 입력하세요. : "))

결과 = True
if C학점 >= 3 and 평점 <= 3.5:
    결과 = False
    if 토익 >= 950:
        결과 = True
print(이름 + " 지원자는  서류 평과 결과가 " + str(결과) + " 입니다.")
