/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.utils;

/**
 *
 * @author ozaytunctan13
 */
public class FactoryIstatistic {

    /**
     * standart sapmasını hesaplar
     *
     * @param m
     * @return
     */
    public static double getStandardDeviation(double[] m) {
        double mean = FactoryUtils.avg(m);
        double deviation = 0.0d;
        double variance = 0.0d;

        for (int i = 0; i < m.length; i++) {
            deviation = m[i] - mean;
            variance += Math.pow(deviation, 2);
        }
        variance /= (m.length - 1);
        return Math.sqrt(variance);
    }

    /**
     * Standart sapmasını hesaplar.
     *
     * @param m
     * @return
     */
    public static double getStandardDeviation(int[] m) {
        double mean = FactoryUtils.avg(m);
        double deviation = 0.0d;
        double variance = 0.0d;

        for (int i = 0; i < m.length; i++) {
            deviation = m[i] - mean;
            variance += Math.pow(deviation, 2);
        }
        variance /= (m.length - 1);
        return Math.sqrt(variance);
    }

    /**
     * Varyansını hesaplar.
     *
     * @param m
     * @return
     */
    public static double getVariance(double[] m) {
        double mean = FactoryUtils.avg(m);
        double deviation = 0.0d;
        double variance = 0.0d;

        for (int i = 0; i < m.length; i++) {
            deviation = m[i] - mean;
            variance += Math.pow(deviation, 2);
        }
        variance /= (m.length - 1);
        return variance;
    }

    /**
     * Varyansını hesaplar.
     *
     * @param m
     * @return
     */
    public static double getVariance(int[] m) {
        double mean = FactoryUtils.avg(m);
        double deviation = 0.0d;
        double variance = 0.0d;

        for (int i = 0; i < m.length; i++) {
            deviation = m[i] - mean;
            variance += Math.pow(deviation, 2);
        }
        variance /= (m.length - 1);
        return variance;
    }
}
