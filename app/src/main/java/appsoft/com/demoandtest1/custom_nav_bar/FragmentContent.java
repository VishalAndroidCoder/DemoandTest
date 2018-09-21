package appsoft.com.demoandtest1.custom_nav_bar;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import appsoft.com.demoandtest1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContent extends Fragment {

    private static final String KEY_TITLE = "Content";

    public FragmentContent() {
    }

    public static FragmentContent getInstance(String title){
        FragmentContent fragmentContent = new FragmentContent();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_TITLE, title);
        fragmentContent.setArguments(bundle);
        return fragmentContent;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String title = getArguments().getString(KEY_TITLE);
        ((TextView)view.findViewById(R.id.title)).setText(title);
    }
}
