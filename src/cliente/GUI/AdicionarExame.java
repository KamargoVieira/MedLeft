package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class AdicionarExame extends javax.swing.JFrame {

    Conexao conexao;
    public AdicionarExame(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        nameExame = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adicionar Exame");
        getContentPane().setLayout(null);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("Nome do Exame:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 70, 160, 21);

        nameExame.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(nameExame);
        nameExame.setBounds(90, 100, 270, 50);

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 170, 110, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 450, 270);

        setSize(new java.awt.Dimension(439, 297));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(nameExame.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Informe o nome do Exame a ser adicionado!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String str = "AddExame@" + nameExame.getText();
                conexao.enviar(str);
                String op = conexao.receber();
                
                switch(op){
                    case "jaexiste":
                        JOptionPane.showMessageDialog(null,"Nome já cadastrado. Tente outro!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        nameExame.setText("");
                        break;
                    case "ok":
                        JOptionPane.showMessageDialog(null,"Exame cadastrado com sucesso!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(AdicionarExame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nameExame;
    // End of variables declaration//GEN-END:variables
}