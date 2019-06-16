
package servidor.entidades;

public class Atestado {
    
    private String cpf;
    private String inicio;
    private String fim;
    private String motivos;
    
    public Atestado(String cpf, String inicio, String fim, String motivos){
        this.cpf = cpf;
        this.inicio = inicio;
        this.fim = fim;
        this.motivos = motivos;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the inicio
     */
    public String getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fim
     */
    public String getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(String fim) {
        this.fim = fim;
    }

    /**
     * @return the motivos
     */
    public String getMotivos() {
        return motivos;
    }

    /**
     * @param motivos the motivos to set
     */
    public void setMotivos(String motivos) {
        this.motivos = motivos;
    }
    
}
