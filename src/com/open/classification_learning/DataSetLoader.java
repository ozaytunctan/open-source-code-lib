/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.classification_learning;

import com.open.matrix.CMat;

/**
 *
 * @author ozaytunctan13
 */
public class DataSetLoader {

    public CMat train;
    public CMat test;

    public DataSetLoader(CMat train, CMat test) {
        this.train = train;
        this.test = test;
    }

    public DataSetLoader() {
        train = CMat.getInstance();
        test = CMat.getInstance();
    }

    public DataSetLoader(double[][] train, double[][] test) {
        this.train = CMat.getInstance(train);
        this.test = CMat.getInstance(test);
    }

    public DataSetLoader(int[][] train, int[][] test) {
        this.train = CMat.getInstance(train);
        this.test = CMat.getInstance(test);
    }

    public CMat getTrainSet() {
        return this.train;
    }

    public CMat getTestSet() {
        return this.test;
    }

}
