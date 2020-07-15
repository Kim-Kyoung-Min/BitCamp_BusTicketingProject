package spms.dao;

import java.util.List;

import spms.vo.Bus;

public interface BusDao {
	public List<Bus> selectList() throws Exception;
	public int insert(Bus bus) throws Exception;
	public int delete(int no) throws Exception;
	public Bus selectOne(int no) throws Exception;
	public int update(Bus bus) throws Exception;
	public Bus exist(String email, String password) throws Exception;
	
}
