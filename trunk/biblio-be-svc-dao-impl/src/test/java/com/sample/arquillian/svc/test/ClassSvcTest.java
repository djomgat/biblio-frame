package com.sample.arquillian.svc.test;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.sample.arquillian.ClassDaoImpl;
import com.sample.arquillian.ClassSvcImpl;
import com.sample.arquillian.IClassDao;
import com.sample.arquillian.IClassSvc;
import com.sample.arquillian.IClassSvcLocal;
import com.sample.arquillian.IClassSvcRemote;
import com.sample.arquillian.IUserDao;
import com.sample.arquillian.UserDaoImpl;
import com.sample.arquillian.exceptions.BiblioDaoExceptionForTestTransact;
import com.sample.arquillian.interceptors.BiblioExceptionInterceptor;
import com.sample.arquillian.svc.test.resource.SvcTestResources;
import com.sample.biblio.constant.be.BiblioBeConstant;
import com.sample.biblio.constant.be.BiblioDaoMessageKey;
import com.sample.biblio.constant.be.BiblioSvcMessageKey;
import com.sample.biblio.entity.sample.Tabclass;
import com.sample.biblio.entity.sample.Tabuser;
import com.sample.biblio.exceptions.BiblioDaoException;
import com.sample.biblio.exceptions.BiblioSvcException;
import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.dao.generic.IFrameBaseDao;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.be.interceptor.TransactionInterceptor;
import com.sample.frame.be.svc.generic.GenericSvcImpl;
import com.sample.frame.core.entity.GenericEntity;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.exception.GenericSvcException;
import com.sample.frame.core.logging.EnumLoggingMode;
import com.sample.frame.core.logging.FrameBaseLogger;
import com.sample.frame.core.svc.generic.IFrameBaseSvc;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.frame.core.utils.FrameRessourceLocator;
import com.sample.frame.core.utils.FrameTools;

