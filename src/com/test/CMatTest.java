/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.open.classification_learning.GroupLabel;
import com.open.classification_learning.KnnClassification;
import com.open.image_processing.ImageProcess;
import com.open.io.InputOutputUtils;
import com.open.matrix.CMat;
import com.open.matrix.CSize;
import com.open.matrix.DistanceType;
import com.open.utils.FactoryNormalizerUtils;
import com.open.utils.FactoryUtils;
import com.open.vision.FrameImage;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ozaytunctan13
 */
public class CMatTest {

    public static void main(String[] args) {
        double[][] t = {
            {1, 8, 9, 5},//1
            {0, 1, 2, 3},//0
            {1, 10, 8, 5},//1
            {1, 0, 1, 0},//2
            {1, 8, 9, 4},//1
            {1, 8, 9, 4}};//1
//        double[][] test = {
//            {1, 7, 8, 4},//1
//            {2, 7, 8, 5},//1
//            {1, 1, 3, 3}//0
//        };
//        Integer[] trea = {1, 0, 1, 2,1, 1};
//        Integer[] tesr = {1, 1, 0};
//        GroupLabel l = new GroupLabel(trea);
//        GroupLabel t = new GroupLabel(tesr);
//        CMat cm = CMat.getInstance(train);
//        CMat cm2 = CMat.getInstance(test);
//        KnnClassification kn = 
//          new KnnClassification(cm, l,cm2, t, DistanceType.euclidean, 3);
//        kn.start();
//        GroupLabel result_train = kn.getResultSet();
//        System.out.println(Arrays.toString(t.getLabel()));
//        System.out.println(Arrays.toString(result_train.getLabel()));
        long tic = FactoryUtils.tic();
        double []d=new double[1];
        CMat cm = CMat.getInstance().randi(10, 10, 0, 255).println().subMatrix(new Rectangle(0, 2, 5, 5)).println();

//               c[0].println();
//               c[1].println();
//     FactoryUtils.toc(tic);
//     cm.println();
//    }
//
//    public static void main(String[] args) {
//
//        double[][] d2 = {
//            {3, 3, 3},
//            {3, 78, 3},
//            {3, 13, 13},
//            {3, 78, 3},
//            {7, 7, 7},
//            {7, 7, 7}
//        };
//        double[][] d1=
//                 
//                {{1, 56, 1},
//                {1, 11, 1},
//                {1, 20, 11}};
//        double[][] m
//                = {{19.125, 1.02, 0.0},
//                {1.02, 19.125, 8.925},
//                {0.0, 1.02, 255.0}};
//        ArrayList<double[]> ls = new ArrayList<>();
//        ls.add(new double[]{1, 4, 5, 6});
//        ls.add(new double[]{3, 4, 1, 7});
////        CMat c1 = CMat.getInstance(new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}});
////        CMat c = CMat.getInstance().randi(200, 100, 0, 255)
////                .println();
//        BufferedImage im = InputOutputUtils.imread("images/ozay.jpg");
//        FrameImage f = new FrameImage(im);
//        f.setVisible(true);
//        CMat test=CMat.getInstance(d1);
//        CMat c = CMat.getInstance(d2).distance(test, DistanceType.euclidean.name()); //        CMat cm1 = CMat.getInstance(d1).distance(c,"chessbord").println();
//
//        
////CMat cm = CMat.getInstanceFromFile().println();
//                //  c.println();
//                // System.out.println(c.getName());
//                //        CMat cm = CMat.getInstance()
//                //                .rand(400, 500)
//                //                .tic()
//                //                .map(0, 255)
//                //                .transpose()
//                //                .pow(2)
//                //                .sqrt()
//                //                .divide(5)
//                //                .subtract(3)
//                //                .add(5)
//                //                .transpose()
//                //                .subtract(5)
//                //                .reshape(10, 10)
//                //                .println()
//                //                .minmax2D()
//                //                .println()
//                //                
//                //                .reshape(20, 20)
//                //                .fillMatrix(10, 10,-5)
//                //                .abs()
//                //                .pow(0.9)
//                //                .multiply(5)
//                //                .sqrt()
//                //                .reshape(new CSize(5))
//                //                .println()
//                //                .toc();
//                //        //CMat cm2=CMat.getInstance().rand(50,50, 5.2, 100.99).tic().println().toc();
//                ////        ;
//                //        FactoryUtils.println(minmax(d2));
//                //        FactoryUtils.println(FactoryNormalizerUtils.normalizeMinMax(d2));
//                // System.out.println(FactoryUtils.replaceAll("ozay tunctan aykara aydan","ay",""));
    }

    public static double[][] minmax(double[][] d) {
        int r = d.length;
        int c = d.length;
        double max = FactoryUtils.getMaximum(d.clone());
        double min = FactoryUtils.getMinimum(d.clone());
        double[][] temp = new double[r][c];
        double delta = (max - min);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = FactoryUtils.
                        formatDouble((d[i][j] - min) / delta);
            }
        }
        return temp;
    }
}
