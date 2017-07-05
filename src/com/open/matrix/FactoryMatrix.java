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
public class FactoryMatrix {

    /**
     * ************************************************************************
     * Clone Operation : using fastest method of System.arraycopy()
     * ************************************************************************
     */
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

    public static int[] clone(int[] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        int[] result = new int[r];
        System.arraycopy(input, 0, result, 0, r);
        return result;
    }

    public static double[][] clone(double[][] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        int c = input[0].length;
        double[][] result = new double[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(input[i], 0, result[i], 0, c);
        }
        return result;
    }

    public static double[] clone(double[] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        double[] result = new double[r];
        System.arraycopy(input, 0, result, 0, r);
        return result;
    }

    public static float[][] clone(float[][] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        int c = input[0].length;
        float[][] result = new float[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(input[i], 0, result[i], 0, c);
        }
        return result;
    }

    public static float[] clone(float[] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        float[] result = new float[r];
        System.arraycopy(input, 0, result, 0, r);
        return result;
    }

    public static short[][] clone(short[][] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        int c = input[0].length;
        short[][] result = new short[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(input[i], 0, result[i], 0, c);
        }
        return result;
    }

    public static short[] clone(short[] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        short[] result = new short[r];
        System.arraycopy(input, 0, result, 0, r);
        return result;
    }

    public static long[][] clone(long[][] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        int c = input[0].length;
        long[][] result = new long[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(input[i], 0, result[i], 0, c);
        }
        return result;
    }

    public static long[] clone(long[] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        long[] result = new long[r];
        System.arraycopy(input, 0, result, 0, r);
        return result;
    }

    public static byte[][] clone(byte[][] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        int c = input[0].length;
        byte[][] result = new byte[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(input[i], 0, result[i], 0, c);
        }
        return result;
    }

    public static byte[] clone(byte[] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        byte[] result = new byte[r];
        System.arraycopy(input, 0, result, 0, r);
        return result;
    }

    public static boolean[][] clone(boolean[][] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        int c = input[0].length;
        boolean[][] result = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(input[i], 0, result[i], 0, c);
        }
        return result;
    }

    public static boolean[] clone(boolean[] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        boolean[] result = new boolean[r];
        System.arraycopy(input, 0, result, 0, r);
        return result;
    }

    public static char[][] clone(char[][] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        int c = input[0].length;
        char[][] result = new char[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(input[i], 0, result[i], 0, c);
        }
        return result;
    }

    public static char[] clone(char[] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        char[] result = new char[r];
        System.arraycopy(input, 0, result, 0, r);
        return result;
    }

    public static String[][] clone(String[][] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        int c = input[0].length;
        String[][] result = new String[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(input[i], 0, result[i], 0, c);
        }
        return result;
    }

    public static String[] clone(String[] input) {
        if (input == null) {
            return null;
        }
        int r = input.length;
        String[] result = new String[r];
        System.arraycopy(input, 0, result, 0, r);
        return result;
    }
}
