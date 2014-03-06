package com.example.practica.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
 

public class PrimersConversor {
 
	private PrimersSQLiteHelper helper;
 
	
	public PrimersConversor() {
 
	}
 

	public PrimersConversor(PrimersSQLiteHelper helper) {
		this.helper = helper;
	}
 
	
	public long save(Primer primer) {		
		long index = -1;
	
		SQLiteDatabase db = helper.getWritableDatabase();
		
		ContentValues dades = new ContentValues();
 
    	dades.put("nom", primer.getNom());
    
    	try {
    		index = db.insertOrThrow("Primers", null, dades);
    		
    		Log.i("Primers", dades.toString() + " afegit amb codi " + index);
    	}
    	catch(Exception e) {
    		
    		Log.e("Primers", e.getMessage());
    	}
    	return index;
	}	
 
	
	public Cursor getAll() {
		SQLiteDatabase db = helper.getReadableDatabase();
 
		return db.query(true, "Primers", 
						new String[]{"_id","nom"}, 
						null, null, null, null, null, null);
	}
 
	
	public boolean remove(Primer p) {		
		
		SQLiteDatabase db = helper.getWritableDatabase();
 
		return db.delete("Primers", "_id=?" ,new String[]{ p.getCodi()+"" }) > 0;
	}
	
	public boolean removeAll() {		
		
		SQLiteDatabase db = helper.getWritableDatabase();
 
		return db.delete("Primers", null, null ) > 0;
	}
}