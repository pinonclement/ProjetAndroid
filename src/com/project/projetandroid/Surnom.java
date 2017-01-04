package com.project.projetandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class Surnom extends Activity implements OnClickListener {

	public void onCreate(Bundle bn) {

		super.onCreate(bn);
		setContentView(R.layout.surnomlayout);
		Button okbutton = (Button) findViewById(R.id.okbutton);
		okbutton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v0){
		switch (v0.getId()) {
		case R.id.okbutton:
			EditText edittextuser1 = (EditText) findViewById(R.id.textuser1);
			EditText edittextuser2 = (EditText) findViewById(R.id.textuser2);
			EditText edittextuser3 = (EditText) findViewById(R.id.textuser3);
			EditText edittextuser4 = (EditText) findViewById(R.id.textuser4);
			String user1 = edittextuser1.getText().toString();
			String user2 = edittextuser2.getText().toString();
			String user3 = edittextuser3.getText().toString();
			String user4 = edittextuser4.getText().toString();
			Intent intent = new Intent(this, JeuActivity.class);
			intent.putExtra("user1", user1);
			intent.putExtra("user2", user2);
			intent.putExtra("user3", user3);
			intent.putExtra("user4", user4);
			startActivity(intent);
			break;

		}
		finish();

	}
}
