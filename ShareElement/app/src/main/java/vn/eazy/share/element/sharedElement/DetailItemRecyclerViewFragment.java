package vn.eazy.share.element.sharedElement;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import vn.eazy.share.element.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailItemRecyclerViewFragment extends Fragment {
    public static final String TRANSITION_NAME = "transition_name";
    public static final String BITMAP_KEY = "bitmap_key";
    private View view;
    private ImageView ivData;

    public static DetailItemRecyclerViewFragment newInstance() {

        Bundle args = new Bundle();

        DetailItemRecyclerViewFragment fragment = new DetailItemRecyclerViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_item_recycler_view, container, false);
        ivData = (ImageView) view.findViewById(R.id.ivData);
        if (getArguments() != null) {
            ivData.setImageBitmap((Bitmap) getArguments().getParcelable(BITMAP_KEY));
            ivData.setTransitionName(getArguments().getString(TRANSITION_NAME, ""));
        }
        return view;
    }

}
