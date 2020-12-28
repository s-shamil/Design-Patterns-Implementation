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
public class AcceptingCoinsState implements State {
    
    VendingMachine vm = null;
    
    public AcceptingCoinsState(VendingMachine machine){
        this.vm = machine;
    }
    @Override
    public void ChooseDrink() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Drink already chosen!");
    }

    @Override
    public void InsertCoin() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        System.out.println("Money To Be Paid: " + vm.money_to_be_paid + "/-");
        System.out.println("Enter Coin: 1. One Taka  2. Two Taka  3. Five Taka");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                vm.deposited_money += 1;
                break;
            case 2:
                vm.deposited_money += 2;
                break;
            case 3:
                vm.deposited_money += 5;
                break;
            default:
                break;
        }
        System.out.println("Deposited Money: " + vm.deposited_money + "/-");
    }

    @Override
    public void PressButton() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        //check if deposited money is less than required - action: eject money and return to idle state
        if(vm.deposited_money < vm.money_to_be_paid){
            System.out.println("Insufficient amount of money! " + vm.deposited_money + "/- ejected!");
            vm.deposited_money = 0;
            vm.SetCurrentState(vm.getIdleState());
            return;
        }
        //chack if change impossible - action: eject money and return to idle state
        int change_needed = vm.deposited_money - vm.money_to_be_paid;
        //int balance = vm.OnesForChange * 1 + vm.TwosForChange * 2 + vm.FivesForChange * 5;
        int balance = vm.change_available;
        
        //simple check, may not be correct in many cases. Dynamic Programming can be used here to check correctly
        if(balance<change_needed){
            System.out.println("Sorry! Couldn't manage change! " + vm.deposited_money + "/- ejected!");
            vm.deposited_money = 0;
            vm.SetCurrentState(vm.getIdleState());
            return;
        }
        
        //else - Go to Delivering drink state and call dispense
        vm.SetCurrentState(vm.getDeliveringDrinkState());
        vm.Dispense();
    }

    @Override
    public void TakeDrink() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Slot empty! Order is being processed, cannot collect drink!");
        vm.SetCurrentState(vm.getIdleState());
    }

    @Override
    public void Dispense() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Invalid Request");
    }
    
}
