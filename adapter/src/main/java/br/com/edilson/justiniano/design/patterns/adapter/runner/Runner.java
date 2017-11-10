package br.com.edilson.justiniano.design.patterns.adapter.runner;

import java.util.UUID;

import br.com.edilson.justiniano.design.patterns.adapter.api.Customer;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerManagement;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerService;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerV2;
import br.com.edilson.justiniano.design.patterns.adapter.api.impl.CustomerManagementImpl;
import br.com.edilson.justiniano.design.patterns.adapter.api.impl.CustomerServiceToCustomerManagementAdapter;

public class Runner {

	public static void main(String... args) {
		Customer customer = new Customer(UUID.randomUUID().toString(), "Edilson");
		CustomerManagement customerManagement = new CustomerManagementImpl();
		customerManagement.addCustomer(customer);

		CustomerV2 customerV2 = new CustomerV2(UUID.randomUUID(), "Josy", 27);
		CustomerService customerService = new CustomerServiceToCustomerManagementAdapter(customerManagement);
		customerService.saveCustomer(customerV2);

		Customer retrievedCustomer = customerManagement.getCustomerByName("Josy");
		CustomerV2 retrievedCustomerV2 = customerService.getCustomerByName("Edilson");

		System.out.println("retrieved customer v2: " + retrievedCustomerV2);
		System.out.println("customer: " + customer);

		System.out.println("retrieved customer: " + retrievedCustomer);
		System.out.println("customerv2: " + customerV2);
	}
}
