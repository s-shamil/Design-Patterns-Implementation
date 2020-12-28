/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachinetest;

import java.util.ArrayList;

/**
 *
 * @author lelmil
 */
public class VendingMachine {
    
    //static na diyeo kaj hote pare
    //stores drink names
    public ArrayList<String> DrinkNames = new ArrayList<String>();
    //store corresponding price per qty
    public ArrayList<Integer> DrinkPrice = new ArrayList<Integer>();
    //how many drink left
    public ArrayList<Integer> DrinkLeft = new ArrayList<Integer>();
    
    
    int CurrOrderDrinkID;
    int CurrOrderQty; //how many bottles ordered
    
    int OnesForChange;
    int TwosForChange;
    int FivesForChange;
    
    int change_available; //for simplicity assuming any change is possbile if our total money covers it
    
    int money_to_be_paid;
    int deposited_money;
    
    State idleState;
    State choosingDrinkState;
    State acceptingCoinsState;
    State deliveringDrinkState;
    State servedState;
    
    State CurrentState;
    
    public VendingMachine(){
        idleState = new IdleState(this);
        choosingDrinkState = new ChoosingDrinkState(this);
        acceptingCoinsState = new AcceptingCoinsState(this);
        deliveringDrinkState = new DeliveringDrinkState(this);
        servedState = new ServedState(this);
        
        CurrentState = idleState;
        
        money_to_be_paid = 0;
        deposited_money = 0;
        change_available = 10;
    }
    
    public void ChooseDrink(){
        CurrentState.ChooseDrink();
    }
    public void InsertCoin(){
        CurrentState.InsertCoin();
    }
    public void PressButton(){
        CurrentState.PressButton();
    }
    public void Dispense(){
        CurrentState.Dispense();
    }
    public void TakeDrink(){
        CurrentState.TakeDrink();
    }
    
    public void SetCurrentState(State state){
        CurrentState = state;
    }
    
    //functions for the owner
    public void AddDrinkToMenu(String s, int price, int adding){
        DrinkNames.add(s);
        DrinkPrice.add(price);
        DrinkLeft.add(adding);
    }
    
    public void RefillDrink(int amount_each){
        int len = DrinkNames.size();
        for(int i = 1; i<=len; i++){
            DrinkLeft.set(i-1, DrinkLeft.get(i-1) + amount_each);
        }
    }
    
    public void RefillChange(int amount){
        //OnesForChange += amount;
        //TwosForChange += amount;
        //FivesForChange += amount;
        change_available += amount;
    }
    
    public void PrintMenu(){
        int len = DrinkNames.size();
        System.out.println("=================================================================");
        System.out.println("=================================================================");
        
        System.out.println("   Drink Name ---- Price ---- Available");
        for(int i = 1; i<=len; i++){
            System.out.println(i+". " + DrinkNames.get(i-1) + " ---- " + DrinkPrice.get(i-1) + " ---- " + DrinkLeft.get(i-1));
        }
        System.out.println("=================================================================");
        System.out.println("=================================================================");
        
    }
    
    
    //getters of states
    public State getIdleState(){
        return idleState;
    }
    public State getChoosingDrinkState(){
        return choosingDrinkState;
    }
    public State getAcceptingCoinsState(){
        return acceptingCoinsState;
    }
    public State getDeliveringDrinkState(){
        return deliveringDrinkState;
    }
    public State getServedState(){
        return servedState;
    }
}
