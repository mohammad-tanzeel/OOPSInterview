import java.util.Arrays;
import java.util.List;

public class Restaurant {
	private String nameOfRestaurant;
	private FoodItem[] menu;
	private double profit = 0;
	
	public Restaurant(String name, FoodItem[] foodItems) {
		this.nameOfRestaurant = name;
		this.menu = foodItems;
	}
	
	@Override
	public String toString() {
		StringBuilder returnStr = new StringBuilder("-- Restaurant ").append(this.nameOfRestaurant)
		.append("\n").append("Profit: ").append(this.profit).append("\nMenu:\n");
		
		List<FoodItem> foodItems = Arrays.asList(this.menu);
		for(FoodItem foodItem: foodItems) {
			returnStr.append(foodItem.toString()).append("\n");
		}
		returnStr.append("\n") ;
		
		return returnStr.toString();
	}

	public String getNameOfRestaurant() {
		return nameOfRestaurant;
	}

	public FoodItem[] getMenu() {
		return menu;
	}

	public double getProfit() {
		return profit;
	}
	
	public void fillOrder (double totalPrice, FoodItem[] foodItems, int numerOfFoodItems, double fee) {
		double sumOfmarkup =0;
		for(int index=0; index<numerOfFoodItems; index++) {
			sumOfmarkup = foodItems[index].getMarkup();
		}
		this.profit = sumOfmarkup - (totalPrice * fee/100);
	}
}
