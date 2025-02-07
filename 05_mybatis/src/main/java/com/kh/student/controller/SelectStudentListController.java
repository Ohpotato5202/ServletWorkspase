package com.kh.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.student.model.service.StudentService;
import com.kh.student.model.vo.Student;

public class SelectStudentListController extends AbstractController{
	
	private StudentService studentService = new StudentService();
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 비지니스 로직(학생정보 조회)
		List<Student> list = studentService.selectStudentList();		
		List<Map<String, Object>> mapList = studentService.selectStudentMapList();
		
		System.out.println(list);
		
		// 2) jsp페이지에게 작업 위임
		request.setAttribute("list", list);
		
		return "student/selectList";
		
	}

}
