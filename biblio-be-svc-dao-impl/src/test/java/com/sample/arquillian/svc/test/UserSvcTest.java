package com.sample.arquillian.svc.test;

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
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sample.biblio.dao.contract.IUserDao;
import com.sample.biblio.svc.contract.IUserSvc;
import com.sample.biblio.svc.contract.IUserSvcLocal;
import com.sample.biblio.svc.contract.IUserSvcRemote;
import com.sample.biblio.dao.impl.UserDaoImpl;
import com.sample.biblio.svc.impl.UserSvcImpl;
import com.sample.biblio.exceptions.BiblioDaoExceptionForTestTransact;
import com.sample.biblio.interceptors.BiblioExceptionInterceptor;
import com.sample.arquillian.svc.test.resource.SvcTestResources;
import com.sample.biblio.constant.be.BiblioBeConstant;
import com.sample.biblio.constant.be.BiblioDaoMessageKey;
import com.sample.biblio.constant.be.BiblioSvcMessageKey;
import com.sample.biblio.entity.Tabclass;
import com.sample.biblio.entity.Tabuser;
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
import com.sample.frame.core.utils.FrameTools;

@RunWith(Arquillian.class)
public class UserSvcTest {

	@Deployment
	public static Archive<?> creerTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "testUserSvc.war")
				.addClasses(
						IFrameBaseDao.class, IFrameBaseSvc.class, FrameBaseLogger.class,EnumLoggingMode.class,
						IGenericDao.class, GenericDaoJpaImpl.class, 
						IGenericSvc.class, GenericSvcImpl.class,  
						GenericEntity.class,
						GenericDaoException.class, GenericSvcException.class,GenericException.class,
						BiblioDaoException.class, BiblioSvcException.class, BiblioBeConstant.class,
						BiblioDaoMessageKey.class, BiblioSvcMessageKey.class,
						BiblioDaoExceptionForTestTransact.class,
						BiblioExceptionInterceptor.class, TransactionInterceptor.class,
						LoggingInterceptor.class, AuthorizationInterceptor.class,
						UserDaoImpl.class, IUserDao.class, UserSvcImpl.class,
						IUserSvc.class, IUserSvcLocal.class, IUserSvcRemote.class,						
						Tabuser.class, Tabclass.class, SvcTestResources.class,
						FrameTools.class	, TestClassConstants.class)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy our test datasource
				.addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}

	@Inject
	IUserSvcLocal component;
	
	@Inject
	IUserDao componentDao;
	
	@Before
	public void setup() throws GenericDaoException {
		if(TestClassConstants.runSetup){
		String v$query = "delete from tabuser where codeUser like '%SVC%'";
		componentDao.runUpdateQuery(v$query);		
		}
	}
	
	@Test
	public void testcreer() throws GenericException {
		Tabuser v$result = component.creer(getEntity("creer"));
		Assert.assertTrue("Verification Code [" + v$result.getCodeUser() + "]", v$result.getCodeUser().contains("creer"));
	}

	@Test
	public void testModifier() throws GenericException {
		Tabuser v$result = component.creer(getEntity("Update"));
		String v$strLastname = "Last Name Updated";
		String v$strFirstname = "First Name Updated";
		v$result.setLastName(v$strLastname);
		v$result.setFirstName(v$strFirstname);
		
		v$result = component.modifier(v$result);
		Assert.assertTrue("Verification LastName [" + v$strLastname + "]", v$strLastname.contains(v$result.getLastName()));
		Assert.assertTrue("Verification FirstName [" + v$strFirstname + "]", v$strFirstname.contains(v$result.getFirstName()));
	
	}

	@Test
	public void testRechercher() throws GenericException {
		Tabuser v$result = component.creer(getEntity("FindOne"));
		
		String v$strCode = v$result.getCodeUser();
		
		Tabuser v$resultFindOne = component.rechercher(v$strCode);
		
		Assert.assertTrue("Verification Code [" + v$strCode + "]", v$strCode.contains(v$resultFindOne.getCodeUser()));		
		
	}

	@Test
	public void testRechercherTout() throws GenericException {
		// création des user a selectionner
		component.creer(getEntity("FindAll1"));
		component.creer(getEntity("FindAll2"));
		component.creer(getEntity("FindAll3"));
		component.creer(getEntity("FindAll4"));
		component.creer(getEntity("FindAll5"));
		component.creer(getEntity("FindAll6"));
		
		
		
		// Recherche des user ayant un cde avec FindBC
		List<Tabuser> v$resultList = component.rechercherTout();
		
		// Verification du nombre de user trouve
		Assert.assertTrue("Vérification du nombre de User > 6", v$resultList.size()>=6);
	}

	//@Test
	public void testRechercherParCritere() throws GenericException {
		// creation des user a selectionner
		component.creer(getEntity("FindBC1"));
		component.creer(getEntity("FindBC2"));
		component.creer(getEntity("FindBC3"));
		component.creer(getEntity("FindBC4"));
		component.creer(getEntity("FindBC5"));
		component.creer(getEntity("FindBC6"));
		
		// Définition du critere de recherche
		Tabuser v$userCriteria = new Tabuser();
		v$userCriteria.setCodeUser("FindBC");
		
		// Recherche des user ayant un cde avec FindBC
		List<Tabuser> v$resultList = component.rechercherParCritere(v$userCriteria);
		
		// Vérification du nombre de user trouvé
		Assert.assertEquals(6, v$resultList.size());
		
		
		
	}
	
	private Tabuser getEntity(String p$distinger){
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
