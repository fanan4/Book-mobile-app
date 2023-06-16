package medicalApps.com;

public class Parent {
   String Name;
   String medical_situation;

   public Parent(String name, String medical_situation) {
      Name = name;
      this.medical_situation = medical_situation;
   }
   public  void display(){
      System.out.println("Name: "+Name+"\n"+"medical situation :"+medical_situation);
   }
}
