package com.aptitudeguru.dashboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidhive.dashboard.R;

public class Resultallinone extends Activity {
	TextView t1, t2, t3, t4, t5, t6, t7, t8;
	int id = 0;
	String cat = "";
	int allid[] = new int[40];
	int yourans[] = new int[40];
	int givenans[] = new int[40];
	int current = 0;
	final Context context = this;
	DatabaseHandler db = new DatabaseHandler(this);

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		Button btn_home = (Button) findViewById(R.id.btn_home);

		
		Button btn_fav = (Button) findViewById(R.id.btn_fav);

		
		Button btn_score = (Button) findViewById(R.id.btn_score);

	
		Button btn_tutorial = (Button) findViewById(R.id.btn_tutorial);

		
		Button btn_about = (Button) findViewById(R.id.btn_about);
	Button btn_help = (Button) findViewById(R.id.btn_help);
		
		btn_help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
			Intent i = new Intent(getApplicationContext(),
					Help.class);

				startActivity(i);
			}
		});
		
		btn_home.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(),
						AndroidDashboardDesignActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
			}
		});

		
		btn_fav.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(), FavPage.class);

				startActivity(i);
			}
		});

		
		btn_score.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), scoremenu.class);
				startActivity(i);
			}
		});

	
		btn_tutorial.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
			
				Intent i = new Intent(getApplicationContext(),
						Tutorialpage.class);
				startActivity(i);
			}
		});

		
		btn_about.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				
				Intent i = new Intent(getApplicationContext(), AboutUs.class);
				startActivity(i);
			}
		});
		Bundle bundle = getIntent().getExtras();
		String id1 = bundle.getString("ComingFrom");
		id = Integer.parseInt(id1);
		String curr = bundle.getString("current");
		current = Integer.parseInt(curr);
		cat = bundle.getString("Category");
		yourans = bundle.getIntArray("yourans");
		givenans = bundle.getIntArray("givenans");
		allid = bundle.getIntArray("allid");

		final int ul = bundle.getInt("ul");

		final String ques[] = bundle.getStringArray("ques");
		final String sol1[] = bundle.getStringArray("sol1");
		final String sol2[] = bundle.getStringArray("sol2");
		final String sol3[] = bundle.getStringArray("sol3");
		final String sol4[] = bundle.getStringArray("sol4");
		Log.d("coming from", id1 + "");
		Log.d("current", current + "");

		final Button btn_next = (Button) findViewById(R.id.btn_next);
		final Button btn_prev = (Button) findViewById(R.id.btn_prev);
		final Button btn_finish = (Button) findViewById(R.id.btn_finish);
		String j = ques[current];
		String opt1 = sol1[current];
		String opt2 = sol2[current];
		String opt3 = sol3[current];
		String opt4 = sol4[current];
		String sol = givenans[current] + "";

		t1 = (TextView) findViewById(R.id.quest1);
		t2 = (TextView) findViewById(R.id.op1);
		t3 = (TextView) findViewById(R.id.op2);
		t4 = (TextView) findViewById(R.id.op3);
		t5 = (TextView) findViewById(R.id.op4);
		t6 = (TextView) findViewById(R.id.selans);
		t7 = (TextView) findViewById(R.id.corrans);
		t8 = (TextView) findViewById(R.id.timer);
		t1.setText(j);
		t2.setText("1." + opt1);
		t3.setText("2." + opt2);
		t4.setText("3." + opt3);
		t5.setText("4." + opt4);
		int p = yourans[current];
		String j1 = p + "";
		if (p == 0)
			j1 = "-";
		if (sol.equalsIgnoreCase("a"))
			sol = 1 + "";
		else if (sol.equalsIgnoreCase("b"))
			sol = 2 + "";
		else if (sol.equalsIgnoreCase("c"))
			sol = 3 + "";
		else if (sol.equalsIgnoreCase("d"))
			sol = 4 + "";
		else {
		}
		t6.setText("Selected Answer " + j1 + "");
		t7.setText("Correct Answer " + sol + "" + "\n" + "\t\t");
		t8.setText((current + 1) + "/" + (ul * 10));
		btn_prev.setEnabled(true);

		btn_next.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				if (current == ((ul * 10) - 1)) {
					btn_next.setEnabled(false);
				} else {
					btn_next.setEnabled(true);
					btn_prev.setEnabled(true);
					current = current + 1;
					id = allid[current];

					String j = ques[current];
					String opt1 = sol1[current];
					String opt2 = sol2[current];
					String opt3 = sol3[current];
					String opt4 = sol4[current];

					t1 = (TextView) findViewById(R.id.quest1);
					t2 = (TextView) findViewById(R.id.op1);
					t3 = (TextView) findViewById(R.id.op2);
					t4 = (TextView) findViewById(R.id.op3);
					t5 = (TextView) findViewById(R.id.op4);
					t6 = (TextView) findViewById(R.id.selans);
					t7 = (TextView) findViewById(R.id.corrans);
					String sol = givenans[current] + "";
					t1.setText(j);
					t2.setText("1." + opt1);
					t3.setText("2." + opt2);
					t4.setText("3." + opt3);
					t5.setText("4." + opt4);
					int p = yourans[current];
					String j1 = p + "";
					if (p == 0)
						j1 = "-";

					if (sol.equalsIgnoreCase("a"))
						sol = 1 + "";
					else if (sol.equalsIgnoreCase("b"))
						sol = 2 + "";
					else if (sol.equalsIgnoreCase("c"))
						sol = 3 + "";
					else if (sol.equalsIgnoreCase("d"))
						sol = 4 + "";
					else {
					}
					t6.setText("Selected Answer " + j1 + "");
					t7.setText("Correct Answer " + sol + "" + "\n" + "\t\t");
					t8.setText((current + 1) + "/" + (ul * 10));
				}
			}
		});

		btn_prev.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				if (current == 0) {
					btn_prev.setEnabled(false);
				} else {
					btn_next.setEnabled(true);
					btn_prev.setEnabled(true);
					current = current - 1;
					id = allid[current];

					String j = ques[current];
					String opt1 = sol1[current];
					String opt2 = sol2[current];
					String opt3 = sol3[current];
					String opt4 = sol4[current];
					String sol = givenans[current] + "";
					t1 = (TextView) findViewById(R.id.quest1);
					t2 = (TextView) findViewById(R.id.op1);
					t3 = (TextView) findViewById(R.id.op2);
					t4 = (TextView) findViewById(R.id.op3);
					t5 = (TextView) findViewById(R.id.op4);
					t6 = (TextView) findViewById(R.id.selans);
					t7 = (TextView) findViewById(R.id.corrans);

					t1.setText(j);
					t2.setText("1." + opt1);
					t3.setText("2." + opt2);
					t4.setText("3." + opt3);
					t5.setText("4." + opt4);
					int p = yourans[current];
					String j1 = p + "";
					if (p == 0)
						j1 = "-";
					t6.setText("Selected Answer " + j1 + "");

					if (sol.equalsIgnoreCase("a"))
						sol = 1 + "";
					else if (sol.equalsIgnoreCase("b"))
						sol = 2 + "";
					else if (sol.equalsIgnoreCase("c"))
						sol = 3 + "";
					else if (sol.equalsIgnoreCase("d"))
						sol = 4 + "";
					else {
					}
					t7.setText("Correct answer " + sol + "" + "\n" + "\t\t");
					t8.setText((current + 1) + "/" + (ul * 10));
				}
			}
		});

		btn_finish.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);

				TextView title = new TextView(context);
				title.setText("Aptitude App");
				title.setBackgroundColor(Color.DKGRAY);
				title.setPadding(10, 10, 10, 10);
				title.setGravity(Gravity.CENTER);
				title.setTextColor(Color.WHITE);
				title.setTextSize(20);
				alertDialogBuilder.setCustomTitle(title);

				// set dialog message
				alertDialogBuilder
						.setMessage("Click yes to exit!")
						.setCancelable(false)
						.setPositiveButton("Yes",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {

										Resultallinone.this.finish();
									}
								})
						.setNegativeButton("No",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										
										dialog.cancel();
									}
								});

				
				AlertDialog alertDialog = alertDialogBuilder.create();

				
				alertDialog.show();
			}
		});

	}

}
