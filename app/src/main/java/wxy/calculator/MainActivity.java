package wxy.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.CheckedInputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button add;              //按钮 +
    private Button subtract;        //按钮 -
    private Button multiply;        //按钮 *
    private Button divid;           //按钮 ÷
    private Button equal;           //按钮 =
    private Button delete;          //按钮 ←
    private Button clean;           //按钮 C
    private Button point;           //按钮 .
    private Button square;          //按钮 X²
    private Button lp;              //按钮（
    private Button rp;              //按钮 ）
    private Button zero;            //按钮 0
    private Button one;             //按钮 1
    private Button two;             //按钮 2
    private Button three;           //按钮 3
    private Button four;            //按钮 4
    private Button five;            //按钮 5
    private Button six;             //按钮 6
    private Button seven;           //按钮 7
    private Button eight;           //按钮 8
    private Button nine;            //按钮 9
    private EditText show;          //显示器
    private String OperateSum="";  //用来记录输入和保存的数字和符号
    private char Operator;         //用来记录运算符
    private double num1=0,num2=0,sum=0; //sum1,sum2用来记录输入的数字，sum记录运算结果

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();         //对按钮和事件进行初始化
    }
    private void initView()//如上所述↑ ↑ ↑初始化
    {
        zero=(Button) findViewById(R.id.zero);
        one=(Button) findViewById(R.id.one);
        two=(Button) findViewById(R.id.two);
        three=(Button) findViewById(R.id.three);
        four=(Button) findViewById(R.id.four);
        five=(Button) findViewById(R.id.five);
        six=(Button) findViewById(R.id.six);
        seven=(Button) findViewById(R.id.seven);
        eight=(Button) findViewById(R.id.eight);
        nine=(Button) findViewById(R.id.nine);

        add=(Button) findViewById(R.id.add);
        subtract=(Button) findViewById(R.id.subtract);
        multiply=(Button) findViewById(R.id.multiply);
        divid=(Button) findViewById(R.id.divide);
        equal=(Button) findViewById(R.id.equal);
        delete=(Button) findViewById(R.id.delete);
        clean=(Button) findViewById(R.id.clean);
        point=(Button) findViewById(R.id.point);
        square=(Button) findViewById(R.id.square);
        lp=(Button) findViewById(R.id.lp);
        rp=(Button) findViewById(R.id.rp);

        show=(EditText) findViewById(R.id.show);
        show.setCursorVisible(false);    //是否显示光标，在这里我选择的不显示

        zero.setOnClickListener(this);  //为所有的按钮添加事件
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divid.setOnClickListener(this);
        equal.setOnClickListener(this);
        delete.setOnClickListener(this);
        clean.setOnClickListener(this);
        point.setOnClickListener(this);
        square.setOnClickListener(this);
        lp.setOnClickListener(this);
        rp.setOnClickListener(this);

        show.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.zero:
                OperateSum=AddSum('0');
                show.setText(OperateSum);
                break;
            case R.id.one:                      //记录输入的数字1
                OperateSum=AddSum('1');         //把数字1添加进OperateSum
                show.setText(OperateSum);       //把输入的数字显示在EditText
                break;
            case R.id.two:
                OperateSum=AddSum('2');
                show.setText(OperateSum);
                break;
            case R.id.three:
                OperateSum=AddSum('3');
                show.setText(OperateSum);
                break;
            case R.id.four:
                OperateSum=AddSum('4');
                show.setText(OperateSum);
                break;
            case R.id.five:
                OperateSum=AddSum('5');
                show.setText(OperateSum);
                break;
            case R.id.six:
                OperateSum=AddSum('6');
                show.setText(OperateSum);
                break;
            case R.id.seven:
                OperateSum=AddSum('7');
                show.setText(OperateSum);
                break;
            case R.id.eight:
                OperateSum=AddSum('8');
                show.setText(OperateSum);
                break;
            case R.id.nine:
                OperateSum=AddSum('9');
                show.setText(OperateSum);
                break;

            case R.id.add:
                OperateSum=AddSum('+');
                Operator='+';
                show.setText(OperateSum);
                break;
            case R.id.subtract:
                OperateSum=AddSum('-');
                Operator='-';
                show.setText(OperateSum);
                break;
            case R.id.multiply:
                OperateSum=AddSum('*');
                Operator='*';
                show.setText(OperateSum);
                break;
            case R.id.divide:
                OperateSum=AddSum('/');
                Operator='/';
                show.setText(OperateSum);
                break;
            case R.id.point:
                OperateSum=AddSum('.');
                Operator='.';
                show.setText(OperateSum);
                break;


            case R.id.delete:
                if (OperateSum.length()>=1)
                {
                    OperateSum=OperateSum.substring(0,OperateSum.length()-1);
                }
                show.setText(OperateSum);
                break;

            case R.id.clean:
                OperateSum="";
                num1=0;
                num2=0;
                sum=0;
                Operator=' ';
                show.setText(OperateSum);
                break;

            case R.id.equal:
                if (CheckInput(OperateSum))                 //调用checkedinput函数判断输入时候合法
                {
                    OperateSum=OperateSum+"="+String.valueOf(equals(OperateSum));
                    show.setText(OperateSum);                //显示数字运算符和结果
                    OperateSum=String.valueOf(sum);          //保存运算结果，可以再输入运算符和数字，可以连续计算
                }
                else
                {
                    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();//long或者short，选择报告error
                }
                break;
            default:
                break;
        }
    }

    public String AddSum(char c)            //添加一个方法，addsum，添加并记录输入的数字或字符
    {
        OperateSum=OperateSum+String.valueOf(c);
        return OperateSum;
    }
    public  boolean CheckInput(String OperateSum)
    {
        if(OperateSum.length()<=2)                       //至少输入一个数字+运算符+一个数字，否则不合理
        {
            return false;
        }
        if(OperateSum.indexOf(Operator, 1)==-1)          //判断时候有运算符，没有就报错
        {
            return false;
        }
        if (OperateSum.endsWith(String.valueOf(Operator)))//用运算符作为输入的结尾肯定不对啊
        {
            return false;
        }
        return true;
    }

    public double equals(String OperateSum)
    {
        int indexOfOperator=0;
        indexOfOperator=OperateSum.indexOf(Operator,1);
        if(OperateSum.length()>=3)
        {
            num1=Double.parseDouble(OperateSum.substring(0,indexOfOperator));
            num2=Double.parseDouble(OperateSum.substring(indexOfOperator+1,OperateSum.length()));
        }
        switch (Operator)
        {
            case '+':
                sum=num1+num2;
                break;
            case '-':
                sum=num1-num2;
                break;
            case '*':
                sum=num1*num2;
                break;
            case '/':
                if (num2!=0)
                {
                    sum=num1/num2;
                }
                if (num2==0)
                {
                    sum=0;
                    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }

        return sum;
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        int id= item.getItemId();
//
//        if ( id == R.id.action_settings)
//        {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
