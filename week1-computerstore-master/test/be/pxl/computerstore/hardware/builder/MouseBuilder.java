package be.pxl.computerstore.hardware.builder;

import be.pxl.computerstore.hardware.Mouse;

public class MouseBuilder {
	public static final String VENDOR = "Logitech";
	public static final String NAME = "MS-123";
	public static final double PRICE = 12.5;
	
	private String vendor = VENDOR;
	private String name = NAME;
	private double price = PRICE;

	public MouseBuilder vendor(String vendor) {
		this.vendor = vendor;
		return this;
	}

	public MouseBuilder name(String name) {
		this.name = name;
		return this;
	}

	public MouseBuilder price(double price) {
		this.price = price;
		return this;
	}

	public Mouse build() {
		Mouse result = new Mouse(vendor, name, price);
		return result;
	}
}
