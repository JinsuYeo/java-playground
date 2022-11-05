package unit;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class BaseBallGame {
	private static ArrayList<Integer> randomNumbers = new ArrayList<>(); 
	private static ArrayList<Integer> userInputNumbers = new ArrayList<>();
	
	public static void startGame(Scanner scanner) {
		while(true) {
			System.out.println("숫자 야구 게임을 시작합니다.");
			baseBallGame(scanner);
		}
	}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		startGame(scanner);
	}
}
