package com.ese.crud3.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class DepartmentVO {
	
	@Id
	@Column(name = "dept_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deptNo;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@OneToMany
	@JoinColumn(name = "dept_no")
	private List<MemberVO> memberVO = new ArrayList<MemberVO>();
	
	public List<MemberVO> getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(List<MemberVO> memberVO) {
		this.memberVO = memberVO;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public String toString() {
		return "DepartmentVO [deptNo=" + deptNo + ", deptName=" + deptName + ", memberVO=" + memberVO + "]";
	}
	
}
