package be.pxl.computerstore.hardware;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import be.pxl.computerstore.hardware.builder.ComputerCaseBuilder;
import be.pxl.computerstore.hardware.builder.MouseBuilder;
import be.pxl.computerstore.hardware.builder.ProcessorBuilder;
import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystemComputableTest {

	@Test
	public void totalPriceExclReturnsSumOfAllComputerComponents() throws TooManyPeripheralsException {
		ComputerSystem computerSystem = new ComputerSystem();
		Processor processor = new ProcessorBuilder().build();
		ComputerCase computerCase = new ComputerCaseBuilder().build();
		Mouse peripheral1 = new MouseBuilder().build();
		Mouse peripheral2 = new MouseBuilder().build();
		computerSystem.setComputerCase(computerCase);
		computerSystem.setProcessor(processor);
		computerSystem.addPeripheral(peripheral1);
		computerSystem.addPeripheral(peripheral2);
		double total = processor.getPrice() + computerCase.getPrice() + peripheral1.getPrice() + peripheral2.getPrice();
		assertEquals(total, computerSystem.totalPriceExcl(), 0.001);
		assertEquals(total * 1.21, computerSystem.totalPriceIncl(), 0.001);
	}
}
