package second;

import java.time.LocalDate;

public class Juice extends Drinks{
	public Juice(String name, double cost, LocalDate produce, int exp) {
		super(name, cost, produce, exp);
		exp=2;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String str="Name: "+this.name+"\n"+"Cost: "+this.cost+"\n"+"Produce Date: "+this.produce
				+"\n"+"Expiration time: "+this.exp;
		return str;
	}
	

}
