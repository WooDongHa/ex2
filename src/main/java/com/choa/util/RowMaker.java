package com.choa.util;

public class RowMaker {
	private int startRow;
	private int lastRow;
	public int getStartRow() {
		return startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	
	//
	public void makeRow(int curPage, int perPage){
		startRow=(curPage-1)*perPage+1;
		lastRow=curPage*perPage;
	}
	
	


}
