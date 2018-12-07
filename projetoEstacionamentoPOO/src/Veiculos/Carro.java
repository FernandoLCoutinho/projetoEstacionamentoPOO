/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Veiculos;

import java.sql.Timestamp;

/**
 *
 * @author murilo.aaraujo
 */
public class Carro extends VeiculoGeral{
    
    private String marca;
    private String porte;
    private Timestamp horaE;
    private Timestamp horaS;
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getPorte(){
        return porte;
    }
    
    public void setPorte(String porte){
        this.porte = porte;
    }
    
    public Timestamp getEntrada() {
        return horaE;
    }

    public void setEntrada(Timestamp entrada) {
        this.horaE = entrada;
    }

    public Timestamp getSaida() {
        return horaS;
    }

    public void setSaida(Timestamp saida) {
        this.horaS = saida;
    }
}
