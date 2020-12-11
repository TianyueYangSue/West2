package second;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant{
	double balance;
	LinkedList<Beer> beers=new LinkedList<Beer>();
	LinkedList<Juice> juices=new LinkedList<Juice>();
	static LinkedList<SetMeal> meals=new LinkedList<SetMeal>();
	
	public West2FriedChickenRestaurant(double balance, LinkedList<Beer> beers, LinkedList<Juice> juices) {
		this.balance=balance;
		this.beers=beers;
		this.juices=juices;
		Juice juice1=new Juice("Apple Juice", 5.0, LocalDate.of(2020, 12, 12), 30);
		Juice juice2=new Juice("Orange Juice", 5.0, LocalDate.of(2020, 12, 9), 30);
		Beer beer=new Beer("Budweiser", 10.0, LocalDate.of(2020, 12, 10), 90, 12);
		meals.add(new SetMeal("Boom", 20.0, "Fire Chicken", juice1));
		meals.add(new SetMeal("Flare", 23.0, "Gold Chicken", juice2));
		meals.add(new SetMeal("Sparkle", 25.0, "Red Chicken", beer));
	}
	
	private void use(Beer beer) {
		boolean sellout=true;
		Iterator<Beer> it=beers.iterator();
		while(it.hasNext()) {
			if(beer==it.next()) {
				sellout=false;
				if(beer.overdue()) {
					System.out.println("This beer is overdue.");
				} else {
					beers.remove(it.next());
				}
				break;
			}
		}
		if(sellout) {
			throw new IngredientSortOutException("This beer has been sold out.");
		}
	}
	
	private void use(Juice juice) {
		boolean sellout=true;
		Iterator<Juice> it=juices.iterator();
		while(it.hasNext()) {
			if(juice==it.next()) {
				sellout=false;
				if(juice.overdue()) {
					System.out.println("This juice is overdue.");
				} else {
					juices.remove(it.next());
				}
				break;
			}
		}
		if(sellout) {
			throw new IngredientSortOutException("This juice has been sold out.");
		}
	}
	
	public void sellMeal(SetMeal meal) {
		Iterator<SetMeal> it=meals.iterator();
		while(it.hasNext()) {
			if(meal==it.next()) {
				if(it.next().drink instanceof Beer) {
					use((Beer)(it.next().drink));
				} else {
					use((Juice)(it.next().drink));
				}
			}
		}
	}
	
	public void purchase(Drinks drink) {
		if(drink instanceof Beer) {
			if(drink.cost<=balance) {
				beers.add((Beer)drink);
			} else {
				throw new OverdraftBalanceException("The purchase cost is over the balance.");
			}
		} else {
			if(drink.cost<=balance) {
				juices.add((Juice)drink);
			} else {
				throw new OverdraftBalanceException("The purchase cost is over the balance.");
			}
		}
	}
}
