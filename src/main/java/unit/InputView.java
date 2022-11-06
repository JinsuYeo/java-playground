package unit;

import static unit.ResultView.exit;

import java.util.Scanner;
import static unit.BaseBallGame.*;

public class InputView {
	static boolean restartOrExit(Scanner scanner) {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int input = scanner.nextInt();
		if(input == 1) return true;
		if(input == 2) return false;
		exit();
		return false;
	}
	
	static void printOutResult() {
		if(!hasStrike() && !hasBall()) {
			System.out.println("낫싱");
			return;
		}
		if(hasStrike() && hasBall()) {
			System.out.printf("%d볼 %d스트라이크\n", ball, strike);
			return;
		}
		if(hasStrike() && !hasBall()) {
			System.out.printf("%d스트라이크\n", strike);
			return;
		} 
		if(hasBall() && !hasStrike()) {
			System.out.printf("%d볼\n", ball);
			return;
		}
	}
	
	static boolean hasStrike() {
		if(strike > 0) return true;
		else return false;
	}
	
	static boolean hasBall() {
		if(ball > 0) return true;
		else return false;
	}
	
	static boolean isThreeStrike() {
		if(strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}
}
