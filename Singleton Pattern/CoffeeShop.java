/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop;

/**
 *
 * @author lelmil
 */

interface Coffee
{
    void AddMilk();
    void AddCaffeine();
    void AddSugar();
}

class CoffeeA implements Coffee
{
    @Override
    public void AddMilk()
    {
        System.out.println("Added Milk type A\n");
    }
    @Override
    public void AddCaffeine()
    {
        System.out.println("Added Caffeine type A\n");
    }
    @Override
    public void AddSugar()
    {
        System.out.println("Added Sugar type A\n");
    }
}

class CoffeeB implements Coffee
{
    @Override
    public void AddMilk()
    {
        System.out.println("Added Milk type B\n");
    }
    @Override
    public void AddCaffeine()
    {
        System.out.println("Added Caffeine type B\n");
    }
    @Override
    public void AddSugar()
    {
        System.out.println("No Sugar added\n");
    }
}

class CoffeeC implements Coffee
{
    @Override
    public void AddMilk()
    {
        System.out.println("Added Milk type C\n");
    }
    @Override
    public void AddCaffeine()
    {
        System.out.println("Added Caffeine type C\n");
    }
    @Override
    public void AddSugar()
    {
        System.out.println("Added Sugar type C\n");
    }
}

//coffee factory - singleton used to prevent multiple instances
class CoffeeFactory
{
    private static CoffeeFactory coffeeFactory = null;
    private Coffee coffee;
    
    private CoffeeFactory(){}
    
    public static CoffeeFactory getCoffeeFactory()
    {
        if(coffeeFactory==null){
            coffeeFactory = new CoffeeFactory();
        }
        return coffeeFactory;
    }
    
    public void produceCoffee(String which){
        coffee = null;
        if(which.equals("A"))
        {
            coffee = new CoffeeA();
        }
        else if(which.equals("B"))
        {
            coffee = new CoffeeB();
        }
        else if(which.equals("C")){
            coffee = new CoffeeC();
        }
        if(coffee!=null)
        {
            coffee.AddMilk();
            coffee.AddCaffeine();
            coffee.AddSugar();  
        }
        else
        {
            System.out.println("Not Available\n");
        }
    }
}



public class CoffeeShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CoffeeFactory coffeeFactory = CoffeeFactory.getCoffeeFactory();
        
        //Produce CoffeeA
        coffeeFactory.produceCoffee("A");
        //Produce CoffeeA
        coffeeFactory.produceCoffee("B");
        //Produce CoffeeA
        coffeeFactory.produceCoffee("C");
        //Invalid Order
        coffeeFactory.produceCoffee("D");
    }
    
}
