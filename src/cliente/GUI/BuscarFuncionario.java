package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BuscarFuncionario extends javax.swing.JFrame {

    Conexao conexao;
    public BuscarFuncionario(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cpfSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nome = new javax.swing.JLabel();
        cpf = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Funcionário");
        getContentPane().setLayout(null);

        name.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        name.setText("Nome:");
        getContentPane().add(name);
        name.setBounds(80, 240, 90, 20);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("CPF:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 280, 90, 21);

        cpfSearch.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cpfSearch);
        cpfSearch.setBounds(150, 110, 270, 50);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setText("CPF:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(90, 120, 90, 21);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 110, 110, 50);

        nome.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(nome);
        nome.setBounds(180, 240, 460, 30);

        cpf.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cpf);
        cpf.setBounds(180, 280, 370, 30);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 1220, 770);

        setSize(new java.awt.Dimension(1214, 474));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                        String[] dados = op.split("@");
                        nome.setText(dados[0]);
                        cpf.setText(dados[1]);
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(BuscarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cpf;
    private javax.swing.JTextField cpfSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nome;
    // End of variables declaration//GEN-END:variables
}