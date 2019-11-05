/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import EnemyBullets.EnemyWeaponType;
import Explosion.ExplosionManager;
import GameScreen.BasicBlocks;
import GameScreen.Player;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class EnemyBulletHandler {

    private List<EnemyWeaponType> weaponTypes = new ArrayList<>();

    public void addBullet(EnemyWeaponType weaponType) {
        this.weaponTypes.add(weaponType);
    }

    public void draw(Graphics2D g) {
        for (EnemyWeaponType enemyWeaponType : weaponTypes) {
            enemyWeaponType.draw(g);
        }
    }

    public void update(double delta, BasicBlocks blocks, Player player) {
        for (int i = 0; i < weaponTypes.size(); i++) {
            weaponTypes.get(i).update(delta, blocks, player);
            if (weaponTypes.get(i).collision(player.getRect())) {
                ExplosionManager.createPixelExplosion(weaponTypes.get(i).getxPos(), weaponTypes.get(i).getyPos());
                weaponTypes.remove(i);
                player.hit();
            }
        }
    }

    public void reset() {
        weaponTypes.clear();
    }

}
