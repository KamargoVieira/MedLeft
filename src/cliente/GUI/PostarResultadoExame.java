package cliente.GUI;

import cliente.Conexao;


public class PostarResultadoExame extends javax.swing.JFrame {
    
    Conexao conexao;
    public PostarResultadoExame(Conexao conexao) {
        initComponents();
        escolherArquivo.setVisible(false);
        this.conexao = conexao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escolherArquivo = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Postar Exame");
        getContentPane().setLayout(null);
        getContentPane().add(escolherArquivo);
        escolherArquivo.setBounds(450, 90, 670, 600);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Escolher Arquivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 120, 180, 50);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("CPF (Paciente):");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 210, 150, 21);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(200, 200, 220, 50);

        jButton2.setText("Postar");
        getContentPane().add(jButton2);
        jButton2.setBounds(160, 280, 150, 60);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Selecionar o Arquivo:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 130, 190, 21);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 760);

        setSize(new java.awt.Dimension(1193, 786));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        escolherArquivo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser escolherArquivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}