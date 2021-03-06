package com.roadruwa.vo;

import java.sql.Timestamp;
import java.util.List;

public class CommentVo extends BaseVO{
	private int cNum; 
    private String cContent;
    private Timestamp cReg;
    private int bNum;
    private String cId;
    private String Star;
    private String cPic;
    private List<BoardVo> boardMap;
    
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public Timestamp getcReg() {
		return cReg;
	}
	public void setcReg(Timestamp cReg) {
		this.cReg = cReg;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getStar() {
		return Star;
	}
	public void setStar(String star) {
		Star = star;
	}
	public String getcPic() {
		return cPic;
	}
	public void setcPic(String cPic) {
		this.cPic = cPic;
	}
	public List<BoardVo> getBoardMap() {
		return boardMap;
	}
	public void setBoardMap(List<BoardVo> boardMap) {
		this.boardMap = boardMap;
	}

	
}
