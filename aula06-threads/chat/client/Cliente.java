package chat.client;

import java.awt.event.KeyEvent;
import java.io.ObjectOutputStream;
import java.net.Socket;

import chat.util.Message;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.pro.br>
 */

public class Cliente extends javax.swing.JFrame {
    private Socket socket;
    private ObjectOutputStream out;

    public Cliente() {
        initComponents();
    }

    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        txtPorta = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHistorico = new javax.swing.JTextArea();
        txtEntrada = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jLabel1.setText("IP");

        jLabel2.setText("Porta");

        jLabel3.setText("Usuário");

        txtIP.setText("127.0.0.1");
        txtPorta.setText("9876");

        btnConectar.setText("Conectar");
        btnConectar.setName("btnConectar"); // NOI18N
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(
                jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jInternalFrame1Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                false)
                                        .addGroup(jInternalFrame1Layout
                                                .createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtUsuario))
                                        .addGroup(jInternalFrame1Layout
                                                .createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(25, 25, 25)
                                                .addComponent(txtPorta,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        93,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jInternalFrame1Layout
                                                .createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(43, 43, 43)
                                                .addComponent(txtIP,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        111,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                jInternalFrame1Layout.createSequentialGroup()
                                        .addContainerGap(154, Short.MAX_VALUE)
                                        .addComponent(btnConectar)
                                        .addGap(156, 156, 156)));
        jInternalFrame1Layout.setVerticalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame1Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(txtIP,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtPorta,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jInternalFrame1Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtUsuario,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnConectar)
                                .addContainerGap(67, Short.MAX_VALUE)));

        tabPanel.addTab("Servidor", jInternalFrame1);

        jInternalFrame2.setVisible(true);

        txtHistorico.setColumns(20);
        txtHistorico.setRows(5);
        txtHistorico.setEnabled(false);
        jScrollPane1.setViewportView(txtHistorico);

        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntradaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(
                jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
                jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jInternalFrame2Layout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                376,
                                                Short.MAX_VALUE)
                                        .addComponent(txtEntrada))
                                .addContainerGap()));
        jInternalFrame2Layout.setVerticalGroup(
                jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        192,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEntrada,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(7, Short.MAX_VALUE)));

        tabPanel.addTab("Chat", jInternalFrame2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabPanel));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tabPanel));

        pack();
        tabPanel.setEnabled(false);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEntradaKeyPressed(java.awt.event.KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Message msg = new Message(txtUsuario.getText(), txtEntrada.getText());
            try {
                out.writeObject(msg);
                txtEntrada.setText("");
            } catch (Exception e) {
                System.out.println("Erro msg: " + e.getMessage());
            }

        }

    }

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            socket = new Socket(txtIP.getText(), Integer.parseInt(txtPorta.getText()));
            out = new ObjectOutputStream(socket.getOutputStream());
            Listenner listenner = new Listenner(socket, txtHistorico);
            listenner.start();
            tabPanel.setSelectedIndex(1);
        } catch (Exception e) {
            System.out.println("Erro conexão: " + e.getMessage());
        }

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnConectar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextArea txtHistorico;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JTextField txtUsuario;
}
