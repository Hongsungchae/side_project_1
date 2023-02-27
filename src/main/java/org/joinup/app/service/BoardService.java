package org.joinup.app.service;

import lombok.RequiredArgsConstructor;
import org.joinup.app.domain.BoardDTO;
import org.joinup.app.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public int save(BoardDTO boardDTO) {
        return boardRepository.save(boardDTO);
    }
}
