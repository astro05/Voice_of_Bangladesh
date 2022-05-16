package com.example.voiceofbangladesh;


        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v7.widget.CardView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.support.v4.app.FragmentManager;





public class Home_Fragment  extends Fragment implements View.OnClickListener {

    private CardView emergency,report,govinfo,feedback;
    private static View view;
    private static FragmentManager fragmentManager;

    public Home_Fragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews();
        setListeners();
        return view;
    }

    private void initViews() {
        fragmentManager = getActivity().getSupportFragmentManager();
        emergency =(CardView) view.findViewById(R.id.card_emergency);
        report = (CardView) view.findViewById(R.id.card_report);
        govinfo = (CardView) view.findViewById(R.id.card_govinfo);
        feedback = (CardView) view.findViewById(R.id.card_feedback);


    }


    private void setListeners() {
        emergency.setOnClickListener(this);
        report.setOnClickListener(this);
        govinfo.setOnClickListener(this);
        feedback.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.card_emergency :
            fragmentManager
                    .beginTransaction().replace(R.id.fragment_container, new Emergency_Fragment(), null).addToBackStack(null).commit();
            break;
            case R.id.card_report :
                fragmentManager
                        .beginTransaction().replace(R.id.fragment_container, new Report_Fragment(), null).addToBackStack(null).commit();
                break;
            case R.id.card_govinfo :
                fragmentManager
                        .beginTransaction().replace(R.id.fragment_container, new Govinfo_Fragment(),null).addToBackStack(null).commit();
                break;
                case R.id.card_feedback :
                fragmentManager
                        .beginTransaction().replace(R.id.fragment_container, new Feedback_Fragment(), null).addToBackStack(null).commit();
                break;



        }


    }
}