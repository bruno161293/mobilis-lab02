package com.pemb.mobilis.lab02;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	
	private List<String> strings;
	private LayoutInflater inflater;
	//private ViewHolder holder;

	public MyAdapter (Context context, List<String> list){
		inflater = LayoutInflater.from(context);
		this.strings = list;		
	}
	
	@Override
	public int getCount() {
		return strings.size();
	}

	@Override
	public String getItem(int arg0) {
		return strings.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		return strings.get(position).hashCode();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null)
		{
			convertView = inflater.inflate(R.layout.line, null);
			viewHolder = new ViewHolder();
			viewHolder.texto = (TextView) convertView.findViewById(R.id.linhaDeTexto);
			convertView.setTag(viewHolder);
		}
		else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.texto.setText(strings.get(position));
		return convertView;
	}
	
	static class ViewHolder{
		TextView texto;
	}

}
