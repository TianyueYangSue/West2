package second;

public class SetMeal {
	String mealname;
	double cost;
	String chikenname;
	Drinks drink;
	
	public SetMeal(String mealname, double cost, String chickenname, Drinks drink) {
		this.mealname=mealname;
		this.cost=cost;
		this.chikenname=chickenname;
		this.drink=drink;
	}
	
	@Override
	public String toString() {
		return "SetMeal [mealname=" + mealname + ", cost=" + cost + ", chikenname=" + chikenname + ", drink=" + drink
				+ "]";
	}
	
}
