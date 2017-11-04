package com.example.root.villupuramglug;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.root.villupuramglug.network.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;


public class SplashScreen extends Activity {

	String now_playing, earned;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		/*
		 * Showing splashscreen while making network calls to download necessary
		 * data before launching the app Will use AsyncTask to make http call
		 */
		new PrefetchData().execute();

	}

	/*
	 * Async Task to make http call
	 */
	private class PrefetchData extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// before making http calls
			Log.e("JSON", "Pre execute");

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			/*
			 * Will make http call here This call will download required data
			 * before launching the app 
			 * example: 
			 * 1. Downloading and storing SQLite 
			 * 2. Downloading images 
			 * 3. Parsing the xml / json 
			 * 4. Sending device information to server 
			 * 5. etc.,
			 */
			JsonParser jsonParser = new JsonParser();
			String json = jsonParser.getJSONFromUrl("http://api.androidhive.info/game/game_stats.json");
			String json1 = jsonParser.getJSONFromUrl("http://demos.vetbossel.in/ajson/image.json");

			Log.e("Response: ", "> " + json);

			if (json != null) {
				try {
					JSONObject jObj = new JSONObject(json)
							.getJSONObject("game_stat");
					now_playing = jObj.getString("now_playing");
					earned = jObj.getString("earned");

					Log.e("JSON", "> " + now_playing + earned);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// After completing http call
			// will close this activity and lauch main activity
			Intent i = new Intent(SplashScreen.this, MainActivity.class);
			i.putExtra("now_playing", now_playing);
			i.putExtra("earned", earned);
			startActivity(i);

			// close this activity
			finish();
		}

	}

}
