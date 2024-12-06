package web.web_lab4_2.dao;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import web.web_lab4_2.entities.Customer;

import java.util.List;

@Stateless
public class CustomerDao {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @PostConstruct
    public void init() {
        System.out.println("EntityManager injected: " + (em != null));
    }

    public List<Customer> fillAll(){
        return em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    public Customer find(int id) {
        return em.find(Customer.class, id);
    }

    public void delete(int id) {
        Customer customer = em.find(Customer.class, id);
        em.remove(customer);
    }

    public void add(Customer customer) {
        em.persist(customer);
    }
}
