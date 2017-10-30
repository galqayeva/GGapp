package g.y.v.anew;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import g.y.v.anew.Other.DatabaseHelper;


public class CategoryActivity extends AppCompatActivity {

    EditText etClo,etTra,etEnt,etCos,etRes,etBir,etMed,etJew,etMar,etOth;
    EditText etTClo,etTtra,etTEnt,etTCos,etTRes,etTBir,etTMed,etTJew,etTMar,etTOth;
    Button button;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        myDB = new DatabaseHelper(getApplicationContext());

        etClo=(EditText)findViewById(R.id.etCloth);
        etTra=(EditText)findViewById(R.id.etTransp);
        etEnt=(EditText)findViewById(R.id.etEntr);
        etCos=(EditText)findViewById(R.id.etCos);
        etRes=(EditText)findViewById(R.id.etRes);
        etBir=(EditText)findViewById(R.id.etBirth);
        etMed=(EditText)findViewById(R.id.etMed);
        etJew=(EditText)findViewById(R.id.etJew);
        etMar=(EditText)findViewById(R.id.etMar);
        etOth=(EditText)findViewById(R.id.etOther);

        etTClo=(EditText)findViewById(R.id.etTclot);
        etTtra=(EditText)findViewById(R.id.etTransp);
        etTEnt=(EditText)findViewById(R.id.etTenter);
        etTCos=(EditText)findViewById(R.id.etTcosmetic);
        etTRes=(EditText)findViewById(R.id.etTrestaurnat);
        etTBir=(EditText)findViewById(R.id.etTbirth);
        etTMed=(EditText)findViewById(R.id.etTmedicin);
        etTJew=(EditText)findViewById(R.id.etTjewelery);
        etTMar=(EditText)findViewById(R.id.etTmarket);
        etTOth=(EditText)findViewById(R.id.etTother);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();

                String sDate = c.get(Calendar.YEAR) + "-"
                        + c.get(Calendar.MONTH)+"1"
                        + "-" + c.get(Calendar.DAY_OF_MONTH);

                boolean insertData = myDB.addData(sDate,
                        etTClo.getText().toString(),integerParse(etClo.getText().toString()),
                        etTCos.getText().toString(),integerParse(etCos.getText().toString()),
                        etTMed.getText().toString(),integerParse(etMed.getText().toString()),
                        etTEnt.getText().toString(),integerParse(etEnt.getText().toString()),
                        etTRes.getText().toString(),integerParse(etRes.getText().toString()),
                        etTBir.getText().toString(),integerParse(etBir.getText().toString()),
                        etTMar.getText().toString(),integerParse(etMar.getText().toString()),
                        etTtra.getText().toString(),integerParse(etTra.getText().toString()),
                        etTJew.getText().toString(),integerParse(etJew.getText().toString()),
                        etTOth.getText().toString(),integerParse(etOth.getText().toString())

                );
                if(!insertData==true)
                    Log.d("something","getwrong");



                AlertDialog alertDialog = new AlertDialog.Builder(CategoryActivity.this).create();
                alertDialog.setTitle("Congrulations");
                alertDialog.setMessage("Your record is added");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent=new Intent(CategoryActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        });
                alertDialog.show();

            }
        });

        demo();

    }
    public  int integerParse(String k) {

        int a = 0;
        if (k == "") {
            a = 0;
        }
        return a;
    }

    public  void demo(){
        Cursor data = myDB.getAlldata();

        String gunay="********";
        if(data.getCount() != 0)
        {
            Log.d("Gunay","--"+data.getCount());
            while(data.moveToNext())
            {
                gunay=data.getString(0)
                        +data.getString(1)+data.getString(2)+data.getString(3)+
                        data.getString(4)+data.getString(5)+data.getString(6)+data.getString(7)+
                        data.getString(8)+data.getString(9)+data.getString(10)+data.getString(11);
            }
            Log.d("Gunay",gunay);

        }
    }
}
