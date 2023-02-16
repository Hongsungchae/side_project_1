package org.joinup.app.service;

import lombok.RequiredArgsConstructor;
import org.joinup.app.domain.MemberVO;
import org.joinup.app.mapper.MemberMapper;
import org.joinup.app.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberMapper mapper;

    public List<MemberVO> getMember() {
        return mapper.getMember();
    };

    public int save(MemberVO memberVO) {
        return memberRepository.save(memberVO);
    }

    public boolean login(MemberVO memberVO) {
        MemberVO loginmember = memberRepository.login(memberVO);
        if(loginmember!=null){
            //조회 시 있을 경우
            return true;
        }else{
            //조회 시 없을 경우
            return false;
        }

    }

    public MemberVO findByID(String email) {
        return memberRepository.findByid(email);
    }
}
