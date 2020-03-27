package com.ese.crud3.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ese.crud3.vo.DepartmentVO;

public interface DepartmentRepositroy extends JpaRepository<DepartmentVO, Integer>{

}
