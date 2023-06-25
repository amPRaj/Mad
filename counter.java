import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kotlinx.coroutines.Delay;

public class MainActivity extends AppCompatActivity {
    Button btnstart, btnstop;
    TextView tc;
    int i = 0;
    Handler customHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tc = findViewById(R.id.Counter);
    }
    public void startcounter(View v)
    {
        customHandler.postDelayed(Threadcount,1000);

    }
    public void stopcounter(View v)
    {
        customHandler.removeCallbacks(Threadcount);
    }
    public Runnable Threadcount=new Runnable()
    {

        @Override
        public void run() {
            tc.setText(""+i);
            i++;
            customHandler.postDelayed(Threadcount,1000);
        }
    };

}
