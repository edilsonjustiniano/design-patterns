package br.com.edilson.justiniano.design.patterns.adapter.api.impl;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.edilson.justiniano.design.patterns.adapter.api.Customer;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerManagement;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerV2;

/**
 * Unit tests for {@link CustomerServiceToCustomerManagementAdapter}
 *
 * @author edilson
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceToCustomerManagementAdapterTest {

	private static final UUID CUSTOMER_ID = UUID.randomUUID();
	private static final String CUSTOMER_NAME = "customerName";
	private static final int CUSTOMER_AGE = 30;

	@Mock
	private CustomerManagement customerManagement;

	@InjectMocks
	private CustomerServiceToCustomerManagementAdapter customerServiceToCustomerManagementAdapter = new CustomerServiceToCustomerManagementAdapter();

	@Test
	public void saveCustomer_shouldSuccessfullySaveIt() {
		// given
		CustomerV2 customer = new CustomerV2(CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_AGE);
		// when
		customerServiceToCustomerManagementAdapter.saveCustomer(customer);

		// then
		BDDMockito.verify(customerManagement).addCustomer(BDDMockito.any(Customer.class));
	}
}
