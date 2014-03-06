package com.example.practica;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TerceraActivity extends Activity {

	private ProgressDialog progressBar;
	Button  btcomanda;
	private int progressBarStatus = 0;

	private Handler progressBarbHandler = new Handler();

	private long fileSize = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tercera);
		
		String primer = getIntent().getStringExtra(SeconActiviti.PRIMER);
		String segon = getIntent().getStringExtra(SeconActiviti.SEGON);
		String postres = getIntent().getStringExtra(SeconActiviti.POSTRES);
		String beguda = getIntent().getStringExtra(SeconActiviti.BEGUDA);

		String informacio = "----------MENÚ----------\n    " + primer
				+ "\n    " + segon + "\n    " + postres + "\n    " + beguda;
		;
		TextView label = (TextView) findViewById(R.id.textView1);
		label.setText(informacio);
	}

	public void enviar(View view) {

		progressBar = new ProgressDialog(view.getContext());
		progressBar.setCancelable(true);
		progressBar.setMessage("Elaboració del menú");
		progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressBar.setProgress(0);
		progressBar.setMax(100);
		progressBar.show();
		progressBarStatus = 0;

		final Toast toast1 =
	            Toast.makeText(getApplicationContext(),
	                    "Menú llest apunt per servir", Toast.LENGTH_SHORT);
		fileSize = 0;

		new Thread(new Runnable() {

			public void run() {

				while (progressBarStatus < 100) {
					
					progressBarStatus = elaboració();
					
					try {

						Thread.sleep(1000);
						
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					progressBarbHandler.post(new Runnable() {

						public void run() {

							progressBar.setProgress(progressBarStatus);

						}

					});

				}

				if (progressBarStatus >= 100) {

					try {

						Thread.sleep(2000);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

					progressBar.dismiss();
					toast1.show();
					
				}
	

			}

		}).start();
		       
	}

	public int elaboració() {

		while (fileSize <= 1000000) {

			fileSize++;

			if (fileSize == 100000) {

				return 10;

			} else if (fileSize == 200000) {

				return 20;

			} else if (fileSize == 300000) {

				return 30;

			} else if (fileSize == 400000) {

				return 40;

			} else if (fileSize == 500000) {

				return 50;

			} else if (fileSize == 700000) {

				return 70;

			} else if (fileSize == 800000) {

				return 80;

			}

		}

		return 100;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tercera, menu);
		return true;
	}

}
