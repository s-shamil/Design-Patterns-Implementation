/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classinfotransfer;

/**
 *
 * @author lelmil
 */
public abstract class Observer {
    protected String news;
    protected CRSubject subject;
    public abstract void setObserverNews(String s);
    public abstract void update();
    public abstract void print();
}
