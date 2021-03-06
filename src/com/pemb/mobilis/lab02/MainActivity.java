package com.pemb.mobilis.lab02;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private LinkedList<String> strings;
	private MyAdapter adapter;
	
    public final static String DETALHE = "com.pemb.mobilis.lab02.DETALHE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		strings = new LinkedList<String>();
		adapter = new MyAdapter(this, strings);
		ListView lista = (ListView) findViewById(R.id.listView1);
		lista.setAdapter(adapter);
		lista.setClickable(true);
		lista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				Intent intent = new Intent(parent.getContext(),DetailActivity.class);
				intent.putExtra(MainActivity.DETALHE, ((TextView) view.findViewById(R.id.linhaDeTexto)).getText().toString());
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
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
	
}
