package prova;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	private JDBC banco;
	
	public FuncionarioDAOImpl() {
		banco = new JDBC();
	}
	
	@Override
	public void salvar(Funcionario funcionario) {
		Hibernate hibernate = new Hibernate();

		Session session = hibernate.getSessionFactory().openSession();		
		session.beginTransaction();
		
		session.save(funcionario);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Funcionario> listar() {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		String sql = "select * from funcionario;";
		
		try {
			
			Statement statement = banco.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(resultSet.getInt(1));
				funcionario.setNome(resultSet.getString(2));
				funcionario.setProfissao(resultSet.getString(3));
				funcionario.setSalario(resultSet.getInt(4));
				funcionarios.add(funcionario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return funcionarios;
	}

	@Override
	public Funcionario findByID(int id) {
		JDBC banco = new JDBC();
		Funcionario funcionario = new Funcionario();

		String sql = "select * from funcionario where id=" + id + ";";

		try {
			Statement statement = banco.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
			funcionario.setId(resultSet.getInt(1));
			funcionario.setNome(resultSet.getString(2));
			funcionario.setProfissao(resultSet.getString(3));
			funcionario.setSalario(resultSet.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionario;
	}

}
