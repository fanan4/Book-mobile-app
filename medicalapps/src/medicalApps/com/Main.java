package medicalApps.com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient(new Left_Eye("Left Eye", "Normal", "Blue"), new Right_Eye("Right Eye", "Normal", "Blue"),
                new Stomack("Stomach", "Normal"), new Heart("Heart", "Normal", 65)
                , new Skin("Skin", "Normal"));
        int choice;
        boolean finish=true;
        Scanner scanner=new Scanner(System.in);
        do {
            OrganList();
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                     patient.left_eye.display();
                     patient.left_eye.closeEye();
                     break;
                case 2:
                    patient.right_eye.display();
                    patient.right_eye.closeEye();
                    break;
                case 3:
                    patient.heart.display();
                    patient.heart.ChangeRate();
                    break;
                case 4:
                    patient.stomack.display();
                    patient.stomack.Digest();
                    break;
                case 5:
                    patient.skin.display();
                    break;
                default:
                    break;
            }
            if(choice==6) break;
        }while(finish);

    }
  public static void OrganList(){
        String[] organlist={"1. Left Eye","2. Right Eye","3. Heart","4. Stomach","5. Skin","6. Quite"};
        for (int i=0;i<5;i++){
            System.out.println(organlist[i]);
        }

  }
}
