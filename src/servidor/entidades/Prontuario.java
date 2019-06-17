package servidor.entidades;


public class Prontuario {
    
    private String cpf;
    private String usuario;
    private String queixaprincipal;
    private String historicofamiliar;
    private String obs;
    private String altura;
    private String peso;
    private String hemoglucoteste;
    private String frequenciacardiaca;
    private String pressaosistotica;
    private String pressaodiastolica;
    private String obs2;

    public Prontuario(String cpf, String usuario, String queixaprincipal, String historicofamiliar, String obs, String altura, String peso, String hemoglucoteste, String frequenciacardiaca, String pressaosistotica, String pressaodiastolica, String obs2) {
        setCpf(cpf);
        setQueixaprincipal(queixaprincipal);
        setHistoricofamiliar(historicofamiliar);
        setObs(obs);
        setAltura(altura);
        setPeso(peso);
        setHemoglucoteste(hemoglucoteste);
        setFrequenciacardiaca(frequenciacardiaca);
        setPressaosistotica(pressaosistotica);
        setPressaodiastolica(pressaodiastolica);
        setObs2(obs2);
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
    
    public String getQueixaprincipal() {
        return queixaprincipal;
    }

    /**
     * @param queixaprincipal the queixaprincipal to set
     */
    public void setQueixaprincipal(String queixaprincipal) {
        this.queixaprincipal = queixaprincipal;
    }

    /**
     * @return the historicofamiliar
     */
    public String getHistoricofamiliar() {
        return historicofamiliar;
    }

    /**
     * @param historicofamiliar the historicofamiliar to set
     */
    public void setHistoricofamiliar(String historicofamiliar) {
        this.historicofamiliar = historicofamiliar;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the altura
     */
    public String getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(String altura) {
        this.altura = altura;
    }

    /**
     * @return the peso
     */
    public String getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }

    /**
     * @return the hemoglucoteste
     */
    public String getHemoglucoteste() {
        return hemoglucoteste;
    }

    /**
     * @param hemoglucoteste the hemoglucoteste to set
     */
    public void setHemoglucoteste(String hemoglucoteste) {
        this.hemoglucoteste = hemoglucoteste;
    }

    /**
     * @return the frequenciacardiaca
     */
    public String getFrequenciacardiaca() {
        return frequenciacardiaca;
    }

    /**
     * @param frequenciacardiaca the frequenciacardiaca to set
     */
    public void setFrequenciacardiaca(String frequenciacardiaca) {
        this.frequenciacardiaca = frequenciacardiaca;
    }

    /**
     * @return the pressaosistotica
     */
    public String getPressaosistotica() {
        return pressaosistotica;
    }

    /**
     * @param pressaosistotica the pressaosistotica to set
     */
    public void setPressaosistotica(String pressaosistotica) {
        this.pressaosistotica = pressaosistotica;
    }

    /**
     * @return the pressaodiastolica
     */
    public String getPressaodiastolica() {
        return pressaodiastolica;
    }

    /**
     * @param pressaodiastolica the pressaodiastolica to set
     */
    public void setPressaodiastolica(String pressaodiastolica) {
        this.pressaodiastolica = pressaodiastolica;
    }

    /**
     * @return the obs2
     */
    public String getObs2() {
        return obs2;
    }

    /**
     * @param obs2 the obs2 to set
     */
    public void setObs2(String obs2) {
        this.obs2 = obs2;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}