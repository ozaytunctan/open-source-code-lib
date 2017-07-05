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
public enum DistanceType {
    cityblock, chessbord,
    euclidean;

    private DistanceType() {
    }
    private DistanceType getValue(String distance) {
        return valueOf(distance);
    }
    public static void main(String[] args) {
        System.out.println(DistanceType.chessbord);
    }
}
