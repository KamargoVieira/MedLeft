package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlterarPaciente extends javax.swing.JFrame {

    Conexao conexao;
    String nomeAux, enderecoAux,bairroAux,municipioAux,cepAux,estadoAux,telefoneAux, celularAux, userAux, senhaAux;   
    
    public AlterarPaciente(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
        nome.setVisible(false);
        nomej.setVisible(false);
        datanascimento.setVisible(false);
        datanascimentoj.setVisible(false);
        endereco.setVisible(false);
        enderecoj.setVisible(false);
        bairro.setVisible(false);
        bairroj.setVisible(false);
        municipio.setVisible(false);
        municipioj.setVisible(false);
        cep.setVisible(false);
        cepj.setVisible(false);
        estado.setVisible(false);
        estadoj.setVisible(false);
        telefone.setVisible(false);
        telefonej.setVisible(false);
        celular.setVisible(false);
        celularj.setVisible(false);
        cpf.setVisible(false);
        cpfj.setVisible(false);
        user.setVisible(false);
        userj.setVisible(false);
        password.setVisible(false);
        password.setVisible(false);        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        nome = new javax.swing.JTextField();
        endereco = new javax.swing.JTextField();
        enderecoj = new javax.swing.JLabel();
        nomej = new javax.swing.JLabel();
        bairro = new javax.swing.JTextField();
        municipio = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        cep = new javax.swing.JTextField();
        estado = new javax.swing.JComboBox<>();
        celular = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        municipioj = new javax.swing.JLabel();
        bairroj = new javax.swing.JLabel();
        telefonej = new javax.swing.JLabel();
        cpfj = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cepj = new javax.swing.JLabel();
        estadoj = new javax.swing.JLabel();
        celularj = new javax.swing.JLabel();
        datanascimento = new javax.swing.JFormattedTextField();
        datanascimentoj = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cpfSearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        user = new javax.swing.JTextField();
        userj = new javax.swing.JLabel();
        passwordj = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        nome.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });
        getContentPane().add(nome);
        nome.setBounds(180, 180, 270, 50);

        endereco.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoActionPerformed(evt);
            }
        });
        getContentPane().add(endereco);
        endereco.setBounds(180, 240, 600, 50);

        enderecoj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        enderecoj.setText("Endereço: ");
        getContentPane().add(enderecoj);
        enderecoj.setBounds(50, 260, 90, 21);

        nomej.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        nomej.setText("Nome:");
        getContentPane().add(nomej);
        nomej.setBounds(50, 200, 90, 21);

        bairro.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(bairro);
        bairro.setBounds(180, 300, 270, 50);

        municipio.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        municipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                municipioActionPerformed(evt);
            }
        });
        getContentPane().add(municipio);
        municipio.setBounds(560, 300, 220, 50);

        telefone.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(telefone);
        telefone.setBounds(180, 420, 270, 50);

        cep.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cep);
        cep.setBounds(180, 360, 270, 50);

        estado.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));
        getContentPane().add(estado);
        estado.setBounds(560, 360, 220, 50);

        celular.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celularActionPerformed(evt);
            }
        });
        getContentPane().add(celular);
        celular.setBounds(560, 420, 220, 50);

        cpf.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cpf);
        cpf.setBounds(180, 480, 270, 50);

        municipioj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        municipioj.setText("Municipio:");
        getContentPane().add(municipioj);
        municipioj.setBounds(460, 320, 90, 21);

        bairroj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        bairroj.setText("Bairro:");
        getContentPane().add(bairroj);
        bairroj.setBounds(50, 320, 70, 21);

        telefonej.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        telefonej.setText("Telefone:");
        getContentPane().add(telefonej);
        telefonej.setBounds(50, 440, 80, 21);

        cpfj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cpfj.setText("CPF:");
        getContentPane().add(cpfj);
        cpfj.setBounds(50, 500, 90, 21);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Alterar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(520, 680, 170, 50);

        cepj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cepj.setText("CEP:");
        getContentPane().add(cepj);
        cepj.setBounds(50, 380, 50, 21);

        estadoj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        estadoj.setText("Estado:");
        getContentPane().add(estadoj);
        estadoj.setBounds(470, 380, 70, 18);

        celularj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        celularj.setText("Celular:");
        getContentPane().add(celularj);
        celularj.setBounds(470, 430, 70, 21);

        try {
            datanascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        datanascimento.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(datanascimento);
        datanascimento.setBounds(600, 180, 180, 50);

        datanascimentoj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        datanascimentoj.setText("Data de Nasc.:");
        getContentPane().add(datanascimentoj);
        datanascimentoj.setBounds(460, 200, 120, 18);

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel12.setText("CPF do Paciente:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 60, 140, 21);
        getContentPane().add(cpfSearch);
        cpfSearch.setBounds(200, 50, 300, 50);

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(550, 50, 110, 50);
        getContentPane().add(password);
        password.setBounds(180, 600, 210, 50);

        user.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(user);
        user.setBounds(180, 540, 210, 50);

        userj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        userj.setText("Usuário:");
        getContentPane().add(userj);
        userj.setBounds(50, 550, 80, 21);

        passwordj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        passwordj.setText("Senha:");
        getContentPane().add(passwordj);
        passwordj.setBounds(50, 600, 60, 21);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 760);

        setSize(new java.awt.Dimension(1197, 790));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enderecoActionPerformed

    private void municipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_municipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_municipioActionPerformed

    private void celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_celularActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if(!(nome.getText().isBlank()))
                this.nomeAux = nome.getText();
            if(!(endereco.getText().isBlank()))
                this.enderecoAux = endereco.getText();
            if(!(bairro.getText().isBlank()))
                this.bairroAux = bairro.getText();
            if(!(municipio.getText().isBlank()))
                this.municipioAux = municipio.getText();
            if(!(cep.getText().isBlank()))
                this.cepAux = cep.getText();
            if(!(estado.getSelectedItem().equals("--")))
                this.estadoAux = estado.getSelectedItem().toString();
            if(!(telefone.getText().isBlank()))
                this.telefoneAux = telefone.getText();
            if(!(celular.getText().isBlank()))
                this.celularAux = celular.getText();
            if(!(user.getText().isBlank()))
                this.userAux = user.getText();
            if(!(password.getPassword().length < 1))
                this.senhaAux = new String(password.getPassword());
            
            String str = "AlterarPaciente@"+this.nomeAux+"@"+datanascimento.getText()+"@"+this.enderecoAux+"@"+this.bairroAux+"@"+this.municipioAux+"@"+
                    this.cepAux+"@"+this.estadoAux+"@"+this.telefoneAux+"@"+this.celularAux+"@"+this.userAux+"@"+this.senhaAux;
            conexao.enviar(str);
            String op =conexao.receber();
            switch(op){
                case "ok":
                    JOptionPane.showMessageDialog(null,"Paciente alterado com sucesso!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "userjaexiste":
                    JOptionPane.showMessageDialog(null,"Nome de usuario informado já existe. Tente outro!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                    user.setText("");
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(AlterarPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cpfSearch.getText().isBlank()){
           JOptionPane.showMessageDialog(null,"Digite algo no campo de busca!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String str = "BuscarPaciente@"+cpfSearch.getText();
                conexao.enviar(str);
                String op = conexao.receber();
                switch(op){
                    case "naoencontrado":
                        JOptionPane.showMessageDialog(null,"Paciente não encontrado", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;   
                    default:
                        nome.setVisible(true);
                        nomej.setVisible(true);
                        datanascimento.setVisible(true);
                        datanascimento.setEditable(false);
                        datanascimentoj.setVisible(true);
                        endereco.setVisible(true);
                        enderecoj.setVisible(true);
                        bairro.setVisible(true);
                        bairroj.setVisible(true);
                        municipio.setVisible(true);
                        municipioj.setVisible(true);
                        cep.setVisible(true);
                        cepj.setVisible(true);
                        estado.setVisible(true);
                        estadoj.setVisible(true);
                        telefone.setVisible(true);
                        telefonej.setVisible(true);
                        celular.setVisible(true);
                        celularj.setVisible(true);
                        cpf.setVisible(true);
                        cpf.setEditable(false);
                        cpfj.setVisible(true);
                        user.setVisible(true);
                        userj.setVisible(true);
                        password.setVisible(true);
                        password.setVisible(true);
                        String[] dados = op.split("@");
                        nome.setText(dados[0]);
                        this.nomeAux = dados[0];
                        datanascimento.setText(dados[4]);
                        endereco.setText(dados[5]);
                        this.enderecoAux = dados[5];
                        bairro.setText(dados[6]);
                        this.bairroAux = dados[6];
                        municipio.setText(dados[7]);
                        this.municipioAux = dados[7];
                        cep.setText(dados[8]);
                        this.cepAux = dados[8];
                        estado.setSelectedItem(dados[9]);
                        this.estadoAux = dados[9];
                        telefone.setText(dados[10]);
                        this.telefoneAux = dados[10];
                        celular.setText(dados[11]);
                        this.celularAux = dados[11];
                        cpf.setText(dados[1]);
                        user.setText(dados[2]);
                        this.userAux = dados[2];
                        this.senhaAux = dados[3];
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(AlterarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro;
    private javax.swing.JLabel bairroj;
    private javax.swing.JTextField celular;
    private javax.swing.JLabel celularj;
    private javax.swing.JTextField cep;
    private javax.swing.JLabel cepj;
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField cpfSearch;
    private javax.swing.JLabel cpfj;
    private javax.swing.JFormattedTextField datanascimento;
    private javax.swing.JLabel datanascimentoj;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel enderecoj;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel estadoj;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField municipio;
    private javax.swing.JLabel municipioj;
    private javax.swing.JTextField nome;
    private javax.swing.JLabel nomej;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordj;
    private javax.swing.JTextField telefone;
    private javax.swing.JLabel telefonej;
    private javax.swing.JTextField user;
    private javax.swing.JLabel userj;
    // End of variables declaration//GEN-END:variables
}