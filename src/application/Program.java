package application;

import java.util.Date;
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
		System.out.println("\n=== TEST 3: seller findAll =====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
			}
		System.out.println("\n=== TEST 4: seller insert =====");
		Seller newSeller = new Seller (null, "Greg", "gtrg@gmail.com", new Date(), 4000.0, department); 
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		System.out.println("\n=== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
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