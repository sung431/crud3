package com.ese.crud3.service;

import java.util.List;

import com.ese.crud3.vo.DepartmentVO;

public interface DepartmentService {

	public List<DepartmentVO> selectList() throws Exception;

	public int insert(DepartmentVO vo) throws Exception;

	public DepartmentVO selectOne(int deptNo) throws Exception;

	public int update(DepartmentVO vo) throws Exception;

	public int delete(int deptNo) throws Exception;

	public int selectListCnt() throws Exception;

}
