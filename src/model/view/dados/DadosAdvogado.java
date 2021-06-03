/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view.dados;

import static java.awt.Color.blue;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Advogado;
import model.bean.Email;
import model.bean.Endereco;
import model.bean.Oab;
import model.bean.Sexo;
import model.bean.Telefone;
import model.dao.AdvogadoDAO;
import model.dao.EmailDAO;
import model.dao.EnderecoDAO;
import model.dao.OabDAO;
import model.dao.TelefoneDAO;
import model.view.cadastros.CadastroFisica;
import model.view.cadastros.NovoCodigoOAB;
import model.view.cadastros.NovoEmailAdvogado;
import model.view.cadastros.NovoEnderecoAdvogado;
import model.view.cadastros.NovoTelefoneAdvogado;

/**
 *
 * @author Pedro
 */
public class DadosAdvogado extends javax.swing.JInternalFrame {
    int codigoemail, codigooab, codigotelefone, codigoendereco;
    /**
     * Creates new form DadosAdvogado
     */
    public DadosAdvogado(Advogado adv) {
        initComponents();
        
        deletaEmail.setVisible(false);
        deletaTelefone.setVisible(false);
        tabelaEmail.getParent().setBackground(white);
        tabelaTelefone.getParent().setBackground(white);
        tabelaEnd.getParent().setBackground(white);
        tabelaOAB.getParent().setBackground(white);
        Advogado av = adv;
        nome.setEditable(false);
        sobre.setEditable(false);
        cpf.setEditable(false);
        rg.setEditable(false);
        data.setEditable(false);
        coab.setEditable(false);
        est.setEditable(false);
        sexo.setEditable(false);
        rua.setEditable(false);
        bairro.setEditable(false);
        num.setEditable(false);
        cep.setEditable(false);
        cidade.setEditable(false);
        estado.setEditable(false);
        comple.setEditable(false);
        cadastro.setEditable(false);
        email.setEditable(false);
        ddd.setEditable(false);
        tele.setEditable(false);
        salv.setVisible(false);
        sexi.setVisible(false);
        esta.setVisible(false);
        estado.setVisible(true);
        estado1.setVisible(false);
        deletaEnd.setVisible(false);
        deletaOAB.setVisible(false);
        AdvogadoDAO aDAO = new AdvogadoDAO();
        aDAO.buscarAdvogado(av);
        /////Mostrar os valores/////////
        cadastro.setText(String.valueOf(av.getCod_adv()));
        nome.setText(av.getNome());
        sobre.setText(av.getSobrenome());
        cpf.setText(av.getCpf());
        rg.setText(av.getRg());
        ///////Data//////////
        String datinha;
        String dat[] = (String.valueOf(av.getData_nasc())).split("-");
        datinha = (dat[2]+"/"+dat[1]+"/"+dat[0]);
        data.setText(datinha);
        /////////Sexo
        String sexi=null;
        if(av.getSexo().getId()==1){
            sexi = "Masculino";
        }else{
            if(av.getSexo().getId()==2){
                sexi = "Feminino";
            }else{
               
                }
        }
        sexo.setText(sexi);
       
        //////////
        
       
        est.setText(av.getEst_civ());
        
       
///////////
        ///Lista de endereços
        EnderecoDAO edao = new EnderecoDAO();
        Endereco end = new Endereco();
        end.setCod_end_adv(av);
        DefaultTableModel dtm = (DefaultTableModel) tabelaEnd.getModel();

        dtm.setNumRows(0);
        for (Endereco en : edao.listarEnderecoAdvogado(end)) {
            dtm.addRow(new Object[]{
                en.getCod_end(),
                en.getCidade(),
                en.getBairro(),
                en.getRua()});
        }
        //////////////////
        
        OabDAO oDAO = new OabDAO();
        Oab ob = new Oab();
        ob.setCod_advogado(av);
        DefaultTableModel dtm2 = (DefaultTableModel) tabelaOAB.getModel();
        dtm2.setNumRows(0);
        
        for (Oab oab1 : oDAO.listarCodigoOab(ob)) {
           
            dtm2.addRow(new Object[]{ 
                oab1.getCod_cod_oab(), 
                oab1.getCodigo()});
        }
        //////////
        EmailDAO emDAO = new EmailDAO();
        Email emi = new Email();
        emi.setAdvogado(adv);
        DefaultTableModel dtm3 = (DefaultTableModel) tabelaEmail.getModel();
        dtm3.setNumRows(0);
        for (Email em : emDAO.listarEmailAdvogado(emi)) {
            dtm3.addRow(new Object[]{
                em.getCod_email(),
                em.getDescricao()

            });
        }
        TelefoneDAO tDAO = new TelefoneDAO();
        Telefone tel = new Telefone();
        tel.setAdvogado(adv);
        DefaultTableModel dtm4 = (DefaultTableModel) tabelaTelefone.getModel();
        dtm4.setNumRows(0);
        for (Telefone te : tDAO.listarTelefoneAdvogado(tel)) {
            dtm4.addRow(new Object[]{
                te.getCod_telefone(),
                te.getDdd(),
                te.getNumero()
            });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        sobre = new javax.swing.JTextField();
        data = new javax.swing.JFormattedTextField();
        cpf = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sexo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        est = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        coab = new javax.swing.JTextField();
        sexi = new javax.swing.JComboBox<>();
        esta = new javax.swing.JComboBox<>();
        rg = new javax.swing.JFormattedTextField();
        cadastro = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
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
        estado = new javax.swing.JTextField();
        cidade = new javax.swing.JTextField();
        comple = new javax.swing.JTextField();
        estado1 = new javax.swing.JComboBox<>();
        cep = new javax.swing.JFormattedTextField();
        num = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        tele = new javax.swing.JFormattedTextField();
        ddd = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        scroll1 = new javax.swing.JScrollPane();
        tabelaEnd = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        scroll2 = new javax.swing.JScrollPane();
        tabelaOAB = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        salv = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        deletaEnd = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        deletaOAB = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        scroll3 = new javax.swing.JScrollPane();
        tabelaTelefone = new javax.swing.JTable();
        scroll4 = new javax.swing.JScrollPane();
        tabelaEmail = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        deletaEmail = new javax.swing.JButton();
        deletaTelefone = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1261, 575));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Dados do Advogado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Informações Pessoais", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nome:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Sobrenome:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("CPF:");

