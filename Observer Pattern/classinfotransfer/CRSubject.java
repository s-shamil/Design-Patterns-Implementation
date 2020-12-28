/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classinfotransfer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lelmil
 */
public class CRSubject {
    private List<Observer> registeredObservers = new ArrayList<Observer>();
    private String news;
    
    public String getNews(){
        return news;
    }
    
    public void setNews(String s){
        this.news = s;
        notifyAllObservers();
    }
    
    public void register(Observer observer){
        if(!registeredObservers.contains(observer)){
            observer.setObserverNews("No news till now! Connected!");
            registeredObservers.add(observer);
            System.out.println("User added!");
        }
        else{
            System.out.println("User already exists!");
        }
    }
    
    public void unregister(Observer observer){
        if(registeredObservers.contains(observer)){
            observer.setObserverNews("No news available! Disconnected!");
            registeredObservers.remove(observer);
            System.out.println("User removed!");
        }
        else{
            System.out.println("User not found!");
        }
    }
    
    public void notifyAllObservers(){
        for(Observer observer: registeredObservers){
            observer.update();
        }
    }
}
