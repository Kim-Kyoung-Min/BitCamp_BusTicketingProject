package spms.dao;

import java.util.List;

import spms.vo.Manager;

public interface ManagerDao {
	List<Manager> selectList(Manager manager) throws Exception;	
	List<Manager> selectListMypage(Manager manager) throws Exception;
	List<Manager> allSelectList(Manager manager) throws Exception;
	Manager selectOne(int no) throws Exception;	
	List<Manager> update(Manager manager) throws Exception;	//예매 버튼 클릭 시 남은좌석만 수정
	public int delete(int busNo) throws Exception;
}

