package vn.eazy.share.element.basic;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;

import vn.eazy.share.element.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicAnimationFragment extends Fragment implements View.OnClickListener {
    private Button btnAlphaAnim;
    private Button btnScaleAnim;
    private Button btnTranslateAnim;
    private Button btnRotateAnim;
    private Button btnCustomAnim;
    private View view;

    public static BasicAnimationFragment newInstance() {

        Bundle args = new Bundle();

        BasicAnimationFragment fragment = new BasicAnimationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_basic_animation, container, false);
        btnAlphaAnim = (Button) view.findViewById(R.id.btnAlphaAnim);
        btnScaleAnim = (Button) view.findViewById(R.id.btnScaleAnim);
        btnRotateAnim = (Button) view.findViewById(R.id.btnRotateAnim);
        btnTranslateAnim = (Button) view.findViewById(R.id.btnTranslateAnim);
        btnCustomAnim = (Button) view.findViewById(R.id.btnCustomAnim);
        btnAlphaAnim.setOnClickListener(this);
        btnScaleAnim.setOnClickListener(this);
        btnTranslateAnim.setOnClickListener(this);
        btnRotateAnim.setOnClickListener(this);
        btnCustomAnim.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAlphaAnim:
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(2000);
                btnAlphaAnim.startAnimation(alphaAnimation);
                break;
            case R.id.btnScaleAnim:
                Animation scaleAnimation = AnimationUtils.loadAnimation(getContext(),R.anim.scale_animations);
                btnScaleAnim.startAnimation(scaleAnimation);
                break;
            case R.id.btnTranslateAnim:
                Animation translateAnimation = AnimationUtils.loadAnimation(getContext(),R.anim.translate_animations);
                btnTranslateAnim.startAnimation(translateAnimation);
                break;
            case R.id.btnRotateAnim:
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360);
                rotateAnimation.setDuration(2000);
                btnRotateAnim.startAnimation(rotateAnimation);
                break;
            case R.id.btnCustomAnim:
                Animation customAnimation = AnimationUtils.loadAnimation(getContext(),R.anim.custom_animations);
                btnCustomAnim.startAnimation(customAnimation);
                break;
        }
    }
}
