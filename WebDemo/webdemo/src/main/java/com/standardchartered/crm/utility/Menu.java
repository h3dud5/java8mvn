package com.standardchartered.crm.utility;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	ArrayList<MenuOption> menuOptions;

	public Menu() {
		this.menuOptions = new ArrayList<>();
	}

	public void setMenuOption(MenuOption menuOption) {
		this.menuOptions.add(menuOption);
	}

	public void handle() {

		while(true) {
			
			System.out.println("-------------------------------");
			System.out.println("|    " + "(0) Exit");
			
			for (MenuOption menuOption : menuOptions) {
				System.out.println("|    " + menuOption);
			}

			System.out.println("-------------------------------\n\n");
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter your choice: ");
			System.out.println();
			System.out.println();
			
			String strChoice = scanner.next();

			if(Integer.parseInt(strChoice) == 0) {
				System.out.print("\n\nThank you for using the system");
				return;
			}
			
			for (MenuOption menuOption : menuOptions) {
				if (menuOption.getOption() == Integer.parseInt(strChoice)) {
					menuOption.performAction();
				}
			}
		}
	}

}
