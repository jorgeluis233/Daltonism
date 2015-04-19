package green.edu.intec.daltonism;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class TestActivity extends ActionBarActivity {

    public ArrayList<Question> questions;
    public EditText editAnswer;
    public TextView plateName;
    public ImageView imageQuestion;
    public TextView textQuestion;
    public int currentQuestion;
    Bitmap[] maps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        this.setTitle("Ishihara Test");
        questions = new ArrayList<Question>();
        maps = new Bitmap[38];
        createQuestions();
        editAnswer = (EditText)findViewById(R.id.question_answer);
        imageQuestion = (ImageView)findViewById(R.id.question_image);
        textQuestion = (TextView)findViewById(R.id.question_display);
        plateName = (TextView)findViewById(R.id.question_name);
        currentQuestion = 0;
        plateName.setText("Plate " + (questions.get(currentQuestion).getPlate()+""));
        textQuestion.setText("What number do you see?");


        imageQuestion.setImageBitmap(maps[currentQuestion]);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createQuestions(){

        questions.clear();
        int first = 2130837559;
        for(int x = 0; x <=37; x++){
            maps[x] = BitmapFactory.decodeResource(getResources(), first);
            first++;
        }

        Question[] q = new Question[38];
        q[0] = new Question(1, "12");
        q[1] = new Question(2, "8");
        q[2] = new Question(3, "6");
        q[3] = new Question(4, "29");
        q[4] = new Question(5, "57");
        q[5] = new Question(6, "5");
        q[6] = new Question(7, "3");
        q[7] = new Question(8, "15");
        q[8] = new Question(9, "74");
        q[9] = new Question(10, "2");
        q[10] = new Question(11, "6");
        q[11] = new Question(12, "97");
        q[12] = new Question(13, "45");
        q[13] = new Question(14, "5");
        q[14] = new Question(15, "7");
        q[15] = new Question(16, "16");
        q[16] = new Question(17, "73");
        q[17] = new Question(18, "");
        q[18] = new Question(19, "");
        q[19] = new Question(20, "");
        q[20] = new Question(21, "");
        q[21] = new Question(22, "26");
        q[22] = new Question(23, "42");
        q[23] = new Question(24, "35");
        q[24] = new Question(25, "96");
        q[25] = new Question(26, "2");
        q[26] = new Question(27, "2");
        q[27] = new Question(28, "0");
        q[28] = new Question(29, "0");
        q[29] = new Question(30, "1");
        q[30] = new Question(31, "1");
        q[31] = new Question(32, "1");
        q[32] = new Question(33, "1");
        q[33] = new Question(34, "1");
        q[34] = new Question(35, "1");
        q[35] = new Question(36, "1");
        q[36] = new Question(37, "1");
        q[37] = new Question(38, "1");


        for (int x = 0; x<38; x++){
            questions.add(q[x]);
            if(x<25){
                questions.get(x).setType(Type.Number);
            }else {
                questions.get(x).setType(Type.Line);
            }
        }


    }

    public void submitAnswer(View button){
        if(currentQuestion < 37){
            if(editAnswer.getText().toString().equals(questions.get(currentQuestion).getCorrectAnswer())){
                questions.get(currentQuestion).setCorrect(true);

            } else {
                questions.get(currentQuestion).setCorrect(false);
            }

                questions.get(currentQuestion).setAnswer(editAnswer.getText().toString());


            currentQuestion++;
            if(currentQuestion < 38){
                imageQuestion.setImageBitmap(maps[currentQuestion]);
                editAnswer.setText("");
                plateName.setText("Plate " + (questions.get(currentQuestion).getPlate()+""));
                if(questions.get(currentQuestion).getType().toString().equals("Line")){
                    textQuestion.setText("How many lines do you see?");
                }else {
                    textQuestion.setText("What number do you see?");
                }
            }


        } else {
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("QUESTION_LIST",questions);
            startActivity(intent);
        }

    }


}
