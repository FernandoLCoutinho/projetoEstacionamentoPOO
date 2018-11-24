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
import java.sql.Date;

/**
 *
 * @author fernando.lcoutinho
 */
public class ClienteDAO {
    
    public void inserir(Cliente c) throws SQLException, Exception{
        String sql = "INSERT INTO `cliente`(`cpf`,`endereco`,`nome`,`email`,`telefone`,`id`,`datanascimento`,`celular`,`cep`) VALUES (?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement prep = null;
                         
                
        con = ConnectionUtils.getConnection();
        prep = con.prepareStatement(sql);
        prep.setString(1, c.getCpf());
        prep.setString(2, c.getEndereco());
        prep.setString(3, c.getNome());
        prep.setString(4, c.getEmail());
        prep.setString(5, c.getTelefone());
        prep.setInt(6, c.getId());
        prep.setDate(7,c.getDataNascimento());
        prep.setString(8, c.getCelular());
        prep.setString(9, c.getCep());
        System.out.println(prep);
    }
    public void atualizar(Carro carro, Cliente cliente) throws SQLException, Exception {
        String sql = "UPDATE Cliente SET endereco=?, nome=?, email=?,telefone=?,datanascimento=?,celular=?,cep=?,carro=?"
                + "WHERE (cpf=?)";
        Connection con = null;
        PreparedStatement prep = null;
        try {
            con = ConnectionUtils.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, cliente.getNome());
            prep.setString(2, cliente.getEmail());
            prep.setString(3, cliente.getTelefone());
            prep.setDate(4, cliente.getDataNascimento());
            prep.setString(5, cliente.getCelular());
            prep.setString(6, cliente.getCep());
            prep.setString(7, carro.getPlaca());
        } finally {
            if (prep != null && !prep.isClosed()) {
                prep.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }
    
    public void excluir(Cliente cliente) throws SQLException,Exception{
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
