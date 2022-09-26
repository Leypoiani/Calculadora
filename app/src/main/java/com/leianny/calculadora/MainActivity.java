package com.leianny.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button numberZero, numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberSeven,
            numberEight, numberNine, divider, multiplier, sum, subtraction, clear, equal, dot;
    private TextView textExpression, textResult;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        getSupportActionBar().hide();

        numberZero.setOnClickListener(this);
        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        divider.setOnClickListener(this);
        multiplier.setOnClickListener(this);
        sum.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        dot.setOnClickListener(this);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textExpression.setText("");
                textResult.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expression = findViewById(R.id.txt_expression);
                String string = expression.getText().toString();

                if (string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String textExpression = string.substring(var0,var1);
                    expression.setText(textExpression);
                }
                textResult.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    Expression expression = new ExpressionBuilder(textExpression.getText().toString()).build();
                    double result = expression.evaluate();

                    long longResult = (long) result;

                    if (result == (double) longResult) {
                        textResult.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        textResult.setText((CharSequence) String.valueOf(result));
                    }
                } catch (Exception e) {

                }
            }
        });
    }



    private void initComponents(){
        numberZero = findViewById(R.id.number_zero);
        numberOne = findViewById(R.id.number_one);
        numberTwo = findViewById(R.id.number_two);
        numberThree = findViewById(R.id.number_three);
        numberFour = findViewById(R.id.number_four);
        numberFive = findViewById(R.id.number_five);
        numberSix = findViewById(R.id.number_six);
        numberSeven = findViewById(R.id.number_seven);
        numberEight = findViewById(R.id.number_eight);
        numberNine = findViewById(R.id.number_nine);
        divider = findViewById(R.id.bt_divider);
        multiplier = findViewById(R.id.bt_divider);
        equal = findViewById(R.id.bt_equal);
        clear = findViewById(R.id.bt_clear);
        dot = findViewById(R.id.dot);
        sum = findViewById(R.id.bt_adiction);
        subtraction = findViewById(R.id.bt_subtraction);
        backspace = findViewById(R.id.backspace);
        textExpression = findViewById(R.id.txt_expression);
        textResult = findViewById(R.id.txt_result);
    }
    //ACRESCENTAR UMA EXPRESSÃO
    public void addAnExpression(String string, boolean clearFields){
        if (textResult.getText().equals("")){
            textExpression.setText(" ");
        }if (clearFields = true){
            textResult.setText(" ");
            textExpression.append(string);
        }else {
            textExpression.append(textResult.getText());
            textExpression.append(string);
            textResult.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case R.id.number_zero:
              addAnExpression("0", true);break;
          case R.id.number_one:
              addAnExpression("1", true);break;
          case R.id.number_two:
              addAnExpression("2", true);break;
          case R.id.number_three:
              addAnExpression("3", true);break;
          case R.id.number_four:
              addAnExpression("4", true);break;
          case R.id.number_five:
              addAnExpression("5", true);break;
          case R.id.number_six:
              addAnExpression("6", true);break;
          case R.id.number_seven:
              addAnExpression("7", true);break;
          case R.id.number_eight:
              addAnExpression("8", true);break;
          case R.id.number_nine:
              addAnExpression("9", true);break;
          case R.id.dot:
              addAnExpression(".", true);break;
          case R.id.bt_adiction:
              addAnExpression("+", false);break;
          case R.id.bt_subtraction:
              addAnExpression("-", false);break;
          case R.id.bt_divider:
              addAnExpression("/", false);break;
          case R.id.bt_multiplier:
              addAnExpression("*", false);break;

      }
    }
}