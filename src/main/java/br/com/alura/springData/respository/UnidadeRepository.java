package br.com.alura.springData.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springData.orm.Unidade;

@Repository
public interface UnidadeRepository extends CrudRepository<Unidade, Integer> {

}
