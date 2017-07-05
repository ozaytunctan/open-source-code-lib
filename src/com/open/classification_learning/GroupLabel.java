/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.classification_learning;

import com.open.utils.FactoryUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ozaytunctan13
 */
/**
 *
 * @param <V> Makine öğrenmesi yöntemleri için sınıf bilgisinin tutulması için
 * tanımlanmıştır. GroupLabel nesnesi generic tipte tanımlanmıştır.
 * Double,Integer,Float,Short,String
 */
public class GroupLabel<V> implements Serializable {

    private V[] label;

    public GroupLabel(V[] label) {
        this.label = label;
    }

    public GroupLabel() {
        this.label = null;
    }

    public V[] getLabel() {
        return label;
    }

    /**
     *
     * @param label
     */
    public void setLabel(V[] label) {
        this.label = label;
    }

    public ArrayList<V> toList() {
        ArrayList<V> list = new ArrayList<>();
        for (V v : label) {
            list.add(v);
        }
        return list;
    }

}
