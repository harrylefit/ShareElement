package vn.eazy.share.element;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import vn.eazy.share.element.reveal.RevealActivity;
import vn.eazy.share.element.sharedElement.MainActivity;
import vn.eazy.share.element.sharedElement.RecyclerViewActivity;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTransDemo;
    private Button btnActDemo;
    private Button btnRecyclerViewDemo;
    private Button btnRevealDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        btnTransDemo = (Button) findViewById(R.id.btnTransDemo);
        btnActDemo = (Button) findViewById(R.id.btnActDemo);
        btnRecyclerViewDemo = (Button) findViewById(R.id.btnRecyclerViewDemo);
        btnRevealDemo = (Button) findViewById(R.id.btnRevealDemo);
        btnTransDemo.setOnClickListener(this);
        btnActDemo.setOnClickListener(this);
        btnRecyclerViewDemo.setOnClickListener(this);
        btnRevealDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnTransDemo) {
            startActivity(new Intent(DemoActivity.this, MainActivity.class));
        } else if (view.getId() == R.id.btnActDemo) {

        } else if (view.getId() == R.id.btnRecyclerViewDemo) {
            startActivity(new Intent(DemoActivity.this, RecyclerViewActivity.class));
        } else if (view.getId() == R.id.btnRevealDemo) {
            startActivity(new Intent(DemoActivity.this, RevealActivity.class));
        }

    }
}
