package br.com.edilson.justiniano.design.patterns.bridge.api.impl;

import br.com.edilson.justiniano.design.patterns.bridge.api.Product;

public class GearLocking implements Product {

	private final String productName;

	public GearLocking(String productName) {
		this.productName = productName;
	}

	@Override
	public String productName() {
		return productName;
	}

	@Override
	public void produce() {
		System.out.println("Producing Central Locking System");
	}

}
