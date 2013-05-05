package com.pemb.mobilis.lab02;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.pemb.mobilis.lab02.R;

public class MainActivity extends Activity {

	private LinkedList<String> strings;
	private ArrayAdapter<String> adapter;
	
    public final static String DETALHE = "com.pemb.mobilis.lab02.DETALHE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		strings = new LinkedList<String>();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings);
		ListView lista = (ListView) findViewById(R.id.listView1);
		lista.setAdapter(adapter);
		lista.setClickable(true);
		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(parent.getContext(),DetailActivity.class);
				
				intent.putExtra(MainActivity.DETALHE, ((TextView) view).getText().toString());
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void salvaTexto(View view){
		EditText campo = (EditText) findViewById(R.id.editText1);
		strings.addFirst(campo.getText().toString());
		adapter.notifyDataSetChanged();
		campo.setText("");
	}
	
	public void enviaTexto(View view){
		//ListView lista =  (ListView) view;
		//lista.geti
	}
	
	

}
