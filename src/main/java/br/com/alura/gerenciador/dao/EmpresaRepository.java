package br.com.alura.gerenciador.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.gerenciador.modelo.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

}
