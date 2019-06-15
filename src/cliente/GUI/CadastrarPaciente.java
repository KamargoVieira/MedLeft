
package cliente.GUI;

import cliente.Conexao;

public class CadastrarPaciente extends javax.swing.JFrame {

    Conexao conexao;
    public CadastrarPaciente(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        identificacao = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        endereco = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        bairro = new javax.swing.JTextField();
        municipio = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Paciente");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Identificação:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 90, 110, 18);

        identificacao.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(identificacao);
        identificacao.setBounds(160, 70, 260, 50);

        nome.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        getContentPane().add(nome);
        nome.setBounds(160, 130, 600, 50);

        jTextField1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(160, 190, 600, 50);

        endereco.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        endereco.setText("Endereço: ");
        getContentPane().add(endereco);
        endereco.setBounds(30, 210, 90, 21);

        name.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        name.setText("Nome:");
        getContentPane().add(name);
        name.setBounds(30, 150, 90, 21);

        bairro.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(bairro);
        bairro.setBounds(160, 250, 270, 50);

        municipio.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        municipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                municipioActionPerformed(evt);
            }
        });
        getContentPane().add(municipio);
        municipio.setBounds(160, 310, 270, 50);

        jTextField2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jTextField2);
        jTextField2.setBounds(160, 490, 270, 50);

        jTextField3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jTextField3);
        jTextField3.setBounds(160, 370, 270, 50);

        jComboBox1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(160, 430, 270, 50);

        jTextField4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(540, 490, 220, 50);

        jTextField5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jTextField5);
        jTextField5.setBounds(160, 550, 600, 50);

        jTextField6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jTextField6);
        jTextField6.setBounds(160, 620, 270, 50);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Municipio:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 330, 90, 21);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Bairro:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 270, 70, 21);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Telefone:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 510, 80, 21);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setText("Email:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 570, 49, 18);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("CPF:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 630, 90, 21);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Próximo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1010, 670, 170, 50);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setText("CEP:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 380, 50, 21);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setText("Estado:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 440, 70, 18);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setText("Celular:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(450, 500, 70, 21);

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jFormattedTextField1);
        jFormattedTextField1.setBounds(581, 70, 180, 50);

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setText("Data de Nasc.:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(440, 80, 120, 18);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1220, 760);

        setSize(new java.awt.Dimension(1227, 790));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new CadastrarPacienteDadosDeAcesso().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void municipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_municipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_municipioActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro;
    private javax.swing.JLabel endereco;
    private javax.swing.JTextField identificacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField municipio;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nome;
    // End of variables declaration//GEN-END:variables
}