        nome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nome.setPreferredSize(new java.awt.Dimension(74, 24));

        sobre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sobre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sobre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        sobre.setPreferredSize(new java.awt.Dimension(74, 24));

        data.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        data.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        data.setMinimumSize(new java.awt.Dimension(6, 24));
        data.setPreferredSize(new java.awt.Dimension(64, 24));

        cpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpf.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cpf.setMinimumSize(new java.awt.Dimension(6, 24));
        cpf.setPreferredSize(new java.awt.Dimension(64, 24));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Data de Nascimento:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("RG:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Sexo:");

        sexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sexo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sexo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        sexo.setPreferredSize(new java.awt.Dimension(74, 24));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Estado Civil:");

        est.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        est.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        est.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        est.setPreferredSize(new java.awt.Dimension(74, 24));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Código OAB:");

        coab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        coab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        coab.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        coab.setPreferredSize(new java.awt.Dimension(74, 24));

        sexi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sexi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar", "Masculino", "Feminino" }));
        sexi.setToolTipText("");
        sexi.setBorder(null);

        esta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        esta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro(a)", "Casado(a)", "Separado(a)", "Desquitado(a)", "Divorciado(a)", "Viúvo(a)", "Outro" }));
        esta.setBorder(null);
        esta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estaActionPerformed(evt);
            }
        });

        rg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            rg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        rg.setText("");
        rg.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        rg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rg.setPreferredSize(new java.awt.Dimension(73, 24));

        cadastro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cadastro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cadastro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cadastro.setPreferredSize(new java.awt.Dimension(74, 24));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Código de Cadastro:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sobre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sexi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(esta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(est, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coab, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sexi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(est, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(esta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(coab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Endereço", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

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

        estado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        estado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        estado.setPreferredSize(new java.awt.Dimension(4, 24));

        cidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cidade.setPreferredSize(new java.awt.Dimension(2, 24));

        comple.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comple.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        comple.setPreferredSize(new java.awt.Dimension(2, 24));

        estado1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        estado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MP", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        estado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estado1ActionPerformed(evt);
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
        cep.setMinimumSize(new java.awt.Dimension(6, 24));
        cep.setPreferredSize(new java.awt.Dimension(64, 24));
        cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cepActionPerformed(evt);
            }
        });

        num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        num.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        num.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        num.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        num.setMinimumSize(new java.awt.Dimension(6, 24));
        num.setPreferredSize(new java.awt.Dimension(64, 24));

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
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estado1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Contato", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Email:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Telefone:");

        email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        email.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        email.setPreferredSize(new java.awt.Dimension(2, 24));

        tele.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            tele.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tele.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tele.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tele.setMinimumSize(new java.awt.Dimension(6, 24));
        tele.setPreferredSize(new java.awt.Dimension(64, 24));
        tele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teleActionPerformed(evt);
            }
        });

        ddd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            ddd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ddd.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ddd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ddd.setMinimumSize(new java.awt.Dimension(6, 24));
        ddd.setPreferredSize(new java.awt.Dimension(64, 24));
        ddd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ddd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tele, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ddd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Endereços do Advogado:");
        jLabel2.setToolTipText("");

        scroll1.setBackground(new java.awt.Color(255, 255, 255));

        tabelaEnd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaEnd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cidade", "Bairro", "Rua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEnd.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEndMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelaEndMouseEntered(evt);
            }
        });
        scroll1.setViewportView(tabelaEnd);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagens/atualizar.jpg"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        scroll2.setBackground(new java.awt.Color(255, 255, 255));

        tabelaOAB.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaOAB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Código OAB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaOAB.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaOAB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaOABMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelaOABMouseEntered(evt);
            }
        });
        scroll2.setViewportView(tabelaOAB);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Códigos OAB do Advogado:");
        jLabel20.setToolTipText("");

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

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Adicionar Endereço");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        deletaEnd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletaEnd.setText("Excluír Endereço");
        deletaEnd.setBorder(null);
        deletaEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletaEndActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setText("Adicionar Código OAB");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        deletaOAB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletaOAB.setText("Excluír Código OAB");
        deletaOAB.setBorder(null);
        deletaOAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletaOABActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setText("E-Mails do Advogado:");
        jLabel40.setToolTipText("");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setText("Telefones do Advogado:");
        jLabel39.setToolTipText("");

        scroll3.setBackground(new java.awt.Color(255, 255, 255));

        tabelaTelefone.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaTelefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "DDD", "Número"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTelefone.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTelefoneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelaTelefoneMouseEntered(evt);
            }
        });
        scroll3.setViewportView(tabelaTelefone);

        scroll4.setBackground(new java.awt.Color(255, 255, 255));

        tabelaEmail.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelaEmail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEmail.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEmailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tabelaEmailMouseEntered(evt);
            }
        });
        scroll4.setViewportView(tabelaEmail);

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setText("Adicionar E-Mail");
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("Adicionar Telefone");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        deletaEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletaEmail.setText("Excluír E-Mail");
        deletaEmail.setBorder(null);
        deletaEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletaEmailActionPerformed(evt);
            }
        });

        deletaTelefone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deletaTelefone.setText("Excluír Telefone");
        deletaTelefone.setBorder(null);
        deletaTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletaTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deletaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(deletaEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scroll4, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 131, Short.MAX_VALUE))
                            .addComponent(scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(deletaTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 17, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(deletaOAB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(salv)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(scroll2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton4, salv});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(102, 102, 102))
                            .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deletaOAB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(scroll4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(salv)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletaTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletaEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton4, salv});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {deletaEnd, deletaOAB});

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletaEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaEndActionPerformed
        Endereco end = new Endereco();
        EnderecoDAO eDAO = new EnderecoDAO();
        int linhaE = tabelaEnd.getSelectedRow();
        int codEnd = (int) tabelaEnd.getValueAt(linhaE, 0);
        end.setCod_end(codEnd);
        eDAO.deletarEndereco(end);

        Advogado adv = new Advogado();
        adv.setCod_adv(Integer.parseInt(cadastro.getText()));
        end.setCod_end_adv(adv);
        DefaultTableModel dtm = (DefaultTableModel) tabelaEnd.getModel();

        dtm.setNumRows(0);
        for (Endereco en : eDAO.listarEnderecoAdvogado(end)) {
            dtm.addRow(new Object[]{
                en.getCod_end(),
                en.getCidade(),
                en.getBairro(),
                en.getRua()});
        }
    }//GEN-LAST:event_deletaEndActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Advogado adv = new Advogado();
        adv.setCod_adv(Integer.parseInt(cadastro.getText()));
        NovoEnderecoAdvogado addEnd = new NovoEnderecoAdvogado(adv);
        addEnd.setVisible(true);
        addEnd.toFront();
        addEnd.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void salvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvActionPerformed
       if(nome.getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(rootPane, " Campo Nome em branco, digite o Nome");
      
    }else if(sobre.getText().equalsIgnoreCase("")){
        JOptionPane.showMessageDialog(rootPane, " Campo Sobrenome em branco, digite o Sobrenome");
      
    }else if(cpf.getText().equalsIgnoreCase("   .   .   -  ")){
        JOptionPane.showMessageDialog(rootPane, " Campo CPF em branco, digite o CPF");
      
    }else if(data.getText().equalsIgnoreCase("  /  /    ")){
        JOptionPane.showMessageDialog(rootPane, " Campo Data de Nascimento em branco, digite a Data de Nascimento");
      
    }else if(rg.getText().equalsIgnoreCase(" .   .   ")){
        JOptionPane.showMessageDialog(rootPane, " Campo RG em branco, digite o RG");
      
    }else if(sexi.getSelectedIndex()==0){
        JOptionPane.showMessageDialog(rootPane, " Campo sexo não está selecionado, selecione o sexo");
      
     
      
    }else{ 
        
        Advogado ad = new Advogado();
        AdvogadoDAO aDAO = new AdvogadoDAO();
        ad.setCod_adv(Integer.parseInt(cadastro.getText()));
        ad.setNome(nome.getText());
        ad.setSobrenome(sobre.getText());
        ad.setCpf(cpf.getText());
        /////Data/////////
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date dat = null;

        try {
            dat = new java.sql.Date(format.parse(data.getText()).getTime());
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(CadastroFisica.class.getName()).log(Level.SEVERE, null, ex);
        }

        ad.setData_nasc(dat);
        ///////////////////
        ad.setRg(rg.getText());
        ////////Sexo
        Sexo sex = new Sexo();
        sex.setId(sexi.getSelectedIndex());
        ad.setSexo(sex);
        /////////////
        ad.setEst_civ(String.valueOf(esta.getSelectedItem()));
        ////////////Endereço////////
        if (tabelaEnd.getSelectedRow()!=(-1)) {
        Endereco end = new Endereco();
        EnderecoDAO eDAO = new EnderecoDAO();
        end.setRua(rua.getText());
        end.setBairro(bairro.getText());
        end.setNumero(Integer.parseInt(num.getText()));
        end.setCep(cep.getText());
        end.setCidade(cidade.getText());
        end.setEstado(String.valueOf(estado1.getSelectedItem()));
        end.setComplemento(comple.getText());
        
        end.setCod_end(codigoendereco);
        eDAO.editarEndereco(end);
        eDAO.buscarEnderecoAdvogado(end);
        estado.setText(end.escreveEstado(end.getEstado()));
       
           }else{
            rua.setText("");
            bairro.setText("");
            num.setText("");
            cep.setText("");
            cidade.setText("");
            estado.setText("");
            comple.setText("");
        }
        
        ///////////
        /////////OAB/////////
           if (tabelaOAB.getSelectedRow()!=(-1)) {
               
           
        Oab oab = new Oab();
        OabDAO oDAO = new OabDAO();
        oab.setCod_advogado(ad);
        oab.setCodigo(coab.getText());
        oab.setCod_cod_oab(codigooab);
        oDAO.editarCodigoOab(oab);
           }else{
               coab.setText("");
           }
///////////////////////////////////////
        /////////////Email
           if (tabelaEmail.getSelectedRow()!=(-1)) {
               
           
        Email emi = new Email();
        EmailDAO emDAO = new EmailDAO();
        emi.setCod_email(codigoemail);
        emi.setDescricao(email.getText());
        emDAO.editarEmail(emi);
           }else{
               email.setText("");
           }
           
//////
///////////////Telefone///////////
        if(tabelaTelefone.getSelectedRow()!=(-1)){
        Telefone tel = new Telefone();
        TelefoneDAO tDAO = new TelefoneDAO();
        tel.setCod_telefone(codigotelefone);
        tel.setDdd(ddd.getText());
        tel.setNumero(tele.getText());
        tDAO.editarTelefone(tel);
        }else{
            ddd.setText("");
            tele.setText("");
        }
////////////////////
    
        
    
        aDAO.editarAdvogado(ad);
        
        
        
        nome.setEditable(false);
        sobre.setEditable(false);
        cpf.setEditable(false);
        rg.setEditable(false);
        data.setEditable(false);
        coab.setEditable(false);
        est.setEditable(false);
        sexo.setEditable(false);
        rua.setEditable(false);
        bairro.setEditable(false);
        num.setEditable(false);
        cep.setEditable(false);
        cidade.setEditable(false);
        estado.setEditable(false);
        comple.setEditable(false);
        cadastro.setEditable(false);
        email.setEditable(false);
        ddd.setEditable(false);
        tele.setEditable(false);
        salv.setVisible(false);
        sexi.setVisible(false);
        esta.setVisible(false);
        estado.setVisible(true);
        estado1.setVisible(false);
        sexo.setVisible(true);
        est.setVisible(true);
        aDAO.buscarAdvogado(ad);
        est.setText(ad.getEst_civ());
        if (ad.getSexo().getId()==1) {
            sexo.setText("Masculino");
        }else if(ad.getSexo().getId()==2){
            sexo.setText("Feminino");
        }else if(ad.getSexo().getId()==3){
            sexo.setText("Outro");
        }
       
        
    }
    }//GEN-LAST:event_salvActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        
        int s = 0;
        if (sexo.getText().equalsIgnoreCase("masculino")) {
            s = 1;
        }else if(sexo.getText().equalsIgnoreCase("feminino")){
            s = 2;
        }else if(sexo.getText().equalsIgnoreCase("outro")){
            s=3;
        }
        int c = -1;
        if(est.getText().equalsIgnoreCase("Solteiro(a)")){
            c = 0;
        }else if(est.getText().equalsIgnoreCase("Casado(a)")){
            c = 1;
        }else if(est.getText().equalsIgnoreCase("Separado(a)")){
            c = 2;
        }else if(est.getText().equalsIgnoreCase("Desquitado(a)")){
            c = 3;
        }else if(est.getText().equalsIgnoreCase("Divorciado(a)")){
            c = 4;
        }else if(est.getText().equalsIgnoreCase("Viúvo(a)")){
            c = 5;
        }else if(est.getText().equalsIgnoreCase("Outro")){
            c = 6;

        }
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

        nome.setEditable(true);
        sobre.setEditable(true);
        cpf.setEditable(true);
        rg.setEditable(true);
        data.setEditable(true);
        coab.setEditable(true);
        est.setEditable(true);
        sexo.setEditable(true);
        rua.setEditable(true);
        bairro.setEditable(true);
        num.setEditable(true);
        cep.setEditable(true);
        cidade.setEditable(true);
        estado.setEditable(true);
        comple.setEditable(true);
        email.setEditable(true);
        ddd.setEditable(true);
        tele.setEditable(true);
        sexi.setSelectedIndex(s);
        estado1.setSelectedIndex(l);
        esta.setSelectedIndex(c);
        salv.setVisible(true);
        sexo.setVisible(false);
        sexi.setVisible(true);
        est.setVisible(false);
        esta.setVisible(true);
        estado.setVisible(false);
        estado1.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tabelaOABMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaOABMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaOABMouseEntered

    private void tabelaOABMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaOABMouseClicked
        int linha = tabelaOAB.getSelectedRow();
        int cod = (int) tabelaOAB.getValueAt(linha, 0);
        codigooab = cod;
        OabDAO oDAO = new OabDAO();
        Oab oab = new Oab();
        oab.setCod_cod_oab(cod);
        oDAO.buscarCodigoOab(oab);
        coab.setText(oab.getCodigo());
        deletaOAB.setVisible(true);
    }//GEN-LAST:event_tabelaOABMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EnderecoDAO edao = new EnderecoDAO();
        Endereco end = new Endereco();
        Advogado adv = new Advogado();
        adv.setCod_adv(Integer.parseInt(cadastro.getText()));
        end.setCod_end_adv(adv);
        DefaultTableModel dtm = (DefaultTableModel) tabelaEnd.getModel();

        dtm.setNumRows(0);
        for (Endereco en : edao.listarEnderecoAdvogado(end)) {
            dtm.addRow(new Object[]{
                en.getCod_end(),
                en.getCidade(),
                en.getBairro(),
                en.getRua()});
        }
        
        OabDAO oDAO = new OabDAO();
        Oab ob = new Oab();
        ob.setCod_advogado(adv);
        DefaultTableModel dtm2 = (DefaultTableModel) tabelaOAB.getModel();
        dtm2.setNumRows(0);

        for (Oab oab : oDAO.listarCodigoOab(ob)) {
            dtm2.addRow(new Object[]{  
                oab.getCod_cod_oab(), 
                oab.getCodigo()});
        }
        EmailDAO emDAO = new EmailDAO();
        Email emi = new Email();
        emi.setAdvogado(adv);
        DefaultTableModel dtm3 = (DefaultTableModel) tabelaEmail.getModel();
        dtm3.setNumRows(0);
        for (Email em : emDAO.listarEmailAdvogado(emi)) {
            dtm3.addRow(new Object[]{
                em.getCod_email(),
                em.getDescricao()

            });
        }
        TelefoneDAO tDAO = new TelefoneDAO();
        Telefone tel = new Telefone();
        tel.setAdvogado(adv);
        DefaultTableModel dtm4 = (DefaultTableModel) tabelaTelefone.getModel();
        dtm4.setNumRows(0);
        for (Telefone te : tDAO.listarTelefoneAdvogado(tel)) {
            dtm4.addRow(new Object[]{
                te.getCod_telefone(),
                te.getDdd(),
                te.getNumero()
            });
        }
        
        deletaEnd.setVisible(false);
        deletaEmail.setVisible(false);
        deletaTelefone.setVisible(false);
        deletaOAB.setVisible(false);
        System.out.println(tabelaEnd.getSelectedRow());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaEndMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEndMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaEndMouseEntered

    private void tabelaEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEndMouseClicked
        


        int linha = tabelaEnd.getSelectedRow();
        int codEnd = (int) tabelaEnd.getValueAt(linha, 0);
        codigoendereco = codEnd;
        EnderecoDAO edao = new EnderecoDAO();
        Endereco end = new Endereco();
        end.setCod_end(codEnd);
        edao.buscarEnderecoAdvogado(end);
        rua.setText(end.getRua());
        bairro.setText(end.getBairro());
        num.setText(String.valueOf(end.getNumero()));
        cep.setText(end.getCep());
        cidade.setText(end.getCidade());

        estado.setText(end.escreveEstado(end.getEstado()));
        comple.setText(end.getComplemento());
        deletaEnd.setVisible(true);
    }//GEN-LAST:event_tabelaEndMouseClicked

    private void estado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estado1ActionPerformed

    private void estaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estaActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         Advogado adv = new Advogado();
        adv.setCod_adv(Integer.parseInt(cadastro.getText()));
        NovoCodigoOAB nOAB = new NovoCodigoOAB(adv);
        nOAB.setVisible(true);
        nOAB.toFront();
        nOAB.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void deletaOABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaOABActionPerformed
        Oab ob = new Oab();
        OabDAO oDAO = new OabDAO();
        int linhaO = tabelaOAB.getSelectedRow();
        int codOAB = (int) tabelaOAB.getValueAt(linhaO, 0);
        ob.setCod_cod_oab(codOAB);
        oDAO.deletarCodigoOab(ob);
        Advogado adv = new Advogado();
        adv.setCod_adv(Integer.parseInt(cadastro.getText()));
        ob.setCod_advogado(adv);
        
        ob.setCod_advogado(adv);
        DefaultTableModel dtm2 = (DefaultTableModel) tabelaOAB.getModel();
        dtm2.setNumRows(0);

        for (Oab oab : oDAO.listarCodigoOab(ob)) {
            dtm2.addRow(new Object[]{  
                oab.getCod_cod_oab(), 
                oab.getCodigo()});
        }
    }//GEN-LAST:event_deletaOABActionPerformed

    private void tabelaTelefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTelefoneMouseClicked
       


        int linha = tabelaTelefone.getSelectedRow();
        int codTele = (int) tabelaTelefone.getValueAt(linha, 0);
        codigotelefone = codTele;
        TelefoneDAO tDAO = new TelefoneDAO();
        Telefone tel = new Telefone();
        tel.setCod_telefone(codTele);
        tDAO.buscarTelefoneAdvogado(tel);
        ddd.setText(tel.getDdd());
        tele.setText(tel.getNumero());
        deletaTelefone.setVisible(true);
    }//GEN-LAST:event_tabelaTelefoneMouseClicked

    private void tabelaTelefoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTelefoneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaTelefoneMouseEntered

    private void tabelaEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmailMouseClicked
       


        int linha = tabelaEmail.getSelectedRow();
        int codEmail = (int) tabelaEmail.getValueAt(linha, 0);
        codigoemail = codEmail;
        EmailDAO edao = new EmailDAO();
        Email emi = new Email();
        emi.setCod_email(codEmail);
        edao.buscarEmailAdvogado(emi);
        email.setText(emi.getDescricao());
        deletaEmail.setVisible(true);
    }//GEN-LAST:event_tabelaEmailMouseClicked

    private void tabelaEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmailMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaEmailMouseEntered

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Advogado adv = new Advogado();
        adv.setCod_adv(Integer.parseInt(cadastro.getText()));
        NovoEmailAdvogado addEmi = new NovoEmailAdvogado(adv);
        addEmi.setVisible(true);
        addEmi.toFront();
        addEmi.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         Advogado adv = new Advogado();
        adv.setCod_adv(Integer.parseInt(cadastro.getText()));
        NovoTelefoneAdvogado addTele = new NovoTelefoneAdvogado(adv);
        addTele.setVisible(true);
        addTele.toFront();
        addTele.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void deletaEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaEmailActionPerformed
        int linha = tabelaEmail.getSelectedRow();
        int codEmail = (int) tabelaEmail.getValueAt(linha, 0);
        EmailDAO emDAO = new EmailDAO();
        Email emi = new Email();
        Advogado adv = new Advogado();
        adv.setCod_adv(Integer.parseInt(cadastro.getText()));
        emi.setAdvogado(adv);
        emi.setCod_email(codEmail);
        emDAO.deletarEmail(emi);
        DefaultTableModel dtm3 = (DefaultTableModel) tabelaEmail.getModel();
        dtm3.setNumRows(0);
        for (Email em : emDAO.listarEmailAdvogado(emi)) {
            dtm3.addRow(new Object[]{
                em.getCod_email(),
                em.getDescricao()

            });
        }
    }//GEN-LAST:event_deletaEmailActionPerformed

    private void deletaTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaTelefoneActionPerformed
        int linha = tabelaTelefone.getSelectedRow();
        int codTele = (int) tabelaTelefone.getValueAt(linha, 0);
        TelefoneDAO tDAO = new TelefoneDAO();
        Telefone tel = new Telefone();
        Advogado adv = new Advogado();
        tel.setCod_telefone(codTele);
        adv.setCod_adv(Integer.parseInt(cadastro.getText()));
        tel.setAdvogado(adv);
        tDAO.deletarTelefone(tel);
        DefaultTableModel dtm2 = (DefaultTableModel) tabelaTelefone.getModel();
        dtm2.setNumRows(0);
        for (Telefone te : tDAO.listarTelefoneAdvogado(tel)) {
            dtm2.addRow(new Object[]{
                te.getCod_telefone(),
                te.getDdd(),
                te.getNumero()
            });
        }
    }//GEN-LAST:event_deletaTelefoneActionPerformed

    private void cepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cepActionPerformed

    private void teleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teleActionPerformed

    private void dddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro;
    private javax.swing.JTextField cadastro;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JTextField coab;
    private javax.swing.JTextField comple;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JFormattedTextField ddd;
    private javax.swing.JButton deletaEmail;
    private javax.swing.JButton deletaEnd;
    private javax.swing.JButton deletaOAB;
    private javax.swing.JButton deletaTelefone;
    private javax.swing.JTextField email;
    private javax.swing.JTextField est;
    private javax.swing.JComboBox<String> esta;
    private javax.swing.JTextField estado;
    private javax.swing.JComboBox<String> estado1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField num;
    private javax.swing.JFormattedTextField rg;
    private javax.swing.JTextField rua;
    private javax.swing.JButton salv;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JScrollPane scroll3;
    private javax.swing.JScrollPane scroll4;
    private javax.swing.JComboBox<String> sexi;
    private javax.swing.JTextField sexo;
    private javax.swing.JTextField sobre;
    private javax.swing.JTable tabelaEmail;
    private javax.swing.JTable tabelaEnd;
    private javax.swing.JTable tabelaOAB;
    private javax.swing.JTable tabelaTelefone;
    private javax.swing.JFormattedTextField tele;
    // End of variables declaration//GEN-END:variables
}
