package pl.krepam.Game;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Computer {
	private boolean color;
	private Map<Position, Short> white;
	private Map<Position, Short> black;
	private Map<Position, Short> sum;

	public Computer(boolean color) {
		this.color = color;
		white = new TreeMap<>();
		black = new TreeMap<>();
		sum = new TreeMap<>();
	}
	/*
	public String getMove(Board board) {//!!!moze zamiast dodawac wartosc do listy bede dodawal figure!!!
		ChessPiece[] arr = board.getPieces();
		List<Position> pom = new LinkedList<>();
		for(short i=0; i<arr.length; i++) {
			pom = arr[i].returnInfluence(board);
			for(Position a : pom) {
				if(arr[i].isColor()) {//black
					if(black.containsKey(a)) {
						black.replace(a, black.get(a), (short) (black.get(a)+1));//dopisac * wartosc figury
					}
					else {
						black.put(a, (short) 1);
					}
				}
				else {//white
					if(white.containsKey(a)) {
						white.replace(a, black.get(a), (short) (black.get(a)+1));
					}
					else {
						white.put(a, (short) 1);
					}
				}
			}
		}
		//sortowanie mapy
		//najlepszy wynik ktory jest wykonywalny(nie powoduje szacha)
		return "null";
	}
	*/
}
