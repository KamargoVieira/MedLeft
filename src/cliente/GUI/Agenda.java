
package cliente.GUI;

import cliente.Conexao;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Agenda extends javax.swing.JFrame {

    Conexao conexao;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Agenda(Conexao conexao) throws IOException {
        initComponents();
        this.conexao = conexao;        
        atualizaTabela();
        
    }
    
    public void atualizaTabela(){
        try {
            String str = "Agenda@"+sdf.format(new Date());
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
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        idconsulta = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agenda do Dia");
        getContentPane().setLayout(null);

        tabela.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        tabela.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CPF(Paciente)", "Telefone", "Horário", "Data", "Atendido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setOpaque(false);
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 50, 770, 280);

        jButton1.setText("Voltar");
        getContentPane().add(jButton1);
        jButton1.setBounds(1020, 650, 100, 50);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("ID da Consulta:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 360, 230, 21);
        getContentPane().add(idconsulta);
        idconsulta.setBounds(50, 400, 210, 50);

        jButton2.setText("Confirmar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(90, 470, 110, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/GUI/imagens/fundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 760);

        setSize(new java.awt.Dimension(1192, 790));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if(idconsulta.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos!", "Info" ,JOptionPane.INFORMATION_MESSAGE);
        }else{
            try {
                conexao.enviar("consultaAtendida@"+idconsulta.getText());
                String op = conexao.receber();
                switch(op){
                    case "naoencontrado":
                         JOptionPane.showMessageDialog(null,"Paciente não encontrado", "Info" ,JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        atualizaTabela();
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idconsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}