package Programmers.Hash;

import com.sun.tools.javac.jvm.Gen;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Genre> hashMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!hashMap.containsKey(genres[i])) {
                hashMap.put(genres[i], new Genre());
            }
            hashMap.get(genres[i]).addMusic(i, plays[i]);
            hashMap.get(genres[i]).addTotalPlay(plays[i]);
        }
        hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(i -> i.getValue())
                .map(i -> i.musics)
                .forEach(Musics-> {
                    Musics.sort(Music::compareTo);
                    for (int i =0; i< 2; i++) {
                        if (!Musics.isEmpty()) {
                            answer.add(Musics.remove(0).idx);
                        }
                    }
                } );
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Genre implements Comparable<Genre>{
    int totalPlay;
    List<Music> musics;

    public Genre() {
        totalPlay = 0;
        musics = new ArrayList<>();
    }

    public void addMusic(int idx, int play) {
        musics.add(new Music(idx, play));
    }

    public void addTotalPlay(int play) {
        totalPlay += play;
    }

    @Override
    public int compareTo(Genre o) {
        if (this.totalPlay > o.totalPlay) {
            return -1;
        }
        return 1;
    }
}

class Music implements Comparable<Music> {
    int idx;
    int plays;

    public Music(int idx, int plays) {
        this.idx = idx;
        this.plays = plays;
    }

    @Override
    public int compareTo(Music o) {
        if (this. plays > o.plays) {
            return -1;
        } else if (this.plays == o.plays) {
            if (this.idx < o.idx) {
                return -1;
            }
        }
        return 1;
    }
}