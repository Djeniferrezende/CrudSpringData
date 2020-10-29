package br.com.alura.springData.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springData.orm.Funcionario;
import br.com.alura.springData.respository.FuncionarioRepository;

@Service
public class RelatoriosService {
	
	private Boolean system = true;
	
	private final FuncionarioRepository funcionarioRepository;	
	
	
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner sc) {
		while(system) {
			System.out.println("qual ação de cargo deseja executar");
			System.out.println("0- sair");
			System.out.println("1- Busca funcionario nome");
			System.out.println("2- Busca funcionario nome salario e data de contratacao");
			
			
			int action = sc.nextInt();
			

			switch (action) {
			case 1:
				buscaFuncionarioNome(sc);
				break;
			case 2:
				 buscaFuncionarioNomeSalarioDataContratacao(sc);
				break;
			
			default:
				system = false;
				break;
			}
		}		
		
	}
	
	private void buscaFuncionarioNome(Scanner sc) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = sc.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
	
	private void buscaFuncionarioNomeSalarioDataContratacao(Scanner sc) {
		System.out.println("Digite o nome do funcionario");
		String nome = sc.next();
		
		System.out.println("Digite o salario");
		Double salario = sc.nextDouble();
		
		System.out.println("Digite data de contratacao");
		String datadeContratacao = sc.next();
		
		
		List<Funcionario> list = funcionarioRepository.findByNomeSalarioDataContratacao(nome, salario, datadeContratacao);
		list.forEach(System.out::println);
	}

}
