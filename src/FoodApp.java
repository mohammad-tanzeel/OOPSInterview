import java.util.Arrays;
import java.util.List;

/*
 * 
 */
public class FoodApp {
	private static final int NO_OF_CUSTOMER = 100;
	private String nameofFoodApp;
	private double fee;
	private Customer[] customers;
	private int currentNumberOfCustomers;

	/*
	 * String name double fee (%)
	 */
	public FoodApp(String name, double fee) {
		this.nameofFoodApp = name;
		this.fee = fee;
		this.customers = new Customer[NO_OF_CUSTOMER];
		this.currentNumberOfCustomers = 0;
	}

	/*
	 * 	
	 */
	public int getCustomerIndex(Customer customer) {
		for (int index = 0; index < customers.length; index++) {
			if (customers[index]!=null && customers[index].equals(customer)) {
				return index;
			}
		}
		return -1;
	}

	/*
	 * 
	 */
	public boolean addCustomer(Customer customer) {
		if (getCustomerIndex(customer) > -1) {
			return false;
		} else {
			this.customers[currentNumberOfCustomers] = customer;
			currentNumberOfCustomers++;
			return true;
		}
	}

	public boolean removeCustomer(Customer customer) {
		int removedCustomerIndex = this.getCustomerIndex(customer);

		if (removedCustomerIndex > -1) {

			// An temp array of size one less than original array
			Customer[] tempArray = new Customer[this.customers.length - 1];

			for (int index = 0, counter = 0; index < this.customers.length; index++) {

				if (index == removedCustomerIndex) {
					continue;
				}

				tempArray[counter++] = this.customers[index];
			}
			this.customers = tempArray;
			currentNumberOfCustomers--;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder returnStr = new StringBuilder("- FoodApp ").append(this.nameofFoodApp).append("\n")
				.append(this.currentNumberOfCustomers).append(" customer(s) registered: ");

		for (int index=0; index<this.currentNumberOfCustomers; index++) {
			returnStr.append(this.customers[index].toString());
		}
		returnStr.append("\n");

		return returnStr.toString();
	}

	public String getNameofFoodApp() {
		return nameofFoodApp;
	}

	public void setNameofFoodApp(String nameofFoodApp) {
		this.nameofFoodApp = nameofFoodApp;
	}

	public double getFee() {
		return fee;
	}
}
