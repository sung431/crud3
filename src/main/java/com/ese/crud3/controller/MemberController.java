package com.ese.crud3.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ese.crud3.Pagination;
import com.ese.crud3.service.DepartmentService;
import com.ese.crud3.service.MemberService;
import com.ese.crud3.vo.MemberVO;

@Controller
public class MemberController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "memberService")
	private MemberService memberService;
	
	@Resource(name = "departmentService")
	private DepartmentService departmentService;
	
	@RequestMapping(name = "member/memberList.do")
	public ModelAndView selectList(@RequestParam(defaultValue="1") int curPage) throws Exception{
		ModelAndView mv = new ModelAndView("member/memberList");
		
		int listCnt = memberService.selectListCnt();
		Pagination pagination = new Pagination(listCnt, curPage);
		List<MemberVO> list = memberService.selectList(pagination);
		
		log.debug("cp : " + pagination.getCurPage() + " / si : " + pagination.getStartIndex() + " / ps : " + pagination.getPageSize());
		
		mv.addObject("list", list);
		mv.addObject("pagination", pagination);
		
		return mv;
	}
	
	@RequestMapping(value="member/memberAdd.do")
	public ModelAndView addView() throws Exception {
		ModelAndView mv = new ModelAndView("member/memberAdd");
		
		mv.addObject("list", departmentService.selectList());
		
		return mv;
	}
	
	@RequestMapping(value="member/memberInsert.do")
	public @ResponseBody String insert(@ModelAttribute MemberVO vo) throws Exception{
		log.debug("intsert : " + vo.getMemberName() + " / " + vo.getDepartmentVO().getDeptNo());
		
		String result = "";
		if(memberService.insert(vo) != null) {
			result = "1";
		}		
		log.debug("result : " + result);
		
		return result;
	}
	
	@RequestMapping(value="member/memberView.do")
	public ModelAndView modView(@RequestParam("member_no") int memberNo) throws Exception{
		ModelAndView mv = new ModelAndView("member/memberView");
		mv.addObject("list", departmentService.selectList());
		mv.addObject("dto", memberService.selectOne(memberNo));
		return mv;
	}
	
	@RequestMapping(value="member/memberUpdate.do")
	public @ResponseBody String update(@ModelAttribute MemberVO vo) throws Exception{
		log.debug("update : " + vo.getMemberName() + " / " + vo.getDepartmentVO().getDeptNo());
		
		String result = "";
		if(memberService.update(vo) != null) {
			result = "1";
		}		
		log.debug("result : " + result);
		
		return result;
	}
	
	@RequestMapping(value="member/memberDelete.do")
	public @ResponseBody String delete(@RequestParam("memberNo") int memberNo) throws Exception{
		log.debug("delete : " + memberNo);
		
		String result = String.valueOf(memberService.delete(memberNo));
		log.debug("result : " + result);
		
		return result;
	}
}
