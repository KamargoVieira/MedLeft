package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BuscarProntuario extends javax.swing.JFrame {

    Conexao conexao;
    String tipoUsuario;
    String user;
    public BuscarProntuario(Conexao conexao, String tipoUsuario, String user) {
        initComponents();
        this.conexao = conexao;
        this.tipoUsuario = tipoUsuario;
        this.user = user;
        if(tipoUsuario.equals("paciente")){
            try {
                String str  = "BuscarProntuarioPaciente@"+user;
                conexao.enviar(str);
                String op = conexao.receber();
                String[] dados = op.split("@");
                queixaprincipal.setText(dados[0]);
                historicofamiliar.setText(dados[1]);
                obs.setText(dados[2]);
                altura.setText(dados[3]);
                peso.setText(dados[4]);
                hemoglucoteste.setText(dados[5]);
                temperatura.setText(dados[6]);
                frequenciacaradiaca.setText(dados[7]);
                pressaosistotica.setText(dados[8]);
                pressaodiastolica.setText(dados[9]);
                obs2.setText(dados[10]);                
                queixaprincipal.setEditable(false);
                historicofamiliar.setEditable(false);
                obs.setEditable(false);
                altura.setEditable(false);
                peso.setEditable(false);
                hemoglucoteste.setEditable(false);
                temperatura.setEditable(false);
                frequenciacaradiaca.setEditable(false);
                pressaosistotica.setEditable(false);
                pressaodiastolica.setEditable(false);
                obs2.setEditable(false);
                cpfj.setVisible(false);
                cpfSearch.setVisible(false);
                buscarbt.setVisible(false);
                
            } catch (IOException ex) {
                Logger.getLogger(BuscarProntuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cpfj = new javax.swing.JLabel();
        cpfSearch = new javax.swing.JTextField();
        buscarbt = new javax.swing.JButton();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        queixaprincipal = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        historicofamiliar = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        altura = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        frequenciacaradiaca = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        peso = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        hemoglucoteste = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        temperatura = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        obs2 = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        pressaosistotica = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        pressaodiastolica = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(990, 680, 170, 50);

        cpfj.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        cpfj.setText("CPF:");
        getContentPane().add(cpfj);
        cpfj.setBounds(40, 80, 80, 21);
        getContentPane().add(cpfSearch);
        cpfSearch.setBounds(170, 60, 300, 50);

        buscarbt.setText("Buscar");
        buscarbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarbtActionPerformed(evt);
            }
        });
        getContentPane().add(buscarbt);
        buscarbt.setBounds(520, 60, 110, 50);

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

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel2.setText("Anamnese");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 160, 170, 24);

        jLabel3.setText("_____________________________________________________________");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 170, 440, 18);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Queixa Principal:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 200, 140, 21);

        queixaprincipal.setColumns(20);
        queixaprincipal.setRows(5);
        jScrollPane1.setViewportView(queixaprincipal);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(210, 200, 280, 92);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Histórico Familiar:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 320, 160, 21);

        historicofamiliar.setColumns(20);
        historicofamiliar.setRows(5);
        jScrollPane2.setViewportView(historicofamiliar);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(210, 310, 280, 92);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setText("Observações:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 440, 110, 21);

        obs.setColumns(20);
        obs.setRows(5);
        jScrollPane3.setViewportView(obs);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(210, 420, 280, 92);

        jLabel7.setText("_____________________________________________________________");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 520, 440, 18);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel8.setText("Exame Físico");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 510, 170, 24);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setText("Altura (cm):");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(50, 560, 110, 21);

        altura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alturaActionPerformed(evt);
            }
        });
        getContentPane().add(altura);
        altura.setBounds(160, 550, 60, 40);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setText("Frequência Cardiaca (bpm) :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(50, 610, 230, 21);
        getContentPane().add(frequenciacaradiaca);
        frequenciacaradiaca.setBounds(300, 600, 60, 40);

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setText("Peso (kg):");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(230, 560, 90, 18);
        getContentPane().add(peso);
        peso.setBounds(320, 550, 60, 40);

        jLabel25.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel25.setText("Hemoglucoteste (mg/dl):");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(390, 560, 220, 21);
        getContentPane().add(hemoglucoteste);
        hemoglucoteste.setBounds(610, 550, 60, 40);

        jLabel26.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel26.setText("Temperatura (°C):");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(680, 560, 150, 21);
        getContentPane().add(temperatura);
        temperatura.setBounds(840, 550, 60, 40);

        jLabel27.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel27.setText("Observações:");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(50, 650, 120, 21);

        obs2.setColumns(20);
        obs2.setRows(5);
        jScrollPane4.setViewportView(obs2);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(170, 650, 262, 92);

        jLabel28.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel28.setText("Pressão arterial sistótica (mmHg):");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(380, 610, 290, 21);
        getContentPane().add(pressaosistotica);
        pressaosistotica.setBounds(670, 600, 60, 40);

        jLabel29.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel29.setText("Pressão arterial diastólica (mmHg):");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(740, 610, 290, 21);

        pressaodiastolica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pressaodiastolicaActionPerformed(evt);
            }
        });
        getContentPane().add(pressaodiastolica);
        pressaodiastolica.setBounds(1040, 600, 60, 40);

        jButton3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(810, 680, 170, 50);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 760);

        setBounds(0, 0, 1198, 790);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void alturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alturaActionPerformed

    private void pressaodiastolicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pressaodiastolicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pressaodiastolicaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(queixaprincipal.getText().isBlank() || historicofamiliar.getText().isBlank() || obs.getText().isBlank() ||
            altura.getText().isBlank() || peso.getText().isBlank() || hemoglucoteste.getText().isBlank() || temperatura.getText().isBlank() ||
            frequenciacaradiaca.getText().isBlank() || pressaosistotica.getText().isBlank() || pressaodiastolica.getText().isBlank() || obs2.getText().isBlank()
            ){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos.", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String str = "AlterarProntuario@"+queixaprincipal.getText()+"@"+ historicofamiliar.getText()+"@"+obs.getText()+"@"+
                        altura.getText()+"@"+peso.getText()+"@"+hemoglucoteste.getText()+"@"+temperatura.getText()+"@"+frequenciacaradiaca.getText()+"@"+
                        pressaosistotica.getText()+"@"+pressaodiastolica.getText()+"@"+ obs2.getText()+"@"+cpfSearch.getText();
                conexao.enviar(str);
                String op = conexao.receber();
                switch(op){
                    case "ok":
                        JOptionPane.showMessageDialog(null,"Prontuário atualizado com sucesso!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(BuscarProntuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buscarbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarbtActionPerformed
        if(cpfSearch.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Digite algo no campo de busca!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                String str  = "BuscarProntuario@"+cpfSearch.getText();
                conexao.enviar(str);
                String op = conexao.receber();
                switch(op){
                     case "naoencontrado":
                        JOptionPane.showMessageDialog(null,"Paciente não encontrado", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        String[] dados = op.split("@");
                        queixaprincipal.setText(dados[0]);
                        historicofamiliar.setText(dados[1]);
                        obs.setText(dados[2]);
                        altura.setText(dados[3]);
                        peso.setText(dados[4]);
                        hemoglucoteste.setText(dados[5]);
                        temperatura.setText(dados[6]);
                        frequenciacaradiaca.setText(dados[7]);
                        pressaosistotica.setText(dados[8]);
                        pressaodiastolica.setText(dados[9]);
                        obs2.setText(dados[10]);                         
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(BuscarProntuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_buscarbtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField altura;
    private javax.swing.JButton buscarbt;
    private javax.swing.JTextField cpfSearch;
    private javax.swing.JLabel cpfj;
    private javax.swing.JTextField frequenciacaradiaca;
    private javax.swing.JTextField hemoglucoteste;
    private javax.swing.JTextArea historicofamiliar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea obs;
    private javax.swing.JTextArea obs2;
    private javax.swing.JTextField peso;
    private javax.swing.JTextField pressaodiastolica;
    private javax.swing.JTextField pressaosistotica;
    private javax.swing.JTextArea queixaprincipal;
    private javax.swing.JTextField temperatura;
    // End of variables declaration//GEN-END:variables
}