package pl.krepam.Game;

import java.util.LinkedList;
import java.util.List;

public class Rook extends ChessPiece {
	private boolean wasMoved;

	public boolean getWasMoved() {
		return wasMoved;
	}

	public void setWasMoved(boolean wasMoved) {
		this.wasMoved = wasMoved;
	}

	public Rook(short x, short y, short value, boolean color, boolean wasMoved) {
		super();
		this.wasMoved = wasMoved;
	}

	@Override
	public List<Position> returnInfluence(Board board) {
		List<Position> pos = new LinkedList<>();
		short[][] help = {{1,0}, {0,-1}, {-1,0}, {1,0}};
		short x;
		short y;
		for(short i=0; i<4; i++)
		{
			x = (short) (this.getX() + help[i][0]);
			y = (short) (this.getY() + help[i][1]);
			while(board.czy_jest_w_planszy(x, y) && !board.isPosition(x, y)) {
				if(!board.nazwa(this.getX(), this.getY(), x, y, this.isColor()))	pos.add(new Position(x,y));
				x += help[i][0];
				y += help[i][1];
			}
			if(board.czy_jest_w_planszy(x, y) && !board.checkColor(x, y, this.isColor()) && !board.nazwa(this.getX(), this.getY(), x, y, this.isColor()))	pos.add(new Position(x,y));
		}
		return pos;
	}
	
	
}
