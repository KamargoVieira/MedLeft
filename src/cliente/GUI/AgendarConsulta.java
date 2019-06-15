package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AgendarConsulta extends javax.swing.JFrame {

    Conexao conexao;
    public AgendarConsulta(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        especialista = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        data = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        horario = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        telefone = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agendar Consulta");
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Especialista:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 90, 110, 21);

        especialista.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        especialista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));
        getContentPane().add(especialista);
        especialista.setBounds(190, 80, 400, 50);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("CPF:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 160, 36, 21);

        cpf.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cpf);
        cpf.setBounds(190, 150, 400, 50);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Data:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 310, 42, 21);

        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(data);
        data.setBounds(190, 300, 190, 50);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Horário:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 380, 80, 21);

        horario.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        horario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "08:00", "08:20", "08:40", "09:00", "09:20", "09:40", "10:00", "10:20", "10:40", "11:00", "11:20", "11:40", "14:00", "14:20", "14:40", "15:00", "15:20", "15:40", "16:00", "16:20", "16:40", "17:00", "17:20", "17:40" }));
        getContentPane().add(horario);
        horario.setBounds(190, 370, 190, 50);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setText("Observações:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 440, 120, 21);

        obs.setColumns(20);
        obs.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        obs.setRows(5);
        obs.setAlignmentX(1.0F);
        obs.setAlignmentY(1.0F);
        jScrollPane1.setViewportView(obs);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 440, 420, 170);

        jButton1.setText("Agendar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 670, 120, 50);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("Telefone p/ contato:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 240, 180, 21);

        try {
            telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)9####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(telefone);
        telefone.setBounds(250, 220, 260, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 760);

        setBounds(0, 0, 1197, 790);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(especialista.getSelectedItem().equals("--") || cpf.getText().isBlank() || telefone.getText().isBlank() ||
            data.getText().isBlank() || horario.getSelectedItem().equals("--") || obs.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String str = "AgendarConsulta@"+especialista.getSelectedItem()+"@"+cpf.getText()+"@"+telefone.getText()+"@"+data.getText()+"@"+horario.getSelectedItem()+"@"+obs.getText()+"confirmada";
                conexao.enviar(str);
                String op = conexao.receber();
                switch(op){
                    case "ok":
                        JOptionPane.showMessageDialog(null,"Consulta agendada com sucesso!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "datahorario":
                        JOptionPane.showMessageDialog(null,"Já existe uma consulta marcada para este horário. Tente outro!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(AgendarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpf;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JComboBox<String> especialista;
    private javax.swing.JComboBox<String> horario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea obs;
    private javax.swing.JFormattedTextField telefone;
    // End of variables declaration//GEN-END:variables
}