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
public class ExameMarcado extends Dados {
    
    private String tipo;

    public ExameMarcado(String cpf,String telefone, String data, String horario, String observacoes, String tipo) {
        setCpf(cpf);
        setTelefone(telefone);
        setData(data);
        setHorario(horario);
        setObservacoes(observacoes);
        setTipo(tipo);
    } 

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
