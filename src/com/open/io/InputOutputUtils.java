/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.io;

import com.open.lang.MessageBox;
import com.open.matrix.CMat;
import com.open.matrix.CSize;
import com.open.utils.FactoryUtils;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author ozaytunctan13
 */
public class InputOutputUtils {

    public static String getDefaultDirectory() {
        String workingDir = System.getProperty("user.dir");
        return workingDir;
    }

    public static File getFileFromChooserForPNG() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("save panel as a png file");
        chooser.setSize(new java.awt.Dimension(45, 37)); // Generated
        chooser.setFileFilter(new FileNameExtensionFilter("png", "png"));
        File file = new File("C:\\deneme.png");
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            if (file.getName().indexOf(".png") == -1) {
                File file2 = new File(file.getParent() + "\\" + file.getName() + ".png");
                file = file2;
            }
            return file;
        }
        return null;
    }

    public static File getFileFromChooser() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("save as file");
        chooser.setSize(new java.awt.Dimension(45, 37)); // Generated
//        chooser.setFileFilter(new FileNameExtensionFilter("png", "png"));
        File file = null;
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            return file;
        }
        return file;
    }

    public static File getFileFromChooser(String folderPath) {
        JFileChooser chooser = new JFileChooser(folderPath);
        chooser.setDialogTitle("save as file");
        chooser.setSize(new java.awt.Dimension(45, 37)); // Generated
//        chooser.setFileFilter(new FileNameExtensionFilter("png", "png"));
        File file = null;
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            return file;
        }
        return file;
    }

    public static File getFileFromChooserSave() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("save as file");
        chooser.setSize(new java.awt.Dimension(45, 37)); // Generated
//        chooser.setFileFilter(new FileNameExtensionFilter("png", "png"));
        File file = null;
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            return file;
        }
        return file;
    }

    public static File getFileFromChooserSave(String folderPath) {
        JFileChooser chooser = new JFileChooser(folderPath);
        chooser.setDialogTitle("save as file");
        chooser.setSize(new java.awt.Dimension(45, 37)); // Generated
//        chooser.setFileFilter(new FileNameExtensionFilter("png", "png"));
        File file = null;
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            return file;
        }
        return file;
    }

    public static File getFileFromChooserLoad() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("select file");
        chooser.setSize(new java.awt.Dimension(45, 37)); // Generated
