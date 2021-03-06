/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badillosoft.client;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.UUID;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 * La clase FileClientUI crea una interfaz para recibir los 4 archivos del
 * servidor, posee una caja de texto para seleccionar la carpeta donde se guardarán
 * los archivos recibidos.
 * 
 * La interfaz guarda en una lista todas las descargas exitosas y mantiene
 * informado al usuario con el label inferior.
 * 
 * La interfaz se bloquea y desbloquea automáticamente al comenzar una transmisión.
 * 
 * @author Alan Badillo Salas [badillo.soft@hotmail.com]
 * @version 1.0
 * @see com.badillosoft.File
 */
public class FileClientUI extends javax.swing.JFrame implements Runnable {

    private String selectedKey;
    
    /**
     * Creates new form FileClientUI
     */
    public FileClientUI() {
        initComponents();
        
        // Iniciamos la carpeta de descargas en el "Escritorio"
        this.jTextField1.setText(System.getProperty("user.home") + "/Desktop");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BadilloSoft - File Client");

        jLabel1.setText("Path de salida");

        jTextField1.setEnabled(false);

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("A");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("B");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("C");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("D");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setText("Listo");

        jList1.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addGap(0, 259, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Al pulsar el botón seleccionamos la carpeta donde se descargarán los
     * archivos transmitidos (vea com.badillosoft.FileUI)
     * @param evt 
     * @see com.badillosoft.FileUI
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fc = new JFileChooser();
        
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int option = fc.showDialog(this.jButton1, "Seleccionar carpeta");
        
        if (option == JFileChooser.APPROVE_OPTION) {
            this.jTextField1.setText(fc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Define el método run para que al ejecutarse como hilo este comience el
     * proceso de descargar el archivo según la llave seleccionada.
     */
    @Override
    public void run() {
        try {
            this.download(this.selectedKey);
        } catch (IOException ex) {
            this.jLabel2.setText("Hubo un error en el servidor, intente de nuevo");
            this.jProgressBar1.setValue(0);
            this.setLock(false);
        }
    }
    
    /**
     * Descarga un archivo del servidor mediante la llave dada.
     * El archivo es guardado en la carpeta definida en la caja de texto
     * JTextField1 y guardado con un nombre aleatorio que comienza por la llave.
     * @param key
     * @throws IOException 
     */
    private void download(String key) throws IOException {
        // Bloqueamos la interfaz
        this.setLock(true);
        
        // Nos conectamos al servidor
        Socket socket = null;
        
        System.out.println("@ Conectando al servidor...");
        try {
            socket = new Socket("localhost", 3000);
            this.jLabel2.setText("Conectado");
        } catch (IOException ex) {
            System.out.println("@ Error al conectarse con el servidor");
            this.jLabel2.setText("No se pudo establecer conexión al servidor");
        }
        
        // Si falla desbloqueamos la interfaz
        if (socket == null) {
            this.setLock(false);
            return;
        }
        
        // Generamos un nombre de archivo aleatorio con el path ajustado
        String filename = this.getRandomFilename(key, this.jTextField1.getText());
        
        System.out.format("@ Recuperando el archivo %s%n", key);
        
        this.jLabel2.setText("Esperando que se desocupe el servidor...");
        
        // Protocolo 1. Enviamos la llave del archivo a recuperar
        
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        // Enviamos la llave del archivo requerido (Protocolo 1)
        out.writeUTF(key);
        
        // Protocolo 2. Leemos el tamaño del archivo
        DataInputStream in = new DataInputStream(socket.getInputStream());
        
        // Obtenemos el tamaño del archivo (Protocolo 2)
        int size = in.readInt();
        
        System.out.format("@ Recuperando archivo de %d bytes...%n", size);
        
        BufferedOutputStream fs = new BufferedOutputStream(
            new FileOutputStream(filename)
        );
        
        int b;
        int c = 0;
        int ip = -1;
        
        String message;
        
        for (int i = 0; i < size; i++) {
            // Calculamos el porcentaje de datos enviados
            int p = (int)(100 * c / (size - 1));
            
            // Actualizamos la barra de progreso
            this.jProgressBar1.setValue(p);
            
            // Si el porcentaje es distinto al anterior
            if (p != ip) {
                message = String.format("Descargando el archivo %s: %d%% (%d / %d)",
                    key, p, c + 1, size);
                this.jLabel2.setText(message);
                System.out.println(message);
                ip = p;
            }
            
            c++;
            
            // Recibimos los bytes del archivo (Protocolo 3)
            b = in.readByte();
            // Guardamos los bytes leídos en el archivo
            fs.write(b);
            //System.out.format("%x ", b);
        }
        
        System.out.format("@ Guardando el archivo %s...%n", filename);
        
        // Agregamos el nombre del archivo a la lista
        ((DefaultListModel)jList1.getModel()).addElement(filename);
        
        // Reiniciamos el progreso
        this.jProgressBar1.setValue(0);
        
        // Cerramos los streams y el socket
        in.close();
        out.close();
        fs.close();
        socket.close();
        
        this.jLabel2.setText("Listo");
        
        // Desbloqueamos la interfaz
        // TODO: Desbloquea la interfaz
    }
    
    /**
     * Generamos un nombre de archivo aleatorio a partir de una llave
     * @param key llave del archivo (informativa)
     * @param path ruta física de la carpeta donde se guardará el archivo
     * @return el nombre aleatorio del archivo
     */
    private String getRandomFilename(String key, String path) {
        return String.format("%s/%s - %s", path, key, UUID.randomUUID());
    }
    
    // Bloquea o desbloquea la interfaz
    public void setLock(boolean value) {
        this.jButton1.setEnabled(!value);
        this.jButton2.setEnabled(!value);
        this.jButton3.setEnabled(!value);
        // TODO: Completa para el botón 4 y 5
    }
    
    /**
     * Descarga el archivo en un hilo
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.selectedKey = "A";
        // Ejecuta el método run de esta clase en un hilo
        (new Thread(this)).start();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.selectedKey = "B";
        (new Thread(this)).start();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.selectedKey = "C";
        (new Thread(this)).start();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.selectedKey = "D";
        // TODO: Completa como los demás
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileClientUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
