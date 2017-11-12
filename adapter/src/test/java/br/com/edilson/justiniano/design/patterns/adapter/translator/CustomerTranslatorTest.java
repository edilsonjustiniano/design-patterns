package br.com.edilson.justiniano.design.patterns.adapter.translator;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.UUID;

import org.junit.Test;

import br.com.edilson.justiniano.design.patterns.adapter.api.Customer;
import br.com.edilson.justiniano.design.patterns.adapter.api.CustomerV2;

/**
 * Unit tests for {@link CustomerTranslator}
 *
 * @author edilson
 */
public class CustomerTranslatorTest {

	private static final String CUSTOMER_ID = UUID.randomUUID().toString();
	private static final String CUSTOMER_NAME = "customerName";

	@Test
	public void constructor_shouldSuccessfullyInstantiated() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<CustomerTranslator> constructor = CustomerTranslator.class.getDeclaredConstructor();
		assertThat(Modifier.isPrivate(constructor.getModifiers())).isEqualTo(true);
		constructor.setAccessible(true);
		constructor.newInstance();
	}

	@Test
	public void translate_shouldTranslateCustomerSuccessfully() {
		// given
		Customer customer = new Customer(CUSTOMER_ID, CUSTOMER_NAME);
		CustomerV2 customerV2 = new CustomerV2(UUID.fromString(CUSTOMER_ID), CUSTOMER_NAME, 0);

		// when
		CustomerV2 result = CustomerTranslator.translateFromCustomer(customer);

		// then
		assertThat(result).isEqualTo(customerV2);
	}

	@Test
	public void translate_shouldTranslateCustomerFromNull() {
		// when
		CustomerV2 result = CustomerTranslator.translateFromCustomer(null);

		// then
		assertThat(result).isNull();
	}

	@Test
	public void translate_shouldTranslateCustomerV2Successfully() {
		// given
		CustomerV2 customerV2 = new CustomerV2(UUID.fromString(CUSTOMER_ID), CUSTOMER_NAME, 0);
		Customer customer = new Customer(CUSTOMER_ID, CUSTOMER_NAME);

		// when
		Customer result = CustomerTranslator.translateFromCustomerV2(customerV2);

		// then
		assertThat(result).isEqualTo(customer);
	}

	@Test
	public void translate_shouldTranslateCustomerV2FromNull() {
		// when
		Customer result = CustomerTranslator.translateFromCustomerV2(null);

		// then
		assertThat(result).isNull();
	}
}
