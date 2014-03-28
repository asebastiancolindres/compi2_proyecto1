/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente_correo;

/**
 *
 * @author sebastian
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import static java.nio.file.Files.size;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import parser_correo.archivo;
import parser_correo.celdaPG;

class Surface extends JPanel {
    archivo archivo;
    
     public Surface(archivo archivo) {
        
        this.archivo = archivo;  
        
    }
    
    

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        

        Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        
        System.out.println("w: "+w);
        System.out.println("h: "+h);
        

        Iterator<celdaPG> itC = this.archivo.celdas.iterator(); 
          //  int cc =0;
        int fil=0;
        int col=0;
            while (itC.hasNext()) {
             //   cc++;


               
                celdaPG celda = itC.next();
                
                if (celda.color.equalsIgnoreCase("azul"))
                    g2d.setColor(Color.blue);
                if (celda.color.equalsIgnoreCase("rojo"))
                    g2d.setColor(Color.red);
                if (celda.color.equalsIgnoreCase("amarillo"))
                    g2d.setColor(Color.yellow);
                if (celda.color.equalsIgnoreCase("verde"))
                    g2d.setColor(Color.green);
                if (celda.color.equalsIgnoreCase("negro"))
                    g2d.setColor(Color.black);
                
             //    int x = Math.abs(r.nextInt()) % w;
            //int y = Math.abs(r.nextInt()) % h;
                
                fil = Integer.parseInt(celda.fila)*3;
                col = Integer.parseInt(celda.columna)*3;
                 g2d.fillRect(fil, col, 3, 3);
                System.out.println("fila: " + celda.fila + " columna :" + celda.columna + " color: " + celda.color);              
            }
           
           // g2d.fill
       // }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Points extends JFrame {
    
    public int tamX;
    public int tamY;
    public archivo archivo;

    public Points(archivo archivo) {
        
        this.archivo = archivo;  
        
        String tam[] = archivo.tamanio.split("x");
        System.out.println("x: "+tam[0]);
        System.out.println("y: "+tam[1]);
        
        Insets insets = getInsets();

        
        tamX = 7+Integer.parseInt(tam[0].trim())*3;
        tamY = 35+Integer.parseInt(tam[1].trim())*3;
        
         
            

        initUI();
    }

    private void initUI() {
        
        setTitle("Archivo PG");
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new Surface(this.archivo));

        setSize(tamX, tamY);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                Points ps = new Points(null);
                ps.setVisible(true);
            }
        });
    }
}
