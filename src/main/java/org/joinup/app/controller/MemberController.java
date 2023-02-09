package org.joinup.app.controller;

import org.joinup.app.domain.MemberVO;
import org.joinup.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/home")
    public String goHome(Model model) {

        List<MemberVO> memberList = memberService.getMember();

        model.addAttribute("memberList", memberList);

        return "test/home";
    }


}
