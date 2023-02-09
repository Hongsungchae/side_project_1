package org.joinup.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.joinup.app.domain.MemberVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberMapper {

    List<MemberVO> getMember();
}
