/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.utils;

import com.open.classification_learning.GroupLabel;
import com.open.matrix.CPoint;
import com.open.lang.MessageBox;
import com.open.lang.StringProc;
import com.open.matrix.CMat;
import com.open.matrix.FactoryMatrix;
import com.open.matrix.TMatrix;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Ozay TUNÇTAN
 * @Computer Engineer ======2017======
 */
public class FactoryUtils {

    /**
     * Metod parametre olarak aldığı primitive değerlere sahip bir listedeki
     * değerleri primitive 2D boyutlu bir diziye dönüştürmektedir.
     *
     * @param list
     * @return
     */
    public static int[][] toInteger2D(ArrayList<int[]> list) {
        int[][] d = new int[1][1];
        return list.toArray(d);
    }

    /**
     * Metod parametre olarak aldığı Double[] bir listedeki değerleri 2D boyutlu
     * double[][] dizisine dönüştürmektedir.
     *
     * @param list
     * @return
     */
    public static double[][] toDouble2D(ArrayList<Double[]> list) {
        Double[][] ret = new Double[1][1];
        return toDouble2D(list.toArray(ret));
    }

    public static double[][] toListDouble2D(ArrayList<double[]> list) {
        double[][] ret = new double[1][1];
        return list.toArray(ret);
    }

    public static int[][] toListInt2D(ArrayList<int[]> list) {
        int[][] ret = new int[1][1];
        return list.toArray(ret);
    }

    /**
     * Metod parametre olarak aldığı Integer[] bir listedeki değerleri 2D
     * boyutlu int[][]dizisine dönüştürmektedir.
     *
     * @param list
     * @return
     */
    public static int[][] toInt2D(ArrayList<Integer[]> list) {
        Integer[][] ret = new Integer[1][1];
        return toInt2D(list.toArray(ret));
    }

