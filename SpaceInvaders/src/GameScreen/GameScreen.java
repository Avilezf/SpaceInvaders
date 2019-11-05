/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameScreen;

import Display.Display;
import FontArcade.FontArcade;
import Handler.EnemyBulletHandler;
import Levels.Level1;
import Sockets.Client;
import State.StateMachine;
import State.SuperStateMachine;
import Timer.TickTimer;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Luis
 */
public class GameScreen extends SuperStateMachine {

    private Player player;
    private BasicBlocks blocks;
    private Level1 level;
    private EnemyBulletHandler bulletHandler;

    public static int SCORE = 0;
    public static int SCORE2 = 0;

    private FontArcade font = new FontArcade();
    private Font gameScreen = font.fuente(font.getARC(), 0, 40);
    private TickTimer gameOverTimer = new TickTimer(180);
    private TickTimer completeTimer = new TickTimer(180);

    public GameScreen(StateMachine stateMachine) {
        super(stateMachine);
        blocks = new BasicBlocks();
        bulletHandler = new EnemyBulletHandler();
        player = new Player(Display.WIDTH / 2 - 50, Display.HEIGHT - 75, 50, 50, blocks);
        level = new Level1(player, bulletHandler);
    }

    @Override
    public void update(double delta) {
        player.update(delta);
        level.update(delta, blocks);
        if (level.isGameOver()) {
            gameOverTimer.tick(delta);
            if (gameOverTimer.isEventReady()) {
                level.reset();
                blocks.reset();
                getStateMachine().setState((byte) 0);
                SCORE = 0;
            }
        }

        if (level.isComplete()) {
            completeTimer.tick(delta);
            if (completeTimer.isEventReady()) {
                level.reset();
            }
        }
    }

    @Override
    public void draw(Graphics2D g) {
        Client client = new Client(); //para actualizar cada vez que dibuja, si no sirve quitenlo y coloquenlo en enemytype cada vez que muere un marciano
        g.setColor(Color.white);
        g.setFont(gameScreen);
        g.drawString("Score    " + SCORE, 5, 27);//El signo de : no sirve
        g.drawString("Score P2    " + SCORE2, 240, 27);

        g.setColor(Color.yellow);
        g.setFont(gameScreen);
        g.drawString("Health   " + player.getHealth(), 500, 27);//El signo de : no sirve

        blocks.draw(g);
        player.draw(g);
        level.draw(g);

        if (level.isGameOver()) {
            g.setColor(Color.red);
            g.setFont(gameScreen);
            String gameOver = "GAME OVER!";
            int gameOverWidth = g.getFontMetrics().stringWidth(gameOver);
            g.drawString(gameOver, (Display.WIDTH / 2) - (gameOverWidth / 2), Display.HEIGHT / 2);
        }

        if (level.isComplete()) {
            g.setColor(Color.green);
            g.setFont(gameScreen);
            String complete = "LEVEL COMPLETE!";
            int completeWidth = g.getFontMetrics().stringWidth(complete);
            g.drawString(complete, (Display.WIDTH / 2) - (completeWidth / 2), Display.HEIGHT / 2);
        }
    }

    @Override
    public void init(Canvas canvas) {
        canvas.addKeyListener(player);
    }

}
