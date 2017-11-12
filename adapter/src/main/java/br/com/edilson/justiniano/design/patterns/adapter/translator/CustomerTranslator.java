package br.com.edilson.justiniano.design.patterns.adapter.translator;

import java.util.UUID;

import br.com.edilson.justiniano.design.patterns.adapter.api.Customer;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerV2;

public class CustomerTranslator {

	private CustomerTranslator() {
		// Constructor created to avoid any instantiation
	}

	public static CustomerV2 translateFromCustomer(Customer from) {
		if (from == null) {
			return null;
		}
		return new CustomerV2(UUID.fromString(from.getId()), from.getName(), 0);
	}

	public static Customer translateFromCustomerV2(CustomerV2 from) {
		if (from == null) {
			return null;
		}
		return new Customer(from.getId().toString(), from.getName());
	}
}
