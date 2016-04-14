package bello.andrea.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String SAVED_STRING_BUILDER_KEY = "string_builder";

    StringBuilder stringBuilder;
    TextView showLogTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null)
            stringBuilder = (StringBuilder)savedInstanceState.getSerializable(SAVED_STRING_BUILDER_KEY);
        else
            stringBuilder = new StringBuilder();

        setContentView(R.layout.activity_main);
        showLogTextView = (TextView)findViewById(R.id.textView);

        log("onCreate");

        findViewById(R.id.change_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        log("onSavedInstanceState");
        outState.putSerializable(SAVED_STRING_BUILDER_KEY, stringBuilder);
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log("onRestart");
    }

    private void log(String string){
        if(stringBuilder.length() != 0){
            stringBuilder.append(System.getProperty("line.separator"));
        }
        stringBuilder.append(string);
        showLogTextView.setText(stringBuilder.toString());
    }
}
