package vn.eazy.share.element;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import vn.eazy.share.element.basic.BasicActivity;
import vn.eazy.share.element.custom.FullAnimationActivity;
import vn.eazy.share.element.reveal.RevealActivity;
import vn.eazy.share.element.sharedElement.MainActivity;
import vn.eazy.share.element.sharedElement.RecyclerViewActivity;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTransDemo;
    private Button btnRecyclerViewDemo;
    private Button btnRevealDemo;
    private Button btnBasicDemo;
    private Button btnFullAnimationDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        btnTransDemo = (Button) findViewById(R.id.btnTransDemo);
        btnRecyclerViewDemo = (Button) findViewById(R.id.btnRecyclerViewDemo);
        btnRevealDemo = (Button) findViewById(R.id.btnRevealDemo);
        btnBasicDemo = (Button) findViewById(R.id.btnBasicDemo);
        btnFullAnimationDemo = (Button) findViewById(R.id.btnFullAnimationDemo);
        btnTransDemo.setOnClickListener(this);
        btnRecyclerViewDemo.setOnClickListener(this);
        btnRevealDemo.setOnClickListener(this);
        btnBasicDemo.setOnClickListener(this);
        btnFullAnimationDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnTransDemo) {
            startActivity(new Intent(DemoActivity.this, MainActivity.class));
        } else if (view.getId() == R.id.btnRecyclerViewDemo) {
            startActivity(new Intent(DemoActivity.this, RecyclerViewActivity.class));
        } else if (view.getId() == R.id.btnRevealDemo) {
            startActivity(new Intent(DemoActivity.this, RevealActivity.class));
        } else if (view.getId() == R.id.btnBasicDemo) {
            startActivity(new Intent(DemoActivity.this, BasicActivity.class));
        } else if (view.getId() == R.id.btnFullAnimationDemo) {
            startActivity(new Intent(DemoActivity.this, FullAnimationActivity.class));
        }

    }
}
