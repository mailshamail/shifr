package ru.mailshamail.shifr.Polibiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.mailshamail.shifr.R;
import ru.mailshamail.shifr.utils.utils;

public class Polibiy extends AppCompatActivity {

    TextView res;
    Button CodeButton, decodeButton;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polibiy);


        res = (TextView)findViewById(R.id.result);
        CodeButton = (Button)findViewById(R.id.CodeButton);
        decodeButton = (Button)findViewById(R.id.decodeButton);
        text = (EditText)findViewById(R.id.text);


        CodeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                res.setText(utils.codePolibiy(text.getText().toString()));

                //System.out.println(utils.codePolibiy(text.getText().toString()));
            }
        });

        decodeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                res.setText(utils.decodePolibiy(text.getText().toString()));

                //System.out.println(utils.codePolibiy(text.getText().toString()));
            }
        });

    }
}
