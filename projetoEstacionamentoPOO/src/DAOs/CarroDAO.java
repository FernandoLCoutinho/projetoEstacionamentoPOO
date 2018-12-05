package DAOs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Interfaces.Alteravel;
import Interfaces.Inserivel;
import Util.ConnectionUtils;
import Veiculos.Carro;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author murilo.aaraujo
 */
public abstract class CarroDAO implements Inserivel, Alteravel {

    public static void inserir(Carro carro) throws SQLException, Exception {
        String sql = "INSERT INTO veiculo (placa, modelo, marca, cor, porte, horaE, horaS) VALUES (?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement prep = null;
        long millis = System.currentTimeMillis();
        long decoy = 0;
        try {
            con = ConnectionUtils.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, carro.getPlaca());
            prep.setString(2, carro.getModelo());
            prep.setString(3, carro.getMarca());
            prep.setString(4, carro.getCor());
            prep.setString(5, carro.getPorte());
            prep.setTimestamp(6, new Timestamp(millis));
            prep.setTimestamp(7, new Timestamp(decoy));
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

    public static void alterar(Carro carro) throws SQLException, Exception {
        String sql = "UPDATE veiculo SET horaS=? "
                + "WHERE (placa=?)";
        Connection con = null;
        PreparedStatement prep = null;

        con = ConnectionUtils.getConnection();
        prep = con.prepareStatement(sql);
        prep.setTimestamp(1, carro.getSaida());
        prep.setString(2, carro.getPlaca());
        prep.executeUpdate();
        con.close();
        prep.close();

    }
    
    public static ArrayList<Carro> listaCarro(){
        ArrayList<Carro> listaCarro = new ArrayList<>();
        try{
            Connection con = new ConnectionUtils().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM veiculo");
            
            while(rs.next()){
            Carro c = new Carro();
            
            c.setPlaca(rs.getString("placa"));
            c.setModelo(rs.getString("modelo"));
            c.setMarca(rs.getString("marca"));
            c.setPorte(rs.getString("porte"));
            c.setEntrada(rs.getTimestamp("horaE"));
            c.setSaida(rs.getTimestamp("horaS"));
            
            listaCarro.add(c);
            }
        
        }catch(SQLException e){
            System.out.println("Erro no banco de dados " + e);
        }
        return listaCarro;
    }

//    public static void atualizar(Carro carro, Cliente cliente) throws SQLException, Exception {
//        String sql = "UPDATE Veiculo SET modelo=?, marca=?, cor=?, porte=?"
//                + "WHERE (placa=?)";
//        Connection con = null;
//        PreparedStatement prep = null;
//        try {
//            con = ConnectionUtils.getConnection();
//            prep = con.prepareStatement(sql);
//            prep.setString(1, carro.getModelo());
//            prep.setString(2, carro.getMarca());
//            prep.setString(3, carro.getCor());
//            prep.setString(4, carro.getPorte());
//        } finally {
//            if (prep != null && !prep.isClosed()) {
//                prep.close();
//            }
//            if (con != null && !con.isClosed()) {
//                con.close();
//            }
//        }
//    } 
}
