package pl.krepam.Game;

import java.util.List;

public abstract class ChessPiece {
	private short x;
	private short y;
	private short value;
	private boolean color;
	public short getX() {
		return x;
	}
	public void setX(short x) {
		this.x = x;
	}
	public short getY() {
		return y;
	}
	public void setY(short y) {
		this.y = y;
	}
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	
	public short getValue() {
		return value;
	}
	public void setValue(short value) {
		this.value = value;
	}
	public abstract List<Position> returnInfluence(Board board);//sphere of influence
}
