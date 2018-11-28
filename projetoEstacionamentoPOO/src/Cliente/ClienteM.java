/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.sql.Date;

/**
 *
 * @author ADRIANA
 */
public class ClienteM extends Cliente{
    private String cpf;
    private String endereco;
    private String email;
    private Date datanascimento;
    private String celular;
    private String cep;
    
     public Date getDataNascimento() {
        return datanascimento;
    }

    public void setDataNascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
}
