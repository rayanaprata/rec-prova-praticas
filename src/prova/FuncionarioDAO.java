package prova;

import java.util.List;

public interface FuncionarioDAO {
	public void salvar (Funcionario funcionario);//Hibernate
	public List<Funcionario> listar(); //JDBC Statement
	public Funcionario findByID(int id);//JDBC PreparedStatement
}
