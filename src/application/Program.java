package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		System.out.println("===== TEST 1 : seller findbyId=====");
		Seller seller = sellerdao.findBYId(3);
		
		System.out.println(seller);

	}

}
