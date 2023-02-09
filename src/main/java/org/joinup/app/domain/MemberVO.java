package org.joinup.app.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private Long user_no;
    private String user_id;
    private String user_pw;

}
