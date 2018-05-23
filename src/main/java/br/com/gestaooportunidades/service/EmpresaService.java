package br.com.gestaooportunidades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gestaooportunidades.model.Empresa;
import br.com.gestaooportunidades.repository.EmpresaRepository;
 
@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public void save (Empresa empresa) {
		empresaRepository.save(empresa);
	}

	public Iterable<Empresa> findAll() {
		return empresaRepository.findAll();
	}
}
