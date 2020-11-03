package br.com.alura.springData;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.alura.springData.service.CrudCargoService;
import br.com.alura.springData.service.CrudFuncionarioService;
import br.com.alura.springData.service.CrudUnidadeService;
import br.com.alura.springData.service.RelatorioFuncionarioDinamico;
import br.com.alura.springData.service.RelatoriosService;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private Boolean system =  true;
	
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeService unidadeService;
	private final RelatoriosService relatorios;
	private final RelatorioFuncionarioDinamico relatorioDinamico;
	

	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService,
			CrudUnidadeService unidadeService, RelatoriosService relatorios, RelatorioFuncionarioDinamico relatorioDinamico) {
		super();
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeService = unidadeService;
		this.relatorios = relatorios;
		this.relatorioDinamico = relatorioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		/*enquanto a variavel for true quero que as coisas dentro da aplicação funcione*/
		
		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorio dinamico");
			

			Integer function = sc.nextInt();

			switch (function) {
				case 1:
					cargoService.inicial(sc);
					break;
				case 2:
					funcionarioService.incial(sc);
					break;
				case 3:
					unidadeService.inicial(sc);
					break;
				case 4:
					relatorios.inicial(sc);
					break;
				case 5:
					relatorioDinamico.inicial(sc);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}