package coursera.mismapas.adaptador;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import coursera.mismapas.MapsActivity;
import coursera.mismapas.R;
import coursera.mismapas.modelo.Lugar;

/**
 * Created by Jose on 28/4/2017.
 */

public class LugarAdaptador extends RecyclerView.Adapter<LugarAdaptador.LugarViewHolder> {

    private Context context;
    private ArrayList<Lugar> lugares = new ArrayList<>();

    public LugarAdaptador(Context context, ArrayList<Lugar> lugares) {
        this.context = context;
        this.lugares = lugares;
    }

    @Override
    public LugarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_lugares, parent, false);
        return new LugarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LugarViewHolder holder, final int position) {
        Lugar lugar = lugares.get(position);

        holder.lugar_titulo.setText(lugar.getTitulo());
        holder.lugar_titulo.setBackgroundColor(ContextCompat.getColor(context, lugar.getColor()));
        holder.lugar_descripcion.setText(lugar.getDescripcion());
        Picasso.with(context)
                .load(lugar.getUrl_foto())
                .error(R.drawable.no_image_placeholder)
                .into(holder.lugar_imagen);
        holder.lugar_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMapa(position);
            }
        });
    }

    private void irMapa(int position) {
        Intent intent = new Intent(context, MapsActivity.class);
        intent.putExtra(context.getResources().getString(R.string.LUGAR), lugares.get(position));
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return lugares.size();
    }

    public static class LugarViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout lugar_container;
        private TextView lugar_titulo, lugar_descripcion;
        private ImageView lugar_imagen;

        public LugarViewHolder(View itemView) {
            super(itemView);
            lugar_container = (LinearLayout) itemView.findViewById(R.id.lugar_container);
            lugar_titulo = (TextView) itemView.findViewById(R.id.lugar_titulo);
            lugar_descripcion = (TextView) itemView.findViewById(R.id.lugar_descripcion);
            lugar_imagen = (ImageView) itemView.findViewById(R.id.lugar_imagen);
        }
    }
}
