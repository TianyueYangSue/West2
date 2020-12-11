package second;

import java.time.LocalDate;
import java.time.Period;

public abstract class Drinks {
	protected String name;
	protected double cost;
	protected LocalDate produce;
	protected int exp;
	
	public Drinks(String name, double cost, LocalDate produce, int exp) {
		this.name=name;
		this.cost=cost;
		this.produce=produce;
		this.exp=exp;
	}
	
	public boolean overdue() {
		LocalDate ld = LocalDate.now();
		Period beetween=Period.between(ld, produce);
		if(beetween.getDays()>exp) {
			return false;
		} else {
			return true;
		}
	}
	
	public abstract String toString();

}
