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
    
}
