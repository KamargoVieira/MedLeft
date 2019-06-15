package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RemoverFuncionario extends javax.swing.JFrame {

    Conexao conexao;
    public RemoverFuncionario(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cpf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Remover Funcionario");
        getContentPane().setLayout(null);

        cpf.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cpf);
        cpf.setBounds(100, 80, 270, 50);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("CPF:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 90, 90, 21);

        jButton1.setText("Remover");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(180, 150, 110, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 430, 270);

        setSize(new java.awt.Dimension(430, 294));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(cpf.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Preencha o campo indicado!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String str = "RemoverFuncionario@"+cpf.getText();
                conexao.enviar(str);
                String op = conexao.receber();
                switch(op){
                    case "ok":
                        JOptionPane.showMessageDialog(null,"Funcionario Removido com Sucesso!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "naoencontrado":
                        JOptionPane.showMessageDialog(null,"Funcionario não encontrado!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(RemoverFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
