package 기출.NHN;

import java.util.*;

public class 일번 {
	static Set<Character> faster = new HashSet<>();
	static Map<Character, Integer> map = new HashMap<>();

	private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {
		char[] seat = new char[numOfAllPlayers - 1];
		for (char namesOfQuickPlayer : namesOfQuickPlayers) {
			faster.add(namesOfQuickPlayer);
		}
		for (int idx = 65; idx < 65 + numOfAllPlayers; idx++) {
			map.put((char) idx, 0);
		}
		for (int idx = 0; idx < numOfAllPlayers - 1; idx++) {
			seat[idx] = (char) (idx + 66);
		}
		map.put('A', 1);
		char currentSul = 'A';
		int currentIdx = 0;
		for (int game = 0; game < numOfGames; game++) {
			int moveOffset = numOfMovesPerGame[game];
			int nextIdx;
			if (moveOffset >= 0) {
				nextIdx = (currentIdx + moveOffset) % (numOfAllPlayers - 1);
			} else {
				nextIdx = (currentIdx + (numOfAllPlayers - 1) - (-moveOffset)) % (numOfAllPlayers - 1);
			}
			if (faster.contains(seat[nextIdx])) {
				Integer integer = map.get(currentSul);
				integer++;
				map.put(currentSul, integer);
			} else {
				char prev = seat[nextIdx];
				seat[nextIdx] = currentSul;
				currentSul = prev;
				Integer integer = map.get(currentSul);
				integer++;
				map.put(currentSul, integer);
			}
			currentIdx = nextIdx;
		}
		for (int idx = 0; idx < numOfAllPlayers - 1; idx++) {
			System.out.println(seat[idx] + " " + map.get(seat[idx]));
		}
		System.out.println(currentSul + " " + map.get(currentSul));
	}

	private static class InputData {
		int numOfAllPlayers;
		int numOfQuickPlayers;
		char[] namesOfQuickPlayers;
		int numOfGames;
		int[] numOfMovesPerGame;
	}

	private static InputData processStdin() {
		InputData inputData = new InputData();

		try (Scanner scanner = new Scanner(System.in)) {
			inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

			inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
			System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

			inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
			inputData.numOfMovesPerGame = new int[inputData.numOfGames];
			String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
			for (int i = 0; i < inputData.numOfGames; i++) {
				inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
			}
		} catch (Exception e) {
			throw e;
		}

		return inputData;
	}

	public static void main(String[] args) throws Exception {
		InputData inputData = processStdin();

		solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
	}

}
