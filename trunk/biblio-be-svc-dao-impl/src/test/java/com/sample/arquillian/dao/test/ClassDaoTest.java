package com.sample.arquillian.dao.test;

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

import com.sample.arquillian.ClassDaoImpl;
import com.sample.arquillian.IClassDao;
import com.sample.arquillian.IUserDao;
import com.sample.arquillian.UserDaoImpl;
import com.sample.arquillian.dao.test.resource.DaoTestResources;
import com.sample.arquillian.exceptions.BiblioDaoExceptionForTestTransact;
import com.sample.arquillian.interceptors.BiblioExceptionInterceptor;
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
import com.sample.frame.core.entity.GenericEntity;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.exception.GenericSvcException;
import com.sample.frame.core.logging.EnumLoggingMode;
import com.sample.frame.core.logging.FrameBaseLogger;
import com.sample.frame.core.svc.generic.IFrameBaseSvc;
import com.sample.frame.core.utils.FrameTools;

@RunWith(Arquillian.class)
public class ClassDaoTest {
	
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "testClassDao.war")
				.addClasses(
						IFrameBaseDao.class, IFrameBaseSvc.class,FrameBaseLogger.class,EnumLoggingMode.class,
						IGenericDao.class, 
						GenericDaoJpaImpl.class,  GenericEntity.class,
						GenericDaoException.class, GenericSvcException.class,GenericException.class,
						BiblioDaoException.class, BiblioSvcException.class, BiblioBeConstant.class,
						BiblioDaoMessageKey.class, BiblioSvcMessageKey.class,
						BiblioDaoExceptionForTestTransact.class,
						BiblioExceptionInterceptor.class, TransactionInterceptor.class,
						LoggingInterceptor.class, AuthorizationInterceptor.class,
						ClassDaoImpl.class, IClassDao.class,
						UserDaoImpl.class, IUserDao.class,
						Tabuser.class, Tabclass.class, DaoTestResources.class, FrameTools.class						
						)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy our test datasource
				.addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}
	

	@Inject
	IClassDao component;
	
	@Before
	public void setup() throws GenericDaoException {
		String v$query = "delete from tabclass where codeClass like '%DAO%'";
		component.runUpdateQuery(v$query);		
	}
	
	
	@Test
	public void testCreate() throws GenericDaoException {
		Tabclass v$result = component.create(getEntity("Create"));
		Assert.assertTrue("Verification Code [" + v$result.getCodeClass() + "]", v$result.getCodeClass().contains("Create"));
	}
	
	
	@Test
	public void testUpdate() throws GenericDaoException  {
		Tabclass v$result = component.create(getEntity("Update"));
		String v$strName = "Last Name Updated";
		
		v$result.setName(v$strName);
		
		
		v$result = component.update(v$result);
		Assert.assertTrue("Verification Name [" + v$strName + "]", v$strName.contains(v$result.getName()));
		
	
	}

	@Test
	public void testFindOne() throws GenericDaoException {
		Tabclass v$result = component.create(getEntity("FindOne"));
		
		String v$strCode = v$result.getCodeClass();
		
		Tabclass v$resultFindOne = component.retrieve(v$strCode);
		
		Assert.assertTrue("Verification Code [" + v$strCode + "]", v$strCode.contains(v$resultFindOne.getCodeClass()));		
		
	}

	@Test
	public void testFindAll() throws GenericDaoException {
		// création des class a selectionner
		component.create(getEntity("FindAll1"));
		component.create(getEntity("FindAll2"));
		component.create(getEntity("FindAll3"));
		component.create(getEntity("FindAll4"));
		component.create(getEntity("FindAll5"));
		component.create(getEntity("FindAll6"));
		
		
		
		// Recherche des class ayant un cde avec FindBC
		List<Tabclass> v$resultList = component.findAll();
		
		// Verification du nombre de class trouve
		Assert.assertTrue("Vérification du nombre de Class > 6", v$resultList.size()>=6);
	}

	//@Test
	public void testFindByCriteria() throws GenericDaoException {
		// creation des class a selectionner
		component.create(getEntity("FindBC1"));
		component.create(getEntity("FindBC2"));
		component.create(getEntity("FindBC3"));
		component.create(getEntity("FindBC4"));
		component.create(getEntity("FindBC5"));
		component.create(getEntity("FindBC6"));
		
		// Définition du critere de recherche
		Tabclass v$classCriteria = new Tabclass();
		v$classCriteria.setCodeClass("FindBC");
		
		// Recherche des class ayant un cde avec FindBC
		List<Tabclass> v$resultList = component.findByExample(v$classCriteria);
		
		// Vérification du nombre de class trouvé
		Assert.assertEquals(6, v$resultList.size());
		
	}
	
	
	private Tabclass getEntity(String p$distinger){
		Tabclass v$class = new Tabclass();
		v$class.setCodeClass("CDAO"+p$distinger + this.getClass().getSimpleName());
		v$class.setName("LNDAO " + p$distinger + this.getClass().getSimpleName());
		v$class.setCapacity(p$distinger.length());
		
		return v$class;
	}

}
