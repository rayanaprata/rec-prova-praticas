package prova;

import java.util.List;

public class Main {

	public static void imprimir(List<Funcionario> lista) {
		System.out.println("Imprimindo lista...");
		for(Funcionario funcionario : lista) {
			imprimirFuncionario(funcionario);
		}
		System.out.println("");
	}

	public static void imprimirFuncionario(Funcionario funcionario) {
		System.out.print(funcionario.getId() + " ");
		System.out.print(funcionario.getNome()+ " ");
		System.out.print(funcionario.getProfissao() + " ");
		System.out.println(funcionario.getSalario() );
	}
	

	public static void main(String[] args) {

		FuncionarioDAO banco = new FuncionarioDAOImpl(); 
			
		List<Funcionario> lista =  banco.listar();
		imprimir(lista);

		Funcionario funcionario = new Funcionario();
		funcionario.setNome("João");
		funcionario.setProfissao("Contador");
		funcionario.setSalario(2000);
		
		banco.salvar(funcionario);
		
		lista =  banco.listar();
		imprimir(lista);		

		System.out.println("Imprimindo funcionario...");
		imprimirFuncionario(banco.findByID(2));
		
	}

}