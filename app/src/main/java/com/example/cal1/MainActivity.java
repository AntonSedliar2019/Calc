package com.example.cal1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btnClear,btnBack,btnDivide,btnMulti,btnMinus,btnSum,btnEquals,btnSquare,btnCloseBracket,btnOpenBracket;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDot;
    Button btnSin,btnCos,btnTan,btnDeg,btnFact,btnRoot,btnRad,btnAtan;
    TextView textView1,textView2;


    private int count = 0;
    private String text = "";
    private static final String KEY_RESULT = "key_result";
    private static final String KEY_SAVE = "key_result1";

    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClear= (Button) findViewById(R.id.btnClear);
        btnBack= (Button) findViewById(R.id.btnBack);
        btnDivide= (Button) findViewById(R.id.btnDivide);
        btnMulti= (Button) findViewById(R.id.btnMulti);
        btnMinus= (Button) findViewById(R.id.btnMinus);
        btnSum= (Button) findViewById(R.id.btnSum);
        btnEquals= (Button) findViewById(R.id.btnEquals);
        btnSquare= (Button) findViewById(R.id.btnTan);
        btnCloseBracket= (Button) findViewById(R.id.btnCloseBracket);
        btnOpenBracket= (Button) findViewById(R.id.btnOpenBracket);
        btnDot= (Button) findViewById(R.id.btnDot);
        btnSin= findViewById(R.id.btn_sin);
        btnCos= findViewById(R.id.btn_cos);
        btnTan= findViewById(R.id.btnTan);
        btnDeg= findViewById(R.id.btnDeg);
        btnRad= findViewById(R.id.btnRad);
        btnFact= findViewById(R.id.btnFact);
        btnRoot= findViewById(R.id.btnRoot);
        btnAtan= findViewById(R.id.btnAtan);
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        btn3= (Button) findViewById(R.id.btn3);
        btn4= (Button) findViewById(R.id.btn4);
        btn5= (Button) findViewById(R.id.btn5);
        btn6= (Button) findViewById(R.id.btn6);
        btn7= (Button) findViewById(R.id.btn7);
        btn8= (Button) findViewById(R.id.btn8);
        btn9= (Button) findViewById(R.id.btn9);
        btn0= (Button) findViewById(R.id.btn0);
        textView1= (TextView) findViewById(R.id.textView1);
        textView2= (TextView) findViewById(R.id.textView2);
        btnClear.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnSquare.setOnClickListener(this);
        btnCloseBracket.setOnClickListener(this);
        btnOpenBracket.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnDeg.setOnClickListener(this);
        btnFact.setOnClickListener(this);
        btnRoot.setOnClickListener(this);
        btnRad.setOnClickListener(this);
        btnAtan.setOnClickListener(this);

        if(savedInstanceState != null ) {
            textView2.setText(savedInstanceState.getString(KEY_RESULT));
            textView1.setText(savedInstanceState.getString(KEY_SAVE));
        }

}

    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, textView2.getText().toString());
        ed.commit();
       // Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
        return;
    }
    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "=");
        textView1.setText(savedText);
        //Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        String save = textView2.getText().toString() + "";
        String save1 = textView1.getText().toString() + "";
        outState.putString(KEY_RESULT, save);
        outState.putString(KEY_SAVE, save1);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnClear:
                textView2.setText("");
                count = 0;
                break;
            case R.id.btn_sin:
                textView2.setText(textView2.getText() + "SIN(");
                Toast.makeText(this, "Не забудь закрыть скобку", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cos:
                textView2.setText(textView2.getText() + "COS(");
                Toast.makeText(this, "Не забудь закрыть скобку", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnTan:
                textView2.setText(textView2.getText() + "TAN(");
                Toast.makeText(this, "Не забудь закрыть скобку", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnDeg:
                textView2.setText(textView2.getText() + "DEG(");
                Toast.makeText(this, "Не забудь закрыть скобку", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnFact:
                textView2.setText(textView2.getText() + "FACT(");
                Toast.makeText(this, "Не забудь закрыть скобку", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRoot:
                textView2.setText(textView2.getText() + "SQRT(");
                Toast.makeText(this, "Не забудь закрыть скобку", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnAtan:
                textView2.setText(textView2.getText() + "ATAN(");
                Toast.makeText(this, "Не забудь закрыть скобку", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRad:
                textView2.setText(textView2.getText() + "RAD(");
                Toast.makeText(this, "Не забудь закрыть скобку", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn0:
                textView2.setText(textView2.getText() + "0");
                break;
            case R.id.btn1:
                textView2.setText(textView2.getText() + "1");
                break;
            case R.id.btn2:
                textView2.setText(textView2.getText() + "2");
                break;
            case R.id.btn3:
                textView2.setText(textView2.getText() + "3");
                break;
            case R.id.btn4:
                textView2.setText(textView2.getText() + "4");
                break;
            case R.id.btn5:
                textView2.setText(textView2.getText() + "5");
                break;
            case R.id.btn6:
                textView2.setText(textView2.getText() + "6");
                break;
            case R.id.btn7:
                textView2.setText(textView2.getText() + "7");
                break;
            case R.id.btn8:
                textView2.setText(textView2.getText() + "8");
                break;
            case R.id.btn9:
                textView2.setText(textView2.getText() + "9");
                break;
            case R.id.btnDivide:
                textView2.setText(textView2.getText() + "/");
                saveText();
                break;
            case R.id.btnMulti:
                textView2.setText(textView2.getText() + "*");
                break;
            case R.id.btnMinus:
                textView2.setText(textView2.getText() + "-");
                break;
            case R.id.btnSum:
                textView2.setText(textView2.getText() + "+");
                break;
            case R.id.btnCloseBracket:
                textView2.setText(textView2.getText() + ")");
                break;
            case R.id.btnOpenBracket:
                textView2.setText(textView2.getText() + "(");
                break;
            case R.id.btnDot:
                textView2.setText(textView2.getText() + ".");
                break;
            case R.id.btnBack:
                text = textView2.getText().toString();
                if(text.length() > 0){
                    String newText = text.substring(0, text.length() - 1);
                    textView2.setText(newText);
                }
                textView2.setText(textView2.getText());
                break;
            case R.id.btnEquals:
                saveText();
                loadText();
                try {
                    if (!textView2.getText().toString().equals("")) {
                        Expression expression = new Expression(textView2.getText().toString());

                        BigDecimal result = expression. eval(false); // 1.333333


                            textView2.setText(result.toString());

                        }

                    }

                catch (ArithmeticException e ){

                    textView2.setText("Illigal expression");

                }
                catch (Expression.ExpressionException e ){

                    textView2.setText("Expression is not valid");

                }
                catch (NumberFormatException e ){

                    textView2.setText("Wrong format of expression");

                }
                break;
            default:
                break;
        }
    }

    }



