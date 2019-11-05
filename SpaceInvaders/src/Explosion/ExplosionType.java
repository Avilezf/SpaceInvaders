/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Explosion;

import java.awt.Graphics2D;



/**
 *
 * @author Luis
 */
public interface ExplosionType {

	public void draw(Graphics2D g);
	public void update(double delta);
	
	public boolean destory();
}

