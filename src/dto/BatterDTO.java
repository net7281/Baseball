package dto;

public class BatterDTO extends HumanDTO{
	private String position;
	private int batcount;
	private int hit;
	private double hivAvg;
	
	public BatterDTO(int number, String name, int age, double height, String position, int batcount, int hit,
			double hivAvg) {
		super(number, name, age, height);
		this.position = position;
		this.batcount = batcount;
		this.hit = hit;
		this.hivAvg = hivAvg;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getBatcount() {
		return batcount;
	}
	public void setBatcount(int batcount) {
		this.batcount = batcount;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public double getHivAvg() {
		return hivAvg;
	}
	public void setHivAvg(double hivAvg) {
		this.hivAvg = hivAvg;
	}
	
	@Override
	public String toString() {
		return super.toString() + "-" + position + "-" + batcount + "-" + hit + "-" + hivAvg;
	}
	
	public String toSelect() {
		String str = "";
		str += "번호 : " + super.getNumber() + "\n";
		str += "이름 : " + super.getName() + "\n";
		str += "나이 : " + super.getAge() + "\n";
		str += "키 : " + super.getHeight() + "\n";
		str += "포지션 : " + position + "\n";
		str += "타수 : " + batcount + "\n";
		str += "안타 : " + hit + "\n";
		str += "타율 : " + hivAvg + "\n";
		return str;
	}
	
} 
