package tom_dev.com.roomio_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 1000;
    private SharedPreferences prefs = null;
    private final String PREFS_NAME = "tom_dev.com.roomio_android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // determine what activity to direct to, either, sign-up, or login

                prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                Class targetActivity = MainActivity.class;

                // if first time running
                if (prefs.getBoolean("firstrun", true)) {
                    prefs.edit().putBoolean("firstrun", false).commit();
                    targetActivity = SignupActivity.class;
                }
                // otherwise, go to the login activity
                else {
                    targetActivity = LoginActivity.class;
                }

                Intent intent = new Intent(SplashActivity.this, targetActivity);

                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}
