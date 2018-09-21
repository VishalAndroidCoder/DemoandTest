package appsoft.com.demoandtest1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;

import java.util.ArrayList;

public class BarActivity extends AppCompatActivity {

    private BarChart barChart;
    private float barWidth;
    private float barSpace;
    private float groupSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);

        barChart = findViewById(R.id.barChart);
        barWidth = 0.3f;
        barSpace = 0.0f;
        groupSpace = 0.4f;

        Description description = new Description();
        description.setText("Annual Attendance");
        description.setTextColor(Color.GRAY);
        description.setTextSize(10);
        barChart.setDescription(description);
        barChart.setPinchZoom(false);
        barChart.setDrawBarShadow(false);
        barChart.setScaleEnabled(true);
        barChart.computeScroll();
        barChart.setDrawGridBackground(false);
        barChart.animateXY(3000, 3000);

        int groupCount = 12;

        ArrayList xVals = new ArrayList();
        xVals.add("Jun");
        xVals.add("Jul");
        xVals.add("Aug");
        xVals.add("Sep");
        xVals.add("Oct");
        xVals.add("Nov");
        xVals.add("Dec");
        xVals.add("Jan");
        xVals.add("Feb");
        xVals.add("Mar");
        xVals.add("Apr");
        xVals.add("May");


        ArrayList yVals1 = new ArrayList();
        ArrayList yVals2 = new ArrayList();

        yVals1.add(new BarEntry(1, (float)24));
        yVals2.add(new BarEntry(1, (float)20));
        yVals1.add(new BarEntry(2, (float)23));
        yVals2.add(new BarEntry(2, (float)16));
        yVals1.add(new BarEntry(3, (float)20));
        yVals2.add(new BarEntry(3, (float)16));
        yVals1.add(new BarEntry(4, (float)18));
        yVals2.add(new BarEntry(4, (float)8));
        yVals1.add(new BarEntry(5, (float)22));
        yVals2.add(new BarEntry(5, (float)0));
        yVals1.add(new BarEntry(6, (float)0));
        yVals2.add(new BarEntry(6, (float)0));
        yVals1.add(new BarEntry(7, (float)0));
        yVals2.add(new BarEntry(7, (float)0));
        yVals1.add(new BarEntry(8, (float)0));
        yVals2.add(new BarEntry(8, (float)0));
        yVals1.add(new BarEntry(9, (float)0));
        yVals2.add(new BarEntry(9, (float)0));
        yVals1.add(new BarEntry(10, (float)0));
        yVals2.add(new BarEntry(10, (float)0));
        yVals1.add(new BarEntry(11, (float)0));
        yVals2.add(new BarEntry(11, (float)0));
        yVals1.add(new BarEntry(12, (float)0));
        yVals2.add(new BarEntry(12, (float)0));

        BarDataSet set1, set2;
        set1 = new BarDataSet(yVals1, "Working Days");
        set1.setColor(Color.DKGRAY);
        set1.setValueTextSize(14f);
        set2 = new BarDataSet(yVals2,"Present Days");
        set2.setColor(Color.GREEN);
        set2.setValueTextSize(14f);

        BarData data = new BarData(set1, set2);
        data.setValueFormatter(new LargeValueFormatter());
        barChart.setData(data);
        barChart.getBarData().setBarWidth(barWidth);
        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0 + barChart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
        barChart.groupBars(0, groupSpace, barSpace);

        Legend legend = barChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(true);
        legend.setYOffset(20f);
        legend.setXOffset(0f);
        legend.setYEntrySpace(0f);
        legend.setTextSize(8f);

        // X axis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        //xAxis.setAxisMaximum(6);
        xAxis.setLabelRotationAngle(315);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));

        // Y axis
        barChart.getAxisRight().setEnabled(false);
        YAxis yAxis = barChart.getAxisLeft();
        yAxis.setValueFormatter(new LargeValueFormatter());
        yAxis.setDrawGridLines(true);
        yAxis.setSpaceTop(35f);
        yAxis.setAxisMinimum(0f);

        barChart.invalidate();
    }
}
