package com.example.laengenumrechner;


import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {
	private final double conversionFactors[] = {1, 1000, 1852,  9460730472580.8};

	private EditText sourceField;
	private TextView destinationField;
	private Spinner sourceUnit;
	private Spinner destinationUnit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.einheiten, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		
		
		sourceUnit = (Spinner) findViewById(R.id.spinner1);
		sourceUnit.setAdapter(adapter);
		
		destinationUnit = (Spinner) findViewById(R.id.spinner2);
		destinationUnit.setAdapter(adapter);
		destinationUnit.setOnItemSelectedListener(new OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,	int arg2, long arg3) {
				convert();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
		});
		
		
		
		sourceField = (EditText) findViewById(R.id.editText1);
		destinationField = (TextView) findViewById(R.id.textView1);
		sourceField.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,	KeyEvent event) {
				boolean handled = false;
				if (actionId == EditorInfo.IME_ACTION_SEND) {
					convert();
				}
				return handled;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void convert(){
		try {
			int sourceIndex = sourceUnit.getSelectedItemPosition();
			double sourceFactor = conversionFactors[sourceIndex];
			
			int destinationIndex = destinationUnit.getSelectedItemPosition();
			double destinationFactor = conversionFactors[destinationIndex];
			
			double sourceValue = Double.valueOf(sourceField.getText().toString());
			double destinatonValue = sourceValue * sourceFactor / destinationFactor;
			destinationField.setText("" + destinatonValue);
		}
		catch(Exception e){}
	}
}
