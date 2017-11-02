package g.y.v.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;

import g.y.v.anew.Models.CategoryModel;
import g.y.v.anew.Other.MyAdapter;

public class SpendinglistActivity extends BaseActivity {

    private List<CategoryModel> modelList1;
    private RecyclerView.Adapter adapter1;
    RecyclerView rV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spendinglist);
        toolBarInitialize(R.id.toolbar);
        setTitle("My Budget Planner");

        rV1=(RecyclerView)findViewById(R.id.recycleview);
        rV1.setHasFixedSize(true);
        rV1.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        modelList1=new ArrayList<>();

        for(int i=1;i<=16;i++){
            CategoryModel demo=new CategoryModel("cfor clothing jaod die 18 avqust","120$");
            modelList1.add(demo);
        }

        adapter1=new MyAdapter(modelList1,getApplicationContext());
        rV1.setAdapter(adapter1);
    }
}
