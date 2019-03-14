package pl.krepam.Game;

import java.util.LinkedList;
import java.util.List;

public class Pawn extends ChessPiece {
	private boolean twoSq;

	public Pawn(short x, short y, short value, boolean color, boolean twoSq) {
		super();
		this.twoSq = twoSq;
	}
	
	

	public boolean isTwoSq() {
		return twoSq;
	}



	public void setTwoSq(boolean twoSq) {
		this.twoSq = twoSq;
	}



	@Override
	public List<Position> returnInfluence(Board board) {
		List<Position> pos = new LinkedList<>();
		short x = this.getX();
		short y = this.getY();
		if(this.isColor()) {//black
			x++;
			y--;
			if(board.czy_jest_w_planszy(x, y) && board.checkColor(x, y, !this.isColor()) && board.nazwa(this.getX(), this.getY(), x, y, this.isColor()))	pos.add(new Position(x,y));
			if(board.czy_jest_w_planszy(x, y) && board.getPiece(x, y).getValue()==0 && board.getPawn(x, y).isTwoSq()==true)	pos.add(new Position(x,y));
			x = this.getX();
			y= this.getY();
			x--;
			y--;
			if(board.czy_jest_w_planszy(x, y) && board.checkColor(x, y, !this.isColor()) && board.nazwa(this.getX(), this.getY(), x, y, this.isColor()))	pos.add(new Position(x,y));
			if(board.czy_jest_w_planszy(x, y) && board.getPiece(x, y).getValue()==0 && board.getPawn(x, y).isTwoSq()==true)	pos.add(new Position(x,y));
		}
		else {//white
			x++;
			y++;
			if(board.czy_jest_w_planszy(x, y) && board.checkColor(x, y, !this.isColor()) && board.nazwa(this.getX(), this.getY(), x, y, this.isColor()))	pos.add(new Position(x,y));
			if(board.czy_jest_w_planszy(x, y) && board.getPiece(x, y).getValue()==0 && board.getPawn(x, y).isTwoSq()==true)	pos.add(new Position(x,y));
			x = this.getX();
			y = this.getY();
			x--;
			y++;
			if(board.czy_jest_w_planszy(x, y) && board.checkColor(x, y, !this.isColor()) && board.nazwa(this.getX(), this.getY(), x, y, this.isColor()))	pos.add(new Position(x,y));
			if(board.czy_jest_w_planszy(x, y) && board.getPiece(x, y).getValue()==0 && board.getPawn(x, y).isTwoSq()==true)	pos.add(new Position(x,y));
		}
		return pos;
	}

	
	
}
