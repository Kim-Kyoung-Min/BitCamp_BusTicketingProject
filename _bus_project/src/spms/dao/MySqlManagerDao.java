package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import spms.annotation.Component;
import spms.vo.Manager;

@Component("managerDao")
public class MySqlManagerDao implements ManagerDao {

	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	
	@Override
	public List<Manager> selectList(Manager m) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
//		final String sqlSelect = "select departure,arrive,departureDate, departureTime, arriveTime, busInfo.busNo, busCom, spareSeat from serviceInfo left join busInfo on busInfo.busNo=serviceInfo.busNo left join lineinfo on serviceinfo.pathCode = lineinfo.pathCode where departureDate='"
//				+ m.getDepartureTime() + "' and departure='" + m.getDeparture() + "' and arrive='" + m.getArrive()
//				+ "'";
		
		final String sqlSelect = "select departureDate, departureTime, arriveTime, busInfo.busNo, busCom, spareSeat, departure, arrive from serviceInfo left join busInfo on busInfo.busNo=serviceInfo.busNo left join lineinfo on serviceinfo.pathCode = lineinfo.pathCode where departureDate='"
				+ m.getDepartureDate() + "' and departure='" + m.getDeparture() + "' and arrive='" + m.getArrive()+ "'";

		try {
			
			connection = ds.getConnection();
			stmt = connection.prepareStatement(sqlSelect);
			rs = stmt.executeQuery(sqlSelect);
			ArrayList<Manager> test = new ArrayList<Manager>();
			while (rs.next()) {
				test.add(new Manager()
						.setDepartureDate(rs.getString("departureDate"))
						.setDepartureTime(rs.getString("departureTime"))
						.setArriveTime(rs.getString("arriveTime"))
						.setBusNo(rs.getInt("busNo"))
						.setBusCom(rs.getString("busCom"))
						.setSpareSeat(rs.getInt("spareSeat"))
						.setDeparture(rs.getString("departure"))
						.setArrive(rs.getString("arrive")));
			}
			return test;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public Manager selectOne(int no) throws Exception {
		Connection connection = null;
		Manager manager = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
	    final String sqlSelectOne = "SELECT busNo,spareSeat FROM serviceInfo WHERE busNo=";
	    
	    try {
    	  connection = ds.getConnection();
	      stmt = connection.createStatement();
	      rs = stmt.executeQuery( sqlSelectOne + no);    
	      if (rs.next()) {
	    	 manager = new Manager()
	    	 .setBusNo(rs.getInt("busNo"))
	    	 .setSpareSeat(rs.getInt("spareSeat"));

	      } else {
	    	  
	      }

	    } catch (Exception e) {
	      throw e;
	    } finally {
	      try {if (rs != null) rs.close();} catch(Exception e) {}
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
		  try {if(connection != null)connection.close();}
		  catch(Exception e) {e.printStackTrace();}
	    }
	    
		return manager;
	}

	@Override
	public List<Manager> update(Manager m) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT spareSeat FROM ServiceInfo WHERE busNo='" + m.getBusNo() + "'";
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(sqlSelect); 
			rs = stmt.executeQuery(sqlSelect);
			ArrayList<Manager> test = new ArrayList<Manager>();
			  while(rs.next()) { 
				  test.add(new Manager()
						  .setSpareSeat(rs.getInt("spareSeat")));
				  }

			final String sqlUpdate = "UPDATE serviceInfo SET spareSeat="+(int)(test.get(0).getSpareSeat()-m.getTicket())+" Where busNo='"+m.getBusNo()+"'";
			stmt = connection.prepareStatement(sqlUpdate);
			stmt.executeUpdate(sqlUpdate);
			
			sqlSelect="select departureDate, departureTime, arriveTime, busInfo.busNo, busCom, spareSeat, departure, arrive from serviceInfo left join busInfo on busInfo.busNo=serviceInfo.busNo left join lineinfo on serviceinfo.pathCode = lineinfo.pathCode where departureDate='"
					+ m.getDepartureDate() + "' and departure='" + m.getDeparture() + "' and arrive='" + m.getArrive()
					+ "' and serviceInfo.busNo='"+m.getBusNo()+"'";
			stmt.executeQuery(sqlSelect);
			ArrayList<Manager> test2 = new ArrayList<Manager>();
			while (rs.next()) {
				test.add(new Manager()
						.setDepartureDate(rs.getString("departureDate"))
						.setDepartureTime(rs.getString("departureTime"))
						.setArriveTime(rs.getString("arriveTime"))
						.setBusNo(rs.getInt("busNo")).setBusCom(rs.getString("busCom"))
						.setSpareSeat(rs.getInt("spareSeat"))
						.setDeparture(rs.getString("departure"))
						.setArrive(rs.getString("arrive"))
						);
			}
			return test2;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
public int delete(int busNo) throws Exception{
		
		Connection connection = null;
	    Statement stmt = null;
	    final String sqlDelete = "UPDATE serviceInfo SET spareSeat=spareSeat-1 WHERE busNo=" + busNo;
	    try {
    	  connection = ds.getConnection();
	      stmt = connection.createStatement();
	      return stmt.executeUpdate(sqlDelete);

	    } catch (Exception e) {
	      throw e;

	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
		  try {if(connection != null)connection.close();}
		  catch(Exception e) {e.printStackTrace();}
	    }		
	}


@Override
public List<Manager> selectListMypage(Manager m) throws Exception {
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	final String sqlSelect = "select departure,arrive,departureDate, departureTime, arriveTime, busInfo.busNo, busCom, spareSeat from serviceInfo left join busInfo on busInfo.busNo=serviceInfo.busNo left join lineinfo on serviceinfo.pathCode = lineinfo.pathCode where busInfo.busNo='"
			+ m.getBusNo() + "'";

	try {
		
		connection = ds.getConnection();
		stmt = connection.prepareStatement(sqlSelect);
		rs = stmt.executeQuery(sqlSelect);
		ArrayList<Manager> test = new ArrayList<Manager>();
		while (rs.next()) {
			test.add(new Manager().setDeparture(rs.getString("departure")).setArrive(rs.getString("arrive")).setDepartureDate(rs.getString("departureDate"))
					.setDepartureTime(rs.getString("departureTime")).setArriveTime(rs.getString("arriveTime"))
					.setBusNo(rs.getInt("busNo")).setBusCom(rs.getString("busCom"))
					.setSpareSeat(rs.getInt("spareSeat")));
			System.out.println("rs.getString(departureDate) : " + rs.getString("departureDate"));
		}
		
		return test;
	} catch (Exception e) {
		throw e;
	} finally {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


@Override
public List<Manager> allSelectList(Manager m) throws Exception {
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	final String sqlSelect = "select departureDate, departureTime, arriveTime, busInfo.busNo, busCom, spareSeat, departure, arrive from serviceInfo left join busInfo on busInfo.busNo=serviceInfo.busNo left join lineinfo on serviceinfo.pathCode = lineinfo.pathCode";
			
	try {
		
		connection = ds.getConnection();
		stmt = connection.prepareStatement(sqlSelect);
		rs = stmt.executeQuery(sqlSelect);
		ArrayList<Manager> test = new ArrayList<Manager>();
		while (rs.next()) {
			test.add(new Manager()
					.setDepartureDate(rs.getString("departureDate"))
					.setDepartureTime(rs.getString("departureTime"))
					.setArriveTime(rs.getString("arriveTime"))
					.setBusNo(rs.getInt("busNo"))
					.setBusCom(rs.getString("busCom"))
					.setSpareSeat(rs.getInt("spareSeat"))
					.setDeparture(rs.getString("departure"))
					.setArrive(rs.getString("arrive")));
		}
		return test;
	} catch (Exception e) {
		throw e;
	} finally {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
}
