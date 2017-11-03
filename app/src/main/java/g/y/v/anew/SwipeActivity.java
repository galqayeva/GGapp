package g.y.v.anew;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.widget.ArrayAdapter;
import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;

import java.util.ArrayList;

import g.y.v.anew.Other.DatabaseHelper;

public class SwipeActivity extends BaseActivity {

    private static final String TAG = "salus";
    DatabaseHelper myDB;
    SwipeMenuListView listView;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        toolBarInitialize(R.id.toolbar);
        setTitle("My Budget Planner");

        listView = (SwipeMenuListView) findViewById(R.id.listView);
        loadList();

    }

    private void loadList(){

        list = new ArrayList<>();
        myDB = new DatabaseHelper(getApplicationContext());
        Cursor data = myDB.getAlldata();
        if (data.getCount() != 0) {
            while (data.moveToNext()) {
                list.add("Your Spending is " + data.getString(1) + "$");
            }
        }

        final ArrayAdapter adapter = new ArrayAdapter(SwipeActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);


        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem openItem = new SwipeMenuItem(getApplicationContext());
                openItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x66, 0xff)));
                openItem.setWidth(170);
                openItem.setTitle("Open");
                openItem.setTitleSize(18);
                openItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(openItem);

                SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                deleteItem.setWidth(170);
                deleteItem.setTitle("Delete");
                deleteItem.setTitleSize(18);
                deleteItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(deleteItem);
            }
        };


        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {


                    case 0:
                        Intent intent = new Intent(SwipeActivity.this, CategoryActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        myDB.deleteId(position);
                        adapter.clear();
                        list.clear();
                        loadList();
                       // Log.d("gunay","a-"+adapter.getItem(0));
                        break;
                }
                return false;
            }
        });
    }
}
