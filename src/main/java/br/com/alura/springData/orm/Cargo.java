package br.com.alura.springData.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "cargos")
public class Cargo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String descricao;
	
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario>funcionario;


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<Funcionario> getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}


	@Override
	public String toString() {
		return "Cargo [Id=" + Id + ", descricao=" + descricao + "]";
	}


	


	
	
	
	
	
	
	

}
