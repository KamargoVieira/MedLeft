package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlterarFuncionario extends javax.swing.JFrame {

    Conexao conexao;
    String  senhaAux;
    String  userAux;
    String nomeAux;
    public AlterarFuncionario(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
        nome.setVisible(false);
        cpf.setVisible(false);
        user.setVisible(false);
        password.setVisible(false);
        nomej.setVisible(false);
        cpfj.setVisible(false);
        userj.setVisible(false);
        passwordj.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JTextField();
        nomej = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        cpfj = new javax.swing.JLabel();
        userj = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        passwordj = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cpfSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alterar Funcionário");
        getContentPane().setLayout(null);

        nome.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        getContentPane().add(nome);
        nome.setBounds(170, 130, 440, 50);

        nomej.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nomej.setText("Nome:");
        getContentPane().add(nomej);
        nomej.setBounds(40, 150, 90, 21);

        cpf.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cpf);
        cpf.setBounds(170, 190, 270, 50);

        cpfj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cpfj.setText("CPF:");
        getContentPane().add(cpfj);
        cpfj.setBounds(40, 200, 90, 21);

        userj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        userj.setText("Usuário:");
        getContentPane().add(userj);
        userj.setBounds(40, 260, 80, 21);

        user.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(user);
        user.setBounds(170, 250, 210, 50);

        passwordj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        passwordj.setText("Senha:");
        getContentPane().add(passwordj);
        passwordj.setBounds(40, 310, 60, 21);

        jButton2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 400, 130, 40);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("CPF do Funcionario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 170, 21);

        cpfSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cpfSearch);
        cpfSearch.setBounds(210, 40, 270, 50);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 40, 100, 50);
        getContentPane().add(password);
        password.setBounds(170, 310, 210, 50);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 0, 700, 550);

        setSize(new java.awt.Dimension(662, 491));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            if(!(nome.getText().isBlank()))
                this.nomeAux = nome.getText();
            if(!(user.getText().isBlank()))
                this.userAux = user.getText();
            if(!(password.getPassword().length < 1))
                this.senhaAux = new String(password.getPassword());
            String str = "AlterarFuncionario@"+this.nomeAux+"@"+cpf.getText()+"@"+this.userAux+"@"+this.senhaAux;
            conexao.enviar(str);
            String op = conexao.receber();
            
            switch(op){
                case "ok":
                    JOptionPane.showMessageDialog(null,"Funcionario alterado com sucesso!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "userjaexiste":
                    JOptionPane.showMessageDialog(null,"Nome de usuario informado já existe. Tente outro!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                    user.setText("");
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(cpfSearch.getText().isBlank()){
           JOptionPane.showMessageDialog(null,"Digite algo no campo de busca!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
       }else{
           try {
               String str = "BuscarFuncionario@"+cpfSearch.getText();
               conexao.enviar(str);
               String op = conexao.receber();
               
               switch(op){
                    case "naoencontrado":
                        JOptionPane.showMessageDialog(null,"Funcionário não encontrado", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;   
                    default:
                        nome.setVisible(true);
                        cpf.setVisible(true);
                        user.setVisible(true);
                        password.setVisible(true);
                        nomej.setVisible(true);
                        cpfj.setVisible(true);
                        userj.setVisible(true);
                        passwordj.setVisible(true);
                        String[] dados = op.split("@");
                        nome.setText(dados[0]);
                        cpf.setText(dados[1]);
                        cpf.setEditable(false);
                        user.setText(dados[2]);
                        this.userAux = dados[2];
                        this.senhaAux = dados[3];
                        this.nomeAux = dados[0];
                        break;
               }
           } catch (IOException ex) {
               Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField cpfSearch;
    private javax.swing.JLabel cpfj;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nome;
    private javax.swing.JLabel nomej;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordj;
    private javax.swing.JTextField user;
    private javax.swing.JLabel userj;
    // End of variables declaration//GEN-END:variables
}