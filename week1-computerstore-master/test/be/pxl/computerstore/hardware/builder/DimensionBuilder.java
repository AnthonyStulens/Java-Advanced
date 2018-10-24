package be.pxl.computerstore.hardware.builder;

import be.pxl.computerstore.util.Dimension;

public class DimensionBuilder {
		public static int WIDTH = 200;
		public static int HEIGHT = 430;
		public static int DEPTH = 445;
		private int width = WIDTH;
		private int height = HEIGHT;
		private int depth = DEPTH;

		public DimensionBuilder width(int width) {
			this.width = width;
			return this;
		}

		public DimensionBuilder height(int height) {
			this.height = height;
			return this;
		}

		public DimensionBuilder depth(int depth) {
			this.depth = depth;
			return this;
		}

		public Dimension build() {
			Dimension result = new Dimension(width, height, depth);
			return result;
		}
	
}
