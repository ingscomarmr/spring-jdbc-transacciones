package test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:datasource-test.xml" })
public class TestJDBC{
	private static Log logger = LogFactory.getLog("TestJdbc");
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	@Ignore
	public void testJdbc() {
		
		logger.info("Inicio del test Jdbc");
		int noPersonas = jdbcTemplate.queryForObject("select count(*) from persona", Integer.class);
		logger.info("Numero de personas:" + noPersonas);
		assertEquals(3, noPersonas);
		logger.info("Fin del test Jdbc");
	}
	
	@Test	
	public void testJdbcOracle() {
		
		logger.info("Inicio testJdbcOracle");
		int noPersonas = jdbcTemplate.queryForObject("SELECT PERSONASEQUENCE.nextval FROM DUAL", Integer.class);
		logger.info("Numero de clientes:" + noPersonas);
		assertTrue(noPersonas > 0);
		logger.info("Fin testJdbcOracle");
	}
}