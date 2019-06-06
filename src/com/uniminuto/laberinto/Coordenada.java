/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.laberinto;

/**
 *
 * @author joncasasq
 */
public class Coordenada {

    public int x;
    public int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + "\"x\":" + x + ", \"y\":" + y + '}';
    }

}
