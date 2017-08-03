package com.android.monkey.testtoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_show_toast).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch(i){
                            case 0:
                                showToast1();
                                i++;
                                break;
                            case 1:
                                showToast2();
                                i++;
                                break;
                            case 2:
                                showToast3();
                                i++;
                                break;
                            case 3:
                                showToast4();
                                i=0;
                                break;
                            default:
                                break;
                        }

                    }
                }
        );
    }
    private void showToast1() {
        Toast toast = Toast.makeText(this,"第一条Toast",Toast.LENGTH_LONG);
        toast.show();
    }
    private void showToast2() {
        Toast toast = Toast.makeText(this,"第二条Toast",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
    private void showToast3() {
        Toast toast = Toast.makeText(this,"第三条Toast",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.LEFT|Gravity.BOTTOM,0,0);
        LinearLayout viewGroup = (LinearLayout)toast.getView();
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200,200);
        imageView.setLayoutParams(lp);
        viewGroup.addView(imageView);
        toast.show();
    }
    private void showToast4() {
        Toast toast = Toast.makeText(this,"第四条Toast",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.LEFT|Gravity.BOTTOM,0,0);
        LayoutInflater inflater = getLayoutInflater();
        //和下面2句效果一样 因为下面两句的viewGroup也是null
        ViewGroup viewGroup = null;
        //ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ll_toast);
        //ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ll_test);
        View view = inflater.inflate(R.layout.layout_toast, viewGroup);
        toast.setView(view);
        toast.show();
    }
}
