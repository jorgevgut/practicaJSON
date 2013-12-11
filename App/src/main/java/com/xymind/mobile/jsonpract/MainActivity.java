package com.xymind.mobile.jsonpract;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        private TextView resultView;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button btn = (Button) rootView.findViewById(R.id.btnSubmit);
            btn.setOnClickListener(this);
            resultView = (TextView) rootView.findViewById(R.id.json_result);
            return rootView;
        }

        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                //se verifica que hubo clicl en el boton
                case R.id.btnSubmit:

                    String result;
                    result = "";
                    EditText etNombre = (EditText)getActivity().findViewById(R.id.data_name);
                    EditText etEdad = (EditText)getActivity().findViewById(R.id.data_age);

                    String n;
                    int e=0;
                    n = etNombre.getText().toString();
                    e = Integer.parseInt(etEdad.getText().toString());

                    JSONObject json = new JSONObject();
                    JSONArray jsarray = new JSONArray();
                    try{
                        json.put("name",n);
                        json.put("edad",e);

                        jsarray.put("hola");
                        jsarray.put(100);
                        jsarray.put(-10);

                        json.put("array",jsarray);
                    }catch (JSONException error){}


                    resultView.setText(json.toString());
                    break;
            }

        }
    }

}
