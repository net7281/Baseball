package dto;

public class BatterDTO extends HumanDTO{
	private String position;
	private int batcount;
	private int hit;
	private double hivAvg;
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
	
	
} 
