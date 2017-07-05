/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.utils;

import com.open.matrix.FactoryMatrix;

/**
 *
 * @author ozaytunctan13
 */
public abstract class FactoryClone {

    public static String clone(String str) {
        char krk[] = str.toCharArray();
        return String.copyValueOf(krk);
    }

    public static int[] clone(int[] d) {
        int[] c = new int[d.length];
        System.arraycopy(d, 0, c, 0, c.length);
        return c;
    }

    public static int[][] clone(int[][] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        int c = input[0].length;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(input[i], 0, result[i], 0, c);
        }
        return result;
    }

    public static double[] clone(double[] d) {
        return FactoryMatrix.clone(d);
    }

    public static double[][] clone(double[][] d) {
        return FactoryMatrix.clone(d);
    }

    public static short[] clone(short[] d) {
        return FactoryMatrix.clone(d);
    }

    public static short[][] clone(short[][] d) {
        return FactoryMatrix.clone(d);
    }

    public static byte[] clone(byte[] d) {
        return FactoryMatrix.clone(d);
    }

    public static byte[][] clone(byte[][] d) {
        return FactoryMatrix.clone(d);
    }

    public static long[] clone(long[] d) {
        return FactoryMatrix.clone(d);
    }

    public static long[][] clone(long[][] d) {
        return FactoryMatrix.clone(d);
    }

    public static float[] clone(float[] d) {
        return FactoryMatrix.clone(d);
    }

    public static float[][] clone(float[][] d) {
        return FactoryMatrix.clone(d);
    }

    public static char[] clone(char[] d) {
        return FactoryMatrix.clone(d);
    }

    public static char[][] clone(char[][] d) {
        return FactoryMatrix.clone(d);
    }

    public static String[] clone(String[] d) {
        return FactoryMatrix.clone(d);
    }

    public static String[][] clone(String[][] d) {
        return FactoryMatrix.clone(d);
    }

    static Object[] clone(Object[] r) {
        Object[] c = new Object[r.length];
        System.arraycopy(r, 0, c, 0, c.length);
        return c;
    }
}
