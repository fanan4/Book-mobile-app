package medicalApps.com;

import java.util.Scanner;

public class Left_Eye extends Parent{
    public String Color;
    Scanner scanner=new Scanner(System.in);
    public void closeEye(){
        int close;
        System.out.println("1. close the Eye");
        close=scanner.nextInt();
        if(close==1){
            System.out.println("eye closed");
        }
    }

    public Left_Eye(String name, String medical_situation, String color) {
        super(name, medical_situation);
        Color = color;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(""+"color :"+Color);
    }
}
