package vn.eazy.share.element;


import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecycerViewFragment extends Fragment {
    private RecyclerView rvData;
    private View root;
    private ImageAdapter imageAdapter;

    public static RecycerViewFragment newInstance() {

        Bundle args = new Bundle();

        RecycerViewFragment fragment = new RecycerViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_recycer_view, container, false);
        rvData = (RecyclerView) root.findViewById(R.id.rvData);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageAdapter = new ImageAdapter();
        rvData.setLayoutManager(new LinearLayoutManager(getContext()));
        rvData.setAdapter(imageAdapter);
    }

    private class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> implements View.OnClickListener {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.ivData.setTransitionName("image" + position);
            holder.ivData.setOnClickListener(this);
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        @Override
        public void onClick(View view) {
            setSharedElementReturnTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.change_image_trans));
            setExitTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.explode));

            DetailItemRecyclerViewFragment detailItemRecyclerViewFragment = DetailItemRecyclerViewFragment.newInstance();
            detailItemRecyclerViewFragment.setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.change_image_trans));
            detailItemRecyclerViewFragment.setEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.explode));
            Bundle bundle = new Bundle();
            bundle.putString(DetailItemRecyclerViewFragment.TRANSITION_NAME, view.getTransitionName());
            bundle.putParcelable(DetailItemRecyclerViewFragment.BITMAP_KEY
                    , ((BitmapDrawable) (((ImageView) view).getDrawable())).getBitmap());
            detailItemRecyclerViewFragment.setArguments(bundle);

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, detailItemRecyclerViewFragment)
                    .addSharedElement(view, view.getTransitionName())
                    .addToBackStack("Recycler Demo").commit();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView ivData;

            public ViewHolder(View itemView) {
                super(itemView);
                ivData = (ImageView) itemView.findViewById(R.id.ivData);
            }
        }
    }
}
