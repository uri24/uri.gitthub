package com.example.practica;


import android.app.Activity;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.practica.data.Primer;

	

	public class PrimerAdapter extends BaseAdapter {
		private Activity context;
		private Cursor dades;

		PrimerAdapter(Activity context, Cursor dades) {
			super();
			this.context = context;
			this.dades = dades;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View element = convertView;
			Vista vista;
			
			Primer p = getItem(position);

			if (element == null) {
				LayoutInflater inflater = context.getLayoutInflater();
				element = inflater.inflate(R.layout.activity_secon_activiti, null);

				vista = new Vista();
				
				

				element.setTag(vista);
			} else {
				vista = (Vista) element.getTag();
			}

			vista.Nom.setText(p.getNom());
			

			return element;
		}

	
		public int getCount() {
			return dades.getCount();
		}

		
		public Primer getItem(int pos) {
			Primer p = new Primer();
			if (dades.moveToPosition(pos)) {
				p.setCodi(dades.getInt(0));
				p.setNom(dades.getString(1));
				
			}
			return p;
		}

	
		public long getItemId(int position) {
			return getItem(position).getCodi();
		}
	}

