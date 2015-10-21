package mymapapplication.miguel.labrador.com.deadlifthelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainScreen extends AppCompatActivity {

    /*****************************/
    /*****Global Variables******/
    /***************************/

    //Used as a key for extras in intents to identify username.
    public final static String USERNAME = "DEADLIFT_HELPER_USERNAME";

    //Used as a key for extras in intents to identify weight.
    public final static String WEIGHT = "DEADLIFT_HELPER_WEIGHT";

    //used as a key for extras in intents to identify timer
    public final static String TIMER = "DEADLIFT_HELPER_TIMER";


    /*****************************/
    /*****Private Variables******/
    /***************************/



    /*****************************/
    /*Helper & Private Functions*/
    /***************************/

    //Helper function to start the Record Deadlift activity.
    //This activity will require the username and weight that were entered here.
    //Build an intent with this data, and start next activity.
    private void navigateTo_recordDeadlift(View view)
    {
        //Intent used to navigate to Record Deadlift activity.
        Intent itent_recordDeadlift = new Intent(this, RecordDeadlift.class);

        //Edit texts used to send the next activity the username and weight entered here.
        EditText username = (EditText) this.findViewById(R.id.UsernameEditText);
        EditText weight = (EditText) this.findViewById(R.id.EnterWeightEditText);

        //Get actual text value from each EditText.
        String username_text = username.getText().toString();
        String weight_text = weight.getText().toString();

        //Give the intent the necessary data.
        //Public strings USERNAME and WEIGHT are used as keys for
        //username_text and weight_text respectively.
        itent_recordDeadlift.putExtra(USERNAME, username_text);
        itent_recordDeadlift.putExtra(WEIGHT, weight_text);

        //Finally, start the Record Deadlift activity.
        startActivity(itent_recordDeadlift);
    }

    //Helper function to start the View Lifts activity.
    //This activity will require the username and weight that were entered here.
    //Build an intent with this data, and start next activity.
    private void navigateTo_viewLifts(View view)
    {
        //Intent used to navigate to View Lifts activity.
        Intent itent_viewLifts = new Intent(this, ViewLifts.class);

        //Edit texts used to send the next activity the username and weight entered here.
        EditText username = (EditText) this.findViewById(R.id.UsernameEditText);
        EditText weight = (EditText) this.findViewById(R.id.EnterWeightEditText);

        //Get actual text value from each EditText.
        String username_text = username.getText().toString();
        String weight_text = weight.getText().toString();

        //Give the intent the necessary data.
        //Public strings USERNAME and WEIGHT are used as keys for
        //username_text and weight_text respectively.
        itent_viewLifts.putExtra(USERNAME, username_text);
        itent_viewLifts.putExtra(WEIGHT, weight_text);

        //Finally, start the View Lifts activity.
        startActivity(itent_viewLifts);
    }


    private void navigateTo_TimerCount(View view)
    {
        //Intent used to navigate to timer activity.
        Intent intent_timerCount = new Intent(this, TimerCount.class);

        //Edit texts used to send the next activity the timer amount entered here.
        EditText timerVal = (EditText) this.findViewById(R.id.TimerEditText);


        //Get actual text value from each EditText.
        String timerVal_text = timerVal.getText().toString();

        //Give the intent the necessary data.
        //Public strings USERNAME and WEIGHT are used as keys for
        //username_text and weight_text respectively.
        intent_timerCount.putExtra(TIMER, timerVal_text);

        //Finally, start the timer activity.
        startActivity(intent_timerCount);
    }


    /*****************************/
    /*****Lifecycle Functions****/
    /***************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Default and required.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        /***********Add Navigation Buttons***********/
        //Button to navigate to Record Deadlift screen.
        Button recordDeadlift = (Button) this.findViewById(R.id.RecordDeadliftButton);

        recordDeadlift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTo_recordDeadlift(view);
            }
        });


        //Button to navigate to View Lifts screen.
        Button viewLifts = (Button) this.findViewById(R.id.ViewPreviousLiftsButton);

        viewLifts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                navigateTo_viewLifts(view);
            }
        });

        //Button to navigate to View Lifts screen.
        Button timerButton = (Button) this.findViewById(R.id.StartTimerButton);

        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                navigateTo_TimerCount(view);
            }
        });
    }

    










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
