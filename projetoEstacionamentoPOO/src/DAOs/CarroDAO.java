package DAOs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Util.ConnectionUtils;
import Veiculos.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author murilo.aaraujo
 */
public class CarroDAO {

    public void inserir(Carro carro) throws SQLException, Exception {
        String sql = "INSERT INTO carro(placa, modelo, chassi, marca, cor) VALUES (?,?,?,?,?)";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = ConnectionUtils.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, carro.getPlaca());
            preparedStatement.setString(2, carro.getModelo());
            preparedStatement.setString(3, carro.getChassi());
            preparedStatement.setString(4, carro.getMarca());
            preparedStatement.setString(6, carro.getCor());
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
}
