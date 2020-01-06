package service;
import java.util.Map;

import org.junit.Test;

import dao.CustomerDaoImpl;
import entities.Customer;
import junit.framework.Assert;

public class CustomerServiceImplTest {
	@Test
	public void testCreateAccount_1() {
		CustomerServiceImpl service=new CustomerServiceImpl(new CustomerDaoImpl());
		String mobileNo="911";
		double balance= 100;
		String name="chandra";
		Customer c=new Customer();
		Customer customer=service.addCustomer(c);
		Assert.assertNotNull(customer);
		Map<String,Customer>store=service.getdao().getStore();
		Customer expected=store.get(mobileNo);
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected, customer);
		
	}

}
