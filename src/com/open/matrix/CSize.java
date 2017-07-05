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
public class CSize {

    public int width;
    public int height;

    public CSize(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public CSize(int size) {
        this.width = size;
        this.height = size;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return (this.width * this.height);
    }

}
