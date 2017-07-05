/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.utils;

import java.util.Arrays;

/**
 *
 * @author ozaytunctan13
 */
public class FactoryNormalizerUtils {

    public static double[][] normalizeTanH(double[][] p) {
        double[][] ret = FactoryUtils.transpose(p.clone());
        for (int i = 0; i < ret.length; i++) {
            ret[i] = normalizeTanH(ret[i]);
        }
        ret = FactoryUtils.transpose(ret);
        return ret;
    }

    public static double[] normalizeTanH(double[] v) {
        double[] ret = v.clone();
        double mean = FactoryUtils.avg(v);
        double std = FactoryIstatistic.getStandardDeviation(v);
        for (int i = 0; i < v.length; i++) {
            ret[i] = FactoryUtils.formatDouble(0.5 * (Math.tanh(0.01 * ((v[i] - mean) / std)) + 1));
        }
        return ret;
    }

    public static double[][] normalizeSigmoidal(double[][] p) {
        double[][] ret = FactoryUtils.transpose(p.clone());
        for (int i = 0; i < ret.length; i++) {
            ret[i] = normalizeSigmoidal(ret[i]);
        }
        ret = FactoryUtils.transpose(ret);
        return ret;
    }

    public static double[] normalizeSigmoidal(double[] v) {
        double[] ret = v.clone();
        for (int i = 0; i < v.length; i++) {
            ret[i] = FactoryUtils.formatDouble(1.0 / (1 + Math.exp(-v[i])));
        }
        return ret;
    }

    public static double[][] normalizeMinMax(double[][] p) {
        double[][] ret = FactoryUtils.transpose(p.clone());
        for (int i = 0; i < ret.length; i++) {
            ret[i] = normalizeMinMax(ret[i]);
        }
        ret = FactoryUtils.transpose(ret);
        return ret;
    }

//    public static float[][] normalizeMinMax(float[][] p) {
//        float[][] ret = FactoryUtils.transpose(p.clone()));
//        for (int i = 0; i < ret.length; i++) {
//            ret[i] = normalizeMinMax(ret[i]);
//        }
//        ret = FactoryUtils.transpose(ret);
//        return ret;
//    }
    public static int[] normalizeMinMax(int[] p) {
        int min = FactoryUtils.getMinimum(p);
        int max = FactoryUtils.getMaximum(p);
        int[] r = new int[p.length];
        int delta = (max - min);
        for (int i = 0; i < p.length; i++) {
            r[i] = (p[i] - min) / delta;
        }
        return r;
    }

    public static double[] normalizeMinMax(double[] v) {
        double[] ret = v.clone();
        double min = FactoryUtils.getMinimum(v);
        double max = FactoryUtils.getMaximum(v);
        double delta = (max - min);
        for (int i = 0; i < v.length; i++) {
            ret[i] = FactoryUtils.formatDouble((v[i] - min) / delta);
        }
        return ret;
    }

    public static double[][] normalize2DMinMax(double[][] p) {
        double[][] ret = p.clone();
        int r = ret.length;
        int c = ret[0].length;
        double max = FactoryUtils.getMaximum(p);
        double min = FactoryUtils.getMinimum(p);
        double delta = (max - min);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = FactoryUtils.
                        formatDouble((p[i][j] - min) / delta);
            }
        }
        return ret;
    }
//    public static float[] normalizeMinMax(float[] v) {
//        float[] ret =v.clone();
//        double min = FactoryUtils.getMinimum(v);
//        double max = FactoryUtils.getMaximum(v);
//        double delta = (max - min);
//        for (int i = 0; i < v.length; i++) {
//            ret[i] = (float) FactoryUtils.formatDouble((v[i] - min) / delta);
//        }
//        return ret;
//    }

    public static double[] normalizeIntensity(double[] v, double dmin, double dmax) {
        double[] ret = v.clone();
        double min = FactoryUtils.getMinimum(v);
        double max = FactoryUtils.getMaximum(v);
        double delta1 = (max - min);
        double delta2 = (dmax - dmin);
        double r = delta2 / delta1;
        for (int i = 0; i < v.length; i++) {
            ret[i] = FactoryUtils.formatDouble((v[i] - min) * r + dmin);
        }
        return ret;
    }

    public static double[][] normalizeWith1DRange(double[][] param, double min, double max) {
        double[][] temp = param.clone();
        double[][] temp2 = normalizeMinMax(param.clone());
        double range = max - min;
        for (int i = 0; i < param.length; i++) {
            for (int j = 0; j < param[0].length; j++) {
                double d = temp2[i][j];
                double tmp = d * range + min;
                temp[i][j] = tmp;
            }
        }
        return temp;
    }

    public static double[][] normalizeWith2DRange(double[][] param, double min, double max) {
        double[][] temp = param.clone();
        double[][] temp2 = normalize2DMinMax(param.clone());
        double range = max - min;
        for (int i = 0; i < param.length; i++) {
            for (int j = 0; j < param[0].length; j++) {
                double d = temp2[i][j];
                double tmp =FactoryUtils.formatDouble(d * range + min);
                temp[i][j] = tmp;
            }
        }
        return temp;
    }

    public static double[] normalizeWith1DRange(double[] param, double min, double max) {
        double[] temp = param.clone();
        double[] temp2 = normalizeMinMax(param.clone());
        double range = max - min;
        for (int i = 0; i < param.length; i++) {
            double d = temp2[i];
            double tmp = d * range + min;
            temp[i] = tmp;
        }
        return temp;
    }
}
