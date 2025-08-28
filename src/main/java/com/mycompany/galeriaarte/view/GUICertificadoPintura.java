package com.mycompany.galeriaarte.view;

import com.mycompany.galeriaarte.model.CertificadoAutenticidad;
import com.mycompany.galeriaarte.model.ObraArte;
import com.mycompany.galeriaarte.model.Pintura;
import com.mycompany.galeriaarte.service.IServicioObraArte;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class GUICertificadoPintura extends javax.swing.JFrame {

    private final IServicioObraArte servicioObraArte;

    public GUICertificadoPintura(IServicioObraArte servicioObraArte) {
        this.servicioObraArte = servicioObraArte;
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdPintura = new javax.swing.JTextField();
        txtNumeroCertificado = new javax.swing.JTextField();
        txtFechaEmision = new javax.swing.JTextField();
        txtEntidadEmisora = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID Pintura:");
        jLabel2.setText("Número Certificado:");
        jLabel3.setText("Fecha Emisión (AAAA-MM-DD):");
        jLabel4.setText("Entidad Emisora:");

        btnGenerar.setText("Generar Certificado");
        btnGenerar.addActionListener(evt -> btnGenerarActionPerformed(evt));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(evt -> dispose());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1).addGap(18).addComponent(txtIdPintura, 200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2).addGap(18).addComponent(txtNumeroCertificado, 200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3).addGap(18).addComponent(txtFechaEmision, 200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4).addGap(18).addComponent(txtEntidadEmisora, 200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGenerar).addGap(18).addComponent(btnSalir)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1).addComponent(txtIdPintura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2).addComponent(txtNumeroCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3).addComponent(txtFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4).addComponent(txtEntidadEmisora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar).addComponent(btnSalir))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int id = Integer.parseInt(txtIdPintura.getText().trim());
            String numero = txtNumeroCertificado.getText().trim();
            LocalDate fecha = LocalDate.parse(txtFechaEmision.getText().trim());
            String entidad = txtEntidadEmisora.getText().trim();

            ObraArte obra = servicioObraArte.buscarObraArte(id);
            if (obra instanceof Pintura) {
                Pintura p = (Pintura) obra;
                CertificadoAutenticidad cert = new CertificadoAutenticidad(numero, fecha, entidad);
                p.asignarCertificado(cert);
                JOptionPane.showMessageDialog(this, "Certificado asignado a la pintura:\n" + cert.toString());
            } else {
                JOptionPane.showMessageDialog(this, "El ID no corresponde a una pintura.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtEntidadEmisora;
    private javax.swing.JTextField txtFechaEmision;
    private javax.swing.JTextField txtIdPintura;
    private javax.swing.JTextField txtNumeroCertificado;
}
