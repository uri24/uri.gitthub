package com.example.practica;





import com.example.practica.data.Primer;
import com.example.practica.data.PrimersConversor;
import com.example.practica.data.PrimersSQLiteHelper;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

public class SeconActiviti extends Activity {
	Button  btaceptar;
	private PrimersSQLiteHelper sqlite;
	private PrimersConversor primersConv;
	public final static String PRIMER ="PRIMER";
	public final static String SEGON ="SEGON";
	public final static String POSTRES ="POSTRES";
	public final static String BEGUDA="BEGUDA";
	private Cursor primers;
	
	
	String primer, segon, postres, beguda;
	Spinner sp1;
	PrimerAdapter adapter1;
	Spinner sp2;
	ArrayAdapter<CharSequence> adapter2;
	Spinner sp3;
	ArrayAdapter<CharSequence> adapter3;		 
	Spinner sp4;
	ArrayAdapter<CharSequence> adapter4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secon_activiti);
		
		sqlite = new PrimersSQLiteHelper(this, "PrimersDB.db", null, 1);
		SQLiteDatabase database = sqlite.getWritableDatabase();
		
		
	
		

		primersConv = new PrimersConversor(sqlite);
		//primersConv.save(new Primer("Amanida"));
		sp1 = ((Spinner)findViewById(R.id.spinner1));

        // Si s'ha obert correctament la BD
		if(database != null) {
			// actualitzar la llista
			refreshData();
	    	// Tancar la base de dades
			//database.close();
		} 
		
	//	adapter1 = ArrayAdapter.createFromResource(this, R.array.primers, android.R.layout.simple_spinner_item);
	//	adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//sp1 = (Spinner) findViewById(R.id.spinner1);
		//adapter1 = new SimpleCursorAdapter(this, android.R.layout.simple_spinner_item, primers, new String[]{"nom"}, new int[]{android.R.id.text1},0);
		//sp1.setAdapter(adapter1);
		
		

		
		adapter2 = ArrayAdapter.createFromResource(this, R.array.segons, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp2 = (Spinner) findViewById(R.id.spinner2);
		sp2.setAdapter(adapter2);

		adapter3 = ArrayAdapter.createFromResource(this, R.array.postes, android.R.layout.simple_spinner_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp3 = (Spinner) findViewById(R.id.spinner3);
		sp3.setAdapter(adapter3);
		
		adapter4 = ArrayAdapter.createFromResource(this, R.array.beguda, android.R.layout.simple_spinner_item);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp4 = (Spinner) findViewById(R.id.spinner4);
		sp4.setAdapter(adapter4);
		

		  btaceptar = (Button) findViewById(R.id.btcomand);
	        btaceptar.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					
					primer= (String)sp1.getSelectedItem();
					segon= (String)sp2.getSelectedItem();
					postres= (String)sp3.getSelectedItem();
					beguda= (String)sp4.getSelectedItem();
				
					
					Intent i = new Intent(SeconActiviti.this,TerceraActivity.class);
					i.putExtra(PRIMER, primer);
					i.putExtra(SEGON, segon);
					i.putExtra(POSTRES, postres);
					i.putExtra(BEGUDA, beguda);
					startActivity(i);
				}
			});
	}

	private void refreshData() {
		primers = primersConv.getAll();
		adapter1 = new PrimerAdapter(this, primers);  
		adapter1.notifyDataSetChanged();
       sp1.setAdapter(adapter1);                    
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.secon_activiti, menu);
		return true;
	}

}