    /**
     * Metod parametre olarak aldığı Integer [][] tamsayı içeren nesneyi
     * primitive int [][] dizisine dönüştürmektedir.
     *
     * @param d
     * @return
     */
    public static int[][] toInt2D(Integer[][] d) {
        int r = d.length;
        int c = d[0].length;
        int[][] ret = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = d[i][j].intValue();
            }
        }
        return ret;
    }

    /**
     * Metod parametre olarak aldığı Double [][] sayıları içeren nesneyi
     * primitive double [][] dizisine dönüştürmektedir.
     *
     * @param d
     * @return
     */
    public static double[][] toDouble2D(Double[][] d) {
        int r = d.length;
        int c = d[0].length;
        double[][] ret = new double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = d[i][j].doubleValue();
            }
        }
        return ret;
    }

    public static String[] toString1D(ArrayList<String> list) {
        String[] t = new String[1];
        return list.toArray(t);
    }

    public static String[][] toString2D(ArrayList<String[]> list) {
        String[][] t = new String[1][1];
        return list.toArray(t);
    }

    /**
     * Metod parametre olarak aldığı Double bir listedeki değerleri 1D boyutlu
     * double[]dizisine dönüştürmektedir.
     *
     * @param list
     * @return
     */
    public static double[] toDouble1D(ArrayList<Double> list) {
        int r = list.size();
        double[] ret = new double[r];
        for (int i = 0; i < r; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    /**
     * Metod parametre olarak aldığı Integer bir listedeki değerleri 1D boyutlu
     * int[]dizisine dönüştürmektedir.
     *
     * @param list
     * @return
     */
    public static int[] toInt1D(ArrayList<Integer> list) {
        int r = list.size();
        int[] ret = new int[r];
        for (int i = 0; i < r; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    /**
     * Metod parametre olarak aldığı 2 boyutlu bir diziyi bir boyutlu diziye
     * parse etmektedir.
     *
     * @param d
     * @return
     */
    public static int[] toInt1D(int[][] d) {
        int r = d.length;
        int c = d[0].length;
        int[] ret = new int[r * c];
        int k = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[++k] = d[i][j];
            }
        }
        return ret;
    }

    /**
     * Metod parametre olarak aldığı 2D boyutlu double[][] bir diziyi bir
     * boyutlu double[] diziye parse etmektedir.
     *
     * @param d
     * @return
     */
    public static double[] toDouble1D(double[][] d) {
        int r = d.length;
        int c = d[0].length;
        double[] ret = new double[r * c];
        int k = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[++k] = d[i][j];
            }
        }
        return ret;
    }

    /**
     * Metod 2 parametre almaktadır.Birinci parametre formatlanacak veriyi
     * virgülden sonra ne kadar rakam alınacağını gösterir.
     *
     * @param num
     * @param alinacak_adet
     * @return
     */
    public static double formatDouble(double num, int alinacak_adet) {
        double ret;
        try {
            DecimalFormat fr = new DecimalFormat("#." + FactoryUtils.format(alinacak_adet));
            ret = Double.parseDouble(fr.format(num).replace(",", "."));
            return ret;
        } catch (Exception e) {
            //  e.printStackTrace();
            return -0.000;
        }
    }

    /**
     * Metod double sayının virgülden sonra üç adet rakam alacağını gösterir.
     *
     * @param num
     * @return
     */
    public static double formatDouble(double num) {
        double ret = 0.0f;
        try {
            DecimalFormat fr = new DecimalFormat("#.000");
            ret = Double.parseDouble(fr.format(num).replace(",", "."));
            return ret;
        } catch (Exception e) {
            //  e.printStackTrace();
            return -0.000;
        }
    }

    /**
     * Metod parametre olarak aldığı double dizisini int dizisine cast
     * etmektedir.
     *
     * @param d
     * @return
     */
    public static int[] toCastInt1D(double[] d) {
        int r = d.length;
        int ret[] = new int[r];
        for (int i = 0; i < r; i++) {
            ret[i] = (int) d[i];
        }
        return ret;
    }

    public static Integer[] toCastInt1D(int[] d) {
        int r = d.length;
        Integer ret[] = new Integer[r];
        for (int i = 0; i < r; i++) {
            ret[i] = d[i];
        }
        return ret;
    }

    public static Double[] toCastDouble1D(double[] d) {
        int r = d.length;
        Double ret[] = new Double[r];
        for (int i = 0; i < r; i++) {
            ret[i] = d[i];
        }
        return ret;
    }

    public static int getDigitNumber(double p) {
        NumberFormat formatter = new DecimalFormat();
        formatter = new DecimalFormat("0.######E0");
        String s = formatter.format(p);
        String ss = s.substring(s.indexOf("E") + 1);
        return Integer.parseInt(ss);
    }

    /**
     * Metod parametre olarak aldığı int dizisini double dizisine cast
     * etmektedir.
     *
     * @param d
     * @return
     */
    public static double[] toCastDouble1D(int[] d) {
        int r = d.length;
        double ret[] = new double[r];
        for (int i = 0; i < r; i++) {
            ret[i] = (double) d[i];
        }
        return ret;
    }

    /**
     * Metod parametre olarak aldığı 2 boyutlu double dizisini 2D boyutlu
     * Integer dizisine cast etmektedir.
     *
     * @param d
     * @return
     */
    public static int[][] toCastInt2D(double[][] d) {
        int r = d.length;
        int c = d[0].length;
        int[][] ret = new int[r][c];
        for (int i = 0; i < r; i++) {
            ret[i] = toCastInt1D(d[i]);
        }
        return ret;
    }

    /**
     * Metod parametre olarak aldığı 2 boyutlu int dizisini 2D boyutlu double
     * dizisine cast etmektedir.
     *
     * @param d
     * @return
     */
    public static double[][] toCastDouble2D(int[][] d) {
        int r = d.length;
        int c = d[0].length;
        double[][] ret = new double[r][c];
        for (int i = 0; i < r; i++) {
            ret[i] = toCastDouble1D(d[i]);
        }
        return ret;
    }

    public static void println(int[][] d) {
        int r = d.length;
        int c = d[0].length;
        String print = "Value is(" + r + "X" + c + "):\n";
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c - 1; j++) {
                print += d[i][j] + ",";
            }
            print += d[i][c - 1] + "\n";
        }
        System.out.println(print);
    }

    public static void println(double[][] d) {
        CMat cm = CMat.getInstance(d);
        System.out.println(toString(cm));
    }

    private static String toString(CMat cm) {
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

    public static void println(double[] d) {
        System.out.println(" Array Length:" + d.length + " "
                + Arrays.toString(d));
    }

    public static void println(int[] d) {
        System.out.println(" Array Length:" + d.length + " "
                + Arrays.toString(d));
    }

    /**
     * Metod 2D boyutlu bir dizideki maximum değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static int getMaximum(int[][] d) {
        int r = d.length;
        int max = d[0][0];
        for (int i = 0; i < r; i++) {
            int newMax = getMaximum(d[i]);
            if (max < newMax) {
                max = newMax;
            }
        }
        return max;
    }

    /**
     * Metod 1D boyutlu bir dizideki maximum değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static int getMaximum(int[] d) {
        int r = d.length;
        int max = d[0];
        for (int i = 0; i < r; i++) {
            if (max < d[i]) {
                max = d[i];
            }
        }
        return max;
    }

    /**
     * Metod 2D boyutlu bir dizideki minimum değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static int getMinimum(int[][] d) {
        int r = d.length;
        int min = d[0][0];
        for (int i = 0; i < r; i++) {
            int newMin = getMinimum(d[i]);
            if (min > newMin) {
                min = newMin;
            }
        }
        return min;
    }

    /**
     * Metod 1D boyutlu bir dizideki minimum değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static int getMinimum(int[] d) {
        int r = d.length;
        int min = d[0];
        for (int i = 0; i < r; i++) {
            if (min > d[i]) {
                min = d[i];
            }
        }
        return min;
    }

    /**
     * Metod 2D boyutlu bir dizideki maximum değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static double getMaximum(double[][] d) {
        int r = d.length;
        double max = d[0][0];
        for (int i = 0; i < r; i++) {
            double newMax = getMaximum(d[i]);
            if (max < newMax) {
                max = newMax;
            }
        }
        return max;
    }

    /**
     * Metod 1D boyutlu bir dizideki maximum değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static double getMaximum(double[] d) {
        int r = d.length;
        double max = d[0];
        for (int i = 0; i < r; i++) {
            if (max < d[i]) {
                max = d[i];
            }
        }
        return max;
    }

    /**
     * Metod 2D boyutlu bir dizideki minimum değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static double getMinimum(double[][] d) {
        int r = d.length;
        double min = d[0][0];
        for (int i = 0; i < r; i++) {
            double newMin = getMinimum(d[i]);
            if (min > newMin) {
                min = newMin;
            }
        }
        return min;
    }

    /**
     * Metod 1D boyutlu bir dizideki minimum değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static double getMinimum(double[] d) {
        int r = d.length;
        double min = d[0];
        for (int i = 0; i < r; i++) {
            if (min > d[i]) {
                min = d[i];
            }
        }
        return min;
    }

//    public static <V extends Number> V getMaximum(V[] d, String primitiveType) {
//        int indis=0;
//        switch (primitiveType) {
//            case "int":
//                int r = d.length;
//                int max = d[0].intValue();
//                for (int i = 0; i < r; i++) {
//                    int newMax=d[i].intValue();
//                    if (max < newMax)  {
//                        max = newMax;
//                        indis=i;
//                    }
//                }
//               break;
//            case "short":
//                int rs = d.length;
//                int maxs = d[0].shortValue()Value();
//                for (int i = 0; i < rs; i++) {
//                    int newMax=d[i].intValue();
//                    if (maxs < newMax)  {
//                        maxs = newMax;
//                        indis=i;
//                    }
//                }
//               break;
//        }
//         return d[indis];
//    }
    /**
     * Metod bir dizideki maximum değerin bulunduğu indis değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static int getMaximumIndex(int[] d) {
        int r = d.length;
        int max = d[0];
        int index = 0;
        for (int i = 0; i < r; i++) {
            if (max < d[i]) {
                max = d[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Metod bir dizideki minimum değerin bulunduğu indis değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static int getMinimumIndex(int[] d) {
        int r = d.length;
        int min = d[0];
        int index = 0;
        for (int i = 0; i < r; i++) {
            if (min < d[i]) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Metod paramatre olarak aldığı 2D boyutlu bir dizinin maximum değerinin
     * bulunduğu konumu geri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static CPoint getMaximumIndex(int[][] d) {
        int px = 0, py = 0;
        int r = d.length;
        int c = d[0].length;
        int max = d[0][0];
        CPoint pt = new CPoint(px, py);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int newMax = d[i][j];
                if (max < newMax) {
                    max = newMax;
                    pt.translate(i, j);
                }
            }
        }
        return pt;

    }

    /**
     * Metod paramatre olarak aldığı 2D boyutlu bir dizinin minimum değerinin
     * bulunduğu konumu geri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static CPoint getMinimumIndex(int[][] d) {
        int px = 0, py = 0;
        int r = d.length;
        int c = d[0].length;
        int min = d[0][0];
        CPoint pt = new CPoint(px, py);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int newMin = d[i][j];
                if (min > newMin) {
                    min = newMin;
                    pt.translate(i, j);
                }
            }
        }
        return pt;

    }

    /**
     * Metod bir dizideki maximum değerin bulunduğu indis değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static int getMaximumIndex(double[] d) {
        int r = d.length;
        double max = d[0];
        int index = 0;
        for (int i = 0; i < r; i++) {
            if (max < d[i]) {
                max = d[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Metod bir dizideki minimum değerin bulunduğu indis değeri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static int getMinimumIndex(double[] d) {
        int r = d.length;
        double min = d[0];
        int index = 0;
        for (int i = 0; i < r; i++) {
            if (min > d[i]) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Metod paramatre olarak aldığı 2D boyutlu bir dizinin maximum değerinin
     * bulunduğu konumu geri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static CPoint getMaximumIndex(double[][] d) {
        int px = 0, py = 0;
        int r = d.length;
        int c = d[0].length;
        double max = d[0][0];
        CPoint pt = new CPoint(px, py);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                double newMax = d[i][j];
                if (max < newMax) {
                    max = newMax;
                    pt.translate(i, j);
                }
            }
        }
        return pt;

    }

    /**
     * Metod paramatre olarak aldığı 2D boyutlu bir dizinin minimum değerinin
     * bulunduğu konumu geri döndürmektedir.
     *
     * @param d
     * @return
     */
    public static CPoint getMinimumIndex(double[][] d) {
        int px = 0, py = 0;
        int r = d.length;
        int c = d[0].length;
        double min = d[0][0];
        CPoint pt = new CPoint(px, py);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                double newMin = d[i][j];
                if (min > newMin) {
                    min = newMin;
                    pt.translate(i, j);
                }
            }
        }
        return pt;
    }

    public static int[] getMinimumIndex(double[] d, int ek_adet) {
        ArrayList<Integer> l = new ArrayList<>(ek_adet);
        int r = d.length;
        double max = FactoryUtils.getMaximum(d);
        for (int i = 0; i < ek_adet; i++) {
            int ek_index = FactoryUtils.getMinimumIndex(d);
            d[ek_index] = max;
            l.add(ek_index);
        }
        return FactoryUtils.toInt1D(l);
    }

    public static int[] getMaximumIndex(double[] d, int eb_adet) {
        ArrayList<Integer> l = new ArrayList<>(eb_adet);
        int r = d.length;
        double min = FactoryUtils.getMinimum(d);
        for (int i = 0; i < eb_adet; i++) {
            int ek_index = FactoryUtils.getMaximumIndex(d);
            d[ek_index] = min;
            l.add(ek_index);
        }
        return FactoryUtils.toInt1D(l);
    }

    public static int[] getMinimumIndex(int[] d, int ek_adet) {
        ArrayList<Integer> l = new ArrayList<>(ek_adet);
        int r = d.length;
        int max = FactoryUtils.getMaximum(d);
        for (int i = 0; i < ek_adet; i++) {
            int ek_index = FactoryUtils.getMinimumIndex(d);
            d[ek_index] = max;
            l.add(ek_index);
        }
        return FactoryUtils.toInt1D(l);
    }

    public static int[] getMaximumIndex(int[] d, int eb_adet) {
        ArrayList<Integer> l = new ArrayList<>(eb_adet);
        int r = d.length;
        int min = FactoryUtils.getMinimum(d);
        for (int i = 0; i < eb_adet; i++) {
            int ek_index = FactoryUtils.getMaximumIndex(d);
            d[ek_index] = min;
            l.add(ek_index);
        }
        return FactoryUtils.toInt1D(l);
    }

    /**
     * Method grayscale bir resimdeki pixel değerleri(0-255)arasındaki
     * histogramı hesaplar.
     *
     * @param d
     * @return
     */
    public static double std(double[] d) {
        return FactoryIstatistic.getStandardDeviation(d);
    }

    public static double var(double[] d) {
        return FactoryIstatistic.getVariance(d);
    }

    public static int[] getHistogram(double[][] d) {
        int r = d.length;
        int c = d[0].length;
        int[] hist = new int[256];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int valueIndex = (int) (d[i][j]);
                hist[valueIndex]++;
            }
        }
        return hist;
    }

    /**
     * Metoda parametre olarak gecilen double değerlerin toplamını hesaplar
     *
     * @param p
     * @return
     */
    public static double sum(double... p) {
        double sum_top = 0;
        for (double d : p) {
            sum_top += d;
        }
        return sum_top;
    }

    public static double sum(int... p) {
        int sum_top = 0;
        for (int d : p) {
            sum_top += d;
        }
        return sum_top;
    }

    /**
     * Method bir dizideki ortanca(median) degeri bulur ve geri döndürür.
     *
     * @param kernel
     * @return
     */
    public static int getMedianValue(int[] kernel) {
        int mid = kernel.length / 2;
        Arrays.sort(kernel);
        return kernel[mid];
    }

    /**
     * Method bir dizideki ortanca(median) degeri bulur ve geri döndürür.
     *
     * @param kernel
     * @return
     */
    public static double getMedianValue(double[] kernel) {
        int mid = kernel.length / 2;
        Arrays.sort(kernel);
        return kernel[mid];
    }

    /**
     * Metod 2d boyutlu bir dizinin ortalamsını hesaplar.
     *
     * @param d
     * @return
     */
    public static double avg(int[][] d) {
        int r = d.length;
        int c = d[0].length;
        int sum_m = 0;
        for (int i = 0; i < r; i++) {
            sum_m += sum(d[i]);
        }
        double num = (sum_m / (double) (r * c));
        return FactoryUtils.formatDouble(num);
    }

    /**
     * Metod 2d boyutlu bir dizinin ortalamsını hesaplar.
     *
     * @param d
     * @return
     */
    public static double avg(double[][] d) {
        int r = d.length;
        int c = d[0].length;
        int sum_m = 0;
        for (int i = 0; i < r; i++) {
            sum_m += sum(d[i]);
        }
        double num = (sum_m / (double) (r * c));
        return FactoryUtils.formatDouble(num);
    }

    public static double avg(double[] d) {
        return FactoryUtils.formatDouble((sum(d) / (double) d.length));
    }

    public static double avg(int[] d) {
        return FactoryUtils.formatDouble((sum(d) / (double) d.length));
    }

    /**
     * Metod max-min aralığında n adet bir dizi üretir.
     *
     * @param min
     * @param max
     * @param n
     * @return int[]
     */
    public static int[] randInt1D(int min, int max, int n) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = (int) ((Math.random() * (max - min)) + min);
        }
        return ret;
    }

    /**
     * Metod max-min aralığında r satir c sutun adeti kadar 2D boyutlu dizi
     * üretir.
     *
     * @param r
     * @param c
     * @param min
     * @param max
     * @return int[][]
     */
    public static int[][] randInt2D(int r, int c, int min, int max) {
        int[][] ret = new int[r][c];
        for (int i = 0; i < r; i++) {
            ret[i] = randInt1D(min, max, c);
        }
        return ret;
    }

    /**
     * Metod max-min aralığında n adet bir dizi üretir.
     *
     * @param min
     * @param max
     * @param n
     * @return double[]
     */
    public static double[] randDouble1D(double min, double max, int n) {
        double[] ret = new double[n];
        double delta = (max - min);
        for (int i = 0; i < n; i++) {
            ret[i] = ((Math.random() * (delta)) + min);
        }
        return ret;
    }

    /**
     * Metod max-min aralığında r satir c sutun adeti kadar 2D boyutlu dizi
     * üretir.
     *
     * @param r
     * @param c
     * @param min
     * @param max
     * @return double[][]
     */
    public static double[][] randDouble2D(int r, int c, double min, double max) {
        double[][] ret = new double[r][c];
        for (int i = 0; i < r; i++) {
            ret[i] = randDouble1D(min, max, c);
        }
        return ret;
    }

    /**
     * Metod bir matrisin transposesini alır.
     *
     * @param d
     * @return double[][]
     */
    public static double[][] transpose(double[][] d) {
        int r = d.length;
        int c = d[0].length;
        double[][] ret = new double[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[j][i] = d[i][j];
            }
        }
        return ret;

    }

    /**
     * Burayı icele sıkıntı olabilir
     *
     * @param num
     * @return
     */
    public static double log2(double num) {
        double ret = (Math.log10(num) / num);
        return ret;
    }

    public static double[][] log10(double[][] d) {
        int r = d.length;
        int c = d[0].length;
        double[][] ret = new double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = Math.log10(d[i][j]);
            }
        }
        return ret;
    }

    /**
     * Bir nesneyi(Objeyi) kaydetmek için yazılmıştır.
     *
     * @param obj
     * @param path
     * @return
     *
     */
    public static boolean serialize(Object obj, String path) {
        FileOutputStream fout = null;
        ObjectOutputStream objOut = null;
        try {
            fout = new FileOutputStream(new File(path));
            objOut = new ObjectOutputStream(fout);
            objOut.writeObject(obj);
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FactoryUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fout.close();
                objOut.close();
            } catch (IOException ex) {
                MessageBox.showErrorMessage(ex.getMessage());
            }

        }
        return false;
    }

    /**
     * Kaydedilen nesneyi okumak için yeniden kullanmak için yazılmıştır.Objeyi
     * deserilize etmek için
     *
     * @param filePath
     * @return
     */
    public static Object deserialize(String filePath) {
        FileInputStream fout = null;
        ObjectInputStream objOut = null;
        try {
            fout = new FileInputStream(new File(filePath));
            objOut = new ObjectInputStream(fout);
            Object obj = objOut.readObject();
            return obj;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FactoryUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FactoryUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fout.close();
                objOut.close();
            } catch (IOException ex) {
                MessageBox.showErrorMessage(ex.getMessage());
            }
        }
        return null;
    }

    /**
     * System zamanını göstermektedir.
     *
     * @return
     */
    public static long tic() {
        long currentTime = System.nanoTime();
        return currentTime;
    }

    /**
     * Parametre tic ve o anki zaman farkını milisaniye cinsinden
     * göstermektedir.
     *
     * @param msg
     * @param tic
     * @return
     */
    public static long toc(String msg, long tic) {
        long toc = System.nanoTime();
        double elapsed = (toc - tic) / (1000000.0d);
        System.out.println(msg + elapsed + " miliSecond");
        return toc;
    }

    /**
     * Parametre tic ve o anki zaman farkını milisaniye cinsinden
     * göstermektedir.
     *
     * @param tic
     * @return
     */
    public static long toc(long tic) {
        long toc = System.nanoTime();
        double elapsed = (toc - tic) / (1000000.0d);
        System.out.println("Elapsed Time:" + elapsed + " miliSecond");
        return toc;
    }

    /**
     * Parametre olarak gecilen Matrix ile Array arasındaki oklid uzaklığı
     * hesaplar.Math.sqrt((x2-x1)^2+(y2-y1)^2)
     *
     * @param c1
     * @param t
     * @return
     */
    public static double[] distanceOklid(CMat c1, double[] t) {
        // double[][] d1 = FactoryUtils.extract(c1.clone(), t.clone()).toDoubleArray2D();
        double[][] d1 = c1.toDoubleArray2D();
        int r = d1.length;
        int c = d1[0].length;
        double[] ret = new double[r];
        for (int i = 0; i < r; i++) {
            double sum = 0.00f;
            for (int j = 0; j < c; j++) {
                sum += Math.pow((d1[i][j] - t[j]), 2);
            }
            ret[i] = Math.sqrt(sum);
        }
        return ret;
    }

    /**
     * Parametre olarak gecilen Matrix ile Array arasındaki oklid uzaklığı
     * hesaplar.Math.sqrt((x2-x1)^2+(y2-y1)^2)
     *
     * @param tm
     * @param t
     * @return
     */
    public static double[] distanceOklid(CMat tm, int[] t) {
        double[][] d1 = tm.toDoubleArray2D();
        int r = d1.length;
        int c = d1[0].length;
        double[] ret = new double[r];
        for (int i = 0; i < r; i++) {
            double sum = 0.00f;
            for (int j = 0; j < c; j++) {
                sum += Math.pow(d1[i][j] - t[j], 2.0);
            }
            ret[i] = Math.sqrt(sum);
        }
        return ret;
    }

    /**
     * Matrix ile d dizisi arsındaki farkı hesaplamaktadır.(x2-x1)
     *
     * @param c1
     * @param d
     * @return
     */
    public static CMat extract(CMat c1, int[] d) {
        if (c1.getColNumber() != d.length) {
            MessageBox.showErrorMessage("Uyarı Penceresi", "Column Number Value Not Equals !");
            return CMat.getInstance();
        } else {
            double[][] d1 = c1.clone().toDoubleArray2D();
            double[][] ret = d1.clone();
            int r = c1.getRowNumber();
            int c = c1.getColNumber();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ret[i][j] = d1[i][j] - d[j];
                }
            }
            return CMat.getInstance(ret);
        }
    }

    /**
     * Matrix ile d dizisi arsındaki farkı hesaplamaktadır.(x2-x1)
     *
     * @param c1
     * @param d
     * @return
     */
    public static CMat extract(CMat c1, double[] d) {
        if (c1.getColNumber() != d.length) {
            MessageBox.showErrorMessage("Uyarı Penceresi", "Column Number Value Not Equals !");
            return CMat.getInstance();
        } else {
            double[][] d1 = c1.clone().toDoubleArray2D();
            double[][] ret = d1.clone();
            int r = c1.getRowNumber();
            int c = c1.getColNumber();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ret[i][j] = d1[i][j] - d[j];
                }
            }
            return CMat.getInstance(ret);
        }
    }

    /**
     * Bir diziyi küçükten büyüğe doğru sıralamaktadır.
     *
     * @param d
     * @return
     */
    public static int[] sort(int[] d) {
        int n = d.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (d[i] > d[j]) {
                    int temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }

            }
        }
        return d;
    }

    /**
     * Bir diziyi küçükten büyüğe doğru sıralamaktadır.
     *
     * @param d
     * @return
     */
    public static double[] sort(double[] d) {
        int n = d.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (d[i] > d[j]) {
                    double temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }

        }
        return d;
    }

    /**
     * Bir diziyi büyükten küçüğe doğru sıralamaktadır.
     *
     * @param d
     * @return
     */
    public static int[] asort(int[] d) {
        int n = d.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (d[i] < d[j]) {
                    int temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }

            }
        }
        return d;
    }

    /**
     * Bir diziyi büyükten küçüğe doğru sıralamaktadır.
     *
     * @param d
     * @return
     */
    public static double[] asort(double[] d) {
        int n = d.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (d[i] < d[j]) {
                    double temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }

        }
        return d;
    }

    /**
     * Bir dizide bir eleman aranmaktadır.Bulduğunda index ini aksi halde -1
     * değerini döndürmektedir.
     *
     * @param d
     * @param search
     * @return
     */
    public static int search(int[] d, int search) {
        int n = d.length;
        int ret = -1;
        for (int i = 0; i < n; i++) {
            if (d[i] == search) {
                ret = i;
            }
        }
        return ret;
    }

    /**
     * Bir dizide bir eleman aranmaktadır.Bulduğunda index ini aksi halde -1
     * değerini döndürmektedir.
     *
     * @param d
     * @param search
     * @return
     */
    public static int search(double[] d, double search) {
        int n = d.length;
        int ret = -1;
        for (int i = 0; i < n; i++) {
            if (d[i] == search) {
                ret = i;
                return ret;
            }
        }
        return ret;
    }

    /**
     * Bir dizide son elemandan başlanarak arama yapılmaktadır.Elemanı
     * bulduğunda index ini aksi halde -1 değerini döndürmektedir.
     *
     * @param d
     * @param search
     * @return
     */
    public static int lastSearch(int[] d, int search) {
        int n = d.length - 1;
        int ret = -1;
        for (int i = n; i >= 0; i--) {
            if (d[i] == search) {
                ret = i;
                return ret;
            }
        }
        return ret;
    }

    /**
     * Bir dizide son elemandan başlanarak arama yapılmaktadır.Elemanı
     * bulduğunda index ini aksi halde -1 değerini döndürmektedir.
     *
     * @param d
     * @param search
     * @return
     */
    public static int lastSearch(double[] d, double search) {
        int n = d.length - 1;
        int ret = -1;
        for (int i = n; i >= 0; i--) {
            if (d[i] == search) {
                ret = i;
                return ret;
            }
        }
        return ret;
    }

    private static String format(int alinacak_adet) {
        String str = "";
        for (int i = 0; i < alinacak_adet; i++) {
            str += "0";
        }
        return str;
    }

    /**
     * d dizisini from to aralığına çeker.
     *
     * @param d
     * @param from
     * @param to
     * @return
     */
    public static double[] map(double[] d, int from, int to) {
        double[] norm = FactoryNormalizerUtils.
                normalizeWith1DRange(d.clone(), from, to);
        return norm;
    }

    public static double[] map(double[] d, double from, double to) {
        double[] norm = FactoryNormalizerUtils.
                normalizeWith1DRange(d.clone(), from, to);
        return norm;
    }

    /**
     * d dizisini from to aralığına çeker.
     *
     * @param d
     * @param from
     * @param to
     * @return
     */
    public static double[][] map(double[][] d, double from, double to) {
        double[][] ret = FactoryNormalizerUtils.normalizeWith2DRange(d, from, to);
        return ret;
    }

    public static double[][] mapint(double[][] d, int from, int to) {
        double[][] ret = FactoryNormalizerUtils.normalizeWith2DRange(d, from, to);
        double[][] temp = ret.clone();
        int r = d.length;
        int c = d[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = (int) ret[i][j];
            }
        }

        return temp;
    }

    /**
     * d dizisini yeniden boyutlandırmaktadır.
     *
     * @param d
     * @param n
     * @return n boyutunda bir dizi dönmektedir
     */
    public static double[] reshape(double[] d, int n) {

        if (n > 0) {
            int r = d.length;
            double[] ret = new double[n];
            if (n < r) {
                for (int i = 0; i < n; i++) {
                    ret[i] = d[i];
                }
                return ret;
            } else {
                for (int i = 0; i < r; i++) {
                    ret[i] = d[i];
                }
                return ret;
            }
        } else {
            try {
                MessageBox.showErrorMessage("Error Window",
                        Class.forName("com.open.utils.FactoryUtils").toString() + ".reshape" + "\n n<0 geçerli değildir.");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FactoryUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return d;
    }

    /**
     * d dizisini yeniden boyutlandırmaktadır.
     *
     * @param d
     * @param r
     * @param c
     * @return r satir ve c sutun boyutunda 2D bir dizi döner.
     */
    public static double[][] reshape(double[][] d, int r, int c) {
        int nr = d.length;
        int nc = d[0].length;
        if (r > 0 && c > 0) {
            double[][] ret = new double[r][c];
            if (r > nr) {
                for (int i = 0; i < nr; i++) {
                    ret[i] = FactoryUtils.reshape(d[i], c);
                }
            } else {
                for (int i = 0; i < r; i++) {
                    ret[i] = FactoryUtils.reshape(d[i], c);
                }
            }
            return ret;
        } else {
            try {
                MessageBox.showErrorMessage("Error Window",
                        Class.forName("com.open.utils.FactoryUtils").toString() + ".reshape" + "\n row<0 geçerli değildir.");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
        }
        return d;
    }

    /**
     * d dizisini yeniden boyutlandırmaktadır.
     *
     * @param d
     * @param n
     * @return n boyutunda bir dizi dönmektedir
     */
    public static int[] reshape(int[] d, int n) {

        if (n > 0) {
            int r = d.length;
            int[] ret = new int[n];
            if (n < r) {
                for (int i = 0; i < n; i++) {
                    ret[i] = d[i];
                }
                return ret;
            } else {
                for (int i = 0; i < r; i++) {
                    ret[i] = d[i];
                }
                return ret;
            }
        } else {
            try {
                MessageBox.showErrorMessage("Error Window",
                        Class.forName("com.open.utils.FactoryUtils").toString() + ".reshape" + "\n n<0 geçerli değildir.");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FactoryUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return d;
    }

    /**
     * d dizisini yeniden boyutlandırmaktadır.
     *
     * @param d
     * @param r
     * @param c
     * @return r satir ve c sutun boyutunda 2D bir dizi döner.
     */
    public static int[][] reshape(int[][] d, int r, int c) {
        int nr = d.length;
        int nc = d[0].length;
        if (r > 0 && c > 0) {
            int[][] ret = new int[r][c];
            if (r > nr) {
                for (int i = 0; i < nr; i++) {
                    ret[i] = FactoryUtils.reshape(d[i], c);
                }
            } else {
                for (int i = 0; i < r; i++) {
                    ret[i] = FactoryUtils.reshape(d[i], c);
                }
            }
            return ret;
        } else {
            try {
                MessageBox.showErrorMessage("Error Window",
                        Class.forName("com.open.utils.FactoryUtils").toString() + ".reshape" + "\n row<0 geçerli değildir.");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage());
            }
        }
        return d;
    }

    /**
     *
     * @param d
     * @return (x1*x1)+(y1*y1) karekökü
     */
    public static double getMagnitude(double[] d) {
        double t = 0;
        for (int i = 0; i < d.length; i++) {
            t += d[i] * d[i];
        }
        return Math.sqrt(t);
    }

    public static double getMagnitude(int[] d) {
        double t = 0;
        for (int i = 0; i < d.length; i++) {
            t += d[i] * d[i];
        }
        return Math.sqrt(t);
    }

    public static double getMagnitude(float[] d) {
        double t = 0;
        for (int i = 0; i < d.length; i++) {
            t += d[i] * d[i];
        }
        return Math.sqrt(t);
    }

    public static double getMagnitude(byte[] d) {
        double t = 0;
        for (int i = 0; i < d.length; i++) {
            t += d[i] * d[i];
        }
        return Math.sqrt(t);
    }

    /**
     * 2D boyutlu iki diziyi belirtilen koardinatta ust uste eklemektedir.
     *
     * @param d1
     * @param d2
     * @param p
     * @return
     */
    public static double[][] add(double[][] d1, double[][] d2, Point p) {
        int mr, mc;
        int r = d1.length;
        int c = d1[0].length;
        if (r == d2.length + p.x) {
            mr = r;
        } else {
            mr = d2.length + p.x;
        }
        if (c == d2[0].length + p.y) {
            mc = c;
        } else {
            mc = d2[0].length + p.y;
        }
        double[][] ret = new double[mr][mc];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = d1[i][j];
            }
        }
        int k = 0, l = 0;
        for (int i = p.x; i < mr; i++) {
            for (int j = p.y; j < mc; j++) {
                ret[i][j] = d2[k][l++];
            }
            l = 0;
            k++;
        }
        return ret;
    }

    /**
     * 2D boyutlu iki diziyi ust uste eklemektedir.
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double[][] add(double[][] d1, double[][] d2) {
        int r = d1.length;
        int c = d1[0].length;

        if (r == d2.length && c == d2[0].length) {
            double[][] ret = new double[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ret[i][j] = d1[i][j] + d2[i][j];
                }
            }
            return ret;
        } else {
            MessageBox.showErrorMessage("Error Window", FactoryUtils.class.toString() + ".add \n Array 2D row and column not equals");
            return d1;
        }
    }

    /**
     * 2D boyutlu iki diziyi bit düzeyinde xor uygulamaktadır.
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double[][] xor(double[][] d1, double[][] d2) {
        int r = d1.length;
        int c = d1[0].length;

        if (r == d2.length && c == d2[0].length) {
            double[][] ret = new double[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ret[i][j] = ((int) d1[i][j]) ^ ((int) d2[i][j]);
                }
            }
            return ret;
        } else {
            MessageBox.showErrorMessage("Error Window", FactoryUtils.class.toString() + ".xor \n Array 2D row and column not equals");
            return d1;
        }
    }

    /**
     * 2D boyutlu diziyi bit düzeyinde not işlemini uygulamaktadır.
     *
     * @param d1
     * @return
     */
    public static double[][] not(double[][] d1) {
        int r = d1.length;
        int c = d1[0].length;
        double[][] ret = new double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = ~(int) d1[i][j];
            }
        }
        return ret;

    }

    /**
     * 2D boyutlu iki diziyi bit düzeyinde or uygulamaktadır.
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double[][] or(double[][] d1, double[][] d2) {
        int r = d1.length;
        int c = d1[0].length;

        if (r == d2.length && c == d2[0].length) {
            double[][] ret = new double[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ret[i][j] = ((int) d1[i][j]) | ((int) d2[i][j]);
                }
            }
            return ret;
        } else {
            MessageBox.showErrorMessage("Error Window", FactoryUtils.class.toString() + ".or \n Array 2D row and column not equals");
            return d1;
        }
    }

    /**
     * 2D boyutlu iki diziyi bit düzeyinde and uygulamaktadır.
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double[][] and(double[][] d1, double[][] d2) {
        int r = d1.length;
        int c = d1[0].length;
        if (r == d2.length && c == d2[0].length) {
            double[][] ret = new double[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    ret[i][j] = ((int) d1[i][j]) & ((int) d2[i][j]);
                }
            }
            return ret;
        } else {
            MessageBox.showErrorMessage("Error Window", FactoryUtils.class.toString() + ".and \n Array 2D row and column not equals");
            return d1;
        }
    }

    /**
     *
     * @param d
     * @return
     */
    public static double[][] toDouble2D(double[] d) {
        int r = d.length;
        double[][] ret = new double[1][r];
        for (int i = 0; i < r; i++) {
            ret[0][i] = d[i];
        }
        return ret;
    }

    /**
     *
     * @param d
     * @return
     */
    public static int[][] toInt2D(int[] d) {
        int r = d.length;
        int[][] ret = new int[1][r];
        for (int i = 0; i < r; i++) {
            ret[0][i] = d[i];
        }
        return ret;
    }

    /**
     *
     * @param d
     * @return
     */
    public static double[] toDouble1D(short[] d) {
        int n = d.length;
        double[] ret = new double[n];
        for (int i = 0; i < n; i++) {
            ret[i] = (double) d[i];
        }
        return ret;
    }

    /**
     *
     * @param d
     * @return
     */
    public static double[] toDouble1D(float[] d) {
        int n = d.length;
        double[] ret = new double[n];
        for (int i = 0; i < n; i++) {
            ret[i] = (double) d[i];
        }
        return ret;
    }

    /**
     *
     * @param d
     * @return
     */
    public static double[] toDouble1D(byte[] d) {
        int n = d.length;
        double[] ret = new double[n];
        for (int i = 0; i < n; i++) {
            ret[i] = (double) d[i];
        }
        return ret;
    }

    /**
     *
     * @param d
     * @return
     */
    public static int[] toInt1D(double[][] d) {
        int r = d.length;
        int c = d[0].length;
        int[] ret = new int[r * c];
        int k = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[++k] = (int) d[i][j];
            }
        }
        return ret;
    }

    /**
     *
     * @param d
     * @return
     */
    public static double[][] round(double[][] d) {
        double[][] ret = d.clone();
        int r = d.length;
        int c = d[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = Math.round(d[i][j]);
            }
        }
        return ret;
    }

    /**
     *
     * @param d
     * @param num
     */
    public static void fillIntMatrix(double[][] d, int num) {
        int r = d.length;
        int c = d[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                d[i][j] = num;
            }
        }
    }

    /**
     *
     * @param d
     * @param num
     */
    public static void fillDoubleMatrix(double[][] d, double num) {
        int r = d.length;
        int c = d[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                d[i][j] = num;
            }
        }
    }

    public static double[] getColumnArray(double[][] d, int col) {
        int r = d.length;
        double[] ret = new double[r];
        for (int i = 0; i < r; i++) {
            for (int j = col; j < col + 1; j++) {
                ret[i] = d[i][j];
            }
        }
        return ret;
    }

    public static double[][] getColumn2DArray(double[][] d, int col) {
        double[] rt = FactoryUtils.getColumnArray(d, col);
        double[][] ret = FactoryUtils.toDouble2D(rt);
        return FactoryUtils.transpose(ret);
    }

    public static double[][] getColumn2DArray(double[][] d, int col1, int col2) {
        int col = col2 - col1;
        int r = d.length;
        double[][] ret = new double[r][col + 1];
        int k = 0;
        for (int i = col1; i < col2 + 1; i++) {
            ret[k++] = FactoryUtils.getColumnArray(d, i);
        }
        return FactoryUtils.transpose(ret);
    }

    public static int[] getColumnArray(int[][] d, int col) {
        int r = d.length;
        int[] ret = new int[r];
        for (int i = 0; i < r; i++) {
            for (int j = col; j < col + 1; j++) {
                ret[i] = d[i][j];
            }
        }
        return ret;
    }

    public static int[][] getColumn2DArray(int[][] d, int col) {
        int[] rt = FactoryUtils.getColumnArray(d, col);
        int[][] ret = FactoryUtils.toInt2D(rt);
        return ret;
    }

    public static double[] cityBlockDistance(double[][] d, double[] t) {

        double[][] d1 = FactoryMatrix.clone(d);
        int r = d1.length;
        int c = d1[0].length;
        double[] ret = new double[r];
        for (int i = 0; i < r; i++) {
            double sum = 0.00f;
            for (int j = 0; j < c; j++) {
                sum += Math.abs(d1[i][j] - t[j]);
            }
            double distance = sum;
            ret[i] = distance;
        }
        return ret;
    }

    public static double[][] abs(double[][] d) {
        int r = d.length;
        int c = d[0].length;
        double[][] ret = new double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = Math.abs(d[i][j]);
            }
        }
        return ret;
    }

    public static String getFileExtension(File file) {
        String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf('.') + 1);
        return extension;
    }

    public static String getFileExtension(String str) {
        String extension = str.substring(str.lastIndexOf('.') + 1);
        return extension;
    }

    public static int getFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    public static int getSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + getSum(n - 1);
    }

    public static int[] getHistogramUTFAlphabetic(String metin) {
        char c[] = metin.toCharArray();
        int[] hist = new int[256];
        for (int i = 0; i < c.length; i++) {
            int value = (int) c[i];
            hist[value]++;
        }
        return hist;
    }

    public static String replaceAll(String str, String reg, String replace) {
        String ret = str.replaceAll(reg, replace);
        return ret;
    }

    public static String removeAll(String str, String remove) {
        if (str.length() < remove.length()) {
            MessageBox.showErrorMessage("String katarlarının boyutları eşleşmiyor.");
            return str;
        }
        StringProc ret = new StringProc(str);
        return ret.removeAll(remove);
    }

    public static String[] toHece(String s, int n) {
        if (s.length() < n) {
            MessageBox.showErrorMessage("String katarlarının boyutları eşleşmiyor.");
            return null;
        }
        StringProc ret = new StringProc(s);
        return ret.toHece(n);
    }

    public static int[] indexOfAll(String s, String search) {
        int[] ret = new int[1];
        if (s.length() < search.length()) {
            MessageBox.showErrorMessage("String katarlarının boyutları eşleşmiyor.");
            return ret;
        }
        StringProc sp = new StringProc(s);
        return sp.indexOfAll(s);
    }

    public static HashMap<String, Integer> nGram(String s, int n) {
        HashMap<String, Integer> hm = new HashMap<>();
        if (s.length() < n) {
            MessageBox.showErrorMessage("String katarlarının boyutları eşleşmiyor.");
            return hm;
        }
        StringProc ret = new StringProc(s);
        return ret.nGramCount(n);
    }

    public static int getGroupCount(String str, String grup) {
        if (str.length() < grup.length()) {
            MessageBox.showErrorMessage("String katarlarının boyutları eşleşmiyor.");
            return -1;
        }
        StringProc ret = new StringProc(str);

        return ret.groupCount(grup);
    }

    public static Object getKnnClassify(GroupLabel trainLabel, int[] index_min) {
        int adet = 0;
        Object[] r = trainLabel.getLabel();
        Object[] res = FactoryClone.clone(r);
        ArrayList<Object> list = getToValueIndex(res, index_min);
        Object[] unik = FactoryUtils.getToUniqueList(list.toArray());
        int[] c = new int[unik.length];
        if (unik.length == 1) {
            return unik[0];
        }
        for (int j = 0; j < c.length; j++) {
            Object val = unik[j];
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == val) {
                    c[j]++;
                }
            }
        }
        return unik[FactoryUtils.getMaximumIndex(c)];
    }

    private static ArrayList<Object> getToValueIndex(Object[] obj, int[] index_min) {
        ArrayList<Object> l = new ArrayList<>();
        for (int i = 0; i < index_min.length; i++) {
            l.add(obj[index_min[i]]);
        }
        return l;
    }

    public static Object[] getToUniqueList(Object[] list) {
        ArrayList<Object> l = new ArrayList<>(list.length);
        for (int i = 0; i < list.length; i++) {
            Object v = list[i];
            int var = -1;
            if (i == 0) {
                l.add(v);
            }
            Object[] add = l.toArray(new Object[1]);
            Arrays.sort(add);
            var = Arrays.binarySearch(add, v);
            if (var < 0) {
                if (i != 0) {
                    l.add(v);
                }
            }
        }

        return l.toArray(new Object[1]);
    }

    public static int[] getToIntUnique1D(int[] d1) {
        ArrayList<Integer> l = new ArrayList<>(d1.length);
        int d[] = FactoryClone.clone(d1);
        for (int i = 0; i < d.length; i++) {
            int v = d[i];
            int var = -1;
            if (i == 0) {
                l.add(v);
            }
            Integer[] add = l.toArray(new Integer[1]);
            Arrays.sort(add);
            var = Arrays.binarySearch(add, v);
            if (var < 0) {
                if (i != 0) {
                    l.add(v);
                }
            }
        }

        return FactoryUtils.toInt1D(l);
    }

    public static double[] getToDoubleUnique1D(double[] d1) {
        ArrayList<Double> l = new ArrayList<>(d1.length);
        double d[] = FactoryClone.clone(d1);
        for (int i = 0; i < d.length; i++) {
            double v = d[i];
            int var = -1;
            if (i == 0) {
                l.add(v);
            }
            Double[] add = l.toArray(new Double[1]);
            Arrays.sort(add);
            var = Arrays.binarySearch(add, v);
            if (var < 0) {
                if (i != 0) {
                    l.add(v);
                }
            }
        }

        return FactoryUtils.toDouble1D(l);
    }

    public static void main(String[] args) {
        int[] d = {4, 5, 6, 8, 1, 2, 3, 4, 8, 1, 2};
        System.out.println(Arrays.toString(FactoryUtils.sort(d)));
    }

    public static double[] fill(double[] d, double[] fill) {
        fill = new double[d.length];
        for (int i = 0; i < d.length; i++) {
            fill[i] = d[i];
        }
        return fill;
    }
}
