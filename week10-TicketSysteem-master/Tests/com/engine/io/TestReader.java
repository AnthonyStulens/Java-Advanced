package com.engine.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestReader {

	@Test
	void testReadFile() {
		String text = new Reader().read("Tests/com/engine/io/emptyFile.txt");
		assertEquals("emptyFile1>emptyFile2>", text);
	}

}
