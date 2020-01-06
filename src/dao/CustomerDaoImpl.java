package dao;
import entities.Customer;
import exceptions.CustomerNotFoundException;
import java.util.*;

public class CustomerDaoImpl implements CustomerDao{
	private Map<String,Customer> store=new HashMap<>();
	
	public CustomerDaoImpl() {
	        Customer c1 = new Customer("9566","AB",1000,"ab");
	        store.put("AB", c1);
	        Customer c2 = new Customer("9874", "CD",2000,"cd");
	        store.put("CD", c2);
	    }
	@Override
    public Customer findCustomerBymobileNo(String mobileNo) {
		Customer c=store.get(mobileNo);
		if(c==null) {
			throw new CustomerNotFoundException("customer not found for mobileNo=" + mobileNo);

		}
		return c;
	}

	
		 
	
	@Override
	 public boolean credentialsCorrect(String mobileNo, String password) {
        Customer c= store.get(mobileNo);
        if (c == null) {
            return false;
        }
        return c.getPassword().equals(password);
    }

	
}