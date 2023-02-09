package org.joinup.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @GetMapping("/404")
    public String error() {
        return "404";
    }

    @GetMapping("/index")
    public String index() {

        return "index";
    }

    @GetMapping("/blank")
    public String black() {

        return "blank";
    }


    @GetMapping("/button")
    public String button() {

        return "button";
    }

    @GetMapping("/chart")
    public String chart() {

        return "chart";
    }

    @GetMapping("/element")
    public String element() {

        return "element";
    }

    @GetMapping("/form")
    public String form() {

        return "form";
    }

    @GetMapping("/signin")
    public String signin() {

        return "signin";
    }

    @GetMapping("/signup")
    public String signup() {

        return "signup";
    }

    @GetMapping("/table")
    public String table() {

        return "table";
    }

    @GetMapping("/typography")
    public String typography() {

        return "typography";
    }

    @GetMapping("/widget")
    public String widget() {

        return "widget";
    }
}
