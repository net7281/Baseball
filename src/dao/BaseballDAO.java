package dao;

import java.util.InputMismatchException;
import java.util.Scanner;

import dto.BatterDTO;
import dto.HumanDTO;
import dto.PitcherDTO;

public class BaseballDAO implements BaseballDAOImpl{
	
	Scanner scanner = new Scanner(System.in);
	
	//학생 데이터 관리 배열
	private HumanDTO humanDTOs[];
	
	//배열 관리용 변수
	private int count;
	
	public BaseballDAO() {
		count = 0;
		humanDTOs = new HumanDTO[10]; //변수만 생성
	}

	@Override
	public void insert() { //선수정보입력
		System.out.println();
		System.out.println("선수정보 입력 ==========");
		System.out.println();
		
		int number;
		String name;
		int age;
		double height;
		int posNum = 0;
		
		try {
			System.out.print("번호 >> ");
			number = scanner.nextInt();
			int index = searchNum(number, humanDTOs);
			if(index != -1) {
				System.out.println(number + "는 이미 존재하는 번호입니다. 메뉴를 다시 선택해주세요.");
				return;
			}
			System.out.print("이름 >> ");
			name = scanner.next();
			System.out.print("나이 >> ");
			age = scanner.nextInt();
			System.out.print("신장 >> ");
			height = scanner.nextDouble();
			
			System.out.print("선수가 투수이면 1, 타자이면 2 를 입력해주세요 >> ");
			posNum = scanner.nextInt();
			
			if(posNum == 1) {
				String position = "투수";
				int win;
				int lose;
				double defence;
				
				System.out.print("승리횟수 >> ");
				win = scanner.nextInt();
				System.out.print("패배횟수 >> ");
				lose = scanner.nextInt();
				System.out.print("방어율 >> ");
				defence = scanner.nextDouble();
				
				humanDTOs[count] = new PitcherDTO(number, name, age, height, position, win, lose, defence);
				
			}else if(posNum == 2) {
				String position = "타자";
				int batcount;
				int hit;
				double hivAvg;
				
				System.out.print("타수 >> ");
				batcount = scanner.nextInt();
				System.out.print("안타 >> ");
				hit = scanner.nextInt();
				System.out.print("타율 >> ");
				hivAvg = scanner.nextDouble();
				
				humanDTOs[count] = new BatterDTO(number, name, age, height, position, batcount, hit, hivAvg);
				
			}else {
				System.out.println("잘못된 번호입니다. 메뉴를 다시 선택해주세요.");
				return;
			}
			
		}catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다. 메뉴를 다시 선택해주세요.");
			scanner.next();
			return;
		}
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void battingSort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pitcherSort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void allData() {
		for(HumanDTO dto : humanDTOs) {
			if(dto instanceof PitcherDTO) {
				System.out.println(((PitcherDTO)dto).toString());
			}else if(dto instanceof BatterDTO) {
				System.out.println(((BatterDTO)dto).toString());
			}
		}
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
	
	//////////////////////////
	//번호가 같은사람 찾기
	private int searchNum(int number, HumanDTO humanDTOs[]) {
		int index = -1;
		for (int i = 0; i < humanDTOs.length; i++) {
			if(humanDTOs[i] != null && number == humanDTOs[i].getNumber()) {
				index = i;
				break;
			}
		}
		return index;
	}

}
