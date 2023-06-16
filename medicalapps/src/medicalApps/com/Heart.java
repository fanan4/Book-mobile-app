package medicalApps.com;

import java.util.Scanner;

public class Heart extends Parent{
    int HeartRate;
    Scanner scan=new Scanner(System.in);
    public void ChangeRate(){
        int change;
        System.out.println("1. change the rate");
        change=scan.nextInt();
        if(change==1){
            System.out.println("enter the new rate ");
            HeartRate=scan.nextInt();
            System.out.println("Heart Rate changed to "+HeartRate);
        }
    }

    public Heart(String name, String medical_situation, int heartRate) {
        super(name, medical_situation);
        HeartRate = heartRate;
    }
}
