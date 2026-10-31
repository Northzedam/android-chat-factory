package com.northzedam.factorysample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    private final Handler handler = new Handler(Looper.getMainLooper());
    private ProgressBar progressBar;
    private TextView statusText;
    private Button verifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        statusText = findViewById(R.id.statusText);
        verifyButton = findViewById(R.id.verifyButton);
        verifyButton.setOnClickListener(view -> verifyFactory());
    }

    private void verifyFactory() {
        progressBar.setVisibility(View.VISIBLE);
        verifyButton.setEnabled(false);
        statusText.setText(R.string.verifying);
        handler.postDelayed(() -> {
            if (isDestroyed()) return;
            progressBar.setVisibility(View.GONE);
            verifyButton.setEnabled(true);
            statusText.setText(R.string.factory_ready);
        }, 700);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
