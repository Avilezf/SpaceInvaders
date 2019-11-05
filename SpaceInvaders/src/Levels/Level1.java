/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import EnemyType.EnemyType;
import EnemyType.EnemyTypeBasic;
import GameScreen.BasicBlocks;
import GameScreen.Player;
import Handler.EnemyBulletHandler;
import Sound.Sound;
import java.awt.Graphics2D;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class Level1 implements SuperLevel {

    private Player player;
    private ArrayList<EnemyType> enemies = new ArrayList<EnemyType>();
    private EnemyBulletHandler bulletHandler;

    private Sound beep, boop;
    private boolean beepboop;

    public Level1(Player player, EnemyBulletHandler bulletHandler) {
        this.player = player;
        this.bulletHandler = bulletHandler;
        addEnemies();

        beep = new Sound("/sounds/beep.wav");
        boop = new Sound("/sounds/boop.wav");
    }

    @Override
    public void draw(Graphics2D g) {
        if (enemies == null) {
            return;
        }

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(g);
        }
        bulletHandler.draw(g);
    }

    @Override
    public void update(double delta, BasicBlocks blocks) {
        if (enemies == null) {
            return;
        }

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).update(delta, player, blocks);
        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).collide(i, player, blocks, enemies);
        }
        hasDirectionChange(delta);
        bulletHandler.update(delta, blocks, player);
    }

    @Override
    public void hasDirectionChange(double delta) {
        if (enemies == null) {
            return;
        }

        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).isOutOfBounds()) {
                changeDurectionAllEnemys(delta);
            }
        }
    }

    @Override
    public void changeDurectionAllEnemys(double delta) {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).changeDirection(delta);
        }
        if (beepboop) {
            beepboop = false;
            boop.play();
        } else {
            beepboop = true;
            beep.play();
        }
    }

    @Override
    public boolean isGameOver() {
        return player.getHealth() <= 0;
    }

    @Override
    public void destory() {

    }

    @Override
    public void reset() {
        player.reset();
        enemies.clear();
        addEnemies();

        bulletHandler.reset();
    }

    public void addEnemies() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 10; x++) {
                EnemyType e = new EnemyTypeBasic(150 + (x * 40), 25 + (y * 40), 1, 3, bulletHandler);
                enemies.add(e);
            }
        }
    }

    @Override
    public boolean isComplete() {
        return enemies.isEmpty();
    }
}
