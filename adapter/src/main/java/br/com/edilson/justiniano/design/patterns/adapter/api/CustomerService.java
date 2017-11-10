package br.com.edilson.justiniano.design.patterns.adapter.api;

import java.util.UUID;

public interface CustomerService {

	void saveCustomer(CustomerV2 customer);

	CustomerV2 getCustomer(UUID customerId);

	CustomerV2 getCustomerByName(String name);
}
