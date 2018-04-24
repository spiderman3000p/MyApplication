package com.example.rafa.myapplication;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.rafa.myapplication.Conexion.cerrarConexion;
import static com.example.rafa.myapplication.Conexion.crearConexion;
import static com.example.rafa.myapplication.Conexion.statement;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment {

    private String title;
    private int position;
    private RecyclerView rv;
   // ArrayAdapter<Favorito> adapter;
    LinearLayoutManager llm;
    private Connection connection;
    private final String USER = this.getResources().getString(R.string.db_user);
    private final String PASS = this.getResources().getString(R.string.db_password);
    private final String DB_URL = this.getResources().getString(R.string.db_url);
    private boolean success;
    private String msg = "";
    private String resultado = "";
    private SyncData data;

    public FavoritosFragment() {
        // Required empty public constructor
    }

    public static FavoritosFragment newInstance(int position,String title) {
        // Required empty public constructor
        FavoritosFragment favoritosFragment = new FavoritosFragment();
        Bundle args = new Bundle();
        args.putInt("position",position);
        args.putString("title",title);
        favoritosFragment.setArguments(args);
        return favoritosFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;

        view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        Button button = (Button) view.findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = new SyncData();
                data.execute("");
            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position",0);
        title = getArguments().getString("title","Inicio");
    }

    public void conectarBD ()
    {/*
            String urlConexionMySQL = "";
            if (bd_name != "")
                urlConexionMySQL = "jdbc:mysql://" + ip + ":" +
                        puerto + "/" + bd_name;
            else
                urlConexionMySQL = "jdbc:mysql://" + ip + ":" + puerto;
        Log.i("app","conexion: "+urlConexionMySQL);
            if (usuario != "" && contrasena != "" && ip != "" && puerto != "")
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    connectionMySQL =	DriverManager.getConnection(urlConexionMySQL,
                            usuario, contrasena);
                }
                catch (ClassNotFoundException e)
                {
                    Toast.makeText(getContext(),
                            "Exception Error 1: " + e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
                catch (SQLException e)
                {
                    Toast.makeText(getContext(),
                            "Exception Error 2: " + e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
*/
    }

    private void consultar() throws SQLException {
        try
        {
            //String sql = "select * from categoria limit 10";
            conectarBD();
            /*Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            String resultadoSQL = "";
            Integer numColumnas = 0;

            //número de columnas (campos) de la consula SQL
            numColumnas = rs.getMetaData().getColumnCount();

            String[] listaCatalogos = new String[numColumnas];
            Integer j = 0;
            //mostramos el resultado
            //mostramos el resultado
            while (rs.next())
            {
                for (int i = 1; i <= numColumnas; i++)
                {
                    if (rs.getObject(i) != null)
                    {
                        if (resultadoSQL != "")
                            if (i < numColumnas)
                                resultadoSQL = resultadoSQL + rs.getObject(i).toString() + ";";
                            else
                                resultadoSQL = resultadoSQL + rs.getObject(i).toString();
                        else
                        if (i < numColumnas)
                            resultadoSQL = rs.getObject(i).toString() + ";";
                        else
                            resultadoSQL = rs.getObject(i).toString();
                    }
                    else
                    {
                        if (resultadoSQL != "")
                            resultadoSQL = resultadoSQL + "null;";
                        else
                            resultadoSQL = "null;";
                    }
                }
                resultadoSQL = resultadoSQL + "n";
            }

            st.close();
            rs.close();
*/


        }
        catch (Exception e)
        {
            Toast.makeText(getContext(),
                    "Error: " + e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }


    }

    private class SyncData extends AsyncTask<String,String,String>{
        ProgressDialog progress;

        @Override
        protected void onPreExecute(){
            progress = ProgressDialog.show(getContext(),"Sincronizando...","Estableciendo conexion...",true);
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                    crearConexion();
                    String sql = "select * from categoria limit 10";
                    resultado = "";
                    statement = connection.createStatement();
                    ResultSet result = statement.executeQuery(sql);

                    if(result != null){
                        while(result.next()){
                            resultado += result.getString("nombre");
                        }
                        Log.i("app","resultados encontrados");
                        msg = "encontrado";
                        success = true;
                    }else{
                        msg = "no encontrado";
                        success = false;
                    }

                    cerrarConexion();
            } catch (Exception e) {

                e.printStackTrace();
                Log.e("app","Excepcion 2: "+e.getMessage());
                success = false;

            }
            return msg;
        }

        @Override
        protected void onPostExecute(String msg){
            progress.dismiss();
            Toast.makeText(getContext(),msg, Toast.LENGTH_LONG).show();

                final AlertDialog.Builder alertDialog =
                        new AlertDialog.Builder(getContext());
                alertDialog.setMessage(msg + ": " + resultado);
                alertDialog.setTitle("Resultado");
                alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                alertDialog.setCancelable(true);
                alertDialog.show();

        }
    }

}
