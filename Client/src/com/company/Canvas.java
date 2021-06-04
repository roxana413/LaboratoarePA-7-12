package com.company;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Canvas extends JPanel implements MouseMotionListener {


    private int x, y;
    private PlayerAttributes player;
    private BufferedImage    imageX, imageO;
    private BufferedImage image;
    private Graphics2D    graphics;
    public boolean active;
    int              shapeWidth;
    int              shapeHeight;



    public Canvas() {

         active = true;  //cand game-ul e gata (primim de la server castigatorii nu mai trimitem request-uri --> active=false)

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void init(PlayerAttributes player) throws IOException {
        this.player = player;
        if (player.getName().equals("x")) {
            BufferedImage img;
            img = ImageIO.read(new File("C:\\Users\\Roxana\\Laborator10Client\\res\\blueX.png"));
            this.setXImage(img);
        } else {
            BufferedImage img;
            img = ImageIO.read(new File("C:\\Users\\Roxana\\Laborator10Client\\res\\redCircle.png"));
            this.setOImage(img);
        }


        //inseram imaginea
        /*JFrame frame = new JFrame();
        frame.setSize(506, 527);
        frame.setLocationRelativeTo((Component) null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(new JLabel(new ImageIcon("C:\\Users\\Roxana\\Laborator10Client\\res\\board.png")));
        */
        try {

            BufferedImage img;
            img = ImageIO.read(new File("C:\\Users\\Roxana\\Laborator10Client\\res\\board.png"));

            System.out.println(img.getWidth());
            this.shapeWidth=img.getWidth();
            System.out.println(img.getHeight());
            this.shapeHeight=img.getHeight();

            this.setTableImage(img);
            graphics.drawImage(img, 0, 0, null);

        } catch (Exception e) {
            e.printStackTrace();
        }


        setDoubleBuffered(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (graphics != null) {


                    //drawShape(e.getX(), e.getY(), player );
                    //trebuie sa transmitem la server exact pozitia
                    int x = e.getX();
                    int y = e.getY();


                    repaint();
                }
            }
        });
    }


    public void drawShape(int x, int y, String shape) {

        if (shape.equals("x")) {
            graphics.drawImage(getImageX(), x*shapeHeight, y*shapeWidth, null);
        } else {
            graphics.drawImage(getImageO(), x*shapeHeight, y*shapeWidth, null);
        }
        repaint();
    }


    public BufferedImage getImageX() {
        return imageX;
    }

    public void setImageX(BufferedImage imageX) {
        this.imageX = imageX;
    }

    public BufferedImage getImageO() {
        return imageO;
    }

    public void setImageO(BufferedImage image0) {
        this.imageO = image0;
    }

    public void setTableImage(BufferedImage tableImage) {
        this.image = tableImage;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = new BufferedImage(500, 300, BufferedImage.TYPE_INT_ARGB);
            graphics = image.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);

    }


    public void clear() {
        graphics.setPaint(Color.white);
        graphics.fillRect(0, 0, getSize().width, getSize().height);

        repaint();
    }


    void setXImage(BufferedImage img) {

        try {
            BufferedImage image;
            image = ImageIO.read(new File("../redX.png"));
            this.setImageX(image);
            graphics = image.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        } catch (IOException ex) {
            System.out.println("Error loading image ..");
        }

    }

    void setOImage(BufferedImage img) {
        try {
            BufferedImage image;
            image = ImageIO.read(new File("../blueCircle.png"));
            this.setImageO(image);
            graphics = image.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        } catch (IOException ex) {
            System.out.println("Error loading image ..");
        }

    }


    public String play() {

        addMouseMotionListener(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                x = e.getX();
                y = e.getY();

                setX(x);
                setY(y);


                repaint(); //va apela metoda paintComponent
            }


        });
      return"AAA";
    }




}
