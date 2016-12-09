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
        List<String> harryUrls = new ArrayList<>();
        harryUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/13086844_1067414563326377_3793963221652643716_o.jpg?oh=7aaed7659a3b66c652639b58d337ee4e&oe=58B35508");
        harryUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/1473072_1441982789358213_1067100616_n.jpg?oh=73d70a1ad1e77fcf54ae5e41717b3101&oe=58FA0F65");
        harryUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15250885_1120951311355264_5638433258738629713_o.jpg?oh=febe3b10ffc2242a6f4bad3a985a75aa&oe=58B8C94D");
        harryUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13178703_991625867600887_6168619455013894646_n.jpg?oh=06b04cd272dcb1d2b9f0b43e525a7cf1&oe=58B31944");

        userInfos.add(new UserInfo("Harry Le", "https://fb-s-a-a.akamaihd.net/h-ak-xtp1/v/t1.0-0/p600x600/14225424_475366339339151_1809592535193006162_n.jpg?oh=e3f646643f67308bc9204dedf09a2a73&oe=58C0C717&__gda__=1491865018_a15cf861abed28f01e62c22f6af7f12f"
                , "Vinova", "Android Developer"
                , "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15384570_514684908740627_7618270673007371228_o.jpg?oh=90f5c1e2d13561cc1f04d65b218a06af&oe=58FC4C4E", harryUrls));

        List<String> benUrls = new ArrayList<>();
        benUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15304365_1814184948821779_8514017730761978655_o.jpg?oh=3562f52763025fd125f0bba5d378a8bf&oe=58F7DBF8");
        benUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/12932951_529769190560514_8812478188529115205_n.jpg?oh=558daf771e06ddca770a1dc89c02da6f&oe=58C06ACE");
        benUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15304395_1120087898108272_4515742610483476057_o.jpg?oh=65aa70b91bd8fa6e370ff6d9e4094d1c&oe=58EBE8C0");
        benUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/14711327_1076415165808879_7550405835337529418_o.jpg?oh=b39b4c8eb2277bb9fb870da7cd0241dd&oe=58BC5799");
        userInfos.add(new UserInfo("Cậu Cường", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14702451_1078550812261981_4781105640509368412_n.jpg?oh=e34f1c947cf1497078ea9eb07122d464&oe=58B74CF4"
                , "Vinova", "Android Developer"
                , "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/10363695_664377420345991_6191636529805872706_n.jpg?oh=d60d1994e75915ad1936fedb11ac3c3b&oe=58AE3340", benUrls));

        List<String> johnUrls = new ArrayList<>();
        johnUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/15219509_1325030427570496_4147356632534045074_n.jpg?oh=234b5c28904897c3375afba39acc8086&oe=58C0A4F8");
        johnUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/15220180_1324934524246753_5534412286478936637_n.jpg?oh=efc5bbfb28520d54330de9c9949f1274&oe=58BE594C");
        johnUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/p960x960/15137616_690476487774918_3237943867549534701_o.jpg?oh=df1cf59e9cd3cecbb8bb524a85449315&oe=58F6FDBC");
        userInfos.add(new UserInfo("John Phạm", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14516453_1246772225396317_2948261164821924209_n.jpg?oh=64d02f427e3e100027d00996df918819&oe=58FD3B58"
                , "Vinova", "Android Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/14524467_1251823171557889_6443390786635355715_o.jpg?oh=cd526dbdca51bbc46242e1ddcc3a757d&oe=58BB5DC8",johnUrls));


        List<String> louisUrls = new ArrayList<>();
        louisUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15325226_1814185142155093_7817958050022238095_o.jpg?oh=1fcd593110095cdac37d32bd46525032&oe=58BD7CBA");
        louisUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15370101_1814187042154903_943118417409174912_o.jpg?oh=91f3a77d609e33a417f66c688db7ad02&oe=58BB272E");
        louisUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15418438_1814186718821602_8154067575917761047_o.jpg?oh=9109409e003df6d92c0c5175cbb7b270&oe=58B01895");
        louisUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15440423_1814185468821727_3282145100260934887_o.jpg?oh=59f507ccd06ea8066b0b632e0c65e621&oe=58F21CEB");
        userInfos.add(new UserInfo("Lu ịt", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15325226_1814185142155093_7817958050022238095_o.jpg?oh=1fcd593110095cdac37d32bd46525032&oe=58BD7CBA"
                , "Vinova", "Ruby Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/21642_436236193110887_2120569209_n.jpg?oh=3de06748a5687e0e953c722594e93760&oe=58FC75F4",louisUrls));

        List<String> thomasUrls = new ArrayList<>();
        thomasUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/11145115_1696295813926552_3755198037411122735_o.jpg?oh=be3c82bca97bbba26e5caa4504107c98&oe=58F5A584");
        thomasUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/536257_576761089125994_3368832343687682527_n.jpg?oh=db04b5d46cae383ec88bd53c692c7f14&oe=58F9F322");
        thomasUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13124902_774441582691276_899922458916825268_n.jpg?oh=bac746c609cabdf7dfe0cdb00a10244d&oe=58F65E41");
        userInfos.add(new UserInfo("Vo Danh ", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13124902_774441582691276_899922458916825268_n.jpg?oh=bac746c609cabdf7dfe0cdb00a10244d&oe=58F65E41"
                , "Vinova", "Ruby Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/11147112_623376994464403_8423053372532627007_n.jpg?oh=e038888faf034534611208d304c1b8a1&oe=58C1F6FD",thomasUrls));

        List<String> dannyUrls = new ArrayList<>();
        dannyUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/15337659_1172732122834605_4823954581028978300_n.jpg?oh=7bea0bad47fa921c63ae9f8cc4a79104&oe=58F473CF");
        dannyUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/15317994_1172732132834604_2869084068644553078_n.jpg?oh=18ee97171ced9a57b7e76791bb65cd17&oe=58BD5DA1");
        dannyUrls.add("https://fb-s-d-a.akamaihd.net/h-ak-xtp1/v/t1.0-0/p600x600/15241965_1171344706306680_6763242311985679012_n.jpg?oh=d81ffeeab0f0fbbf54d1c4534e25001f&oe=58BE1A07&__gda__=1488874021_104118d584ae02602463311816f3b1d0");
        userInfos.add(new UserInfo("Danny Le", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/12487147_919517711489382_612795344708911951_o.jpg?oh=09be661907645b2cb740bc3e5c1f30a2&oe=58AFF8F1"
                , "Vinova", "IOS Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14519770_1106157779492040_5365191348862330622_n.jpg?oh=feab3335fc561f200d8997a64b473589&oe=58BFD2D0",dannyUrls));

        List<String> nicholasUrls = new ArrayList<>();
        nicholasUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15304548_695084673980766_6091841241018965785_o.jpg?oh=d19d4fae90e5f731516d0a9bb5bfc4de&oe=58F6903A");
        nicholasUrls.add("https://fb-s-c-a.akamaihd.net/h-ak-xal1/v/t1.0-0/p206x206/14650474_1127031910737960_2731557790202939014_n.jpg?oh=19f11ba27fff353a0489b7f02fd866b5&oe=58F6E6EF&__gda__=1492689386_13cc09bc132945d40ca522f54ebf863e");
        nicholasUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/12718333_1020627464626221_4575225013510051369_n.jpg?oh=f2af2ea2d7ceb12bd434910f6c7212b5&oe=58BAB1A1");
        userInfos.add(new UserInfo("Nghia Dinh", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14064021_1783396428614271_4493956990614977901_n.jpg?oh=d9fff62fdce196ca9e966ca884f205fd&oe=58EB4171"
                , "Vinova", "IOS Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/14107769_1783428961944351_2309439028580324076_o.jpg?oh=d56495971786f4faca77454322c03c9d&oe=58B13F7D",nicholasUrls));

        List<String> rayUrls = new ArrayList<>();
        rayUrls.add("https://fb-s-c-a.akamaihd.net/h-ak-xpa1/v/t1.0-0/p206x206/15337457_1082601935195459_1922636387713693429_n.jpg?oh=432f85ae79677d38d5cd34fcdf82ae3a&oe=58F8DECD&__gda__=1491872271_bff3d437c169b68dcc4366f68952b5e3");
        rayUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15370064_1078316058957380_524274937054806258_o.jpg?oh=d153e0336df25107b37310814219e3f4&oe=58AEA187");
        rayUrls.add("https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15304085_1076843045771348_687321477423509264_o.jpg?oh=d967219df8577ce9f550e70e103f583f&oe=58F59A3C");
        userInfos.add(new UserInfo("Ray", "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/14962703_1043216752467311_4608171215165721858_n.jpg?oh=43af17e8e628835caf3a5fa144786b36&oe=58F2DE70"
                , "Vinova", "Android Developer", "https://scontent-sin6-1.xx.fbcdn.net/v/t31.0-8/15370087_1080906982031621_7951831541584897114_o.jpg?oh=1c1a601856049698a706da6491c131fc&oe=58ED563F",rayUrls));
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
