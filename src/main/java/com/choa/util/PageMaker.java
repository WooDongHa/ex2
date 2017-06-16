package com.choa.util;

public class PageMaker {
	private int curPage;
	private int perPage;
	private int totalCount;
	private int perBlock;
	
	public PageMaker(int curPage, int totalCount) {
		this(curPage, totalCount, 10);
	}
	
	public PageMaker(int curPage, int totalCount, int perPage){
		this.curPage=curPage;
		this.totalCount=totalCount;
		this.perPage=perPage;
		this.perBlock=5;
	}
	
	
	
	//startRow, lastRow
	public RowMaker getRowMaker(){
		RowMaker rowMaker = new RowMaker();
		rowMaker.makeRow(curPage, perPage);
		return rowMaker;
		
	}
	
	//startNum, lastNum
	public PageResult getPageResult(){
		PageResult pageResult = new PageResult();
		pageResult.makePage(totalCount, perPage, perBlock, curPage);
		return pageResult;
	}

	
	

}
