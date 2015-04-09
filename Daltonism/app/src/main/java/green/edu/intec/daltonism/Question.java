package green.edu.intec.daltonism;

import android.media.Image;

/**
 * Created by Jorge on 4/8/2015.
 */
public class Question {

    private int plate;
    private Type type;
    private Image image;
    private String answer;
    private String correctAnswer;

    public Question(int plate, Type type, Image image, String correctAnswer) {
        this.plate = plate;
        this.type = type;
        this.image = image;
        this.correctAnswer = correctAnswer;
    }

    public int getPlate() {
        return plate;
    }

    public void setPlate(int plate) {
        this.plate = plate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
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
