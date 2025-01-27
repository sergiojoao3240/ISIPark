package com.example.isipark.controller

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import com.example.isipark.R
import com.example.isipark.model.InterfacesRetroFit.Utils
import com.example.isipark.model.RetroFit.RetroPlaceFree
import com.example.isipark.model.sector
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardGestorActivity : AppCompatActivity() {

    val listView: ListView by lazy {
        findViewById<ListView>(R.id.dashboard_gestor_list_sectors)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_gestor)


        //Options buttons
        val noti = findViewById<ImageButton>(R.id.dashboard_g_notification)
        val codeBtn = findViewById<Button>(R.id.dashboard_gestor_code_btn)
        val moreOptions = findViewById<Button>(R.id.dashboard_gestor_more_btn)

        // Vehicle buttons
        val normalBtn = findViewById<ImageButton>(R.id.normal)
        val motoBtn = findViewById<ImageButton>(R.id.moto)
        val eletricBtn = findViewById<ImageButton>(R.id.eletric)
        val rmobBtn = findViewById<ImageButton>(R.id.rmob)

/*        //Adapter
        var adapter = VehiclesArrayAdapter(this, it, values)
        listView.adapter = adapter*/


        val sp = getSharedPreferences(this@DashboardGestorActivity)
        val token = sp.getString("tokenA", null)

        println("777777777777777777777777777777777777777777777777777777777777777777777")
        println(token)

        Utils.instance.getPlaceNormal("Bearer $token")
            .enqueue(object: Callback<List<RetroPlaceFree>> {
                override fun onResponse(call: Call<List<RetroPlaceFree>>, response: Response<List<RetroPlaceFree>>){
                    println("AQUI-------------------------------------------------------")
                    println(token)
                    if(response.code() == 200) {
                        val retroFit2 = response.body()
                        var adapter = retroFit2?.let {
                            VehiclesArrayAdapter(this@DashboardGestorActivity, it)
                        }
                        println("AQUI GESTOR")


                        //var adapter = VehiclesArrayAdapter(this@DashboardActivity, R.layout.layout_sector_dash, it)
                        listView.adapter = adapter
                    }
                }
                override fun onFailure(call: Call<List<RetroPlaceFree>>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                }
            })


        // --------------------------------- Buttons information ----------------------------------------
        normalBtn.setOnClickListener {
            Utils.instance.getPlaceNormalLivre("Bearer $token")
                .enqueue(object: Callback<List<RetroPlaceFree>> {
                    override fun onResponse(call: Call<List<RetroPlaceFree>>, response: Response<List<RetroPlaceFree>>){
                        if(response.code() == 200) {
                            val retroFit2 = response.body()
                            var adapter = retroFit2?.let {
                                VehiclesArrayAdapter(this@DashboardGestorActivity, it)
                            }


                            //var adapter = VehiclesArrayAdapter(this@DashboardActivity, R.layout.layout_sector_dash, it)
                            listView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<List<RetroPlaceFree>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })


        }
        motoBtn.setOnClickListener {
            Utils.instance.getPlaceMotasLivre("Bearer $token")
                .enqueue(object: Callback<List<RetroPlaceFree>> {
                    override fun onResponse(call: Call<List<RetroPlaceFree>>, response: Response<List<RetroPlaceFree>>){
                        if(response.code() == 200) {
                            val retroFit2 = response.body()
                            var adapter = retroFit2?.let {
                                VehiclesArrayAdapter(this@DashboardGestorActivity, it)
                            }


                            //var adapter = VehiclesArrayAdapter(this@DashboardActivity, R.layout.layout_sector_dash, it)
                            listView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<List<RetroPlaceFree>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })


        }
        eletricBtn.setOnClickListener {
            Utils.instance.getPlaceElectricLivre("Bearer $token")
                .enqueue(object: Callback<List<RetroPlaceFree>> {
                    override fun onResponse(call: Call<List<RetroPlaceFree>>, response: Response<List<RetroPlaceFree>>){
                        if(response.code() == 200) {
                            val retroFit2 = response.body()
                            var adapter = retroFit2?.let {
                                VehiclesArrayAdapter(this@DashboardGestorActivity, it)
                            }


                            //var adapter = VehiclesArrayAdapter(this@DashboardActivity, R.layout.layout_sector_dash, it)
                            listView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<List<RetroPlaceFree>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })



        }
        rmobBtn.setOnClickListener {
            Utils.instance.getPlaceReduceLivre("Bearer $token")
                .enqueue(object: Callback<List<RetroPlaceFree>> {
                    override fun onResponse(call: Call<List<RetroPlaceFree>>, response: Response<List<RetroPlaceFree>>){
                        if(response.code() == 200) {
                            val retroFit2 = response.body()
                            var adapter = retroFit2?.let {
                                VehiclesArrayAdapter(this@DashboardGestorActivity, it)
                            }

                            //var adapter = VehiclesArrayAdapter(this@DashboardActivity, R.layout.layout_sector_dash, it)
                            listView.adapter = adapter
                        }
                    }
                    override fun onFailure(call: Call<List<RetroPlaceFree>>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })



        }


        // ------------------------------ Other Buttons ----------------------------------
        // Show code page
        codeBtn.setOnClickListener {
            val intent = Intent(this@DashboardGestorActivity, CodeGestorActivity::class.java)
            startActivity(intent)
        }

        // Show more options page
        moreOptions.setOnClickListener {
            val intent = Intent(this@DashboardGestorActivity, MoreOptionsActivity::class.java)
            startActivity(intent)
        }

        //Show notificationadmin page
        noti.setOnClickListener {
            val intent = Intent(this@DashboardGestorActivity, NotificationAdminActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {}

    //usar quando chamar os token
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
    }

}