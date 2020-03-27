package com.ese.crud3.vo;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class MemberVO {
	
	@Id
	@Column(name = "member_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int memberNo;
	
	@Column(name = "member_name")
	private String memberName;
	
	@ManyToOne
	@JoinColumn(name = "dept_no", insertable = true, updatable = true)
	private DepartmentVO departmentVO;
	
	/*private int deptNo;*/
	
	public int getMemberNo() {
		return memberNo;
	}
	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}
	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/*public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}*/
	
	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", memberName=" + memberName + ", departmentVO=" + departmentVO + "]";
	}
	
}
