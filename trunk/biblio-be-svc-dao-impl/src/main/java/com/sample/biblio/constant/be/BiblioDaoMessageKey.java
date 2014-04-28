package com.sample.biblio.constant.be;

public enum BiblioDaoMessageKey {
	DAOCLASS_CRE001("DAOCLASS-CRE001", "ClassDaoImpl.create", "Erreur lors de la creation"),
	DAOCLASS_CRE002("DAOCLASS-CRE002", "ClassDaoImpl.create", "Creation non authorisée"),
	DAOCLASS_UPD001("DAOCLASS-UPD001", "ClassDaoImpl.update"),
	DAOCLASS_DEL001("DAOCLASS-DEL001", "ClassDaoImpl.delete", "Erreur lors de la suppression"),
	DAOCLASS_DEL002("DAOCLASS-DEL002", "ClassDaoImpl.delete", "Suppresion non authorisée");
	
	private final String value;
	private final String methodName;
	private final String description;


	private BiblioDaoMessageKey(String value, String methodName) {
		this.value = value;
		this.methodName = methodName;
		this.description = "";
	}
	
	private BiblioDaoMessageKey(String value, String methodName, String description) {
		this.value = value;
		this.methodName = methodName;
		this.description = description;
	}


	public String getValue() {
		return value;
	}


	public String getMethodName() {
		return methodName;
	}
	
	public static BiblioDaoMessageKey getByValue(String enumValue) {
		for (BiblioDaoMessageKey enm : BiblioDaoMessageKey.class.getEnumConstants()) {
			if (enm.getValue().equalsIgnoreCase(enumValue))
				return enm;
		}
		return null;
	}
	
	public static BiblioDaoMessageKey getByMethodName(String enumValue) {
		for (BiblioDaoMessageKey enm : BiblioDaoMessageKey.class.getEnumConstants()) {
			if (enm.getMethodName().equalsIgnoreCase(enumValue))
				return enm;
		}
		return null;
	}

	public String getDescription() {
		return description;
	}

}
