/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinetest;

import java.util.Scanner;

/**
 *
 * @author lelmil
 */
public class IdleState implements State {

    VendingMachine vm = null;

    public IdleState(VendingMachine machine) {
        this.vm = machine;
    }

    @Override
    public void ChooseDrink() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Scanner sc = new Scanner(System.in);
        vm.PrintMenu();

        System.out.print("Drink Number: ");
        int x = sc.nextInt();

        System.out.print("Quantity Needed: ");
        int qt = sc.nextInt();

        int qty_left = vm.DrinkLeft.get(x - 1);
        if (qty_left < qt) {
            System.out.println("Drink not available! Try another type!");
        } else {
            //change state to accept money
            vm.CurrOrderDrinkID = x-1;
            vm.CurrOrderQty = qt;
            vm.money_to_be_paid = qt * vm.DrinkPrice.get(x - 1);
            vm.deposited_money = 0;
            vm.SetCurrentState(vm.getAcceptingCoinsState());
        }
    }

    @Override
    public void InsertCoin() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Coin ejected! choose your drink please!");
    }

    @Override
    public void PressButton() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Cannot process request! No drink chosen!");
    }

    @Override
    public void TakeDrink() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("No drink available in the slot!");
    }

    @Override
    public void Dispense() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("No drink chosen!");
    }

}
