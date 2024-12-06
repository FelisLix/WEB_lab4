package web.web_lab4_2.beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import web.web_lab4_2.dao.CustomerDao;
import web.web_lab4_2.entities.Customer;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Named
@SessionScoped
public class CustomerBean implements Serializable {

    @EJB
    private CustomerDao customerDao;

    private Customer customer = new Customer();

    public List<Customer> getCustomers() {
        return customerDao.fillAll();
    }

    public String showOrders(int id) {
        customer = customerDao.find(id);
        return "orders";
    }

    public void delete(int id) {
        customerDao.delete(id);
    }

    public void add() {
        customerDao.add(customer);
        customer = new Customer();
    }
}
