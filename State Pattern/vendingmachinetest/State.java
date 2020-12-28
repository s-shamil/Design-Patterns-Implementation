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
public interface State {
    public void ChooseDrink(); //for selecting which drink how many bottles
    public void InsertCoin(); //pay first
    public void PressButton(); //done payment, request drink : will check if it can go for dispensing and change state
    public void Dispense();
    public void TakeDrink(); //Clear Served Slot 
}
