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

import com.sample.arquillian.dao.test.resource.DaoTestResources;
import com.sample.biblio.svc.impl.exception.BiblioSvcExceptionForTestTransact;
import com.sample.biblio.svc.impl.interceptor.BiblioExceptionInterceptor;
import com.sample.arquillian.svc.test.TestClassConstants;
import com.sample.biblio.svc.impl.constant.be.BiblioBeConstant;
import com.sample.biblio.svc.impl.constant.be.BiblioSvcMessageKey;

import com.sample.biblio.svc.api.exception.BiblioSvcException;
import com.sample.frame.be.dao.generic.IFrameBaseDao;
import com.sample.frame.be.dao.generic.IGenericDao;
import com.sample.frame.be.dao.generic.GenericDaoJpaImpl;
import com.sample.frame.be.interceptor.AuthorizationInterceptor;
import com.sample.frame.be.interceptor.LoggingInterceptor;
import com.sample.frame.be.interceptor.TransactionInterceptor;
import com.sample.frame.core.entity.GenericEntity;
import com.sample.frame.core.exception.GenericDaoException;
import com.sample.frame.core.exception.GenericException;
import com.sample.frame.core.exception.GenericSvcException;
import com.sample.frame.core.logging.EnumLoggingMode;
import com.sample.frame.core.logging.BaseLogger;
import com.sample.frame.core.svc.generic.IFrameBaseSvc;
import com.sample.frame.core.utils.FrameTools;

import com.sample.biblio.model.courrier.TabCourrier;
import com.sample.biblio.model.courrier.TabPersonne;

import com.sample.biblio.dao.api.courrier.ICourrierDao;
import com.sample.biblio.dao.api.courrier.IPersonneDao;


@RunWith(Arquillian.class)
public class CourrierDaoTest {
	
    @Deployment
    public static Archive<?> createTestArchive() {
	return ShrinkWrap
            .create(WebArchive.class, "testCourrierDao.war")
            .addClasses(IFrameBaseDao.class, IFrameBaseSvc.class,BaseLogger.class,EnumLoggingMode.class,
                IGenericDao.class, GenericDaoJpaImpl.class, GenericEntity.class,
                GenericDaoException.class, GenericSvcException.class, GenericException.class,
                BiblioSvcException.class, BiblioSvcException.class, BiblioBeConstant.class,
                BiblioSvcMessageKey.class, BiblioSvcExceptionForTestTransact.class,
                BiblioExceptionInterceptor.class, TransactionInterceptor.class,
                LoggingInterceptor.class, AuthorizationInterceptor.class,
                ICourrierDao.class,IPersonneDao.class, TabCourrier.class, TabPersonne.class, 
                DaoTestResources.class, FrameTools.class,	
                TestClassConstants.class
            )
		.addAsResource("META-INF/persistence.xml","META-INF/persistence.xml")
		.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
		// Deploy our test datasource
		.addAsWebInfResource("test-ds.xml", "test-ds.xml");
	}
	

	@Inject
	ICourrierDao component;
	
	@Before
	public void setup() throws GenericDaoException {
            if(TestClassConstants.runSetup){
                String v$query = "delete from tab_courrier where codeClass like '%DAO%'";
		component.runUpdateQuery(v$query);	
            }
	}
		
	@Test
	public void testCreate() throws GenericDaoException {
            TabCourrier v$result = component.create(getEntity("Create"));
            Assert.assertTrue("Verification Code [" + v$result.getNumeroCourrier()+ "]", v$result.getNumeroCourrier().contains("Create"));
	}
	
	@Test
	public void testUpdate() throws GenericDaoException  {
            TabCourrier v$result = component.create(getEntity("Update"));
            String v$strName = "Last Name Updated";
		
            v$result.setMotsCles(v$strName);
	
            v$result = component.update(v$result);
            Assert.assertTrue("Verification Name [" + v$strName + "]", v$strName.contains(v$result.getNumeroCourrier()));
		
	}

	@Test
	public void testFindOne() throws GenericDaoException {
		TabCourrier v$result = component.create(getEntity("FindOne"));		
		String v$strCode = v$result.getNumeroCourrier();		
		TabCourrier v$resultFindOne = component.retrieve(v$strCode);		
		Assert.assertTrue("Verification Code [" + v$strCode + "]", v$strCode.contains(v$resultFindOne.getNumeroCourrier()));			
	}

	@Test
	public void testFindAll() throws GenericDaoException {
            // création des class à selectionner
            component.create(getEntity("FindAll1"));
            component.create(getEntity("FindAll2"));
            component.create(getEntity("FindAll3"));
            component.create(getEntity("FindAll4"));
            component.create(getEntity("FindAll5"));
            component.create(getEntity("FindAll6"));	
		
            // Recherche des class ayant un cde avec FindBC
            List<TabCourrier> v$resultList = component.findAll();
		
            // Verification du nombre de class trouve
            Assert.assertTrue("Vérification du nombre de Courrier > 6", v$resultList.size()>=6);
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
            TabCourrier v$courrierCriteria = new TabCourrier();
            v$courrierCriteria.setNumeroCourrier("FindBC");
		
            // Recherche des class ayant un cde avec FindBC
            List<TabCourrier> v$resultList = component.findByExample(v$courrierCriteria);
		
            // Vérification du nombre de class trouvé
            Assert.assertEquals(6, v$resultList.size());
		
	}	
	
	private TabCourrier getEntity(String p$distinger){
            TabCourrier v$courrier = new TabCourrier();
            v$courrier.setNumeroCourrier("CDAO"+p$distinger + this.getClass().getSimpleName());
            v$courrier.setObjetCourrier("LNDAO " + p$distinger + this.getClass().getSimpleName());
            v$courrier.setDescCourrier(p$distinger);
            return v$courrier;
	}

}