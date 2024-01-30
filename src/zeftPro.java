
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static java.lang.Math.floor;
//import static javax.swing.plaf.metal.MetalScrollBarUI.thumbColor;


class TabbedPaneExample1 extends JPanel {
    private class dish extends JPanel{
        int panelIndex;
        ImageIcon icon;
        double price;
        int count=0;
        String name;
        JLabel photoLabel;
        JLabel textLabel;

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(new Color(37,40,54));
            g.fillRoundRect(0,0,200,275,0,0);
            g.setColor(new Color(31,29,34 ));
            g.fillRoundRect(0,25,200,250,50,50);

        }
        String description;

        dish(dish v){
            this.count=v.count;
            this.description=v.description;
            this.name=v.name;
            this.icon=v.icon;
            this.price=v.price;
            this.photoLabel=v.photoLabel;
            this.textLabel=v.textLabel;
        }
        dish(ImageIcon icon,String text,int n){
            panelIndex=n;
            try{
                setBorder(BorderFactory.createEmptyBorder());
                this .icon=icon;
                setPreferredSize(new Dimension(200,275));
                setAlignmentX(JPanel.CENTER_ALIGNMENT);
                setLayout(new BorderLayout());

                photoLabel=new JLabel(){
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        // Calculate the size of the visible area
                        int visibleWidth = getWidth() / 2;
                        int visibleHeight = getHeight();
                        // Draw the photo
                        g.drawImage(icon.getImage(), 50, 0, 100, 100, this);
                    }
                };

                String[]str=text.split(",");
                JPanel p1=new JPanel(new FlowLayout());



                textLabel=new JLabel("<html><center><h1 style='font-size: 14pt; color: White'>"+str[0]+"</h1>" +
                        "<p style='font-size: 14pt; color: White'>"+str[1]+" </p>" +
                        "<p style='font-size: 14pt; color: White'>"+str[2]+" $ </p>" +
                        "<p style='font-size: 14pt; color:#B3B8BE'> "+str[3]+"</p></center></html>");

                price=Double.valueOf(str[2]);
                count=Integer.parseInt(str[3]);
                name=str[0];
                description=str[1];
                description=str[1];

                JPanel p=new JPanel(new GridLayout(2,1));
                p.setOpaque(false);
                add (photoLabel,BorderLayout.CENTER);
                p.add(new JPanel(new FlowLayout(FlowLayout.CENTER)).add(textLabel));
                JButton editButton=new JButton("edit");
                editButton.setActionCommand(str[0]);
                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(e.getSource());
                        dish edited=momory.get(e.getActionCommand());
                        new Diffrent(edited,edited.panelIndex);
                    }
                });
                p.add(new JPanel(new FlowLayout(FlowLayout.CENTER)).add(editButton));

                add(p,BorderLayout.SOUTH);

                //add(textLabel,BorderLayout.SOUTH);
                photoLabel.setVerticalAlignment(JLabel.CENTER);
                textLabel.setAlignmentX(JLabel.CENTER);
                textLabel.setHorizontalAlignment(JLabel.CENTER);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

        public void setIcons(ImageIcon icon) {
            this.icon = icon;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }

        public int getCount() {
            return count;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public ImageIcon getIcons() {
            return icon;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void reassign() {

            textLabel.setText("<html><center><h1 style='font-size: 14pt; color: White'>"+getName()+"</h1>" +
                    "<p style='font-size: 14pt; color: White'>"+getDescription()+" </p>" +
                    "<p style='font-size: 14pt; color: White'>"+getPrice()+" $ </p>" +
                    "<p style='font-size: 14pt; color:#B3B8BE'> "+getCount()+"</p></center></html>");

        }
    }



    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public class Diffrent {
        JTextField[]textBox=new JTextField[4];
        JLabel [] labels={new JLabel("dish name"),new JLabel("description"),new JLabel("price"),new JLabel("count"),new JLabel("photo")};
        Point[] points={new Point(25,50),new Point(25,100),new Point(25,150),new Point(25,200),new Point(200,50)
                ,new Point(100,50),new Point(100,100),new Point(100,150),new Point(100,200),
                new Point(260,50),new Point(200,250),new Point(50,250),new Point(350,250)};
        Point[] dimension={
                new Point(70,25),new Point(70,25),new Point(70,25),new Point(70,25),new Point(50,25)
                ,new Point(100,25),new Point(100,25),new Point(100,25),new Point(100,25),
                new Point(100,25),new Point(100,25),new Point(100,25),new Point(100,25)
        };
        JButton saveButton=new JButton("Save"),browserButton=new JButton("Browse"),cancelButton=new JButton("cancel");
        ImageIcon imageIcon;
        boolean haveAphoto;
        Diffrent(int numOfPanel){
            JFrame f=new JFrame("add dish");
            JPanel frame=new JPanel();
            frame.setPreferredSize(new Dimension(375,350));
            f.setSize(375,350);
            frame.setLayout(null);

            for (int i=0;i<5;i++){
                labels[i].setOpaque(true);
                labels[i].setBounds(points[i].getX(),points[i].getY(),dimension[i].getX(),dimension[i].getY());
                labels[i].setHorizontalAlignment(JLabel.CENTER);
                frame.add(labels[i]);
            }

            for (int i=0;i<4;i++){
                textBox[i]=new JTextField();
                textBox[i].setBounds(points[i+5].getX(),points[i+5].getY(),dimension[i+5].getX(),dimension[i+5].getY());
                frame.add(textBox[i]);
            }
            saveButton.setBounds(points[10].getX(),points[10].getY(),dimension[10].getX(),dimension[10].getY());
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String str=new String();
                    str+=textBox[0].getText()+","+textBox[1].getText()+","+textBox[2].getText()+","+textBox[3].getText();
                    if ( textBox[0].getText().equals("")||textBox[2].getText().equals("")||textBox[3].getText().equals(""))
                        JOptionPane.showMessageDialog(null ,"Sorry ,  error was ocuued "+"\uD83D\uDE22"+(textBox[0].getText().equals("")?"name is empty":textBox[2].getText().equals("")?"price is empty":textBox[3].getText().equals("")?"count is empty":"3"),"Error",JOptionPane.ERROR_MESSAGE);
                    else if(imageIcon==null )
                        JOptionPane.showMessageDialog(null ,"Sorry ,  error was ocuued "+"\uD83D\uDE22"+"\nerror in image","Error",JOptionPane.ERROR_MESSAGE);

                    else
                        try{
                            dishes.add( new dish(imageIcon,str,numOfPanel));//("<html>Line 1<br>Line 2<br>Line 3</html>" );
                            if(momory.get(textBox[0].getText())==null){
                                momory.put(textBox[0].getText(),dishes.get(dishes.size()-1));
                                flowslayout.add(new JPanel(new FlowLayout()));
                                flowslayout.get(flowslayout.size()-1).add(dishes.get(dishes.size()-1));}
                            else
                                JOptionPane.showMessageDialog(null,"dish name already take");

                            flowslayout.get(flowslayout.size()-1).setBackground(new Color(37,40,54));
                            panel[numOfPanel].add(flowslayout.get(flowslayout.size()-1));

                        }
                        catch (Exception exception){
                            JOptionPane.showMessageDialog(null ,"Sorry ,  er22ror was ocuued 22"+"\uD83D\uDE22","Error",JOptionPane.ERROR_MESSAGE);
                            System.out.println(exception);
                            System.out.println(textBox[0].getText());
                        }
                }
            });
            cancelButton.setBounds(points[11].getX(),points[11].getY(),dimension[11].getX(),dimension[11].getY());
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                }
            });

            frame.add(cancelButton);
            frame.add(saveButton);
            browserButton.setBounds(points[9].getX(),points[9].getY(),dimension[9].getX(),dimension[9].getY());
            browserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try{
                        haveAphoto=true;
                        JFileChooser chooser=new JFileChooser();
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
                        chooser.setFileFilter(filter);
                        int c=chooser.showOpenDialog(null);
                        File selectedFile = chooser.getSelectedFile();
                        imageIcon = new ImageIcon(selectedFile.getAbsolutePath());

                    }
                    catch (Exception exception){
                        JOptionPane.showMessageDialog(null ,"Sorry ,  photo is invalid "+"\uD83D\uDE22","Error",JOptionPane.ERROR_MESSAGE);
                        haveAphoto=false;
                    }




                }
            });
            frame.add(browserButton);

            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            f.add(frame);
            f.pack();
            f.setVisible(true);
        }

        dish d;
        Diffrent(dish o,int numOfPanel){
            d=o;
            JFrame f=new JFrame("edit dish");
            JPanel frame=new JPanel();
            frame.setPreferredSize(new Dimension(375,350));
            f.setSize(375,350);
            frame.setLayout(null);

            for (int i=0;i<5;i++){
                labels[i].setOpaque(true);
                labels[i].setBounds(points[i].getX(),points[i].getY(),dimension[i].getX(),dimension[i].getY());
                labels[i].setHorizontalAlignment(JLabel.CENTER);
                frame.add(labels[i]);
            }

            for (int i=0;i<4;i++){
                textBox[i]=new JTextField();
                textBox[i].setBounds(points[i+5].getX(),points[i+5].getY(),dimension[i+5].getX(),dimension[i+5].getY());
                frame.add(textBox[i]);
            }
            /***/
            textBox[0].setText(o.getName());
            textBox[1].setText(o.getDescription());
            textBox[2].setText(String.valueOf(o.getPrice()));
            textBox[3].setText(String.valueOf(o.getCount()));
            imageIcon=d.getIcons();
            /*****/
            saveButton.setBounds(points[10].getX()-25,points[10].getY(),dimension[10].getX()-30,dimension[10].getY());
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String str=new String();
                    str+=textBox[0].getText()+","+textBox[1].getText()+","+textBox[2].getText()+","+textBox[3].getText();
                    if ( textBox[0].getText().equals("")||textBox[2].getText().equals("")||textBox[3].getText().equals(""))
                        JOptionPane.showMessageDialog(null ,"Sorry ,  error was ocuued "+"\uD83D\uDE22"+(textBox[0].getText().equals("")?"name is empty":textBox[2].getText().equals("")?"price is empty":textBox[3].getText().equals("")?"count is empty":"3"),"Error",JOptionPane.ERROR_MESSAGE);
                    else if(imageIcon==null )
                        JOptionPane.showMessageDialog(null ,"Sorry ,  error was ocuued "+"\uD83D\uDE22"+"\nerror in image","Error",JOptionPane.ERROR_MESSAGE);

                    else
                        try{
                            d=new dish(o);
                            momory.remove(o.getName());
                            //momory.remove(o.getName());
                            o.setName(textBox[0].getText());
                            o.setDescription(textBox[1].getText());
                            o.setPrice(Double.valueOf(textBox[2].getText()));
                            o.setCount(Integer.valueOf(textBox[3].getText()));
                            //o.setIcons(imageIcon);
                            momory.put(o.getName(),o);
                            o.reassign();
                            //panel.add(new JPanel(new FlowLayout()).add(o));


                        }
                        catch (Exception exception){
                            JOptionPane.showMessageDialog(null ,"Sorry ,  er222ror was ocuued "+"\uD83D\uDE22","Error",JOptionPane.ERROR_MESSAGE);
                            System.out.println(exception);
                            System.out.println(textBox[0].getText());
                        }
                }
            });
            cancelButton.setBounds(points[11].getX(),points[11].getY(),dimension[11].getX(),dimension[11].getY());
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                }
            });
            JButton removeButton= new JButton("remove");
            removeButton.setBounds(points[12].getX()-70,points[12].getY(),dimension[12].getX()-20,dimension[12].getY());
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i=0;i<flowslayout.size();i++){
                        if(flowslayout.get(i).getComponent(0).equals(o)){
                            panel[numOfPanel].remove(flowslayout.get(i));
                            flowslayout.remove(i);
                        }
                    }
                    panel[0].revalidate();
                    momory.remove(o.getName());
                    f.dispose();
                }
            });
            frame.add(removeButton);
            frame.add(cancelButton);
            frame.add(saveButton);
            browserButton.setBounds(points[9].getX(),points[9].getY(),dimension[9].getX(),dimension[9].getY());
            browserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    try{
                        haveAphoto=true;
                        JFileChooser chooser=new JFileChooser();
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
                        chooser.setFileFilter(filter);
                        int c=chooser.showOpenDialog(null);
                        File selectedFile = chooser.getSelectedFile();
                        imageIcon = new ImageIcon(selectedFile.getAbsolutePath());

                    }
                    catch (Exception exception){
                        JOptionPane.showMessageDialog(null ,"Sorry ,  photo is invalid "+"\uD83D\uDE22","Error",JOptionPane.ERROR_MESSAGE);
                        haveAphoto=false;
                    }




                }
            });
            frame.add(browserButton);

            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            f.add(frame);
            f.pack();
            f.setVisible(true);
        }


    }

    ArrayList<dish> dishes=new ArrayList<>() ;
    JPanel []panel=new JPanel[6];
    JPanel [] panels;
    ImageIcon []photoIcon;
    ArrayList <JPanel> flowslayout=new ArrayList<>();
    public LinkedHashMap<String,dish>momory=new LinkedHashMap<>();
    public TabbedPaneExample1() {


        //--------------------------------------------


        setLayout(new BorderLayout());
        for(int i=0;i<6;i++){
        panel[i] = new JPanel();
        panel[i].setPreferredSize(new Dimension(300,1500));}
        panels =new JPanel[5];
        int j=0;
        String str="pizza";
        for (int i=0;i<6;i++){
        panel[i].setLayout(new GridLayout(0,3,0,0));//new BoxLayout(panel, BoxLayout.Y_AXIS)
        panel[i].setBackground(new Color(37,40,54));}
        JPanel []AddPanel=new JPanel[6];
        JLabel[]AddLabel=new JLabel[6];
        for (int i=0;i<6;i++){
                AddLabel[i]=new JLabel("<html><center><h1 style='font-size: 50pt; '>+</h1><br style='font-size: 20pt;'>Add Dish</br></center></html>");
        AddLabel[i].setHorizontalAlignment(JLabel.CENTER);
        AddLabel[i].setForeground(new Color(234,124,105));
        AddLabel[i].setOpaque(true);
        AddLabel[i].setFont(new Font("Arial",Font.BOLD,24));

        //AddLabel.setBorder(BorderFactory.createDashedBorder(10,new Color(234,124,105),5, 10, 5));
        AddLabel[i].setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0,0,0,0),new CompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createDashedBorder(new Color(234,124,105),10f,10f))));

        AddLabel[i].setBackground(new Color(37,40,54));
             AddPanel[i]=new JPanel(null);
        AddPanel[i].setSize(200,200);

        AddLabel[i].setBounds(AddPanel[i].getWidth()/4,AddPanel[i].getHeight()/4+20,175,250);
        AddPanel[i].setAlignmentX(JPanel.CENTER_ALIGNMENT);
        AddPanel[i].setAlignmentY(JPanel.CENTER_ALIGNMENT);
        AddPanel[i].setBackground(new Color(37,40,54));
        AddPanel[i].add(AddLabel[i]);}


        AddLabel[0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                    new Diffrent(0);
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        AddLabel[1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {



                    new Diffrent(1);
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        AddLabel[2].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                    new Diffrent(2);
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        AddLabel[3].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                    new Diffrent(3);
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        AddLabel[4].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                    new Diffrent(4);
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        AddLabel[5].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                    new Diffrent(5);
            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        for (int i=0;i<6;i++)
        panel[i].add(AddPanel[i]);


        // Create a panel to hold the labels


        ;
JScrollBar verticalScrollBar=new JScrollBar();
JScrollPane[]scrollPane=new JScrollPane[6];
        // Create a scroll pane and add the panel to it
        for(int i=0;i<6;i++){

         scrollPane[i] = new JScrollPane(panel[i]);
            scrollPane[i].setViewportView(panel[i]);
            scrollPane[i].setPreferredSize(new Dimension(900,500));
            scrollPane[i].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            verticalScrollBar.setBackground(new Color(37,40,54));
            verticalScrollBar.setForeground(new Color(37,40,54));
            verticalScrollBar.setBorder(BorderFactory.createEmptyBorder());
            verticalScrollBar.setPreferredSize(new Dimension(15, 100));
            scrollPane[i].setVerticalScrollBar(verticalScrollBar);
            scrollPane[i].getVerticalScrollBar().setUI(new BasicScrollBarUI(){

                private static final int THUMB_SIZE = 4;
                private static final int TRACK_SIZE = 0;

                @Override
                protected void configureScrollBarColors() {
                    // Set the color of the scrollbars
                    thumbColor = Color.GRAY;
                    thumbDarkShadowColor = Color.DARK_GRAY;
                    thumbHighlightColor = Color.LIGHT_GRAY;
                    thumbLightShadowColor = Color.LIGHT_GRAY;
                    trackColor = Color.WHITE;
                    trackHighlightColor = Color.LIGHT_GRAY;
                }

                @Override
                protected JButton createDecreaseButton(int orientation) {
                    // Create a hidden decrease button to remove the default arrow
                    return new JButton() {
                        @Override
                        public Dimension getPreferredSize() {
                            return new Dimension();
                        }
                    };
                }

                @Override
                protected JButton createIncreaseButton(int orientation) {
                    // Create a hidden increase button to remove the default arrow
                    return new JButton() {
                        @Override
                        public Dimension getPreferredSize() {
                            return new Dimension();
                        }
                    };
                }

                @Override
                protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                    // Paint the thumb as a thin rounded rectangle
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(thumbColor);
                    int x = thumbBounds.x + (thumbBounds.width - THUMB_SIZE) / 2;
                    int y = thumbBounds.y + (thumbBounds.height - THUMB_SIZE) / 2;
                    g2.fillRoundRect(x, y, THUMB_SIZE, THUMB_SIZE*10, 4, 4);
                    g2.dispose();
                }

                @Override
                protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                    // Paint the track as a thin rounded rectangle
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(trackColor);
                    int x = trackBounds.x + (trackBounds.width - TRACK_SIZE) / 2;
                    int y = trackBounds.y + (trackBounds.height - TRACK_SIZE) / 2;
                    g2.fillRoundRect(x, y, TRACK_SIZE, TRACK_SIZE, 4, 4);
                    g2.dispose();
                }});
            scrollPane[i].getHorizontalScrollBar().setUI(new BasicScrollBarUI(){

                private static final int THUMB_SIZE = 8;
                private static final int TRACK_SIZE = 4;

                @Override
                protected void configureScrollBarColors() {
                    // Set the color of the scrollbars
                    thumbColor = Color.GRAY;
                    thumbDarkShadowColor = Color.DARK_GRAY;
                    thumbHighlightColor = Color.LIGHT_GRAY;
                    thumbLightShadowColor = Color.LIGHT_GRAY;
                    trackColor = Color.WHITE;
                    trackHighlightColor = Color.LIGHT_GRAY;
                }

                @Override
                protected JButton createDecreaseButton(int orientation) {
                    // Create a hidden decrease button to remove the default arrow
                    return new JButton() {
                        @Override
                        public Dimension getPreferredSize() {
                            return new Dimension();
                        }
                    };
                }

                @Override
                protected JButton createIncreaseButton(int orientation) {
                    // Create a hidden increase button to remove the default arrow
                    return new JButton() {
                        @Override
                        public Dimension getPreferredSize() {
                            return new Dimension();
                        }
                    };
                }

                @Override
                protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                    // Paint the thumb as a thin rounded rectangle
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(thumbColor);
                    int x = thumbBounds.x + (thumbBounds.width - THUMB_SIZE) / 2;
                    int y = thumbBounds.y + (thumbBounds.height - THUMB_SIZE) / 2;
                    g2.fillRoundRect(x, y, THUMB_SIZE, THUMB_SIZE, 4, 4);
                    g2.dispose();
                }

                @Override
                protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                    // Paint the track as a thin rounded rectangle
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(trackColor);
                    int x = trackBounds.x + (trackBounds.width - TRACK_SIZE) / 2;
                    int y = trackBounds.y + (trackBounds.height - TRACK_SIZE) / 2;
                    g2.fillRoundRect(x, y, TRACK_SIZE, TRACK_SIZE, 4, 4);
                    g2.dispose();
                }});
