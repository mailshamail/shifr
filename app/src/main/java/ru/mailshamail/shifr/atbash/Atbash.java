package ru.mailshamail.shifr.atbash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.mailshamail.shifr.R;
import ru.mailshamail.shifr.utils.utils;

public class Atbash extends AppCompatActivity {

    TextView res;
    EditText orshift;
    Button code,decode;

    String codeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atbash);

        res = (TextView) findViewById(R.id.result);
        orshift = (EditText) findViewById(R.id.OriginalText);

        code = (Button) findViewById(R.id.code);
        decode = (Button) findViewById(R.id.decode);

        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               codeText = utils.codeAtbash(orshift.getText().toString());
               res.setText(codeText);
            }
        });

        decode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                codeText = utils.decodeAtbash(orshift.getText().toString());
                res.setText(codeText);
            }
        });

       // orshift.setOnKeyListener(new View.OnKeyListener() {
       //     public boolean onKey(View v, int keyCode, KeyEvent event) {
       //         if (event.getAction() == KeyEvent.ACTION_DOWN) {
       //             switch (keyCode) {
       //                 case KeyEvent.KEYCODE_DPAD_CENTER:
       //                 case KeyEvent.KEYCODE_ENTER:
//
       //                     if(!chek.isActivated())
       //                     {
       //                         codeText = utils.codeAtbash(orshift.getText().toString());
       //                     }else if(codeText.equals("")) {
       //                         Toast toast = Toast.makeText(getApplicationContext(), "Пустая строка, расшифрока невозможна", Toast.LENGTH_SHORT);
       //                         toast.show();
       //                     }else {
       //                         utils.decodeAtbash(codeText);
       //                     }
//
       //                     return true;
       //                 default:
       //                     break;
       //             }
       //         }
       //         return false;
       //     }
       // });

    }
}

