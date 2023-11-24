package dao;

import java.util.InputMismatchException;
import java.util.Scanner;

import dto.HumanDTO;

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
		
		try {
			System.out.print("번호 >> ");
			number = scanner.nextInt();
			
		}catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다. 메뉴를 다시 선택해주세요.");
			scanner.next();
			return;
		}
		String name = scanner.next();
		//중복처리
		int index = searchName(name, humanDTOs);
		if(index != -1) {
			System.out.println(name + "는 이미 존재하는 이름입니다.");
			return;
		}
		
		System.out.print("이름 >> ");
		
		
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
		// TODO Auto-generated method stub
		
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
	private int searchName(int number, HumanDTO humanDTOs[]) {
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
