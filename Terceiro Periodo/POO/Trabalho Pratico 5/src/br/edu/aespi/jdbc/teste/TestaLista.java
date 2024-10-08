/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.aespi.jdbc.teste;

import br.edu.aespi.jdbc.dao.ContatoDAO;
import br.edu.aespi.jdbc.modelo.Contato;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hitaloyo
 */
public class TestaLista extends javax.swing.JFrame {

    /**
     * Creates new form Table
     */
    public TestaLista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTcontatos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jBtnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela De Contatos");
        setResizable(false);

        jTcontatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "EMAIL", "ENDERECO", "TELEFONE"
            }
        ));
        jTcontatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTcontatos);

        jButton1.setText("Deletar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jBtnAtualizar.setText("Pesquisar");
        jBtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAtualizar)
                .addGap(193, 193, 193)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAtualizar)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtualizarActionPerformed
        try {
            
            List<Contato> listaDeContatos = new ContatoDAO().getContatos();
            DefaultTableModel model = (DefaultTableModel)jTcontatos.getModel();
            model.setRowCount(0);
            for(Contato contato : listaDeContatos){
            Long id = contato.getId();
            String nome = contato.getNome();
            String email = contato.getEmail();
            String endereco = contato.getEndereco();
            String telefone = contato.getTelefone();
            model.addRow(new Object[]{id,nome,email,endereco,telefone});
            
            
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestaLista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TestaLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jBtnAtualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int linhaSelecionada = jTcontatos.getSelectedRow();
    

    if (linhaSelecionada == -1) {

        JOptionPane.showMessageDialog(null, "Por favor, selecione um contato para deletar.");
        return;
    }
    
    try {

        Object valorId = jTcontatos.getValueAt(linhaSelecionada, 0);
        
        if (valorId == null) {

            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao obter o ID do contato.");
            return;
        }


        Long id = Long.parseLong(valorId.toString());
        

        int confirm = javax.swing.JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar o contato?", "Confirmação", javax.swing.JOptionPane.YES_NO_OPTION);
        
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {

            ContatoDAO contatoDAO = new ContatoDAO();
            contatoDAO.deletaContato(id);  // Certifique-se de que o método existe no DAO
            

            DefaultTableModel model = (DefaultTableModel) jTcontatos.getModel();
            model.removeRow(linhaSelecionada);
            

            JOptionPane.showMessageDialog(null, "Contato deletado com sucesso.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao deletar contato: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            int linhaSelecionada = jTcontatos.getSelectedRow();

    if (linhaSelecionada == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, selecione um contato para editar.");
        return;
    }

    // Obter os dados da linha selecionada
    Long id = Long.parseLong(jTcontatos.getValueAt(linhaSelecionada, 0).toString());
    String nome = (String) jTcontatos.getValueAt(linhaSelecionada, 1);
    String email = (String) jTcontatos.getValueAt(linhaSelecionada, 2);
    String endereco = (String) jTcontatos.getValueAt(linhaSelecionada, 3);
    String telefone = (String) jTcontatos.getValueAt(linhaSelecionada, 4);

    // Abrir a janela de edição passando os dados do contato
   System.out.print(id);
     new TelaEdit(id, nome,email,endereco,telefone).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAtualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTcontatos;
    // End of variables declaration//GEN-END:variables
}
