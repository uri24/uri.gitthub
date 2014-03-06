package com.example.practica.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class PrimersSQLiteHelper extends SQLiteOpenHelper {

	// Sentencia SQL per crear la taula de Titulars
		private final String SQL_CREATE_PRIMERS = "CREATE TABLE Primers(" +
								"	_id INTEGER PRIMARY KEY, " +
								"	nom TEXT)";
	 
		public PrimersSQLiteHelper(Context context, String nom, CursorFactory factory, int versio) {
			super(context, nom, factory, versio);
		}
	 
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			// S'executen les sentències SQL de creació de la BD	
			db.execSQL(SQL_CREATE_PRIMERS);
		}
	 
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int versioAnterior, int versioNova) {
			
			db.execSQL("DROP TABLE IF EXISTS Primers");
			db.execSQL(SQL_CREATE_PRIMERS);
		}
	
}
