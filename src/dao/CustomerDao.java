package dao;
import entities.Customer;

import java.util.Map;
import java.util.Set;

public interface CustomerDao {
	void addCustomer(Customer c);

    

    Set<Customer> allCustomer();
	

    Customer findCustomerBymobileNo(String mobileNo);

    boolean credentialsCorrect(String mobileNo, String password);
}



