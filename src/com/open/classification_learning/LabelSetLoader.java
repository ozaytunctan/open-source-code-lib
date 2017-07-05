/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.classification_learning;

import com.open.utils.FactoryUtils;

/**
 *
 * @author ozaytunctan13
 */
public class LabelSetLoader {

    public GroupLabel trainLabel;
    public GroupLabel testLabel;

    public LabelSetLoader(double[] trainLabel, double[] testLabel) {
        this.trainLabel = new GroupLabel(FactoryUtils.toCastDouble1D(trainLabel));
        this.testLabel = new GroupLabel(FactoryUtils.toCastDouble1D(testLabel));
    }

    public LabelSetLoader(int[] trainLabel, int[] testLabel) {
        this.trainLabel = new GroupLabel(FactoryUtils.toCastInt1D(trainLabel));
        this.testLabel = new GroupLabel(FactoryUtils.toCastInt1D(testLabel));
    }

    public LabelSetLoader(String[] trainLabel, String[] testLabel) {
        this.trainLabel = new GroupLabel(trainLabel);
        this.testLabel = new GroupLabel(testLabel);
    }

    public LabelSetLoader(GroupLabel trainLabel, GroupLabel testLabel) {
        this.trainLabel = trainLabel;
        this.testLabel = testLabel;
    }

    public Object[] getTestLabel() {
        if (this.testLabel != null) {
            return this.testLabel.getLabel();
        }
        return new Object[1];
    }

    public Object[] getTrainLabel() {
        if (this.trainLabel != null) {
            return this.trainLabel.getLabel();
        }
        return new Object[1];
    }
}
