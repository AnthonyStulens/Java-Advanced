package be.pxl.computerstore.util;

public class Dimension {
	private int width;
	private int height;
	private int depth;

	public Dimension(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		description.append("Width = ").append(width).append("mm").append("\n");
		description.append("Height = ").append(height).append("mm").append("\n");
		description.append("Depth = ").append(depth).append("mm").append("\n");
		return description.toString();
	}
}
