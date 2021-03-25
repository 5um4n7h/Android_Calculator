package com.calculator;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.Float;

public class MainActivity extends AppCompatActivity {
	Button one,two,three,four,five,six,seven,eight,nine,zero,equal,plus,minus,multiply,devide,dot,backspace,clear;
	float res1,res2;
    EditText ans;
    boolean add,subtract,mul,devides;

    Toolbar toolbar;


	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle(getString(R.string.app_name));

		//getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\">"+getString(R.string.app_name)+"</font>"));


		one = (Button) findViewById(R.id.one);
		two = (Button) findViewById(R.id.two);
		three= (Button) findViewById(R.id.three);
		four = (Button) findViewById(R.id.four);
		five = (Button) findViewById(R.id.five);
		six = (Button) findViewById(R.id.six);
		seven = (Button) findViewById(R.id.seven);
		eight = (Button) findViewById(R.id.eight);
		nine = (Button) findViewById(R.id.nine);
		zero = (Button) findViewById(R.id.zero);
		equal = (Button) findViewById(R.id.equal);
		plus = (Button) findViewById(R.id.plus);
		minus = (Button) findViewById(R.id.minus);
		multiply = (Button) findViewById(R.id.multiply);
		devide = (Button) findViewById(R.id.devide);
		equal = (Button) findViewById(R.id.equal);
		dot =  (Button)findViewById(R.id.dot);
		ans = (EditText) findViewById(R.id.ans);
		backspace = (Button) findViewById(R.id.backspace);
		clear = (Button) findViewById(R.id.errase);




		one.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText()+"1");


			}

		});

		two.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText()+"2");
			}
		});

		three.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText()+"3");
			}
		});

		four.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText()+"4");
			}
		});

		five.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText()+"5");
			}
		});

		six.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText()+"6");
			}
		});

		seven.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText()+"7");

			}
		});

		eight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText()+"8");

			}
		});

		nine.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText()+"9");

			}
		});

		zero.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText()+"0");

			}
		});

		equal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {


                    res2 =Float.parseFloat(String.valueOf(ans.getText()));
                    if(add==true){
                    	ans.setText(res1+res2+" ");
                    	add=false;
                    }
				if(subtract==true){
					ans.setText(res1-res2+"");
					subtract=false;
				}
				if(mul==true){
					ans.setText(res1*res2+"");
					mul=false;
				}
				if(devides==true){
					ans.setText(res1/res2+"");
					devides=false;
				}



			}
		});

		plus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (ans.getText() == null) {
						ans.setText("");
				}
					else {
					res1 = Float.parseFloat(ans.getText()+" ");
					add = true;
					ans.setText("");

					}

			}
		});

		minus.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (ans.getText() == null) {
					ans.setText("");
				}
				else {
					res1 = Float.parseFloat(ans.getText()+"");
					subtract = true;
					ans.setText(null);

				}

			}
		});

		devide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (ans.getText() == null) {
					ans.setText("");
				}
				else {
					res1 = Float.parseFloat(ans.getText()+"");
					devides = true;
					ans.setText(null);

				}
			}
		});

		multiply.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (ans.getText() == null) {
					ans.setText("");
				}
				else {
					res1 = Float.parseFloat(ans.getText()+"");
					mul = true;
					ans.setText(null);

				}
			}
		});

		dot.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ans.setText(ans.getText()+".");

			}
		});

		backspace.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int length = ans.getText().length();
				if(length>0)
				{
					ans.getText().delete(length-1,length);
				}

			}
		});

		clear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ans.setText("");

			}
		});


	/*	one.setOnTouchListener(new View.OnTouchListener() {
			@SuppressLint({"ClickableViewAccessibility", "ResourceAsColor"})
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				one.setBackgroundColor(R.color.green);
				return false;
			}
		});

	 */

		ans.setEnabled(false);
		ans.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				ans.setSelection(ans.getText().length());
			}
		});
	}


}