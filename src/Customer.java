import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Customer {
	private String customerName;
	private String email;
	private String streetAddress;

	private static final int NO_OF_MOST_RECENT_ORDERS = 3;
	private Order[] recentOrders;

	public Customer(String name, String email, String address) {
		this.customerName = name;
		this.email = email;
		this.streetAddress = address;
		this.recentOrders = new Order[NO_OF_MOST_RECENT_ORDERS];
	}

	@Override
	public String toString() {
		return String.format("- Customer %s\n, Email: %s\n, Address: %s", this.customerName, this.email,
				this.streetAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Customer customer = (Customer) obj;
		return Objects.equals(this.email, customer.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.customerName, this.email, this.streetAddress);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public void updateRecentOrders(Order order) {
		List<Order> orderList = new ArrayList<>(Arrays.asList(recentOrders));
		orderList.remove(0);
		orderList.add(order);
		this.recentOrders = orderList.toArray(recentOrders);
	}
	
	public String getStringRecentOrders() {
		StringBuilder returnStr = new StringBuilder("Recent orders of ").append(this.customerName);

		for(int index=NO_OF_MOST_RECENT_ORDERS; index>0; index--) {
			returnStr.append("- ").append(recentOrders[index].toString());
		}
		return returnStr.toString();
	}
}
