package com.sample.frame.fe.enums;


/**
 * Enum�ration des diff�rents types de vues
 * 
 * @author lkamhoua
 * @since 2013-03-07 - 12:02
 */
public enum EnumViewType {
	
	
	CREATION("Create"),
	
	DASHBOARD("Dashboard"),
	
	DISPLAY("Display"),
	
	EDITION("Edit"),
	
	HOME("Home"),
	
	LIST("List"),
	
	MODIFICATION("Modify"),
	
	SEARCH("Search");


	private final String value; 
	
	
	private EnumViewType(String value){
		this.value = value;
	}

	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
		
}
