package service;
import entities.Customer;
import java.util.*;

import com.mycompany.app.AppUser;

public interface CustomerService {
	 Customer findCustomerBymobileNo(String mobileNo);

	    boolean credentialsCorrect(String mobileNo, String password);
	    Set<Customer> allCustomer();

}


