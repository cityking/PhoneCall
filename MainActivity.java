package com.cityking.phonecall;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity {

	EditText etNo;
	Button btnCall;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etNo = (EditText) findViewById(R.id.et_no);
		btnCall = (Button) findViewById(R.id.btn_call);
		//第一种按钮点击事件 匿名内部类
//		btnCall.setOnClickListener(new OnClickListener() {
//			public void onClick(View v) {
//				call();
//			}
//		});
		

		//第二种按钮点击时间 内部类
		btnCall.setOnClickListener(new MyListener());
		
		//第三种按钮点击时间 实现OnClickListener接口
//		btnCall.setOnClickListener(this);
			
		}
	
	private void call() {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		String number = etNo.getText().toString().trim();
		if(number.equals("")){
			Toast.makeText(MainActivity.this, "你輸入的號碼不能為空", Toast.LENGTH_SHORT).show();
			return;
		}
		intent.setData(Uri.parse("tel:"+number));
		startActivity(intent);
	}
	
	public class MyListener implements OnClickListener{
		public void onClick(View v) {
			call();
			
		}
		
	}
}

