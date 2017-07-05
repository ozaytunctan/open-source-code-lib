/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.matrix;

import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author ozaytunctan13
 */
/* 
Matrix işlemleri için hazırlanmış özel bir konum ifade eden bir nesnedir.
Matrix satir ve sutunları x ve y cinsinden tanımlanmıştır.
örnek olarak bir image te iki pixelin bulunduğu bölge hesaplanması için yazılmıştır.

*/

public class CPoint {

    public int row;
    public int column;

    public CPoint(CPoint p) {
        this.row = p.row;
        this.column = p.column;

    }

    public CPoint(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public CPoint(int rc) {
        this.row = rc;
        this.column = rc;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public CPoint getLocation() {
        return new CPoint(row, column);
    }

    public double getDistance(CPoint p1) {
        int r = this.row - p1.getRow();
        int c = this.column - p1.getColumn();
        return Math.sqrt((r * r) + (c * c));
    }

    public double getDistance(int px, int py) {
        int r = this.row - px;
        int c = this.column - py;
        return Math.sqrt((r * r) + (c * c));
    }

    public void translate(int px, int py) {
        this.row = px;
        this.column = py;
    }
    @Override
    public CPoint clone(){
        return this.clone();
    }
    @Override
    public String toString(){
        String str="TPoint[ row:"+this.row+","+"column:"+this.column+"]";
        return str;      
    }
   

}
