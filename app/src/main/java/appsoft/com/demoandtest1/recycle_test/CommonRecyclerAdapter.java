package appsoft.com.demoandtest1.recycle_test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import aar.erp.appsoft.androidlog.AndroidLog;
import appsoft.com.demoandtest1.R;
import appsoft.com.demoandtest1.recycle_test.bind_classes.DeveloperBindClass;
import appsoft.com.demoandtest1.recycle_test.bind_classes.OsBindViewClass;

import static android.support.constraint.Constraints.TAG;
import static appsoft.com.demoandtest1.recycle_test.Constants.DEVELOPER_INTENT_FLAG;
import static appsoft.com.demoandtest1.recycle_test.Constants.OS_INTENT_FLAG;

public class CommonRecyclerAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Object> list;
    private int flag;
    private int layoutId;

    public CommonRecyclerAdapter(Context context, List<Object> list, int flag, int layoutId){
        this.context = context;
        this.list = list;
        this.flag = flag;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)/* throws NullPointerException*/{
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(layoutId, parent, false);
        return new CommonHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (flag){
            case DEVELOPER_INTENT_FLAG:
                DeveloperBindClass.bindViews(holder, position);
                return;
            case OS_INTENT_FLAG:
                OsBindViewClass.bindViews(holder, position);
                return;
        }
    }

    @Override
    public int getItemCount() {
        try {
            if (list != null){
                Log.d(Constants.TAG , "List Size : "+list.size());
                return list.size();
            }
        }catch (NullPointerException npe){
            Log.d(Constants.TAG , "List Null : "+npe.getMessage());
        }
        return 0;
    }

    class CommonHolder extends RecyclerView.ViewHolder{

        public CommonHolder(View cardView) {
            super(cardView);
        }
    }
}
