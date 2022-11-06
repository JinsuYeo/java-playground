package unit;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

import static unit.ResultView.*;
import static unit.InputView.*;

public class BaseBallGame {	
	static ArrayList<Integer> randomNumbers;
	static ArrayList<Integer> userInputNumbers;
	static int strike = 0;
	static int ball = 0;
	
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
		initBaseBallGame();
		while(!isThreeStrike()) {
			initBaseBallGame();
			System.out.print("숫자를 입력해 주세요 : ");
			int inputNum = scanner.nextInt();
			userInputNumbers = makeUserInputNumbers(inputNum);
			checkIllegalInput(userInputNumbers);
			compare();
			printOutResult();
		}
		restartGame = restartOrExit(scanner);
		return restartGame;
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
	
	static void compare() {
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

	@SuppressWarnings("unchecked")
	private static boolean isDuplicated(ArrayList<Integer> randomNumbers, int randomNumber) {
		if(randomNumber == 0) return true;
		ArrayList<Integer> randomNumbersAddedRandomNumber = (ArrayList<Integer>)randomNumbers.clone();
		randomNumbersAddedRandomNumber.add(randomNumber);
		if(randomNumbers.size() != randomNumbersAddedRandomNumber.stream().distinct().count()) {
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
		startGame(scanner);
	}
}

