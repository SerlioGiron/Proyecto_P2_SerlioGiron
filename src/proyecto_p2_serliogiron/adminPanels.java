/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_p2_serliogiron;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class adminPanels implements Serializable{
    private JPanel panel;
    private File archivo = null;
    
    private static final long SerialVersionUID=777L;

    public adminPanels(String path) {
        archivo = new File(path);
    }
    
    
    public void cargarArchivo() {
        try {            
            // = new ArrayList();
            //persona temp;
            if (archivo.exists()) 
            {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                
                try {
                    
                    panel = (JPanel)objeto.readObject();
                    
                    
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                
                objeto.close();
                entrada.close();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            
            bw.writeObject(panel);
            
            bw.flush();
            
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
    
    

    @Override
    public String toString() {
        return "adminPanels{" + "panel=" + panel + ", archivo=" + archivo + '}';
    }
    
    

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
}
