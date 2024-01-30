//
    import javax.swing.*;
    import javax.swing.border.EmptyBorder;
    import javax.swing.border.LineBorder;
    import javax.swing.event.ChangeEvent;
    import javax.swing.event.ChangeListener;
    import javax.swing.plaf.LabelUI;
    import javax.swing.plaf.basic.BasicLabelUI;
    import javax.swing.plaf.basic.BasicTabbedPaneUI;
    import java.awt.*;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;


public class TabbedPaneExample extends JFrame {

        public TabbedPaneExample() {
            Container c=getContentPane();
            c.setBackground(new Color(37,40,54));
            setTitle("Tabbed Pane Example");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
            // Add the panels to the tabbed pane with titles
            tabbedPane.addTab("Tab 1", panel1);
            tabbedPane.addTab("Tab 2", panel2);
            tabbedPane.addTab("Tab 3", panel3);
            tabbedPane.setBorder(null);
            tabbedPane.setForegroundAt(0,new Color(234,124,105));

            // Add the tabbed pane to the frame
            add(tabbedPane);
            tabbedPane.setBorder(null);

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


            pack();
            setVisible(true);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new TabbedPaneExample());
        }

    }

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class TabbedPaneExample extends JFrame {
//    private JPanel tabPanel;
//    private JPanel contentPanel;
//
//    public TabbedPaneExample() {
//        setTitle("TabbedPane Example");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(300, 200);
//
//        // Create the tab panel to hold the tab buttons
//        tabPanel = new JPanel();
//        tabPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        tabPanel.setBackground(Color.LIGHT_GRAY);
//
//        // Create the content panel to hold the content for each tab
//        contentPanel = new JPanel();
//        contentPanel.setLayout(new BorderLayout());
//
//        // Create the tab buttons
//        JButton tabButton1 = createTabButton("Tab 1");
//        JButton tabButton2 = createTabButton("Tab 2");
//
//        // Add action listeners to the tab buttons
//        tabButton1.addActionListener(new TabButtonListener());
//        tabButton2.addActionListener(new TabButtonListener());
//
//        // Add the tab buttons to the tab panel
//        tabPanel.add(tabButton1);
//        tabPanel.add(tabButton2);
//
//        // Set the initial tab as selected
//        selectTab(tabButton1);
//
//        // Add the panels to the frame
//        add(tabPanel, BorderLayout.NORTH);
//        add(contentPanel, BorderLayout.CENTER);
//    }
//
//    private JButton createTabButton(String text) {
//        JButton tabButton = new JButton(text);
//        tabButton.setFocusPainted(false);
//        tabButton.setBorderPainted(false);
//        tabButton.setBackground(Color.LIGHT_GRAY);
//        tabButton.setMargin(new Insets(5, 10, 5, 10));
//        return tabButton;
//    }
//
//    private void selectTab(JButton selectedTabButton) {
//        // Deselect all tab buttons
//        for (Component component : tabPanel.getComponents()) {
//            if (component instanceof JButton) {
//                JButton tabButton = (JButton) component;
//                tabButton.setBackground(Color.LIGHT_GRAY);
//            }
//        }
//
//        // Select the specified tab button
//        selectedTabButton.setBackground(Color.WHITE);
//
//        // Update the content panel based on the selected tab
//        contentPanel.removeAll();
//        if (selectedTabButton.getText().equals("Tab 1")) {
//            contentPanel.add(new JLabel("This is Tab 1 content"));
//        } else if (selectedTabButton.getText().equals("Tab 2")) {
//            contentPanel.add(new JLabel("This is Tab 2 content"));
//        }
//        contentPanel.revalidate();
//        contentPanel.repaint();
//    }
//
//    private class TabButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JButton selectedTabButton = (JButton) e.getSource();
//            selectTab(selectedTabButton);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            TabbedPaneExample example = new TabbedPaneExample();
//            example.setVisible(true);
//        });
//        JLabel label=new JLabel();
//       // label.setUI
//    }
//}