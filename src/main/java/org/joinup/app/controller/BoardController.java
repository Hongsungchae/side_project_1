package org.joinup.app.controller;

import lombok.RequiredArgsConstructor;
import org.joinup.app.domain.BoardDTO;
import org.joinup.app.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class BoardController {
    private final BoardService boardService;
    @GetMapping("/boardWrite")
    public String saveBoard(){
        return "boardWrite";
    }
    @PostMapping("/boardWrite")
    public String save(@ModelAttribute BoardDTO boardDTO){
        int saveResult = boardService.save(boardDTO);
        if(saveResult > 0){
            return "index";
        }else{
            return "index";
        }
    }
}
