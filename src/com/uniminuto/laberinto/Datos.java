/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.laberinto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joncasasq
 */
public class Datos {

    public ArrayList<Coordenada> leerAleartorios() throws FileNotFoundException {
        ArrayList<Coordenada> datos = new ArrayList<>();
        try (Scanner sn = new Scanner(new File(getClass().getResource("aleatorios.csv").getFile()))) {
            while (sn.hasNext()) {
                String linea = sn.next();
                String[] coordenadas = linea.replace(",", ".").split(";");
                Coordenada coordenada = new Coordenada(conversor(Double.parseDouble(coordenadas[0])), conversor(Double.parseDouble(coordenadas[1])));
                datos.add(coordenada);
            }
        }
        return datos;
    }

    public int conversor(double r) {
        return (int) ((Math.sqrt(2) * Math.sqrt(Math.PI) * r) * 9);
    }

}
