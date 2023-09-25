
package controller;

import model.FruitList;
import view.Menu;


public class ManagerFruitShop extends Menu<String>{

    private FruitList list= new FruitList();
    
    public ManagerFruitShop(String title, String[] s){
        super(title, s);
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                list.createFruit();
                break;
            case 2:
                list.viewOrders();
                break;
            case 3:
                list.shopping();
                break;
            case 4: 
                System.exit(0);               
        }
    }
    
}
