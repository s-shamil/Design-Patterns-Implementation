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
public class StudentObserver extends Observer {
    private int student_id;
    
    public StudentObserver(CRSubject subject, int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.subject = subject;
        this.student_id = id;
        this.news = "No news available! Disconnected!";
    }
    
    
    
    @Override
    public void update() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.setObserverNews(this.subject.getNews());
    }

    @Override
    public void setObserverNews(String s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.news = s;
    }

    @Override
    public void print() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Student ID: " + this.student_id + "   Message: " + this.news);
    }
    
}
