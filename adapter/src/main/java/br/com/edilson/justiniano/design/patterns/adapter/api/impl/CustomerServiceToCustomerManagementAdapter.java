package br.com.edilson.justiniano.design.patterns.adapter.api.impl;

import java.util.UUID;

import br.com.edilson.justiniano.design.patterns.adapter.api.Customer;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerManagement;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerService;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerV2;

public class CustomerServiceToCustomerManagementAdapter implements CustomerService {

	private final CustomerManagement customerManagement;

	public CustomerServiceToCustomerManagementAdapter() {
		this.customerManagement = new CustomerManagementImpl();
	}

	/*
	 * For Unit tests
	 */
	public CustomerServiceToCustomerManagementAdapter(CustomerManagement customerManagement) {
		this.customerManagement = customerManagement;
	}

	@Override
	public void saveCustomer(CustomerV2 customer) {
		Customer customerCandidate = new Customer(customer.getId().toString(), customer.getName());
		customerManagement.addCustomer(customerCandidate);
	}

	@Override
	public CustomerV2 getCustomer(UUID customerId) {
		Customer customer = customerManagement.getCustomer(customerId.toString());
		CustomerV2 newCustomer = null;
		if (customer != null) {
			newCustomer = new CustomerV2(UUID.fromString(customer.getId()), customer.getName(), 0);
		}

		return newCustomer;
	}

	@Override
	public CustomerV2 getCustomerByName(String name) {
		Customer customer = customerManagement.getCustomerByName(name);
		CustomerV2 newCustomer = null;
		if (customer != null) {
			newCustomer = new CustomerV2(UUID.fromString(customer.getId()), customer.getName(), 0);
		}

		return newCustomer;
	}

}
