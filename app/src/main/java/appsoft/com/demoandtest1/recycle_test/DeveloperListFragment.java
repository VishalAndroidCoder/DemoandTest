package appsoft.com.demoandtest1.recycle_test;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import appsoft.com.demoandtest1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeveloperListFragment extends Fragment {

    private RecyclerView.LayoutManager mManager;
    public DeveloperListFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_developer_list, container, false);
    }

    private List<DeveloperNameModel> generateList() {
        List<DeveloperNameModel> developerNameModelList = new ArrayList<>();
        DeveloperNameModel model1 = new DeveloperNameModel("Vishal Rana", "Appsoft", 23);
        DeveloperNameModel model2 = new DeveloperNameModel("Kushal Rana", "Businessman", 25);
        DeveloperNameModel model3 = new DeveloperNameModel("Vishky Rana", "Infosys", 21);

        developerNameModelList.add(model1);
        developerNameModelList.add(model2);
        developerNameModelList.add(model3);
        return developerNameModelList;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.listDeveloper);
        recyclerView.setHasFixedSize(true);
        mManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mManager);
        generateList();
        // Generate Adapter and pass list to RecyclerView Adapter
    }
}
