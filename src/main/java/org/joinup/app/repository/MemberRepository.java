package org.joinup.app.repository;

import lombok.RequiredArgsConstructor;
import org.joinup.app.domain.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;
    public int save(MemberVO memberVO) {
        System.out.println(memberVO);
        return sql.insert("Member.save", memberVO);
    }

    public MemberVO login(MemberVO memberVO) {

        return sql.selectOne("Member.login", memberVO);
    }

    public MemberVO findByid(String email) {
        return sql.selectOne("Member.findById", email);
    }
}
