/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author kamargo
 */
public class Conexao {

    private final Socket cliente;
    private final DataOutputStream saida;
    private final DataInputStream entrada;

    public Conexao() throws IOException {
        this.cliente = new Socket("127.0.0.1", 12345);
        this.saida = new DataOutputStream(cliente.getOutputStream());
        this.entrada = new DataInputStream(cliente.getInputStream());
    }

    public void enviar(String str) throws IOException {
        saida.writeUTF(str);
    }

    public String receber() throws IOException {
        return entrada.readUTF();
    }

    public void fechar() throws IOException {
        this.saida.close();
        this.entrada.close();
        this.cliente.close();
    }
}
