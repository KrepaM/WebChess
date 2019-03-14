package pl.krepam.Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {
	private List<ChessPiece> pieces;
	private boolean move;
	
	public Board() {
		pieces = new LinkedList<>();
		move = false;
		for(short i=0; i<8; i++)
		{
			pieces.add(new Pawn((short)((short)i+1),(short) 2, (short) 1, false, false));
		}
		for(short i=8; i<16; i++)
		{
			pieces.add(new Pawn((short)((short)i+1),(short) 7, (short) 1, true, false));
		}
		pieces.add(new Rook((short)1 , (short) 1, (short) 5, false, false));
		pieces.add(new Rook((short)8 , (short) 1, (short) 5, false, false));
		pieces.add(new Rook((short)1 , (short) 8, (short) 5, true, false));
		pieces.add(new Rook((short)8 , (short) 8, (short) 5, true, false));
		pieces.add(new Knight((short)2 , (short) 1, (short) 3, false));
		pieces.add(new Knight((short)7 , (short) 1, (short) 3, false));
		pieces.add(new Knight((short)2 , (short) 8, (short) 3, true));
		pieces.add(new Knight((short)7 , (short) 8, (short) 3, true));
		pieces.add(new Bishop((short)3 , (short) 1, (short) 3, false));
		pieces.add(new Bishop((short)6 , (short) 1, (short) 3, false));
		pieces.add(new Bishop((short)3 , (short) 8, (short) 3, true));
		pieces.add(new Bishop((short)6 , (short) 8, (short) 3, true));
		pieces.add(new Queen((short)4 , (short) 1, (short) 9, false));
		pieces.add(new Queen((short)4 , (short) 8, (short) 9, true));
		pieces.add(new King((short)5 , (short) 1, (short) 0, false, false, false));
		pieces.add(new King((short)5 , (short) 8, (short) 0, true, false, false));
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public List<ChessPiece> getPieces() {
		return pieces;
	}	
	
	public boolean isPosition(int x, int y) {
		for(ChessPiece a : pieces) {
			if(a.getX()==x && a.getY()==y)	return true;
		}
		return false;
	}
	
	public boolean checkColor(int x, int y, boolean color) {
		for(ChessPiece a : pieces) {
			if(a.getX()==x && a.getY()==y && a.isColor()==color) return true;
		}
		return false;
	}
	
	public boolean isCheck(boolean color) {
		Position king = null;
		List<Position> pos = new LinkedList<>();
		for(ChessPiece a : pieces) {
			if(a.getValue()==0 && a.isColor()==color)	king = new Position(a.getX(),a.getY());
		}
		for(ChessPiece a : pieces) {
			if(a.isColor()!=color) {
				pos = a.returnInfluence(this);
				if(pos.contains(king))	return true;
			}
		}
		return false;
	}
	
	public void Move(short x1, short y1, short x2, short y2) {//sprawdzanie czy przeciwnik nie chce ruszyc sie pionkiem przeciwnika(Mozna sprawdzic w REST API)
		for(ChessPiece a : pieces) {
			if(a.getX()==x1 && a.getY()==y1) {
				a.setX(x2); a.setY(y2);
			}
		}
	}
	
	public boolean nazwa(short x1, short y1, short x2, short y2, boolean color) {//nowa nazwa
		this.Move(x1, y1, x2, y2);
		boolean val = this.isCheck(color);
		this.Move(x2, y2, x1, y1);
		return val;
	}
	
	public boolean czy_jest_w_planszy(short x, short y) {//inna nazwa
		if(x<9 && x>0 && y<9 && y>0)	return true;
		return false;
	}
	
	public ChessPiece getPiece(short x, short y) {
		for(ChessPiece a : pieces) {
			if(a.getX()==x && a.getY()==y)	return a;
		}
		return null;
	}
	
	public Pawn getPawn(short x, short y) {
		for(ChessPiece a : pieces) {
			if(a.getX()==x && a.getY()==y && a.getValue()==0)	return (Pawn) a;
		}
		return null;
	}
}
