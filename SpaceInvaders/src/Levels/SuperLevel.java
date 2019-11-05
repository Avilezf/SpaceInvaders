/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Levels;

import GameScreen.BasicBlocks;
import java.awt.Graphics2D;


/**
 *
 * @author Luis
 */
public interface SuperLevel {

	void draw(Graphics2D g);
	void update(double delta, BasicBlocks blocks);
	void hasDirectionChange(double delta);
	void changeDurectionAllEnemys(double delta);
	
	boolean isGameOver();
	boolean isComplete();
	
	void destory();
	void reset();
}
