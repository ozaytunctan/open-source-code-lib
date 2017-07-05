/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.open.classification_learning.DataSetLoader;
import com.open.classification_learning.GroupLabel;
import com.open.classification_learning.KnnClassification;
import com.open.classification_learning.LabelSetLoader;
import com.open.matrix.CMat;
import com.open.matrix.DistanceType;
import java.util.Arrays;

/**
 *
 * @author ozaytunctan13
 */
public class TestKNN {

    public static void main(String[] args) {
        CMat train = CMat.getInstanceFromFile("images/pattern(1-7).txt");
        CMat test = CMat.getInstanceFromFile("images/patternV2(1-7).txt");

        Integer[] tes_lb = (test.getColumnValue(test.getColNumber() - 1)).toInteger1D();
        Integer[] tra_lb = train.getColumnValue(train.getColNumber() - 1).toInteger1D();
        GroupLabel<Integer> trainLabel
                = new GroupLabel<>(tra_lb);
        GroupLabel<Integer> testLabel
                = new GroupLabel<>(tes_lb);
        DataSetLoader data = new DataSetLoader(train, test);
        LabelSetLoader label = new LabelSetLoader(trainLabel, testLabel);
        KnnClassification knn = new KnnClassification(data, label, DistanceType.euclidean, 3);
        knn.startTrain();
        double v = knn.getBasariOrani(testLabel);
        System.out.println(v);
        GroupLabel result_train = knn.getResultSet();
        System.out.println(Arrays.toString(testLabel.getLabel()));
        System.out.println(Arrays.toString(result_train.getLabel()));
    }
}
