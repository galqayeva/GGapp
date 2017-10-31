package g.y.v.anew;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import g.y.v.anew.Models.CategoryModel;
import g.y.v.anew.Other.DatabaseHelper;
import g.y.v.anew.Other.MyAdapter;


public class MainActivity extends AppCompatActivity {
    private List<CategoryModel> modelList1;
    private RecyclerView.Adapter adapter1;
    RecyclerView rV1;
    Button btn;
    PieChart pieChart;
    DatabaseHelper myDB;

    private float[] yData=new float[5];
    private String[] xData={ "","Clothes" , "medicine" , "Entertainment", "Transport", "other"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(getApplicationContext());

        btn=(Button)findViewById(R.id.buttonAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });

        yData[0]=demo("clothesM");
        yData[1]=demo("medicineM");
        yData[2]=demo("entertainM");
        yData[3]=demo("transportTextM");
        yData[4]=demo("otherM");


        pieChart=(PieChart)findViewById(R.id.pieChart);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("$");
        pieChart.setCenterTextSize(10);

        addDataSet();
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                int pos1 = e.toString().indexOf("(sum): ");
                String sales = e.toString().substring(pos1 + 7);

                for(int i = 0; i < yData.length; i++){
                    if(yData[i] == Float.parseFloat(sales)){
                        pos1 = i;
                        break;
                    }
                }
                String employee = xData[pos1 + 1];
                Toast.makeText(MainActivity.this, "You spend " +sales + "$ \n" + "on " + employee, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected() {

            }
        });


    }

    private void addDataSet() {


        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            yEntrys.add(new PieEntry(yData[i] , i));
        }

        for(int i = 0; i < xData.length; i++){
            xEntrys.add(xData[i]);
        }
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Speding");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.WHITE);
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);
        colors.add(Color.LTGRAY);
        colors.add(Color.CYAN);

        pieDataSet.setColors(colors);

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }

    public Float  demo(String content){

        Cursor data = myDB.getListContents(content);

        String gunay = "";
        if(data.getCount() != 0)
        {
            while(data.moveToNext())
            {
                gunay=data.getString(0);

            }
            Log.d("Gunay",gunay);

        }

        return Float.parseFloat(gunay);
    }
}
