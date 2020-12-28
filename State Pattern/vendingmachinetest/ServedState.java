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
public class ServedState implements State {

    VendingMachine vm = null;
    
    public ServedState(VendingMachine machine){
        this.vm = machine;
    }
    
    @Override
    public void ChooseDrink() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Slot occupied! Collect drink first!");
    }

    @Override
    public void InsertCoin() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Slot occupied! Collect drink first!");
    }

    @Override
    public void PressButton() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Slot occupied! Collect drink first!");
    }

    @Override
    public void TakeDrink() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        vm.deposited_money = 0;
        System.out.println("Congratulations! Purchase successful!");
        vm.SetCurrentState(vm.getIdleState());
    }

    @Override
    public void Dispense() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Slot occupied! Collect drink first!");
    }
    
}
