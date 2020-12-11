package second;

import java.time.LocalDate;

public class Beer extends Drinks{
	float alc;
	public Beer(String name, double cost, LocalDate produce, int exp, float alc) {
		super(name, cost, produce, exp);
		alc=this.alc;
		exp=30;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String str="Name: "+this.name+"\n"+"Cost: "+this.cost+"\n"+"Produce Date: "+this.produce
				+"\n"+"Expiration time: "+this.exp;
		return str;
	}
	
	
}
