package Pokemon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.sql.Statement;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jesuspeña
 */
public class VentanaPokedex extends javax.swing.JFrame {
     
    private BufferedImage buffer;
    private Image imagenPokemons;
    private int contador = 1;
    //ancho y alto de la pantalla
    private int ancho = 266;
    private int alto = 309;
    int x;
    int y;
    
    
    //conectamos a la base de datos
    
    private Statement estado;
    private ResultSet resultadoConsulta;
    private Connection conexion;
    
    ///////////////////////////////////
    
    //hashmap para almacenar el resultado de la consulta
    HashMap <String,Pokemon> listaPokemons = new HashMap();
    
    
    
    
    
    
    
   
    
    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion/31;
        int columna = posicion%31;
        //apunto al buffer
        Graphics2D g2= (Graphics2D) buffer.getGraphics();
        //borro la pantalla
        g2.setColor(Color.black);
        g2.fillRect(0, 0, ancho, alto);
        g2.drawImage(imagenPokemons,
                0,
                0,
                ancho,
                alto,
                96*columna,
                96*fila,
                96*columna+96,
                96*fila+96,
                null
                );
        repaint();
        escribePokemon();
        escribeEspecie();
        escribeColor();
        escribeHabitat();
        escribeGenderRate();
        escribeEdad();
        escribeAltura();
        
        
    }
    private void escribePokemon(){
        
        Pokemon p = listaPokemons.get(String.valueOf(contador+1));
        if (p !=null){
        jLabel1.setText(p.nombre);
        }
        else{
            jLabel1.setText("No hay datos");
        }
        
        
    }
    
    private void escribeEspecie(){

        
        
            
        Pokemon p = listaPokemons.get(String.valueOf(contador+1));
        if (p !=null){
        jLabel2.setText(p.species);
        }
        else{
            jLabel2.setText("No hay datos");
        }
        
        
        
    }
    
    private void escribeColor(){

        
        
            
        Pokemon p = listaPokemons.get(String.valueOf(contador+1));
        if (p !=null){
        jLabel5.setText(p.color);
        }
        else{
            jLabel5.setText("No hay datos");
        }
        
        
        
    }
    
    private void escribeHabitat(){

        
        
            
        Pokemon p = listaPokemons.get(String.valueOf(contador+1));
        if (p !=null){
        jLabel7.setText(p.habitat);
        }
        else{
            jLabel7.setText("No hay datos");
        }
        
        
        
    }
    
    private void escribeGenderRate(){

        
        
            
        Pokemon p = listaPokemons.get(String.valueOf(contador+1));
        if (p !=null){
        jLabel4.setText(p.gender_rate);
        }
        else{
            jLabel4.setText("No hay datos");
        }
        
        
        
    }
    
    private void escribeEdad(){

        
        
            
        Pokemon p = listaPokemons.get(String.valueOf(contador+1));
        if (p !=null){
        jLabel3.setText(p.edad);
        }
        else{
            jLabel3.setText("No hay datos");
        }
        
        
        
    }
    
    private void escribeAltura(){

        
        
            
        Pokemon p = listaPokemons.get(String.valueOf(contador+1));
        if (p !=null){
        jLabel11.setText(p.edad);
        }
        else{
            jLabel11.setText("No hay datos");
        }
        
        
        
    }
            
            
    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D)jPanel1.getGraphics();
        g2.drawImage(buffer, 0,0,alto,ancho,null);
    }
    
    public VentanaPokedex() {
        initComponents();
    
        try {
            imagenPokemons = ImageIO.read((getClass().getResource("black-white.png")));
        } catch (IOException ex) {
            Logger.getLogger(VentanaPokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        buffer = (BufferedImage) jPanel1.createImage(ancho, alto);
       Graphics2D G2 = buffer.createGraphics();
       
       

        //conectarme a la base de datos////////////////
        try {
          Class.forName("com.mysql.jdbc.Driver");
          conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test","root","");
          estado = conexion.createStatement();
          resultadoConsulta = estado.executeQuery("Select * from pokemon");
          //cargo el resultado de la query en el hashmap
          while(resultadoConsulta.next()){
              Pokemon p = new Pokemon();
              p.nombre = resultadoConsulta.getString(2);
              p.generation_id = resultadoConsulta.getInt(5);
              p.evolution_chain_id = resultadoConsulta.getInt(6);
              p.species = resultadoConsulta.getString(12);
              p.habitat = resultadoConsulta.getString(15);
              p.color = resultadoConsulta.getString(13);
              p.gender_rate = resultadoConsulta.getString(16);
              p.edad = resultadoConsulta.getString(18);
              p.altura = resultadoConsulta.getString(10);
              
               
              
              
              listaPokemons.put(resultadoConsulta.getString(1),p);
          }
        } 
        catch (Exception e) {
        }
        dibujaElPokemonQueEstaEnLaPosicion(0);
//////////////////////////////////////////////
    }
    
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jColorChooser2 = new javax.swing.JColorChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 230, 130, 40));

        jLabel10.setText("ALTURA");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 120, 40));

        jLabel8.setText("HABITAT");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 130, 40));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 120, 50));

        jLabel6.setText("COLOR");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 110, 50));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 110, 50));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 70, 50, 20));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 34, 70, 20));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 64, 170, 20));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 34, 180, 20));

        jButton2.setBackground(new java.awt.Color(204, 0, 204));
        jButton2.setText("Siguiente");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, 90, -1));

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setText("Anterior");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 90, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokedexFondo.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
      contador--;
        if(contador<0){contador=0;}
        dibujaElPokemonQueEstaEnLaPosicion(contador);
                                         
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
          contador++;
        if(contador>507){contador=0;}
        dibujaElPokemonQueEstaEnLaPosicion(contador);
    }//GEN-LAST:event_jButton2MousePressed

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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JColorChooser jColorChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