@RunWith(Arquillian.class)
public class ClassSvcTest {
	
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "testClassSvc.war")
				.addClasses(
						IFrameBaseDao.class, IFrameBaseSvc.class,FrameBaseLogger.class,EnumLoggingMode.class,
						IGenericDao.class, GenericDaoJpaImpl.class, 
						IGenericSvc.class, GenericSvcImpl.class,  
						GenericEntity.class,
						GenericDaoException.class, GenericSvcException.class, GenericException.class,
						BiblioDaoException.class, BiblioSvcException.class, BiblioBeConstant.class,
						BiblioDaoMessageKey.class, BiblioSvcMessageKey.class,
						BiblioDaoExceptionForTestTransact.class,
						BiblioExceptionInterceptor.class, TransactionInterceptor.class,
						LoggingInterceptor.class, AuthorizationInterceptor.class,
						ClassDaoImpl.class, IClassDao.class, ClassSvcImpl.class, 
						UserDaoImpl.class, IUserDao.class,
						IClassSvc.class, IClassSvcLocal.class, IClassSvcRemote.class,	
						Tabuser.class, Tabclass.class, SvcTestResources.class, FrameTools.class,
						FrameRessourceLocator.class						
						)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsResource("com/sample/arquillian/messages/daoMessage_fr_FR.properties",	"com/sample/arquillian/messages/daoMessage_fr_FR.properties")
				.addAsResource("com/sample/arquillian/messages/daoMessage.properties",	"com/sample/arquillian/messages/daoMessage.properties")
				.addAsResource("com/sample/arquillian/messages/svcMessage_fr_FR.properties",	"com/sample/arquillian/messages/svcMessage_fr_FR.properties")
				.addAsResource("com/sample/arquillian/messages/svcMessage.properties",	"com/sample/arquillian/messages/svcMessage.properties")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy our test datasource
				.addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}

	@Inject
	IClassSvcLocal component;
	
	@Inject
	IClassDao componentDao;
	
	 @Rule
	 public ExpectedException exception = ExpectedException.none();
	 
	@Before
	public void setup() throws GenericDaoException {
		String v$query = "delete from tabclass where codeClass like '%SVC%'";
		componentDao.runUpdateQuery(v$query);		
	}
	
	
	@Test
	public void testCreer() throws GenericException {
		Tabclass v$result = component.creer(getEntityTabClass("Create"));
		Assert.assertTrue("Verification Code [" + v$result.getCodeClass() + "]", v$result.getCodeClass().contains("Create"));
	}
	
	
	@Test
	public void testModifier() throws GenericException  {
		Tabclass v$result = component.creer(getEntityTabClass("Update"));
		String v$strName = "Last Name Updated";
		
		v$result.setName(v$strName);
		
		
		v$result = component.modifier(v$result);
		Assert.assertTrue("Verification Name [" + v$strName + "]", v$strName.contains(v$result.getName()));
		
	
	}

	@Test
	public void testRechercher() throws GenericException {
		Tabclass v$result = component.creer(getEntityTabClass("FindOne"));
		
		String v$strCode = v$result.getCodeClass();
		
		Tabclass v$resultFindOne = component.rechercher(v$strCode);
		
		Assert.assertTrue("Verification Code [" + v$strCode + "]", v$strCode.contains(v$resultFindOne.getCodeClass()));		
		
	}

	@Test
	public void testRechercherTout() throws GenericException {
		// création des class a selectionner
		component.creer(getEntityTabClass("FindAll1"));
		component.creer(getEntityTabClass("FindAll2"));
		component.creer(getEntityTabClass("FindAll3"));
		component.creer(getEntityTabClass("FindAll4"));
		component.creer(getEntityTabClass("FindAll5"));
		component.creer(getEntityTabClass("FindAll6"));
		
		
		
		// Recherche des class ayant un cde avec FindBC
		List<Tabclass> v$resultList = component.rechercherTout();
		
		// Verification du nombre de class trouve
		Assert.assertTrue("Vérification du nombre de Class > 6", v$resultList.size()>=6);
	}

	//@Test
	public void testRechercherParCritere() throws GenericException {
		// creation des class a selectionner
		component.creer(getEntityTabClass("FindBC1"));
		component.creer(getEntityTabClass("FindBC2"));
		component.creer(getEntityTabClass("FindBC3"));
		component.creer(getEntityTabClass("FindBC4"));
		component.creer(getEntityTabClass("FindBC5"));
		component.creer(getEntityTabClass("FindBC6"));
		
		// Définition du critere de recherche
		Tabclass v$classCriteria = new Tabclass();
		v$classCriteria.setCodeClass("FindBC");
		
		// Recherche des class ayant un cde avec FindBC
		List<Tabclass> v$resultList = component.rechercherParCritere(v$classCriteria);
		
		// Vérification du nombre de class trouvé
		Assert.assertEquals(6, v$resultList.size());	
	}
	
	@Test
	public void testCreationPourTestRollbackTransac() throws GenericException{
		Tabclass v$tabClass = getEntityTabClass("RollBackTransac");
		String v$codeClass = v$tabClass.getCodeClass();
		List<Tabuser> v$listUser = new ArrayList<Tabuser>();
		v$listUser.add(getEntityTabUser("RollBackTransac01"));
		v$listUser.add(getEntityTabUser("RollBackTransac02"));
		v$listUser.add(getEntityTabUser("RollBackTransac03"));
		v$listUser.add(getEntityTabUser("RollBackTransac04"));
		
		try {
		
			exception.expect(BiblioDaoExceptionForTestTransact.class);
			Tabclass v$tabClassResult = component.creationPourTestRollbackTransac(v$tabClass, v$listUser);
			Assert.fail("Il devrait avoir une exception avant, cette instruction de devrait pas etre exécuté");
		} catch (Exception e) {
			Assert.assertTrue("Doit Etre de type BiblioDaoExceptionForTestTransact", BiblioDaoExceptionForTestTransact.class.isInstance(e));
		}
		
		// s'assurer que la classe de code v$codeClass n'existe plus en base
		Tabclass v$tabClassResult = component.rechercher(v$codeClass);
		Assert.assertNull("Doit etre null",v$tabClassResult);
	}
	
	@Test
	public void testCreationPourTestCommitTransac() throws GenericException{
		
		Tabclass v$tabClass = getEntityTabClass("CommitTransac");
		String v$codeClass = v$tabClass.getCodeClass();
		List<Tabuser> v$listUser = new ArrayList<Tabuser>();
		v$listUser.add(getEntityTabUser("CommitTransac01"));
		v$listUser.add(getEntityTabUser("CommitTransac02"));
		v$listUser.add(getEntityTabUser("CommitTransac03"));
		v$listUser.add(getEntityTabUser("CommitTransac04"));
		
		exception.expect(BiblioDaoExceptionForTestTransact.class);
		Tabclass v$tabClassResult = component.creationPourTestCommitTransac(v$tabClass, v$listUser);
			
		// s'assurer que la classe de code v$codeClass n'existe plus en base
		Tabclass v$tabClassResult2 = component.rechercher(v$codeClass);
		Assert.assertNotNull("Doit pas etre null",v$tabClassResult2);
		
	}
	
	@Test
	public void testCreationPourTestExceptionInterceptor() throws GenericException{
		
		Tabclass v$tabClass = getEntityTabClass("ExceptionInterceptor");
		String v$codeClass = v$tabClass.getCodeClass();
		List<Tabuser> v$listUser = new ArrayList<Tabuser>();
		v$listUser.add(getEntityTabUser("ExceptionInterceptor01"));
		v$listUser.add(getEntityTabUser("ExceptionInterceptor02"));
		v$listUser.add(getEntityTabUser("ExceptionInterceptor03"));
		v$listUser.add(getEntityTabUser("ExceptionInterceptor04"));
		
		try {
		
			exception.expect(BiblioSvcException.class);
			Tabclass v$tabClassResult = component.creationPourTestExceptionInterceptor(v$tabClass, v$listUser);
			Assert.fail("Il devrait avoir une exception avant, cette instruction de devrait pas etre exécuté");
		} catch (Exception e) {
			Assert.assertEquals("Doit Etre de type BiblioDaoExceptionForTestTransact", BiblioSvcException.class, e.getClass());
		}
		
		// s'assurer que la classe de code v$codeClass n'existe plus en base
		Tabclass v$tabClassResult = component.rechercher(v$codeClass);
		Assert.assertNull("Doit etre null",v$tabClassResult);
		
	}
	
	private Tabclass getEntityTabClass(String p$distinger){
		Tabclass v$class = new Tabclass();
		v$class.setCodeClass("CSVC"+p$distinger + this.getClass().getSimpleName());
		v$class.setName("LNSVC " + p$distinger + this.getClass().getSimpleName());
		v$class.setCapacity(p$distinger.length());
		
		return v$class;
	}

	private Tabuser getEntityTabUser(String p$distinger){
		Tabuser v$user = new Tabuser();
		v$user.setCodeUser("CSVC"+p$distinger + this.getClass().getSimpleName());
		v$user.setLastName("LNSVC " + p$distinger + this.getClass().getSimpleName());
		v$user.setFirstName("FNSVC " + p$distinger + this.getClass().getSimpleName());
		v$user.setLogin("LOGSVC"+p$distinger + this.getClass().getSimpleName());
		v$user.setPassword("PWDSVC"+p$distinger + this.getClass().getSimpleName());
		v$user.setBirthDate("20100101000000");
		return v$user;
	}
}
