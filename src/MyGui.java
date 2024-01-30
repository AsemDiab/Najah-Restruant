

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class MyGui extends JFrame {
    JLabel lblRestaurantName;
    JLabel lblDate;
    SearchTextField txtSearch;

    MyGui(){
        super("An-Najah Rest");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Container f=getContentPane();
        f.setBackground(new Color(37,40,54));
        f.validate();
// side color(31,29,34 ) button color (234,124,105) frame new Color(37,40,54)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(new Color(37,40,54));
        lblRestaurantName = new JLabel("Restaurant Name");
        lblRestaurantName.setForeground(Color.WHITE);
        lblRestaurantName.setFont(new Font("Serif", Font.BOLD, 25));
        topPanel.add(lblRestaurantName);
        add(topPanel, BorderLayout.NORTH);
        JPanel centerPanel = new JPanel(new BorderLayout());
centerPanel.setBackground(new Color(37,40,54));
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBackground(new Color(37,40,54));
        LocalDateTime d= LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy ");
        String formattedDate = d.format(myFormatObj);
        lblDate = new JLabel(formattedDate);
        lblDate.setForeground(new Color(179,184,190));
        ;

        infoPanel.add(lblDate);
        final ImageIcon image = new ImageIcon("searchicon.png");
        //txtSearch.setIcon(image);
        txtSearch = new SearchTextField(20);


        infoPanel.add(txtSearch);
        centerPanel.add(infoPanel, BorderLayout.NORTH);
        centerPanel.add(new JPanel(null).add(new Dish(new ImageIcon(getClass().getResource("papoasoup.png")) ,"a,2,4,5",0)),BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);



        setVisible(true);
    }

    class SearchTextField extends JTextField {
        private ImageIcon searchIcon;

        public SearchTextField() {
            searchIcon = new ImageIcon(getClass().getResource("search-icon.png")); // Replace with the path to your search icon
            int iconWidth = searchIcon.getIconWidth();
            int iconHeight = searchIcon.getIconHeight();

            // Set the preferred size of the text field to accommodate the icon
            Dimension preferredSize = getPreferredSize();
            preferredSize.width += iconWidth + 5; // Add extra space for the icon
            setPreferredSize(preferredSize);
        }
        public SearchTextField(int x) {
            super(x);
            searchIcon = new ImageIcon(getClass().getResource("search-icon.png")); // Replace with the path to your search icon
            int iconWidth = searchIcon.getIconWidth();
            int iconHeight = searchIcon.getIconHeight();

            // Set the preferred size of the text field to accommodate the icon
            Dimension preferredSize = getPreferredSize();
            preferredSize.width += iconWidth + 5; // Add extra space for the icon
            setPreferredSize(preferredSize);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the search icon next to the text
            int iconWidth = searchIcon.getIconWidth();
            int iconHeight = searchIcon.getIconHeight();
            int x = getWidth() - iconWidth - 5; // Position the icon 5 pixels from the right edge
            int y = (getHeight() - iconHeight) / 2; // Center the icon vertically

            g.drawImage(searchIcon.getImage(), this.getWidth()-(3*this.getHeight()/4), this.getHeight()/4, this.getHeight()/2,this.getHeight()/2,this);
        }


    }

    public static void main(String []args){
        new MyGui();
    }
}
