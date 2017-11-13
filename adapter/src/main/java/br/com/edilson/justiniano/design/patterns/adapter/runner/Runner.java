package br.com.edilson.justiniano.design.patterns.adapter.runner;

import java.util.UUID;

import org.apache.commons.math3.util.Pair;

import br.com.edilson.justiniano.design.patterns.adapter.api.Customer;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerManagement;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerService;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerV2;
import br.com.edilson.justiniano.design.patterns.adapter.api.impl.CustomerManagementImpl;
import br.com.edilson.justiniano.design.patterns.adapter.api.impl.CustomerServiceToCustomerManagementAdapter;

public class Runner {

	public static void main(String... args) {
		CustomerManagement customerManagement = new CustomerManagementImpl();
		Pair<Customer, CustomerV2> customers = getCustomers(customerManagement, args[0]);
		System.out.println(customers.getFirst());
		System.out.println(customers.getSecond());
	}

	private static Pair<Customer, CustomerV2> getCustomers(CustomerManagement customerManagement, String name) {
		CustomerV2 customerV2 = new CustomerV2(UUID.randomUUID(), name, 27);
		CustomerService customerService = new CustomerServiceToCustomerManagementAdapter(customerManagement);
		customerService.saveCustomer(customerV2);

		Customer retrievedCustomer = customerManagement.getCustomerByName(name);

		return Pair.create(retrievedCustomer, customerV2);
	}
}
