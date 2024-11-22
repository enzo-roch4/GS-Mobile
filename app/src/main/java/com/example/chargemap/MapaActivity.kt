package com.example.chargemap

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.textfield.TextInputLayout

class MapaActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    private lateinit var searchBar: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        mapView = findViewById(R.id.Mapa)
        searchBar = findViewById(R.id.searchBar)

//         Inicializando o MapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        // Configurando a pesquisa
        searchBar.setEndIconOnClickListener {
            val query = searchBar.editText?.text.toString()
            if (query.isNotEmpty()) {
                searchLocation(query)
            } else {
                Toast.makeText(this, "Digite um endereço para buscar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun searchLocation(query: String) {
        val geocoder = android.location.Geocoder(this)
        try {
            val addresses = geocoder.getFromLocationName(query, 1)

            if (!addresses.isNullOrEmpty()) {
                val address = addresses[0] // Acessando o primeiro endereço
                val latLng = LatLng(address.latitude, address.longitude)
                googleMap.addMarker(MarkerOptions().position(latLng).title(query))
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
            } else {
                Toast.makeText(this, "Endereço não encontrado", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Erro ao buscar o endereço", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        val initialLocation = LatLng(-23.5505, -46.6333) // Exemplo: São Paulo
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLocation, 10f))
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}
