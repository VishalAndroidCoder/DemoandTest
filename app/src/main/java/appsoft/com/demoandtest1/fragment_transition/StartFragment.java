package appsoft.com.demoandtest1.fragment_transition;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import appsoft.com.demoandtest1.R;

public class StartFragment extends Fragment {

    private ImageView img;
    private Button btn;
    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        img = view.findViewById(R.id.image);
        btn = view.findViewById(R.id.ok);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .addSharedElement(img, ViewCompat.getTransitionName(img))
                        .addToBackStack(null)
                        .replace(R.id.fragmentContainer, new EndFragment())
                        .commit();
            }
        });
    }
}
