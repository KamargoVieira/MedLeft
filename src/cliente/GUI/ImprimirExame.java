package cliente.GUI;

import cliente.Conexao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ImprimirExame extends javax.swing.JFrame {

    Conexao conexao;
    public ImprimirExame(Conexao conexao) {
        initComponents();
        this.conexao = conexao;
    }
    
    public void atualizarTabela(){
        try {
            tabela.setVisible(true);
            String str = "BuscaExamesImprimir@"+cpfSearch.getText();
            conexao.enviar(str);
            String[] rows = conexao.receber().split("%");
            Integer countRow = 0;
            for(String registro : rows){
                String[] colunas = registro.split("@");
                Integer countCol = 0;
                for(String dado : colunas){
                    tabela.setValueAt(dado, countRow, countCol);
                    countCol++;
                }
                countRow++;
            }
        } catch (IOException ex) {
            Logger.getLogger(BuscarConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        idexame = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cpfSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Imprimir Exame");
        getContentPane().setLayout(null);

        tabela.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID (Exame)", "Tipo", "CPF (Paciente)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 150, 640, 220);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("ID do Exame:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 440, 120, 18);
        getContentPane().add(idexame);
        idexame.setBounds(280, 420, 280, 50);

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/printer.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(350, 490, 120, 50);
        getContentPane().add(cpfSearch);
        cpfSearch.setBounds(150, 60, 260, 50);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("CPF:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 70, 49, 18);

        jButton2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jButton2.setText("Buscar Paciente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(440, 60, 170, 50);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 600);

        setSize(new java.awt.Dimension(720, 630));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cpfSearch.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            atualizarTabela();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(idexame.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Preencha o campo de busca", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                conexao.enviar("imprimirExame@"+idexame.getText());
                String op = conexao.receber();
                switch(op){
                    case "naoencontrado":
                        JOptionPane.showMessageDialog(null,"Exame nao encontrado", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case "ok":
                        JOptionPane.showMessageDialog(null,"Aguarde...O exame será impresso", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        String endereco = new File(".").getCanonicalPath();
                        File arquivo = new File(endereco+"/src/cliente/Exames/"+cpfSearch.getText()+".txt");
                        FileWriter fw = new FileWriter(arquivo);
                        BufferedWriter bw = new BufferedWriter(fw); 
                        bw.write("Exame aqui");
                        bw.close();
                        fw.close();
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpfSearch;
    private javax.swing.JTextField idexame;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}