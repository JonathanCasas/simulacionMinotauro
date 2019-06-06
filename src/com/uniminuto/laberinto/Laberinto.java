/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.laberinto;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author joncasasq
 */
public class Laberinto extends JFrame {

    int globalI = 19;
    int globalJ = 21;
    private final JPanel[][] panels = new JPanel[globalI][globalJ];
    private ArrayList<Position> positions = new ArrayList<>();
    Datos datos = new Datos();
    ArrayList<Coordenada> coordenadas = new ArrayList<>();

    public Laberinto() throws HeadlessException, FileNotFoundException {
        coordenadas = datos.leerAleartorios();
        setPositionsLabyrinth();
        initComponents();//Se establece las propieades de la pantalla (Componentes)
        initPaneles();//Se establecen las propieadades de los paneles (Grilla del laberinto)
    }

    private void initComponents() {
        this.setSize(735, 735);//El tamaño de la ventana
        this.setLayout(new GridLayout(globalI, globalJ));//El tamaño de la grilla 
        this.setBackground(Color.WHITE);//Color de la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Para que se mate el proceso cuando se cierre la ventana
    }

    private void initPaneles() {
        for (int i = 0; i < globalI; i++) {//For para crear los paneles de la grilla
            for (int j = 0; j < globalJ; j++) {
                panels[i][j] = new JPanel();//Se crea el panel y se agrega a la lista
            }
        }
        paintPanels();//Se establecen las propiedades de los paneles que hacen parte del laberinto
        placeMinotaur();
        paintPerson();
        paintTeseo();
        for (int i = 0; i < globalI; i++) {//For para agregar los paneles a la grilla
            for (int j = 0; j < globalJ; j++) {
                this.add(panels[i][j]);
            }
        }
    }

    public static void main(String[] args) throws HeadlessException, FileNotFoundException {
        new Laberinto().setVisible(true);
    }

    private void paintPanels() {
        for (Position position : positions) {
            createLabyrinth(position.i, position.j);
        }
    }

    private void createLabyrinth(int i, int j) {
        panels[i][j].setBackground(new Color(68, 81, 58));
        panels[i][j].setBorder(new LineBorder(Color.WHITE));
    }

    private void placeMinotaur() {
        PanelMintaur panel = new PanelMintaur();
        panel.setSize(panels[8][8].getWidth(), panels[8][8].getHeight());
        panels[8][8].add(panel);
    }

    private void paintPerson() {
        int counter = 0;
        for (Coordenada coordenada : coordenadas) {
            if (!isLabyrinth(coordenada)) {
                counter++;
                panels[coordenada.x][coordenada.y].setBackground(new Color(255, 113, 51));
                panels[coordenada.x][coordenada.y].setBorder(new LineBorder(Color.WHITE));
            }
            if (counter == 3) {
                break;
            }
        }
    }

    private void paintTeseo() {
        panels[1][0].setBackground(Color.CYAN);
        panels[1][0].setBorder(new LineBorder(Color.WHITE));
    }

    private boolean isLabyrinth(Coordenada coordenada) {
        for (Position position : positions) {
            if (coordenada.x == position.i
                    && coordenada.x < 21
                    && coordenada.y == position.j
                    && coordenada.y < 19) {
                return true;
            }
        }
        return false;
    }

