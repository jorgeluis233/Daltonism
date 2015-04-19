package green.edu.intec.daltonism;

import android.graphics.Bitmap;
import android.media.Image;

import java.io.Serializable;

/**
 * Created by Jorge on 4/8/2015.
 */
@SuppressWarnings("serial")
public class Question implements Serializable {

    private int plate;
    private Type type;
    private String correctAnswer;
    private boolean isCorrect;
    private String answer;

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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
