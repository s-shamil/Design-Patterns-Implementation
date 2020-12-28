/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinetest;

import java.util.*;

/**
 *
 * @author lelmil
 */
public class VendingMachineTest {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        VendingMachine vm = new VendingMachine();
        
        //Adding to menu : Drink name, price, initial qty(can be zero)
        vm.AddDrinkToMenu("Coca Cola   ", 15, 10);
        vm.AddDrinkToMenu("Mirinda     ", 15, 1);
        vm.AddDrinkToMenu("Mountain Due", 15, 2);
        vm.AddDrinkToMenu("Pran Lichi  ", 10, 3);
        vm.AddDrinkToMenu("Orange Juice", 8, 4);
        
        Scanner sc = new Scanner(System.in);
        
        OUTER:
        while (true) {
            //vm.PrintMenu();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1. Choose Drink  2. Insert Coin  3. Get Drink  4. Collect & Clean");
            System.out.println("FOR OWNER: 5. Refill Drink  6. Refill Change  0. Exit");
            System.out.println("-----------------------------------------------------------------");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 0:
                    break OUTER;
                case 5:
                    vm.RefillDrink(5);
                    break;
                case 6:
                    vm.RefillChange(100);
                    break;
                case 1:
                    vm.ChooseDrink();
                    break;
                case 2:
                    vm.InsertCoin();
                    break;
                case 3:
                    vm.PressButton();
                    break;
                case 4:
                    vm.TakeDrink();
                    break;
                default:
                    break;
            }
        }
        
        
    }
    
}
