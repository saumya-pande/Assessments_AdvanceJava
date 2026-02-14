package Solution;

import jakarta.persistence.*;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assessment_1");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee emp = new Employee();
        emp.setName("John");
        emp.setEmail("john@example.com");

        IDCard card = new IDCard();
        card.setCardNumber("IDC101");
        card.setIssuedDate("2026-02-14");

        card.setEmployee(emp);
        emp.setIdCard(card);

        em.persist(emp);

        em.getTransaction().commit();

        System.out.println("Employee Created Successfully");

        // Fetch Employee
        Employee fetchedEmp = em.find(Employee.class, emp.getId());

        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + fetchedEmp.getId());
        System.out.println("Name: " + fetchedEmp.getName());
        System.out.println("Email: " + fetchedEmp.getEmail());

        System.out.println("\nID Card Details:");
        System.out.println("Card Number: " + fetchedEmp.getIdCard().getCardNumber());
        System.out.println("Issue Date: " + fetchedEmp.getIdCard().getIssuedDate());

        em.close();
        emf.close();
    }
}
