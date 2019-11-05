/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timer;


/**
 *
 * @author Luis
 */
public class TickTimer {

    private float tick, tickTarget;

    public TickTimer(float tickTarget) {
        this.tickTarget = tickTarget;
        this.tick = 0;
    }

    public void tick(double delta) {
        if (tick <= tickTarget) {
            tick += 1 * delta;
        }
    }

    public boolean isEventReady() {
        if (tick >= tickTarget) {
            resetTimer();
            return true;
        }
        return false;
    }

    private void resetTimer() {
        tick = 0;
    }
}
