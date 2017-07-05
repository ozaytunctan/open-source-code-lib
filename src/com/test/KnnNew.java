/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.open.classification_learning.GroupLabel;
import com.open.matrix.CMat;
import com.open.matrix.DistanceType;

/**
 *
 * @author ozaytunctan13
 */
interface Train {

    public Train trainSet(CMat train);

    public Test trainLabel(GroupLabel label);

}

interface Test {

    public Test testSet(CMat test);

    public IBuild testLabel(GroupLabel label);

}

interface IBuild {

    public KnnNew build();
}

public class KnnNew {

    private static CMat train;
    private static CMat test;
    private static GroupLabel trainLabel;
    private static GroupLabel testLabel;
    private static int neigbor;
    private static DistanceType distance;

    public static Train knnClassify() {
        return new Builder();
    }
//
//    public static Builder build() {
//
//    }

    private static class Builder implements Train, Test, IBuild {

        public Builder() {
        }

        @Override
        public Train trainSet(CMat train) {
            KnnNew.train = train;
            return this;
        }

        @Override
        public Test trainLabel(GroupLabel label) {
            KnnNew.trainLabel = label;
            return this;
        }

        @Override
        public Test testSet(CMat test) {
            KnnNew.test = test;
            return this;
        }

        @Override
        public IBuild testLabel(GroupLabel label) {
            KnnNew.testLabel = label;
            return this;
        }

        @Override
        public KnnNew build() {
            return new KnnNew();
        }

    }

    public static void main(String[] args) {
        KnnNew knn = KnnNew.
                knnClassify().trainLabel(testLabel).
                testSet(test).testLabel(testLabel).build();
                
    }
    }
