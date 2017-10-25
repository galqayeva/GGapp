package g.y.v.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import g.y.v.anew.Models.Category;
import g.y.v.anew.Other.MyAdapter;


public class MainActivity extends AppCompatActivity {
    private List<Category> modelList1;
    private RecyclerView.Adapter adapter1;
    RecyclerView rV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rV1=(RecyclerView)findViewById(R.id.recycleview);
        modelList1=new ArrayList<>();

        Category demo=new Category("clothes","12222");
        modelList1.add(demo);
        adapter1=new MyAdapter(modelList1,getApplicationContext());
        rV1.setAdapter(adapter1);

    }
}
