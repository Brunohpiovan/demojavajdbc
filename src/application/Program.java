package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1 : seller findbyId =====");
		Seller seller = sellerdao.findBYId(3);		
		System.out.println(seller);
		
		System.out.println("\n===== TEST 2 : seller findbyDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerdao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===== TEST 3 : seller findAll =====");
		list = sellerdao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===== TEST 4 : seller insert =====");
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4002.5, department);
		sellerdao.insert(newSeller);
		System.out.println("Inserido! Novo id = "+newSeller.getId());
		
		System.out.println("\n===== TEST 5 : seller update =====");
		seller = sellerdao.findBYId(1);
		seller.setName("Leandro ferreira");
		sellerdao.update(seller);
		System.out.println("Update completed");
	
		System.out.println("\n===== TEST 6 : seller delete =====");
		System.out.println("Informe o id do funcionario que deseja excluir: ");
		int id = sc.nextInt();
		sellerdao.deleteById(id);
		System.out.println("Delete completed.");
		
		
		sc.close();
	}	
	

}
