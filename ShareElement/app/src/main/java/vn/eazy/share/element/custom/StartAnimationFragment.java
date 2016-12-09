package vn.eazy.share.element.custom;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.eazy.share.element.R;
import vn.eazy.share.element.model.UserInfo;
import vn.eazy.share.element.util.RoundImageBitmap;

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
        userInfos.add(new UserInfo("Harry Le", "https://fb-s-a-a.akamaihd.net/h-ak-xtp1/v/t1.0-0/p600x600/14225424_475366339339151_1809592535193006162_n.jpg?oh=e3f646643f67308bc9204dedf09a2a73&oe=58C0C717&__gda__=1491865018_a15cf861abed28f01e62c22f6af7f12f"
                , "Vinova", "Android Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15384570_514684908740627_7618270673007371228_o.jpg?oh=90f5c1e2d13561cc1f04d65b218a06af&oe=58FC4C4E"));
        userInfos.add(new UserInfo("Cậu Cường", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14702451_1078550812261981_4781105640509368412_n.jpg?oh=e34f1c947cf1497078ea9eb07122d464&oe=58B74CF4"
                , "Vinova", "Android Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/10363695_664377420345991_6191636529805872706_n.jpg?oh=d60d1994e75915ad1936fedb11ac3c3b&oe=58AE3340"));
        userInfos.add(new UserInfo("John Phạm", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14516453_1246772225396317_2948261164821924209_n.jpg?oh=64d02f427e3e100027d00996df918819&oe=58FD3B58"
                , "Vinova", "Android Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/14524467_1251823171557889_6443390786635355715_o.jpg?oh=cd526dbdca51bbc46242e1ddcc3a757d&oe=58BB5DC8"));
        userInfos.add(new UserInfo("Lu ịt", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15325226_1814185142155093_7817958050022238095_o.jpg?oh=1fcd593110095cdac37d32bd46525032&oe=58BD7CBA"
                , "Vinova", "Ruby Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/21642_436236193110887_2120569209_n.jpg?oh=3de06748a5687e0e953c722594e93760&oe=58FC75F4"));
        userInfos.add(new UserInfo("Vo Danh ", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13124902_774441582691276_899922458916825268_n.jpg?oh=bac746c609cabdf7dfe0cdb00a10244d&oe=58F65E41"
                , "Vinova", "Ruby Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/11147112_623376994464403_8423053372532627007_n.jpg?oh=e038888faf034534611208d304c1b8a1&oe=58C1F6FD"));
        userInfos.add(new UserInfo("Danny Le", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/12487147_919517711489382_612795344708911951_o.jpg?oh=09be661907645b2cb740bc3e5c1f30a2&oe=58AFF8F1"
                , "Vinova", "IOS Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14519770_1106157779492040_5365191348862330622_n.jpg?oh=feab3335fc561f200d8997a64b473589&oe=58BFD2D0"));
        userInfos.add(new UserInfo("Nghia Dinh", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14064021_1783396428614271_4493956990614977901_n.jpg?oh=d9fff62fdce196ca9e966ca884f205fd&oe=58EB4171"
                , "Vinova", "IOS Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/14107769_1783428961944351_2309439028580324076_o.jpg?oh=d56495971786f4faca77454322c03c9d&oe=58B13F7D"));
        userInfos.add(new UserInfo("Ray", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14962703_1043216752467311_4608171215165721858_n.jpg?oh=43af17e8e628835caf3a5fa144786b36&oe=58F2DE70"
                , "Vinova", "Android Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15370087_1080906982031621_7951831541584897114_o.jpg?oh=1c1a601856049698a706da6491c131fc&oe=58ED563F"));
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
            Glide.with(getContext()).load(userInfo.getAvatar())
                    .asBitmap().centerCrop().into(new RoundImageBitmap(holder.ivAvatar));
            holder.tvName.setText(userInfo.getName());
            holder.tvCompany.setText(userInfo.getCompany());
            holder.tvJobPosition.setText(userInfo.getJobPosition());

            //todo setup transiton for views
            holder.ivAvatar.setTransitionName("ivAvatar" + position);
            holder.tvName.setTransitionName("tvTitle" + position);
            holder.tvCompany.setTransitionName("tvCompany" + position);
            holder.tvJobPosition.setTransitionName("tvJobPosition" + position);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSharedElementReturnTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.change_image_trans));
                    setExitTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.fade));

                    DetailInfoFragment detailInfoFragment = DetailInfoFragment.newInstance();
                    detailInfoFragment.setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.change_image_trans));
                    detailInfoFragment.setEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.fade));

                    Bundle bundle = new Bundle();
                    bundle.putString(DetailInfoFragment.AVATAR_TRANS_KEY, holder.ivAvatar.getTransitionName());
                    bundle.putString(DetailInfoFragment.NAME_TRANS_KEY, holder.tvName.getTransitionName());
                    bundle.putString(DetailInfoFragment.COMPANY_TRANS_KEY, holder.tvCompany.getTransitionName());
                    bundle.putString(DetailInfoFragment.JOB_POSITION_KEY, holder.tvJobPosition.getTransitionName());
                    bundle.putParcelable(DetailInfoFragment.AVATAR_DRAWABLE_KEY
                            , ((RoundedBitmapDrawable) (holder.ivAvatar.getDrawable())).getBitmap());
                    bundle.putSerializable(DetailInfoFragment.USER_INFO_KEY, userInfo);
                    detailInfoFragment.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, detailInfoFragment)
                            .addSharedElement(holder.ivAvatar, holder.ivAvatar.getTransitionName())
                            .addSharedElement(holder.tvName, holder.tvName.getTransitionName())
                            .addSharedElement(holder.tvCompany, holder.tvCompany.getTransitionName())
                            .addSharedElement(holder.tvJobPosition, holder.tvJobPosition.getTransitionName())
                            .addToBackStack("")
                            .commitAllowingStateLoss();
                }
            });
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
