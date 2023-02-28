package org.joinup.app.controller;

import lombok.RequiredArgsConstructor;
import org.joinup.app.domain.BoardDTO;
import org.joinup.app.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class BoardController {
    private final BoardService boardService;
    @GetMapping("/boardWrite")
    public String saveBoard(){
        return "boardwrite";
    }
    @PostMapping("/boardWrite")
    public String save(@ModelAttribute BoardDTO boardDTO, HttpSession session){
        boardDTO.setBoardWriter((String)(session.getAttribute("loginEmail")));
        int saveResult = boardService.save(boardDTO);
        if(saveResult > 0){
            return "index";
        }else{
            return "boardwrite";
        }
    }
    @GetMapping("/board")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList",boardDTOList);
        return "board";
    }
}
