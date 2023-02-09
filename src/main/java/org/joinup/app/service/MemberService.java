package org.joinup.app.service;

import org.joinup.app.domain.MemberVO;
import org.joinup.app.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    public MemberMapper mapper;
    public List<MemberVO> getMember() {
        return mapper.getMember();
    };
}
