
package servidor.entidades;


public class Exame {
   
    private String tipo;

    public Exame(String tipo) {
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
