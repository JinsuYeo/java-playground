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
		}
	}
	
	public static boolean baseBallGame(Scanner scanner) {
		while(true) {
			
		}
	}
	
	private static boolean isDuplicated(ArrayList<Integer> randomNumbers, int randomNumber) {
		if(randomNumber == 0) return true;
		ArrayList<Integer> randomNumbersNotAddedRandomNumber = randomNumbers;
		randomNumbers.add(randomNumber);
		if(randomNumbersNotAddedRandomNumber.size() == randomNumbers.stream().distinct().count()) {
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

