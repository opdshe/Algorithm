package 기출.카카오.카카오상반기2020;

public class 자물쇠와열쇠 {
	static int keySize;
	static int lockSize;

	public static void main(String[] args) {
		solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
	}

	public static boolean solution(int[][] key, int[][] lock) {
		keySize = key.length;
		lockSize = lock.length;
		int[][] map = new int[keySize * 2 + lockSize][keySize * 2 + lockSize];
		for (int height = 0; height < lockSize; height++) {
			for (int width = 0; width < lockSize; width++) {
				map[height + keySize][width + keySize] = lock[height][width];
			}
		}
		boolean result = search(map, key);
		System.out.println(result);
		return result;
	}

	private static boolean search(int[][] map, int[][] key) {
		int count = 0;
		int[][] rotatedKey = deepCopy(key);
		while (count < 4) {
			for (int heightStart = 0; heightStart < map.length - key.length; heightStart++) {
				for (int widthStart = 0; widthStart < map[0].length - key.length; widthStart++) {
					int[][] cloneMap = deepCopy(map);
					for (int keyHeight = 0; keyHeight < key.length; keyHeight++) {
						for (int keyWidth = 0; keyWidth < key.length; keyWidth++) {
							cloneMap[heightStart + keyHeight][widthStart + keyWidth] += rotatedKey[keyHeight][keyWidth];
						}
					}

					if (check(cloneMap)) {
						return true;
					}
				}
			}
			rotatedKey = rotate(rotatedKey);
			count++;
		}
		return false;
	}

	private static boolean check(int[][] map) {
		for (int height = keySize; height < keySize + lockSize; height++) {
			for (int width = keySize; width < keySize + lockSize; width++) {
				if (map[height][width] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	static int[][] rotate(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int[][] rotate = new int[m][n];

		for (int i = 0; i < rotate.length; i++) {
			for (int j = 0; j < rotate[i].length; j++) {
				rotate[i][j] = arr[n - 1 - j][i];
			}
		}
		return rotate;
	}

	private static int[][] deepCopy(int[][] origin) {
		if (origin == null) return null;
		int[][] result = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
		}
		return result;
	}
}
