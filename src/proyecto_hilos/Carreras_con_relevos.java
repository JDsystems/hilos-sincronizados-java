package proyecto_hilos;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.awt.Image;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Carreras_con_relevos extends javax.swing.JFrame implements Runnable {

    Thread hilo = new Thread(this);
    final double ms = 1000;
    double total;
    long tiempo_inicial, duracion;
    private Jugador1 p;
    private Jugador2 q;
    Random tiempo1 = new Random();
    Random tiempo2 = new Random();
    int tiempo_tortuga, tiempoLiebre;

    public Carreras_con_relevos() {
        initComponents();
        tiempo_tortuga = tiempo1.nextInt(300);
        tiempoLiebre = tiempo2.nextInt(300);
        System.out.println("Tiempo Tortuga: " + tiempo_tortuga);
        System.out.println("Tiempo  Liebre: " + tiempoLiebre);
        setLocationRelativeTo(null);

        p = new Jugador1(this.lblTortuga.getX(), this.lblTortuga.getY(), tiempo_tortuga);
        q = new Jugador2(lblLiebre.getX(), lblLiebre.getY(), tiempoLiebre);
        
        ImageIcon tortuga = new ImageIcon("src/tortuga.png");
        Icon tor = new ImageIcon(tortuga.getImage().getScaledInstance(lblTortuga.getWidth(), lblTortuga.getHeight(), Image.SCALE_DEFAULT));
        lblTortuga.setIcon(tor);

        ImageIcon liebre = new ImageIcon("src/liebre.png");
        Icon lieb = new ImageIcon(liebre.getImage().getScaledInstance(lblLiebre.getWidth(), lblLiebre.getHeight(), Image.SCALE_DEFAULT));
        lblLiebre.setIcon(lieb);
    }

    @SuppressWarnings("unchecked")

    public void run() {
        tiempo_inicial = System.currentTimeMillis();
        p.start();
        try {
            p.join();
        } catch (Exception e) {
        }

        q.start();
        try {
            q.join();
        } catch (Exception e) {
        }
        duracion = System.currentTimeMillis() - tiempo_inicial;
        total = duracion / ms;
        JOptionPane.showMessageDialog(null, "Tiempo de la Carrera: " + total + " Segundos", "Tiempo de Ejecucion ", JOptionPane.PLAIN_MESSAGE);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTortuga = new javax.swing.JLabel();
        lblLiebre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lblTortuga, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 70, 50));
        jPanel1.add(lblLiebre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 40, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/montaña1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 450, 250));

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/montaña1.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 450, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1148, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        hilo.start();

    }//GEN-LAST:event_btnIniciarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Carreras_con_relevos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carreras_con_relevos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carreras_con_relevos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carreras_con_relevos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lblLiebre;
    public static javax.swing.JLabel lblTortuga;
    // End of variables declaration//GEN-END:variables

}
