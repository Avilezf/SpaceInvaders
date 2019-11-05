/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import GameScreen.GameScreen;
import MenuScreen.MenuScreen;
import MenuScreen.SetupScreen;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class StateMachine {

    private ArrayList<SuperStateMachine> states = new ArrayList<SuperStateMachine>();
    private Canvas canvas;
    private byte selectState = 0;

    public StateMachine(Canvas canvas) {
        SuperStateMachine game = new GameScreen(this);
        SuperStateMachine menu = new MenuScreen(this);
        SuperStateMachine setup = new SetupScreen(this);
        states.add(menu);
        states.add(game);
        states.add(setup);
                

        this.canvas = canvas;
    }

    public void draw(Graphics2D g) {
        states.get(selectState).draw(g);
    }

    public void update(double delta) {
        states.get(selectState).update(delta);
    }

    public void setState(byte i) {
        for (int r = 0; r < canvas.getKeyListeners().length; r++) {
            canvas.removeKeyListener(canvas.getKeyListeners()[r]);
        }
        selectState = i;
        states.get(selectState).init(canvas);
    }

    public byte getStates() {
        return selectState;
    }
}
