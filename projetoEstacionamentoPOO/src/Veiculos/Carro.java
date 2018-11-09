/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Veiculos;

/**
 *
 * @author murilo.aaraujo
 */
public class Carro {
    private String placa;
    private String modelo;
    private String chassi;
    private String marca;
    private String cor;
    
    
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getChassi(){
        return chassi;
    }
    
    public void setChassi(String chassi){
        this.chassi = chassi;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getCor(){
        return cor;
    }
    
    public void setCor(String cor){
        this.cor = cor;
    }
}
