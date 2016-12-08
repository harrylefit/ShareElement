package vn.eazy.share.element.sharedElement;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import vn.eazy.share.element.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView imageView;
    private String transName;
    private TextView textView;
    private String titleTransName;

    public static DemoFragment newInstance() {

        Bundle args = new Bundle();

        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_demo, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setOnClickListener(this);
        textView = (TextView) view.findViewById(R.id.textView);
    }

    @Override
    public void onClick(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementReturnTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.change_image_trans));
            setExitTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.explode));
            transName = imageView.getTransitionName();
            titleTransName = textView.getTransitionName();

            Demo2Fragment demo2Fragment = Demo2Fragment.newInstance();
            demo2Fragment.setSharedElementEnterTransition(TransitionInflater.from(
                    getActivity()).inflateTransition(R.transition.change_image_trans));
            demo2Fragment.setExitTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.explode));

            Bundle bundle = new Bundle();
            bundle.putString("TRANS_NAME", transName);
            demo2Fragment.setArguments(bundle);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, demo2Fragment)
                    .addToBackStack("Demo")
                    .addSharedElement(imageView, transName)
                    .addSharedElement(textView, titleTransName)
                    .commit();
        }
    }
}
