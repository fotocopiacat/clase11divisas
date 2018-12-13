package com.example.android.clase11divisas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.system.Os.bind
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.lang.Exception
import kotlin.text.Typography.euro

class MainActivity : AppCompatActivity(),GetData.OnTaskCompleted {
    override fun OnTaskCompleted(respuesta: String) {


        if (!respuesta.equals("error"))
        {
            try {
               // var lista = ArrayList<String>()
                var json = JSONObject(respuesta)
                var jsonDataDolar = json.optJSONArray("serie")
                //var jsonDataValor = json.optJSONArray("valor")

                //for (i in 0..jsonData.length()-1)
              //  {
                var valordolar = jsonDataDolar.getJSONObject(0)
                var textoDolar = valordolar.getString("valor")
                System.out.println("fotocopia" + textoDolar)


                  // var valordolar = jsonDataValor.getJSONObject(0)

                     //System.out.println("el euro vale" + valeuro)

                //  lista.add(texto)
              //  }

                //var adaptador = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista)
                //lvListar.adapter = adaptador
            }
            catch (e:Exception)
            {
                Log.e("json error", "${e.message}, ${e.cause}")
            }
        } else
        {
            var alerta = AlertDialog.Builder(this)
            alerta.setTitle("ops, algo pasó :(")
            alerta.setMessage("ocurrió un errors")
            alerta.setNegativeButton("cancelar",{dialog, which ->  dialog.cancel()})
            alerta.show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        var tarea = GetData("",this)
        tarea.execute("https://mindicador.cl/api/dolar")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inCLP: String = findViewById<EditText>(R.id.editValor).text.toString()

        /*btnActualizar.setOnClickListener {
            var tarea = GetData("",this)
            tarea.execute("https://mindicador.cl/api/dolar")
        }*/

        btnDolar.setOnClickListener {
        }
    }
}

