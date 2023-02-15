package org.joinup.app.domain;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

}
