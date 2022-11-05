package unit;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class BaseBallGame {	
	private static ArrayList<Integer> randomNumbers;
	private static ArrayList<Integer> userInputNumbers;
	
	public static void startGame(Scanner scanner) {
		while(true) {
			System.out.println("숫자 야구 게임을 시작합니다.");
			baseBallGame(scanner);
			break;
		}
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
		
	}
	
	public static boolean baseBallGame(Scanner scanner) {
		while(true) {
			System.out.println("숫자를 입력해 주세요 : ");
			int inputNum = scanner.nextInt();
			userInputNumbers = makeUserInputNumbers(inputNum);
			checkIllegalInput(userInputNumbers);
			compare();
			break;
		}
		return true;
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

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		randomNumbers = makeRandomNumbers();
		startGame(scanner);
	}
}

