package unit;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class BaseBallGame {	
	private static ArrayList<Integer> randomNumbers;
	private static ArrayList<Integer> userInputNumbers;
	private static int strike = 0;
	private static int ball = 0;
	
	public static void initBaseBallGame() {
		userInputNumbers = null;
		strike = 0;
		ball = 0;
	}
	
	public static void startGame(Scanner scanner) {
		boolean restartGame = true;
		while(restartGame) {
			System.out.println("숫자 야구 게임을 시작합니다.");
			randomNumbers = makeRandomNumbers();
			restartGame = baseBallGame(scanner);
		}
	}

	public static boolean baseBallGame(Scanner scanner) {
		boolean restartGame = false;
		while(!isThreeStrike()) {
			System.out.print("숫자를 입력해 주세요 : ");
			int inputNum = scanner.nextInt();
			userInputNumbers = makeUserInputNumbers(inputNum);
			checkIllegalInput(userInputNumbers);
			compare();
			printOutResult();
			initBaseBallGame();
		}
		restartGame = restartOrExit(scanner);
		return restartGame;
	}

	private static boolean restartOrExit(Scanner scanner) {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int input = scanner.nextInt();
		if(input == 1) return true;
		if(input == 2) return false;
		exit();
		return false;
	}

	public static ArrayList<Integer> makeUserInputNumbers(int inputNum) {
		ArrayList<Integer> userInputNumbers = new ArrayList<>();
		int num = inputNum;
		while(num != 0) {
			userInputNumbers.add(0, num % 10);
			num /= 10;
		}
		return  userInputNumbers;
	}
	
	private static void compare() {
		for(int i = 0; i < 3; i++) {
			strikeOrBall(i);
		}
	}
	
	private static void strikeOrBall(int idx) {
		if(!isStrike(randomNumbers.get(idx), userInputNumbers.get(idx)))
			isBall(randomNumbers, userInputNumbers.get(idx));
	}

	
	private static boolean isStrike(Integer randomNum, Integer userInputNum) {
		if(randomNum == userInputNum) {
			strike++;
			return true;
		}
		return false;
	}

	private static void isBall(ArrayList<Integer> randomNumbers, Integer userInputNum) {
		if(randomNumbers.contains(userInputNum)) ball++;
	}

	private static void checkIllegalInput(ArrayList<Integer> userInputNumbers) {
		if(userInputNumbers.size() != userInputNumbers.stream().distinct().count()) exit();
		if(userInputNumbers.size() != 3 || userInputNumbers.contains(0)) exit();
	}
	
	public static void exit() {
		try{
			throw new IllegalArgumentException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean isDuplicated(ArrayList<Integer> randomNumbers, int randomNumber) {
		if(randomNumber == 0) return true;
		ArrayList<Integer> randomNumbersNotAddedRandomNumber = randomNumbers;
		randomNumbers.add(randomNumber);
		if(randomNumbersNotAddedRandomNumber.size() != randomNumbers.stream().distinct().count()) {
			return false;
		}
		return true;
	}
	
	private static int makeRandomNumber(ArrayList<Integer> randomNumbers) {
		Random random = new Random();
		int randomNumber = 0;
		while(isDuplicated(randomNumbers, randomNumber))
			randomNumber = 1 + random.nextInt(8);
		return randomNumber;
	}
	
	public static ArrayList<Integer> makeRandomNumbers() {
		ArrayList<Integer> randomNumbers = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			randomNumbers.add(makeRandomNumber(randomNumbers));
		}
		
		return randomNumbers;
	}
	
	private static void printOutResult() {
		if(strike == 0 && ball == 0) {
			System.out.println("낫싱");
			return;
		}
		
		if(strike > 0 && ball > 0) {
			System.out.printf("%d볼 %d스트라이크\n", ball, strike);
			return;
		}
		
		if(strike > 0 && ball == 0) {
			System.out.printf("%d스트라이크\n", strike);
			return;
		}
		
		if(ball > 0 && strike == 0) {
			System.out.printf("%d볼\n", ball);
			return;
		}
	}
	
	private static boolean isThreeStrike() {
		if(strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		startGame(scanner);
	}
}

