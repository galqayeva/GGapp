package g.y.v.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner,spinner2;
    Button btn;
    ArrayAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btn=(Button)findViewById(R.id.button);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.category,android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        adapter2=ArrayAdapter.createFromResource(MainActivity.this,R.array.altcategoryA,android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Title");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                adapter2=ArrayAdapter.createFromResource(MainActivity.this,R.array.altcategoryB,android.R.layout.simple_spinner_dropdown_item);
                btn.setText("bb");
                spinner2.setAdapter(adapter2);

                Toast.makeText(MainActivity.this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                if(spinner.getSelectedItem().toString()=="Eylence"){
                    adapter2=ArrayAdapter.createFromResource(MainActivity.this,R.array.altcategoryA,android.R.layout.simple_spinner_dropdown_item);
                    btn.setText("aaa");
                    spinner2.setAdapter(adapter2);

                }
                if(spinner.getSelectedItem().toString()=="Cafe")
                {
                    adapter2=ArrayAdapter.createFromResource(MainActivity.this,R.array.altcategoryB,android.R.layout.simple_spinner_dropdown_item);
                    btn.setText("bb");
                    spinner2.setAdapter(adapter2);
                }
                if(spinner.getSelectedItem().toString()=="Restaurant"){
                    adapter2=ArrayAdapter.createFromResource(MainActivity.this,R.array.altcategoryC,android.R.layout.simple_spinner_dropdown_item);
                    btn.setText("ca");
                    spinner2.setAdapter(adapter2);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }
}
