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
		for (MenuOption menuOption : menuOptions) {
			System.out.println(menuOption);
		}


		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your choice: ");
		String strChoice = scanner.next();
		
		for (MenuOption menuOption : menuOptions) {
			if (menuOption.getOption() == Integer.parseInt(strChoice)) {
				menuOption.performAction();
			}
		}

	}

}
