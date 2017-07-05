/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.classification_learning;

/**
 *
 * @author ozaytunctan13
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.open.lang.MessageBox;
import com.open.matrix.CMat;
import com.open.matrix.DistanceType;
import com.open.utils.FactoryUtils;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author ozaytunctan13
 */
public class KnnClassification {

    private CMat train;
    private CMat test;
    private GroupLabel trainLabel;
    private GroupLabel testLabel;
    private int neighbor;
    private DistanceType distance = DistanceType.euclidean;
    private int basariOrani;
    private GroupLabel resultValue;

    public KnnClassification(DataSetLoader dataset, LabelSetLoader label, DistanceType distance, int neighbor) {
        setNeuralNetwork(dataset, label, distance, neighbor);
    }

    public KnnClassification(CMat train, GroupLabel trainLabel, CMat test, DistanceType distType, int neighbor) {
        this.train = train;
        this.test = test;
        this.trainLabel = trainLabel;
        this.neighbor = neighbor;
        this.distance = distType;
    }

    public KnnClassification(CMat train, GroupLabel trainLabel, CMat test, GroupLabel testLabel, DistanceType distType, int neighbor) {
        this.train = train;
        this.test = test;
        this.trainLabel = trainLabel;
        this.testLabel = testLabel;
        this.neighbor = neighbor;
        this.distance = distType;
    }

    public KnnClassification(double[][] train, GroupLabel trainLabel, double[][] test, DistanceType distType, int neighbor) {
        this.train = CMat.getInstance(train);
        this.test = CMat.getInstance(test);
        this.trainLabel = trainLabel;
        this.testLabel = testLabel;
        this.neighbor = neighbor;
        this.distance = distType;
    }

    public void start() {
        if (this.train.getColNumber() != this.test.getColNumber() || this.train.getColNumber() == 1) {
            MessageBox.showErrorMessage("Test veya Train setinin sütun sayıları  eşit değildir!");
            return;
        }
        if (this.distance == null) {
            MessageBox.showErrorMessage("Uzaklık değerini giriniz.");
            return;
        }
        int n = neighbor % 2;
        if (n == 0 || neighbor < 0) {
            MessageBox.showErrorMessage("Komşu değeri tek ve komşu>0 büyük olmalıdır.");
            return;
        }
        if (train.getRowNumber() < n) {
            MessageBox.showErrorMessage("Komşu değeri eğitim seti sayısından büyük olamaz.");
            return;
        }
        knnMesssageStart();
        long tic = FactoryUtils.tic();
        CMat mat_dist = train.distance(test, distance.name());
        double[][] dist = mat_dist.toDoubleArray2D();
        int r = dist.length;
        Object[] result = new Object[r];
        for (int i = 0; i < r; i++) {
            int[] index_min = FactoryUtils.getMinimumIndex(dist[i], this.neighbor);
            Object res = FactoryUtils.getKnnClassify(trainLabel, index_min);
            result[i] = res;
        }
        resultValue = new GroupLabel(result);
        FactoryUtils.toc(tic);

    }

    public void startTrain() {
        if (this.train.getColNumber() != this.test.getColNumber() || this.train.getColNumber() == 1) {
            MessageBox.showErrorMessage("Test veya Train setinin sütun sayıları  eşit değildir!");
            return;
        }
        if (this.distance == null) {
            MessageBox.showErrorMessage("Uzaklık değerini giriniz.");
            return;
        }
        int n = neighbor % 2;
        if (n == 0 || neighbor < 0) {
            MessageBox.showErrorMessage("Komşu değeri tek ve komşu>0 büyük olmalıdır.");
            return;
        }
        if (train.getRowNumber() < n) {
            MessageBox.showErrorMessage("Komşu değeri eğitim seti sayısından büyük olamaz.");
            return;
        }
        knnMesssageStart();
        long tic = FactoryUtils.tic();
        CMat mat_dist = train.distance(test, distance.name());
        double[][] dist = mat_dist.toDoubleArray2D();
        int r = dist.length;
        Object[] result = new Object[r];
        for (int i = 0; i < r; i++) {
            int[] index_min = FactoryUtils.getMinimumIndex(dist[i], this.neighbor);
            Object res = FactoryUtils.getKnnClassify(trainLabel, index_min);
            result[i] = res;
        }
        resultValue = new GroupLabel(result);
        FactoryUtils.toc(tic);

    }

    private void setNeuralNetwork(DataSetLoader dataset, LabelSetLoader labelset, DistanceType distance, int neighbor) {
        this.train = dataset.train;
        this.test = dataset.test;
        this.trainLabel = labelset.trainLabel;
        this.testLabel = labelset.testLabel;
        this.distance = distance;
        this.neighbor = neighbor;
    }

    private void knnMesssageStart() {

        String tarih = Calendar.getInstance(new Locale("Tur")).getTime().toString();
        String knnMessage
                = "                   K- EN YAKIN KOMŞU ALGORITMASI                   \n"
                + "====================================================================\n"
                + "--->Eğitim seti olarak " + train.getRowNumber() + " adet veri seçildi.\n"
                + "--->Test seti olarak " + test.getRowNumber() + " adet veri secildi.\n"
                + "--->Uzaklık ölçüsü olarak " + distance.name() + " seçildi.\n"
                + "--->En yakın komşu sayısı olarak " + neighbor + " komşu seçildi.\n"
                + "Start time :" + tarih + "                           \n"
                + "============================Starting....============================\n";
        System.out.println(knnMessage);
    }

    public GroupLabel getResultSet() {
        if (this.resultValue == null) {
            this.resultValue = new GroupLabel(new Object[1]);
        }
        return this.resultValue;
    }

    public double getBasariOrani(GroupLabel labelTest) {
        if (labelTest.getLabel().length > 0 && this.resultValue != null) {
            if (labelTest.getLabel().length == this.resultValue.getLabel().length) {
                int DP = 0;
                Object[] label = labelTest.getLabel();
                Object[] result = this.resultValue.getLabel();
                for (int i = 0; i < label.length; i++) {
                    if (label[i].equals(result[i])) {
                        DP++;
                    }
                }
                double num = FactoryUtils.formatDouble((100 * DP) / result.length);
                System.out.println(
                        "--------------------------------------------------------\n"
                        + "- Knn Başarı Oranı(100):%" + num + "                   -\n"
                        + "--------------------------------------------------------\n");
                return num;

            } else {
                MessageBox.showErrorMessage("Test ve sonuc sayısı eşit değildir.");
                return 0;
            }
        }
        return -1.0;

    }
}
