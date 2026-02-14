package Solution;

import jakarta.persistence.*;

@Entity
public class IDCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cardNumber;
	private String issuedDate;
	
	@OneToOne
    @JoinColumn(name = "employee_id", unique = true)
    private Employee employee;
	
	public IDCard(){
		super();
	}
	
	
	public IDCard(String cardNumber, String issuedDate, Employee employee) {
		super();
		this.cardNumber = cardNumber;
		this.issuedDate = issuedDate;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
