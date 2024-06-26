/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pc
 */
public class conexao {
    
    public static Statement statement = null;
    
    // XAMPP 
    String URL = "jdbc:mysql://localhost:3306/tb_senha";
    String usuario = "root";
    String senha = "";

    private Statement stm = null;
    // Variavel para a conexão
    private Connection conexao = null;
    
 
    // Métodos Conectar e Desconectar Banco de Dados 
    // =============================================

    public void conectar() throws ClassNotFoundException, SQLException {
       
        // Carga do driver de conexão
        Class.forName("com.mysql.jdbc.Driver");

        conexao = DriverManager.getConnection(URL, usuario, senha);
        Connection conn = null;
        System.out.println("Conectou");
        statement = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    public void desconectar() throws SQLException{
           
        // Fechando a conexão
        conexao.close();
    }
public static int runSQL(String sql) 
    {
        int qtdreg = 0;
     
      try
      {        
         qtdreg = statement.executeUpdate(sql);
      }
      catch(SQLException sqlex)
      {
         System.out.println("Erro acesso ao BD"+ sqlex);
      }
      
      return qtdreg;
    }
    
}
