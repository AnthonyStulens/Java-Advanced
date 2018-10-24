package be.pxl.computerstore.hardware;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import be.pxl.computerstore.hardware.builder.ProcessorBuilder;

public class ProcessorTest {
	private static final String VENDOR = "Intel";
	private static final String NAME = "i6";
	private static final double PRICE = 102.50;
	private static final double CLOCKSPEED = 1.7;
	
	
	@Test
	public void vendorNamePriceAndClockspeedAreCorrectWhenCreatingNewProcessor() {
		Processor processor = new Processor(VENDOR, NAME, PRICE, CLOCKSPEED);
		assertEquals(VENDOR, processor.getVendor());
		assertEquals(NAME, processor.getName());
		assertEquals(PRICE, processor.getPrice(), 0.001);
		assertEquals(CLOCKSPEED, processor.getClockspeed(), 0.01);
	}
	
	@Test
	public void minimumClockspeedIsUsedWhenCreatingNewProcessor() {
		Processor processor = new Processor(VENDOR, NAME, PRICE, 0.5);
		assertEquals(VENDOR, processor.getVendor());
		assertEquals(NAME, processor.getName());
		assertEquals(PRICE, processor.getPrice(), 0.001);
		assertEquals(0.7, processor.getClockspeed(), 0.01);
	}
	
	@Test
	public void setterAndGetterForClockspeed() {
		Processor processor = new ProcessorBuilder().build();
		processor.setClockspeed(3.2);
		assertEquals(3.2, processor.getClockspeed(), 0.01);
	}
	
	@Test
	public void minimumClockspeedIsUsedForSetter() {
		Processor processor = new ProcessorBuilder().build();
		processor.setClockspeed(0.65);
		assertEquals(0.7, processor.getClockspeed(), 0.01);
	}
	
}
