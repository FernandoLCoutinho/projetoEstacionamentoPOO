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

    public static void inserir(Carro carro) throws SQLException, Exception {
        String sql = "INSERT INTO veiculo (placa, modelo, marca, cor, porte, horaE, horaS) VALUES (?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        long millis = System.currentTimeMillis();
        try {
            con = ConnectionUtils.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, carro.getPlaca());
            preparedStatement.setString(2, carro.getModelo());
            preparedStatement.setString(3, carro.getMarca());
            preparedStatement.setString(4, carro.getCor());
            preparedStatement.setString(5, carro.getPorte());
            preparedStatement.setDate(6, new Date(millis));
            preparedStatement.setDate(7, new Date(7, 7, 7777));
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

    public static void atualizar(Carro carro, Cliente cliente) throws SQLException, Exception {
        String sql = "UPDATE Veiculo SET modelo=?, marca=?, cor=?, porte=?"
                + "WHERE (placa=?)";
        Connection con = null;
        PreparedStatement prep = null;
        try {
            con = ConnectionUtils.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, carro.getModelo());
            prep.setString(2, carro.getMarca());
            prep.setString(3, carro.getCor());
            prep.setString(4, carro.getPorte());
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
