package be.pxl.computerstore.hardware.builder;

import be.pxl.computerstore.hardware.ComputerCase;
import be.pxl.computerstore.util.Dimension;

public class ComputerCaseBuilder {
	public static Dimension DIMENSION = new DimensionBuilder().build();
	public static final String VENDOR = "Intel";
	public static final String NAME = "GX-123";
	public static final double PRICE = 25.35;
	public static double WEIGHT = 3.5;
	private Dimension dimension = DIMENSION;
	private double weight = WEIGHT;
	private String vendor = VENDOR;
	private String name = NAME;
	private double price = PRICE;

	public ComputerCaseBuilder vendor(String vendor) {
		this.vendor = vendor;
		return this;
	}

	public ComputerCaseBuilder name(String name) {
		this.name = name;
		return this;
	}

	public ComputerCaseBuilder price(double price) {
		this.price = price;
		return this;
	}

	public ComputerCaseBuilder dimension(Dimension dimension) {
		this.dimension = dimension;
		return this;
	}

	public ComputerCaseBuilder weight(double weight) {
		this.weight = weight;
		return this;
	}

	public ComputerCase build() {
		ComputerCase computerCase = new ComputerCase(vendor, name, price);
		computerCase.setDimension(dimension);
		computerCase.setWeight(weight);
		return computerCase;

	}
}
