package pl.krepam.Game;

import java.util.LinkedList;
import java.util.List;

public class King extends ChessPiece {
	private boolean wasMoved;
	private boolean wasCastling;
	
	public boolean isWasMoved() {
		return wasMoved;
	}

	public void setWasMoved(boolean wasMoved) {
		this.wasMoved = wasMoved;
	}

	public boolean isWasCastling() {
		return wasCastling;
	}

	public void setWasCastling(boolean wasCastling) {
		this.wasCastling = wasCastling;
	}

	public King(short x, short y, short value, boolean color, boolean wasMoved, boolean wasCastling) {
		super();
		this.wasMoved = wasMoved;
		this.wasCastling = wasCastling;
	}

	@Override
	public List<Position> returnInfluence(Board board) {
		List<Position> pos = new LinkedList<>();
		short[][] help = {{1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {1,0}};
		short x;
		short y;
		for(short i=0; i<7; i++) {
			x = (short) (this.getX() + help[i][0]);
			y = (short) (this.getY() + help[i][1]);
			if(board.czy_jest_w_planszy(x, y) && !board.checkColor(x, y, this.isColor()) && !board.nazwa(this.getX(), this.getY(), x, y, this.isColor()))	pos.add(new Position(x,y));
		}
		return pos;
	}
}
