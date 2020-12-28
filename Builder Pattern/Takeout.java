/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takeout;
import java.util.LinkedList;

/**
 *
 * @author lelmil
 */

//Common interface of Builder
interface BurgerMaker
{
    void AddPatty();
    void AddSauce();
    void AddCheese();
    Burger GetFood();
}

//ChickenBurger is a concrete builder
class ChickenBurger implements BurgerMaker
{
    private Burger burger = new Burger();
    
    @Override
    public void AddPatty()
    {
        burger.Add(" Patty for Chicken Burger ");
    }
    @Override
    public void AddSauce()
    {
        burger.Add(" Sauce for Chicken Burger ");
    }
    @Override
    public void AddCheese()
    {
        burger.Add(" Cheese for Chicken Burger ");
    }
    @Override
    public Burger GetFood()
    {
        return burger;
    }
}

//ChickenBurger is a concrete builder
class BeefBurger implements BurgerMaker
{
    private Burger burger = new Burger();
    
    @Override
    public void AddPatty()
    {
        burger.Add(" Patty for Beef Burger ");
    }
    @Override
    public void AddSauce()
    {
        burger.Add(" Sauce for Beef Burger ");
    }
    @Override
    public void AddCheese()
    {
        burger.Add(" Cheese for Beef Burger ");
    }
    @Override
    public Burger GetFood()
    {
        return burger;
    }
}

// Burger Class
class Burger
{
    private LinkedList<String> ingredients;
    public Burger()
    {
        ingredients = new LinkedList<String>();
    }
    public void Add(String ingredient)
    {
        ingredients.addLast(ingredient);
    }
    public void Show()
    {
        System.out.println("\n Burger prepared as below :");
        for(int i = 0; i<ingredients.size(); i++){
            System.out.println(ingredients.get(i));
        }
    }
}

// Waiter Class or Director
class Waiter
{
    BurgerMaker myMaker;
    //series of steps
    public void Prepare(BurgerMaker maker)
    {
        myMaker = maker;
        myMaker.AddPatty();
        myMaker.AddSauce();
        myMaker.AddCheese();
    }
}
public class Takeout {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("***Takeout Burger Shop***\n");
        
        Waiter waiter = new Waiter();
        BurgerMaker chickenBurger = new ChickenBurger();
        BurgerMaker beefBurger = new BeefBurger();
        
        //Making Chicken Burger
        waiter.Prepare(chickenBurger);
        Burger b1 = chickenBurger.GetFood();
        b1.Show();
        
        //Making Beef Burger
        waiter.Prepare(beefBurger);
        Burger b2 = beefBurger.GetFood();
        b2.Show();
    }
}