//        chooser.setFileFilter(new FileNameExtensionFilter("png", "png"));
        File file = null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            return file;
        }
        return file;
    }

    public static File getFileFromChooserLoad(String folderPath) {
        JFileChooser chooser = new JFileChooser(folderPath);
        chooser.setDialogTitle("select file");
        chooser.setSize(new java.awt.Dimension(45, 37)); // Generated
//        chooser.setFileFilter(new FileNameExtensionFilter("png", "png"));
        File file = null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            return file;
        }
        return file;
    }

    public static File browseDirectory() {
        return browseDirectory(getDefaultDirectory());
    }

    public static File browseDirectory(String path) {
        JFileChooser chooser = new JFileChooser(path);
        chooser.setDialogTitle("Browse Directory");
        chooser.setSize(new java.awt.Dimension(45, 37)); // Generated
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        File file = null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }
        return file;
    }

    public static File browseFile() {
        return getFileFromChooserLoad();
    }

    public static File browseFile(String path) {
        return getFileFromChooserLoad(path);
    }

    public static BufferedImage imread() {
        BufferedImage imge = new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR);
        try {
            File f = InputOutputUtils.getFileFromChooser();
            if (!f.exists()) {
                MessageBox.showErrorMessage("Image read window Error window", "Lütfen bir resim seciniz");
                return imge;
            }
            imge = ImageIO.read(f);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imge;

    }

    public static BufferedImage imread(String path) {
        BufferedImage imge = new BufferedImage(1, 1, BufferedImage.TYPE_3BYTE_BGR);
        try {
            File f = new File(path);
            if (!f.exists()) {
                MessageBox.showErrorMessage("Image Error window", "Lütfen bir resim seciniz");
                return imge;
            }
            imge = ImageIO.read(f);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imge;

    }

    public static boolean imwrite(BufferedImage imge) {
        return saveImage(imge);
    }

    public static boolean imwrite(BufferedImage imge, String file_name) {
        return saveImage(imge, file_name);
    }

    public static void imwrite(BufferedImage imge, String extension, String file_name) {
        saveImageWithFormat(imge, extension, file_name);
    }

    private static boolean saveImage(BufferedImage img) {
        JFileChooser FC = new JFileChooser("C:/");
        int retrival = FC.showSaveDialog(null);
        if (retrival == FC.APPROVE_OPTION) {
            File fileToSave = FC.getSelectedFile();
            String extension = FactoryUtils.getFileExtension(fileToSave);
            try {
                boolean ret = ImageIO.write(img, extension, fileToSave);
                return ret;

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean saveImage(BufferedImage img, String fileName) {
        File file = new File(fileName);
        String extension = FactoryUtils.getFileExtension(fileName);
        boolean ret = false;
        try {
            ret = ImageIO.write(img, extension, file);
        } catch (IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
        return ret;
    }

    private static void saveImageWithFormat(BufferedImage img, String path, String fileType) {
        File outputFile = new File(path);
        try {
            ImageIO.write(img, fileType, outputFile);
        } catch (IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }

    public static BufferedReader open_read(String file_name) {
        File file = new File(file_name);
        BufferedReader in = null;
        if (!file.exists()) {
            MessageBox.showErrorMessage("Error window", file_name + " isminde bir dosya yok");
            return in;
        }
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return in;
    }

    public static BufferedWriter open_write(String file_name) {
        File file = new File(file_name);
        BufferedWriter out = null;
        if (!file.exists()) {
            MessageBox.showErrorMessage("Error window", file_name + " isminde bir dosya yok");
            return out;
        }
        try {
            MessageBox.showErrorMessage(file_name + " isminde bir dosya zaten var üzerine yazılacak");
            out = new BufferedWriter(new FileWriter(file));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(InputOutputUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }

    public static BufferedWriter open_write_append(String file_name) {
        File file = new File(file_name);
        BufferedWriter out = null;
        if (!file.exists()) {
            MessageBox.showErrorMessage("Error window", file_name + " isminde bir dosya yok");
            return out;
        }
        try {
            MessageBox.showErrorMessage(file_name + " isminde bir dosya zaten var üzerine yazılacak");
            out = Files.newBufferedWriter(file.toPath(),
                    StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(InputOutputUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }

    public static void saveObject(String file_name, Object obj) {
        File f_name = getFileFromChooserSave();
        FactoryUtils.serialize(obj, f_name.getPath());
    }

    public static Object readObject(String file_name) {
        File f_name = getFileFromChooser();
        Object obj = FactoryUtils.deserialize(f_name.getPath());
        return obj;
    }

    public static void close(BufferedReader in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(InputOutputUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void close(BufferedWriter out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(InputOutputUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static double[] readDataDouble(String path) {
        double[] d = {};
        ArrayList<Double> value = new ArrayList<>();
        BufferedReader reader = null;
        try {

            reader = open_read(path);
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    double num = Double.parseDouble(line);
                    value.add(num);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return FactoryUtils.toDouble1D(value);
    }

    public static int[] readDataInt(String path) {
        int[] d = {};
        BufferedReader reader = null;
        ArrayList<Integer> value = new ArrayList<>();
        try {

            reader = open_read(path);
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    int num = Integer.parseInt(line);
                    value.add(num);
                }

            }
            return FactoryUtils.toInt1D(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return d;
    }

    public static String[] readDataString(String path) {
        String[] d = {};
        BufferedReader reader = null;
        ArrayList<String> value = new ArrayList<>();
        try {
            reader = open_read(path);
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    value.add(line);
                }
            }
            return value.toArray(new String[1]);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return d;
    }

    public static double[][] readFromFileDataDouble(String file_name, String token) {
        double[][] d = new double[1][1];
        ArrayList<double[]> lst = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = open_read(file_name);
            String s;
            while ((s = br.readLine()) != null) {
                if ((s.indexOf("@") != -1) || (s.indexOf("%") != -1) | s.startsWith("@")) {
                    continue;
                }
                double[] row = null;
                if (token.isEmpty()) {
                    row = new double[1];
                    row[0] = Double.parseDouble(s);
                } else {
                    if (!s.isEmpty()) {
                        String[] sd = s.split(token);
                        row = new double[sd.length];
                        for (int i = 0; i < sd.length; i++) {
                            row[i] = Double.parseDouble(sd[i]);
                        }
                        lst.add(row);
                    }
                }
            }
        } catch (IOException e) {
            MessageBox.showErrorMessage(e.getMessage());
            return d;
        } finally {
            try {
                if (br != null) {
                    br.close();
                } else {
                    return null;
                }
            } catch (IOException ex) {
                MessageBox.showErrorMessage(ex.getMessage());
            }
        }
        if (lst.isEmpty()) {
            MessageBox.showErrorMessage("Dosya içinde veri bulunamadı");
            return null;
        }
        return lst.toArray(d);
    }

    public static String[][] readFromFileDataString(String file_name, String token) {
        String[][] d = new String[1][1];
        ArrayList<String[]> lst = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = open_read(file_name);
            String s;
            while ((s = br.readLine()) != null) {
                if (s.indexOf("@") != -1) {
                    continue;
                }
                String[] row = null;
                if (token.isEmpty()) {
                    row = new String[1];
                    row[0] = s;
                } else {
                    if (s.isEmpty()) {
                        String[] sd = s.split(token);
                        row = new String[sd.length];
                        for (int i = 0; i < sd.length; i++) {
                            row[i] = sd[i];
                        }
                    }
                    lst.add(row);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return d;
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                MessageBox.showErrorMessage(ex.getMessage());
            }
        }
        return lst.toArray(d);
    }

    public static int[][] readFromFileDataInt(String file_name, String token) {
        return FactoryUtils.toCastInt2D(readFromFileDataDouble(file_name, token));
    }

    public static void writeToFile(String file_name, String row, boolean isappend) {
        BufferedWriter out = null;
        try {
            if (isappend) {
                out = open_write_append(file_name);
            } else {
                out = open_write(file_name);
            }
            out.write(row);
            out.newLine();
            out.flush();

        } catch (IOException e) {
            MessageBox.showErrorMessage(e.getMessage());
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                MessageBox.showErrorMessage(ex.getMessage());
            }
        }
    }

    public static void writeToFile(String file_name, double[][] d, boolean isappend) {
        BufferedWriter out = null;
        try {
            if (isappend) {
                out = open_write_append(file_name);
            } else {
                out = open_write(file_name);
            }
            String row = "";
            for (int i = 0; i < d.length; i++) {
                String r = "";
                for (int j = 0; j < d[0].length; j++) {
                    r += d[i][j] + ",";
                }
                r = r.substring(0, r.length() - 1);
                row = r + "\n";
                out.write(r);
                out.newLine();
                out.flush();
            }
        } catch (IOException ex) {
            MessageBox.showErrorMessage(ex.getMessage());
        } finally {
            close(out);
        }

    }

    public static void writeToFile(String file_name, int[][] d, boolean isappend) {

        BufferedWriter out = null;
        try {
            if (isappend) {
                out = open_write_append(file_name);
            } else {
                out = open_write(file_name);
            }
            String row = "";
            for (int i = 0; i < d.length; i++) {
                String r = "";
                for (int j = 0; j < d[0].length; j++) {
                    r += d[i][j] + ",";
                }
                r = r.substring(0, r.length() - 1);
                row = r;
                out.write(r);
                out.newLine();
                out.flush();
            }
        } catch (IOException ex) {
            MessageBox.showErrorMessage(ex.getMessage());
        } finally {
            close(out);
        }

    }

    public static void writeToFile(String file_name, String[][] d, boolean isappend) {

        BufferedWriter out = null;
        try {
            if (isappend) {
                out = open_write_append(file_name);
            } else {
                out = open_write(file_name);
            }
            String row = "";
            for (int i = 0; i < d.length; i++) {
                String r = "";
                for (int j = 0; j < d[0].length; j++) {
                    r += d[i][j] + ",";
                }
                r = r.substring(0, r.length() - 1);
                row = r;
                out.write(r);
                out.newLine();
                out.flush();
            }
        } catch (IOException ex) {
            MessageBox.showErrorMessage(ex.getMessage());
        } finally {
            close(out);
        }

    }

    public static void main(String[] args) {
        BufferedImage im = InputOutputUtils.imread();
        System.out.println(im.getWidth());
    }
}
