/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import DAOs.CarroDAO;
import Veiculos.Carro;
import Veiculos.Moto;
import java.util.List;


/**
 *
 * @author fernando.lcoutinho
 */
public class ServicoMoto {
    public static void cadastrarMoto(Moto moto) throws Exception{
        CarroDAO.inserirM(moto);
    }
    
    public static List<Moto> listarMoto() throws Exception{
        List<Moto> listaMoto = null;
        listaMoto = CarroDAO.listarM();
        return listaMoto;
        
    }
}
