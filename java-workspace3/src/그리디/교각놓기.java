package 그리디;

import java.util.*;

public class 교각놓기 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int countOfBridge = scanner.nextInt();
        List<Bridge> bridges = new ArrayList<>();
        for (int idx = 0; idx < countOfBridge; idx++) {
            int y = scanner.nextInt();
            int x1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            bridges.add(new Bridge(y, x1, x2));
        }
        bridges.sort(Comparator.comparing(bridge -> bridge.y));
        Collections.reverse(bridges);
        int sum = 0;
        for (int idx = 0; idx < countOfBridge; idx++) {
            Bridge current = bridges.get(idx);
            int left = current.y;
            int right = current.y;
            for (int compare = idx + 1; compare < countOfBridge; compare++) {
                Bridge compareTarget = bridges.get(compare);
                if (current.isUnderLeftBridge(compareTarget)) {
                    left = current.y - compareTarget.y;
                    break;
                }
            }
            for (int compare = idx + 1; compare < countOfBridge; compare++) {
                Bridge compareTarget = bridges.get(compare);
                if (current.isUnderRightBridge(compareTarget)) {
                    right = current.y - compareTarget.y;
                    break;
                }
            }
            sum += left + right;
        }
        System.out.println(sum);
    }

    private static class Bridge {
        int y;
        int x1;
        int x2;

        public Bridge(int y, int x1, int x2) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
        }

        private boolean isUnderLeftBridge(Bridge compare) {
            return (x1 + 0.5) > compare.x1 && (x1 + 0.5) < compare.x2;
        }

        private boolean isUnderRightBridge(Bridge compare) {
            return (x2 - 0.5) > compare.x1 && (x2 - 0.5) < compare.x2;
        }
    }
}
