package com.roadruwa.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.roadruwa.comm.UserException;
import com.roadruwa.comm.web.FileUploader;
import com.roadruwa.service.BoardService;
import com.roadruwa.service.PointService;
import com.roadruwa.vo.BoardDayVo;
import com.roadruwa.vo.BoardVo;
import com.roadruwa.vo.BuyVo;
import com.roadruwa.vo.CommentVo;
import com.roadruwa.vo.FileMng;
import com.roadruwa.vo.MessageVo;
import com.roadruwa.vo.PointVo;

@Controller
public class ContentController {

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private PointService pointSerivce;

	@RequestMapping("/writeForm.do")
	public String writeForm() {
		return "writeForm";
	}
	@RequestMapping("/contentForm.do")
	public String contentForm() {
		return "contentForm";
	}
	
	@RequestMapping("/buyPro.do")
	public String buyPro(@RequestParam("b_num") String b_num, Model model, CommentVo vo) {
		BoardVo result = boardService.contentview(b_num);
		List<BoardDayVo> results = boardService.contentdayview(b_num);
		List<CommentVo> comment = boardService.commentview(b_num);
		String count = boardService.commentCount(b_num);
		
		model.addAttribute("result", result);
		model.addAttribute("results", results);
		model.addAttribute("comment", comment);
		model.addAttribute("count", count);
		
		return "contentForm";
	}
	
	// 댓글 등록
	@RequestMapping(value = "/commnetWrite.do", method = RequestMethod.POST)
	public String commnetWrite(HttpServletRequest request, @RequestParam("b_num") int b_num, BoardVo bo,
			BindingResult bindingResults, CommentVo vo, BindingResult bindingResult, HttpServletResponse response,
			HttpSession session) throws Exception {
	
		response.setContentType("text/plain");

		String uploadPath = "D:\\dev_room\\upload" + File.separatorChar + "dadang";
		FileUploader fileUploader = new FileUploader();
		List<FileMng> upFiles = fileUploader.uploadFile(request, response, uploadPath);
		String u_id = (String) session.getAttribute("u_id");
		vo.setcId(u_id);
		vo.setcPic(upFiles.get(0).getSavedNm());
		vo.setbNum(b_num);
		boardService.commnetWrite(vo);

		// 50개당 100원 증가 (글가격)
		String a = Integer.toString(b_num);
		String count = boardService.commentCount(a);
		int counts = Integer.parseInt(count);
		BoardVo result = boardService.contentview(a);
		int price = result.getbPrice();

		if (counts >= (price + 100) / 2) {
			int total = price + 100;
			bo.setbPrice(total);
			bo.setbNum(b_num);
			boardService.upPrice(bo);
			
		}
		return "redirect:/buyPro.do?b_num=" + b_num;
	}

	//댓글 삭제
	@RequestMapping("/cdelete.do")
	public String cdelete(@RequestParam("b_num") int b_num, @RequestParam("c_num") int c_num) {
		boardService.cdelete(c_num);
		return "redirect:/buyPro.do?b_num=" + b_num;
	}
	
	@RequestMapping("/delForm.do")
	public String delForm(@RequestParam("b_num") int b_num) {
		boardService.delForm(b_num);
		return "redirect:/myPage.do";
	}
	
	@RequestMapping("/content.do")
	public String content(@RequestParam("b_num") int b_num) {
		System.out.println(b_num);
		return "redirect:/myPage.do";
	}
		
	//사용자 게시글 구매 여부
	@RequestMapping("/buycheck.do")
	public String buycheck(@RequestParam("b_num") String b_num, Model model, HttpSession session) {
		String u_id = (String)session.getAttribute("u_id");
		BoardVo result =  boardService.contentview(b_num);
		PointVo point = pointSerivce.points(u_id);
		
		model.addAttribute("point", point);
		model.addAttribute("result", result);
		return "buycheck";
	}
	
	//글구매
	@RequestMapping("/userBuy.do")
	public String userBuy(HttpSession session,@RequestParam("b_num") int b_num, @RequestParam("buyPrice") int buyPrice, BuyVo vo, PointVo point, Model model) {
		String u_id = (String)session.getAttribute("u_id");
		String result = pointSerivce.nowpoint(u_id);
		
		 int rpoint =  Integer.parseInt(result);
		 if(rpoint > buyPrice) {
		  vo.setbNum(b_num);
		  vo.setBuyPrice(buyPrice);
		  vo.setBuyer(u_id);
		  int a = 1 + vo.getBuyCount();
		  vo.setBuyCount(a);
		 boardService.userBuy(vo);
		 
		 //포인트
		 point.setuId(u_id);
		 point.settPoint(-buyPrice);
		 int b = rpoint - buyPrice;
		 point.setrPoint(b);
		 pointSerivce.userBuy(point);
		
		 return "redirect:/myBuy.do";
		 
		 }else {
			model.addAttribute("msg", "포인트가 부족합니다.");
			return "redirect:/myPoint.do";
		 }
	
	}
	
