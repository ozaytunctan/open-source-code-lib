/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.lang;

import com.open.utils.FactoryUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ozaytunctan13
 */
public class StringProc implements java.io.Serializable, CharSequence {

    private int leng = 0;
    private String str = "";
    private String str_current = "";

    public StringProc(String str) {
        this.str = str;
        this.str_current = str;
    }

    public StringProc(StringBuffer str) {
        this.str = str.toString();
    }

    public StringProc(StringBuilder str) {
        this.str = str.toString();
    }

    public StringProc(StringProc str) {
        this.str = str.toString();
    }

    public StringProc(char[] c) {
        this.str = String.valueOf(c, 0, c.length);
    }

    /**
     * String katarında remove ifadesini arar bulur ve siler.
     *
     * @param remove
     * @return
     */
    public String remove(String remove) {
        StringBuffer bf = new StringBuffer(this.str);
        Pattern pat = Pattern.compile(remove);
        Matcher mat = pat.matcher(this.str);
        if (mat.find()) {
            int indis_start = mat.start();
            int indis_end = indis_start + remove.length();
            bf = bf.delete(indis_start, indis_end);
        }
        this.str = bf.toString();
        return this.str;

    }

    /**
     * String katarı içerisinde gecen bütün remove ifadelerini silmektedir.
     *
     * @param remove
     * @return
     */
    public String removeAll(String remove) {
        Pattern pat = Pattern.compile(remove);
        Matcher mat = pat.matcher(this.str);
        String st = "";
        while (mat.find()) {
            this.str = remove(remove);
        }
        return this.str;

    }

    @Override
    public int length() {
        return this.str.length();
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || this.str.length() < index) {
            throw new ArrayIndexOutOfBoundsException("index sınırlarının dışında");
        }
        StringBuffer bf = new StringBuffer(this.str);
        return bf.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        StringBuffer bf = new StringBuffer(this.str);
        return bf.subSequence(start, end);
    }

    /**
     * String katarını belirtilen indix ten itibaren str parametresinin boyutu
     * kadar str ile değiştirir.
     *
     * @param index
     * @param str
     */
    public void setStringAt(int index, String str) {
        int l = length();
        if (index < 0 || index > l) {
            throw new ArrayIndexOutOfBoundsException("index sınırlarının dışında");
        }
        int s1 = index;
        int end = str.length();
        String kontrol = this.str.substring(s1, index + str.length());
        String s_value = this.str.substring(0, s1);
        String end_value = this.str.substring(s1 + end, l);
        if (kontrol.endsWith(" ")) {
            String ret = s_value + str + " " + end_value;
            this.str = ret;
            return;
        }
        String ret = s_value + str + end_value;
        this.str = ret;
    }

    /**
     * String katarı içerisinde str inin bulunduğu indis numaralarını
     * döndürmektedir.
     *
     * @param str
     * @return
     */
    public int[] indexOfAll(String str) {
        Pattern pat = Pattern.compile(str);
        Matcher mat = pat.matcher(this.str);
        ArrayList<Integer> list = new ArrayList<>();
        while (mat.find()) {
            int index = mat.start();
            list.add(index);
        }
        return FactoryUtils.toInt1D(list);
    }

    @Override
    public String toString() {
        return this.str;
    }

    /**
     * String katarının UTF -8 karşılığını bulur.
     *
     * @return
     */
    public int[] unicode() {
        char[] krk = this.str.toCharArray();
        int[] unicode = new int[krk.length];
        for (int i = 0; i < unicode.length; i++) {
            unicode[i] = (int) krk[i];
        }
        return unicode;
    }

    /**
     * unicodu verilen bir dizinin UTF-8 karşılığı bulunur.
     *
     * @param unicode
     * @return
     */
    public String decode(int[] unicode) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < unicode.length; i++) {
            char krk = (char) unicode[i];
            builder.append(krk);
        }
        return builder.toString();
    }

    /**
     * Parametre olarak verilen ifadenin String içerisinde kaç defa gectiğini
     * bulur.
     *
     * @param token
     * @return
     */
    public int groupCount(String aranan) {
        Pattern pat = Pattern.compile(aranan);
        Matcher mat = pat.matcher(this.str);
        int n = 0;
        while (mat.find()) {
            n++;
        }
        return n;
    }

    /**
     * String katarının kopyasını döndürmektedir.
     *
     * @return
     */
    public String copyOfValue() {
        char c[] = this.str.toCharArray();
        String newStr = String.copyValueOf(c);
        return newStr;
    }

    /**
     * n ile belirtilen değer kadar string katarını n- li hecelere ayırır.
     *
     * @param n
     * @return
     */
    public String[] toHece(int n) {
        ArrayList<String> list = new ArrayList<>();
        String newStr = copyOfValue();
        String st = String.copyValueOf(newStr.toCharArray());
        int l = newStr.length();
        String s[] = null;
        if (n < 0 || n > l) {
            throw new ArrayIndexOutOfBoundsException("index sınırların dşında");
        }
        if (n == 1) {
            s = newStr.split("");
            return s;
        }
        for (int i = 0; newStr.length() > 0; i++) {
            if (newStr.length() < n) {
                String sg = newStr.substring(0, newStr.length());
                newStr = remove(sg);
                list.add(sg);
            } else {
                String sg = newStr.substring(0, n);
                newStr = remove(sg);
                list.add(sg);
            }
        }
        this.str = st;
        return list.toArray(new String[1]);

    }

    /**
     * "[, . ; ? \\) : \\( \" ' = ! < > + ]" tokenler şekildek gibi verilmeli.
     * verilen özel karakterleri siler.
     *
     * @param tokens
     * @return
     */
    public String removeTokens(String tokens) {
        String newStr = this.str;
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(tokens);
        matcher = pattern.matcher(newStr);
        this.str = matcher.replaceAll("");
        return this.str;
    }

    /**
     * ngram yöntemi ile string katarını n parametresine göre parçalanır.Daha
     * sonra her parcanın frekansı hesaplanır.Hashmap ile küçükten büyüğe doğru
     * sıralanır.
     *
     * @param n
     * @return
     */
    public HashMap<String, Integer> nGramCount(int n) {
        HashMap<String, Integer> ht = new HashMap<>();
        String cl = this.str;
        String[] st = toHece(n);
        List<String> h = Arrays.asList(st);
        ArrayList<String> liste = new ArrayList<>(h);
        this.str = cl;
        int c = 0;
        for (int i = 0; i <= liste.size(); i++) {
            String value = liste.get(0);
            ArrayList<String> rem_list = new ArrayList<>();
            for (int j = 0; j < liste.size(); j++) {
                if (value.equals(liste.get(j))) {
                    c++;
                }
            }
            rem_list.add(value);
            liste.removeAll(rem_list);
            liste.trimToSize();
            ht.put(value, c);
            c = 0;
            i = 0;

        }
        return ht;
    }

}
