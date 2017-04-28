package coursera.mismapas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import coursera.mismapas.modelo.Lugar;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Lugar lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        bundle();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(lugar.getTitulo());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng barquisimeto = new LatLng(lugar.getLatitud(), lugar.getLongitud());
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons(300, 300)))
                .position(barquisimeto)
                .title(lugar.getTitulo()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(barquisimeto, 16));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    public Bitmap resizeMapIcons(int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.place);
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }

    private void bundle() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            lugar = (Lugar) extras.getSerializable(getResources().getString(R.string.LUGAR));
        }
    }
}
