package g.y.v.anew;


/**
 * Created by softFaGE.az on 10/28/2017.
 */
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import g.y.v.anew.R;


public abstract class BaseActivity extends ActionBarActivity {


    private TextView textViewUserName;
    private ImageView imageViewUserPhoto;
    private Intent intent;
    private SharedPreferences prospectPreferences;
    private SharedPreferences.Editor editorPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void toolBarInitialize(int toolBarId) {
        Toolbar toolbar = (Toolbar) findViewById(toolBarId);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setSubtitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);

        PrimaryDrawerItem item0 = new PrimaryDrawerItem().withIdentifier(1).withName("Home Page");
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(2).withName("My Spendings");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(3).withName("Add Spendings");
        PrimaryDrawerItem item3=  new PrimaryDrawerItem().withIdentifier(4).withName("Log Out");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .build();
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withActionBarDrawerToggle(true)
                .withSliderBackgroundColorRes(R.color.primary)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item0,item1,item2,
                        new DividerDrawerItem(),item3
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position){
                            case 1:
                                Intent intent0=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent0);
                                break;
                            case 2:
                                Intent intent1=new Intent(getApplicationContext(),SpendinglistActivity.class);
                                startActivity(intent1);
                                break;
                            case 3:
                                Intent intent2=new Intent(getApplicationContext(),CategoryActivity.class);
                                startActivity(intent2);
                                break;


                        }

                        return true;
                    }
                })
                .build();

    }

}