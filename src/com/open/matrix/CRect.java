/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.matrix;

/**
 *
 * @author ozaytunctan13
 */
public class CRect {

    public int row;
    public int col;
    public int width;
    public int height;

    public CRect() {
        this.row = 1;
        this.col = 1;
        this.width = 1;
        this.height = 1;
    }
    /**
     * 
     * @param row
     * @param col
     * @param width
     * @param height 
     */
    public CRect(int row, int col, int width, int height) {
        this.row = row;
        this.col = col;
        this.width = width;
        this.height = height;
    }

    public CRect(CPoint p, int width, int height) {
        this.row = p.row;
        this.col = p.column;
        this.width = width;
        this.height = height;
    }

    public CRect(int row, int col, CSize cs) {
        this.row = row;
        this.col = col;
        this.width = cs.width;
        this.height = cs.height;
    }

    public CRect(CPoint p, CSize cs) {
        this.row = p.row;
        this.col = p.column;
        this.width = cs.getWidth();
        this.height = cs.getHeight();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return col;
    }

    public void setColumn(int col) {
        this.col = col;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
