package br.com.alura.springData.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	
	private String nome;
	private int cpf;
	private Double salario;
	private String datadecontratacao;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "funcionarios_unidades", joinColumns = {
			@JoinColumn(name = "fk_funcionario") }, 
	inverseJoinColumns = { @JoinColumn(name = "fk_unidade") })
	private List<Unidade> unidadeTrabalhos;

	
	
	public Integer getId() {
		return Id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getDatadeontratacao() {
		return datadecontratacao;
	}
	public void setDatadeontratacao(String datadeontratacao) {
		this.datadecontratacao = datadeontratacao;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public List<Unidade> getUnidadeTrabalhos() {
		return unidadeTrabalhos;
	}
	public void setUnidadeTrabalhos(List<Unidade> unidadeTrabalhos) {
		this.unidadeTrabalhos = unidadeTrabalhos;
	}
	public void setId(Integer id) {
		Id = id;
	}
	@Override
	public String toString() {
		return "Funcionario [Id=" + Id + ", nome=" + nome + ", cpf=" + cpf + ", salario=" + salario
				+ ", datadeontratacao=" + datadecontratacao + ", cargo=" + cargo + ", unidadeTrabalhos="
				+ unidadeTrabalhos + "]";
	}
	
	
	
	
	
	
	
	
	

}
