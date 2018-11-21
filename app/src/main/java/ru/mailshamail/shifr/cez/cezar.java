package ru.mailshamail.shifr.cez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.mailshamail.shifr.R;
import ru.mailshamail.shifr.utils.utils;

public class cezar extends AppCompatActivity {

    TextView res;
    Button resButton,resButton2 ;
    EditText key, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cezar);

        res = (TextView)findViewById(R.id.result);
        resButton = (Button)findViewById(R.id.resButton);
        resButton2 = (Button)findViewById(R.id.resButton2);
        text = (EditText)findViewById(R.id.text);
        key = (EditText)findViewById(R.id.key);


        resButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String text2;
                int key2;

                text2 = text.getText().toString();
                key2 = Integer.parseInt(key.getText().toString());

                res.setText(utils.decodeCezar(text2, key2));

                //if(!text2.equals("") && key2 != 0)
                //{
                    //String result = utils.codeCezar(text2, key2);
                   // System.out.println(result);
                    //res.setText(utils.codeCezar(text2, key2));
                //}
            }
        });

        resButton2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String text2;
                int key2 ;

                text2 = text.getText().toString();
                key2 = Integer.parseInt(key.getText().toString());

                res.setText(utils.codeCezar(text2, key2));

                //if(!text2.equals("") && key2 != 0)
                //{
                //String result = utils.codeCezar(text2, key2);
                // System.out.println(result);
                //res.setText(utils.codeCezar(text2, key2));
                //}
            }
        });

    }
}
