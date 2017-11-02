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
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import g.y.v.anew.Models.CategoryModel;
import g.y.v.anew.Other.DatabaseHelper;
import g.y.v.anew.Other.MyAdapter;


public class MainActivity extends BaseActivity{

    Button btn;
    PieChart pieChart;
    DatabaseHelper myDB;
    TextView last7,last1,lastMonth;

    private float[] yData=new float[5];
    private String[] xData={ "","Clothes" , "medicine" , "Entertainment", "Transport", "other"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBarInitialize(R.id.toolbar);
        setTitle("My Budget Planner");

        last1=(TextView)findViewById(R.id.textView3);
        last7=(TextView)findViewById(R.id.textView4);
        lastMonth=(TextView)findViewById(R.id.textView5);
        pieChart=(PieChart)findViewById(R.id.pieChart);

        myDB = new DatabaseHelper(getApplicationContext());
        myDB.addData("0","0",0,"0",0,"0",0,"0",0,"0",0);

        btn=(Button)findViewById(R.id.buttonAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });

        last1.setText("Last day Spending "+getSpend("2")+" $");
        last7.setText("Last week Spending "+getSpend("7")+" $");
        lastMonth.setText("Last month Spending "+getSpend("30")+" $");

        yData[0]=demo("clothesM");
        yData[1]=demo("medicineM");
        yData[2]=demo("entertainM");
        yData[3]=demo("transportTextM");
        yData[4]=demo("otherM");

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
                String type = xData[pos1 + 1];
                Toast.makeText(MainActivity.this, "You spend " +sales + "$ \n" + "on " + type, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected() {}
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
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Spending");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.MAGENTA);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.RED);
        colors.add(Color.WHITE);

        pieDataSet.setColors(colors);

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    public float demo(String content){

        Cursor data = myDB.getListContents(content);
        String k = "0";
        if(data.getCount() != 0)
        {
            while(data.moveToNext())
            {
                k=data.getString(0);
            }
        }
        else
            k="10";
        return Float.parseFloat(k);
    }

    public String  getSpend(String day){

        Cursor data = myDB.getLimitedData(day);
        String a = "0";
        if(data.getCount() != 0)
        {
            while(data.moveToNext())
            {
                a=data.getString(0);
            }
        }
        return a;
    }
}
