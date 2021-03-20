package 기출.라인2021.퀄리티;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class 이번 {
	private static final String ALPHABETIC_PATTERN = "[a-zA-Z]*$";
	private static final String NUMERIC_PATTERN = "[0-9]*$";

	//flag_argument_type에 맞게 Predicate를 제공하는 변수
	private static final Map<String, Predicate<String>> rulesMapper = new HashMap<>();

	static {
		rulesMapper.put("STRING", (String flagArgument) -> Arrays.stream(flagArgument.split(" "))
				.allMatch((String flagArg) -> flagArg.matches(ALPHABETIC_PATTERN) &&
						flagArgument.split(" ").length == 1));
		rulesMapper.put("STRINGS", (String flagArgument) -> Arrays.stream(flagArgument.split(" "))
				.allMatch((String flagArg) -> flagArg.matches(ALPHABETIC_PATTERN)) &&
				flagArgument.split(" ").length >= 1);
		rulesMapper.put("NUMBER", (String flagArgument) -> Arrays.stream(flagArgument.split(" "))
				.allMatch((String flagArg) -> flagArg.matches(NUMERIC_PATTERN) &&
						flagArgument.split(" ").length == 1));
		rulesMapper.put("NUMBERS", (String flagArgument) -> Arrays.stream(flagArgument.split(" "))
				.allMatch((String flagArg) -> flagArg.matches(NUMERIC_PATTERN)) &&
				flagArgument.split(" ").length >= 1);
		rulesMapper.put("NULL", Objects::isNull);
	}

	public static void main(String[] args) {
		solution("line", new String[]{"-s STRINGS", "-n NUMBERS", "-e NULL"},
				new String[]{"line -n 100 102 -s hi -e", "line -n id pwd -n 100"});
	}

	public static boolean[] solution(String program, String[] flagRules, String[] commands) {
		boolean[] answer = new boolean[commands.length];
		CommandValidator commandValidator = new CommandValidator(program, flagRules);
		for (int idx = 0; idx < commands.length; idx++) {
			answer[idx] = commandValidator.isValidCommand(commands[idx]);
			System.out.println(answer[idx]);
		}
		return answer;
	}

	//각 command를 확인하는 객체
	private static class CommandValidator {
		private final String program;
		private final Map<String, Predicate<String>> rules = new HashMap<>();

		public CommandValidator(String program, String[] flagRules) {
			this.program = program;
			initRules(flagRules);
		}

		private void initRules(String[] flagRules) {
			for (String flagRule : flagRules) {
				flagRule = flagRule.replaceAll("-", "");
				String[] flagRulePieces = flagRule.split(" ");
				String flagName = flagRulePieces[0];
				String flagArgType = flagRulePieces[1];
				rules.put(flagName, rulesMapper.get(flagArgType));
			}
		}

		// Program이 다른지 확인한 후, 각 flag들을 확인하는 함수
		// flag : ex) n 100, s hi
		private boolean isValidCommand(String command) {
			String[] commandSplitByHyphen = command.split("-");
			String program = commandSplitByHyphen[0].trim();
			if (!isValidProgram(program)) {
				return false;
			}
			for (int idx = 1; idx < commandSplitByHyphen.length; idx++) {
				String flag = commandSplitByHyphen[idx];
				if (!isValidFlag(flag)) {
					return false;
				}
			}
			return true;
		}

		private boolean isValidFlag(String flag) {
			String[] flagSplitBySpace = flag.split(" ");
			String flagArg = Arrays.stream(flagSplitBySpace)
					.skip(1)
					.collect(Collectors.joining(" "));
			if (flagArg.equals("")) {
				flagArg = null;
			}
			Predicate<String> rule = rules.get(flagSplitBySpace[0]);
			//지원하지 않는 flag는 flase반환
			if (rule == null) {
				return false;
			}
			return rule.test(flagArg);
		}

		private boolean isValidProgram(String program) {
			return program.equals(this.program);
		}
	}
}
