package hr.lknezovic.adder;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumber, secondNumber;
    private Button add, next, googleSearch;
    private TextView result;
    private Integer res;
    private ListView myListView;
    private String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = (EditText) findViewById(R.id.firstEditNumber);
        secondNumber = (EditText) findViewById(R.id.secondEditNumber);
        add = (Button) findViewById(R.id.addNumbers);
        result = (TextView) findViewById(R.id.resultView);

        next = (Button) findViewById(R.id.nextActivity);
        googleSearch = (Button) findViewById(R.id.google);


        Resources resorce = getResources();
      /*  myListView = (ListView) findViewById(R.id.myListView);
        items = resorce.getStringArray(R.array.items);*/





        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(newIntent);
            }
        });

        googleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "http://www.yahoo.com";
                Uri web = Uri.parse(google);

                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, web);
                if (goToGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToGoogle);
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fNum = firstNumber.getText().toString();
                String sNum = secondNumber.getText().toString();

                res = Integer.parseInt(fNum) + Integer.parseInt(sNum);
                result.setText(Integer.toString(res));
            }
        });


    }


    public void addNumbers(View view) {


    }
}
