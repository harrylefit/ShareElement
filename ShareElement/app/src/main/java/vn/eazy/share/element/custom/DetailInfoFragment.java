package vn.eazy.share.element.custom;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.eazy.share.element.R;
import vn.eazy.share.element.model.UserInfo;

public class DetailInfoFragment extends Fragment {
    public static final String AVATAR_DRAWABLE_KEY = "avatar_drawable";
    public static final String AVATAR_TRANS_KEY = "avatar_trans";
    public static final String NAME_TRANS_KEY = "name_trans";
    public static final String COMPANY_TRANS_KEY = "company_trans";
    public static final String JOB_POSITION_KEY = "job_position";
    public static final String USER_INFO_KEY = "user_info";
    @BindView(R.id.ivCover)
    KenBurnsView ivCover;

    @BindView(R.id.ivAvatar)
    ImageView ivAvatar;

    @BindView(R.id.tvName)
    TextView tvName;

    @BindView(R.id.tvCompany)
    TextView tvCompany;

    @BindView(R.id.tvJobPosition)
    TextView tvJobPosition;

    @BindView(R.id.lyInfo)
    LinearLayout lyInfo;

    @BindView(R.id.lyStates)
    LinearLayout lyStates;

    @BindView(R.id.rvGallery)
    RecyclerView rvGallery;

    @BindView(R.id.btnFollow)
    Button btnFollow;

    private View view;

    private UserInfo userInfo;
    private GalleryAdapter galleryAdapter;

    public static DetailInfoFragment newInstance() {

        Bundle args = new Bundle();

        DetailInfoFragment fragment = new DetailInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_info, container, false);
        ButterKnife.bind(this, view);
        setEnterSharedElementCallback(new SharedElementCallback() {
            @Override
            public void onSharedElementStart(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
                super.onSharedElementStart(sharedElementNames, sharedElements, sharedElementSnapshots);
                Log.d("Debug", "Start");
            }

            @Override
            public void onSharedElementEnd(List<String> sharedElementNames, List<View> sharedElements, List<View> sharedElementSnapshots) {
                super.onSharedElementEnd(sharedElementNames, sharedElements, sharedElementSnapshots);
                Log.d("Debug", "End");

            }

            @Override
            public void onRejectSharedElements(List<View> rejectedSharedElements) {
                super.onRejectSharedElements(rejectedSharedElements);
                Log.d("Debug", "Reject");

            }

            @Override
            public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                super.onMapSharedElements(names, sharedElements);
                Log.d("Debug", "Shared");

            }

            @Override
            public Parcelable onCaptureSharedElementSnapshot(View sharedElement, Matrix viewToGlobalMatrix, RectF screenBounds) {
                Log.d("Debug", "Capture");
                return super.onCaptureSharedElementSnapshot(sharedElement, viewToGlobalMatrix, screenBounds);
            }

            @Override
            public View onCreateSnapshotView(Context context, Parcelable snapshot) {
                Log.d("Debug", "Create snapshot");
                return super.onCreateSnapshotView(context, snapshot);


            }

            @Override
            public void onSharedElementsArrived(List<String> sharedElementNames, List<View> sharedElements, OnSharedElementsReadyListener listener) {
                super.onSharedElementsArrived(sharedElementNames, sharedElements, listener);
                Log.d("Debug", "Arrived");
            }
        });
        if (getArguments() != null) {
            //Todo get data from arguments
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (userInfo != null) {
//            Glide.with(getContext()).load(userInfo.getCover()).asBitmap().centerCrop().into(ivCover);
//            RandomTransitionGenerator generator = new RandomTransitionGenerator(4000, new LinearInterpolator());
//            ivCover.setTransitionGenerator(generator);
            //todo animation for State layout

        }
    }

    private void settingRecyclerView() {
        initDataForAdapter();
        rvGallery.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvGallery.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        rvGallery.setAdapter(galleryAdapter);
    }

    private void initDataForAdapter() {
        galleryAdapter = new GalleryAdapter(userInfo.getGalleryUrls());
    }


    class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
        private List<String> galleryUrls;
        private boolean isLocked;

        public GalleryAdapter(List<String> galleryUrls) {
            this.galleryUrls = galleryUrls;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_data, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            Glide.with(getContext()).load(galleryUrls.get(position)).asBitmap().centerCrop().sizeMultiplier(0.5f).listener(new RequestListener<String, Bitmap>() {
                @Override
                public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    Log.d("Debug", "Resource ready");
                    if (!isLocked) {
                        setupRevealItem(holder.ivData);
                    }
                    return false;
                }
            }).into(holder.ivData);
        }

        private void setupRevealItem(View view) {
            try {
                //Todo setup reveal animation for item
            } catch (Exception ex) {

            }
        }

        public void setLockedRevealAnimation(boolean isLocked) {
            this.isLocked = isLocked;
        }

        @Override
        public int getItemCount() {
            return GalleryAdapter.this.galleryUrls.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.ivData)
            ImageView ivData;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(ViewHolder.this, itemView);
            }
        }
    }
}
