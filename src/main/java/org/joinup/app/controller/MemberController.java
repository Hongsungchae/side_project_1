package org.joinup.app.controller;

import lombok.RequiredArgsConstructor;
import org.joinup.app.domain.MemberVO;
import org.joinup.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/home")
    public String goHome(Model model) {

        List<MemberVO> memberList = memberService.getMember();

        model.addAttribute("memberList", memberList);

        return "test/home";
    }
    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberVO memberVO) {
        int sign_result = memberService.save(memberVO);
        if(sign_result>0){
            //성공일 시
            return "signup";
        }else{
            return "signin";
        }
    }
//    @PostMapping("/signin")
//    public String signin(@ModelAttribute MemberVO memberVO, HttpSession session) {
//        boolean loginResult = memberService.login(memberVO);
//        if(loginResult){
//            session.setAttribute("loginEmail", memberVO.getMemberEmail());
//            return "index";
//        }else {
//            return "signin";
//        }
//
//    }

    @GetMapping("/signin")
    public String signin() {

        return "signin";
    }

    @GetMapping("/signup")
    public String signup() {

        return "signup";
    }


}
