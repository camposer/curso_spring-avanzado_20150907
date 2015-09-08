package dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import config.DatabaseConfig;
import model.Persona;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@Transactional
public class PersonaDaoTest {
	@PersistenceContext
	private EntityManager em;

	@Test
	public void agregar() {
		Persona p = new Persona();
		p.setNombre("Juan");
		p.setApellido("Pérez");
		p.setFechaNacimiento(new Date());
		em.persist(p);

		// Query q = em.createNamedQuery("Persona.findAll");
		// List<Persona> personas = q.getResultList();

		Assert.assertNotNull(p.getId());
		// Assert.assertEquals(1, personas.size());

	}

}
