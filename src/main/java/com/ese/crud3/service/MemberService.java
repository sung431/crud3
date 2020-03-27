package com.ese.crud3.service;

import java.util.List;

import com.ese.crud3.Pagination;
import com.ese.crud3.vo.MemberVO;

public interface MemberService {

	public List<MemberVO> selectList(Pagination pagination) throws Exception;

	public MemberVO insert(MemberVO vo) throws Exception;

	public MemberVO selectOne(int memberNo) throws Exception;

	public MemberVO update(MemberVO vo) throws Exception;

	public int delete(int memberNo) throws Exception;

	public int selectListCnt() throws Exception;

}
