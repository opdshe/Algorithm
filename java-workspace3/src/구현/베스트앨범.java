package 구현;

import java.util.*;
import java.util.stream.Collectors;

public class 베스트앨범 {
	static Map<String, Integer> countMap = new HashMap<>();
	static Map<String, List<Music>> musics = new HashMap<>();
	static List<Integer> answers = new ArrayList<>();

	public int[] solution(String[] genres, int[] plays) {
		for (int idx = 0; idx < genres.length; idx++) {
			Integer count = countMap.getOrDefault(genres[idx], 0);
			count += plays[idx];
			countMap.put(genres[idx], count);

			List<Music> musicList = musics.getOrDefault(genres[idx], new ArrayList<>());
			musicList.add(new Music(idx, plays[idx]));
			musics.put(genres[idx], musicList);
		}
		List<Map.Entry<String, Integer>> sortedGenre = countMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toList());
		Collections.reverse(sortedGenre);
		for (Map.Entry<String, Integer> entry : sortedGenre) {
			musics.get(entry.getKey()).stream()
					.sorted(new MyComparator())
					.limit(2)
					.forEach(music -> answers.add(music.idx));
		}

		return answers.stream()
				.mapToInt(Integer::valueOf)
				.toArray();
	}

	private static class MyComparator implements Comparator<Music> {

		@Override
		public int compare(Music o1, Music o2) {
			if (o1.play > o2.play) {
				return -1;
			} else if (o1.play == o2.play) {
				if (o1.idx < o2.idx) {
					return -1;
				}
			}
			return 1;
		}
	}


	private static class Music {
		int idx;
		int play;

		public Music(int idx, int play) {
			this.idx = idx;
			this.play = play;
		}
	}
}
