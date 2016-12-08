package vn.eazy.share.element.reveal;


import android.animation.Animator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import vn.eazy.share.element.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RevealFragment extends Fragment implements View.OnClickListener {
    private FloatingActionButton fab;
    private View view;
    private FrameLayout ivReveal;
    private LinearLayout layoutButtons;
    private ImageView ivBg;
    float pixelDensity;
    private boolean flag;
    private AlphaAnimation alphaAnimation;

    public static RevealFragment newInstance() {

        Bundle args = new Bundle();

        RevealFragment fragment = new RevealFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        pixelDensity = getResources().getDisplayMetrics().density;

        view = inflater.inflate(R.layout.fragment_reveal, container, false);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        ivReveal = (FrameLayout) view.findViewById(R.id.ivReveal);
        layoutButtons = (LinearLayout) view.findViewById(R.id.layoutButtons);
        ivBg = (ImageView) view.findViewById(R.id.ivBg);
        fab.setOnClickListener(this);
        alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(500);
        return view;
    }

    @Override
    public void onClick(View view) {
        int x = fab.getLeft() + ((fab.getRight() - fab.getLeft()) / 2);
        int y = fab.getTop() + ((fab.getBottom() - fab.getTop()) / 2);

        int hypotenuse = (int) Math.hypot(ivBg.getWidth(), ivBg.getHeight());

        if (!flag) {

            Animator anim = ViewAnimationUtils.createCircularReveal(ivReveal, x, y, 0, hypotenuse);
            anim.setDuration(700);

            ivReveal.setVisibility(View.VISIBLE);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    layoutButtons.setVisibility(View.VISIBLE);
                    layoutButtons.startAnimation(alphaAnimation);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            anim.start();
        } else {
            Animator anim = ViewAnimationUtils.createCircularReveal(ivReveal, x, y, hypotenuse, 0);
            anim.setDuration(400);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    ivReveal.setVisibility(View.GONE);
                    layoutButtons.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            anim.start();
        }
        flag = !flag;
    }
}
