package medicalApps.com;

public class Patient {
    Left_Eye left_eye;
    Right_Eye right_eye;
    Stomack stomack;
    Heart heart;
    Skin skin;

    public Patient(Left_Eye left_eye, Right_Eye right_eye, Stomack stomack, Heart heart, Skin skin) {
        this.left_eye = left_eye;
        this.right_eye = right_eye;
        this.stomack = stomack;
        this.heart = heart;
        this.skin = skin;
    }
}
