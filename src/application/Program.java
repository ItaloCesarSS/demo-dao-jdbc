package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("====TEST 1: sellerById ====");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("====TEST 2: sellerByDeparment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj: list) {
			System.out.println(obj);
		}
	}
}
		
//		Connection conn = null;
//		Statement st = null;
//		try {
//			conn = DB.getConnection();
//			
//			conn.setAutoCommit(false);
//			
//			st = conn.createStatement();
//			
//			int rows1 = st.executeUpdate(
//					"UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
//			
////			int x = 1;
////			if (x < 2) {
////				throw new SQLException("Fake error ");
////			}
//		
//			int rows2 = st.executeUpdate(
//					"UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
//			
//			conn.commit();
//			System.out.println("rows1: " + rows1);
//			System.out.println("rows2: " + rows2);
//			
//		
//			}
//		
//		catch (SQLException e ) {
//			try {
//				conn.rollback();
//				throw new DbException("Transation rolled back! Caused by: " + e.getMessage());
//			} catch (SQLException e1) {
//				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
//
//			}
//		}
//		finally {
//			DB.closeStatement(st);
//			DB.closeConnection();
//		}
////	}
//}