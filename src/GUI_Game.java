/*

 ██████╗  █████╗ ███╗   ██╗██████╗  ██████╗ ███╗   ███╗ █████╗  ██████╗ ██████╗███████╗███████╗███████╗         ██████╗ ██████╗ ██████╗ ███████╗
 ██╔══██╗██╔══██╗████╗  ██║██╔══██╗██╔═══██╗████╗ ████║██╔══██╗██╔════╝██╔════╝██╔════╝██╔════╝██╔════╝        ██╔════╝██╔═══██╗██╔══██╗██╔════╝
 ██████╔╝███████║██╔██╗ ██║██║  ██║██║   ██║██╔████╔██║███████║██║     ██║     █████╗  ███████╗███████╗        ██║     ██║   ██║██║  ██║█████╗  
 ██╔══██╗██╔══██║██║╚██╗██║██║  ██║██║   ██║██║╚██╔╝██║██╔══██║██║     ██║     ██╔══╝  ╚════██║╚════██║        ██║     ██║   ██║██║  ██║██╔══╝  
 ██║  ██║██║  ██║██║ ╚████║██████╔╝╚██████╔╝██║ ╚═╝ ██║██║  ██║╚██████╗╚██████╗███████╗███████║███████║███████╗╚██████╗╚██████╔╝██████╔╝███████╗
 ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═════╝╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═════╝ ╚══════╝

*/

