/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.BorderLayout;
import javax.swing.JApplet;

/**
 *
 * @author Luis
 */
public class Display_Applet extends JApplet {

    private static final long serialVersionUID = 1L;
    private Display display = new Display();

    public void init() {
        setLayout(new BorderLayout());
        add(display);
    }

    public void start() {
        display.start();
    }

    public void stop() {
        display.stop();
    }
}