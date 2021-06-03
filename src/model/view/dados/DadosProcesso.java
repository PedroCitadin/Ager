/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view.dados;

import java.awt.Dimension;
import model.bean.Advogado;
import model.bean.Cliente;
import model.bean.Processo;
import model.dao.AdvogadoDAO;
import model.dao.ClienteDAO;
import model.dao.ProcessoDAO;

/**
 *
 * @author Pedro
 */
public class DadosProcesso extends javax.swing.JInternalFrame {
    int codigoderegistro, codigodocliente, codigodoadvogado;
    /**
     * Creates new form DadosProcesso
     */
    public DadosProcesso(Processo pro) {
        initComponents();
        Processo p = pro;
        ProcessoDAO pDAO = new ProcessoDAO();
        pDAO.buscarProcesso(p);
        Advogado adv = new Advogado();
        Cliente cli = new Cliente();
        AdvogadoDAO aDAO = new AdvogadoDAO();
        ClienteDAO cDAO = new ClienteDAO();
        adv.setCod_adv(p.getAdvogado().getCod_adv());
        cli.setCod_cliente(p.getCliente().getCod_cliente());
        cDAO.buscarCliente(cli);
        aDAO.buscarAdvogado(adv);
        if (cli.getSobrenome()==null) {
            cliente.setText(cli.getNome()+" "+cli.getNome_fant());
        }else{
            cliente.setText(cli.getNome()+" "+cli.getSobrenome());
        }
        advogado.setText(adv.getNome()+" "+adv.getSobrenome());
        descri.setText(p.getDescricao());
        obs.setText(p.getObservacoes());
        acao.setText(p.getAcao());
        cod.setText(p.getCodigo());
        codigoderegistro = p.getCod_processo();
        advo.setVisible(false);
        clint.setVisible(false);
        advogado.setEditable(false);
        cliente.setEditable(false);
        acao.setEditable(false);
        descri.setEditable(false);
        cod.setEditable(false);
        obs.setEditable(false);
        salv.setVisible(false);
        codigodocliente = cli.getCod_cliente();
        codigodoadvogado = adv.getCod_adv();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        advogado = new javax.swing.JTextField();
        cliente = new javax.swing.JTextField();
        advo = new javax.swing.JComboBox<>();
        clint = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        acao = new javax.swing.JTextField();
        descri = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        obs = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        salv = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Dados do Processo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Envolvidos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Advogado:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Cliente:");

        advogado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        advogado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        advogado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        advogado.setPreferredSize(new java.awt.Dimension(74, 24));

        cliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cliente.setPreferredSize(new java.awt.Dimension(74, 24));

        advo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        advo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Advogado" }));
        advo.setPreferredSize(new java.awt.Dimension(500, 24));

        clint.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clint.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Cliente" }));
        clint.setPreferredSize(new java.awt.Dimension(56, 24));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(advogado, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(advo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(advo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Informações do Processo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Ação:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Descrição:");

        acao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        acao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        acao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        acao.setPreferredSize(new java.awt.Dimension(2, 24));

        descri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descri.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        descri.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        descri.setPreferredSize(new java.awt.Dimension(2, 24));

        obs.setColumns(20);
        obs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        obs.setRows(5);
        obs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        obs.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(obs);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Observações:");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Código do Processo:");

        cod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cod.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cod.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cod.setPreferredSize(new java.awt.Dimension(2, 24));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(acao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Editar");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        salv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salv.setText("Salvar");
        salv.setBorder(null);
        salv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(salv, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton3, salv});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton3, salv});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        salv.setVisible(true);
        advogado.setVisible(false);
        cliente.setVisible(false);
        advo.setVisible(true);
        clint.setVisible(true);
        acao.setEditable(true);
        descri.setEditable(true);
        cod.setEditable(true);
        obs.setEditable(true);
        AdvogadoDAO aDAO = new AdvogadoDAO(); 
        advo.removeAllItems();
        advo.addItem("Selecione o Advogado");
       
         for (Advogado a:aDAO.listarAdvogado()) {
            
            advo.addItem(a);
        }
        ClienteDAO cDAO = new ClienteDAO();
        clint.removeAllItems();
        clint.addItem("Selecione o Cliente");
        for (Cliente c:cDAO.listarCliente()) {
            clint.addItem(c);
            
        }
       
        
        
        
        
        
        
        
     ///////////////Mostra o cliente já¡ selecionado
        Cliente cli = new Cliente();
        cli.setCod_cliente(codigodocliente);
       
        boolean v= true;
        int id=1;
        int c=0;
        Cliente client = new Cliente();
            do{
             client = (Cliente) clint.getItemAt(id);
            
            
          
            if (client.getCod_cliente()==cli.getCod_cliente()){
                c=id;
                break;
                
            }
            id++;
        }while(v);
       clint.setSelectedIndex(c);
       
       //////////////////////
       //Mostra o advogado jÃ¡ selecionado
       Advogado adv = new Advogado();
        adv.setCod_adv(codigodoadvogado);
        boolean a= true;
        int ip=1;
        int f=0;
        Advogado advog = new Advogado();
            do{
             
            advog = (Advogado) advo.getItemAt(ip);
                
            
          
            if (advog.getCod_adv()==adv.getCod_adv()){
                f=ip;
                break;
                
            }
            ip++;
        }while(a);
        advo.setSelectedIndex(f);
        
        ///////////////////
    }//GEN-LAST:event_jButton4ActionPerformed

