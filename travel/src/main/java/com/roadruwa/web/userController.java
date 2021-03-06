package com.roadruwa.web;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roadruwa.comm.UserException;
import com.roadruwa.comm.web.EmailSender;
import com.roadruwa.comm.web.MailUtils;
import com.roadruwa.comm.web.TempKey;
import com.roadruwa.service.PointService;
import com.roadruwa.service.userService;
import com.roadruwa.vo.Email;
import com.roadruwa.vo.PointVo;
import com.roadruwa.vo.UserVo;
@Controller
public class userController {
	private final Log logger = LogFactory.getLog(getClass());

	@Inject
	private userService userService;

	@Inject
	private PointService pointService;

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private Email email;

	@Autowired
	private JavaMailSender mailSender;
     
	@RequestMapping(value = "/loginCheck.do")
	public String loginCheck(@ModelAttribute UserVo vo, Model model, HttpSession session) {
		int result = userService.isValidUser(vo.getuId(), vo.getuPwd());

		switch (result) {
		case 0:
			// 로그인 성공
			session.setAttribute("u_id", vo.getuId());
			break;
		case 1:
			// ID존재 하지 않음.
		case 2:
			// 비밀번호가 일치하지 않음.
			break;
		default:
			// 알수 없는 로직 처리 오류
		}
		model.addAttribute("code", result);
		return "redirect:/indexPage.do";
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/indexPage.do";
	}

	@RequestMapping(value = "/insertUserVo.do", method = RequestMethod.POST)
	@Transactional
	public String insertUserVo(UserVo vo, Model model) throws Exception {
		userService.write(vo);
		UserVo vos = new UserVo();
		String authkey = new TempKey().getKey(50, false);
		vos.setAuthkey(authkey);
		vos.setuId(vo.getuId());
		userService.updateUserVo(vos);
		
		// mail 작성 관련 
		MailUtils sendMail = new MailUtils(mailSender);
		sendMail.setSubject("[다요미홈피] 회원가입 이메일 인증");
		sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
				.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
				.append("<a href='http://localhost:8080/joinConfirm.do?u_id=")
				.append(vo.getuId())
				.append("&u_email=")
				.append(vo.getuEmail())
				.append("&u_authkey=")
				.append(authkey)
				.append("' target='_blenk'>이메일 인증 확인</a>")
				.toString());
		sendMail.setFrom("dyshim12@gmail.com", "심다영");
		sendMail.setTo(vo.getuEmail());
		sendMail.send();
		model.addAttribute("send", "이메일로 인증을 해주세요");
		return "redirect:/indexPage.do";
	}

	@RequestMapping(value = "/searchIdForm.do")
	public String searchIdForm() {
		return "searchIdForm";
	}

	@RequestMapping(value = "/searchId.do")
	public String searchId(@ModelAttribute UserVo vo, Model model) {
		UserVo result = userService.isIdCheck(vo.getuName(), vo.getuEmail());
		if (result == null) {
			model.addAttribute("no_id", "존재하지 않은 회원입니다.");
		} else {
			model.addAttribute("u_id", result.getuId());
		}
		return "searchIdForm";
	}
	
	@RequestMapping(value="/joinConfirm.do", method=RequestMethod.GET)
	public String emailConfirm(HttpServletRequest request, @RequestParam("u_id") String uId , PointVo point,  Model model) throws Exception {
		
		point.setuId(uId);
		pointService.write(point);
		UserVo vo = new UserVo();
		vo.setuId(uId);
		vo.setAuthstatus(1);
		userService.updateUserVo(vo);
		model.addAttribute("auth_check","회원가입이 완료되었습니다.");
	    
		return "redirect:/indexPage.do";
	}

	
	@RequestMapping(value = "/idcheck.do")
	@ResponseBody
	public String idcheck(@RequestParam("uId") String uId) {
		String check = userService.idcheck(uId);
		return check;
	}
	
	@RequestMapping(value = "/updateUserVo.do", method=RequestMethod.POST)
	public String updateUserVo(UserVo vo, Model model, HttpSession session) {
		
			try {
				userService.updateUserVo(vo);
			} catch (UserException e) {
				e.printStackTrace();
			}
			return "redirect:/mySetting.do";
	}
	
	@RequestMapping("/DeleteUserVo.do")
	public String DeleteUserVo(@RequestParam String uId, @RequestParam String uPwd) {
		int result= userService.isValidUser(uId, uPwd);
		if(result == 0) {
			userService.DeleteUserVo(uId);
			return "redirect:/logout.do";
		}else {
			return "redirect:/indexPage.do";
		}
	}
	
	//비밀번호 찾기(이메일 인증)
	@RequestMapping(value="/searchPw.do", method=RequestMethod.GET)
	 public String sendEmailAction (@RequestParam String uId, @RequestParam String uEmail, Model model) throws Exception {

		String PASSWORD = userService.getPw(uId, uEmail);

        if(PASSWORD != null && PASSWORD != " ") {
            email.setContent("비밀번호는 "+PASSWORD+" 입니다."); // 이메일로 보낼 메시지
            email.setReceiver(uEmail); // 받는이의 이메일 주소
            email.setSubject(uId+"님 비밀번호 찾기 메일입니다."); // 이메일로 보낼 제목
             
            try {
                MimeMessage msg = mailSender.createMimeMessage();
                MimeMessageHelper messageHelper 
                = new MimeMessageHelper(msg, true, "UTF-8");
                 
                messageHelper.setSubject(email.getSubject());
                messageHelper.setText(email.getContent());
                messageHelper.setTo(email.getReceiver());
                messageHelper.setFrom("dyshim12@gmail.com"); // 보내는 이의 주소(root-context.xml 에서 선언했지만 적어줬음)
                msg.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(email.getReceiver()));
                mailSender.send(msg);
                model.addAttribute("succes", "이메일을 성공적으로 보냈습니다.");
                
            }catch(MessagingException e) {
                System.out.println("MessagingException");
                e.printStackTrace();
            }
        }else {
        	  model.addAttribute("fail", "아이디와 이메일이 일치하지 않습니다.");
        }
        return "searchIdForm";
    }
	 
}
