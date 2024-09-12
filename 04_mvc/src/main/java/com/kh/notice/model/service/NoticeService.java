package com.kh.notice.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;
import static com.kh.common.JDBCTemplate.*;

public class NoticeService {

	private NoticeDao dao = new NoticeDao();

	public List<Notice> selectNoticeList() {
		Connection conn = getConnection();

		List<Notice> list = dao.selectNoticeList(conn);

		close(conn);

		return list;
	}

	public int insertNotice(Notice n) {

		Connection conn = getConnection();

		int result = dao.insertNotice(conn, n);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	public int increaseCount(int noticeNo) {
		Connection conn = getConnection();

		int result = dao.increaseCount(conn, noticeNo);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public Notice selectNotice(int noticeNo) {
		Connection conn = getConnection();

		Notice n = dao.selectNotice(conn, noticeNo);

		close(conn);

		return n;

	}

}
