package br.com.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> EMPRESAS = new ArrayList<>();

	public void adicionar(Empresa empresa) {
		EMPRESAS.add(empresa);
	}
	
    public List<Empresa> getEmpresas(){ 
        return Banco.EMPRESAS;
    }
	
}