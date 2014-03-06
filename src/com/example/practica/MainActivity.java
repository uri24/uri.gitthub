package com.example.practica;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends Activity  {


	Button  btsaludar;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
		
		  btsaludar = (Button) findViewById(R.id.btcomand);
	        btsaludar.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					
				
					
					Intent i = new Intent(MainActivity.this,SeconActiviti.class);
					startActivity(i);
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	



}
