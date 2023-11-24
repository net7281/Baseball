package dao;

import java.util.InputMismatchException;
import java.util.Scanner;

import dto.BatterDTO;
import dto.HumanDTO;
import dto.PitcherDTO;
import fileIO.FileIO;

public class BaseballDAO implements BaseballDAOImpl{
	
	Scanner scanner = new Scanner(System.in);
	FileIO fileIO;
	
	//학생 데이터 관리 배열
	private HumanDTO humanDTOs[];
	
	//배열 관리용 변수
	private int count;
	
	public BaseballDAO() {
		fileIO = new FileIO("Baseball");
		fileIO.create();
		count = 0;
		humanDTOs = new HumanDTO[10]; //변수만 생성
	}

	@Override
	public void insert() { //선수정보입력
		if(count < 10) {
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
				if(number == 0) {
					System.out.println("0번은 사용하실 수 없습니다.");
				}
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
				
				count++;
				
			}catch (InputMismatchException e) {
				System.out.println("잘못입력하셨습니다. 메뉴를 다시 선택해주세요.");
				scanner.next();
				return;
			}
		}else {
			System.out.println("죄송합니다. 학생정보가 가득 찼습니다.");
		}
	}

	@Override
	public void delete() {
		//이름을 입력받고 int는 0, String은 ""
		
		System.out.println();
		System.out.println("선수정보 삭제 ==========");
		System.out.println();
		
		int number = 0;
		try {
			System.out.print("삭제하실 선수의 번호를 입력하세요 >> ");
			number = scanner.nextInt();
			
		}catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다. 메뉴를 다시 선택해주세요.");
			scanner.next();
			return;
		}
		
		int index = searchNum(number, humanDTOs);
		if(index != -1) {
			humanDTOs[index].setNumber(0);
			humanDTOs[index].setName("");
			humanDTOs[index].setAge(0);
			humanDTOs[index].setHeight(0);
			if(humanDTOs[index] instanceof PitcherDTO) {
				PitcherDTO p = (PitcherDTO) humanDTOs[index];
				p.setPosition("");
				p.setWin(0);
				p.setLose(0);
				p.setDefence(0);
			}else if(humanDTOs[index] instanceof BatterDTO){
				BatterDTO b = (BatterDTO) humanDTOs[index];
				b.setPosition("");
				b.setBatcount(0);
				b.setHit(0);
				b.setHivAvg(0);
			}
			System.out.println(number + "번 선수의 정보를 삭제하였습니다.");
			return;
		}else {
			System.out.println(number + "번 선수를 찾지 못했습니다.");
			return;
		}
		
	}

	@Override
	public void select() {
		System.out.println();
		System.out.println("선수정보 조회 ==========");
		System.out.println();
		
		int number = 0;
		try {
			System.out.print("조회하실 선수의 번호를 입력하세요 >> ");
			number = scanner.nextInt();
			
		}catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다. 메뉴를 다시 선택해주세요.");
			scanner.next();
			return;
		}
		
		int index = searchNum(number, humanDTOs);
		if(index != -1) {
			if(humanDTOs[index] instanceof PitcherDTO) {
				System.out.println(((PitcherDTO)humanDTOs[index]).toSelect());
			}else if(humanDTOs[index] instanceof BatterDTO) {
				System.out.println(((BatterDTO)humanDTOs[index]).toSelect());
			}
			return;
		}else {
			System.out.println(number + "번 선수를 찾지 못했습니다.");
			return;
		}
		
	}

	@Override
	public void update() {
		System.out.println();
		System.out.println("선수정보 수정 ==========");
		System.out.println();
		
		int number = 0;
		try {
			System.out.print("수정하실 선수의 번호를 입력하세요 >> ");
			number = scanner.nextInt();
			
		}catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다. 메뉴를 다시 선택해주세요.");
			scanner.next();
			return;
		}
		
		int index = searchNum(number, humanDTOs);
		if(index != -1) {
			if(humanDTOs[index] instanceof PitcherDTO) {
				int win;
				int lose;
				double defence;
				try {
					System.out.print("승리횟수 >> ");
					win = scanner.nextInt();
					System.out.print("패배횟수 >> ");
					lose = scanner.nextInt();
					System.out.print("방어율 >> ");
					defence = scanner.nextDouble();
				}catch (Exception e) {
					System.out.println("잘못입력하셨습니다. 메뉴를 다시 선택해주세요.");
					return;
				}
				PitcherDTO p = (PitcherDTO) humanDTOs[index];
				p.setWin(win);
				p.setLose(lose);
				p.setDefence(defence);
				
			}else if(humanDTOs[index] instanceof BatterDTO) {
				int batcount;
				int hit;
				double hivAvg;
				try {
					System.out.print("타수 >> ");
					batcount = scanner.nextInt();
					System.out.print("안타 >> ");
					hit = scanner.nextInt();
					System.out.print("타율 >> ");
					hivAvg = scanner.nextDouble();
				}catch (Exception e) {
					System.out.println("잘못입력하셨습니다. 메뉴를 다시 선택해주세요.");
					return;
				}
				BatterDTO b = (BatterDTO) humanDTOs[index];
				b.setBatcount(batcount);
				b.setHit(hit);
				b.setHivAvg(hivAvg);
			}
			
			System.out.println();
			System.out.println(number + "번 선수의 정보를 수정하였습니다.");
			return;
		}else {
			System.out.println(number + "번 선수를 찾지 못했습니다.");
			return;
		}
	}

	@Override
	public void battingSort() { //타율 순 정렬
		System.out.println();
		System.out.println("타율 순위 ==========");
		System.out.println();
		//타자 수 얻기
		int batterCount = 0;
		for(HumanDTO dto : humanDTOs) {
			if(dto instanceof BatterDTO) {
				batterCount++;
			}
		}
		
		//타자 arr
		BatterDTO batterDTOs[] = new BatterDTO[batterCount];
		int dtoCount = 0;
		for(HumanDTO dto : humanDTOs) {
			if(dto instanceof BatterDTO) {
				batterDTOs[dtoCount] = (BatterDTO) dto;
				dtoCount++;
			}
		}
		
		for(int i = 0; i<batterDTOs.length-1; i++) {
			for(int j = i+1; j<batterDTOs.length; j++) {
				if(batterDTOs[i].getHivAvg() < batterDTOs[j].getHivAvg()) {
					swapFunc(i,j,batterDTOs);
				}
			}
		}
		for(BatterDTO dto : batterDTOs) {
			System.out.println(dto.toString());
		}
	}

	@Override
	public void pitcherSort() { // 방어율 순위 - 낮을수록 좋음
		System.out.println();
		System.out.println("방어율 순위 ==========");
		System.out.println();
		//타자 수 얻기
		int pitcherCount = 0;
		for(HumanDTO dto : humanDTOs) {
			if(dto instanceof PitcherDTO) {
				pitcherCount++;
			}
		}
		
		//타자 arr
		PitcherDTO pitcherDTOs[] = new PitcherDTO[pitcherCount];
		int dtoCount = 0;
		for(HumanDTO dto : humanDTOs) {
			if(dto instanceof PitcherDTO) {
				pitcherDTOs[dtoCount] = (PitcherDTO) dto;
				dtoCount++;
			}
		}
		
		for(int i = 0; i<pitcherDTOs.length-1; i++) {
			for(int j = i+1; j<pitcherDTOs.length; j++) {
				if(pitcherDTOs[i].getDefence() > pitcherDTOs[j].getDefence()) {
					swapFunc(i,j,pitcherDTOs);
				}
			}
		}
		for(PitcherDTO dto : pitcherDTOs) {
			System.out.println(dto.toString());
		}
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
	public void save() { //파일 저장
		String strArr[] = new String[10];
		
		int strCount = 0;
		for(int i = 0; i<humanDTOs.length; i++) {
			if(humanDTOs[i] != null && humanDTOs[i].getNumber() != 0) {
				if(humanDTOs[i] instanceof PitcherDTO) {
					strArr[strCount] = ((PitcherDTO)humanDTOs[i]).toString();
				}else if(humanDTOs[i] instanceof BatterDTO) {
					strArr[strCount] = ((BatterDTO)humanDTOs[i]).toString();
				}
				strCount++;
			}
		}
		fileIO.writeFile(strArr);
	}

	@Override
	public void load() { //파일 불러오기
		String strArr[] = fileIO.readFile();
		
		humanDTOs = null;
		
		if(strArr == null || strArr.length == 0) {
			count = 0;
			return;
		}
		
		humanDTOs = new HumanDTO[10];
		for(int i = 0; i<strArr.length ;i++) {
			String splitArr[] = strArr[i].split("-");
			
			if(splitArr.length != 8) { //잘못된 입력 걸러내기
				continue;
			}
			try {
				int number = Integer.parseInt(splitArr[0]);
				String name = splitArr[1];
				int age = Integer.parseInt(splitArr[2]);
				double height = Double.parseDouble(splitArr[3]);
				
				if(splitArr[4].equals("투수")) {
					String position = splitArr[4];
					int win = Integer.parseInt(splitArr[5]);
					int lose = Integer.parseInt(splitArr[6]);
					double defence = Double.parseDouble(splitArr[7]);
					
					humanDTOs[i] = new PitcherDTO(number, name, age, height, position, win, lose, defence);
					
				}else if(splitArr[4].equals("타자")) {
					String position = splitArr[4];
					int batcount = Integer.parseInt(splitArr[5]);
					int hit = Integer.parseInt(splitArr[6]);
					double hivAvg = Double.parseDouble(splitArr[7]);
					
					humanDTOs[i] = new BatterDTO(number, name, age, height, position, batcount, hit, hivAvg);
				}
				count++;
			} catch (Exception e) {
				continue;
			}
			
		}
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
	
	//스왑함수
	private void swapFunc(int i, int j, Object objs[]) {
		Object object;
		object = objs[i];
		objs[i] = objs[j];
		objs[j] = object;
	}

}
