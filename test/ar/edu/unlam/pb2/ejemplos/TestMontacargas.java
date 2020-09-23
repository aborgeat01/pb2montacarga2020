package ar.edu.unlam.pb2.ejemplos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

class TestMontacargas {

	@Test
	void queSePuedaAgregarUnaCarga() {
		Carga nueva = new Carga(10.0);
		Montacargas nuevo = new Montacargas(1000.0);
		
		assertTrue(nuevo.cargar(nueva));
	}
	
	@Test
	void queSeCalculeElPesoActual() {
		Carga deDiez = new Carga(10.0);
		Carga deVeinte = new Carga(20.0);
		Montacargas nuevo = new Montacargas(1000.0);
		
		assertTrue(nuevo.cargar(deDiez));
		assertTrue(nuevo.cargar(deVeinte));
		
		assertEquals(30.0, nuevo.obtenerCarga(), 0.01);		
	}
	
	@Test
	void queNoSeSupereElPesoMaximo() {
		Carga deCien = new Carga(100.0);
		Carga deDocientos = new Carga(200.0);
		Carga deOchocientos = new Carga(800.0);
		Montacargas nuevo = new Montacargas(1000.0);
		
		assertTrue(nuevo.cargar(deCien));
		assertTrue(nuevo.cargar(deDocientos));
		assertFalse(nuevo.cargar(deOchocientos));
		
	}
	
	@Test
	void queSePuedaDescargar() {
		Carga deCien = new Carga(100.0);
		Carga deDocientos = new Carga(200.0);
		Carga deQuinientos = new Carga(500.0);
		Montacargas nuevo = new Montacargas(1000.0);
		
		assertTrue(nuevo.cargar(deCien));
		assertTrue(nuevo.cargar(deDocientos));
		assertTrue(nuevo.cargar(deQuinientos));
		
		assertEquals(800.0, nuevo.obtenerCarga(), 0.01);
		
		nuevo.descargar();
		
		assertEquals(0.0, nuevo.obtenerCarga(), 0.01);	
	}
	
	@Test
	void queSeCalculeBienElPromedio() {
		Carga deCien = new Carga(100.0);
		Carga deDocientos = new Carga(200.0);
		Carga deQuinientos = new Carga(500.0);
		Montacargas nuevo = new Montacargas(1000.0);
		
		assertTrue(nuevo.cargar(deCien));
		assertTrue(nuevo.cargar(deDocientos));
		assertTrue(nuevo.cargar(deQuinientos));
		
		nuevo.descargar();
		
		Carga deCuatrocientos = new Carga(400.0);
		Carga deCincuenta = new Carga(50.0);
		Carga deSeicientos = new Carga(300.0);
		
		assertTrue(nuevo.cargar(deCuatrocientos));
		assertTrue(nuevo.cargar(deCincuenta));
		assertTrue(nuevo.cargar(deSeicientos));
		
		nuevo.descargar();
		
		assertEquals(258.33, nuevo.obtenerCargaPromedio(), 0.01);
	}
	
	@Test
	void queSePuedaReemplazarUnElemento() {
		Carga deCien = new Carga(100.0);
		Carga deDocientos = new Carga(200.0);
		Carga deQuinientos = new Carga(500.0);
		Montacargas nuevo = new Montacargas(1000.0);
		
		assertTrue(nuevo.cargar(deCien));
		assertTrue(nuevo.cargar(deDocientos));
		assertTrue(nuevo.reemplazarUnElemento(0, deQuinientos));
		
		assertEquals(700.0, nuevo.obtenerCarga(), 0.01);	
	}

}
