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
    private byte[] image;
    private Type type;
    private String correctAnswer;
    private boolean isCorrect;

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


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
}
