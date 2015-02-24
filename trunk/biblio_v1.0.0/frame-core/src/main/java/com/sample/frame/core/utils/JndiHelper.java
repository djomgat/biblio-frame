package com.sample.frame.core.utils;

public class JndiHelper {
	
//	 // The app name is the application name of the deployed EJBs. This is typically the ear name
//    // without the .ear suffix. However, the application name could be overridden in the application.xml of the
//    // EJB deployment on the server.
//    // Since we haven't deployed the application as a .ear, the app name for us will be an empty string
//    final String appName = "";
//    // This is the module name of the deployed EJBs on the server. This is typically the jar name of the
//    // EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
//    // In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
//    // jboss-as-ejb-remote-app
//    final String moduleName = "jboss-as-ejb-remote-app";
//    // AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
//    // our EJB deployment, so this is an empty string
//    final String distinctName = "";
//    // The EJB name which by default is the simple class name of the bean implementation class
//    final String beanName = CounterBean.class.getSimpleName();
//    // the remote view fully qualified class name
//    final String viewClassName = RemoteCounter.class.getName();

	/**
	 * 
	 * @param appName The app name is the application name of the deployed EJBs. 
	 * This is typically the ear name without the .ear suffix.
	 * However, the application name could be overridden in the application.xml of the EJB deployment on the server
	 * If you haven't deployed the application as a .ear, the app name will be an empty string
	 * @param moduleName This is the module name of the deployed EJBs on the server. 
	 * This is typically the jar name of the EJB deployment, without the .jar suffix, 
	 * but can be overridden via the ejb-jar.xml
	 * @param distinctName  JBOSS 7 allows each deployment to have an (optional) distinct name. 
	 * It can be empty
	 * @param beanName The EJB name which by default is the simple class name of the bean implementation class
	 * @param viewClass the remote view class 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String lookupRemoteStatelessName(String appName,
			String moduleName, String distinctName, String beanName,
			Class viewClass) {

		// ejb:<app-name>/<module-name>/<distinct-name>/<bean-name>!<fully-qualified-classname-of-the-remote-interface>
		
		return "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClass.getName();

	}
	
	/**
	 * 
	 * @param appName The app name is the application name of the deployed EJBs. 
	 * This is typically the ear name without the .ear suffix.
	 * However, the application name could be overridden in the application.xml of the EJB deployment on the server
	 * If you haven't deployed the application as a .ear, the app name will be an empty string
	 * @param moduleName This is the module name of the deployed EJBs on the server. 
	 * This is typically the jar name of the EJB deployment, without the .jar suffix, 
	 * but can be overridden via the ejb-jar.xml
	 * @param distinctName  JBOSS 7 allows each deployment to have an (optional) distinct name. 
	 * It can be empty
	 * @param beanName The EJB name which by default is the simple class name of the bean implementation class
	 * @param viewClass the remote view class
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String lookupRemoteStatelfullName(String appName,
			String moduleName, String distinctName, String beanName,
			Class viewClass) {

		//ejb:<app-name>/<module-name>/<distinct-name>/<bean-name>!<fully-qualified-classname-of-the-remote-interface>?stateful
		
		return "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClass.getName() +"?stateful";

	}
	

}
