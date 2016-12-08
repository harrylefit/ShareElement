package vn.eazy.share.element.reveal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.eazy.share.element.R;

public class RevealActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, RevealFragment.newInstance())
                .addToBackStack("Reveal")
                .commitAllowingStateLoss();
    }
}
