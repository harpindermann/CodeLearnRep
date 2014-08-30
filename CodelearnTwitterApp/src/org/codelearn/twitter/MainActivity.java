package org.codelearn.twitter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button login_Button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
		String username = prefs.getString("username", null);
		String password = prefs.getString("password", null);
		if(username!=null&&username!=""&&password!=null&&password!="")
		{
			Intent intent = new Intent(MainActivity.this,TweetListActivity.class);
			startActivity(intent);
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void loginClick(View view) {
		login_Button = (Button) findViewById(R.id.button_login);
		EditText username = (EditText) findViewById(R.id.fld_username);
		EditText password = (EditText) findViewById(R.id.fld_password);
		String uname=username.getText().toString();
		String pwd=password.getText().toString();
		SharedPreferences prefs = getSharedPreferences("codelearn_twitter", MODE_PRIVATE);
		Editor editor = prefs.edit();
		editor.putString("username", uname);
		editor.putString("password", pwd);
		editor.commit();
		Intent intent = new Intent(MainActivity.this, TweetListActivity.class);
		startActivity(intent);

	}
}
