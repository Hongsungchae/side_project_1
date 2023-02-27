package org.joinup.app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardBoardTitle;
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreatedTime;
}
