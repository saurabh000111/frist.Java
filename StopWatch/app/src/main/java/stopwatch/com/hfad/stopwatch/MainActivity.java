package stopwatch.com.hfad.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Activity {
    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
           seconds = savedInstanceState.getInt("seconds");
           running = savedInstanceState.getBoolean("running");
        }
        runTimer();
    }

   // for saving current status activity when screen orientation is changed
    public void OnsavedInstanceState(Bundle savedInstanceState ){
        savedInstanceState.putInt("seconds" , seconds);
        savedInstanceState.putBoolean("running", running);
    }


// this called before activity gets destroyed
     protected void onStop(){
        super.onStop();
        running = false;

     }
    // start stop watch running when start button is pressed.
    public void onClickStart(View view) {
        running = true;
    }

    //Stop stop watch running when stop button is pressed.
    public void onClickStop(View view) {
        running = false;
    }

    //Reset stop watch to zero when reset button is pressed.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer() {
        // this creates reference of text view
        final TextView timeveiw = (TextView) findViewById(R.id.time_veiw);
        // this creates a handler object
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(), "%d: %02d:%02d", hours, minutes, secs);
                timeveiw.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
