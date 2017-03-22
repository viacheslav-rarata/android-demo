package org.android.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String DEFAULT_MESSAGE = "You didn't typed nothing!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = getMessage(intent);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }

    private String getMessage(Intent intent) {
        return !empty(intent.getStringExtra(MainActivity.EXTRA_MESSAGE)) ? intent.getStringExtra(MainActivity.EXTRA_MESSAGE) : DEFAULT_MESSAGE;
    }

    private boolean empty(String text) {
        return (null != text && !"".equals(text)) ? Boolean.FALSE : Boolean.TRUE;
    }
}
