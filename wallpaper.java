import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    
    Timer mytimer;
    Drawable drawable;
    WallpaperManager wpm;
    int next = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytimer = new Timer();
        wpm = WallpaperManager.getInstance(this);
    }

    public void changewallpaper(View v) {
        setWallPaper();
    }

    public void setWallPaper() {
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (next == 1) {
                    drawable=getDrawable(R.drawable.one);
                    next=2;
                }
                else if(next==2)
                {
                    drawable=getDrawable(R.drawable.two);
                    next=3;
                }
                else if(next==3)
                {
                    drawable=getDrawable(R.drawable.three);
                    next=4;
                }
                else if(next==4)
                {
                    drawable=getDrawable(R.drawable.four);
                    next=5;
                }
                else if(next==5)
                {
                    drawable=getDrawable(R.drawable.five);
                    next=1;
                }

                Bitmap img=((BitmapDrawable)drawable).getBitmap();
                try {
                    wpm.setBitmap(img);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }, 30000, 5000);
    }
}
