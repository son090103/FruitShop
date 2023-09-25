
package model;

import java.util.ArrayList;
import java.util.Hashtable;
import view.Validation;


public class FruitList {
    private ArrayList<Fruit> list;    
    private Hashtable<String, ArrayList<Order>> ht;
    private Validation validation;
    
    public FruitList(){
        this.list= new ArrayList<>();        
        this.ht= new Hashtable<>();
        this.validation= new Validation();
    }
    
    public void createFruit(){
        while(true){
            int id= validation.checkInt("Enter ID Fruit: ");
            // kiểm tra xem id đã tồn tại hay chưa , nếu rồi thì không thể add vào dnah ách được n
            if(validation.checkIdExist(list, id)){
                continue;
            }
            String name= validation.checkInputString("Enter Fruit name");
            double price= validation.checkInputDouble("Enter Price Fruit: ");
            int quantity= validation.checkInt("Enter Quanity Fruit: ");
            String origin= validation.checkInputString("Enter Origin fruit: ");
            list.add(new Fruit(id, name, price, quantity, origin));
            if(!validation.checkInputYesNo()){
                return;
            }
        }
    }
    
    public void viewOrders(){
        if(ht.isEmpty()){
            System.err.println("No Order!");
        }
        for(String name: ht.keySet()){
            int total=0;
            System.out.println("Custumer: "+name);
            System.out.println(" Product |  Quantity  |  Price  |  Amount");
            ArrayList<Order> array_o= ht.get(name);
            for (int i = 0; i < array_o.size(); i++) {
                System.out.println((i+1)+"."+array_o.get(i).hienthi());
                total+=array_o.get(i).getAmount();
            }
            System.out.println("Total: "+total);
        }
    }
    
    public void shopping(){
        if(list.isEmpty()){
            System.err.println("List is empty!");
            return;
        }
        ArrayList<Order> list_o= new ArrayList<>();
        while(true){
            displayList();
            System.out.println("Enter your select about Fruit: ");
            int choice= validation.checkInputIntLimit(1, list.size());
            Fruit fruit= list.get(choice-1);
            System.out.println("You selected: "+fruit.getName());
            System.out.println("Please input quantity: ");
            int quantity= validation.checkInputIntLimit(1, fruit.getQuantity());        
            list_o.add(new Order(fruit.getName(), quantity, fruit.getPrice(), (quantity * fruit.getPrice())));
            fruit.setQuantity(fruit.getQuantity()-quantity);
            if(fruit.getQuantity()==0){
                list.remove(fruit);
            }
                if(!validation.checkInputYesNo()){
                    double total=0;
                    System.out.println("Product | Quantity | Price | Amount");
                    for (Order order : list_o) {
                        System.out.println(order);
                        total+=order.getAmount();
                    }
                    System.out.println("Total: "+total);
                    String name= validation.checkInputString("Input your name:");
                    ht.put(name, list_o);
                    return;
                }
        }
    
    }    
                    
    public void displayList(){
        System.out.println("| ++ Item++ | ++Fruit Name++ | ++Origin++ | ++Price++ | ++Quantity++ |");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("      "+(i+1)+list.get(i));
        }
    }
}
