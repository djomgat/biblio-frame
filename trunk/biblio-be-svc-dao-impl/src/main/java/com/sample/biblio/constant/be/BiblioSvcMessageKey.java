package com.sample.biblio.constant.be;

public enum BiblioSvcMessageKey {
	
	SVCCLASS_CRE001("SVCCLASS-CRE001", "ClassSvcImpl.creer"),
	SVCCLASS_MOD001("SVCCLASS-CRE001", "ClassSvcImpl.modifier"),
	SVCCLASS_SUP001("SVCCLASS-CRE001", "ClassSvcImpl.supprimer");
	
	private final String value;
	private final String methodName;


	private BiblioSvcMessageKey(String value, String methodName) {
		this.value = value;
		this.methodName = methodName;

	}


	public String getValue() {
		return value;
	}


	public String getMethodName() {
		return methodName;
	}
	
	public static BiblioSvcMessageKey getByValue(String enumValue) {
		for (BiblioSvcMessageKey enm : BiblioSvcMessageKey.class.getEnumConstants()) {
			if (enm.getValue().equalsIgnoreCase(enumValue))
				return enm;
		}
		return null;
	}
	
	public static BiblioSvcMessageKey getByMethodName(String enumValue) {
		for (BiblioSvcMessageKey enm : BiblioSvcMessageKey.class.getEnumConstants()) {
			if (enm.getMethodName().equalsIgnoreCase(enumValue))
				return enm;
		}
		return null;
	}

}
