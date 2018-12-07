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
import java.util.List;

/**
 *
 * @author murilo.aaraujo
 */
public abstract class CarroDAO implements Inserivel, Alteravel {

    public static void inserir(Carro carro) throws SQLException, Exception {
        String sql = "INSERT INTO veiculo (placa, modelo, marca, cor, porte, horaE, horaS, tipo) VALUES (?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement prep = null;
        long millis = System.currentTimeMillis();
        try {
            con = ConnectionUtils.getConnection();
            prep = con.prepareStatement(sql);
            prep.setString(1, carro.getPlaca());
            prep.setString(2, carro.getModelo());
            prep.setString(3, carro.getMarca());
            prep.setString(4, carro.getCor());
            prep.setString(5, carro.getPorte());
            prep.setTimestamp(6, new Timestamp(millis));
            prep.setTimestamp(7, new Timestamp(millis));
            prep.setString(8, carro.getTipo());
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
                + "WHERE placa=?";
        Connection con = null;
        PreparedStatement prep = null;
        long millis = System.currentTimeMillis();

        con = ConnectionUtils.getConnection();
        prep = con.prepareStatement(sql);
        prep.setTimestamp(1, new Timestamp(millis));
        prep.setString(2, carro.getPlaca());
        prep.executeUpdate();
        con.close();
        prep.close();

    }

    public static List<Carro> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM veiculo";
        //Lista de clientes de resultado
        List<Carro> listaCarro = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaCarro == null) {
                    listaCarro = new ArrayList<Carro>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                Carro carro = new Carro();
                
                carro.setPlaca(result.getString("placa"));
                carro.setModelo(result.getString("modelo"));
                carro.setCor(result.getString("cor"));
                carro.setEntrada(result.getTimestamp("horaE"));
                carro.setSaida(result.getTimestamp("horaS"));
                carro.setTipo(result.getString("tipo"));
                
                listaCarro.add(carro);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de clientes do banco de dados
        return listaCarro;
    }

    public static Carro getCarroByPlaca(String placa) {
        Carro c = new Carro();
        try {
            Connection con = new ConnectionUtils().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `veiculo` where placa = '" + placa + "'");

            while (rs.next()) {
                c.setPlaca(rs.getString("placa"));
                c.setModelo(rs.getString("modelo"));
                c.setMarca(rs.getString("marca"));
                c.setPorte(rs.getString("porte"));
                c.setEntrada(rs.getTimestamp("horaE"));
                c.setSaida(rs.getTimestamp("horaS"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados " + e);
        }
        return c;
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
