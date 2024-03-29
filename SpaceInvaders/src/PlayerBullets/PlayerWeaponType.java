/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerBullets;

import GameScreen.BasicBlocks;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;

/**
 *
 * @author Luis
 */
public abstract class PlayerWeaponType {

    protected double xPos, yPos;
    protected int width, height;

    public abstract void draw(Graphics2D g);

    public abstract void update(double delta, BasicBlocks blocks);

    public abstract boolean collisionRect(Rectangle rect);

    public abstract boolean collisionPoly(Polygon poly);

    public abstract boolean destory();

    protected abstract void wallCollide(BasicBlocks blocks);

    protected abstract void isOutofBounds();

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
