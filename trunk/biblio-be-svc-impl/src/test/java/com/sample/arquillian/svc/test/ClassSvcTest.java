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
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sample.arquillian.ClassDaoImpl;
import com.sample.arquillian.ClassSvcImpl;
import com.sample.arquillian.IClassDao;
import com.sample.arquillian.IClassSvc;
import com.sample.arquillian.IClassSvcLocal;
import com.sample.arquillian.IClassSvcRemote;
import com.sample.arquillian.svc.test.resource.SvcTestResources;
import com.sample.biblio.entity.sample.Tabclass;
import com.sample.biblio.entity.sample.Tabuser;
import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.svc.generic.GenericSvcImpl;
import com.sample.frame.core.entity.GenericEntity;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.exception.GenericSvcException;
import com.sample.frame.core.svc.generic.IGenericSvc;
import com.sample.frame.core.utils.FrameTools;

@RunWith(Arquillian.class)
public class ClassSvcTest {
	
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "testClassSvc.war")
				.addClasses(
						IGenericDao.class, GenericDaoJpaImpl.class, 
						IGenericSvc.class, GenericSvcImpl.class,  
						GenericEntity.class,
						GenericDaoException.class, GenericSvcException.class, GenericException.class,
						ClassDaoImpl.class, IClassDao.class, ClassSvcImpl.class, 
						IClassSvc.class, IClassSvcLocal.class, IClassSvcRemote.class,	
						Tabuser.class, Tabclass.class, SvcTestResources.class, FrameTools.class						
						)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy our test datasource
				.addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}

	@Inject
	IClassSvcLocal component;
	
	
	@Test
	public void testCreer() throws GenericException {
		Tabclass v$result = component.creer(getEntity("Create"));
		Assert.assertTrue("Verification Code [" + v$result.getCodeClass() + "]", v$result.getCodeClass().contains("Create"));
	}
	
	
	@Test
	public void testModifier() throws GenericException  {
		Tabclass v$result = component.creer(getEntity("Update"));
		String v$strName = "Last Name Updated";
		
		v$result.setName(v$strName);
		
		
		v$result = component.modifier(v$result);
		Assert.assertTrue("Verification Name [" + v$strName + "]", v$strName.contains(v$result.getName()));
		
	
	}

	@Test
	public void testRechercher() throws GenericException {
		Tabclass v$result = component.creer(getEntity("FindOne"));
		
		String v$strCode = v$result.getCodeClass();
		
		Tabclass v$resultFindOne = component.rechercher(v$strCode);
		
		Assert.assertTrue("Verification Code [" + v$strCode + "]", v$strCode.contains(v$resultFindOne.getCodeClass()));		
		
	}

	@Test
	public void testRechercherTout() throws GenericException {
		// création des class a selectionner
		component.creer(getEntity("FindAll1"));
		component.creer(getEntity("FindAll2"));
		component.creer(getEntity("FindAll3"));
		component.creer(getEntity("FindAll4"));
		component.creer(getEntity("FindAll5"));
		component.creer(getEntity("FindAll6"));
		
		
		
		// Recherche des class ayant un cde avec FindBC
		List<Tabclass> v$resultList = component.rechercherTout();
		
		// Verification du nombre de class trouve
		Assert.assertTrue("Vérification du nombre de Class > 6", v$resultList.size()>=6);
	}

	//@Test
	public void testRechercherParCritere() throws GenericException {
		// creation des class a selectionner
		component.creer(getEntity("FindBC1"));
		component.creer(getEntity("FindBC2"));
		component.creer(getEntity("FindBC3"));
		component.creer(getEntity("FindBC4"));
		component.creer(getEntity("FindBC5"));
		component.creer(getEntity("FindBC6"));
		
		// Définition du critere de recherche
		Tabclass v$classCriteria = new Tabclass();
		v$classCriteria.setCodeClass("FindBC");
		
		// Recherche des class ayant un cde avec FindBC
		List<Tabclass> v$resultList = component.rechercherParCritere(v$classCriteria);
		
		// Vérification du nombre de class trouvé
		Assert.assertEquals(6, v$resultList.size());
		
		
		
	}
	
	private Tabclass getEntity(String p$distinger){
		Tabclass v$class = new Tabclass();
		v$class.setCodeClass("CSVC"+p$distinger + this.getClass().getSimpleName());
		v$class.setName("LNSVC " + p$distinger + this.getClass().getSimpleName());
		v$class.setCapacity(p$distinger.length());
		
		return v$class;
	}

}
