package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastrarMedico extends javax.swing.JFrame {

    Conexao conexao;
    public CadastrarMedico(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        nome = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        especialidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Medico");
        getContentPane().setLayout(null);

        nome.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        getContentPane().add(nome);
        nome.setBounds(160, 80, 440, 50);

        name.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        name.setText("Nome:");
        getContentPane().add(name);
        name.setBounds(30, 100, 90, 21);

        cpf.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cpf);
        cpf.setBounds(160, 140, 270, 50);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("CPF:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 150, 90, 21);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Especialidade:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 210, 120, 21);

        especialidade.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(especialidade);
        especialidade.setBounds(160, 200, 270, 50);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Usuário:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 270, 80, 21);

        user.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(user);
        user.setBounds(160, 260, 210, 50);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Senha:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 320, 60, 21);

        jButton2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton2.setText("Cadastrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(260, 460, 130, 40);
        getContentPane().add(password);
        password.setBounds(160, 320, 210, 50);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 0, 650, 530);

        setSize(new java.awt.Dimension(632, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        
    }//GEN-LAST:event_nomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(nome.getText().isBlank() || cpf.getText().isBlank() || especialidade.getText().isBlank() || user.getText().isBlank() || password.getPassword().length <1){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos.", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String str = "CadastrarMedico@"+nome.getText()+"@"+cpf.getText()+"@"+user.getText()+"@"+ new String(password.getPassword())+"@"+especialidade.getText();
                conexao.enviar(str);
                String op = conexao.receber();
                switch(op){
                    case "ok":
                        JOptionPane.showMessageDialog(null,"Médico cadastrado com sucesso!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "jaexiste":
                        JOptionPane.showMessageDialog(null,"Nome de usuário já existe. Tente outro.", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        user.setText("");
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField especialidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nome;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}