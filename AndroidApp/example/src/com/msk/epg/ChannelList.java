package com.msk.epg;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;



public class ChannelList extends Activity implements OnClickListener
{
	public Button back_button,main_button;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.channel_list);
		ArrayList<String> channelList = new ArrayList<String>();
		
		final ListView l=(ListView)findViewById(R.id.listView1);
		back_button=(Button) findViewById(R.id.c_back_button);
		main_button= (Button) findViewById(R.id.c_main_button);
		
		back_button.setOnClickListener(this);
		main_button.setOnClickListener(this);
		Bundle bundle = getIntent().getExtras();
		String name=bundle.getString("msg");

		String result="";
		InputStream isr=null;
		try
		{
			HttpClient httpclient=new DefaultHttpClient();
			HttpPost httppost=new HttpPost("http://mobileepg.net63.net/channel.php?lang="+name);
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			isr=entity.getContent();
		}
		catch(Exception e)
		{
			Log.e("Exception in channel List 1", e.toString());
		}
    
		try
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(isr));
			StringBuilder sb= new StringBuilder();
			String line=null;
			while((line=reader.readLine())!=null)
			{
				sb.append(line+"\n");
			}
			isr.close();
			result=sb.toString();
		}
		catch(Exception e)
		{
			Log.e("Exception in channel List 2", e.toString());
		}
   
		try
		{
			String s="";
			JSONArray jArray=new JSONArray(result);
			for(int ii=0;ii<jArray.length();ii++)
			{
				JSONObject json= jArray.getJSONObject(ii);
				s=json.getString("cname");
				channelList.add(s);
			}
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, channelList);
			l.setAdapter(adapter);
		}
		catch(Exception e)
		{
			Log.e("Exception in channel List 3", e.toString());
		}
		
		l.setOnItemClickListener(new OnItemClickListener()
		{
        @Override
        public void onItemClick(AdapterView<?> parent, View view,int position, long id)
        {
            // getting values from selected ListItem
            String name = l.getItemAtPosition(position).toString();
            Intent myIntent1 = new Intent(ChannelList.this,ProgramList.class);
        	myIntent1.putExtra("msg", name);
        	myIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        	startActivity(myIntent1);
        }
		});
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if(v==back_button)
		{
			finish();
		}
		if(v==main_button)
		{
			Intent intent= new Intent(this,HomeActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	}
}