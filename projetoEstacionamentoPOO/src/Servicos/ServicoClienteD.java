/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import Cliente.Cliente;
import DAOs.ClienteDDAO;

/**
 *
 * @author fernando.lcoutinho
 */
public class ServicoClienteD {
    public static void cadastrarClienteD(Cliente cliente) throws Exception {
        ClienteDDAO.inserir(cliente);
    }
}
