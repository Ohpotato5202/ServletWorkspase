package com.kh.student.model.service;

import static com.kh.common.MybatisTemplate.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.dao.StudentDao;
import com.kh.student.model.vo.Student;

public class StudentService {

	private StudentDao dao = new StudentDao();

	public int insertStudent(Student student) {

		SqlSession session = getSqlSession();

		int result = dao.insertStudent(session, student);

		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();

		return result;
	}

	public int insertStudentMap(Map<String, Object> student) {

		SqlSession session = getSqlSession();

		int result = dao.insertStudentMap(session, student);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();

		return result;
	}

	public int selectStudentCount() {
		SqlSession session = getSqlSession();

		int total = dao.selectStudentCount(session);

		session.close();

		return total;
	}

	public Student selectOneStudent(int no) {

		SqlSession session = getSqlSession();

		Student student = dao.selectOneStudent(session, no);

		session.close();

		return student;
	}

	public Map<String, Object> selectOneStudentMap(int no) {

		SqlSession session = getSqlSession();

		Map<String, Object> student = dao.selectOneStudentMap(session, no);

		session.close();

		return student;
	}

	public int updateStudent(Student student) {
		SqlSession session = getSqlSession();

		int result = dao.updateStudent(session, student);

		if (result > 0)
			session.commit();
		else
			session.rollback();
		session.close();

		return result;
	}

	public int deleteStudent(int no) {
		SqlSession session = getSqlSession();

		int result = dao.deleteStudent(session, no);

		if (result > 0)
			session.commit();
		else
			session.rollback();
		session.close();

		return result;
	}

	public List<Student> selectStudentList() {
		SqlSession sqlSession = getSqlSession();
		
		List<Student> list = dao.selectStudentList(sqlSession);
		
		sqlSession.close();
		
		return list;
		
	}

	public List<Map<String, Object>> selectStudentMapList() {
		SqlSession sqlSession = getSqlSession();
		
		List<Map<String, Object>> mapList = dao.selectStudentMapList(sqlSession);
		
		sqlSession.close();
		
		return mapList;
	}

}
