package coursera.mismapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import coursera.mismapas.adaptador.LugarAdaptador;
import coursera.mismapas.modelo.Lugar;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerLugares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enlazarVistaControlador();
        recyclerInit();
    }

    private void recyclerInit() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerLugares.setLayoutManager(llm);

        LugarAdaptador adaptador = new LugarAdaptador(MainActivity.this, Lugar.listLugares());
        recyclerLugares.setAdapter(adaptador);
    }

    private void enlazarVistaControlador() {
        recyclerLugares = (RecyclerView) findViewById(R.id.recyclerLugares);
    }


}