    private void salvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvActionPerformed
      ProcessoDAO pDAO = new ProcessoDAO();
      Processo p = new Processo();
      Advogado adv = new Advogado();
      Cliente cli = new Cliente();
        p.setCod_processo(codigoderegistro);
        p.setDescricao(descri.getText());
        p.setObservacoes(obs.getText());
        p.setAcao(acao.getText());
        p.setCodigo(cod.getText());
        ////////Pegar opÃ§Ã£o de cliente
       cli = (Cliente) clint.getItemAt(clint.getSelectedIndex());
       //////////// 
       ///////Pegar opÃ§Ã£o de advogado
       adv = (Advogado) advo.getItemAt(advo.getSelectedIndex());
       ////////////
       
       p.setAdvogado(adv);
       p.setCliente(cli);
        
        
       pDAO.editarProcesso(p);
       pDAO.buscarProcesso(p);
       adv.setCod_adv(p.getAdvogado().getCod_adv());
       cli.setCod_cliente(p.getCliente().getCod_cliente());
       ClienteDAO cDAO = new ClienteDAO();
       AdvogadoDAO aDAO = new AdvogadoDAO();
       cDAO.buscarCliente(cli);
       aDAO.buscarAdvogado(adv);
       if (cli.getSobrenome()==null) {
            cliente.setText(cli.getNome()+" "+cli.getNome_fant());
        }else{
            cliente.setText(cli.getNome()+" "+cli.getSobrenome());
        }
        advogado.setText(adv.getNome()+" "+adv.getSobrenome());
        descri.setText(p.getDescricao());
        obs.setText(p.getObservacoes());
        acao.setText(p.getAcao());
        cod.setText(p.getCodigo());
        codigoderegistro = p.getCod_processo();
        advogado.setVisible(true);
        
        advo.setVisible(false);
        cliente.setVisible(true);
       
        clint.setVisible(false);
        advogado.setEditable(false);
        cliente.setEditable(false);
        acao.setEditable(false);
        descri.setEditable(false);
        cod.setEditable(false);
        obs.setEditable(false);
    }//GEN-LAST:event_salvActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acao;
    private javax.swing.JComboBox<Object> advo;
    private javax.swing.JTextField advogado;
    private javax.swing.JTextField cliente;
    private javax.swing.JComboBox<Object> clint;
    private javax.swing.JTextField cod;
    private javax.swing.JTextField descri;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea obs;
    private javax.swing.JButton salv;
    // End of variables declaration//GEN-END:variables
public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
}
}