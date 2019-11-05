/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnemyBullets;

import GameScreen.BasicBlocks;
import GameScreen.Player;
import java.awt.Graphics2D;
import java.awt.Rectangle;



public abstract class EnemyWeaponType {

    public abstract void draw(Graphics2D g);

    public abstract void update(double delta, BasicBlocks blocks, Player player);

    public abstract boolean collision(Rectangle rect);

    public abstract boolean destory();

    protected abstract void wallCollide(BasicBlocks blocks);

    protected abstract void isOutofBounds();

    public abstract int getxPos();

    public abstract int getyPos();
}
