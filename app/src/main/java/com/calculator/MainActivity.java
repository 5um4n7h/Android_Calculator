package com.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;

import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.lang.Float;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
	Button one, two, three, four, five, six, seven, eight, nine, zero, equal, plus, minus, multiply, devide, dot, backspace, clear;

	EditText ans;
	TextView display;

	Toolbar toolbar;
	Boolean equalFalg = false;





	public int evaluate(@NotNull String expression) {
		char[] tokens = expression.toCharArray();
		Stack<Integer> values = new Stack<>();
		Stack<Character> ops = new Stack<>();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] >= '0' &&
					tokens[i] <= '9') {
				StringBuilder sbuf = new
						StringBuilder();

				while (i < tokens.length &&
						tokens[i] >= '0' &&
						tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.
						toString()));
				i--;
			}

			else if (tokens[i] == '(')
				ops.push(tokens[i]);
			else if (tokens[i] == ')') {
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(),
							values.pop(),
							values.pop()));
				ops.pop();
			}

			else if (tokens[i] == '+' ||
					tokens[i] == '-' ||
					tokens[i] == '*' ||
					tokens[i] == '/') {
				while (!ops.empty() &&
						hasPrecedence(tokens[i],
								ops.peek()))
					values.push(applyOp(ops.pop(),
							values.pop(),
							values.pop()));

				ops.push(tokens[i]);
			}
		}

		while (!ops.empty())
			values.push(applyOp(ops.pop(),
					values.pop(),
					values.pop()));

		return values.pop();
	}

	public boolean hasPrecedence(
			char op1, char op2) {

		return (op1 != '*' && op1 != '/') ||
				(op2 != '+' && op2 != '-');
	}

	public int applyOp(char op,
	                   int b, int a) {
		switch (op) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			case '/':
				if (b == 0)
					throw new
							UnsupportedOperationException(
							"Cannot divide by zero");
				return a / b;
		}
		return 0;
	}


	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int height = displayMetrics.heightPixels;
		int width = displayMetrics.widthPixels;
		if (height < 1280 || width < 720) {
			Toast.makeText(this, "Screen Size not supporetd", Toast.LENGTH_LONG).show();
		}

		toolbar = findViewById(R.id.toolbar);
		toolbar.setTitle(getString(R.string.app_name));

		//getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\">"+getString(R.string.app_name)+"</font>"));


		one = findViewById(R.id.one);
		two = findViewById(R.id.two);
		three = findViewById(R.id.three);
		four = findViewById(R.id.four);
		five = findViewById(R.id.five);
		six = findViewById(R.id.six);
		seven = findViewById(R.id.seven);
		eight = findViewById(R.id.eight);
		nine = findViewById(R.id.nine);
		zero = findViewById(R.id.zero);
		equal = findViewById(R.id.equal);
		plus = findViewById(R.id.plus);
		minus = findViewById(R.id.minus);
		multiply = findViewById(R.id.multiply);
		devide = findViewById(R.id.devide);
		equal = findViewById(R.id.equal);
		dot = findViewById(R.id.dot);
		ans = findViewById(R.id.ans);
		backspace = findViewById(R.id.backspace);
		clear = findViewById(R.id.errase);
		display = findViewById(R.id.display);


		one.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText() + "1");


			}

		});

		two.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText() + "2");

			}
		});

		three.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText() + "3");

			}
		});

		four.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText() + "4");

			}
		});

		five.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText() + "5");

			}
		});

		six.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText() + "6");

			}
		});

		seven.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText() + "7");


			}
		});

		eight.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText() + "8");

			}
		});

		nine.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText() + "9");


			}
		});

		zero.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				ans.setText(ans.getText() + "0");


			}
		});

		equal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				display.setText(display.getText()+""+ans.getText());
				String a = null;
				try {
					String exp = display.getText().toString();
					int a1 = evaluate(exp);
					a = String.valueOf(a1);
				} catch (Exception e) {
					Log.e("Error", e.toString());
				}

				try {
					display.setText(display.getText()+"=");
					equalFalg = true;
					ans.setText(a);
				} catch (Exception e) {
					Log.e("Error", e.toString());
				}
			}
			
		});

		plus.setOnClickListener(new View.OnClickListener() {
		//	@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				if(!equalFalg)
					display.setText(display.getText()+""+ans.getText() + "+");
				else {
					display.setText(ans.getText() + "+");
					equalFalg = false;
				}
				ans.setText("");



			}
		});

		minus.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View view) {
				if(!equalFalg)
					display.setText(display.getText()+""+ans.getText() + "-");
				else {
					equalFalg = false;
					display.setText(ans.getText() + "-");
				}
				ans.setText("");
			}
		});

		devide.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View v) {
				if (!equalFalg)
					display.setText(display.getText() + "" + ans.getText() + "/");
				else{
					equalFalg = false;
					display.setText(ans.getText() + "/");
			}
				ans.setText("");
			}
		});

		multiply.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View v) {
				if(!equalFalg)
					display.setText(display.getText()+""+ans.getText() + "*");
				else {
					display.setText(ans.getText() + "*");
					equalFalg = false;
				}ans.setText("");
			}
		});

		dot.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View v) {
				ans.setText(ans.getText() + ".");

			}
		});

		backspace.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int length = ans.getText().length();
				if (length > 0) {
					ans.getText().delete(length - 1, length);
				}else{
					int length2 = display.getText().length();
					String dis = null;
					if(length2>0)
						dis = display.getText().toString().substring(0,display.length()-1);
					    display.setText(dis);
				}

			}
		});

		clear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ans.setText("");
				display.setText("");
			}
		});


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