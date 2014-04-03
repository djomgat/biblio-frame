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
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sample.arquillian.IUserDao;
import com.sample.arquillian.UserDaoImpl;
import com.sample.arquillian.dao.test.resource.DaoTestResources;
import com.sample.biblio.entity.sample.Tabclass;
import com.sample.biblio.entity.sample.Tabuser;
import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.core.entity.GenericEntity;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.exception.GenericSvcException;
import com.sample.frame.core.utils.FrameTools;

@RunWith(Arquillian.class)
public class UserDaoTest {

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(UserDaoImpl.class, IUserDao.class,
						Tabuser.class, Tabclass.class, DaoTestResources.class, FrameTools.class,
						GenericDaoJpaImpl.class, 
						IGenericDao.class, GenericEntity.class,
						GenericDaoException.class, GenericSvcException.class,
						GenericException.class)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy our test datasource
				.addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}

	@Inject
	IUserDao component;
	
	
	@Test
	public void testCreate() throws GenericDaoException {
		Tabuser v$result = component.create(getEntity("Create"));
		Assert.assertTrue("Verification Code [" + v$result.getCodeUser() + "]", v$result.getCodeUser().contains("Create"));
	}

	@Test
	public void testUpdate() throws GenericDaoException {
		Tabuser v$result = component.create(getEntity("Update"));
		String v$strLastname = "Last Name Updated";
		String v$strFirstname = "First Name Updated";
		v$result.setLastName(v$strLastname);
		v$result.setFirstName(v$strFirstname);
		
		v$result = component.update(v$result);
		Assert.assertTrue("Verification LastName [" + v$strLastname + "]", v$strLastname.contains(v$result.getLastName()));
		Assert.assertTrue("Verification FirstName [" + v$strFirstname + "]", v$strFirstname.contains(v$result.getFirstName()));
	
	}

	@Test
	public void testFindOne() throws GenericDaoException {
		Tabuser v$result = component.create(getEntity("FindOne"));
		
		String v$strCode = v$result.getCodeUser();
		
		Tabuser v$resultFindOne = component.retrieve(v$strCode);
		
		Assert.assertTrue("Verification Code [" + v$strCode + "]", v$strCode.contains(v$resultFindOne.getCodeUser()));		
		
	}

	@Test
	public void testFindAll() throws GenericDaoException {
		// création des user a selectionner
		component.create(getEntity("FindAll1"));
		component.create(getEntity("FindAll2"));
		component.create(getEntity("FindAll3"));
		component.create(getEntity("FindAll4"));
		component.create(getEntity("FindAll5"));
		component.create(getEntity("FindAll6"));
		
		
		
		// Recherche des user ayant un cde avec FindBC
		List<Tabuser> v$resultList = component.findAll();
		
		// Verification du nombre de user trouve
		Assert.assertTrue("Vérification du nombre de User > 6", v$resultList.size()>=6);
	}

	//@Test
	public void testFindByCriteria() throws GenericDaoException {
		// creation des user a selectionner
		component.create(getEntity("FindBC1"));
		component.create(getEntity("FindBC2"));
		component.create(getEntity("FindBC3"));
		component.create(getEntity("FindBC4"));
		component.create(getEntity("FindBC5"));
		component.create(getEntity("FindBC6"));
		
		// Définition du critere de recherche
		Tabuser v$userCriteria = new Tabuser();
		v$userCriteria.setCodeUser("FindBC");
		
		// Recherche des user ayant un cde avec FindBC
		List<Tabuser> v$resultList = component.findByExample(v$userCriteria);
		
		// Vérification du nombre de user trouvé
		Assert.assertEquals(6, v$resultList.size());
		
		
		
	}
	
	private Tabuser getEntity(String p$distinger){
		Tabuser v$user = new Tabuser();
		v$user.setCodeUser("C"+p$distinger + this.getClass().getSimpleName());
		v$user.setLastName("LN " + p$distinger + this.getClass().getSimpleName());
		v$user.setFirstName("FN " + p$distinger + this.getClass().getSimpleName());
		v$user.setLogin("LOG"+p$distinger + this.getClass().getSimpleName());
		v$user.setPassword("PWD"+p$distinger + this.getClass().getSimpleName());
		v$user.setBirthDate("20100101000000");
		return v$user;
	}

}
