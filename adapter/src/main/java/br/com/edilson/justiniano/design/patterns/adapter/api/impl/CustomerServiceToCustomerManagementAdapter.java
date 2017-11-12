package br.com.edilson.justiniano.design.patterns.adapter.api.impl;

import java.util.UUID;

import br.com.edilson.justiniano.design.patterns.adapter.api.Customer;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerManagement;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerService;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerV2;
import br.com.edilson.justiniano.design.patterns.adapter.translator.CustomerTranslator;

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
		Customer customerCandidate = CustomerTranslator.translateFromCustomerV2(customer);
		customerManagement.addCustomer(customerCandidate);
	}

	@Override
	public CustomerV2 getCustomer(UUID customerId) {
		Customer customer = customerManagement.getCustomerById(customerId.toString());
		CustomerV2 newCustomer = null;
		if (customer != null) {
			newCustomer = CustomerTranslator.translateFromCustomer(customer);
		}

		return newCustomer;
	}

	@Override
	public CustomerV2 getCustomerByName(String name) {
		Customer customer = customerManagement.getCustomerByName(name);
		CustomerV2 newCustomer = null;
		if (customer != null) {
			newCustomer = CustomerTranslator.translateFromCustomer(customer);
		}

		return newCustomer;
	}

}
