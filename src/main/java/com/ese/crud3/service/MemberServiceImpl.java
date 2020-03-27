package com.ese.crud3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ese.crud3.Pagination;
import com.ese.crud3.repositroy.MemberRepositroy;
import com.ese.crud3.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepositroy memberRep;
	
	@Override
	public List<MemberVO> selectList(Pagination pagination) throws Exception {
		
		/*Page<MemberVO> result = memberRep.findAll(new PageRequest(pagination.getCurPage(), pagination.getPageSize()));
		return result.getContent();*/
		
		return memberRep.findAllByOrderByMemberNoDesc();
	}

	@Override
	public MemberVO insert(MemberVO vo) {
		return memberRep.save(vo);
	}

	@Override
	public MemberVO selectOne(int memberNo) throws Exception {
		return memberRep.findOne(memberNo);
	}

	@Override
	public MemberVO update(MemberVO vo) throws Exception {
		return memberRep.save(vo);
	}

	@Override
	public int delete(int memberNo) throws Exception {
		int result = 0;
		try {
			memberRep.delete(memberNo);
			result = 1;
		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int selectListCnt() throws Exception {
		return (int)memberRep.count();
	}

}
