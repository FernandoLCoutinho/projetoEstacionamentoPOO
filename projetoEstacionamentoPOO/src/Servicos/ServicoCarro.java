/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import DAOs.CarroDAO;
import Veiculos.Carro;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author murilo.aaraujo
 */
public class ServicoCarro {
    public static void cadastrarCarro(Carro carro) throws Exception{
        CarroDAO.inserir(carro);
    }
    
    public static List<Carro> listarCarro() throws Exception{
        List<Carro> listaCarro = null;
        listaCarro = CarroDAO.listar();
        return listaCarro;
        
    }
    
    public static void saidaCarro(String Placa) throws Exception{
        Carro c = CarroDAO.getCarroByPlaca(Placa);
        CarroDAO.alterar(c);
    }
}
