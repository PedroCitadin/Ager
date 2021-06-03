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
import javax.swing.table.DefaultTableModel;
import model.bean.Cliente;
import model.bean.Email;
import model.bean.Endereco;
import model.bean.Oab;
import model.bean.Sexo;
import model.bean.Telefone;
import model.dao.ClienteDAO;
import model.dao.EmailDAO;
import model.dao.EnderecoDAO;
import model.dao.OabDAO;
import model.dao.TelefoneDAO;
import model.view.cadastros.CadastroFisica;
import model.view.cadastros.NovoCodigoOAB;
import model.view.cadastros.NovoEmailAdvogado;
import model.view.cadastros.NovoEmailCliente;
import model.view.cadastros.NovoEnderecoCliente;
import model.view.cadastros.NovoTelefoneCliente;

/**
 *
 * @author Pedro
 */
public class DadosPessoaFisica extends javax.swing.JInternalFrame {

    /**
     * Creates new form DadosCliente
     */
    public DadosPessoaFisica(Cliente cli) {
        initComponents();
       
        Dimension tamnhoT = Toolkit.getDefaultToolkit().getScreenSize();
        if (tamnhoT.height > 800) {
            this.setSize(1357, 758);
        }else{
            this.setSize(1357, 630);
        }
        tabelaEnd.getParent().setBackground(white);
        tabelaTelefone.getParent().setBackground(white);
        tabelaEmail.getParent().setBackground(white);
        Cliente cl = cli;
        nome.setEditable(false);
        sobre.setEditable(false);
        cpf.setEditable(false);
        rg.setEditable(false);
        data.setEditable(false);
        prof.setEditable(false);
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
        deletaTelefone.setVisible(false);
        deletaEmail.setVisible(false);
        ClienteDAO cDAO = new ClienteDAO();
        cDAO.buscarFisica(cl);
        /////Mostrar os valores/////////
        cadastro.setText(String.valueOf(cl.getCod_cliente()));
        nome.setText(cl.getNome());
        sobre.setText(cl.getSobrenome());
        cpf.setText(cl.getCpf());
        rg.setText(cl.getRg());
        est.setText(cl.getEst_civ());
        prof.setText(cl.getProfissao());
        ///////Data//////////
        String datinha;
        String dat[] = (String.valueOf(cl.getData_nasc())).split("-");
        datinha = (dat[2]+"/"+dat[1]+"/"+dat[0]);
        data.setText(datinha);
        /////////Sexo
        String sexi=null;
         if(cl.getSexo().getId()==1){
           sexi = "Masculino";
        }else{
        if(cl.getSexo().getId()==2){
             sexi = "Feminino";
        }
        }
        sexo.setText(sexi);
       
        //////////
        
        /*
        est.setText(av.getEst_civ());
        email.setText(av.getEmail());
        ddd.setText(av.getDdd());
        tele.setText(av.getNum_telefone());
        */
///////////
        ///Lista de endereços
        EnderecoDAO edao = new EnderecoDAO();
        Endereco end = new Endereco();
        end.setCod_end_cli(cl);
        DefaultTableModel dtm = (DefaultTableModel) tabelaEnd.getModel();

        dtm.setNumRows(0);
        for (Endereco en : edao.listarEnderecoCliente(end)) {
            dtm.addRow(new Object[]{
                en.getCod_end(),
                en.getCidade(),
                en.getBairro(),
                en.getRua()});
        }
        //////////////////
        /////Lista telefones
        TelefoneDAO tDAO = new TelefoneDAO();
        Telefone tel = new Telefone();
        tel.setCliente(cli);
        DefaultTableModel dtm2 = (DefaultTableModel) tabelaTelefone.getModel();
        dtm2.setNumRows(0);
        for (Telefone te : tDAO.listarTelefoneCliente(tel)) {
            dtm2.addRow(new Object[]{
                te.getCod_telefone(),
                te.getDdd(),
                te.getNumero()
                });
        }
        ////////////////
        //////////Listar email
        EmailDAO emDAO = new EmailDAO();
        Email emi = new Email();
        emi.setCliente(cli);
        DefaultTableModel dtm3 = (DefaultTableModel) tabelaEmail.getModel();
        dtm3.setNumRows(0);
        for (Email em : emDAO.listarEmailCliente(emi)) {
            dtm3.addRow(new Object[]{
                    em.getCod_email(),
                em.getDescricao()
                
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

        painel1 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        sobre = new javax.swing.JTextField();
        data = new javax.swing.JFormattedTextField();
        cpf = new javax.swing.JFormattedTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        sexo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        est = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        prof = new javax.swing.JTextField();
        sexi = new javax.swing.JComboBox<>();
        esta = new javax.swing.JComboBox<>();
        rg = new javax.swing.JFormattedTextField();
        cadastro = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        rua = new javax.swing.JTextField();
        bairro = new javax.swing.JTextField();
        estado = new javax.swing.JTextField();
        cidade = new javax.swing.JTextField();
        comple = new javax.swing.JTextField();
        estado1 = new javax.swing.JComboBox<>();
        cep = new javax.swing.JFormattedTextField();
        num = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        tele = new javax.swing.JTextField();
        ddd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        scroll1 = new javax.swing.JScrollPane();
        tabelaEnd = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        salv = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        deletaEnd = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        scroll2 = new javax.swing.JScrollPane();
        tabelaTelefone = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        deletaTelefone = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        scroll3 = new javax.swing.JScrollPane();
        tabelaEmail = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        deletaEmail = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1357, 500));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Dados do Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Informações Pessoais", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Nome:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Sobrenome:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("CPF:");

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

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Data de Nascimento:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("RG:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Sexo:");

        sexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sexo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sexo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        sexo.setPreferredSize(new java.awt.Dimension(74, 24));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Estado Civil:");

        est.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        est.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        est.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        est.setPreferredSize(new java.awt.Dimension(74, 24));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Profisssão:");

        prof.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        prof.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        prof.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        prof.setPreferredSize(new java.awt.Dimension(74, 24));

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

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Código de Cadastro:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sobre, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sexi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(esta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(est, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sobre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sexi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(est, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(esta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Endereço", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Rua:");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Bairro:");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Número:");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("CEP:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Estado:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Complemento:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Cidade:");

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

        num.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        num.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        num.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        num.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        num.setMinimumSize(new java.awt.Dimension(6, 24));
        num.setPreferredSize(new java.awt.Dimension(64, 24));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estado1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Contato", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Email:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Telefone:");

        email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        email.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        email.setPreferredSize(new java.awt.Dimension(2, 24));

        tele.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tele.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tele.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tele.setPreferredSize(new java.awt.Dimension(2, 24));

        ddd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ddd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ddd.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ddd.setPreferredSize(new java.awt.Dimension(2, 24));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ddd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(tele, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ddd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Endereços do Cliente:");
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

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setText("Telefones do Cliente:");
        jLabel39.setToolTipText("");

        scroll2.setBackground(new java.awt.Color(255, 255, 255));

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
        scroll2.setViewportView(tabelaTelefone);

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("Adicionar Telefone");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setText("E-Mails do Cliente:");
        jLabel40.setToolTipText("");

        scroll3.setBackground(new java.awt.Color(255, 255, 255));

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
        scroll3.setViewportView(tabelaEmail);

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setText("Adicionar E-Mail");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
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

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/imagens/atualizar.jpg"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deletaEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deletaEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(scroll2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel39)
                                    .addGap(0, 72, Short.MAX_VALUE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(deletaTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salv))))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton4, salv});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(scroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(scroll3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deletaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletaEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deletaTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton4, salv});

