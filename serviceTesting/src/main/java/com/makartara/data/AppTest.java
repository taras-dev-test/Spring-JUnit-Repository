package com.makartara.data;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * Hello world!
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class AppTest 
{
	private static final Logger LOG=LoggerFactory.getLogger(AppTest.class);
	@Autowired
	private MMAService rep;
	@Before
	@Rollback(false)
	public void initDB(){
		rep.createFighter("Jon Jones", 23, "MMA");
		rep.createFighter("Conor McGregor", 21, "Boxing");
		rep.createFighter("Demetrious Johnson", 26, "MMA");
		rep.createFighter("Khabib Nurmagomedov",23,"Combat Sambo");
		rep.createFighter("Demian Maia", 25, "BJJ");
		rep.createFighter("Taras", 0, "Non-proffesional moves");
	}
	@Test
	public void clearingFighterByExistingName(){
		rep.killFighterByName("Khabib Nurmagomedov");
		assertFalse("Fighter exists", rep.isThereName("Khabib Nurmagomedov"));
	}
	@Test
	public void IsFighterExistByExistingName(){
		assertTrue("Fighter doesn't exist", rep.isThereName("Jon Jones"));
	}
	@Test
	public void getFightersByExistingStyle(){
		List<MMAFighter> l=rep.findByStyle("MMA");
		assertNotNull("There is no fighters with such style",l);
	}
	@Test
	public void getFightersByNonExistingStyle(){
		List<MMAFighter> l=rep.findByStyle("Kickboxing");
		assertNull("Such style exists",l);
	}
	@After
	public void clearDB(){
		rep.killAll();
		rep.clearStyles();
	}
}