    private void setPositionsLabyrinth() {
        positions.add(new Position(0, 0));
        positions.add(new Position(0, 1));
        positions.add(new Position(0, 2));
        positions.add(new Position(0, 3));
        positions.add(new Position(0, 4));
        positions.add(new Position(0, 5));
        positions.add(new Position(0, 6));
        positions.add(new Position(0, 7));
        positions.add(new Position(0, 8));
        positions.add(new Position(0, 9));
        positions.add(new Position(0, 10));
        positions.add(new Position(0, 11));
        positions.add(new Position(0, 12));
        positions.add(new Position(0, 13));
        positions.add(new Position(0, 14));
        positions.add(new Position(0, 15));
        positions.add(new Position(0, 16));
        positions.add(new Position(0, 17));
        positions.add(new Position(0, 18));
        positions.add(new Position(0, 19));
        positions.add(new Position(0, 20));
        positions.add(new Position(1, 13));
        positions.add(new Position(1, 20));
        positions.add(new Position(2, 0));
        positions.add(new Position(2, 2));
        positions.add(new Position(2, 3));
        positions.add(new Position(2, 4));
        positions.add(new Position(2, 5));
        positions.add(new Position(2, 6));
        positions.add(new Position(2, 8));
        positions.add(new Position(2, 9));
        positions.add(new Position(2, 10));
        positions.add(new Position(2, 11));
        positions.add(new Position(2, 12));
        positions.add(new Position(2, 13));
        positions.add(new Position(2, 14));
        positions.add(new Position(2, 15));
        positions.add(new Position(2, 17));
        positions.add(new Position(2, 18));
        positions.add(new Position(2, 20));
        positions.add(new Position(3, 0));
        positions.add(new Position(3, 2));
        positions.add(new Position(3, 18));
        positions.add(new Position(3, 20));
        positions.add(new Position(4, 0));
        positions.add(new Position(4, 2));
        positions.add(new Position(4, 4));
        positions.add(new Position(4, 6));
        positions.add(new Position(4, 7));
        positions.add(new Position(4, 8));
        positions.add(new Position(4, 9));
        positions.add(new Position(4, 10));
        positions.add(new Position(4, 11));
        positions.add(new Position(4, 12));
        positions.add(new Position(4, 13));
        positions.add(new Position(4, 14));
        positions.add(new Position(4, 15));
        positions.add(new Position(4, 16));
        positions.add(new Position(4, 18));
        positions.add(new Position(4, 20));
        positions.add(new Position(5, 0));
        positions.add(new Position(5, 2));
        positions.add(new Position(5, 4));
        positions.add(new Position(5, 9));
        positions.add(new Position(5, 16));
        positions.add(new Position(5, 18));
        positions.add(new Position(5, 20));
        positions.add(new Position(6, 0));
        positions.add(new Position(6, 4));
        positions.add(new Position(6, 6));
        positions.add(new Position(6, 7));
        positions.add(new Position(6, 8));
        positions.add(new Position(6, 9));
        positions.add(new Position(6, 11));
        positions.add(new Position(6, 12));
        positions.add(new Position(6, 13));
        positions.add(new Position(6, 14));
        positions.add(new Position(6, 16));
        positions.add(new Position(6, 18));
        positions.add(new Position(6, 20));
        positions.add(new Position(7, 0));
        positions.add(new Position(7, 2));
        positions.add(new Position(7, 4));
        positions.add(new Position(7, 6));
        positions.add(new Position(7, 14));
        positions.add(new Position(7, 16));
        positions.add(new Position(7, 18));
        positions.add(new Position(7, 20));
        positions.add(new Position(8, 0));
        positions.add(new Position(8, 2));
        positions.add(new Position(8, 4));
        positions.add(new Position(8, 6));
        positions.add(new Position(8, 14));
        positions.add(new Position(8, 16));
        positions.add(new Position(8, 17));
        positions.add(new Position(8, 18));
        positions.add(new Position(8, 20));
        positions.add(new Position(9, 0));
        positions.add(new Position(9, 2));
        positions.add(new Position(9, 4));
        positions.add(new Position(9, 6));
        positions.add(new Position(9, 14));
        positions.add(new Position(9, 16));
        positions.add(new Position(9, 18));
        positions.add(new Position(9, 20));
        positions.add(new Position(10, 0));
        positions.add(new Position(10, 2));
        positions.add(new Position(10, 3));
        positions.add(new Position(10, 4));
        positions.add(new Position(10, 6));
        positions.add(new Position(10, 7));
        positions.add(new Position(10, 8));
        positions.add(new Position(10, 9));
        positions.add(new Position(10, 10));
        positions.add(new Position(10, 11));
        positions.add(new Position(10, 12));
        positions.add(new Position(10, 13));
        positions.add(new Position(10, 14));
        positions.add(new Position(10, 16));
        positions.add(new Position(10, 18));
        positions.add(new Position(10, 20));
        positions.add(new Position(11, 0));
        positions.add(new Position(11, 2));
        positions.add(new Position(11, 4));
        positions.add(new Position(11, 12));
        positions.add(new Position(11, 16));
        positions.add(new Position(11, 18));
        positions.add(new Position(11, 20));
        positions.add(new Position(12, 0));
        positions.add(new Position(12, 2));
        positions.add(new Position(12, 4));
        positions.add(new Position(12, 5));
        positions.add(new Position(12, 6));
        positions.add(new Position(12, 7));
        positions.add(new Position(12, 8));
        positions.add(new Position(12, 9));
        positions.add(new Position(12, 10));
        positions.add(new Position(12, 11));
        positions.add(new Position(12, 12));
        positions.add(new Position(12, 13));
        positions.add(new Position(12, 14));
        positions.add(new Position(12, 16));
        positions.add(new Position(12, 18));
        positions.add(new Position(12, 20));
        positions.add(new Position(13, 0));
        positions.add(new Position(13, 2));
        positions.add(new Position(13, 9));
        positions.add(new Position(13, 18));
        positions.add(new Position(13, 20));
        positions.add(new Position(14, 0));
        positions.add(new Position(14, 2));
        positions.add(new Position(14, 3));
        positions.add(new Position(14, 4));
        positions.add(new Position(14, 5));
        positions.add(new Position(14, 6));
        positions.add(new Position(14, 7));
        positions.add(new Position(14, 8));
        positions.add(new Position(14, 9));
        positions.add(new Position(14, 10));
        positions.add(new Position(14, 11));
        positions.add(new Position(14, 12));
        positions.add(new Position(14, 14));
        positions.add(new Position(14, 15));
        positions.add(new Position(14, 16));
        positions.add(new Position(14, 18));
        positions.add(new Position(14, 20));
        positions.add(new Position(15, 0));
        positions.add(new Position(15, 2));
        positions.add(new Position(15, 18));
        positions.add(new Position(15, 20));
        positions.add(new Position(16, 0));
        positions.add(new Position(16, 2));
        positions.add(new Position(16, 3));
        positions.add(new Position(16, 4));
        positions.add(new Position(16, 6));
        positions.add(new Position(16, 7));
        positions.add(new Position(16, 8));
        positions.add(new Position(16, 9));
        positions.add(new Position(16, 10));
        positions.add(new Position(16, 11));
        positions.add(new Position(16, 12));
        positions.add(new Position(16, 13));
        positions.add(new Position(16, 14));
        positions.add(new Position(16, 15));
        positions.add(new Position(16, 16));
        positions.add(new Position(16, 17));
        positions.add(new Position(16, 18));
        positions.add(new Position(16, 20));
        positions.add(new Position(17, 0));
        positions.add(new Position(17, 20));
        positions.add(new Position(18, 0));
        positions.add(new Position(18, 1));
        positions.add(new Position(18, 2));
        positions.add(new Position(18, 3));
        positions.add(new Position(18, 4));
        positions.add(new Position(18, 5));
        positions.add(new Position(18, 6));
        positions.add(new Position(18, 7));
        positions.add(new Position(18, 8));
        positions.add(new Position(18, 9));
        positions.add(new Position(18, 10));
        positions.add(new Position(18, 11));
        positions.add(new Position(18, 12));
        positions.add(new Position(18, 13));
        positions.add(new Position(18, 14));
        positions.add(new Position(18, 15));
        positions.add(new Position(18, 16));
        positions.add(new Position(18, 17));
        positions.add(new Position(18, 18));
        positions.add(new Position(18, 19));
        positions.add(new Position(18, 20));
    }
}
