package ar.edu.unlam.pb2.ejemplos;

import java.util.ArrayList;

public class Montacargas {
	
	private Double PESO_MAXIMO;
	private ArrayList<Carga> cargas;
	private ArrayList<Carga> historicas;
	
	
	
	public Montacargas(Double pesoMaximo) {
		PESO_MAXIMO = pesoMaximo;
		cargas = new ArrayList<Carga>();
		historicas = new ArrayList<Carga>();
	}
	
	public Double obtenerCarga() {
		Double pesoActual = 0.0;
		
		for(Carga actual: cargas) {
			pesoActual += actual.getPeso();
		}
		
		return pesoActual;		
	}
	
	public Boolean cargar(Carga nueva) {
		Boolean resultado = false;
		if(this.obtenerCarga()+nueva.getPeso()<PESO_MAXIMO) {
			cargas.add(nueva);
			resultado = true;
		}

		return resultado;
	}
	
	public void descargar() {
		historicas.addAll(cargas);    
		
		cargas.clear();         
		
		
	}
	

	
	public Double obtenerCargaPromedio() {
		Double sumatoria = 0.0, promedio = 0.0;
		for(Carga actual: historicas) {
			sumatoria+=actual.getPeso();
		}
		promedio = sumatoria/historicas.size();
		return promedio;
	}
	
	public Boolean reemplazarUnElemento(int posicionAReemplazar, Carga nuevoElemento) {
		cargas.set(posicionAReemplazar, nuevoElemento);
		return true;
	}

}
