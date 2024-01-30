//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//public class Main {
//    public static void main(String[] args) {
//
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new RestaurantOrderingSystem();
//            }
//        });
//    }
//}
//
//
//
//
//class Dish {
//    private String name;
//    private double price;
//
//    public Dish(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//}
//
//class Restaurant {
//    private String name;
//    private List<Dish> dishes;
//
//    public Restaurant(String name) {
//        this.name = name;
//        this.dishes = new ArrayList<>();
//    }
//
//    public void addDish(Dish dish) {
//        dishes.add(dish);
//    }
//
//    public List<Dish> getDishesByCategory(String category) {
//        // Implement logic to filter and return dishes based on the category
//        // You can maintain a category property in the Dish class or use other data structures
//        // to organize dishes by category
//        return null;
//    }
//}
//
//class OrderItem {
//    private Dish dish;
//    private int quantity;
//    private String notes;
//
//    public OrderItem(Dish dish, int quantity, String notes) {
//        this.dish = dish;
//        this.quantity = quantity;
//        this.notes = notes;
//    }
//
//    public Dish getDish() {
//        return dish;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public String getNotes() {
//        return notes;
//    }
//}
//
//class Order {
//    private int orderNumber;
//    private String selectedOption;
//    private List<OrderItem> orderItems;
//
//    public Order(int orderNumber) {
//        this.orderNumber = orderNumber;
//        this.orderItems = new ArrayList<>();
//    }
//
//    public void addItem(OrderItem item) {
//        orderItems.add(item);
//    }
//
//    public void removeItem(OrderItem item) {
//        orderItems.remove(item);
//    }
//
//    public double getTotalPrice() {
//        double total = 0.0;
//        for (OrderItem item : orderItems) {
//            total += item.getDish().getPrice() * item.getQuantity();
//        }
//        return total;
//    }
//}
//
// class RestaurantOrderingSystem {
//    private JFrame frame;
//    private JLabel lblRestaurantName;
//    private JLabel lblDate;
//    private JTextField txtSearch;
//    private JList<String> lstCategories;
//    private JButton btnSettings;
//    private JList<Dish> lstDishes;
//    private JButton btnAddToOrder;
//    private JList<OrderItem> lstOrderItems;
//    private JComboBox<String> cmbOptions;
//    private JButton btnRemove;
//    private JTextArea txtNotes;
//    private JTextField txtQuantity;
//    private JLabel lblTotalPrice;
//    private JButton btnContinueToPayment;
//
//    private Restaurant restaurant;
//    private Order order;
//
//    public RestaurantOrderingSystem() {
//        initialize();
//        restaurant = new Restaurant("Sample Restaurant");
//        order = new Order(1);
//    }
//
//    private void initialize() {
//        frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 600);
//        frame.setLayout(new BorderLayout());
//
//        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        lblRestaurantName = new JLabel("Restaurant Name");
//        lblRestaurantName.setFont(new Font("Serif", Font.BOLD, 20));
//        topPanel.add(lblRestaurantName);
//        frame.add(topPanel, BorderLayout.NORTH);
//
//        JPanel centerPanel = new JPanel(new BorderLayout());
//
//        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        lblDate = new JLabel(new Date().toString());
//        infoPanel.add(lblDate);
//        txtSearch = new JTextField(20);
//        infoPanel.add(txtSearch);
//        centerPanel.add(infoPanel, BorderLayout.NORTH);
//
//        JPanel categoriesPanel = new JPanel(new BorderLayout());
//        lstCategories = new JList<>(new String[]{"Category 1", "Category 2", "Category 3"}); // Replace with actual categories
//        categoriesPanel.add(lstCategories, BorderLayout.CENTER);
//        btnSettings = new JButton(new ImageIcon("settings.png")); // Replace with actual icon
//        btnSettings.setToolTipText("Settings"); // Tooltip for settings button
//        categoriesPanel.add(btnSettings, BorderLayout.EAST);
//        centerPanel.add(categoriesPanel, BorderLayout.WEST);
//
//        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        cmbOptions = new JComboBox<>(new String[]{"Dine in", "To go", "Delivery"});
//        optionsPanel.add(new JLabel("Options:"));
//        optionsPanel.add(cmbOptions);
//        centerPanel.add(optionsPanel, BorderLayout.CENTER);
//
//        JPanel dishesPanel = new JPanel(new BorderLayout());
//        lstDishes = new JList<>(); // Replace with list model of dishes in selected category
//        dishesPanel.add(new JScrollPane(lstDishes), BorderLayout.CENTER);
//        btnAddToOrder = new JButton("Add to Order");
//        dishesPanel.add(btnAddToOrder, BorderLayout.SOUTH);
//        centerPanel.add(dishesPanel, BorderLayout.EAST);
//
//        JPanel orderPanel = new JPanel(new BorderLayout());
//        lstOrderItems = new JList<>(); // Replace with list model of order items
//        orderPanel.add(new JScrollPane(lstOrderItems), BorderLayout.CENTER);
//        JPanel orderDetailsPanel = new JPanel(new BorderLayout());
//        orderDetailsPanel.add(new JLabel("Order Number: 1"), BorderLayout.NORTH);
//        JPanel optionsDetailsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        optionsDetailsPanel.add(new JLabel("Selected Option:"));
//        optionsDetailsPanel.add(cmbOptions);
//        orderDetailsPanel.add(optionsDetailsPanel, BorderLayout.CENTER);
//        JPanel itemsDetailsPanel = new JPanel(new BorderLayout());
//        itemsDetailsPanel.add(new JLabel("Selected Dishes:"), BorderLayout.NORTH);
//        JPanel itemDetailsPanel = new JPanel(new BorderLayout());
//        itemDetailsPanel.add(new JLabel("Dish Image"), BorderLayout.WEST); // Replace with actual image
//        JPanel itemInfoPanel = new JPanel(new GridLayout(3, 2));
//        itemInfoPanel.add(new JLabel("Dish Price: $10.99")); // Replace with actual price
//        txtQuantity = new JTextField(5);
//        itemInfoPanel.add(new JLabel("Quantity:"));
//        itemInfoPanel.add(txtQuantity);
//        itemInfoPanel.add(new JLabel("Notes:"));
//        txtNotes = new JTextArea(3, 20);
//        itemInfoPanel.add(new JScrollPane(txtNotes));
//        itemInfoPanel.add(new JLabel());
//        itemInfoPanel.setBackground(new Color(37,40,54));// Placeholder for remove button
//        itemDetailsPanel.add(itemInfoPanel, BorderLayout.CENTER);
//        itemsDetailsPanel.add(itemDetailsPanel, BorderLayout.CENTER);
//        orderDetailsPanel.add(itemsDetailsPanel, BorderLayout.SOUTH);
//        orderPanel.add(orderDetailsPanel, BorderLayout.WEST);
//        btnRemove = new JButton("Remove");
//        orderPanel.add(btnRemove, BorderLayout.EAST);
//        centerPanel.add(orderPanel, BorderLayout.SOUTH);
//
//        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        lblTotalPrice = new JLabel("Total Price: $0.00");
//        bottomPanel.add(lblTotalPrice);
//        btnContinueToPayment = new JButton("Continue to Payment");
//        bottomPanel.add(btnContinueToPayment);
//        centerPanel.add(bottomPanel, BorderLayout.SOUTH);
//
//        frame.add(centerPanel, BorderLayout.CENTER);
//
//        frame.setVisible(true);
//    }}