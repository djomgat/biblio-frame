/**
 * 
 */
package com.sample.frame.fe.helper.tablemanager;

/**
 * Enumération des modes de sélection dans un table de données
 * Exemple : Dans un tableau : sélection multiple ou simple
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