package g.y.v.anew.Other;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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
import java.util.Calendar;

import g.y.v.anew.CategoryActivity;
import g.y.v.anew.MainActivity;
import g.y.v.anew.R;


/**
 * Created by galqayeva on 02.11.2017.
 */

public class Methd extends AppCompatActivity{


    public String  getDate(){

        Calendar c = Calendar.getInstance();
        String sDate = c.get(Calendar.YEAR) + "-"
                + (c.get(Calendar.MONTH)+1)
                + "-" + c.get(Calendar.DAY_OF_MONTH);

        return sDate;
    }
    private void addDataSet(PieChart pieChart, final float[] yData, final String xData) {


    }

}
