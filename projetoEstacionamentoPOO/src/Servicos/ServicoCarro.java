/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import DAOs.CarroDAO;
import Veiculos.Carro;
/**
 *
 * @author murilo.aaraujo
 */
public class ServicoCarro {
    public static void cadastrarCarro(Carro carro) throws Exception{
        CarroDAO.inserir(carro);
    }
}