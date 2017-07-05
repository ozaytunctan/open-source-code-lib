/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.matrix;

import com.open.lang.MessageBox;
import com.open.io.InputOutputUtils;
import com.open.utils.FactoryIstatistic;
import com.open.utils.FactoryNormalizerUtils;
import com.open.utils.FactoryUtils;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;

/**
 *
 * @author ozaytunctan13
 */
public class CMat implements Serializable {

    private int row;
    private int col;
    private double[][] mat;
    private CMat cmatrix;
    private long start_time;
    private String name = "Matrix";

    private CMat() {
        this.row = 1;
        this.col = 1;
        this.mat = new double[row][col];
    }

    private CMat(int r, int c) {
        this.row = r;
        this.col = c;
        mat = new double[r][c];
    }

    private CMat(CMat tm) {
        this.col = tm.getColNumber();
        this.row = tm.getRowNumber();
        this.mat = tm.toDoubleArray2D();
    }

    private CMat(double[][] d) {
        this.row = d.length;
        this.col = d[0].length;
        this.mat = new double[row][col];
        this.mat = d;
    }

    private CMat(int[][] d) {
        this.row = d.length;
        this.col = d[0].length;
        this.mat = FactoryUtils.toCastDouble2D(d);
    }

    private CMat(int[] d) {
        this.row = 1;
        this.col = d.length;
        this.mat = toMatrix(d);
    }

    private CMat(short[] d) {
        this.row = 1;
        this.col = d.length;
        double[] ret = FactoryUtils.toDouble1D(d);
        this.mat = toMatrix(ret);
    }

    private CMat(float[] d) {
        this.row = 1;
        this.col = d.length;
        double[] ret = FactoryUtils.toDouble1D(d);
        this.mat = toMatrix(ret);
    }

    private CMat(byte[] d) {
        this.row = 1;
        this.col = d.length;
        double[] ret = FactoryUtils.toDouble1D(d);
        this.mat = toMatrix(ret);
    }

    private CMat(double[] d) {
        this.row = 1;
        this.col = d.length;
        this.mat = toMatrix(d);
    }

    private CMat(ArrayList<double[]> l) {
        double[][] cst = new double[1][1];
        double[][] d = l.toArray(cst);
        this.row = d.length;
        this.col = d[0].length;
        this.mat = d;
    }

    /**
     * row:1 col:1 yeni bir CMat oluşturur.
     *
     * @return
     */
    public static CMat getInstance() {
        return new CMat();
    }

    public CMat build() {
        CMat ret = this.clone(this);
        return ret;
    }

    /**
     *
     * @return
     */
    public static CMat getInstanceFromFile() {
        String file_name = InputOutputUtils.getFileFromChooserLoad().getPath();
        if (file_name == null) {
            MessageBox.showErrorMessage("Dosya secilemedi");
        }
        double[][] m = InputOutputUtils.readFromFileDataDouble(file_name, ",");
        CMat cm = new CMat(m);
        return cm;

    }

    /**
     *
     * @param file_name
     * @return
     */
    public static CMat getInstanceFromFile(String file_name) {
        File f = new File(file_name);
        if (!f.exists()) {
            MessageBox.showErrorMessage("Dosya yolu bulunamadı");
        }
        double[][] m = InputOutputUtils.readFromFileDataDouble(file_name, ",");
        CMat cm = new CMat(m);
        return cm;
    }

    /**
     *
     * @param file_name
     * @param token
     * @return
     */
    public static CMat getInstanceFromFile(String file_name, String token) {
        File f = InputOutputUtils.getFileFromChooserLoad(file_name);
        if (!f.exists()) {
            MessageBox.showErrorMessage("Dosya yolu bulunamadı");
        }
        double[][] m = InputOutputUtils.readFromFileDataDouble(f.getAbsolutePath(), token);
        CMat cm = new CMat(m);
        return cm;
    }

    /**
     *
     * @param l
     * @return
     */
    public static CMat getInstance(ArrayList<double[]> l) {
        return new CMat(l);
    }

    /**
     * row=r ,col=c olmak üzere yeni bir matris oluşturmaktadır.
     *
     * @param r
     * @param c
     * @return
     */
    public static CMat getInstance(int r, int c) {
        if (r == 0 || c == 0) {
            r = 1;
            c = 1;
        }
        return new CMat(r, c);
    }

    /**
     * Parametre olarak aldığı diziyi CMat dizisine atar ve yeni bir matrix
     * oluşturmaktadır.
     *
     * @param d
     * @return
     */
    public static CMat getInstance(int[][] d) {
        return new CMat(d);
    }

    /**
     * Parametre olarak aldığı 1D boyutlu diziyi 2D boyutlu bir diziye atar ve
     * yeni bir matrix oluşturmaktadır.
     *
     * @param d
     * @return CMat
     */
    public static CMat getInstance(int[] d) {
        return new CMat(d);
    }

    /**
     * Parametre olarak aldığı diziyi CMat dizisine atar ve yeni bir matrix
     * oluşturmaktadır.
     *
     * @param d
     * @return
     */
    public static CMat getInstance(double[][] d) {
        return new CMat(d);
    }

    /**
     * Parametre olarak aldığı 1D boyutlu diziyi 2D boyutlu bir diziye atar ve
     * yeni bir matrix oluşturmaktadır.
     *
     * @param d
     * @return
     */
    public static CMat getInstance(double[] d) {
        return new CMat(d);
    }

    public static CMat getInstance(byte[] d) {
        return new CMat(d);
    }

    public static CMat getInstance(short[] d) {
        return new CMat(d);
    }

    public static CMat getInstance(float[] d) {
        return new CMat(d);
    }

    /**
     * Paramtre olarak aldığı
     *
     * @param tm
     * @return
     */
    public static CMat getInstance(CMat tm) {
        return new CMat(tm);

    }

    /**
     * CMat satır sayısını gösterir.
     *
     * @return
     */
    public int getRowNumber() {
        return this.row;
    }

    /**
     * CMat sutun sayısını gösterir.
     *
     * @return
     */
    public int getColNumber() {
        return this.col;
    }

    /**
     * CMat 2D boyutlu bir double diziye atar.
     *
     * @return
     */
    public double[][] toDoubleArray2D() {
        return this.mat;
    }

