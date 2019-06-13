package com.standardchartered.crm;

import com.standardchartered.crm.utility.Menu;
import com.standardchartered.crm.utility.MenuOption;

class SCMenu {
	
	private Menu menu;
	
	public SCMenu() {
		this.menu = new Menu();
	}
	
	public Menu create() {
		MenuOption menuOption = new MenuOption(1, "List Customers") {
			public void performAction() {
				System.out.println("List Customers");
			}
		};
		
		this.menu.setMenuOption(menuOption);
		
		menuOption = new MenuOption(2, "View Customer By Id") {
			public void performAction() {
				System.out.println("View Customer By Id");
			}
		};
		
		this.menu.setMenuOption(menuOption);
		
		return this.menu;
	}
}

public class MainApp {

	
	
	public static void main(String[] args) {
		/*
		 * CustomerController customerController = new CustomerController();
		 * customerController.doListCustomers();
		 * System.out.println("-------------------------------");
		 */
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the ID: ");
//		String strId = scanner.next();
		
		//mainApp.showCustomerById(Integer.parseInt(strId));
		//System.out.println("-------------------------------");
		//mainApp.doNewCustomer();
		//System.out.println("-------------------------------");
		//mainApp.doListCustomers();
		
		//mainApp.doEditCustomer();
		//customerController.doDeleteCustomer();
		
		//customerController.doListCustomers();
		
		SCMenu scMenu = new SCMenu();
		scMenu.create().handle();
		
	}

}
