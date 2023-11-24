package dto;

public class PitcherDTO extends HumanDTO{
	private String position;
	private int win;
	private int lose;
	private double defence;
	
	public PitcherDTO(int number, String name, int age, double height, String position, int win, int lose, double defence) {
		super(number,name,age,height);
		this.position = position;
		this.win = win;
		this.lose = lose;
		this.defence = defence;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public double getDefence() {
		return defence;
	}
	public void setDefence(double defence) {
		this.defence = defence;
	}

	@Override
	public String toString() {
		return super.toString() + "-" + position + "-" + win + "-" + lose + "-" + defence;
	}
	
	public String toSelect() {
		String str = "";
		str += "번호 : " + super.getNumber() + "\n";
		str += "이름 : " + super.getName() + "\n";
		str += "나이 : " + super.getAge() + "\n";
		str += "키 : " + super.getHeight() + "\n";
		str += "포지션 : " + position + "\n";
		str += "승리횟수 : " + win + "\n";
		str += "패배횟수 : " + lose + "\n";
		str += "방어율 : " + defence + "\n";
		return str;
	}
}
