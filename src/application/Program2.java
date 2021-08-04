package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("TESTE 1 = INSERT");
		Department newDepartment = new Department(5,"Musica");
		departmentDao.insert(newDepartment);
		System.out.println("TESTE 2 = UPDATE");
		Department department = departmentDao.findById(1);
		department.setName("Phones");
		departmentDao.update(department);
		System.out.println("Update completed");
		System.out.println("\n=== TEST 3: seller delete =====");
		System.out.println("Enter id for delete test: ");
		departmentDao.deleteById(sc.nextInt());
		System.out.println("Delete completed");
		System.out.println("\n=== TEST 2: findAll =======");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		System.out.println("=== TEST 1: findById =======");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
	}

}