    public ArrayList<Double> toDoubleList1D() {
        ArrayList<Double> v = new ArrayList<>();
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColNumber(); j++) {
                v.add(this.mat[i][j]);
            }
        }
        return v;
    }

    public ArrayList<Integer> toIntList1D() {
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColNumber(); j++) {
                v.add((int) this.mat[i][j]);
            }
        }
        return v;
    }

    public Integer[] toInteger1D() {
        int[][] d = this.toIntArray2D();
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                v.add(d[i][j]);
            }
        }
        return v.toArray(new Integer[1]);
    }

    public Double[] toDouble1D() {
        double[][] d = this.toDoubleArray2D();
        ArrayList<Double> v = new ArrayList<>();
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColNumber(); j++) {
                v.add(d[i][j]);
            }
        }
        return v.toArray(new Double[1]);
    }

    /**
     * CMat 2D boyutlu bir int diziye atar.
     *
     * @return
     */
    public int[][] toIntArray2D() {
        return FactoryUtils.toCastInt2D(this.mat);
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

    /**
     * Matrisi belirtilen 2D boyutlu parametreyle doldurmaktadır.
     *
     * @param d
     * @return
     */
    public CMat setIntArray2D(int[][] d) {
        this.mat = FactoryUtils.toCastDouble2D(d);
        this.row = d.length;
        this.col = d[0].length;
        return this;
    }

    /**
     * Matrisi belirtilen 1D boyutlu parametreyle doldurmaktadır.
     *
     * @param a
     * @return
     */
    public CMat setDoubleArray1D(double[] a) {
        if (a.length == 0) {
            return new CMat();
        }
        double[][] d = new double[1][a.length];
        for (int i = 0; i < a.length; i++) {
            d[0][i] = a[i];
        }
        this.mat = d;
        return this;
    }

    /**
     * Matrisi belirtilen 1D boyutlu parametreyle doldurmaktadır.
     *
     * @param a
     * @return
     */
    public CMat setIntArray1D(int[] a) {
        if (a.length == 0) {
            return new CMat();
        }
        double[][] d = new double[1][a.length];
        for (int i = 0; i < a.length; i++) {
            d[0][i] = (double) a[i];
        }
        this.mat = d;
        this.row = d.length;
        this.col = d[0].length;
        return this;
    }

    /**
     * Matrisi belirtilen 2D boyutlu parametreyle doldurmaktadır.
     *
     * @param d
     * @return
     */
    public CMat setDoubleArray2D(double[][] d) {
        this.mat = d;
        this.row = d.length;
        this.col = d[0].length;
        return this;
    }

    /**
     * Matrisin kopyasını döndürmektedir.
     *
     * @return
     */
    @Override
    public CMat clone() {
        CMat ret = this.clone(this);
        return ret;
    }

    public CMat clone(CMat cm) {
        CMat ret = new CMat(FactoryMatrix.clone(cm.mat));
        ret.name = cm.name;
        return ret;
    }

    @Override
    public String toString() {
        CMat cm = this.clone();
        String s = "Matrix value of [" + cm.getRowNumber() + "x" + cm.getColNumber() + "]:\n";
        double[][] d = cm.toDoubleArray2D();
        for (int i = 0; i < cm.getRowNumber(); i++) {
            String r = "";
            for (int j = 0; j < cm.getColNumber(); j++) {
                r += d[i][j] + "\t";
            }
            s += r + "\n";
        }
        return s;
    }

    /**
     * Matris eşit olup olmadığını kontrol eder.
     *
     * @param cm
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        boolean ret = false;
        if (obj instanceof CMat) {
            CMat cm = (CMat) obj;
            if (this.getRowNumber() == cm.getRowNumber() && this.getColNumber() == cm.getColNumber()) {
                int r = this.getRowNumber();
                int c = this.getColNumber();
                double[][] cm_mat = cm.toDoubleArray2D();
                stop:
                {
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            if (this.mat[i][j] != cm_mat[i][j]) {
                                break stop;
                            }
                        }
                    }
                    ret = !ret;
                }
            }
        }
        return ret;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Matrisin transposesini hesaplar.
     *
     * @return
     */
    public CMat transpose() {
        if (this.mat.length == 0 || this.mat[0].length == 1) {
            return this;
        }
        this.mat = FactoryUtils.transpose(this.mat);
        int r = this.row;
        this.row = this.col;
        this.col = r;
        return this;
    }

    /**
     * 2 matrisi bit düzeyinde lojik ve uygulanmaktadır. 100&101 =100
     *
     * @param cm
     * @return
     */
    public CMat and(CMat cm) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|and";
        if (cm.getRowNumber() != this.getRowNumber() || cm.getColNumber() != this.getColNumber()) {
            MessageBox.showErrorMessage(this.name, "matrix row and column not equals");
            return ret;
        }
        double[][] d = cm.toDoubleArray2D();
        double[][] d2 = FactoryUtils.and(this.mat.clone(), d.clone());
        ret.setDoubleArray2D(d2);
        return ret;
    }

    /**
     * Matrisin expansiyelini hesaplamaktadır.
     *
     * @return
     */
    public CMat exp() {
        CMat ret = this.clone(this);

        for (int i = 0; i < ret.getRowNumber(); i++) {
            for (int j = 0; j < ret.getColNumber(); j++) {
                ret.mat[i][j] = Math.exp(ret.mat[i][j]);
            }
        }
        ret.name = this.name + "|exp";
        return ret;
    }

    /**
     * 2 matrisi bit düzeyinde lojik özel veya uygulanmaktadır. 100 ^101 =001
     *
     * @param cm
     * @return
     */
    public CMat xor(CMat cm) {
        CMat ret = this.clone();
        ret.name = this.name + "|xor";
        if (cm.getRowNumber() == 0) {
            MessageBox.showErrorMessage("Error matrix window", "Matrix value is null");
            return ret;
        }
        double[][] d = cm.toDoubleArray2D();
        ret.setDoubleArray2D(FactoryUtils.xor(this.mat.clone(), d.clone()));
        return ret;
    }

    /**
     * 2 matrisi bit düzeyinde lojik veya uygulanmaktadır. 100| 101 =101
     *
     * @param cm
     * @return
     */
    public CMat or(CMat cm) {
        CMat ret = this.clone();
        if (cm.getRowNumber() != this.getRowNumber() || cm.getColNumber() != this.getColNumber()) {
            MessageBox.showErrorMessage("Error matrix window", "matrix row and column not equals");
            return ret;
        }
        ret.name = this.name + "|or";
        double[][] d = cm.toDoubleArray2D();
        double[][] d2 = FactoryUtils.or(this.mat.clone(), d.clone());
        ret.setDoubleArray2D(d2);
        return ret;
    }

    /**
     * 2 matrisi bit düzeyinde lojik not uygulanmaktadır. 100~=011
     *
     * @return
     */
    public CMat not() {
        CMat ret = this.clone();
        ret.name = this.name + "|not";
        if (!(this.getRowNumber() > 0)) {
            MessageBox.showErrorMessage("Error matrix window", "Matrix value is null");
            return ret;
        }
        ret.setDoubleArray2D(FactoryUtils.not(this.mat.clone()));
        return ret;

    }

    /**
     * İki matrisi toplar.
     *
     * @param cm
     * @return
     */
    public CMat add(CMat cm) {
        CMat ret = this.clone();
        ret.name = this.name + "|add";
        if (cm.getRowNumber() != this.getRowNumber() || cm.getColNumber() != this.getColNumber()) {
            MessageBox.showErrorMessage("Error matrix window", "matrix row and column not equals");
            return ret;
        }

        double[][] d = cm.toDoubleArray2D();
        double[][] temp = FactoryUtils.add(this.mat.clone(), d.clone());
        ret.setDoubleArray2D(temp);
        return ret;
    }

    /**
     * iki matrisi belirtilen koordinatta toplama yapar.
     *
     * @param cm
     * @param p
     * @return
     */
    public CMat add(CMat cm, Point p) {
        CMat ret = this.clone();
        ret.name = this.name + "|add";
        double[][] d = cm.toDoubleArray2D();
        double[][] temp = FactoryUtils.add(this.mat.clone(), d.clone(), p);
        ret.setDoubleArray2D(temp);
        return ret;
    }

    /**
     * Matrisin değerlerini num ile toplar.
     *
     * @param num
     * @return
     */
    public CMat add(double num) {
        CMat ret = this.clone();
        ret.name = this.name + "|add";
        double[][] temp = this.mat.clone();
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColNumber(); j++) {
                temp[i][j] += num;
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;

    }

    /**
     * 2D boyutlu iki matrisi çarpma işlemi yapar.
     *
     * @param c
     * @return
     */
    public CMat multiply(CMat c) {
        CMat ret = this.clone();
        ret.name = this.name + "|multiply";
        if (c.getRowNumber() != this.getRowNumber() || c.getColNumber() != this.getColNumber()) {
            MessageBox.showErrorMessage("Error matrix window", "matrix row and column not equals");
            return ret;
        }
        double[][] temp = new double[row][col];
        double[][] d = c.clone().toDoubleArray2D();
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColNumber(); j++) {
                temp[i][j] = this.mat[i][j] * d[i][j];
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;
    }

    /**
     * Matrisin değerlerini num ile çarpma yapar.
     *
     * @param num
     * @return
     */
    public CMat multiply(double num) {
        CMat ret = this.clone();
        ret.name = this.name + "|multiply";
        double[][] temp = this.mat.clone();
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColNumber(); j++) {
                temp[i][j] *= num;
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;
    }

    /**
     * 2D boyutlu iki matrisi çıkarma işlemi yapar.
     *
     * @param cm
     * @return
     */
    public CMat subtract(CMat cm) {
        CMat ret = this.clone();
        ret.name = this.name + "|subtract";
        if (cm.getRowNumber() != this.getRowNumber() || cm.getColNumber() != this.getColNumber()) {
            MessageBox.showErrorMessage("Error matrix window", "matrix row and column not equals");
            return ret;
        }
        double[][] temp = this.mat.clone();
        double[][] d = cm.toDoubleArray2D();
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColNumber(); j++) {
                temp[i][j] -= d[i][j];
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;
    }

    /**
     * 2D boyutlu matrisin değerlerinden num değeri çıkarılır.
     *
     * @param num
     * @return
     */
    public CMat subtract(double num) {
        CMat ret = this.clone();
        ret.name = this.name + "|subtract";
        double[][] temp = this.mat.clone();
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColNumber(); j++) {
                temp[i][j] -= num;
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;
    }

    public CMat divide(CMat cm) {
        CMat ret = this.clone();
        ret.name = this.name + "|divide";
        if (cm.getRowNumber() != this.getRowNumber() || cm.getColNumber() != this.getColNumber()) {
            MessageBox.showErrorMessage("Error matrix window", "matrix row and column not equals");
            return ret;
        }
        double[][] temp = this.mat.clone();
        double[][] d = cm.toDoubleArray2D();
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColNumber(); j++) {
                temp[i][j] /= d[i][j];
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;
    }

    public CMat divide(double num) {
        CMat ret = this.clone();
        ret.name = this.name + "|divide";
        double[][] temp = this.mat.clone();
        for (int i = 0; i < this.getRowNumber(); i++) {
            for (int j = 0; j < this.getColNumber(); j++) {
                temp[i][j] /= num;
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;
    }

    public CMat sin() {
        CMat ret = this.clone(this);
        for (int i = 0; i < ret.getRowNumber(); i++) {
            for (int j = 0; j < ret.getColNumber(); j++) {
                ret.mat[i][j] = Math.sin(ret.mat[i][j]);
            }
        }
        ret.name = this.name + "|sin";
        return ret;
    }

    /**
     * t=0 sinc(x) =| |sin(pi*x)/(pi*x) t<>0
     *
     *
     * @return
     */
    public CMat sinc() {
        CMat ret = this.clone(this);

        for (int i = 0; i < ret.getRowNumber(); i++) {
            for (int j = 0; j < ret.getColNumber(); j++) {
                if (ret.mat[i][j] != 0) {
                    ret.mat[i][j] = Math.sin(Math.PI * ret.mat[i][j]) / (Math.PI * ret.mat[i][j]);
                } else {
                    ret.mat[i][j] = 1;
                }

            }
        }
        ret.name = this.name + "|sinc";
        return ret;
    }

    public CMat cos() {
        CMat ret = this.clone(this);
        for (int i = 0; i < ret.getRowNumber(); i++) {
            for (int j = 0; j < ret.getColNumber(); j++) {
                ret.mat[i][j] = Math.cos(ret.mat[i][j]);
            }
        }
        ret.name = this.name + "|cos";
        return ret;
    }

    public CMat tan() {
        CMat ret = this.clone(this);
        for (int i = 0; i < ret.getRowNumber(); i++) {
            for (int j = 0; j < ret.getColNumber(); j++) {
                ret.mat[i][j] = Math.tan(ret.mat[i][j]);
            }
        }
        ret.name = this.name + "|tan";
        return ret;
    }

    public CMat tanh() {
        CMat ret = this.clone(this);
        for (int i = 0; i < ret.getRowNumber(); i++) {
            for (int j = 0; j < ret.getColNumber(); j++) {
                ret.mat[i][j] = Math.tanh(ret.mat[i][j]);
            }
        }
        ret.name = this.name + "|tanh";
        return ret;
    }

    public CMat pow(double us) {
        CMat ret = this.clone();
        ret.name = this.name + "|pow";
        if (this.getRowNumber() == 0) {
            MessageBox.showMessage(ret.name, "Matrix is empty");
            return ret;
        }
        double[][] temp = this.mat.clone();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = Math.pow(temp[i][j], us);
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;

    }

    public CMat sqrt() {
        CMat ret = this.clone();
        ret.name = this.name + "|sqrt";
        if (this.getRowNumber() == 0) {
            MessageBox.showErrorMessage(ret.name, "Matrix is empty");
            return ret;
        }
        double[][] temp = this.mat.clone();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = Math.sqrt(temp[i][j]);
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;
    }

    public CMat tic() {
        start_time = FactoryUtils.tic();
        CMat ret = this.clone();
        return ret;
    }

    public CMat toc() {
        long end_time = FactoryUtils.toc(start_time);
        CMat ret = this.clone();
        return ret;
    }

    /**
     * Matristeki belirtilen satirdaki array silinir.
     *
     * @param row_index
     * @return
     */
    public CMat removeRow(int row_index) {
        CMat cm = this.clone();
        this.name = this.name + "|removeColumn";
        if (row_index < 0 || this.getRowNumber() < row_index) {
            MessageBox.showMessage(name, "İndex numarası aralığın dışında.\nLütfen gecerli indis giriniz");
            return cm;
        }
        int r = this.getRowNumber();
        int c = this.getColNumber();
        double[][] ret = new double[r - 1][c];
        int k = 0, l = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == row_index) {
                    --k;
                    break;
                }
                ret[k][l] = this.mat[i][j];
                l++;
            }
            k++;
            l = 0;
        }
        cm.setDoubleArray2D(ret);
        return cm;
    }

    /**
     * Matristeki belirtilen sutundaki array silinir.
     *
     * @param col_index
     * @return
     */
    public CMat removeColumn(int col_index) {
        CMat cm = this.clone();
        this.name = this.name + "|removeColumn";
        if (col_index < 0 || this.getColNumber() < col_index) {
            MessageBox.showMessage(name, "İndex numarası aralığın dışında.\nLütfen gecerli indis giriniz");
            return cm;
        }
        int r = this.getRowNumber();
        int c = this.getColNumber();
        double[][] temp = FactoryUtils.transpose(this.mat.clone());
        double[][] ret = new double[c - 1][r];
        int k = 0, l = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (i == col_index) {
                    --k;
                    break;
                }
                ret[k][l] = temp[i][j];
                l++;
            }
            l = 0;
            k++;
        }
        cm.setDoubleArray2D(FactoryUtils.transpose(ret));
        return cm;
    }

    /**
     * Matrisi rastgele min ve max aralığında integer değerlerle doldurmaktadır.
     *
     * @param r
     * @param c
     * @param min
     * @param max
     * @return
     */
    public CMat randi(int r, int c, int min, int max) {
        CMat ret = this.clone();
        ret.name = this.name + "|randi";
        int[][] temp = FactoryUtils.randInt2D(r, c, min, max);
        double[][] d = FactoryUtils.toCastDouble2D(temp);
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisi rastgele min ve max aralığında değerlerle doldurmaktadır.
     *
     * @param r
     * @param c
     * @param min
     * @param max
     * @return
     */
    public CMat rand(int r, int c, int min, int max) {
        CMat ret = this.clone();
        ret.name = this.name + "|rand";
        double[][] d = new double[r][c];
        fillRandMat(d, (int) min, (int) max);
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisi rastgele 0-1 aralığında doldurur.
     *
     * @param r
     * @param c
     * @return
     */
    public CMat rand(int r, int c) {
        CMat ret = this.clone();
        ret.name = this.name + "|rand";
        double[][] d = new double[r][c];
        fillRandMat(d);
        ret.setDoubleArray2D(d);
        return ret;
    }

    public CMat randGaussian(int r, int c) {
        double[][] d = new double[r][c];

        SecureRandom sc = new SecureRandom();
        CMat ret = this.clone();
        ret.name = this.name + "|randGaussian";
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                d[i][j] = sc.nextGaussian();
            }
        }
        ret.setDoubleArray2D(d);
        return ret;
    }

    public CMat randGaussian(int r, int c, double min, double max) {
        double[][] d = new double[r][c];
        SecureRandom sc = new SecureRandom();
        CMat ret = this.clone();
        ret.name = this.name + "|randGaussian";
        double delta = (max - min);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                d[i][j] = sc.nextGaussian() * delta + min;
            }
        }
        ret.setDoubleArray2D(d);
        return ret;
    }

    public CMat randGaussian(int r, int c, int min, int max) {
        double[][] d = new double[r][c];
        SecureRandom sc = new SecureRandom();
        CMat ret = this.clone();
        ret.name = this.name + "|randGaussian";
        double delta = (max - min);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                d[i][j] = (int) sc.nextGaussian() * delta + min;
            }
        }
        ret.setDoubleArray2D(d);
        return ret;
    }

    private void fillRandMat(double[][] d, int min, int max) {
        SecureRandom r = new SecureRandom();
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                d[i][j] = min + r.nextDouble() * (max - min);
            }
        }
    }

    private void fillRandMat(double[][] d) {
        SecureRandom r = new SecureRandom();
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                d[i][j] = r.nextDouble();
            }
        }
    }

    /**
     * Matrisin değerlerini belirtilen aralığa taşır.
     *
     * @param from
     * @param to
     * @return
     */
    public CMat map(int from, int to) {
        CMat ret = this.clone();
        ret.name = this.name + "|map";
        double[][] d = FactoryUtils.mapint(this.mat.clone(), from, to);
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisin değerlerini belirtilen aralığa taşır.
     *
     * @param from
     * @param to
     * @return
     */
    public CMat map(double from, double to) {
        CMat ret = this.clone();
        ret.name = this.name + "|map";
        double[][] d = FactoryUtils.map(this.mat.clone(), from, to);
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisin değerlerini yuvarlama yapar 0.5>ise bir üste küçük ise 1 alta
     *
     * @return
     */
    public CMat round() {
        CMat ret = this.clone();
        ret.name = this.name + "|round";
        double[][] d = FactoryUtils.round(this.mat.clone());
        ret.setDoubleArray2D(d);
        return ret;
    }

    public CMat println() {
        FactoryUtils.println(this.mat.clone());
        return this;
    }

    /**
     * Matrisin boş olup olmadığını kotrol eder.
     *
     * @return
     */
    public boolean isEmpty() {
        boolean ret = false;
        if (this.getRowNumber() == 1 || this.getRowNumber() == 1) {
            ret = !ret;
        }

        return ret;
    }

    /**
     * Matrisi 0 ile doldurur.
     *
     * @param r
     * @param c
     * @return
     */
    public CMat zeros(int r, int c) {
        CMat ret = this.clone();
        double[][] d = new double[r][c];
        FactoryUtils.fillIntMatrix(d, 0);
        ret.name = this.name + "|zeros";
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisi 0 ile doldurur.
     *
     * @return
     */
    public CMat zeros() {
        CMat ret = this.clone();
        double[][] d = new double[row][col];
        FactoryUtils.fillIntMatrix(d, 0);
        ret.name = this.name + "|zeros";
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisi 1 ile doldurur.
     *
     * @param r
     * @param c
     * @return
     */
    public CMat ones(int r, int c) {
        CMat ret = this.clone();
        double[][] d = new double[r][c];
        FactoryUtils.fillIntMatrix(d, 1);
        ret.name = this.name + "|ones";
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisi 1 ile doldurur.
     *
     * @return
     */
    public CMat ones() {
        CMat ret = this.clone();
        double[][] d = new double[row][col];
        FactoryUtils.fillIntMatrix(d, 1);
        ret.name = this.name + "|ones";
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisi r satir r sutun kadar belirtilen parametre ile doldurur.
     *
     * @param r
     * @param c
     * @param num
     * @return
     */
    public CMat fillMatrix(int r, int c, int num) {
        CMat ret = this.clone();
        double[][] d = new double[r][c];
        FactoryUtils.fillIntMatrix(d, num);
        ret.name = this.name + "|fillMatrix";
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisi r satir r sutun kadar belirtilen parametre ile doldurur.
     *
     * @param r
     * @param c
     * @param num
     * @return
     */
    public CMat fillMatrix(int r, int c, double num) {
        CMat ret = this.clone();
        double[][] d = new double[r][c];
        FactoryUtils.fillDoubleMatrix(d, num);
        ret.name = this.name + "|fillMatrix";
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisi belirtilen parametre ile doldurur.
     *
     * @param num
     * @return
     */
    public CMat fillMatrix(double num) {
        CMat ret = this.clone();
        double[][] d = new double[row][col];
        FactoryUtils.fillDoubleMatrix(d, num);
        ret.name = this.name + "|fillMatrix";
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Dimension parametresine göre satır veya sutunsal olarak iki matrisi
     * birleştirir dim=1 ise satir ,dim=0 ise sutun
     *
     * @param cm
     * @param dim
     * @return
     */
    public CMat cat(CMat cm, int dim) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|cat";
        if (dim == 1) {
            if (this.getRowNumber() != cm.getRowNumber()) {
                MessageBox.showErrorMessage(this.name, "Matrislerin satır sayıları eşit olmalıdır.");
                return ret;
            }
            double[][] d = FactoryUtils.
                    add(this.toDoubleArray2D(), cm.toDoubleArray2D(), new Point(0, this.getColNumber()));
            ret.setDoubleArray2D(d);
            return ret;
        } else if (dim == 0) {
            if (this.getColNumber() != cm.getColNumber()) {
                MessageBox.showErrorMessage(this.name, "Matrislerin sütun sayıları eşit olmalıdır.");
                return ret;
            }
            double[][] d = FactoryUtils.
                    add(this.toDoubleArray2D(), cm.toDoubleArray2D(), new Point(this.getRowNumber(), 0));
            ret.setDoubleArray2D(d);
            return ret;
        }
        MessageBox.showErrorMessage(this.name, "Dimension sutun için 0 ve satir için 1 olmalıdır.");
        return ret;
    }

    public CMat catFirst(CMat cm, int dim) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|cat";
        if (dim == 1) {
            if (this.getRowNumber() != cm.getRowNumber()) {
                MessageBox.showErrorMessage(this.name, "Matrislerin satır sayıları eşit olmalıdır.");
                return ret;
            }
            double[][] d = FactoryUtils.
                    add(cm.toDoubleArray2D(), this.toDoubleArray2D(), new Point(0, cm.getColNumber()));
            ret.setDoubleArray2D(d);
            return ret;
        } else if (dim == 0) {
            if (this.getColNumber() != cm.getColNumber()) {
                MessageBox.showErrorMessage(this.name, "Matrislerin sütun sayıları eşit olmalıdır.");
                return ret;
            }
            double[][] d = FactoryUtils.
                    add(cm.toDoubleArray2D(), this.toDoubleArray2D(), new Point(cm.getRowNumber(), 0));
            ret.setDoubleArray2D(d);
            return ret;
        }
        MessageBox.showErrorMessage(this.name, "Dimension sutun için 0 ve satir için 1 olmalıdır.");
        return ret;
    }

    /**
     * Matristen belirtilen sutun aralığındaki değerleri döndürmektedir.
     *
     * @param col
     * @return
     */
    public CMat getColumnValue(int col) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|getColumnValue";
        if (col < 0 || col > this.getColNumber() - 1) {

            MessageBox.showErrorMessage(name, "Sutun numarası gecerli değildir.\n Lutfen uygun sutun numarasını giriniz");
            return ret;
        }
        double trans[][] = FactoryUtils.transpose(ret.mat);
        double[] value = trans[col];
        ret.setDoubleArray1D(value);
        return ret.transpose();
    }

    /**
     * Matristen belirtilen sutundaki değerleri döndürmektedir.
     *
     * @param c_from
     * @param c_to
     * @return
     */
    public CMat getColumnValue(int c_from, int c_to) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|getColumnValue";
        if (c_from < 0 || c_to > this.getColNumber() - 1) {

            MessageBox.showErrorMessage(name, "Sutun numarası gecerli değildir.\n Lutfen uygun sutun numarasını giriniz");
            return ret;
        }
        double[][] trans = FactoryUtils.transpose(ret.mat);
        double[][] value = new double[(c_to - c_from) + 1][getRowNumber()];
        int k = -1;
        for (int i = c_from; i <= c_to; i++) {
            value[++k] = trans[i];
        }
        ret.setDoubleArray2D(value);
        return ret.transpose();
    }

    /**
     * Matristen belirtilen satirdaki değerleri döndürmektedir.
     *
     * @param r
     * @return
     */
    public CMat getRowValue(int r) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|getRowValue";
        if (r < 0 || r > this.getRowNumber() - 1) {
            MessageBox.showErrorMessage(name, "Satır numarası geçerli değildir.\n Lutfen uygun satır numarasını giriniz");
            return ret;
        }
        double[][] d = new double[1][ret.getColNumber()];
        d[0] = this.mat[r];
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matristen belirtilen satir aralığındaki değerleri döndürmektedir.
     *
     * @param r_from
     * @param r_to
     * @return
     */
    public CMat getRowValue(int r_from, int r_to) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|getRowValue";
        if (r_from < 0 || r_to > this.getRowNumber() - 1) {
            MessageBox.showErrorMessage(name, "Satır numarası gecerli değildir.\n Lutfen uygun satır numarasını giriniz");
            return ret;
        }
        double[][] value = new double[(r_to - r_from) + 1][this.getColNumber()];
        int k = 0;
        for (int i = r_from; i < r_to + 1; i++) {
            value[k++] = this.mat[i];
        }
        ret.setDoubleArray2D(value);
        return ret;
    }

    /**
     * Matrisin sutun sutun minmax normalizasyonunu uygular.Degerleri
     * (0-1)aralığına çeker. value=number-(min)/(max-min)
     *
     * @return
     */
    public CMat minmax() {
        CMat ret = this.clone();
        ret.name = this.name + "|minmax";
        if (this.getRowNumber() == 0) {
            MessageBox.showErrorMessage(ret.name, "Matrix is empty");
            return ret;
        }
        double[][] temp = FactoryNormalizerUtils.normalizeMinMax(this.mat.clone());
        ret.setDoubleArray2D(temp);
        return ret;
    }

    /**
     * Matrisin minmax normalizasyonunu uygulanmaktadır.Degerler (0-1)aralığına
     * çeker. value=number-(min)/(max-min)
     *
     * @return
     */
    public CMat minmax2D() {
        CMat ret = this.clone();
        ret.name = this.name + "|minmax2D";
        if (this.getRowNumber() == 0) {
            MessageBox.showErrorMessage(ret.name, "Matrix is empty");
            return ret;
        }
        double[][] temp = FactoryNormalizerUtils.normalize2DMinMax(this.mat.clone());
        ret.setDoubleArray2D(temp);
        return ret;
    }

    /**
     * Matrisi yeniden boyutlandırır.
     *
     * @param r
     * @param c
     * @return
     */
    public CMat reshape(int r, int c) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|reshape";
        double[][] ret = FactoryUtils.reshape(this.mat.clone(), r, c);
        cm.setDoubleArray2D(ret);
        return cm;
    }

    /**
     * Matrisi yeniden boyutlandırır.
     *
     * @param cs
     * @return
     */
    public CMat reshape(CSize cs) {
        CMat cm = this.clone().reshape(cs.getWidth(), cs.getHeight());
        cm.name = this.name + "|reshape";
        return cm;
    }

    /**
     * Matrisin mutlak değerini hesaplar.
     *
     * @return
     */
    public CMat abs() {
        CMat cm = this.clone(this);
        cm.name = this.name + "|abs";
        double[][] ret = FactoryUtils.abs(this.mat.clone());
        cm.setDoubleArray2D(ret);
        return cm;
    }

    /**
     * Birim matris oluşturur.
     *
     * @param n
     * @return n*n lik bir matris döner
     */
    public CMat eye(int n) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|eye";
        double[][] ret = CMat.getInstance(n, n).zeros().toDoubleArray2D();
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (k == i) {
                    ret[i][k] = 1.0;
                }
            }
            k++;
        }
        cm.setDoubleArray2D(ret);
        return cm;
    }

    /**
     * Matristeki en büyük değeri bulmaktadır.
     *
     * @return
     */
    public CMat max() {
        CMat ret = this.clone(this);
        ret.name += "|max";
        double max = FactoryUtils.getMaximum(this.mat.clone());
        double[][] d = {{max}};
        ret.setDoubleArray2D(d);
        return ret;

    }

    /**
     * Matristeki en küçük değeri bulmaktadır.
     *
     * @return
     */
    public CMat min() {
        CMat ret = this.clone(this);
        ret.name += "|min";
        double min = FactoryUtils.getMinimum(this.mat.clone());
        double[][] d = {{min}};
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * Matrisin sutunlarının aritmetik ortalaması hesaplanmaktadır.
     *
     * @return
     */
    public CMat mean() {
        double[] r = new double[this.getColNumber()];
        CMat ret = new CMat(r);
        CMat cm = this.clone(this).transpose();
        for (int i = 0; i < cm.getRowNumber(); i++) {
            r[i] = FactoryUtils.avg(cm.mat[i]);
        }
        ret.setDoubleArray1D(r);
        ret.name = this.name + "|std";
        return ret;
    }

    /**
     * Matrixin sutunlar halindeki standart sapması hesaplanmaktadır.
     *
     * @return r adet
     */
    public CMat std() {
        double[] r = new double[this.getColNumber()];
        CMat ret = new CMat(r);
        CMat cm = this.clone(this).transpose();
        for (int i = 0; i < cm.getRowNumber(); i++) {
            r[i] = FactoryUtils.std(cm.mat[i]);
        }
        ret.setDoubleArray1D(r);
        ret.name = this.name + "|std";
        return ret;
    }

    /**
     * Matrisin sutunlarının varyansı hesaplanmaktadır.
     *
     * @return
     */
    public CMat var() {
        double[] r = new double[this.getColNumber()];
        CMat ret = new CMat(r);
        CMat cm = this.clone(this).transpose();
        for (int i = 0; i < cm.getRowNumber(); i++) {
            r[i] = FactoryUtils.var(cm.mat[i]);
        }
        ret.setDoubleArray1D(r);
        ret.name = this.name + "|var";
        return ret;
    }

    /**
     * Matrisin değerlerinin tersini hesaplar. formul:max- d[i][j]
     *
     * @return
     */
    public CMat inverse() {
        CMat ret = this.clone(this);
        ret.name = this.name + "|inverse";
        double max = FactoryUtils.getMaximum(this.mat.clone());
        int r = this.getRowNumber();
        int c = this.getColNumber();
        double[][] temp = new double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = max - this.mat[i][j];
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;
    }

    /**
     * Matrisin histogramını hesaplar.
     *
     * @return int []
     */
    public CMat hist() {
        CMat ret = this.clone(this);
        ret.name = this.name + "|hist";
        int[] h = FactoryUtils.getHistogram(this.mat.clone());
        ret.setIntArray1D(h);
        return ret;
    }

    /**
     * Matrisin 10 tabanında logaritmasını hesaplar.
     *
     * @return
     */
    public CMat log10() {
        CMat ret = this.clone(this);
        ret.name = this.name + "|log10";
        double[][] temp = FactoryUtils.log10(this.mat.clone());
        ret.setDoubleArray2D(temp);
        return ret;
    }

    /**
     * Matrisin 2 tabanında logaritmasını hesaplar.
     *
     * @return
     */
    public CMat log2() {
        CMat ret = this.clone(this);
        ret.name = this.name + "|log2";
        int r = this.getRowNumber();
        int c = this.getColNumber();
        double[][] temp = this.mat.clone();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = FactoryUtils.log2(this.mat[i][j]);
            }
        }
        ret.setDoubleArray2D(temp);
        return ret;
    }

    /**
     * Matrisin logaritmasını hesaplar.
     *
     * @return
     */
    public CMat log() {
        CMat ret = this.clone(this);
        for (int i = 0; i < ret.getRowNumber(); i++) {
            for (int j = 0; j < ret.getColNumber(); j++) {
                ret.mat[i][j] = Math.log(ret.mat[i][j]);
            }
        }
        ret.name = this.name + "|log";
        return ret;
    }

    /**
     * 1 den n kadar bir vektör oluşturur.
     *
     * @param n
     * @return
     */
    public CMat vector(int n) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|vector";
        double[][] d = new double[1][n];
        int num = 1;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = num++;
            }
        }
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * from dan inc miktarı kadar artiş ile to kadar bir vektör oluşturur.
     *
     * @param from
     * @param inc
     * @param to
     * @return
     */
    public CMat vector(double from, double inc, double to) {
        CMat ret = this.clone();
        ret.name = this.name + "|vector";
        if (to < inc) {
            MessageBox.showErrorMessage(ret.name, "to<inc olamaz.");
            return ret;
        }
        if (from > to) {
            MessageBox.showErrorMessage(ret.name, "from>to olamaz.");
            return ret;
        }
        if ((to - from) < inc) {
            MessageBox.showErrorMessage(ret.name, "(to-from)<inc olamaz.");
            return ret;
        }
        double delta = Math.abs(to - from);
        int n = (int) (delta / inc);
        double[][] d = new double[1][n + 1];
        for (int i = 0; i <= n; i++) {
            d[0][i] = from + i * inc;
        }
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * from dan inc miktarı kadar artiş ile to kadar bir vektör oluşturur.
     *
     * @param from
     * @param inc
     * @param to
     * @return
     */
    public CMat vector(int from, int inc, int to) {
        CMat ret = this.clone();
        ret.name = this.name + "|vector";
        if (to < inc) {
            MessageBox.showErrorMessage(ret.name, "to<inc olamaz.");
            return ret;
        }
        if (from > to) {
            MessageBox.showErrorMessage(ret.name, "from>to olamaz.");
            return ret;
        }
        if ((to - from) < inc) {
            MessageBox.showErrorMessage(ret.name, "(to-from)<inc olamaz.");
            return ret;
        }
        int delta = (int) Math.abs(to - from);
        int n = (int) (delta / inc);
        double[][] d = new double[1][n + 1];
        for (int i = 0; i <= n; i++) {
            d[0][i] = from + i * inc;
        }
        ret.setDoubleArray2D(d);
        return ret;
    }

    /**
     * from dan to kadar bir vektör oluşturur.
     *
     * @param from
     * @param to
     * @return
     */
    public CMat vector(int from, int to) {
        CMat ret = this.clone();
        ret.name = this.name + "|vector";
        if (to < from) {
            MessageBox.showErrorMessage(ret.name, "(to-from)<0 olamaz.");
            return ret;
        }
        int inc = from;
        int k = 0;
        double[] d = new double[(int) Math.abs(to - from) + 1];
        for (int i = from; i < (int) to + 1; i++) {
            d[k++] = inc++;
        }
        ret.setDoubleArray1D(d);
        return ret;
    }

    /**
     * from dan to kadar bir vektör oluşturur.
     *
     * @param from
     * @param to
     * @return
     */
    public CMat vector(double from, double to) {
        CMat ret = this.clone();
        ret.name = this.name + "|vector";
        if (to < from) {
            MessageBox.showErrorMessage(ret.name, "(to-from)<0 olamaz.");
            return ret;
        }
        double inc = from;
        int k = 0;
        double[] d = new double[(int) Math.abs(to - from) + 1];
        for (int i = (int) from; i < (int) to + 1; i++) {
            d[k++] = inc++;
        }
        ret.setDoubleArray1D(d);
        return ret;
    }

    /**
     * İki matris arasında DistanceType olarak belirlenen mesafeyi hesaplar.
     * euclidean,cityblock,chessbord vb.
     * ********************************Eksik*********************************
     * *********************** ********************************--------
     *
     ***********************
     * @param c
     * @param distance_type
     * @return
     */
    public CMat distance(CMat c, String distance_type) {
        CMat c1 = this.clone(this);
        c1.name = this.name + "|distance";
        if (c1.getColNumber() != c.getColNumber()) {
            MessageBox.showMessage(c1.name, "Matrisler sutunları eşit değildir.");
            return c1;
        }
        switch (distance_type) {
            case "euclidean":
                double[][] d1 = c.toDoubleArray2D();
                double[][] ret = new double[d1.length][c1.getRowNumber()];
                CMat tm = CMat.getInstance(this.mat.clone());
                for (int i = 0; i < c.getRowNumber(); i++) {
                    ret[i] = FactoryUtils.distanceOklid(tm.clone(), d1[i].clone());
                }
                c1.setDoubleArray2D(ret);
                break;
            case "cityblock":
                double[][] d2 = c.toDoubleArray2D();
                double[][] ret2 = new double[d2.length][c1.getRowNumber()];
                CMat tm2 = CMat.getInstance(this.mat.clone());
                for (int i = 0; i < c.getRowNumber(); i++) {
                    ret2[i] = FactoryUtils.cityBlockDistance(tm2.toDoubleArray2D(), d2[i].clone());
                }
                c1.setDoubleArray2D(ret2);
                break;
            case "chessbord":
                //İçerisi sonra doldurulacak
                break;
            default:
                MessageBox.showErrorMessage(this.name, "Mesafe ölçüsü geçerli değildir.\nDistanceType using");
                break;
        }
        return c1;
    }

    /**
     * Matrix değerlerinin bir dosyaya kaydetmek için yazıldı.
     *
     * @return
     */
    public CMat saveData() {
        CMat cm = this.clone();
        cm.name = this.name + "|saveData";
        if (this.mat != null) {
            JFileChooser FC = new JFileChooser("C:/");
            int ret = FC.showSaveDialog(null);
            if (ret == FC.APPROVE_OPTION) {
                File fileToSave = FC.getSelectedFile();
                InputOutputUtils.writeToFile(fileToSave.getAbsolutePath(), FactoryMatrix.clone(this.mat), false);
            }
        }
        return cm;
    }

    /**
     * Matrix değerlerinin bir dosyaya kaydetmek için yazıldı.
     *
     * @param isappend
     * @return
     */
    public CMat saveData(boolean isappend) {
        CMat cm = this.clone();
        cm.name = this.name + "|saveData";
        if (this.mat != null) {
            JFileChooser FC = new JFileChooser("C:/");
            int ret = FC.showSaveDialog(null);
            if (ret == FC.APPROVE_OPTION) {
                File fileToSave = FC.getSelectedFile();
                InputOutputUtils.writeToFile(fileToSave.getAbsolutePath(), FactoryMatrix.clone(this.mat), isappend);
            }
        }
        return cm;
    }

    /**
     * Matrix değerlerinin bir dosyaya kaydetmek için yazıldı.
     *
     * @param file_name
     * @return
     */
    public CMat saveData(String file_name) {
        CMat cm = this.clone();
        cm.name = this.name + "|saveData";
        if (this.mat != null) {
            File f = new File(file_name);
            if (!f.exists()) {
                MessageBox.showErrorMessage("Dosya yolu bulunamadı");
            }
            InputOutputUtils.writeToFile(file_name, FactoryMatrix.clone(this.mat), false);
        }
        return cm;
    }

    /**
     * Matrixi (0,1) aralığında girilen parametreye göre iki yeni matrix
     * oluturur.örneğin 0.75 girilmesi durumunda %75 birinci matrisi %25 ise
     * ikinci matrisi oluşturur.
     *
     * @param num
     * @return
     */
    public CMat[] splitToTestTrain(double num) {
        CMat[] ct = new CMat[2];
        int r = this.getRowNumber();
        int pos = (int) (r * num);
        CMat cl = this.clone(this);
        ct[0] = cl.getRowValue(0, pos - 1);
        ct[1] = cl.getRowValue(pos, r - 1);
        return ct;
    }

    /**
     * Cmatrixi serileştirmek için yazıldı bu işlem bir classın son durumu
     * kaydedilip istenildiği zaman kaldığı yerden devam ettirmek için
     * yazılmıştır.Sınıf bir txt dosyasına yazılmıştır.
     *
     * @param file_name
     * @return
     */
    public CMat serialize(String file_name) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|serialize";
        File f = InputOutputUtils.getFileFromChooserSave(file_name);
        if (!f.exists()) {
            MessageBox.showErrorMessage(ret.name, "Dosya yolu bulunamadı");
            return ret;
        }
        FactoryUtils.serialize(ret, f.getAbsolutePath());
        return ret;
    }

    /**
     * Kaydedilen Cmatrixi okumak için kaldığı duruma devam etmesi için
     * yazılmıştır.
     *
     * @param file_name
     * @return
     */
    public CMat deSerialize(String file_name) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|deSerialize";
        File f = InputOutputUtils.getFileFromChooserLoad(file_name);
        if (!f.exists()) {
            MessageBox.showErrorMessage(ret.name, "Dosya yolu bulunamadı");
            return ret;
        }
        Object obj = FactoryUtils.deserialize(f.getAbsolutePath());
        if (obj instanceof CMat) {
            return (CMat) obj;
        }

        return ret;
    }

    /**
     * Matrisin değerleri thresold tan küçük ise 0 aksi halde 255 olmaktadır.Bu
     * genelde siyah beyaz resim elde etmek için kullanılır.
     *
     * @param thresold
     * @return
     */
    public CMat thresold(double thresold) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|thresold";
        double[][] ret = cm.toDoubleArray2D();
        int r = ret.length;
        int c = ret[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                double value = ret[i][j];
                if (value < thresold) {
                    ret[i][j] = 0;
                } else {
                    ret[i][j] = 255;
                }

            }
        }
        cm.setDoubleArray2D(ret);
        return cm;
    }

    /**
     * Matrisin değerleri thresold tan küçük ise 0 aksi halde 1 olmaktadır.Bu
     * genelde binary bir resim elde etmek için kullanılır.
     *
     * @param thresold
     * @return
     */
    public CMat thresoldToBinary(double thresold) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|thresoldToBinary";
        double[][] ret = cm.toDoubleArray2D();
        int r = ret.length;
        int c = ret[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                double value = ret[i][j];
                if (value < thresold) {
                    ret[i][j] = 0;
                } else {
                    ret[i][j] = 1;
                }
            }
        }
        cm.setDoubleArray2D(ret);
        return cm;
    }

    /**
     * Matrisin değerleri thresold_min ile thresold_max tan aralığında ise 255
     * aksi halde 0 olmaktadır.Bu genelde belirli bir aralıktaki resimleri siyah
     * beyaz dönüşümü yapmaktadır.
     *
     * @param th_min
     * @param th_max
     * @return
     */
    public CMat thresold(double th_min, double th_max) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|thresold";
        double[][] ret = cm.toDoubleArray2D();
        int r = ret.length;
        int c = ret[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                double value = ret[i][j];
                if (value >= th_min && value < th_max) {
                    ret[i][j] = 255;
                } else {
                    ret[i][j] = 0;
                }

            }
        }
        cm.setDoubleArray2D(ret);
        return cm;
    }

    /**
     * Matrisin değerleri thresold_min den büyük ve thresold_max tan küçük ise
     * newPix aksi halde 0 olmaktadır.Bu genelde belirli bir aralıktaki
     * resimleri istenilen bir değere taşımak için kullanılır.
     *
     * @param th_min
     * @param th_max
     * @param newPix
     * @return
     */
    public CMat thresold(double th_min, double th_max, double newPix) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|thresold";
        double[][] ret = cm.toDoubleArray2D();
        int r = ret.length;
        int c = ret[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                double value = ret[i][j];
                if (value >= th_min && value < th_max) {
                    ret[i][j] = newPix;
                } else {
                    ret[i][j] = 0;
                }
            }
        }
        cm.setDoubleArray2D(ret);
        return cm;
    }

    public CSize getSize() {
        return new CSize(this.getRowNumber(), this.getColNumber());
    }

    /**
     * Bir matriste tepe noktasını bulmak için kullanılır.Matriste ençok bulunan
     * değeri bulmaktadır.
     *
     * @return
     */
    public double getPeakDetection() {
        CMat c = this.clone(this);
        int[] val = FactoryUtils.getHistogram(c.toDoubleArray2D());
        double tepe_nokta = (double) FactoryUtils.getMaximumIndex(val);
        return tepe_nokta;
    }

    /**
     * Matrise jitter oranında görültü bindirmek için kullanılır.
     *
     * @param jitter
     * @return
     */
    public CMat noise(double jitter) {
        CMat ret = this.clone(this);
        ret.name = this.name + "|noise";
        double[][] d = this.toDoubleArray2D();
        int r = d.length;
        int c = d[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                double n = new Random().nextGaussian() * jitter;
                d[i][j] = d[i][j] + n;
            }
        }
        ret.setDoubleArray2D(d);
        return ret;
    }

    public CMat setXY(int i, int j, double value) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|setXY";
        if (this.getRowNumber() > i && this.getColNumber() > j) {
            cm.mat[i][j] = value;
        } else {
            MessageBox.showErrorMessage("Matris için i veya j geçerli değildir.");
        }
        return cm;

    }

    public double getXY(int i, int j) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|setXY";
        double value = -1;
        if (this.getRowNumber() > i && this.getColNumber() > j) {
            value = cm.mat[i][j];
        } else {
            MessageBox.showErrorMessage("Matris için i veya j geçerli değildir.");
        }
        return value;
    }

    public double[] getX(int i, double[] fill) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|getX";
        if (this.getRowNumber() < i) {
            MessageBox.showErrorMessage("Matris için i geçerli değildir.");
            return fill;
        }
        fill = cm.mat[i];
        return fill;
    }

    public double[] getY(int j, double[] fill) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|getY";
        if (this.getColNumber() - 1 < j) {
            MessageBox.showErrorMessage("Matris için j geçerli değildir.");
            return fill;
        }
        cm = cm.transpose();
        fill = cm.mat[j];
        cm.transpose();
        return fill;
    }

    public CMat setX(int i, double[] d) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|setX";
        if (this.getRowNumber() - 1 < i || this.getColNumber() != d.length) {
            MessageBox.showErrorMessage("Matris için i veya d boyutu geçerli değildir.");
            return cm;
        }
        for (int j = i; j < i + 1; j++) {
            for (int k = 0; k < this.getColNumber(); k++) {
                cm.mat[i][k] = d[k];
            }
        }
        return cm;
    }

    public CMat setY(int j, double[] d) {
        CMat cm = this.clone(this);
        cm.name = this.name + "|setY";
        if (this.getColNumber() - 1 < j || this.getRowNumber() != d.length) {
            MessageBox.showErrorMessage("Matris için j veya d boyutu geçerli değildir.");
            return cm;
        }
        cm = cm.transpose();
        cm.mat[j] = d;
        return cm.transpose();
    }

    public CMat subMatrix(CMat m, Point p1, Point p2) {
        int r = m.mat.length;
        int c = m.mat[0].length;
        CMat ret = m;
        if (p1.x < 0 || p1.y < 0 || p1.x > p2.x || p1.y > p2.y || p1.x > r || p1.y > c || p2.x > r || p2.y > c) {
            return null;
        } else {
            double[][] d = new double[p2.x - p1.x][p2.y - p1.y];
            for (int i = p1.x; i < p2.x; i++) {
                for (int j = p1.y; j < p2.y; j++) {
                    d[i - p1.x][j - p1.y] = m.mat[i][j];
                }
            }
            ret.setDoubleArray2D(d);
            ret.name = this.name + "|submatrix";
            return ret;
        }
    }

    public CMat subMatrix(Point p1, Point p2) {
        CMat ret = this.clone(this);
        int r = ret.mat[0].length;
        int c = ret.mat.length;
        if (p1.x < 0 || p1.y < 0 || p1.x > p2.x || p1.y > p2.y || p1.x > r || p1.y > c || p2.x > r || p2.y > c) {
            return null;
        } else {
            double[][] d = new double[p2.y - p1.y][p2.x - p1.x];
            for (int i = p1.x; i < p2.x; i++) {
                for (int j = p1.y; j < p2.y; j++) {
                    d[j - p1.y][i - p1.x] = ret.mat[j][i];
                }
            }
            ret.setDoubleArray2D(d);
            ret.name = this.name + "|submatrix";
            return ret;
        }
    }

    public CMat subMatrix(CPoint p1, CPoint p2) {
        CMat ret = this.clone(this);
        int r = ret.mat[0].length;
        int c = ret.mat.length;
        if (p1.column < 0 || p1.row < 0 || p1.column > p2.column || p1.row > p2.row || p1.column > r || p1.row > c || p2.column > r || p2.row > c) {
            return null;
        } else {
            double[][] d = new double[p2.row - p1.row][p2.column - p1.column];
            for (int i = p1.column; i < p2.column; i++) {
                for (int j = p1.row; j < p2.row; j++) {
                    d[j - p1.row][i - p1.column] = ret.mat[j][i];
                }
            }
            ret.setDoubleArray2D(d);
            ret.name = this.name + "|submatrix";
            return ret;
        }
    }

    public CMat subMatrix(Rectangle rect) {
        Point p1 = new Point(rect.x, rect.y);
        Point p2 = new Point(rect.x + rect.width, rect.y + rect.height);
        return subMatrix(p1, p2);
    }
}
