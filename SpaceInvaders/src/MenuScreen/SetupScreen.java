/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuScreen;

import Display.Display;
import FontArcade.FontArcade;
import State.StateMachine;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Luis
 */
public class SetupScreen extends MenuScreen implements KeyListener {

    private FontArcade font = new FontArcade();
    private Font titlefont = font.fuente(font.getARC(), 0, 50);
    private Font startFont = font.fuente(font.getARC(), 0, 20);
    private String Instruccions = "Instruccions";
    private String Start = "Press Enter to Start";

    private BufferedImage controls;

    public SetupScreen(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void draw(Graphics2D g) {

        //Title
        int tittleWidth = g.getFontMetrics().stringWidth(Instruccions);
        g.setFont(titlefont);
        g.setColor(Color.white);
        g.drawString(Instruccions, ((Display.WIDTH / 2) - (tittleWidth / 2)) - 140, 100);

        //Image
        try {
            URL url = this.getClass().getResource("/Images/Controles.png");
            controls = ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(SetupScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(controls, 100, 150, null);

        //Press Enter to Start
        g.setFont(startFont);
        g.setColor(Color.WHITE);
        g.drawString(Start, ((Display.WIDTH / 2) - (tittleWidth / 2)) - 80, 550);
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

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            getStateMachine().setState((byte) 1);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    
}

