package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import dao.BaseballDAO;

public class MainClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BaseballDAO dao = new BaseballDAO();
		
		while (true) {
			System.out.println();
			System.out.println("=== 야구 프로그램 ===");
			System.out.println();
			System.out.println("1. 선수정보 추가");
			System.out.println("2. 선수정보 삭제");
			System.out.println("3. 선수정보 검색");
			System.out.println("4. 선수정보 수정");
			System.out.println("5. 선수정보 전체출력");
			System.out.println("6. 타율 순위");
			System.out.println("7. 방어율 순위");
			System.out.println("8. 파일 저장");
			System.out.println("9. 파일불러오기");
			System.out.println();
			System.out.print("원하시는 메뉴의 번호를 입력하세요 >> ");
			
			int menuNum = 0;
			try {
				menuNum = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
				scanner.next(); //버퍼에 남아있는 잘못된 입력제거
				continue;
			}
			
			switch (menuNum) {
				case 1: //선수정보입력
					dao.insert();
					dao.allData();
					break;
				case 2: //선수정보삭제
					dao.delete();
					dao.allData();
					break;
				case 3: //선수정보검색
					dao.select();
					dao.allData();
					break;
				case 4: //선수정보수정
					dao.update();
					dao.allData();
					break;
				case 5: //선수정보 모두출력
					dao.allData();
					break;
				case 6: //타율순위
					dao.battingSort();
					break;
				case 7: //방어율순위 - 낮을수록 좋음
					dao.pitcherSort();
					break;
				case 8: //파일 저장
					dao.save();
					break;
				case 9: //파일 불러오기
					System.out.println("기존의 데이터가 날아갈 수 있습니다. 계속하시겠습니까? (0입력시 취소)");
					char flag = scanner.next().charAt(0);
					if(flag == '0') {
						break;
					}else {
						dao.load();
						dao.allData();
						break;
					}
				default:
					break;
				}
		}
	}
}
