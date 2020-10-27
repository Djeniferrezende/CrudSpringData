package br.com.alura.springData.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springData.orm.Cargo;
import br.com.alura.springData.respository.CargoRepository;

@Service
public class CrudCargoService {
	
	private Boolean system = true;
	private final CargoRepository cargoRepository; 
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner sc) {
		while(system) {
			System.out.println("qual ação de cargo deseja executar");
			System.out.println("0- sair");
			System.out.println("1- funcão de cargo");
			System.out.println("2- atualizar");
			System.out.println("3- visualizar");
			System.out.println("4- deletar");
			
			int action = sc.nextInt();
			

			switch (action) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(sc);
				break;
			default:
				system = false;
				break;
			}
		}		
		
	}
	
	private void salvar(Scanner sc) {
		System.out.println("Digite um descricao");
		/*pego o valor de texto */
		String descricao = sc.next();
		/*intancio a classe*/
		Cargo cargo = new Cargo();
		/*cargo com descrissao sendo atribuida*/
		cargo.setDescricao(descricao);
		/* vou salver esse cargo com a descricao dinamica que o usuario colocou*/
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner sc) {
		System.out.println("id:");
		Integer id = sc.nextInt();
		
		System.out.println("Digite atualização");		
		String descricao = sc.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Atualizado");
		
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner sc) {
		System.out.println("id:");
		Integer id = sc.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deletado");
	}

}
