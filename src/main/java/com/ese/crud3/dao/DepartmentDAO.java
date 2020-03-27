package com.ese.crud3.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ese.crud3.vo.DepartmentVO;

@Repository("departmentDAO")
public class DepartmentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<DepartmentVO> selectList() {
		return sqlSession.selectList("department.listAll");
	}
	
	public int insert(DepartmentVO vo) throws Exception {
		return sqlSession.insert("department.insert", vo);
	}

	public DepartmentVO selectOne(int deptNo) throws Exception {
		return sqlSession.selectOne("department.selectOne", deptNo);
	}

	public int update(DepartmentVO vo) throws Exception {
		return sqlSession.update("department.update", vo);
	}

	public int delete(int deptNo) throws Exception {
		return sqlSession.delete("department.delete", deptNo);
	}

	public int selectListCnt() throws Exception{
		return sqlSession.selectOne("department.selectListCnt");
	}
}
