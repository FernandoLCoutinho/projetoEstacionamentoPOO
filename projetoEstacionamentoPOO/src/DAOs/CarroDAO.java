package DAOs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Cliente.Cliente;
import Util.ConnectionUtils;
import Veiculos.Carro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author murilo.aaraujo
 */
public class CarroDAO {

    public void inserir(Carro carro) throws SQLException, Exception {
        String sql = "INSERT INTO carro(placa, modelo, chassi, marca, cor,dataentrada,datasaida) VALUES (?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        long millis = System.currentTimeMillis();
        try {
            con = ConnectionUtils.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, carro.getPlaca());
            preparedStatement.setString(2, carro.getModelo());
            preparedStatement.setString(3, carro.getChassi());
            preparedStatement.setString(4, carro.getMarca());
            preparedStatement.setString(6, carro.getCor());
            preparedStatement.setDate(7, new Date(millis));
            preparedStatement.setDate(8, new Date(0, 0, 0000));
            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public void atualizar(Carro carro, Cliente cliente) throws SQLException, Exception {
        String sql = "UPDATE Veiculo SET modelo=?, chassi=?, cor=?,marca=?,dataentrada=?,datasaida=?,dono=?"
                + "WHERE (placa=?)";
        Connection con = null;
        PreparedStatement prep = null;
        try {
            con = ConnectionUtils.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, carro.getModelo());
            prep.setString(2, carro.getChassi());
            prep.setString(3, carro.getMarca());
            prep.setString(4, carro.getCor());
            prep.setString(5, cliente.getNome());
        } finally {
            if (prep != null && !prep.isClosed()) {
                prep.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    } 
}