	//댓글 수정
	@RequestMapping(value ="/cupdate.do", method = RequestMethod.POST)
	public String cupdate(@RequestParam("b_num") int b_num, @RequestParam("c_num") int c_num, HttpServletRequest request, HttpServletResponse response, HttpSession session, CommentVo vo, BindingResult bindingResult) throws Exception {
		
        response.setContentType("text/plain");
		
    	if (!(request instanceof MultipartHttpServletRequest)) {
			throw new UserException("dd");
		}
        
		String uploadPath = "D:\\dev_room\\upload" + File.separatorChar + "dadang";
		FileUploader fileUploader = new FileUploader();
		List<FileMng> upFiles = fileUploader.uploadFile(request, response, uploadPath);
		
		String u_id =(String) session.getAttribute("u_id");
	    vo.setcId(u_id);
        vo.setcPic(upFiles.get(0).getSavedNm());
        vo.setbNum(b_num);
        vo.setcNum(c_num);
		
		boardService.cupdate(vo);
		
		return "redirect:/buyPro.do?b_num=" + b_num;
	}
	
    //게시글 등록
	@RequestMapping(value = "/contentForm.do", method = RequestMethod.POST)
	public String contentForm(BoardVo board, BindingResult bindingResult,BoardDayVo dayvo, BindingResult bindingResults, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {

		response.setContentType("text/plain");

		if (!(request instanceof MultipartHttpServletRequest)) {
			throw new UserException("dd");
		}
		
		String uploadPath = "D:\\dev_room\\upload" + File.separatorChar + "dadang";
		FileUploader fileUploader = new FileUploader();
		List<FileMng> upFiles = fileUploader.uploadFile(request, response, uploadPath);
		board.setbPic1(upFiles.get(0).getSavedNm());
		board.setbPic2(upFiles.get(1).getSavedNm());
		board.setbPic3(upFiles.get(2).getSavedNm());

		String u_id = (String) session.getAttribute("u_id");
		board.setuId(u_id);
		boardService.boardinsert(board);

	   String[] b_trav = request.getParameterValues("bTrav");
	   String[] b_food = request.getParameterValues("bFood");
	   String[] b_trans = request.getParameterValues("bTrans");
	   String[] b_stay = request.getParameterValues("bStay");
	   String[] b_cont = request.getParameterValues("bCont");
	   String[] b_post = request.getParameterValues("bPost");
	
		for (int i = 0; i < b_trav.length; i++) {
			dayvo.setbNum(board.getbNum());
			dayvo.setbDay((i + 1) + "");
			dayvo.setbTrav(b_trav[i]);
			dayvo.setbFood(b_food[i]);
			dayvo.setbTrans(b_trans[i]);
			dayvo.setbStay(b_stay[i]);
			dayvo.setbCont(b_cont[i]);
			dayvo.setbPost(b_post[i]);
			boardService.boardDayinsert(dayvo);

			int a = Integer.parseInt(dayvo.getbTrav());
			int b = Integer.parseInt(dayvo.getbFood());
			int c = Integer.parseInt(dayvo.getbTrans());
			int d = Integer.parseInt(dayvo.getbStay());
			String bnum = Integer.toString(board.getbNum());
			BoardVo result = boardService.contentview(bnum);
			int e = result.getbAc();
			board.setbNum(board.getbNum());
			board.setbAc(a + b + c + d + e);
			boardService.acUpdate(board);
	 
	   }
		return "redirect:/myPage.do";
	}
	
	//파일 업로드
	@RequestMapping(value = "/Upload.do", method = RequestMethod.POST)
	@ResponseBody
    public ResponseEntity<?> Upload(@RequestParam("file") MultipartFile file,HttpServletRequest request, HttpServletResponse response) {
		
        try {
			String uploadPath = "D:\\dev_room\\upload" + File.separatorChar +"dadang";
			FileUploader fileUploader = new FileUploader();
			List<FileMng> upFiles = fileUploader.uploadFile(request, response, uploadPath);
			ResponseEntity<?> name = ResponseEntity.ok().body("/image/" + upFiles.get(0).getSavedNm());
			
            return name;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
	
	@RequestMapping(value = "/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@RequestParam("b_num") String b_num, Model model) {
		BoardVo result =  boardService.contentview(b_num);
		List<BoardDayVo> results = boardService.contentdayview(b_num);
	    model.addAttribute("result", result);
	    model.addAttribute("results", results);
		return "upDateForm";
	}
	
	//쪽지 messagePro.do
	@RequestMapping(value = "/messagePro.do", method = RequestMethod.POST)
	@ResponseBody
	public int messagePro(MessageVo vo, Model model) {
		int Data = vo.getbNum();
		boardService.messageWrite(vo);
	
		return Data;
	}
	
	@RequestMapping(value = "/buycount.do", method = RequestMethod.POST)
	@ResponseBody
	public void buycount(@RequestParam("b_num") int b_num, Model model) {
	}
	
}
