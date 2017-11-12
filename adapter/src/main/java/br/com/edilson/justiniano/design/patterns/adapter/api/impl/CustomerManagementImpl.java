package br.com.edilson.justiniano.design.patterns.adapter.api.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.edilson.justiniano.design.patterns.adapter.api.Customer;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerManagement;

public class CustomerManagementImpl implements CustomerManagement {

	private final List<Customer> customers;

	public CustomerManagementImpl() {
		this.customers = new ArrayList<>();
	}

	@Override
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return customers.stream().filter(customer -> customerId.equals(customer.getId())).findFirst().orElse(null);
	}

	@Override
	public Customer getCustomerByName(String name) {
		return customers.stream().filter(customer -> name.equalsIgnoreCase(customer.getName())).findFirst()
				.orElse(null);
	}

	/*
	 * Used only for Unit tests purposes
	 */
	List<Customer> getCustomers() {
		return customers;
	}

}
