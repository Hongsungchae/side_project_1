package org.joinup.app.repository;

import lombok.RequiredArgsConstructor;
import org.joinup.app.domain.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;
    public int save(BoardDTO boardDTO) {
        return sql.insert("Board.save",boardDTO);

    }
}
