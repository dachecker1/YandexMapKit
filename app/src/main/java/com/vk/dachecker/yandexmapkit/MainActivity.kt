package com.vk.dachecker.yandexmapkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vk.dachecker.yandexmapkit.databinding.ActivityMainBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mapView: MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("a4b07969-baac-4db9-ba3d-1a3a137375ed")
        MapKitFactory.initialize(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mapView = binding.mapView
        mapView.map.move(
            CameraPosition(Point(55.981173, 37.414042), 11.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 300f),
            null
        )
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }
}