        painel1.setViewportView(jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deletaEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaEmailActionPerformed
        int linha = tabelaEmail.getSelectedRow();
        int codEmail = (int) tabelaEmail.getValueAt(linha, 0);
        EmailDAO emDAO = new EmailDAO();
        Email emi = new Email();
        Cliente cli = new Cliente();
        cli.setCod_cliente(Integer.parseInt(cadastro.getText()));
        emi.setCliente(cli);
        emi.setCod_email(codEmail);
        emDAO.deletarEmail(emi);
        DefaultTableModel dtm3 = (DefaultTableModel) tabelaEmail.getModel();
        dtm3.setNumRows(0);
        for (Email em : emDAO.listarEmailCliente(emi)) {
            dtm3.addRow(new Object[]{
                    em.getCod_email(),
                em.getDescricao()
                
                });
        }
    }//GEN-LAST:event_deletaEmailActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            Cliente cli = new Cliente();
            cli.setCod_cliente(Integer.parseInt(cadastro.getText()));
        NovoEmailCliente addEmi = new NovoEmailCliente(cli);
        addEmi.setVisible(true);
        addEmi.toFront();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tabelaEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmailMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaEmailMouseEntered

    private void tabelaEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmailMouseClicked
        int linha = tabelaEmail.getSelectedRow();
        int codEmail = (int) tabelaEmail.getValueAt(linha, 0);
        EmailDAO edao = new EmailDAO();
        Email emi = new Email();
        emi.setCod_email(codEmail);
        edao.buscarEmailCliente(emi);
        email.setText(emi.getDescricao());
        deletaEmail.setVisible(true);
    }//GEN-LAST:event_tabelaEmailMouseClicked

    private void deletaTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaTelefoneActionPerformed
        int linha = tabelaTelefone.getSelectedRow();
        int codTele = (int) tabelaTelefone.getValueAt(linha, 0);
        TelefoneDAO tDAO = new TelefoneDAO();
        Telefone tel = new Telefone();
        Cliente cli = new Cliente();
        tel.setCod_telefone(codTele);
        cli.setCod_cliente(Integer.parseInt(cadastro.getText()));
        tel.setCliente(cli);
        tDAO.deletarTelefone(tel);
        DefaultTableModel dtm2 = (DefaultTableModel) tabelaTelefone.getModel();
        dtm2.setNumRows(0);
        for (Telefone te : tDAO.listarTelefoneCliente(tel)) {
            dtm2.addRow(new Object[]{
                te.getCod_telefone(),
                te.getDdd(),
                te.getNumero()
                });
        }
    }//GEN-LAST:event_deletaTelefoneActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         Cliente cli = new Cliente();
            cli.setCod_cliente(Integer.parseInt(cadastro.getText()));
        NovoTelefoneCliente addTele = new NovoTelefoneCliente(cli);
        addTele.setVisible(true);
        addTele.toFront();
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tabelaTelefoneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTelefoneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaTelefoneMouseEntered

    private void tabelaTelefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTelefoneMouseClicked
        int linha = tabelaTelefone.getSelectedRow();
        int codTele = (int) tabelaTelefone.getValueAt(linha, 0);
        TelefoneDAO tDAO = new TelefoneDAO();
        Telefone tel = new Telefone();
        tel.setCod_telefone(codTele);
        tDAO.buscarTelefoneCliente(tel);
        ddd.setText(tel.getDdd());
        tele.setText(tel.getNumero());
        deletaTelefone.setVisible(true);
    }//GEN-LAST:event_tabelaTelefoneMouseClicked

    private void deletaEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletaEndActionPerformed
        Endereco end = new Endereco();
        EnderecoDAO eDAO = new EnderecoDAO();
        int linhaE = tabelaEnd.getSelectedRow();
        int codEnd = (int) tabelaEnd.getValueAt(linhaE, 0);
        end.setCod_end(codEnd);
        eDAO.deletarEndereco(end);

        Cliente cli = new Cliente();
        cli.setCod_cliente(Integer.parseInt(cadastro.getText()));
        end.setCod_end_cli(cli);
        DefaultTableModel dtm = (DefaultTableModel) tabelaEnd.getModel();

        dtm.setNumRows(0);
        for (Endereco en : eDAO.listarEnderecoCliente(end)) {
            dtm.addRow(new Object[]{
                en.getCod_end(),
                en.getCidade(),
                en.getBairro(),
                en.getRua()});
        }
    }//GEN-LAST:event_deletaEndActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Cliente cli = new Cliente();
        cli.setCod_cliente(Integer.parseInt(cadastro.getText()));
        NovoEnderecoCliente addEnd = new NovoEnderecoCliente(cli);
        addEnd.setVisible(true);
        addEnd.toFront();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void salvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvActionPerformed
        Cliente cl = new Cliente();
        ClienteDAO cDAO = new ClienteDAO();
        cl.setCod_cliente(Integer.parseInt(cadastro.getText()));
        cl.setNome(nome.getText());
        cl.setSobrenome(sobre.getText());
        cl.setCpf(cpf.getText());
        /////Data/////////
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date dat = null;

        try {
            dat = new java.sql.Date(format.parse(data.getText()).getTime());
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(CadastroFisica.class.getName()).log(Level.SEVERE, null, ex);
        }

        cl.setData_nasc(dat);
        ///////////////////
        cl.setRg(rg.getText());
        ////////Sexo
        Sexo sex = new Sexo();
        sex.setId(sexi.getSelectedIndex());
        cl.setSexo(sex);
        /////////////
        cl.setEst_civ(String.valueOf(esta.getSelectedItem()));

        /////////////////////////////Endereço////////
        Endereco end = new Endereco();
        EnderecoDAO eDAO = new EnderecoDAO();
        end.setRua(rua.getText());
        end.setBairro(bairro.getText());
        end.setNumero(Integer.parseInt(num.getText()));
        end.setCep(cep.getText());
        end.setCidade(cidade.getText());
        end.setEstado(String.valueOf(estado1.getSelectedItem()));
        end.setComplemento(comple.getText());
        int linhaE = tabelaEnd.getSelectedRow();
        int codEnd = (int) tabelaEnd.getValueAt(linhaE, 0);
        end.setCod_end(codEnd);
        ///////////
        cDAO.editarFisica(cl);
        eDAO.editarEndereco(end);
        ////////////Email/////////
        Email emi = new Email();
        EmailDAO emDAO = new EmailDAO();
        emi.setDescricao(email.getText());
        int linha = tabelaEmail.getSelectedRow();
        int codEmail = (int) tabelaEmail.getValueAt(linha, 0);
        emi.setCod_email(codEmail);
        emDAO.editarEmail(emi);
        ///////////Telefone//////////
        Telefone tel = new Telefone();
        TelefoneDAO tDAO = new TelefoneDAO();
        tel.setDdd(ddd.getText());
        tel.setNumero(tele.getText());
        int linhaq = tabelaTelefone.getSelectedRow();
        int codTele = (int) tabelaTelefone.getValueAt(linhaq, 0);
        tel.setCod_telefone(codTele);
        tDAO.editarTelefone(tel);
        
        nome.setEditable(false);
        sobre.setEditable(false);
        cpf.setEditable(false);
        rg.setEditable(false);
        data.setEditable(false);
        prof.setEditable(false);
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
    }//GEN-LAST:event_salvActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Dimension tamnhoT = Toolkit.getDefaultToolkit().getScreenSize();
        if (tamnhoT.height > 800) {
            this.setSize(1357, 758);
        }else{
            this.setSize(1357, 630);
        }
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
        prof.setEditable(true);
        est.setEditable(true);
        sexo.setEditable(true);
        rua.setEditable(true);
        bairro.setEditable(true);
        num.setEditable(true);
        cep.setEditable(true);
        cidade.setEditable(true);
        estado.setEditable(true);
        comple.setEditable(true);
        cadastro.setEditable(true);
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

    private void tabelaEndMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEndMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaEndMouseEntered

    private void tabelaEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEndMouseClicked
        int linha = tabelaEnd.getSelectedRow();
        int codEnd = (int) tabelaEnd.getValueAt(linha, 0);
        EnderecoDAO edao = new EnderecoDAO();
        Endereco end = new Endereco();
        end.setCod_end(codEnd);
        edao.buscarEnderecoCliente(end);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        EnderecoDAO eDAO = new EnderecoDAO();
       
       
        Endereco end = new Endereco();
        Cliente cli = new Cliente();
        cli.setCod_cliente(Integer.parseInt(cadastro.getText()));
        end.setCod_end_cli(cli);
        DefaultTableModel dtm = (DefaultTableModel) tabelaEnd.getModel();

        dtm.setNumRows(0);
        for (Endereco en : eDAO.listarEnderecoCliente(end)) {
            dtm.addRow(new Object[]{
                en.getCod_end(),
                en.getCidade(),
                en.getBairro(),
                en.getRua()});
        }
        
        EmailDAO emDAO = new EmailDAO();
        Email emi = new Email();
        
        cli.setCod_cliente(Integer.parseInt(cadastro.getText()));
        emi.setCliente(cli);
        
        DefaultTableModel dtm3 = (DefaultTableModel) tabelaEmail.getModel();
        dtm3.setNumRows(0);
        for (Email em : emDAO.listarEmailCliente(emi)) {
            dtm3.addRow(new Object[]{
                    em.getCod_email(),
                em.getDescricao()
                
                });
        }
        
        TelefoneDAO tDAO = new TelefoneDAO();
        Telefone tel = new Telefone();
        
        
        cli.setCod_cliente(Integer.parseInt(cadastro.getText()));
        tel.setCliente(cli);
        
        DefaultTableModel dtm2 = (DefaultTableModel) tabelaTelefone.getModel();
        dtm2.setNumRows(0);
        for (Telefone te : tDAO.listarTelefoneCliente(tel)) {
            dtm2.addRow(new Object[]{
                te.getCod_telefone(),
                te.getDdd(),
                te.getNumero()
                });
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairro;
    private javax.swing.JTextField cadastro;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JTextField comple;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JTextField ddd;
    private javax.swing.JButton deletaEmail;
    private javax.swing.JButton deletaEnd;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField num;
    private javax.swing.JScrollPane painel1;
    private javax.swing.JTextField prof;
    private javax.swing.JFormattedTextField rg;
    private javax.swing.JTextField rua;
    private javax.swing.JButton salv;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JScrollPane scroll3;
    private javax.swing.JComboBox<String> sexi;
    private javax.swing.JTextField sexo;
    private javax.swing.JTextField sobre;
    private javax.swing.JTable tabelaEmail;
    private javax.swing.JTable tabelaEnd;
    private javax.swing.JTable tabelaTelefone;
    private javax.swing.JTextField tele;
    // End of variables declaration//GEN-END:variables
}
