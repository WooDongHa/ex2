package com.choa.util;

public class PageResult {
	private int totalPage;
	private int totalBlock;
	private int curBlock;
	private int startNum;
	private int lastNum;
	
	public void makePage(int totalCount, int perPage, int perBlock, int curPage){
		//1. totalCount
		//2. totalPage
		if(totalCount%perPage==0){
			this.totalPage=totalCount/perPage;
		}else {
			this.totalPage=totalCount/perPage+1;
		}
		//3. totalBlock
		if(this.totalPage%perBlock==0){
			this.totalBlock=this.totalPage/perBlock;
		}else {
			this.totalBlock=this.totalPage/perBlock+1;
		}
		//4. curBlock
		if(curPage%perBlock==0){
			this.curBlock=curPage/perBlock;
		}else {
			this.curBlock=curPage/perBlock+1;
		}
		//5. startNum, lastNum
		this.startNum=(this.curBlock-1)*perBlock+1;
		this.lastNum=this.curBlock*perBlock;
		if(this.curBlock==this.totalBlock){
			this.lastNum=this.totalPage;
		}
	}
	
	
	
	
	
	public int getTotalPage() {
		return totalPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	
	

}