//scrollPane[i].add(verticalScrollBar);
verticalScrollBar=new JScrollBar();
        }
        // Add the scroll pane to the frame
        //-------------------------------------------

        UIManager.put("TabbedPane.selected", new Color(37,40,54));

        // Create a tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setForeground(Color.WHITE);
        tabbedPane.setBackground(new Color(37,40,54));

        // Create panels for the tabs
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(37,40,54));
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(37,40,54));
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(37,40,54));

        // Add components to the panels
        panel1.add(new JLabel("This is Panel 1"));
        panel2.add(new JLabel("This is Panel 2"));
        panel3.add(new JLabel("This is Panel 3"));

        JPanel panel4 = new JPanel();
        panel4.setBackground(new Color(37,40,54));
        JPanel panel5 = new JPanel();
        panel5.setBackground(new Color(37,40,54));
        JPanel panel6 = new JPanel();
        panel6.setBackground(new Color(37,40,54));

        // Add components to the panels
        panel4.add(new JLabel("This is Panel 1"));
        panel5.add(new JLabel("This is Panel 2"));
        panel6.add(new JLabel("This is Panel 3"));

        // Add the panels to the tabbed pane with titles
        tabbedPane.addTab("Hot Dishes", panel1);
        tabbedPane.addTab("Cold Dishes", panel2);
        tabbedPane.addTab("soup", panel3);
        tabbedPane.addTab("Grill", panel4);
        tabbedPane.addTab("Apperizer", panel5);
        tabbedPane.addTab("Dessert", panel6);
        tabbedPane.setBorder(null);
        tabbedPane.setForegroundAt(0,new Color(234,124,105));

        // Add the tabbed pane to the frame
        add(tabbedPane);
        setOpaque(false);
        tabbedPane.setPreferredSize(new Dimension(600,600));
        tabbedPane.setBorder(null);
        for (int i=0;i<6;i++)
        tabbedPane.setComponentAt(i,scrollPane[i]);

        tabbedPane.setUI(new BasicTabbedPaneUI(){
            private static final int TAB_HEIGHT = 30;

            @Override
            protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {
                super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);

                Rectangle tabRect = rects[tabIndex];

                if (tabPane.getSelectedIndex() == tabIndex) {
                    g.setColor(new Color(234,124,105));
                    g.fillRect(tabRect.x, tabRect.y + tabRect.height - 3, tabRect.width-25, 3);
                }
            }

            @Override
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
                // Remove the content border painting
                tabbedPane.setBorder(new EmptyBorder(0,0,0,0));

            }



            @Override
            protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
                return TAB_HEIGHT;
            }
        });


        tabbedPane.setFocusable(false);
        tabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tabbedPane.getSelectedComponent().setForeground(Color.yellow);
                System.out.println("Tab: " + tabbedPane.getSelectedIndex());

                for(int i=0;i<tabbedPane.getTabCount();i++){
                    tabbedPane.setForegroundAt(i,Color.WHITE);
                    if(tabbedPane.getSelectedIndex()==i)
                        tabbedPane.setForegroundAt(i,new Color(234,124,105));
                }
                // Prints the string 3 times if there are 3 tabs etc
            }
        });

        JPanel tailPayPanel=new JPanel(new FlowLayout(FlowLayout.LEFT,10,50));
        tailPayPanel.setOpaque(false);
        JButton conformButtom=new JButton(" save change");
        conformButtom.setBackground(new Color(234,124,105));
        conformButtom.setPreferredSize(new Dimension(100,30));
        conformButtom.setForeground(Color.white);

        conformButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tailPayPanel.add(conformButtom);
        setPreferredSize(new Dimension(800,800));
        JButton cancelButtom=new JButton("   discard   ");
        cancelButtom.setBackground(new Color(37,40,54));
        cancelButtom.setForeground(new Color(234,124,105));
        cancelButtom.setPreferredSize(new Dimension(100,30));
        cancelButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        tailPayPanel.add(cancelButtom);
        cancelButtom.setBorder(BorderFactory.createLineBorder(new Color(234,124,105)));
        add(tailPayPanel,BorderLayout.SOUTH);



    }

    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());

        Container c=frame.getContentPane();
        c.setBackground(new Color(37,40,54));
        frame.setTitle("Tabbed Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TabbedPaneExample1 tab=new TabbedPaneExample1();
        tab.setPreferredSize(new Dimension(800,600));
        frame .add( tab);
        frame. pack();
        frame.  setSize(900,700);
        frame.setVisible(true);
    }

}

public class zeftPro {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setLayout(new BorderLayout());

        Container c=frame.getContentPane();
        c.setBackground(new Color(37,40,54));
        frame.setTitle("Tabbed Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TabbedPaneExample1 tab=new TabbedPaneExample1();
        tab.setPreferredSize(new Dimension(1000,1000));
        frame.getContentPane() .add( tab);
        frame. pack();
        frame.  setSize(1000,1000);
        frame.setVisible(true);
    }
}
