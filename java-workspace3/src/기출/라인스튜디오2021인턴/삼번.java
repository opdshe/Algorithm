package 기출.라인스튜디오2021인턴;

import java.util.*;

public class 삼번 {
	static Map<String, Integer> cookingTime = new HashMap<>();
	static List<Machine> machines = new ArrayList<>();
	static List<Menu> menus = new ArrayList<>();

	public static void main(String[] args) {
		solution(3, new String[]{"SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8"},
				new String[]{"PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8"});
	}

	public static long solution(int n, String[] recipes, String[] orders) {
		for (String recipe : recipes) {
			String[] split = recipe.split(" ");
			cookingTime.put(split[0], Integer.parseInt(split[1]));
		}
		for (String order : orders) {
			String[] split = order.split(" ");
			menus.add(new Menu(split[0], Integer.parseInt(split[1])));
		}
		for (int i = 0; i < n; i++) {
			machines.add(new Machine());
		}
		long answer = -1;
		while (!menus.isEmpty()) {
			machines.sort(Comparator.comparing(machine -> machine.endTime));
			Menu next = menus.get(0);
			Machine availableMachine = null;
			for (Machine machine : machines) {
				if (machine.endTime <= next.orderTime) {
					availableMachine = machine;
					break;
				}
			}
			if (availableMachine != null) {
				availableMachine.endTime = next.orderTime + cookingTime.get(next.name);
				if (menus.size() == 1) {
					answer = availableMachine.endTime;
				}
			} else {
				Machine machine = machines.get(0);
				machine.endTime += cookingTime.get(next.name);
				if (menus.size() == 1) {
					answer = machine.endTime;
				}
			}
			menus.remove(next);
		}
		//System.out.println(answer);
		return answer;
	}

	private static class Machine {
		long endTime;
	}

	private static class Menu {
		String name;
		long orderTime;

		public Menu(String name, int orderTime) {
			this.name = name;
			this.orderTime = orderTime;
		}
	}
}
