package vn.eazy.share.element.custom;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.eazy.share.element.R;
import vn.eazy.share.element.model.UserInfo;

public class StartAnimationFragment extends Fragment {
    @BindView(R.id.rvData)
    RecyclerView rvData;

    private View view;
    private List<UserInfo> userInfos;
    private UserInfoAdapter userInfoAdapter;

    public static StartAnimationFragment newInstance() {

        Bundle args = new Bundle();

        StartAnimationFragment fragment = new StartAnimationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_start_animation, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userInfos = new ArrayList<>();
        settingDataForRecyclerView();
    }

    private void setupDataForAdapter() {
        //Todo setup data

        userInfoAdapter = new UserInfoAdapter(userInfos);
    }

    private void settingDataForRecyclerView() {
        setupDataForAdapter();
        rvData.setLayoutManager(new LinearLayoutManager(getContext()));
        rvData.setAdapter(userInfoAdapter);
    }

    class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder> {
        private List<UserInfo> userInfos;

        public UserInfoAdapter(List<UserInfo> userInfos) {
            this.userInfos = userInfos;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_user_info, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            final UserInfo userInfo = userInfos.get(position);
//            Glide.with(getContext()).load(userInfo.getAvatar())
//                    .asBitmap().centerCrop().into(new RoundImageBitmap(holder.ivAvatar));
        }

        @Override
        public int getItemCount() {
            return this.userInfos.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.ivAvatar)
            ImageView ivAvatar;

            @BindView(R.id.tvName)
            TextView tvName;

            @BindView(R.id.tvCompany)
            TextView tvCompany;

            @BindView(R.id.tvJobPosition)
            TextView tvJobPosition;

            @BindView(R.id.lyInfo)
            RelativeLayout lyInfo;

            public ViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(ViewHolder.this, itemView);
            }
        }
    }
}
