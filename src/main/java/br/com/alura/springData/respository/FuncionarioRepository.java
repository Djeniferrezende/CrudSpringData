package br.com.alura.springData.respository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springData.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>{

	List<Funcionario> findByNome(String nome);
	

	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario AND f.datadecontratacao = :datadeContratacao")
	List<Funcionario> findByNomeSalarioDataContratacao(String nome, Double salario, LocalDate datadeContratacao);
	
	
	@Query(value = "SELECT * FROM funcionarios f WHERE f.datadecontratacao >= :datadecontratacao ", nativeQuery= true)
	List<Funcionario> findByDatadeContratacaoMaior(LocalDate datadecontratacao);
}
