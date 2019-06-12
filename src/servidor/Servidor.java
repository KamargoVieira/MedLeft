/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author kamargo
 */
public class Servidor extends Thread {
    
    Conexao conexao;
    
    public Servidor(Socket cliente) throws IOException {
        this.conexao = new Conexao(cliente);
    }

    @Override
    public void run() {
        
    }
}
