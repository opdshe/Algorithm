class TV:  # TV 클래스
    MIN_VOLUME = 0
    MAX_VOLUME = 20
    MIN_CHANNEL = 0
    MAX_CHANNEL = 200

    def __init__(self):
        self.__volume = 5
        self.__channel = 0
        self.__is_on = False  # 꺼짐 상태...?

    def __str__(self):
        if self.__is_on == False:
            return 'TV가 꺼짐 상태입니다'
        return '볼륨 = {}, 채널 = {}'.format(self.get_volume(), self.get_channel())

    def toggle_power(self):
        if self.__is_on == True:
            self.__is_on = False
        elif self.__is_on == False:
            self.__is_on = True

    def get_channel(self):
        return self.__channel

    def set_channel(self, choice):
        self.__channel = choice
        if choice > TV.MAX_CHANNEL or choice < TV.MIN_CHANNEL:
            print('채널 오류')

    def get_volume(self):
        return self.__volume

    def set_volume(self, choice):
        self.__volume = choice
        if choice > TV.MAX_VOLUME or choice < TV.MIN_VOLUME:
            print('볼륨 오류')

    def volume_up(self):
        if self.__volume <= TV.MAX_VOLUME:
            self.__volume += 1

    def volume_down(self):
        if self.__volume >= TV.MIN_VOLUME:
            self.__volume -= 1

    def channel_up(self):
        if self.__channel <= TV.MAX_CHANNEL:
            self.__channel += 1

    def channel_down(self):
        if self.__channel >= TV.MIN_CHANNEL:
            self.__channel -= 1


my_tv = TV()  # my_tv 인스턴스 생성
print(my_tv)
my_tv.toggle_power()  # my_tv의 전원을 켬(디폴트 채널은 0, 볼륨은 5)
print(my_tv)
my_tv.set_channel(45)  # 채널을 45번으로 설정함
print(my_tv)
my_tv.volume_up()  # 볼륨을 올림, 볼륨 값은 6이 됨
my_tv.channel_up()  # 채널도 올림, 채널 값은 46이 됨
print(my_tv)
