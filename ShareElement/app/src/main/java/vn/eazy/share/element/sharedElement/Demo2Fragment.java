package vn.eazy.share.element.sharedElement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.eazy.share.element.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Demo2Fragment extends Fragment {
    private View view;

    public Demo2Fragment() {
        // Required empty public constructor
    }

    public static Demo2Fragment newInstance() {

        Bundle args = new Bundle();

        Demo2Fragment fragment = new Demo2Fragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = getArguments();
        String transitionName = "";
        if(bundle != null){
            transitionName = bundle.getString("TRANS_NAME");
        }
        view = inflater.inflate(R.layout.fragment_demo2, container, false);

        //Todo set shared element by code
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            view.findViewById(R.id.otherImage).setTransitionName(transitionName);
//        }
        return view;
    }

}
