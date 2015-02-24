/**
 * 
 */
package com.sample.frame.core.xtream;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.report.jasper.Constants;
import com.sample.frame.core.utils.FrameResourceLocator;
import java.util.HashMap;

/**
 * @author btoko
 * 
 */
public class XmlFactory {
	
    private static XStream serializer = null;
	
    static{
        serializer = new XStream(new DomDriver(Constants.XML_ENCODING));
	serializer.registerConverter(new MapEntryConverter());

	try {
            // Chargement des Alias, Récupération de la liste de Alias
            Map<String, String> aliasList = new HashMap<String, String>();
                    //FrameResourceLocator.getList(FrameResourceLocator.XML_ENCODING);
            Set<String> classAliasList = aliasList.keySet();
            Iterator<String> itAlias = classAliasList.iterator();
            while (itAlias.hasNext()) {
		String className = itAlias.next();
		String alias = aliasList.get(className);
		serializer.alias(alias, Class.forName(className));
            }

            // Chargement des Filename
            // Recup�ration de la liste de FileName
            Map<String, String> filenameList = new HashMap<String, String>();
                    //FrameResourceLocator.getList(FrameResourceLocator.SosSrlEntityKeyType.FILENAME);
            Set<String> classFilenameList = filenameList.keySet();
            Iterator<String> itFilename = classFilenameList.iterator();
            while (itFilename.hasNext()) {
                String className = itFilename.next();
		String filename = filenameList.get(className);
		serializer.addImplicitCollection(Class.forName(className), filename);
            }
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
    }

    public static String getXmlStream(Object entity) throws GenericException {
        try {
            String v$xmlString = "";			
            v$xmlString = serializer.toXML(entity);
            return v$xmlString;
	} catch (Exception e) {
            throw new GenericException("Erreur de cr�ation du fichier XML : " + e.getMessage(), e);
	  }
    }
}