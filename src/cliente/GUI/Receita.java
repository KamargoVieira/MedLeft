package cliente.GUI;

import cliente.Conexao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Receita extends javax.swing.JFrame {

    Conexao conexao;
    public Receita(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar Receita");
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("CPF (Paciente):");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 80, 150, 21);
        getContentPane().add(cpf);
        cpf.setBounds(210, 70, 270, 50);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Medicamentos/ Quantidade/ Período:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 150, 340, 21);

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 190, 420, 200);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 550, 540);

        setSize(new java.awt.Dimension(550, 565));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(texto.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String str = "Receita@"+cpf.getText()+"@"+texto.getText();
                conexao.enviar(str);
                String op = conexao.receber();
                switch(op){
                    default:
                        JOptionPane.showMessageDialog(null,"Aguarde, Receita será impresso...", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        String endereco = new File(".").getCanonicalPath();
                        File arquivo = new File(endereco+"/src/cliente/Receitas/"+cpf.getText()+".txt");
                        FileWriter fw = new FileWriter(arquivo);
                        BufferedWriter bw = new BufferedWriter(fw); 
                        bw.write(op);
                        bw.close();
                        fw.close();
                        break;
                    case "naoencotrado":
                        JOptionPane.showMessageDialog(null,"Paciente não encontrado!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        cpf.setText("");
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Receita.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}