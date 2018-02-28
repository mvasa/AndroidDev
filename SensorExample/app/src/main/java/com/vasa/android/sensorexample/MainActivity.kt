package com.vasa.android.sensorexample

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View

class MainActivity : AppCompatActivity() , SensorEventListener {

    private var mSensorManager : SensorManager ?= null
    private var mAccelerometer : Sensor ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i("onTouchEvent--- ", "x value: "+event!!.x.toString() + " y value: "+ event.y.toString())
        return super.onTouchEvent(event)

    }
    override fun onAccuracyChanged(sensor: Sensor?, p1: Int)
    {

    }

    override fun onSensorChanged(event: SensorEvent?)
    {

        if(event != null)
        {
            xValue.text = event.values[0].toString()
            yValue.text = event.values[1].toString()
            zValue.text = event.values[2].toString()
            Log.i("onSensorChanged2", "x value:" + event.values[0].toString() + " y value: "+ event.values[1].toString() + " z value: " + event.values[2].toString())


        }
    }


    override fun onResume() {
        super.onResume()
        mSensorManager!!.registerListener(this, mAccelerometer,SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause()
    {
        super.onPause()
        mSensorManager!!.unregisterListener(this)
    }
}

