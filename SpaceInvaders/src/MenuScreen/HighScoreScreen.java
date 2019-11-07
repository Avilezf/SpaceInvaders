/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuScreen;

import Display.Display;
import FontArcade.FontArcade;
import Sockets.Client;
import State.StateMachine;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Luis
 */
public class HighScoreScreen extends MenuScreen {

    private FontArcade font = new FontArcade();
    private Font startFont = font.fuente(font.getARC(), 0, 20);
    private String Score = "Score";
    private String Player = "Player";

    public HighScoreScreen(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void draw(Graphics2D g) {
        Client cliente = new Client();

        //Score Title
        g.setFont(startFont);
        g.setColor(Color.white);
        g.drawString(Score, 500, 27);

        //Player Title
        g.setFont(startFont);
        g.setColor(Color.white);
        g.drawString(Player, 5, 27);

        //Score Numbers
        g.setFont(startFont);
        g.setColor(Color.white);
        int a = 0;
        for (int i = 0; i < 7; i++) {
            g.drawString(cliente.getScores().get(i), 500, 37 + a);//Score of the Array
            a = a + 100;
        }

        //Players Names
        g.setFont(startFont);
        g.setColor(Color.white);
        int b = 0;
        for (int i = 0; i < 7; i++) {
            g.drawString(cliente.getIps().get(i), 5, 37 + a);//Players of the String
            b = b + 100;
        }

    }

    @Override
    public void init(Canvas canvas) {
        canvas.addKeyListener(this);
    }

}
