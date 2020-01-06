package ui;
import dao.CustomerDaoImpl;
import entities.Customer;
import service.CustomerServiceImpl;
import service.CustomerService;

import java.util.Collection;
import java.util.Set;

public class Customerui {
	    private CustomerService service = new CustomerServiceImpl(new CustomerDaoImpl());

	    public static void main(String[] args) {
	        Customerui ui = new Customerui();
	        ui.runUi();
	    }

	    public void runUi() {
	        try {
	            Customer c1 = new Customer("911", "chandra",100);
	            Customer c2 = new Customer("444", "satya",200);
	            service.addCustomer(c1);
	            service.addCustomer(c2);
	            Customer fetched1 = service.findCustomerByMobileNo("911");
	            Customer fetched2 = service.findCustomerByMobileNo("444");
	            System.out.println(fetched1.getName());
	            System.out.println(fetched2.getName());
	            System.out.println("********printing all customers****");
	            Set<Customer> customer = service.allCustomer();
	            print(customer);
	        }catch (Throwable c){
	            c.printStackTrace();
	            System.out.println("something went wrong");
	        }
	    }

	    void print(Collection<Customer>customers){
	        for (Customer c:customers){
	            System.out.println(c.getName());
	        }
	    }
	}



