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
			
			System.out.println("===== TEST 1 : department findbyId =====");
			Department department = new Department(null, "logistica");
			departmentDao.insert(department);
			System.out.println("Inserido novo departamento de "+department.getName() + ", com id = "+department.getId());

			
			System.out.println("===== TEST 2 : department findbyId =====");
			Department newdepartment = departmentDao.findBYId(3);		
			System.out.println(newdepartment);
			
			System.out.println("\n===== TEST 3 : department update =====");
			newdepartment = departmentDao.findBYId(3);
			newdepartment.setName("Almoxarife");
			departmentDao.update(newdepartment);
			System.out.println("Departamento atualizado.");
			
			System.out.println("\n===== TEST 4 : department findAll =====");
			List<Department> list = departmentDao.findAll();
			for(Department obj : list) {
				System.out.println(obj);
			}
			
			//System.out.println("\n===== TEST 5 : department delete =====");
			//System.out.println("Informe o id do departamento que deseja excluir: ");
			//int id = sc.nextInt();
			//departmentDao.deleteById(id);
			//System.out.println("Delete completed.");
			
			sc.close();
	}

}
