/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view.dados;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import model.bean.Audiencia;
import model.bean.Processo;
import model.dao.AudienciaDAO;
import model.dao.ProcessoDAO;
import model.view.listas.ListarAudiencia;

/**
 *
 * @author Pedro
 */
public class DadosAudiencia extends javax.swing.JInternalFrame {
    int codigodoprocesso, codigodaaudiencia;
    /**
     * Creates new form DadosAudiencia
     */
    public DadosAudiencia(Audiencia aud) {
        initComponents();
        Audiencia au = aud;
        Processo pro = new Processo();
        ProcessoDAO pDAO = new ProcessoDAO();
        
        
        AudienciaDAO aDAO = new AudienciaDAO();
        aDAO.buscarAudiencia(au);
        pro.setCod_processo(au.getProcesso().getCod_processo());
        pDAO.buscarProcesso(pro);
        
        salv.setVisible(false);
        estado.setEditable(false);
        processo.setEditable(false);
        rua.setEditable(false);
        bairro.setEditable(false);
        num.setEditable(false);
        cep.setEditable(false);
        cidade.setEditable(false);
        estado.setEditable(false);
        comple.setEditable(false);
        data.setEditable(false);
        hora.setEditable(false);
        estado2.setVisible(false);
        processo1.setVisible(false);
        codigodaaudiencia = au.getCod_audiencia();
        codigodoprocesso = pro.getCod_processo();
        processo.setText(pro.toString());
        rua.setText(au.getRua());
        bairro.setText(au.getBairro());
        num.setText(String.valueOf(au.getNumero()));
        cep.setText(au.getCep());
        cidade.setText(au.getCidade());
        estado.setText(au.escreveEstado(au.getEstado()));
        comple.setText(au.getComplemento());
         /////Data
        if(aud.getData()!=null){
        String datas[] = new String[3];    
        String datinha = String.valueOf(aud.getData());
        datas = datinha.split("-");
        data.setText(datas[2]+"/"+datas[1]+"/"+datas[0]);
        }else{
            data.setText("Vazio");
        }
        
       
        
       
        
       
        ///////////
        hora.setText(String.valueOf(au.getHora()));
       
        for (Processo p: pDAO.listarProcesso()) {
            processo1.addItem(p);
            
        }
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
        jLabel34 = new javax.swing.JLabel();
        processo = new javax.swing.JTextField();
        processo1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rua = new javax.swing.JTextField();
        bairro = new javax.swing.JTextField();
        num = new javax.swing.JTextField();
        estado = new javax.swing.JTextField();
        cidade = new javax.swing.JTextField();
        comple = new javax.swing.JTextField();
        estado2 = new javax.swing.JComboBox<>();
        cep = new javax.swing.JFormattedTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        data = new javax.swing.JFormattedTextField();
        hora = new javax.swing.JFormattedTextField();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        salv = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Dados da Audiência", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Processo da Audiência", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Processo: ");

        processo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        processo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        processo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        processo.setPreferredSize(new java.awt.Dimension(2, 24));
        processo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processoActionPerformed(evt);
            }
        });

        processo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        processo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Processo" }));
        processo1.setPreferredSize(new java.awt.Dimension(500, 24));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(processo1, 0, 544, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(processo, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(processo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(processo1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Informações da Audiência", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Endereço", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Rua:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Bairro:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Número:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("CEP:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Estado:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Complemento:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Cidade:");

        rua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rua.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        rua.setPreferredSize(new java.awt.Dimension(2, 24));

        bairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bairro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        bairro.setPreferredSize(new java.awt.Dimension(2, 24));

        num.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        num.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        num.setPreferredSize(new java.awt.Dimension(2, 24));

        estado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        estado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        estado.setPreferredSize(new java.awt.Dimension(2, 24));

        cidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cidade.setPreferredSize(new java.awt.Dimension(2, 24));

        comple.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comple.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        comple.setPreferredSize(new java.awt.Dimension(2, 24));

        estado2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MP", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        estado2.setPreferredSize(new java.awt.Dimension(51, 24));
        estado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estado2ActionPerformed(evt);
            }
        });

        cep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cep.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cep.setPreferredSize(new java.awt.Dimension(109, 24));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estado2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Data e Hora", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Data:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Hora:");

        data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        data.setPreferredSize(new java.awt.Dimension(109, 24));

        hora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        hora.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        hora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hora.setPreferredSize(new java.awt.Dimension(109, 24));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Editar");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(salv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_processoActionPerformed

    private void estado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estado2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estado2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int l=0;
        if(estado.getText().equalsIgnoreCase("Alagoas")){
            l=1;
        }else if(estado.getText().equalsIgnoreCase("Amapá")){
            l=2;
        }else if(estado.getText().equalsIgnoreCase("Amazonas")){
            l=3;
        }else if(estado.getText().equalsIgnoreCase("Bahia")){
            l=4;
        }else if(estado.getText().equalsIgnoreCase("Ceará")){
            l=5;
        }else if(estado.getText().equalsIgnoreCase("Distrito Federal")){
            l=6;
        }else if(estado.getText().equalsIgnoreCase("Espírito Santo")){
            l=7;
        }else if(estado.getText().equalsIgnoreCase("Goiás")){
            l=8;
        }else if(estado.getText().equalsIgnoreCase("Maranhão")){
            l=9;
        }else if(estado.getText().equalsIgnoreCase("Mato Grosso")){
            l=10;
        }else if(estado.getText().equalsIgnoreCase("Mato Grosso do Sul")){
            l=11;
        }else if(estado.getText().equalsIgnoreCase("Minas Gerais")){
            l=12;
        }else if(estado.getText().equalsIgnoreCase("Pará")){
            l=13;
        }else if(estado.getText().equalsIgnoreCase("Paraíba")){
            l=14;
        }else if(estado.getText().equalsIgnoreCase("Paraná")){
            l=15;
        }else if(estado.getText().equalsIgnoreCase("Pernambuco")){
            l=16;
        }else if(estado.getText().equalsIgnoreCase("Piauí")){
            l=17;
        }else if(estado.getText().equalsIgnoreCase("Rio de Janeiro")){
            l=18;
        }else if(estado.getText().equalsIgnoreCase("Rio Grande do Norte")){
            l=19;
        }else if(estado.getText().equalsIgnoreCase("Rio Grande do Sul")){
            l=20;
        }else if(estado.getText().equalsIgnoreCase("Rondônia")){
            l=21;
        }else if(estado.getText().equalsIgnoreCase("Roraima")){
            l=22;
        }else if(estado.getText().equalsIgnoreCase("Santa Catarina")){
            l=23;
        }else if(estado.getText().equalsIgnoreCase("São Paulo")){
            l=24;
        }else if(estado.getText().equalsIgnoreCase("Sergipe")){
            l=25;
        }else if(estado.getText().equalsIgnoreCase("Tocantins")){
            l=26;
        }
        //////////Mostra processo ja selecionado
        Processo pro = new Processo();
        pro.setCod_processo(codigodoprocesso);
        Processo proce = new Processo();
        boolean v= true;
        int id=1;
        int c=0;
            do{
             
            proce = (Processo) processo1.getItemAt(id);
            
            
          
            if (proce.getCod_processo()==pro.getCod_processo()){
                c=id;
                break;
                
            }
            id++;
        }while(v);
        //////////
        
        
         processo1.setSelectedIndex(c);
         estado2.setSelectedIndex(l);
         salv.setVisible(true);
         processo.setVisible(false);
         processo1.setVisible(true);
         estado2.setVisible(true);
         estado.setVisible(false);
         rua.setEditable(true);
         bairro.setEditable(true);
         num.setEditable(true);
         cep.setEditable(true);
         cidade.setEditable(true);
         comple.setEditable(true);
         data.setEditable(true);
         hora.setEditable(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void salvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvActionPerformed
     Audiencia aud = new Audiencia();
     AudienciaDAO aDAO = new AudienciaDAO();
     Processo pro = new Processo();
     aud.setCod_audiencia(codigodaaudiencia);
     aud.setRua(rua.getText());
     aud.setBairro(bairro.getText());
     aud.setNumero(Integer.parseInt(num.getText()));
     aud.setCep(cep.getText());
     aud.setCidade(cidade.getText());
     aud.setComplemento(comple.getText());
     aud.setEstado(String.valueOf(estado2.getSelectedItem()));
     /////Pega Processo
        pro = (Processo) processo1.getItemAt(processo1.getSelectedIndex());
        
     //////
     aud.setProcesso(pro);
     ///////Data
        
   
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date dat = null;
       
        try {
            dat = new java.sql.Date(format.parse(data.getText()).getTime());
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(ListarAudiencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
        
        
        aud.setData(dat);
        ////hora
        
            
            java.sql.Time horas = null;
            String h = hora.getText()+":00";
            String ho[] = new String[3];
            ho = h.split(":");
            int hor = Integer.parseInt(ho[0]);  
            int min = Integer.parseInt(ho[1]);
            int sec = Integer.parseInt(ho[2]);
            horas = new java.sql.Time(hor, min, sec);

        aud.setHora(horas);
        aDAO.editarAudiencia(aud);
        processo.setVisible(true);
        salv.setVisible(false);
        estado.setEditable(false);
        processo.setEditable(false);
        rua.setEditable(false);
        bairro.setEditable(false);
        num.setEditable(false);
        cep.setEditable(false);
        cidade.setEditable(false);
        estado.setEditable(false);
        comple.setEditable(false);
        data.setEditable(false);
        hora.setEditable(false);
        estado.setVisible(true);
        estado2.setVisible(false);
        processo1.setVisible(false);
        aDAO.buscarAudiencia(aud);
        pro.setCod_processo(aud.getProcesso().getCod_processo());
        ProcessoDAO pDAO = new ProcessoDAO();
        pDAO.buscarProcesso(pro);
        processo.setText(pro.toString());
        rua.setText(aud.getRua());
        bairro.setText(aud.getBairro());
        num.setText(String.valueOf(aud.getNumero()));
        cep.setText(aud.getCep());
        cidade.setText(aud.getCidade());
        estado.setText(aud.escreveEstado(aud.getEstado()));
        comple.setText(aud.getComplemento());
         /////Data
        if(aud.getData()!=null){
        String datas[] = new String[3];    
        String datinha = String.valueOf(aud.getData());
        datas = datinha.split("-");
        data.setText(datas[2]+"/"+datas[1]+"/"+datas[0]);
        }else{
            data.setText("Vazio");
        }
        
       
        
       
        
       
        ///////////
        hora.setText(String.valueOf(aud.getHora()));
    }//GEN-LAST:event_salvActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JTextField comple;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JTextField estado;
    private javax.swing.JComboBox<String> estado2;
    private javax.swing.JFormattedTextField hora;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField num;
    private javax.swing.JTextField processo;
    private javax.swing.JComboBox<Object> processo1;
    private javax.swing.JTextField rua;
    private javax.swing.JButton salv;
    // End of variables declaration//GEN-END:variables
}
