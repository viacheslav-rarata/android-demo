package org.android.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "org.android.demo.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get a string resource from your app's Resources
        String hello_android = getResources().getString(R.string.hello_android);
        Log.v("hello_android", hello_android);

        TextView textView = new TextView(this);
        textView.setText(R.string.hello_android);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void navigateToFragment(View view) {
        Intent intent = new Intent(this, org.android.demo.fragments.MainActivity.class);
        startActivity(intent);
    }
}
