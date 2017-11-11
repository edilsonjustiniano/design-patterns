package br.com.edilson.justiniano.design.patterns.adapter.api.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.edilson.justiniano.design.patterns.adapter.api.Customer;

/**
 * Unit tests for {@link CustomerManagementImpl}
 *
 * @author edilson
 */

public class CustomerManagementImplTest {

	private static final String CUSTOMER_ID = "customerId";
	private static final String CUSTOMER_NAME = "customerName";

	private CustomerManagementImpl customerManagement;

	@Before
	public void setUp() {
		customerManagement = new CustomerManagementImpl();
	}

	@Test
	public void addCustomer_shouldSuccessfullyAddCustomer() {
		// given
		Customer customer = new Customer(CUSTOMER_ID, CUSTOMER_NAME);

		// when
		customerManagement.addCustomer(customer);

		// then
		assertThat(customerManagement.getCustomers().get(0)).isEqualTo(customer);
	}
}