import javax.swing.ImageIcon;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class GUI_Game extends javax.swing.JFrame {

    int cpu_handSelectedOption = 0;
    int timerCounter = 0;
    int scoreCounter = 0;
    
    Random random = new Random();
    Timer timer;
    TimerTask playAnimation;
     
    

    public GUI_Game() {
        initComponents();
        
        Status_Tag.setVisible(false);
        
        Player_Container.setVisible(false);
        CPU_Container.setVisible(false);
        
        Button_Rock.setVisible(false);
        Button_Paper.setVisible(false);
        Button_Scissors.setVisible(false);
        
        Player_ScoreBar.setText("0");
        // [!] ~ Codigo Extra ~ [!]
        fuck.setVisible(false);
        // [!] ~ Codigo Extra ~ [!]
    }

    //----------------------------------------------------------------------------//
    // #1. Metodo donde la computadora selecciona de forma aleatoria una opcion   //
    //     [Piedra = 0] ~ [Papel = 1] ~ [Tijera = 2]                              //
    //----------------------------------------------------------------------------//
    public void cpu_setOption(){
        cpu_handSelectedOption = random.nextInt(3);
        
        switch(cpu_handSelectedOption){
            case 0:
                CPU_Container.setIcon(new ImageIcon(getClass().getResource("Images/CPU_Rock.png")));
                break;
            case 1:
                CPU_Container.setIcon(new ImageIcon(getClass().getResource("Images/CPU_Paper.png")));
                break;
            case 2:
                CPU_Container.setIcon(new ImageIcon(getClass().getResource("Images/CPU_Scissors.png")));
                break;
        }
    }
    
    //----------------------------------------------------------------------------//
    // #2. Metodo que muestra la animacion(.gif) de explosion de fondo.           //
    //     Cuando el contador de tiempo es igual a 2 seg la imagen es cambiada.   //
    //----------------------------------------------------------------------------//  
    public void explosionAnimation(){
        timer = new Timer();
        
        Explosion.setIcon(new ImageIcon(getClass().getResource("Images/Explosion(1).gif")));
        Explosion.setVisible(true);
        
        playAnimation = new TimerTask() {
            @Override
            public void run() {
                if(timerCounter == 2){
                    cancel();
                    Explosion.setIcon(new ImageIcon(getClass().getResource("Images/Explosion(2).gif")));
                }
                timerCounter++;
            }
        };
        timer.schedule(playAnimation, 0, 1000);
        timerCounter = 0;
    }

    //----------------------------------------------------------------------------//
    // #3. Metodo que reinicia los botones para volver a jugar.                   //
    //----------------------------------------------------------------------------//
    public void resetButtons(){
        
        Button_Rock.setVisible(false);
        Button_Paper.setVisible(false);
        Button_Scissors.setVisible(false);
        
        Button_Play.setVisible(true);
    }

    //----------------------------------------------------------------------------//
    // #4. Metodo que realiza el conteo de las partidas ganadas por el jugador.   //
    //----------------------------------------------------------------------------// 
    public void scoreCounter(){
        scoreCounter++;
        Player_ScoreBar.setText(String.valueOf(scoreCounter));
        
        // [!] ~ Codigo Extra ~ [!]
        if(scoreCounter == 6){
            fuck.setIcon(new ImageIcon(getClass().getResource("Images/fuckGame.png")));
            fuck.setVisible(true);
            Player_Container.setVisible(false);
            CPU_Container.setVisible(false);
            Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Winner_Tag.png")));
        }
        // [!] ~ Codigo Extra ~ [!]
    }
    

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fuck = new javax.swing.JLabel();
        Button_Play = new javax.swing.JButton();
        Button_Rock = new javax.swing.JButton();
        Button_Paper = new javax.swing.JButton();
        Button_Scissors = new javax.swing.JButton();
        Status_Tag = new javax.swing.JLabel();
        Player_Container = new javax.swing.JLabel();
        CPU_Container = new javax.swing.JLabel();
        Explosion = new javax.swing.JLabel();
        Player_ScoreBar = new javax.swing.JLabel();
        lbl_Score = new javax.swing.JLabel();
        Button_Reset = new javax.swing.JButton();
        Background_Ring = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rock Paper Scissors Game");
        setResizable(false);
        getContentPane().setLayout(null);

        fuck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fuckGame.png"))); // NOI18N
        getContentPane().add(fuck);
        fuck.setBounds(390, 200, 170, 360);

        Button_Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Play(Default).png"))); // NOI18N
        Button_Play.setBorderPainted(false);
        Button_Play.setContentAreaFilled(false);
        Button_Play.setPreferredSize(new java.awt.Dimension(370, 110));
        Button_Play.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Play(Hover).png"))); // NOI18N
        Button_Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PlayActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Play);
        Button_Play.setBounds(270, 640, 370, 110);

        Button_Rock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Rock(Default).png"))); // NOI18N
        Button_Rock.setBorderPainted(false);
        Button_Rock.setContentAreaFilled(false);
        Button_Rock.setPreferredSize(new java.awt.Dimension(260, 160));
        Button_Rock.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Rock(Hover).png"))); // NOI18N
        Button_Rock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RockActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Rock);
        Button_Rock.setBounds(30, 610, 260, 160);

        Button_Paper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Paper(Default).png"))); // NOI18N
        Button_Paper.setBorderPainted(false);
        Button_Paper.setContentAreaFilled(false);
        Button_Paper.setPreferredSize(new java.awt.Dimension(260, 160));
        Button_Paper.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Paper(Hover).png"))); // NOI18N
        Button_Paper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PaperActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Paper);
        Button_Paper.setBounds(328, 610, 260, 160);

        Button_Scissors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Scissors(Default).png"))); // NOI18N
        Button_Scissors.setBorderPainted(false);
        Button_Scissors.setContentAreaFilled(false);
        Button_Scissors.setPreferredSize(new java.awt.Dimension(260, 160));
        Button_Scissors.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Scissors(Hover).png"))); // NOI18N
        Button_Scissors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ScissorsActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Scissors);
        Button_Scissors.setBounds(620, 610, 260, 160);

        Status_Tag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ready_Tag.png"))); // NOI18N
        Status_Tag.setPreferredSize(new java.awt.Dimension(600, 110));
        getContentPane().add(Status_Tag);
        Status_Tag.setBounds(170, 40, 600, 110);

        Player_Container.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Player_HandRoll.gif"))); // NOI18N
        getContentPane().add(Player_Container);
        Player_Container.setBounds(210, 310, 280, 200);

        CPU_Container.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CPU_HandRoll.gif"))); // NOI18N
        getContentPane().add(CPU_Container);
        CPU_Container.setBounds(480, 200, 280, 200);

        Explosion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Explosion.setPreferredSize(new java.awt.Dimension(630, 520));
        getContentPane().add(Explosion);
        Explosion.setBounds(130, 30, 630, 520);

        Player_ScoreBar.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        Player_ScoreBar.setForeground(new java.awt.Color(204, 0, 0));
        Player_ScoreBar.setText("123456");
        getContentPane().add(Player_ScoreBar);
        Player_ScoreBar.setBounds(120, 530, 150, 50);

        lbl_Score.setFont(new java.awt.Font("JACKPORT COLLEGE NCV", 0, 38)); // NOI18N
        lbl_Score.setForeground(new java.awt.Color(102, 51, 0));
        lbl_Score.setText("Score :");
        getContentPane().add(lbl_Score);
        lbl_Score.setBounds(10, 530, 110, 50);

        Button_Reset.setBackground(new java.awt.Color(153, 0, 0));
        Button_Reset.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        Button_Reset.setForeground(new java.awt.Color(255, 255, 255));
        Button_Reset.setText("Reset");
        Button_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ResetActionPerformed(evt);
            }
        });
        getContentPane().add(Button_Reset);
        Button_Reset.setBounds(830, 530, 71, 21);

        Background_Ring.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background_Ring.gif"))); // NOI18N
        getContentPane().add(Background_Ring);
        Background_Ring.setBounds(0, 0, 910, 780);

        setSize(new java.awt.Dimension(924, 817));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    //----------------------------------------------------------------------------//
    // > [Boton Piedra]                                                           //
    //----------------------------------------------------------------------------//     
    private void Button_RockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RockActionPerformed
        Player_Container.setIcon(new ImageIcon(getClass().getResource("Images/Player_Rock.png")));
        Player_Container.setVisible(true);
        cpu_setOption();
        explosionAnimation();
        
        switch(cpu_handSelectedOption){
            case 0:
                Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Draw_Tag.png")));
                resetButtons();
                break;
            case 1:
                Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Lose_Tag.png")));
                resetButtons();
                break;
            case 2:
                Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Winner_Tag.png")));
                scoreCounter();
                resetButtons();
                break;
        }
    }//GEN-LAST:event_Button_RockActionPerformed

    //----------------------------------------------------------------------------//
    // > [Boton Papel]                                                            //
    //----------------------------------------------------------------------------//     
    private void Button_PaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PaperActionPerformed
        Player_Container.setIcon(new ImageIcon(getClass().getResource("Images/Player_Paper.png")));
        Player_Container.setVisible(true);
        cpu_setOption();
        explosionAnimation();
        
        switch(cpu_handSelectedOption){
            case 0:
                Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Winner_Tag.png")));
                scoreCounter();
                resetButtons();
                break;
            case 1:
                Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Draw_Tag.png")));
                resetButtons();
                break;
            case 2:
                Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Lose_Tag.png")));               
                resetButtons();
                break;
        }        
    }//GEN-LAST:event_Button_PaperActionPerformed

    //----------------------------------------------------------------------------//
    // > [Boton Tijera]                                                           //
    //----------------------------------------------------------------------------//     
    private void Button_ScissorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ScissorsActionPerformed
        Player_Container.setIcon(new ImageIcon(getClass().getResource("Images/Player_Scissors.png")));
        Player_Container.setVisible(true);
        cpu_setOption();
        explosionAnimation();
        
        switch(cpu_handSelectedOption){
            case 0:
                Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Lose_Tag.png")));               
                resetButtons();
                break;
            case 1:
                Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Winner_Tag.png")));
                scoreCounter();
                resetButtons();
                break;
            case 2:
                Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Draw_Tag.png")));               
                resetButtons();
                break;
        }         
    }//GEN-LAST:event_Button_ScissorsActionPerformed

    //----------------------------------------------------------------------------//
    // > [Boton Play]                                                             //
    //----------------------------------------------------------------------------//     
    private void Button_PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PlayActionPerformed
        Button_Play.setVisible(false);
        Explosion.setVisible(false);

        Status_Tag.setIcon(new ImageIcon(getClass().getResource("Images/Ready_Tag.png")));
        Status_Tag.setVisible(true);

        Player_Container.setIcon(new ImageIcon(getClass().getResource("Images/Player_HandRoll.gif")));
        CPU_Container.setIcon(new ImageIcon(getClass().getResource("Images/CPU_HandRoll.gif")));
        Player_Container.setVisible(true);
        CPU_Container.setVisible(true);

        Button_Rock.setVisible(true);
        Button_Paper.setVisible(true);
        Button_Scissors.setVisible(true);
    }//GEN-LAST:event_Button_PlayActionPerformed

    //----------------------------------------------------------------------------//
    // > [Boton Reset]                                                            //
    //----------------------------------------------------------------------------//     
    private void Button_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ResetActionPerformed
        Player_ScoreBar.setText("0");
        scoreCounter = 0;

        Status_Tag.setVisible(false);
        Explosion.setVisible(false);
        Player_Container.setVisible(false);
        CPU_Container.setVisible(false);

        resetButtons();
    }//GEN-LAST:event_Button_ResetActionPerformed

   

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
            java.util.logging.Logger.getLogger(GUI_Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background_Ring;
    private javax.swing.JButton Button_Paper;
    private javax.swing.JButton Button_Play;
    private javax.swing.JButton Button_Reset;
    private javax.swing.JButton Button_Rock;
    private javax.swing.JButton Button_Scissors;
    private javax.swing.JLabel CPU_Container;
    private javax.swing.JLabel Explosion;
    private javax.swing.JLabel Player_Container;
    private javax.swing.JLabel Player_ScoreBar;
    private javax.swing.JLabel Status_Tag;
    private javax.swing.JLabel fuck;
    private javax.swing.JLabel lbl_Score;
    // End of variables declaration//GEN-END:variables
}
