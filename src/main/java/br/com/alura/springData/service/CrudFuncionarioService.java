package br.com.alura.springData.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.springData.orm.Cargo;
import br.com.alura.springData.orm.Funcionario;
import br.com.alura.springData.orm.Unidade;
import br.com.alura.springData.respository.CargoRepository;
import br.com.alura.springData.respository.FuncionarioRepository;
import br.com.alura.springData.respository.UnidadeRepository;

@Service
public class CrudFuncionarioService {

	private boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	private final UnidadeRepository unidadeRepository;

	

	public CrudFuncionarioService(CargoRepository cargoRepository, FuncionarioRepository funcionarioRepository,
			UnidadeRepository unidadeRepository) {
		this.cargoRepository = cargoRepository;
		this.funcionarioRepository = funcionarioRepository;
		this.unidadeRepository = unidadeRepository;
	}

	public void incial(Scanner sc) {
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
				visualizar(sc);
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
		System.out.println("Digite o nome do novo funcionario");
		String nome = sc.next();
		
		
		System.out.println("Digite o cpf do novo funcionario");
		int cpf = sc.nextInt();
		
		System.out.println("Digite o salario do novo funcionario");
		Double salario = sc.nextDouble();
		
		System.out.println("Digite a data de contratacao do funcionario");
		String datadecontratacao = sc.next();
		
	
		
		System.out.println("Digite o cargoid");
		Integer cargoId = sc.nextInt();
		
		List<Unidade> unidades = unidade(sc);
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDatadeontratacao(LocalDate.parse(datadecontratacao, formatter));
		
		Optional<Cargo>cargo = cargoRepository.findById(cargoId);
		funcionario.setCargo(cargo.get());
		funcionario.setUnidadeTrabalhos(unidades);
		
		funcionarioRepository.save(funcionario);
		System.out.println("salvo!");

	}

	private List<Unidade> unidade(Scanner sc) {
        Boolean isTrue = true;
        List<Unidade> unidades = new ArrayList<>();

        while (isTrue) {
            System.out.println("Digite o unidadeId (Para sair digite 0)");
            Integer unidadeId = sc.nextInt();

            if(unidadeId != 0) {
                Optional<Unidade> unidade = unidadeRepository.findById(unidadeId);
                unidades.add(unidade.get());
            } else {
                isTrue = false;
            }
        }

        return unidades;
    }
	

	public void atualizar(Scanner sc) {
		System.out.println("Digite o id para atualização");
		Integer id = sc.nextInt();
		
		
		System.out.println("Digite o nome");
		String nome = sc.next();
		
		System.out.println("Digite o cpf");
		int cpf = sc.nextInt();
		
		System.out.println("Digite o salario");
		Double salario = sc.nextDouble();
		
		System.out.println("Digite a data de contratação");
		String datadecontratacao = sc.next();
		
		System.out.println("digite o cargoId");
		Integer cargoId = sc.nextInt();
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDatadeontratacao(LocalDate.parse(datadecontratacao, formatter));
		Optional<Cargo>cargo = cargoRepository.findById(cargoId);
		funcionario.setCargo(cargo.get());
		
		
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo");

	}
	 
	private void visualizar(Scanner sc) {
		System.out.println("Qual pagina voce deseja visualizar?");
		Integer page =sc.nextInt();
		
		Pageable pageable = PageRequest.of(page, 5,Sort.by(Sort.Direction.ASC,"nome"));		
		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
		
		
		
		System.out.println(funcionarios);
		System.out.println("Pagina atual " + funcionarios.getNumber());
		System.out.println("Total elementos na consulta " + funcionarios.getTotalElements());
		
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}
	
	private void deletar(Scanner sc) {
		System.out.println("Digite o id para exclusao");
		Integer id = sc.nextInt();
		funcionarioRepository.deleteById(id);
		System.out.println("Deletado");
	}

}
