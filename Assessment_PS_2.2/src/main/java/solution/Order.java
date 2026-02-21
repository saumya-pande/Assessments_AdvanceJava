package solution;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderId;
	String orderDate;
	double totalAmount;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "orderItem_itemId", cascade = CascadeType.ALL)
	List<OrderItem> items = new ArrayList<>();
	
	
	public void addItem(OrderItem item) {
        items.add(item);
        item.setOrder(this);
    }

	public Order() {
		super();
	}

	public Order(String orderDate, double totalAmount, List<OrderItem> items) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.items = items;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}	
}
