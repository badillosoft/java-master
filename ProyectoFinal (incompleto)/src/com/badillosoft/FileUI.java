/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badillosoft;

import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * La clase FileUI deriva de com.badillosoft.File y provee mecanismos
 * de interfaz que le permiten interactuar con una interfaz, sobre todo le permite
 * recibir cualquier JButton, JTextField, JLabel y JProgressBar para interactuar
 * con esos elementos.
 * 
 * La clase define el comportamiento del JButton de tal manera que seleccione
 * el archivo mediante un diálogo generado por JFileChooser.
 * 
 * Luego el path lo ajusta en el JTextField y modifica el JLabel para
 * mostrar el tamaño.
 * 
 * Además sobreescribe el comportamiento de setProgress() para actualizar
 * el JProgressBar acutomáticamente.
 * 
 * @author Alan Badillo Salas [badillo.soft@hotmail.com]
 * @version 1.0
 * @see com.badillosoft.File
 * 
 */
public class FileUI extends File {
    
    private final JProgressBar progressBar;
    
    /**
     * Crea un archivo com.badillosoft.File con comportamiento adicional.
     * 
     * @param key la llave del archivo (informativo)
     * @param button botón de selección de archivo
     * @param textField caja de texto donde se colocará el path del archivo
     * @param label etiqueta que mostrará la llave y tamaño del archivo
     * @param progressBar barra de progreso que se actualizará con el progreso del archivo
     */
    public FileUI(String key, JButton button,
        JTextField textField, JLabel label, JProgressBar progressBar) {
        
        super();
        
        this.progressBar = progressBar;

        // Mostramos una caja de diálogo cuando se pulse el botón
        button.addActionListener((evt) -> {
            // Instanciamos un JFileChooser para abrir el diálogo
            JFileChooser fc= new JFileChooser();
            
            // Lo mostramos a la altura del botón
            int option = fc.showOpenDialog(button);
            
            // Si se cancela nos regresamos (no hay nada que hacer)
            if (option == JFileChooser.CANCEL_OPTION) {
                return;
            }
            
            // Si se selecciona un archivo recuperamos el path y lo
            // colocamos en la caja de texto
            if (option == JFileChooser.APPROVE_OPTION) {
                textField.setText(fc.getSelectedFile().getPath());
            }
            
            // recuperamos el path de la caja de texto (ambigüo)
            String path = textField.getText();

            // Configuramos los datos de un Cuadro de Alerta
            //String title = "Archivo cambiado correctamente";
            //String message = String.format("Archivo cambiado: %s", path);
            //int type = JOptionPane.INFORMATION_MESSAGE;

            try {
                // Si podemos ajustar el archivo (vea com.badillosoft.File)
                // entonces se calculará automáticamente el tamaño del archivo
                this.setPath(path);
                // Mostramos el tamaños del archivo en el label
                label.setText(String.format("Path %s (%d bytes)",
                    key, this.getSize()));
            } catch (IOException ex) {
                //title = "Error al cambiar el archivo";
                //message = String.format("No existe el archivo: %s", path);
                //type = JOptionPane.ERROR_MESSAGE;
                // Regresamos el path anterior (innecesario)
                textField.setText(this.getPath());
            }

            // Mostramos un cuadro de diálogo con los datos configurados
            //JOptionPane.showMessageDialog(form, message, title, type);
        });
    }
    
    @Override
    public void setProgress(int progress) {
        this.progressBar.setValue(progress);
    }
    
}
