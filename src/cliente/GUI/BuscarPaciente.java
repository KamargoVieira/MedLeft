package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BuscarPaciente extends javax.swing.JFrame {

    Conexao conexao;
    public BuscarPaciente(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enderecoj = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cpfSearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        datanascimento = new javax.swing.JLabel();
        endereco = new javax.swing.JLabel();
        bairro = new javax.swing.JLabel();
        cep = new javax.swing.JLabel();
        telefone = new javax.swing.JLabel();
        cpf = new javax.swing.JLabel();
        municipio = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        enderecoj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        enderecoj.setText("Endereço: ");
        getContentPane().add(enderecoj);
        enderecoj.setBounds(40, 280, 90, 21);

        name.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        name.setText("Nome:");
        getContentPane().add(name);
        name.setBounds(40, 220, 90, 21);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Municipio:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(450, 340, 90, 21);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Bairro:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 340, 70, 21);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Telefone:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 460, 80, 21);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("CPF:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 530, 90, 21);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(980, 670, 170, 50);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setText("CEP:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 400, 50, 21);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setText("Estado:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(450, 400, 70, 18);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setText("Celular:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(450, 450, 70, 21);

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setText("Data de Nasc.:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(450, 220, 120, 18);

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel12.setText("CPF:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 60, 80, 21);
        getContentPane().add(cpfSearch);
        cpfSearch.setBounds(170, 50, 300, 50);

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(500, 50, 110, 50);

        jLabel13.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(190, 230, 180, 0);

        jLabel14.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(600, 230, 100, 0);

        jLabel15.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(560, 410, 0, 0);

        jLabel16.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel16);
        jLabel16.setBounds(560, 470, 100, 0);

        jLabel17.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel17);
        jLabel17.setBounds(560, 520, 120, 0);

        jLabel18.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel18);
        jLabel18.setBounds(190, 290, 120, 0);

        jLabel19.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel19);
        jLabel19.setBounds(190, 350, 90, 0);

        jLabel20.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel20);
        jLabel20.setBounds(190, 410, 90, 0);

        jLabel21.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel21);
        jLabel21.setBounds(190, 470, 140, 0);

        jLabel22.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel22);
        jLabel22.setBounds(190, 600, 0, 0);

        jLabel23.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel23);
        jLabel23.setBounds(190, 680, 110, 0);

        jLabel24.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(jLabel24);
        jLabel24.setBounds(190, 530, 130, 0);

        nome.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(nome);
        nome.setBounds(130, 220, 290, 0);

        datanascimento.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(datanascimento);
        datanascimento.setBounds(590, 220, 130, 30);

        endereco.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(endereco);
        endereco.setBounds(150, 280, 270, 0);

        bairro.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(bairro);
        bairro.setBounds(150, 340, 170, 0);

        cep.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cep);
        cep.setBounds(160, 400, 180, 0);

        telefone.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(telefone);
        telefone.setBounds(160, 460, 150, 0);

        cpf.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(cpf);
        cpf.setBounds(150, 530, 210, 0);

        municipio.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(municipio);
        municipio.setBounds(580, 340, 230, 0);
        getContentPane().add(estado);
        estado.setBounds(550, 400, 220, 30);

        celular.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        getContentPane().add(celular);
        celular.setBounds(560, 450, 170, 0);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1190, 760);

        setSize(new java.awt.Dimension(1184, 789));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

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
                        JOptionPane.showMessageDialog(null,"Médico não encontrado", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        String[] dados = op.split("@");
                        nome.setText(dados[0]);
                        cpf.setText(dados[1]);
                        datanascimento.setText(dados[2]);
                        endereco.setText(dados[3]);
                        bairro.setText(dados[4]);
                        municipio.setText(dados[5]);
                        cep.setText(dados[6]);
                        estado.setText(dados[7]);
                        telefone.setText(dados[8]);
                        celular.setText(dados[9]);
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(BuscarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bairro;
    private javax.swing.JLabel celular;
    private javax.swing.JLabel cep;
    private javax.swing.JLabel cpf;
    private javax.swing.JTextField cpfSearch;
    private javax.swing.JLabel datanascimento;
    private javax.swing.JLabel endereco;
    private javax.swing.JLabel enderecoj;
    private javax.swing.JLabel estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel municipio;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel telefone;
    // End of variables declaration//GEN-END:variables
}
