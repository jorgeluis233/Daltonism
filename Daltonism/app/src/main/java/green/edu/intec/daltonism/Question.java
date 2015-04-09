package green.edu.intec.daltonism;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Created by Jorge on 4/8/2015.
 */
public class Question {

    private int plate;
    private Bitmap image;
    private String answer;
    private String correctAnswer;

    public Question(int plate, String correctAnswer) {
        this.plate = plate;
        this.correctAnswer = correctAnswer;
    }

    public int getPlate() {
        return plate;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
