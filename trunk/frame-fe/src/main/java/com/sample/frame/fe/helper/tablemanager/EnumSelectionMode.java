/**
 * 
 */
package com.sample.frame.fe.helper.tablemanager;


/**
 * Enum�ration des modes de s�lection
 * Exemple : Dans un tableau : s�lection multiple ou simple
 * 
 *
 */
public enum EnumSelectionMode {
	
	/**
	 * Selection unique
	 */
	SINGLE("single"),
	
	/**
	 * Selection multiple
	 */
	MULTI("multi");
		
	/**
	 * Valeur 
	 */
	private final String value; 
	
	
	private EnumSelectionMode(String value){
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
