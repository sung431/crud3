package com.ese.crud3.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ese.crud3.dao.DepartmentDAO;
import com.ese.crud3.repositroy.DepartmentRepositroy;
import com.ese.crud3.vo.DepartmentVO;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentRepositroy departmentRep;
	
	@Resource(name = "departmentDAO")
	DepartmentDAO departmentDAO;
	
	@Override
	public List<DepartmentVO> selectList() throws Exception {
		return departmentDAO.selectList();
	}

	@Override
	public int insert(DepartmentVO vo) throws Exception {
		return departmentDAO.insert(vo);
	}

	@Override
	public DepartmentVO selectOne(int deptNo) throws Exception {
		return departmentDAO.selectOne(deptNo);
	}

	@Override
	public int update(DepartmentVO vo) throws Exception {
		return departmentDAO.update(vo);
	}

	@Override
	public int delete(int deptNo) throws Exception {
		return departmentDAO.delete(deptNo);
	}

	@Override
	public int selectListCnt() throws Exception {
		return departmentDAO.selectListCnt();
	}

}
