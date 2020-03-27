package com.ese.crud3.repositroy;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ese.crud3.vo.MemberVO;

/***
 * <VO, key type>
 * ***/
public interface MemberRepositroy extends JpaRepository<MemberVO, Integer>{
	
	List<MemberVO> findAllByOrderByMemberNoDesc();
	
	Page<MemberVO> findAll(Pageable pageable);
	
	/*@Query(value="SELECT m FROM member m offset :startIndex limit :pageSize", nativeQuery=true)
	List<MemberVO> findPageAll(@Param("pageSize") Integer pageSize, @Param("startIndex") Integer startIndex);
	
	List<MemberVO> findFirst5ByMemberNo(Integer startIndex);*/
	
	
}
