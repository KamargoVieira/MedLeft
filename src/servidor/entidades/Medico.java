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
public class Medico extends Usuario{
    private String especialidade;

    public Medico(String nome, String cpf, String usuario, String senha, String especialidade) {
        setNome(nome);
        setCpf(cpf);
        setUsuario(usuario);
        setSenha(senha);
        setEspecialidade(especialidade);
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    
}
