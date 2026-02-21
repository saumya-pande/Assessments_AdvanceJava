package solution;

import jakarta.persistence.*;

@Entity
public class OrderItem {
	@Id
	@JoinColumn(name =  "Order")
	int itemId;
	
	 private String productName;
    private Integer quantity;
    private Double price;
    
	@ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
