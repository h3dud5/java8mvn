package com.standardchartered.crm.utility;

public abstract class MenuOption {
	
	private int option;
	private String caption;
	
	public MenuOption(int option, String caption) {
		this.option = option;
		this.caption = caption;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public abstract void performAction();
	
	@Override
	public String toString() {
		String result = "(" + this.option + ") " + this.caption;
		return result;
	}
	
	
}
