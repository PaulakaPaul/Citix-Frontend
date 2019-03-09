package europe.dev.citix.citix;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gauravbhola.ripplepulsebackground.RipplePulseLayout;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import europe.dev.citix.citix.login.EntryActivity;

public class SplashScreen extends AppCompatActivity {

    RipplePulseLayout mRipplePulseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mRipplePulseLayout = findViewById(R.id.layout_ripplepulse);
        mRipplePulseLayout.startRippleAnimation();
        setTimeout(3500,this);
    }
    public static void setTimeout(int delay,final Context context){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // this code will be executed after 2 seconds
                Intent home_intent = new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                context.startActivity(home_intent);
            }
        }, delay);
    }

}
