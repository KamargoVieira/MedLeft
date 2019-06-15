
package cliente.GUI;

import cliente.Conexao;


public class AgendarExame extends javax.swing.JFrame {

    Conexao conexao;
    public AgendarExame(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Exame:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 90, 110, 21);

        jComboBox1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(190, 80, 400, 50);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("CPF:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 160, 36, 21);

        jTextField1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(190, 150, 400, 50);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Data:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 310, 42, 21);

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jFormattedTextField1);
        jFormattedTextField1.setBounds(190, 300, 190, 50);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Horário:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 380, 80, 21);

        jComboBox2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- -", "08:00", "08:20", "08:40", "09:00", "09:20", "09:40", "10:00", "10:20", "10:40", "11:00", "11:20", "11:40", "14:00", "14:20", "14:40", "15:00", "15:20", "15:40", "16:00", "16:20", "16:40", "17:00", "17:20", "17:40" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(190, 370, 190, 50);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setText("Observações:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 440, 120, 21);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\n");
        jTextArea1.setAlignmentX(1.0F);
        jTextArea1.setAlignmentY(1.0F);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 440, 420, 170);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Agendar");
        getContentPane().add(jButton1);
        jButton1.setBounds(420, 660, 160, 50);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("Telefone p/ contato:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 240, 180, 21);

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)9####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(jFormattedTextField2);
        jFormattedTextField2.setBounds(250, 220, 260, 50);

        jToggleButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jToggleButton1.setText("Imprimir Comprovante");
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(200, 660, 210, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 760);

        setSize(new java.awt.Dimension(1197, 790));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
