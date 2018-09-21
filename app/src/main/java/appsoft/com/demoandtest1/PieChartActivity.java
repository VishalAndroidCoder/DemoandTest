package appsoft.com.demoandtest1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    private PieChart pieChart;
    private String[] names = {"paid", "unpaid"};
    private float fees[] = {21000, 7000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        pieChart = findViewById(R.id.myPie);
        Description desc = new Description();
        desc.setText("Annual School Fees in Rupees");
        pieChart.setDescription(desc);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleColor(Color.CYAN);
        pieChart.setHoleRadius(20.0f);
        pieChart.setCenterText("School Fees");
        pieChart.setCenterTextSize(12.0f);
        //pieChart.setDrawEntryLabels(true);
        //pieChart.setTransparentCircleAlpha(20);

        setDataToPieChart();

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(PieChartActivity.this, ""+e.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

    private void setDataToPieChart(){
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<PieEntry> dataEntry = new ArrayList<>();

        for (String n : names){
            nameList.add(n);
        }

        for (Float e: fees){
            dataEntry.add(new PieEntry(e));
        }

        PieDataSet pieDataSet = new PieDataSet(dataEntry, "Fees");
        pieDataSet.setSliceSpace(2.0f);
        pieDataSet.setValueTextSize(12);

        // SetColors Now

        ArrayList<Integer> colorArray = new ArrayList<>();
        colorArray.add(Color.RED);
        colorArray.add(Color.GREEN);
        colorArray.add(Color.MAGENTA);
        colorArray.add(Color.BLUE);
        colorArray.add(Color.YELLOW);

        pieDataSet.setColors(colorArray);

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        // Create Pie data Object

        PieData dataPie = new PieData(pieDataSet);
        pieChart.setData(dataPie);
        pieChart.invalidate();
    }
}
