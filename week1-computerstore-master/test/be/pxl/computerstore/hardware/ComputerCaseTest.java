package be.pxl.computerstore.hardware;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import be.pxl.computerstore.hardware.ComputerCase;
import be.pxl.computerstore.hardware.builder.ComputerCaseBuilder;
import be.pxl.computerstore.hardware.builder.DimensionBuilder;
import be.pxl.computerstore.util.Dimension;

public class ComputerCaseTest {
	private static final String VENDOR = "Sharkoon";
	private static final String NAME = "VG4-S";
	private static final double PRICE = 28.13;
	private static final int WIDTH = 1001;
	private static final int HEIGHT = 1002;
	private static final int DEPTH = 1003;
	private static final double WEIGHT = 12.23;
	
	
	@Test
	public void vendorNameAndPriceAreCorrectWhenCreatingNewComputerCase() {
		ComputerCase computerCase = new ComputerCase(VENDOR, NAME, PRICE);
		assertEquals(VENDOR, computerCase.getVendor());
		assertEquals(NAME, computerCase.getName());
		assertEquals(PRICE, computerCase.getPrice(), 0.001);
	}
	
	@Test
	public void setterAndGetterForComputerCaseDimension() {
		ComputerCase computerCase = new ComputerCaseBuilder().build();
		Dimension dimension = new DimensionBuilder().depth(DEPTH).height(HEIGHT).width(WIDTH).build();
		computerCase.setDimension(dimension);
		assertNotNull(computerCase.getDimension());
		assertEquals(WIDTH, computerCase.getDimension().getWidth());
		assertEquals(HEIGHT, computerCase.getDimension().getHeight());
		assertEquals(DEPTH, computerCase.getDimension().getDepth());
	}
	
	@Test
	public void setterAndGetterForComputerCaseWeight() {
		ComputerCase computerCase = new ComputerCaseBuilder().build();
		computerCase.setWeight(WEIGHT);
		assertEquals(WEIGHT, computerCase.getWeight(), 0.001);
	}
	
}
