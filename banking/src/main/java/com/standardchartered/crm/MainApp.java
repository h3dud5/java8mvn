package com.standardchartered.crm;

import com.standardchartered.crm.controllers.AccountController;
import com.standardchartered.crm.controllers.CustomerController;
import com.standardchartered.crm.utility.Menu;
import com.standardchartered.crm.utility.MenuOption;

class SCAccountMenu {

	private Menu menu;

	public SCAccountMenu() {
		this.menu = new Menu();
	}

	public Menu create() {
		MenuOption menuOption = new MenuOption(1, "List Accounts By Customer Id") {
			public void performAction() {
				AccountController accountController = new AccountController();
				accountController.doListAccounts();

			}
		};

		this.menu.setMenuOption(menuOption);

		menuOption = new MenuOption(2, "View Account By Id") {
			public void performAction() {
				AccountController accountController = new AccountController();
				accountController.doViewAccountById();
			}
		};
		this.menu.setMenuOption(menuOption);
		
		menuOption = new MenuOption(3, "Add a New Account") {
			public void performAction() {
				AccountController accountController = new AccountController();
				accountController.doNewAccount();
			}
		};
		this.menu.setMenuOption(menuOption);

		menuOption = new MenuOption(4, "Edit Existing Account") {
			public void performAction() {
				AccountController accountController = new AccountController();
				accountController.doEditAccount();
			}
		};
		this.menu.setMenuOption(menuOption);
		
		menuOption = new MenuOption(5, "Delete Account") {
			public void performAction() {
				AccountController accountController = new AccountController();
				accountController.doDeleteAccount();
			}
		};
		this.menu.setMenuOption(menuOption);
	
		return this.menu;
	}
}

class SCMenu {

	private Menu menu;

	public SCMenu() {
		this.menu = new Menu();
	}

	public Menu create() {
		MenuOption menuOption = new MenuOption(1, "List Customers") {
			public void performAction() {
				CustomerController customerController = new CustomerController();
				customerController.doListCustomers();

			}
		};

		this.menu.setMenuOption(menuOption);

		menuOption = new MenuOption(2, "View Customer By Id") {
			public void performAction() {
				CustomerController customerController = new CustomerController();
				customerController.doViewCustomerById();
			}
		};
		this.menu.setMenuOption(menuOption);
		
		menuOption = new MenuOption(3, "Add a New Customer") {
			public void performAction() {
				CustomerController customerController = new CustomerController();
				customerController.doNewCustomer();
			}
		};
		this.menu.setMenuOption(menuOption);

		menuOption = new MenuOption(4, "Edit Existing Customer") {
			public void performAction() {
				CustomerController customerController = new CustomerController();
				customerController.doEditCustomer();
			}
		};
		this.menu.setMenuOption(menuOption);
		
		menuOption = new MenuOption(5, "Delete Customer") {
			public void performAction() {
				CustomerController customerController = new CustomerController();
				customerController.doDeleteCustomer();
			}
		};
		this.menu.setMenuOption(menuOption);
		
		menuOption = new MenuOption(6, "Manage Accounts") {
			public void performAction() {
				SCAccountMenu scAccountMenu = new SCAccountMenu();
				scAccountMenu.create().handle();
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

		// mainApp.showCustomerById(Integer.parseInt(strId));
		// System.out.println("-------------------------------");
		// mainApp.doNewCustomer();
		// System.out.println("-------------------------------");
		// mainApp.doListCustomers();

		// mainApp.doEditCustomer();
		// customerController.doDeleteCustomer();

		// customerController.doListCustomers();

		SCMenu scMenu = new SCMenu();
		scMenu.create().handle();

	}

}
