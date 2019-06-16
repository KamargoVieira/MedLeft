package cliente.GUI;

import cliente.Conexao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Atestado extends javax.swing.JFrame {

    Conexao conexao;
    public Atestado(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fim = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inicio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        motivos = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Gerar Atestado Médico");
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("CPF (Paciente):");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 100, 150, 21);
        getContentPane().add(cpf);
        cpf.setBounds(210, 90, 270, 50);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("a:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(280, 180, 60, 21);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/printer.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 430, 120, 50);

        jButton2.setText("Voltar");
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 430, 140, 50);
        getContentPane().add(fim);
        fim.setBounds(320, 170, 160, 50);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("De:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 180, 60, 21);
        getContentPane().add(inicio);
        inicio.setBounds(100, 170, 160, 50);

        motivos.setColumns(20);
        motivos.setRows(5);
        jScrollPane2.setViewportView(motivos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(60, 270, 420, 92);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Motivos:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 240, 90, 18);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 550, 540);

        setSize(new java.awt.Dimension(549, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(cpf.getText().isBlank() || inicio.getText().isBlank() || fim.getText().isBlank() || motivos.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String str = "Atestado@"+cpf.getText()+"@"+inicio.getText()+"@"+fim.getText()+"@"+motivos.getText();
                conexao.enviar(str);
                String op = conexao.receber();
                switch(op){                    
                    case "naoencotrado":
                        JOptionPane.showMessageDialog(null,"Paciente não encontrado!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        cpf.setText("");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Aguarde, Atestado será impresso...", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        String endereco = new File(".").getCanonicalPath();
                        File arquivo = new File(endereco+"/src/cliente/Atestados/"+cpf.getText()+".txt");
                        FileWriter fw = new FileWriter(arquivo);
                        BufferedWriter bw = new BufferedWriter(fw); 
                        bw.write(op);
                        bw.close();
                        fw.close();
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Atestado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField fim;
    private javax.swing.JTextField inicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea motivos;
    // End of variables declaration//GEN-END:variables
}