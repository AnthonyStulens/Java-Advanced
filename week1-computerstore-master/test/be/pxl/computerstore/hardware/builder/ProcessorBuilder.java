package be.pxl.computerstore.hardware.builder;

import be.pxl.computerstore.hardware.Processor;

public class ProcessorBuilder {
	public static final String VENDOR = "Intel";
	public static final String NAME = "GX-123";
	public static final double PRICE = 25.35;
	public static final double CLOCK_SPEED = 3.7;

	private double clockspeed = CLOCK_SPEED;
	private String vendor = VENDOR;
	private String name = NAME;
	private double price = PRICE;

	public ProcessorBuilder vendor(String vendor) {
		this.vendor = vendor;
		return this;
	}

	public ProcessorBuilder name(String name) {
		this.name = name;
		return this;
	}

	public ProcessorBuilder price(double price) {
		this.price = price;
		return this;
	}

	public ProcessorBuilder clockspeed(double clockspeed) {
		this.clockspeed = clockspeed;
		return this;
	}

	public Processor build() {
		Processor result = new Processor(vendor, name, price, clockspeed);
		return result;
	}
}
