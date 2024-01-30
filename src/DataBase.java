import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

public class DataBase {
    private LinkedHashMap<String,LinkedHashMap>mainLinker=new LinkedHashMap<>();
    private  final String []type={"Hot Dishes","Cold Dishes","Soup","Grill","Appetizer","Dessert"};
    public DataBase(){
        for (String t:type)
        mainLinker.put(t,new LinkedHashMap<>());

    }
    public void  addHotDish(Dish dish){
        mainLinker.get("Hot Dishes").put(dish.getName(),dish);
    }
    public void  addColdDish(Dish dish){
        mainLinker.get("Cold Dishes").put(dish.getName(),dish);
    }
    public void  addSoup(Dish dish){
        mainLinker.get("Soup").put(dish.getName(),dish);
    }
    public void  addGrill(Dish dish){
        mainLinker.get("Grill").put(dish.getName(),dish);
    }
    public void  addAppetizer(Dish dish){
        mainLinker.get("Appetizer").put(dish.getName(),dish);
    }
    public void  addDessert(Dish dish){
        mainLinker.get("Dessert").put(dish.getName(),dish);
    }

    public Dish  getHotDish(String name){
        return (Dish) mainLinker.get("Hot Dishes").get(name);
    }
    public   Dish getColdDish(String name){
        return (Dish) mainLinker.get("Cold Dishes").get(name);
    }
    public Dish  getSoup(String name){
        return (Dish) mainLinker.get("Soup").get(name);
    }
    public Dish  getGrill(String name){
        return (Dish) mainLinker.get("Grill").get(name);
    }
    public Dish  addAppetizer(String name){
        return (Dish) mainLinker.get("Appetizer").get(name);
    }
    public Dish  getDessert(String name){
        return (Dish) mainLinker.get("Dessert").get(name);
    }

    public void removeHotDish(Dish dish){
        mainLinker.get("Hot Dish").remove(dish);
    }
    public void removeColdDish(Dish dish){
        mainLinker.get("Cold Dish").remove(dish);
    }
    public void removeSoup(Dish dish){
        mainLinker.get("Soup").remove(dish);
    }
    public void removeGrill(Dish dish){
        mainLinker.get("Grill").remove(dish);
    }
    public void removeDessert(Dish dish){
        mainLinker.get("Dessert").remove(dish);
    }
    public void removeAppetizer(Dish dish){
        mainLinker.get("Appetizer").remove(dish);
    }
    public static void main(String[]args){
        DataBase dataBase=new DataBase();
        String arr[]={"hot","0","0","0"};
        for(int i=0;i<10;i++){
        dataBase.addHotDish(new Dish(arr));
        arr[0]=arr[0]+String.valueOf(i);
        arr[1]=String.valueOf(i);
    }
        arr=new String[]{"cold","0","0","0"};
        for(int i=0;i<10;i++){
            arr[0]=arr[0]+String.valueOf(i);
            dataBase.addColdDish(new Dish(arr));
            arr[1]=String.valueOf(i);
        }

        arr=new String[]{"Soup","0","0","0"};
        for(int i=0;i<10;i++){
            arr[0]=arr[0]+String.valueOf(i);
            dataBase.addSoup(new Dish(arr));

            arr[1]=String.valueOf(i);
        }
        String indes="Soup";
        for (int i=0;i<10;i++){
            indes+=String.valueOf(i);
            System.out.println(dataBase.getSoup(indes).getName() + " , "+dataBase.getSoup(indes).getCount());}

        indes="Soup";
        for (int i=0;i<10;i++){
            indes+=String.valueOf(i);
            dataBase.getSoup(indes).setCount(10);
            System.out.println(dataBase.getSoup(indes).getName() + " , "+dataBase.getSoup(indes).getCount());}
    }

}
//
//class Dish extends JPanel {
//    ImageIcon icon;
//    double price;
//    int count=0;
//    String name;
//    JLabel photoLabel;
//    JLabel textLabel;
//
//    public void paintComponent(Graphics g)
//    {
//        super.paintComponent(g);
//        g.setColor(new Color(37,40,54));
//        g.fillRoundRect(0,0,200,275,0,0);
//        g.setColor(new Color(31,29,34 ));
//        g.fillRoundRect(0,25,200,250,50,50);
//
//    }
//    String description;
//
//
//    Dish(String[]str){
//       setCount(Integer.valueOf(str[3]));
//       setPrice(Double.valueOf(str[2]));
//       setDescription(str[1]);
//       setName(str[0]);
//    }
//    Dish(Dish v){
//        this.count=v.count;
//        this.description=v.description;
//        this.name=v.name;
//        this.icon=v.icon;
//        this.price=v.price;
//        this.photoLabel=v.photoLabel;
//        this.textLabel=v.textLabel;
//    }
//    Dish(ImageIcon icon,String text){
//        try{
//            setBorder(BorderFactory.createEmptyBorder());
//            this .icon=icon;
//            setPreferredSize(new Dimension(200,275));
//            setAlignmentX(JPanel.CENTER_ALIGNMENT);
//            setLayout(new BorderLayout());
//
//            photoLabel=new JLabel(){
//                @Override
//                protected void paintComponent(Graphics g) {
//                    super.paintComponent(g);
//                    // Calculate the size of the visible area
//                    int visibleWidth = getWidth() / 2;
//                    int visibleHeight = getHeight();
//                    // Draw the photo
//                    g.drawImage(icon.getImage(), 50, 0, 100, 100, this);
//                }
//            };
//
//            String[]str=text.split(",");
//            JPanel p1=new JPanel(new FlowLayout());
//
//
//
//            textLabel=new JLabel("<html><center><h1 style='font-size: 14pt; color: White'>"+str[0]+"</h1>" +
//                    "<p style='font-size: 14pt; color: White'>"+str[1]+" </p>" +
//                    "<p style='font-size: 14pt; color: White'>"+str[2]+" $ </p>" +
//                    "<p style='font-size: 14pt; color:#B3B8BE'> "+str[3]+"</p></center></html>");
//
//            price=Double.valueOf(str[2]);
//            count=Integer.parseInt(str[3]);
//            name=str[0];
//            description=str[1];
//            description=str[1];
//            JPanel p=new JPanel(new GridLayout(2,1));
//            p.setOpaque(false);
//            add (photoLabel,BorderLayout.CENTER);
//            p.add(new JPanel(new FlowLayout(FlowLayout.CENTER)).add(textLabel));
//
//
//            add(p,BorderLayout.SOUTH);
//            photoLabel.setVerticalAlignment(JLabel.CENTER);
//            textLabel.setAlignmentX(JLabel.CENTER);
//            textLabel.setHorizontalAlignment(JLabel.CENTER);
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
//    }
//
//    public void setIcons(ImageIcon icon) {
//        this.icon = icon;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public ImageIcon getIcons() {
//        return icon;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void reassign() {
//
//        textLabel.setText("<html><center><h1 style='font-size: 14pt; color: White'>"+getName()+"</h1>" +
//                "<p style='font-size: 14pt; color: White'>"+getDescription()+" </p>" +
//                "<p style='font-size: 14pt; color: White'>"+getPrice()+" $ </p>" +
//                "<p style='font-size: 14pt; color:#B3B8BE'> "+getCount()+"</p></center></html>");
//
//    }
//}
//
