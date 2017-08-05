package cse110.crossfit.IDEAproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity {
	
    protected int _splashTime = 5000;
    private Thread splashTread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.start_splash);
        final SplashScreen sPlashScreen = this;

        // thread for displaying the SplashScreen
        splashTread = new Thread() {
        	
            @Override
            public void run() {
                try {
                    synchronized(this){
                        //wait 5 sec
                        wait(_splashTime);
                    }
                } 
                catch(InterruptedException e) {
                	
                }
                finally {
                    finish();
                    //start a new activity
                    Intent i = new Intent();
                    i.setClass(sPlashScreen, IdeaActivity.class);
                    startActivity(i);
                }
            }
        };
        splashTread.start();
    }
    
}
