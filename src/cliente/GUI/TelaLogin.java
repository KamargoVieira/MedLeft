package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    Conexao conexao; 
    public TelaLogin(Conexao conexao) {
        this.conexao = conexao;
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        typeUser = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tela de Login");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(760, 390, 66, 21);

        try {
            user.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        user.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        getContentPane().add(user);
        user.setBounds(840, 380, 300, 50);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Senha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(760, 460, 53, 21);

        password.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(password);
        password.setBounds(840, 440, 300, 49);

        typeUser.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        typeUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:  Tipo de Usuario", "Medico", "Funcionario", "Paciente" }));
        typeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeUserActionPerformed(evt);
            }
        });
        getContentPane().add(typeUser);
        typeUser.setBounds(760, 510, 380, 49);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(760, 570, 380, 50);

        jButton3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton3.setText("Encerrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(580, 680, 120, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/iconmed.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 120, 610, 510);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1230, 760);

        setSize(new java.awt.Dimension(1226, 790));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void typeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeUserActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           String senha = new String(password.getPassword());
        if(user.getText().isBlank() || senha.length() < 1 || typeUser.getSelectedItem().equals("Selecione:  Tipo de Usuario")){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
               try {
                   conexao.enviar("TelaLogin@"+user.getText()+"@"+senha+"@"+typeUser.getSelectedItem());
                   String op = conexao.receber();
                   
                    switch(op){
                        case "mestre":
                            this.dispose();
                            new TelaMestre(conexao).setVisible(true);
                            break;
                        case "funcionario":
                            this.dispose();
                            new TelaFuncionario(conexao).setVisible(true);
                            break;
                        case "medico":
                            this.dispose();
                            new TelaMedico(conexao).setVisible(true);
                            break;
                        case "paciente":
                            this.dispose();
                            new TelaPaciente(conexao).setVisible(true);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Dados Incorretos ou Usuário Inexistente!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }
               } catch (IOException ex) {
                   Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox<String> typeUser;
    private javax.swing.JFormattedTextField user;
    // End of variables declaration//GEN-END:variables
}