package coursera.mismapas.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import coursera.mismapas.R;

/**
 * Created by Jose on 28/4/2017.
 */

@SuppressWarnings("serial")
public class Lugar implements Serializable {

    private String titulo;
    private String descripcion;
    private int color;
    private String url_foto;
    private double longitud;
    private double latitud;

    public Lugar(String url_foto, String titulo, String descripcion, int color, double latitud, double longitud) {
        this.url_foto = url_foto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.color = color;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public Lugar() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public static ArrayList<Lugar> listLugares() {
        ArrayList<Lugar> lugares = new ArrayList<>();
        lugares.add(new Lugar("http://cdn.noticiaaldia.com.s3.amazonaws.com/wp-content/uploads/2016/01/DIVINA-PASTORA.jpg", "Manto de María", "El Monumento Manto de María Divina Pastora es una estructura monumental dedicada a la Virgen María inaugurada el 13 de enero de 2016 en la ciudad de Barquisimeto", R.color.colorMorado, 10.07727353950388, -69.25945466441804));
        lugares.add(new Lugar("https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Catedral_Metropolitana_de_Barquisimeto_en_su_parte_interna..jpg/440px-Catedral_Metropolitana_de_Barquisimeto_en_su_parte_interna..jpg", "Catedral de Nuestra Señora del Carmen", "La Catedral de Nuestra Señora del Carmen o Catedral de Barquisimeto es un templo católico. Fue el primer proyecto de envergadura construido por Jahn Bergkamp; fue terminada en 1968", R.color.colorOscuroOscuro, 9.745029902727298, -63.17237709999995));
        lugares.add(new Lugar("http://facilguia.com/venezuela/wp-content/uploads/2017/01/el-obelisco-barquisimeto-facilguia-1.jpg", "Obelisco de Barquisimeto", "El Obelisco de Barquisimeto es un destacado monumento ubicado en la ciudad de Barquisimeto, siendo uno de los mayores íconos representativos del estado Lara, Venezuela.", R.color.colorRojo, 10.066853402819243, -69.35605120000002));
        lugares.add(new Lugar("https://upload.wikimedia.org/wikipedia/commons/2/27/Flor_de_venezuela_barquisimeto_lara_3.jpg", "Flor de Venezuela", "Llamada alternativamente Flor de Hanóver es una estructura localizada en el área conocida como Triángulo del este en la ciudad de Barquisimeto la capital del Estado Lara en el centro occidente del país sudamericano de Venezuela.", R.color.colorVerde, 10.07247530282084, -69.28980220000005));

        return lugares;
    }
}
