/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuScreen;

import Display.Display;
import FontArcade.FontArcade;
import State.StateMachine;
import State.SuperStateMachine;
import java.applet.AudioClip;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Luis
 */
public class MenuScreen extends SuperStateMachine implements KeyListener  {

    
    private FontArcade font = new FontArcade();
    private Font tittleFont = font.fuente(font.getARC(), 0, 70);
    private Font startFont = font.fuente(font.getARC(), 0, 25);
    private String tittle = "Space Invaders";
    private String start = "Offline Mode";
    private String online = "Online Mode";//Sockets
    private String instr = "Instructions";
    private String exit = "Exit";//Saber como
    private int contColor = 1;
   
            
            // Se carga con un fichero wav
        AudioClip sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sounds/select.wav"));;
       
    
     private BufferedImage spaceinvaders;
     private BufferedImage fondo;

    public MenuScreen(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void update(double delta) {
      
    }

    @Override
    public void draw(Graphics2D g) {
        int color;
        
        
        //Title in the Screen
//        g.setFont(tittleFont);
//        int tittleWidth = g.getFontMetrics().stringWidth(tittle);
//        g.setColor(Color.orange);
//        g.drawString(tittle, ((Display.WIDTH / 2) - (tittleWidth / 2)) - 2, (Display.HEIGHT / 2) - 123);
//        g.setColor(Color.yellow);
//        g.drawString(tittle, (Display.WIDTH / 2) - (tittleWidth / 2), (Display.HEIGHT / 2) - 125);
        //fondo

        try {
            URL url = this.getClass().getResource("/Images/fondo.gif");
            fondo = ImageIO.read(url);
            Image fondo2 = Toolkit.getDefaultToolkit().getImage("/Images/fondo.gif");
            g.drawImage(fondo2, 110, 30,500,250, null);
        } catch (IOException ex) {
            
            //Deivid Notes: da un error cuando se sale, nada que preocuparse
            Logger.getLogger(SetupScreen.class.getName()).log(Level.SEVERE, null, ex);
             
        }
        //Image Space Invaders
        try {
            URL url = this.getClass().getResource("/Images/spacelogo.png");
            spaceinvaders = ImageIO.read(url);
            g.drawImage(spaceinvaders, 110, 30,500,250, null);
        } catch (IOException ex) {
            
            //Deivid Notes: da un error cuando se sale, nada que preocuparse
            Logger.getLogger(SetupScreen.class.getName()).log(Level.SEVERE, null, ex);
             
        }
        
        
        
        
         
       
        //g.drawImage(spaceinvaders, 70, -150, null);
        

        //Offline Mode Screen
        g.setFont(startFont);
        color = 1;
        g.setColor(changeColor(color));
        int startWidth = g.getFontMetrics().stringWidth(start);
        g.drawString(start, (Display.WIDTH / 2) - (startWidth / 2) - 5, (Display.HEIGHT / 2) + 45);
        
        //Online Mode Screen
        g.setFont(startFont);
        color = 2;
        g.setColor(changeColor(color));
        startWidth = g.getFontMetrics().stringWidth(start);
        g.drawString(online, (Display.WIDTH / 2) - (startWidth / 2)+5, (Display.HEIGHT / 2) + 105);
        
        //Setup Screen
        g.setFont(startFont);
        color = 3;
        g.setColor(changeColor(color));
        startWidth = g.getFontMetrics().stringWidth(start);
        g.drawString(instr, (Display.WIDTH / 2) - (startWidth / 2) - 15, (Display.HEIGHT / 2) + 175);
        
        
        //Exit
        g.setFont(startFont);
        color = 4;
        g.setColor(changeColor(color));
        startWidth = g.getFontMetrics().stringWidth(start);
        g.drawString(exit, (Display.WIDTH / 2) - (startWidth / 2) + 45, (Display.HEIGHT / 2) + 235);
        
    }

    @Override
    public void init(Canvas canvas) {
        canvas.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            
             if ( contColor==1) {
            contColor=5;
            
        }
             sonido.stop();
             sonido.play();
             contColor--;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            
             if (contColor==4) {
            contColor=0;
            
        }
             sonido.stop();
             sonido.play();
             contColor++;
        }
       
        
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            switch (contColor){
                case 1:
                    getStateMachine().setState((byte) 1);
                    break;
                    
                case 2:
                    getStateMachine().setState((byte) 3);
                    break;
                    
                    
                case 3:
                    getStateMachine().setState((byte) 2);
                    break;
                    
                    
                case 4:
                    System.exit(0);
                    break;
            }
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    private Color changeColor(int color) {
        if (color == contColor) {
            return Color.RED;
        }
        return Color.WHITE;
    }
}
