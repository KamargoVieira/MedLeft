package servidor.entidades;

public class Consulta extends Dados {
    
    private String especialista;

    public Consulta(String especialista, String cpf, String telefone, String data, String horario, String observacoes, String status) {
        setCpf(cpf);
        setTelefone(telefone);
        setData(data);
        setHorario(horario);
        setObservacoes(observacoes);
        setEspecialista(especialista);
        setStatus(status); 
    }

    /**
     * @return the especialista
     */
    public String getEspecialista() {
        return especialista;
    }

    /**
     * @param especialista the especialista to set
     */
    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }
    
}
