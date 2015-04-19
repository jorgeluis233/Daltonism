package green.edu.intec.daltonism;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        maps = new Bitmap[38];
        loadImages();

        Intent intent = getIntent();
        questions = (ArrayList<Question>)intent.getSerializableExtra("QUESTION_LIST");
       // loadTable();

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
            System.exit(0);
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
        TableLayout table = (TableLayout) findViewById(R.id.tableLayout1);
        for(int i=0;i<questions.size();i++)
        {
            TableRow row=new TableRow(this);
            Question question = questions.get(i);
            TextView tvPlate=new TextView(this);
            tvPlate.setText(""+question.getPlate());
            tvPlate.setPadding(10,0,10,0);
            TextView tvAnswer=new TextView(this);
            tvAnswer.setText(question.getCorrectAnswer());
            tvAnswer.setPadding(10,0,10,0);
            table.addView(row);
            row.addView(tvPlate);
            row.addView(tvAnswer);

        }

    }
}
