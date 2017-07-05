/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.open.vision;

import com.open.io.InputOutputUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ozaytunctan13
 */
public class PanelPicture extends JPanel {

    private BufferedImage orginalImge;
    private BufferedImage currentImage;
    private int wImge;
    private int hImge;
    private int fromLeft;
    private int fromTop;

    public PanelPicture(BufferedImage imge) {
        this.orginalImge = imge;
        wImge = imge.getWidth();
        hImge = imge.getHeight();
    }

    public PanelPicture() {
        this.orginalImge = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(Color.BLACK);
        gr.fillRect(0, 0, orginalImge.getWidth(), orginalImge.getHeight());
        gr.setColor(Color.GREEN);
        int wPanel = this.getWidth();
        int hPanel = this.getHeight();

        if (orginalImge != null) {
            int fromLeft = (wPanel - wImge)/2;
            int fromTop = (hPanel - hImge)/2;
            gr.drawImage(orginalImge, fromLeft,fromTop, this);
        }
    }

    public void setImage(BufferedImage imge) {
        this.currentImage = imge;
        this.orginalImge = imge;
        wImge = imge.getWidth();
        hImge = imge.getHeight();
        repaint();
    }

    public BufferedImage getOriginalImage() {
        return this.orginalImge;
    }

    public BufferedImage getCurrentImage() {
        return this.currentImage;
    }

    public static void main(String[] args) {
        BufferedImage imge = InputOutputUtils.imread("images/ozay.jpg");
        FrameImage fr = new FrameImage(imge);
        fr.setVisible(true);

    }

}
