/*
 */
package com.sample.frame.core.report.jasper;

import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;


/**
 *
 * @author ECHOUPE
 */
public class Summary extends JRDefaultScriptlet{
		
    public String addTocEntry(String pSectionName, Integer pPageNumber, String pTypeSection) throws JRScriptletException{
        	
        ArrayList toc = (ArrayList)this.getVariableValue("SOMMAIRE");
        String lSectionName = pSectionName;
        Integer lPageNumber = pPageNumber;
        String lTypeSection = pTypeSection; 
          
        try{
            toc.add(new Index(lSectionName, lPageNumber, lTypeSection));
        }
        catch (Exception e){
            System.out.println(e);
        }   
        
        return "";
    }

    public String generateHTMLSommaire(ArrayList pListIndex){
        	
        String lSommaireHTML = new String();
        String lBgColor = new String();
        String lCurrentNomIndex = new String();
        String lSautDeLigne = new String();
        String lMargeGauche = new String();
        String lNouvelleColonne = new String();
        	
        lBgColor = "#FFFFFF";
        lSautDeLigne = "  ";
        lNouvelleColonne = "";
        	
        lSommaireHTML = ""; 
        
        for (int i = 0; i < pListIndex.size(); i++){ 
            if(i<2){ 
                lBgColor = "#FFFFFF"; 
            } 
            //if(pListIndex.get(i).getTypeIndex().equals("titre")){ 
                //lCurrentNomIndex = pListIndex.get(i).getNomIndex().toUpperCase(); lMargeGauche = " "; 
            //}else{ 
                //lCurrentNomIndex = pListIndex.get(i).getNomIndex().toLowerCase(); lMargeGauche = "     "; 
            } 
            lSommaireHTML += ""; 
            // .....................
       	return lSommaireHTML;
    }
}
