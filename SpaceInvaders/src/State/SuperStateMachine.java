/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import java.awt.Canvas;
import java.awt.Graphics2D;

/**
 *
 * @author Luis
 */
public abstract class SuperStateMachine {

    private StateMachine stateMachine;

    public SuperStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public abstract void update(double delta);

    public abstract void draw(Graphics2D g);

    public abstract void init(Canvas canvas);

    public StateMachine getStateMachine() {
        return stateMachine;
    }
}
