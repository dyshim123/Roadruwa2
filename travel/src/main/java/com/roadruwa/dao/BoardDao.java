package com.roadruwa.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.roadruwa.vo.BoardDayVo;
import com.roadruwa.vo.BoardVo;
import com.roadruwa.vo.BuyVo;
import com.roadruwa.vo.CommentVo;
import com.roadruwa.vo.MessageVo;

public interface BoardDao {
	
	//게시글
	public List<BoardVo> getBoardList(@Param("lotation")String lotation, @Param("day")Integer day,
			@Param("cost")Integer cost, @Param("trans")String trans, @Param("tema")String tema,
			@Param("search")String search);
	
	public List<BoardVo> getBoardpopList(@Param("lotation")String lotation, @Param("day")Integer day,
			@Param("cost")Integer cost, @Param("trans")String trans, @Param("tema")String tema,
			@Param("search")String search);
	
	public List<BuyVo> buyCount(@Param("b_num")Integer b_num);
	
	public List<BoardVo> myWrite(@Param("u_id")String u_id);
	
	public int boardinsert(BoardVo board);
	
    public void boardDayinsert(BoardDayVo dayvo);
    
    public BoardVo contentview(@Param("b_num")String b_num);
    
    public List<BoardDayVo> contentdayview(@Param("b_num")String b_num);
    
    //댓글
    public void commnetWrite(CommentVo vo);
    
    public List<CommentVo> commentview(@Param("b_num")String b_num);
    
    public void cdelete(@Param("c_num")int c_num);
    
    public String commentCount(@Param("b_num")String b_num);
    
    public void cupdate(CommentVo vo);
    
    public void acUpdate(BoardVo vo);
    
    public void delForm(@Param("b_num")int b_num);
    
    //쪽지
    public void messageWrite(MessageVo vo);
    
    public List<MessageVo> msgList(@Param("u_id")String u_id);
    
    public List<MessageVo> msgLists(@Param("u_id")String u_id);
    
    public MessageVo sendMessage(@Param("mNum")int mNum);
    
    public void replyMessage(MessageVo vo);
    
    public void delmessage(MessageVo vo);
    
    public void managerMsg(MessageVo vo);
    
    public void upPrice(BoardVo bo);
    
    //구매
    public List<BoardVo> buyList(@Param("u_id")String u_id);
    
    public List<BuyVo> userBuyList(@Param("u_id")String u_id);
    
    public void userBuy(BuyVo vo);
}