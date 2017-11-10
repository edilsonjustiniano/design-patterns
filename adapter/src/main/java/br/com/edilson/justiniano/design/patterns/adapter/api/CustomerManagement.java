package br.com.edilson.justiniano.design.patterns.adapter.api;

public interface CustomerManagement {

	void addCustomer(Customer customer);

	Customer getCustomer(String customerId);

	Customer getCustomerByName(String name);

}
