/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classinfotransfer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lelmil
 */
public class ClassInfoTransfer {
    public static ArrayList<StudentObserver> students = new ArrayList<StudentObserver>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CRSubject subject = new CRSubject();
        
        Scanner sc = new Scanner(System.in);
        Scanner ss = new Scanner(System.in); //sentence input nite
        System.out.print("How many students in the class? ");
        int num = sc.nextInt();
        
        for(int i = 1; i<=num; i++){
            StudentObserver st = new StudentObserver(subject, i);
            students.add(st);
        }
        
        while(true){
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("1. Update news by CR  2. Register student  3. Unregister student  4. Check student profile  0. Exit");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            
            int choice = sc.nextInt();
            
            if(choice==0) break;
            
            else if(choice==1){
                System.out.print("Enter text: ");
                String news = ss.nextLine();
                subject.setNews(news);
            }
            
            else if(choice==2){
                System.out.println("Enter student id/roll to register: ");
                int roll = sc.nextInt();
                if(roll>0 && roll<=num){
                    Observer obs = students.get(roll-1);
                    subject.register(obs);
                } else{
                    System.out.println("Invalid ID!");
                }
            }
            
            else if(choice==3){
                System.out.println("Enter student id/roll to unregister: ");
                int roll = sc.nextInt();
                                
                if(roll>0 && roll<=num){
                    Observer obs = students.get(roll-1);
                    subject.unregister(obs);
                } else{
                    System.out.println("Invalid ID!");
                }
            }
            
            else if(choice==4){
                for(StudentObserver so: students){
                    so.print();
                }
            }
        }
    }
    
}
