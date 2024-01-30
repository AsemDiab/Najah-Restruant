import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

class Dish extends JPanel {
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
        g.fillRoundRect(0,0,getWidth(),getHeight()-25,0,0);
        g.setColor(new Color(31,29,34 ));
        g.fillRoundRect(0,25,getWidth(),getHeight()-25,50,50);

    }
    String description;

     Dish(String[]str){
       setCount(Integer.valueOf(str[3]));
       setPrice(Double.valueOf(str[2]));
       setDescription(str[1]);
       setName(str[0]);
  }
    Dish(Dish v){
        this.count=v.count;
        this.description=v.description;
        this.name=v.name;
        this.icon=v.icon;
        this.price=v.price;
        this.photoLabel=v.photoLabel;
        this.textLabel=v.textLabel;
    }
    Dish(ImageIcon icon,String text,int n){
         setPreferredSize(new Dimension(100,100));
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


            add (photoLabel,BorderLayout.CENTER);


           add(textLabel,BorderLayout.SOUTH);



            //add(textLabel,BorderLayout.SOUTH);
            photoLabel.setVerticalAlignment(JLabel.CENTER);
            textLabel.setAlignmentX(JLabel.CENTER);
            textLabel.setHorizontalAlignment(JLabel.CENTER);
            //setPreferredSize(new Dimension(100,100));
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

public class zeftProMax extends JFrame {
     zeftProMax(){
         setSize(500,500);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //setLayout();
         JButton addButton=new JButton("+");
         JPanel mainp=new JPanel(new GridLayout(3,3,5,5));
         JPanel subp=new JPanel(new GridLayout(0,3,5,5));
         JScrollPane scrollPane=new JScrollPane();
         scrollPane.setViewportView(subp);
         addButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
               subp.add((new JPanel(new FlowLayout()).add(new Dish(new ImageIcon(getClass().getResource("papoasoup.png")) ,"a,2,4,5",0))));
                 getContentPane().validate();
             }
         });
         scrollPane.setPreferredSize(new Dimension(getWidth(),getHeight()-50));

         mainp.add(addButton);
         mainp.add(scrollPane);
         //getContentPane().
                 add(new JPanel().add(mainp));
         setVisible(true);
     }




     public static void main(String []str){
         JFrame frame=new JFrame();
         frame.setSize(500,500);
         frame.getContentPane().add(new socialMediaView());
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
     }
}

 class RoundLabel extends JLabel {
    private Color backgroundColor;
    private Color foregroundColor;
    private Shape shape;

    public RoundLabel(String text) {
        super(text);
        setOpaque(false);
        setForeground(Color.WHITE);
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(50, 50));

        // Create the initial round shape
        shape = new Ellipse2D.Double(0, 0, getWidth() - 1, getHeight() - 1);

        // Add the MouseListener to handle mouse events
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the shape to a rounded rectangle when the mouse enters
                RoundLabel l=(RoundLabel)e.getSource();
                l.removeAll();
                setIcon(new ImageIcon());
                l.setText("facebool");
                l.setPreferredSize(new Dimension(100, 50));
                l.setSize(100,50);
                int arcWidth = 50;//getWidth() ; // Adjust the arc width as desired
                int arcHeight = 50;//getHeight() ; // Adjust the arc height as desired
                shape = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
                repaint(); // Repaint to reflect the new shape
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change the shape back to the round shape when the mouse exits
                removeAll();
                setText("");
                setIcon(new ImageIcon(getClass().getResource("Facebook-Icon-PNG-211.png")));
                setPreferredSize(new Dimension(50, 50));
                setSize(50,50);
                shape = new Ellipse2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
                repaint(); // Repaint to reflect the round shape
            }
        });
    }

     @Override
     protected void paintComponent(Graphics g) {
         Graphics2D g2 = (Graphics2D) g.create();
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

         // Paint the background shape
         g2.setColor(backgroundColor);
         g2.fill(shape);

         // Paint the text
         super.paintComponent(g);

         g2.dispose();
     }

     @Override
     public void setBackground(Color background) {
         backgroundColor = background;
     }

     @Override
     public void setForeground(Color foreground) {
         foregroundColor = foreground;
         super.setForeground(foreground);
     }

     @Override
     public Color getBackground() {
         return backgroundColor;
     }

     @Override
     public Color getForeground() {
         return foregroundColor;
     }
    // Test the RoundLabel
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            RoundLabel label = new RoundLabel("Round Label");
            label.setForeground(Color.WHITE);
            label.setBackground(Color.BLUE);

            frame.add(label);
            frame.setSize(200, 200);
            frame.setVisible(true);
        });
    }
}

class socialMediaView extends JPanel {

    JLabel []label=new JLabel[4];

    socialMediaView(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        label[0]=new RoundLabel("facebook");
        label[0].setHorizontalAlignment(JLabel.CENTER);
        add(label[0]);
    }

}