/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinetest;

/**
 *
 * @author lelmil
 */
public class DeliveringDrinkState implements State{
    
    VendingMachine vm = null;
    
    public DeliveringDrinkState(VendingMachine machine){
        this.vm = machine;
    }
    
    @Override
    public void ChooseDrink() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Dispensing ongoing, cannot process request right now!");
    }

    @Override
    public void InsertCoin() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Dispensing ongoing, cannot process request right now!");
    }

    @Override
    public void PressButton() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Dispensing ongoing, cannot process request right now!");
    }

    @Override
    public void TakeDrink() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Dispensing ongoing, cannot process request right now!");
    }

    @Override
    public void Dispense() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        vm.DrinkLeft.set(vm.CurrOrderDrinkID, vm.DrinkLeft.get(vm.CurrOrderDrinkID) - vm.CurrOrderQty);
        int change = vm.deposited_money - vm.money_to_be_paid;
        vm.change_available -= change;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Slot Contains: " + vm.DrinkNames.get(vm.CurrOrderDrinkID) + " " + vm.CurrOrderQty + " bottles!");
        if(change>0) System.out.println("Change Money: " + change + "/- returned!");
        System.out.println("Collect your drink!");
        System.out.println("-----------------------------------------------------------------");
        vm.SetCurrentState(vm.getServedState());
    }
}
