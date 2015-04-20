package green.edu.intec.daltonism;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ResultsActivity extends ActionBarActivity {


    public Bitmap[] maps;
    public ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        this.setTitle("Results");
        maps = new Bitmap[38];
        loadImages();

        Intent intent = getIntent();
        questions = (ArrayList<Question>)intent.getSerializableExtra("QUESTION_LIST");
        loadTable();
        Toast.makeText(this,"Click on menu for detailed results and maps!", Toast.LENGTH_LONG).show();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_results) {
            resultMap();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadImages(){
        int first = 2130837559;
        for(int x = 0; x <=37; x++){
            maps[x] = BitmapFactory.decodeResource(getResources(), first);
            first++;
        }
    }

    public void loadTable(){
        TableLayout table = (TableLayout) findViewById(R.id.tableLayout2);
        TableRow row=new TableRow(this);
        for(int i=0;i<questions.size();i++)
        {
            row=new TableRow(this);
            table.addView(row);
            Question question = questions.get(i);
            TextView tvPlate=new TextView(this);
            String plate = (question.getPlate() < 10) ? ("0"+question.getPlate()) : (question.getPlate()+"");
            tvPlate.setText(plate);
            tvPlate.setPadding(40,0,10,0);
            TextView tvType=new TextView(this);
            tvType.setText(question.getType().toString());
            tvType.setPadding(40,0,10,0);
            TextView tvCorrectAnswer=new TextView(this);
            tvCorrectAnswer.setText(question.getCorrectAnswer());
            tvCorrectAnswer.setPadding(100,0,10,0);
            TextView tvAnswer=new TextView(this);
            String answer = (question.getAnswer().isEmpty()) ? "__" : question.getAnswer();
            tvAnswer.setText(answer);
            tvAnswer.setPadding(160, 0, 20, 0);
            TextView tvResult=new TextView(this);
            String correct = (question.isCorrect()) ? "Correct!" : "Incorrect";
            tvResult.setText(correct);
            tvResult.setPadding(45,0,10,0);
            row.addView(tvPlate);
            row.addView(tvType);
            row.addView(tvCorrectAnswer);
            row.addView(tvAnswer);
            row.addView(tvResult);

        }


    }

    public void resultMap(){
        Intent intent = new Intent(this, MapActivity.class);

        intent.putExtra("QUESTION_LIST", questions);
        startActivity(intent);
    }
}
