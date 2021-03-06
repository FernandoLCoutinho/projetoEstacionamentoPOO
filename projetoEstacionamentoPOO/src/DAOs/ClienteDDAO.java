/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Cliente.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Util.ConnectionUtils;
import Veiculos.Carro;

/**
 *
 * @author fernando.lcoutinho
 */
public class ClienteDDAO {

    public static void inserir(Cliente c) throws SQLException, Exception {
        String sql = "INSERT INTO cliente(cpf, telefone) VALUES (?,?)";
        Connection con = null;
        PreparedStatement prep = null;
        
        try {
        con = ConnectionUtils.getConnection();
        prep = con.prepareStatement(sql);
        prep.setString(1, c.getCpf());
        prep.setString(2, c.getTelefone());
        prep.execute();
        } finally {
            if (prep != null && !prep.isClosed()) {
                prep.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public static void atualizar(Carro carro, Cliente cliente) throws SQLException, Exception {
        String sql = "UPDATE Cliente SET  telefone=?"
                + "WHERE (cpf=?)";
        Connection con = null;
        PreparedStatement prep = null;
        try {
            con = ConnectionUtils.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, cliente.getTelefone());
            prep.setString(2, cliente.getCpf());
            prep.executeUpdate();
        } finally {
            if (prep != null && !prep.isClosed()) {
                prep.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public static void excluir(Cliente cliente) throws SQLException, Exception {
        //Monta a string de atualização do cliente no BD, utilizando
        //prepared statement
        String sql = "DELETE FROM Cliente  WHERE cpf=?";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, cliente.getCpf());

            //Executa o comando no banco de dados
            preparedStatement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
