/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import GameScreen.GameScreen;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public final class Client {
    
    final String HOST = "192.168.1.6";
    final int PORT = 8989;
    InetAddress ip;
    String host;
    Socket socket;
    ArrayList<String> ips = new ArrayList<>();
    ArrayList<String> Scores = new ArrayList<>();

    public ArrayList<String> getIps() {
        return ips;
    }

    public ArrayList<String> getScores() {
        return Scores;
    }
          
    public Client() {
        actualizar();
    }
    
    public void actualizar() {
        try {
            socket = new Socket(HOST, PORT);
            ip = InetAddress.getLocalHost();
            String [] direccion = ip.toString().split("/");;
            host = ip.getHostName();
            DataOutputStream out;
            DataInputStream in;
            
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            out.writeUTF(direccion[1]+"/"+Integer.toString(GameScreen.SCORE));
            
            String[] mensaje;
            while(!in.readUTF().equals(null)){
                mensaje = in.readUTF().split("/");
                ips.add(mensaje[0]);
                Scores.add(mensaje[1]);
            }
            in.readUTF();
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
