package com.anna.sent.soft.supportablealgorithms;

import java.security.Provider;
import java.security.Security;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		StringBuilder sb = new StringBuilder();

		Provider[] providers = Security.getProviders();
		for (Provider provider : providers) {
			sb.append("provider: " + provider.getName());
			sb.append("\n");
			Set<Provider.Service> services = provider.getServices();
			for (Provider.Service service : services) {
				sb.append("  algorithm: " + service.getAlgorithm());
				sb.append("\n");
			}

			sb.append("\n");
		}

		TextView tv = (TextView) findViewById(R.id.textView);
		tv.setText(sb.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
