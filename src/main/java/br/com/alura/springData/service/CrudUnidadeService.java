package br.com.alura.springData.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springData.orm.Unidade;
import br.com.alura.springData.respository.UnidadeRepository;

@Service
public class CrudUnidadeService {

	private boolean system = true;
	private final UnidadeRepository unidadeRepository;

	public CrudUnidadeService(UnidadeRepository unidadeRepository) {
		super();
		this.unidadeRepository = unidadeRepository;
	}

	public void inicial(Scanner sc) {
		while (system) {
			System.out.println("Digite qual ação deseja execultar para o funcionario");
			System.out.println("1 - salvar");
			System.out.println("2 - atualizar");
			System.out.println("3 - visualizar");
			System.out.println("4 - deletar");

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
		System.out.println("Digite a descricao da filial");
		String descricao = sc.next();
		System.out.println("Digite o endereço da filial");
		String endereço = sc.next();

		Unidade unidade = new Unidade();
		unidade.setDescricao(descricao);
		unidade.setEndereco(endereço);
		unidadeRepository.save(unidade);
		System.out.println("salvo!");
	}

	private void atualizar(Scanner sc) {
		System.out.println("Digite o id que deseja atualizar");
		Integer id = sc.nextInt();
		System.out.println("Digite a descricao");
		String descricao = sc.next();

		System.out.println("Digite o endereço");
		String endereço = sc.next();

		Unidade unidade = new Unidade();
		unidade.setId(id);
		unidade.setDescricao(descricao);
		unidade.setEndereco(endereço);

		unidadeRepository.save(unidade);
		System.out.println("Atualizado");
	}

	private void visualizar() {
		Iterable<Unidade> unidades = unidadeRepository.findAll();
		unidades.forEach(unidade -> System.out.println(unidade));

	}

	private void deletar(Scanner sc) {
		System.out.println("Digite o id para deletar");
		Integer id = sc.nextInt();

		unidadeRepository.deleteById(id);
		System.out.println("deletado");
	}

}
