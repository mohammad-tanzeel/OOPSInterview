
public class FoodItem {
	private String name;
	private double cost;
	private double sellingPrice;
	private int itemsInStock = 0;

	public FoodItem(String name, double cost, double price, int items) {
		this.name = name;
		this.cost = cost;
		this.sellingPrice = price;
		this.itemsInStock = items;
	}

	@Override
	public String toString() {
		return String.format("- %s %f%s", this.name, this.sellingPrice, (this.isAvailable() ? "" : " (SOLD OUT)"));
	}

	public boolean isAvailable() {
		if (this.itemsInStock > 0)
			return true;
		return false;
	}

	public void setSellingPrice(double price) {
		this.sellingPrice = price;
	}
	
	public double getSellingPrice() {
		return sellingPrice;
	}

	public void decrementStock() {
		this.itemsInStock = this.itemsInStock - 1;
	}

	public void increaseStock(double newStock) {
		this.itemsInStock += newStock;
	}

	public double getMarkup (){
		return this.sellingPrice - this.cost;
	}
	
	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}
}
