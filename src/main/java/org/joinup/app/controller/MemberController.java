package org.joinup.app.controller;

import lombok.RequiredArgsConstructor;
import org.joinup.app.domain.MemberVO;
import org.joinup.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/signin")
    public String signin(@ModelAttribute MemberVO memberVO, HttpSession session) {
        boolean loginResult = memberService.login(memberVO);
        if(loginResult){
            session.setAttribute("loginEmail", memberVO.getMemberEmail());
            session.setAttribute("loginId",memberVO.getId());

            memberVO = memberService.findByID((String)(session.getAttribute("loginEmail")));
            System.out.println("loginEmail 세션 : " + session.getAttribute("loginEmail"));
            return "index";
        }else {
            return "signin";
        }

    }
//    @PostMapping("/setting")
//    public String setting(@ModelAttribute Model model, HttpSession session) {
//        MemberVO memberVO = memberService.findByID((String)(session.getAttribute("loginEmail")));
//
//        session.setAttribute("memberName 세션 이름 : ",memberVO.getMemberName());
//        model.addAttribute("member", memberVO);
//        return "setting";
//    }
    @GetMapping("/setting")
    public String setting(HttpSession session,Model model) {
        String loginEmail = (String)(session.getAttribute("loginEmail"));
        MemberVO memberVO = memberService.findByID(loginEmail);
        model.addAttribute("member", memberVO);
        System.out.println("setting" + memberVO);
        System.out.println();
        return "setting";
    }
    @GetMapping("/signin")
    public String signin() {

        return "signin";
    }

    @GetMapping("/signup")
    public String signup() {

        return "signup";
    }
    @PostMapping("/update")
    public String updateForm(@ModelAttribute MemberVO memberVO){
        //세션에서 나의 이메일 가져오기
        String loginEmail = (String)(memberVO.getMemberEmail());
        memberVO.setId((memberService.findByID(loginEmail)).getId());
        System.out.println(memberVO);
        boolean result = memberService.update(memberVO);
        if(result){
            return "index";
        }else{
            return "setting";
        }

    }
    @GetMapping("/update")
    public String update() {

        return "setting";
    }

}
