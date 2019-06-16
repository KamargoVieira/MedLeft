package servidor.entidades;

public class Consulta extends Dados {
    
    private String especialista;

    public Consulta(String cpf, int id, String telefone, String data, String horrio, String observacoes, String especialista) {
        setCpf(cpf);
        setId(id);
        setTelefone(telefone);
        setData(data);
        setHorario(horrio);
        setObservacoes(observacoes);
        setEspecialista(especialista);
 
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
