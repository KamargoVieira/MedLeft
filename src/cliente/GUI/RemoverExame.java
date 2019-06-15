package cliente.GUI;

import cliente.Conexao;

public class RemoverExame extends javax.swing.JFrame {

    Conexao conexao;
    public RemoverExame(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("Nome do Exame:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 70, 160, 21);

        jTextField6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jTextField6);
        jTextField6.setBounds(90, 100, 270, 50);

        jButton1.setText("Remover");
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 170, 110, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 450, 270);

        setSize(new java.awt.Dimension(447, 297));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
