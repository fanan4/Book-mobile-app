package medicalApps.com;

import java.util.Scanner;

public class Stomack extends Parent{
       Scanner scanner=new Scanner(System.in);
          public void Digest(){
              int start;
              System.out.println("1.start degest");
              start=scanner.nextInt();
              if(start==1){
                  System.out.println("degestion begin");
              }
          }

    public Stomack(String name, String medical_situation) {
        super(name, medical_situation);
    }
}
