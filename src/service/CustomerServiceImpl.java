package service;

import dao.CustomerDao;
import entities.Customer;
import exceptions.IncorrectMobileNoException;
import java.util.Set;

import com.mycompany.app.AppUser;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao dao;
	public CustomerServiceImpl(CustomerDao dao) {
		this.dao = dao;
	}
	
	@Override
	 public Customer findCustomerByMobileNo(String mobileNo) {
	        if (mobileNo ==null) {
	            throw new IncorrectMobileNoException("mobileNo is incorrect");
	        }
	        Customer c = dao.findCustomerBymobileNo(mobileNo);
	        return c;
	    }
	
	

	@Override
    public Customer findCustomerBymobileNo(String mobileNo) {
        Customer c = dao.findCustomerBymobileNo(mobileNo);
        return c;
    }

    @Override
    public boolean credentialsCorrect(String mobileNo, String password) {
        boolean correct = dao.credentialsCorrect(mobileNo, password);
        return correct;
    }
    @Override
    public Set<Customer> allCustomer() {
        Set<Customer> employees = dao.allCustomer();
        return employees;
    }
}
