package vn.eazy.share.element;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTransDemo;
    private Button btnActDemo;
    private Button btnRecyclerViewDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        btnTransDemo = (Button) findViewById(R.id.btnTransDemo);
        btnActDemo = (Button) findViewById(R.id.btnActDemo);
        btnRecyclerViewDemo = (Button) findViewById(R.id.btnRecyclerViewDemo);
        btnTransDemo.setOnClickListener(this);
        btnActDemo.setOnClickListener(this);
        btnRecyclerViewDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnTransDemo) {
            startActivity(new Intent(DemoActivity.this, MainActivity.class));
        } else if (view.getId() == R.id.btnActDemo) {

        } else if (view.getId() == R.id.btnRecyclerViewDemo) {
            startActivity(new Intent(DemoActivity.this, RecyclerViewActivity.class));
        }

    }
}
