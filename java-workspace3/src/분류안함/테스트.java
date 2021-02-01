package 분류안함;

import java.util.*;
import java.util.stream.Collectors;

public class 테스트 {
    public static void main(String[] args) {
        List<Music> musics = new ArrayList<>();
        musics.add(new Music(0, 500, "rock"));
        musics.add(new Music(1, 100, "hiphop"));
        musics.add(new Music(2, 200, "rock"));
        musics.add(new Music(3, 400, "hiphop"));
        musics.add(new Music(4, 600, "rock"));
        musics.add(new Music(5, 100, "ballad"));

        Map<String, List<Music>> group = musics.stream()
                .collect(Collectors.groupingBy(music -> music.genre));
        Set<Character> sets = new HashSet<>();
    }

    private static class Music {
        int idx;
        int play;
        String genre;

        public Music(int idx, int play, String genre) {
            this.idx = idx;
            this.play = play;
            this.genre = genre;
        }
    }
}
