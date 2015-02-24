
package com.sample.frame.core.utils;

import com.sample.frame.core.logging.BaseLogger;

public class ToolBox {

    public ToolBox() {
	super();
	// 
    }

    private static boolean logIsEnabled = false; //variable pour l'activation au la d�sactivation des logs SBR
	
    private static BaseLogger logger = BaseLogger.getLogger(ToolBox.class);

    public static void debug(String s$Msg){
	// M�thode pour la gestion des logs au niveau SBR durant les tests	
	if(logIsEnabled == true) 
            logger.debug(s$Msg);		
	}
}