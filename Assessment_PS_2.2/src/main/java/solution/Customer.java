package solution;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int customerId;
	
	String customerName;
	String customerEmail;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	List<Order> orders = new ArrayList<>();
	
	public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

	public Customer() {
		super();
	}

	public Customer(int customerId, String customerName, String customerEmail, List<Order> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.orders = orders;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}	
}
