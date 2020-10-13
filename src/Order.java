public class Order {
	private int orderNumber = 900000;
	private Customer customer;
	private Restaurant restaurant;
	private FoodApp foodApp;
	private FoodItem[] foodItems;
	private int totalNumberOfItems;
	private double totalPrice;

	private static final int MAX_NO_OF_ITEMS = 10;
	
	public Order(Customer customer, Restaurant restaurant, FoodApp foodApp) {
		this.customer = customer;
		this.restaurant = restaurant;
		this.foodApp = foodApp;
		this.foodItems = new FoodItem[MAX_NO_OF_ITEMS];
		this.totalNumberOfItems = 0;
		this.totalPrice = 0;
		orderNumber++;
	}

	public void addToOrder(FoodItem foodItem) {
		if (foodItem.isAvailable() && this.totalNumberOfItems < MAX_NO_OF_ITEMS) {
			this.foodItems[this.totalNumberOfItems] = foodItem;
			foodItem.decrementStock();
			this.totalPrice += foodItem.getSellingPrice();
			this.totalNumberOfItems++;			
		}
	}

	@Override
	public String toString() {
		StringBuilder returnStr = new StringBuilder("-- ").append(this.foodApp.getNameofFoodApp()).append(" Order #")
				.append(orderNumber).append("\nFor customer ").append(this.customer.getCustomerName())
				.append(" with ").append(this.restaurant.getNameOfRestaurant());

		for (int index=0; index <totalNumberOfItems; index++) {
			returnStr.append("\n").append(foodItems[index].toString());
		}
		returnStr.append("\n").append("Total Price: ").append(this.totalPrice);

		return returnStr.toString();
	}

	public void submitOrder() {
		this.restaurant.fillOrder(this.totalPrice, this.foodItems, this.totalNumberOfItems, this.foodApp.getFee());
		this.customer.updateRecentOrders(this);
	}

}
