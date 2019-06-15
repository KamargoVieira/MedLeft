/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.entidades;

/**
 *
 * @author kamargo
 */
public class Funcionario extends Usuario {

    public Funcionario() {
        
    }

    public Funcionario(String nome, String cpf, String usuario, String senha) {
        setNome(nome);
        setCpf(cpf);
        setUsuario(usuario);
        setSenha(senha);
    }
    
}
