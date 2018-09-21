package appsoft.com.demoandtest1.recycle_test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import appsoft.com.demoandtest1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeveloperDetailFragment extends Fragment {


    public DeveloperDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_developer_detail, container, false);
    }
}
