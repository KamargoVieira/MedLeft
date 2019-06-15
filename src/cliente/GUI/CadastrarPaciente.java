package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastrarPaciente extends javax.swing.JFrame {

    Conexao conexao;
    public CadastrarPaciente(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nome = new javax.swing.JTextField();
        endereco = new javax.swing.JTextField();
        enderecoj = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        bairro = new javax.swing.JTextField();
        municipio = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        cep = new javax.swing.JTextField();
        estado = new javax.swing.JComboBox<>();
        celular = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        datanascimento = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Paciente");
        setResizable(false);
        getContentPane().setLayout(null);

        nome.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        getContentPane().add(nome);
        nome.setBounds(160, 50, 300, 50);

        endereco.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoActionPerformed(evt);
            }
        });
        getContentPane().add(endereco);
        endereco.setBounds(160, 110, 600, 50);

        enderecoj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        enderecoj.setText("Endereço: ");
        getContentPane().add(enderecoj);
        enderecoj.setBounds(30, 130, 90, 21);

        name.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        name.setText("Nome:");
        getContentPane().add(name);
        name.setBounds(30, 70, 90, 21);

        bairro.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(bairro);
        bairro.setBounds(160, 170, 270, 50);

        municipio.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        municipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                municipioActionPerformed(evt);
            }
        });
        getContentPane().add(municipio);
        municipio.setBounds(160, 230, 270, 50);

        telefone.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(telefone);
        telefone.setBounds(160, 410, 270, 50);

        cep.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cep);
        cep.setBounds(160, 290, 270, 50);

        estado.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));
        getContentPane().add(estado);
        estado.setBounds(160, 350, 270, 50);

        celular.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celularActionPerformed(evt);
            }
        });
        getContentPane().add(celular);
        celular.setBounds(540, 410, 220, 50);

        cpf.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cpf);
        cpf.setBounds(160, 470, 270, 50);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Municipio:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 250, 90, 21);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Bairro:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 190, 70, 21);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Telefone:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 430, 80, 21);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("CPF:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 480, 90, 21);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Cadastrar");
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
        jLabel8.setBounds(30, 300, 50, 21);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setText("Estado:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 360, 70, 18);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setText("Celular:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(450, 420, 70, 21);

        try {
            datanascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        datanascimento.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(datanascimento);
        datanascimento.setBounds(610, 50, 180, 50);

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setText("Data de Nasc.:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(470, 70, 120, 18);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Usuário:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 540, 80, 21);

        user.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(user);
        user.setBounds(160, 530, 210, 50);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setText("Senha:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 600, 60, 21);
        getContentPane().add(password);
        password.setBounds(160, 590, 210, 50);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1220, 760);

        setSize(new java.awt.Dimension(1227, 790));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enderecoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(nome.getText().isBlank() || datanascimento.getText().isBlank() || endereco.getText().isBlank() || bairro.getText().isBlank() ||
                municipio.getText().isBlank() || cep.getText().isBlank() || estado.getSelectedItem().equals("--") || telefone.getText().isBlank()||
                celular.getText().isBlank() || cpf.getText().isBlank() || user.getText().isBlank() || password.getPassword().length < 1){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos.", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String str = "CadastrarPaciente@"+nome.getText()+"@"+datanascimento.getText()+"@"+ endereco.getText()+"@"+bairro.getText()+ "@"+
                    municipio.getText() + "@"+ cep.getText() + "@" + estado.getSelectedItem()+ "@" + telefone.getText()+ "@"+
                    celular.getText()+"@"+cpf.getText()+"@"+user.getText()+"@"+ new String(password.getPassword());
                conexao.enviar(str);
                String op = conexao.receber();
                switch(op){
                    case "ok":
                        JOptionPane.showMessageDialog(null,"Paciente cadastrado com sucesso!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "jaexiste":
                        JOptionPane.showMessageDialog(null,"Nome de usuário já existe. Tente outro.", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        user.setText("");
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(CadastrarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void municipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_municipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_municipioActionPerformed

    private void celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_celularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro;
    private javax.swing.JTextField celular;
    private javax.swing.JTextField cep;
    private javax.swing.JTextField cpf;
    private javax.swing.JFormattedTextField datanascimento;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel enderecoj;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTextField municipio;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nome;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField telefone;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}