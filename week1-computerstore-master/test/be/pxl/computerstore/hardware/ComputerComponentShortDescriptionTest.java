package be.pxl.computerstore.hardware;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import be.pxl.computerstore.hardware.builder.MouseBuilder;
import be.pxl.computerstore.hardware.builder.ProcessorBuilder;


public class ComputerComponentShortDescriptionTest {
	@Test
	public void processorShortDescriptionTest() {
		Processor processor = new ProcessorBuilder().build();
		String stringUnderTest = processor.getShortDescription();
		assertEquals(processor.getArticleNumber() + " * " + processor.getName() + " * " + processor.getPrice() + "€", stringUnderTest);
	}
	
	@Test
	public void mouseShortDescriptionTest() {
		Mouse mouse = new MouseBuilder().build();
		String stringUnderTest = mouse.getShortDescription();
		assertEquals(mouse.getArticleNumber() + " * Mouse * " + mouse.getName() + " * " + mouse.getPrice() + "€", stringUnderTest);
	}
}
