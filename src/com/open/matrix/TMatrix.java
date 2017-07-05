/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.matrix;

import com.open.utils.FactoryUtils;

/**
 *
 * @author ozaytunctan13
 */
public class TMatrix {

    private double[][] current;
    private int row;
    private int col;

    private TMatrix() {
        this.row = 1;
        this.col = 1;
        this.current = new double[row][col];
    }

    private TMatrix(int r, int c) {
        this.row = r;
        this.col = c;
        current = new double[r][c];
    }

    private TMatrix(TMatrix tm) {
        this.col = tm.getColNumber();
        this.row = tm.getRowNumber();
        this.current = tm.toDouble2DArrayValue();
    }

    private TMatrix(double[][] d) {
        this.row = d.length;
        this.col = d[0].length;
        this.current = new double[row][col];
        this.current = d;
    }

    private TMatrix(int[][] d) {
        this.row = d.length;
        this.col = d[0].length;
        this.current = FactoryUtils.toCastDouble2D(d);
    }

    private TMatrix(int[] d) {
        this.row = 1;
        this.col = d.length;
        this.current = toMatrix(d);
    }

    private TMatrix(double[] d) {
        this.row = 1;
        this.col = d.length;
        this.current = toMatrix(d);
    }

    public TMatrix clone() {
        TMatrix clone = TMatrix.getInstance(FactoryMatrix.clone(this.current));
        return clone;
    }

    /**
     * row:1 col:1 yeni bir TMatrix oluşturur.
     *
     * @return
     */
    public static TMatrix getInstance() {
        return new TMatrix();
    }

    /**
     * Parametre olarak aldığı diziyi TMatrix dizisine atar ve yeni bir matrix
     * oluşturmaktadır.
     *
     * @param d
     * @return
     */
    public static TMatrix getInstance(int[][] d) {
        return new TMatrix(d);
    }

    /**
     * Parametre olarak aldığı 1D boyutlu diziyi 2D boyutlu bir diziye atar ve
     * yeni bir matrix oluşturmaktadır.
     *
     * @param d
     * @return
     */
    public static TMatrix getInstance(int[] d) {
        return new TMatrix(d);
    }

    /**
     * Parametre olarak aldığı diziyi TMatrix dizisine atar ve yeni bir matrix
     * oluşturmaktadır.
     *
     * @param d
     * @return
     */
    public static TMatrix getInstance(double[][] d) {
        return new TMatrix(d);
    }

    /**
     * Parametre olarak aldığı 1D boyutlu diziyi 2D boyutlu bir diziye atar ve
     * yeni bir matrix oluşturmaktadır.
     *
     * @param d
     * @return
     */
    public static TMatrix getInstance(double[] d) {
        return new TMatrix(d);
    }

    /**
     * Paramtre olarak aldığı
     *
     * @param tm
     * @return
     */
    public static TMatrix getInstance(TMatrix tm) {
        return new TMatrix(tm);

    }

    /**
     * TMatrix satır sayısını gösterir.
     *
     * @return
     */
    public int getRowNumber() {
        return this.row;
    }

    /**
     * TMatrix sutun sayısını gösterir.
     *
     * @return
     */
    public int getColNumber() {
        return this.col;
    }

    /**
     * TMatrix 2D boyutlu bir double diziye atar.
     *
     * @return
     */
    public double[][] toDouble2DArrayValue() {
        return this.current;
    }

    /**
     * TMatrix 2D boyutlu bir int diziye atar.
     *
     * @return
     */
    public int[][] toInt2DArrayValue() {
        return FactoryUtils.toCastInt2D(this.current);
    }

    public int[] toInt1DArrayValue() {
        return FactoryUtils.toInt1D(this.current.clone());
    }

    public double[] toDouble1DArrayValue() {
        return FactoryUtils.toDouble1D(this.current.clone());
    }

    private double[][] toMatrix(int[] d) {
        double[][] curr = new double[row][col];
        curr[0] = FactoryUtils.toCastDouble1D(d);
        return curr;
    }

    private double[][] toMatrix(double[] d) {
        double[][] curr = new double[row][col];
        curr[0] = d;
        return curr;
    }

    public TMatrix setInt2DArrayValue(int[][] d) {
        this.current = FactoryUtils.toCastDouble2D(d);
        this.row = d.length;
        this.col = d[0].length;
        return this;
    }

    public TMatrix setDouble2DArrayValue(double[][] d) {
        this.current = d;
        this.row = d.length;
        this.col = d[0].length;
        return this;
    }

    /**
     * Matrisin transposesini hesaplar.
     *
     * @return
     */
    public TMatrix transpose() {
        this.current = FactoryUtils.transpose(this.current);
        int r = this.row;
        this.row = this.col;
        this.col = r;
        return this;
    }

//    public static void main(String[] args) {
//        int [][]dd={{1,2,3},{4,5,6}};
//        TMatrix tm = TMatrix.getInstance(new int[]{4, 5, 6, 7});
//       int [][]d= tm.setInt2DArrayValue(dd).transpose().toInt2DArrayValue();
//       FactoryUtils.println(d);
//    }
}
