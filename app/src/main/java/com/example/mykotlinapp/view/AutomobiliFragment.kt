package com.example.mykotlinapp.view


import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mykotlinapp.R
import com.example.mykotlinapp.contract.MainActivityContract
import com.example.mykotlinapp.contract.OnHeadlineSelectedListener
import com.example.mykotlinapp.services.AutoService
import org.json.JSONObject
import android.content.*
import android.content.Context.MODE_PRIVATE
import android.os.AsyncTask
import android.support.v7.widget.LinearLayoutManager
import android.util.Base64
import android.widget.ProgressBar
import com.example.mykotlinapp.automobili.*
import com.example.mykotlinapp.contract.Task
import java.io.IOException
import java.net.MalformedURLException
import com.google.gson.Gson
import kotlinx.android.synthetic.main.recyrcleview_automobili.*
import kotlinx.android.synthetic.main.automobili_content.*


class AutomobiliFragment : Fragment(),Task{


    private lateinit var mPresenter: MainActivityContract.SignUp_frag2
    private lateinit var activity: Activity
    private lateinit var model: MainActivityContract.Model
    private lateinit var callback: OnHeadlineSelectedListener
    private lateinit var ctx: Context
    private lateinit var s:String
    //private val  MY_PREFS_NAME: String  = "MyPrefsIgor"


    lateinit var id: String

    lateinit var naziv: String
    lateinit var ks: String
    lateinit var poreklo: String
    lateinit var marka: String
    lateinit var cena: String
    lateinit var boja: String

   lateinit var slika: String
    lateinit var broj_sedista: String


    private lateinit var broadcastReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this.getActivity()!!
        ctx = this.context!!
        //  list_view.setAdapter(null);
        val serviceIntent = Intent(getActivity(), AutoService::class.java)
        getActivity()?.startService(serviceIntent)
        registerReceiver()

    }
    override fun onTaskFinishGettingData(result: String) {
        this.s=result

    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {


        var retView = inflater.inflate(R.layout.recyrcleview_automobili, container, false)


      var adapter = RecyclerViewAdapter(context)

     AsinhroniTaskReceiver().execute(MyTaskParams(adapter,null))

        // pribavljam count od niza



  //  Toast.makeText(getActivity(),myObject.toString(),Toast.LENGTH_SHORT).show()
        //AsinhroniTaskReceiver().execute(MyTaskParams(adapter, null))
      //  Thread.sleep(myObject.toLong()*1000)
        //pribavljam objekte auto



     //   var serializedDataFromPreference: String? = prefs?.getString("myObject", null)
      //  Create a new object from the serialized data with the same state
   //     var restoredMyData:AutomobiliAdapter = AutomobiliAdapter.create(serializedDataFromPreference);



        return retView
    }

    private @Synchronized fun  registerReceiver()  {


        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                var gson = Gson()
              //  var namirniceAdapter = AutomobiliAdapter(context, R.layout.row_namirnice)
                val editor = getActivity()?.getSharedPreferences("MyPrefc", MODE_PRIVATE)?.edit()

                val otpCode = intent.getStringExtra("serviceDataAuto")
               // Log.e("My::sa seu broadcast", otpCode)
//                list_view.setAdapter(null)
            //  AsinhroniTaskReceiver().execute(MyTaskParams(namirniceAdapter, otpCode))

              //  var adapter = AutomobiliAdapter(context, R.layout.row_namirnice)

                  var count = 0
                val JO =  JSONObject(otpCode)
                var jsonArray = JO.getJSONArray("automobili");

             while (count < jsonArray.length()) {
                 val JOd = jsonArray.getJSONObject(count)
               //  Thread.sleep(200)
                 id = JOd.getString("id")
                 naziv = JOd.getString("naziv");
                 ks=JOd.getString("ks");
                 poreklo = JOd.getString("poreklo");
                 marka = JOd.getString("marka");
                 boja = JOd.getString("boja");
                 broj_sedista = JOd.getString("broj_sedista");
                 cena=JOd.getString("cena");

                slika=JOd.getString("slika");
                 var decodedBytes = Base64.decode(slika, 0);

                 var auto = Auto(id,naziv,  poreklo, ks,  marka, boja,  broj_sedista, cena,decodedBytes)
                 //Log.e("Auto iz boradcast",auto.naziv)
                // adapter.add(auto)


                var jsonauto = gson.toJson(auto)
                 // Save the serialized data into a shared preference


              editor?.putString(count.toString(), jsonauto)

               //  namirniceAdapter.add(auto);

                 count++
             }


               // Toast.makeText(getContext(),naziv,Toast.LENGTH_LONG)



            // var editor = getActivity()?.getSharedPreferences("MyPrefsIgor", MODE_PRIVATE)?.edit()
                editor?.putString("count", count.toString())

                // Serialize the object into a string


           editor?.apply()




                //  list_view.setAdapter(namirniceAdapter)
                //  callback.onArticleSelected(username,ime,prezime)

//                model.username=username
                //    val data= Utils.gsonParser()?.toJson(model)
                //    val bundle=Bundle()
                //    bundle.putString("data_key",data)
                //mPresenter.UlazUmenuActivity(activity,username,ime,prezime)


            }
        }
        getActivity()?.registerReceiver(broadcastReceiver, IntentFilter("auto_ser"))
    }


    inner class AsinhroniTaskReceiver internal constructor() : AsyncTask<MyTaskParams, Int, RecyclerViewAdapter>() {

        lateinit var id: String
        var gson = Gson()
        var prefs:SharedPreferences? = getActivity()?.getSharedPreferences("MyPrefc", MODE_PRIVATE)
        lateinit var naziv: String
        lateinit var ks: String
        lateinit var poreklo: String
        lateinit var marka: String
        lateinit var cena: String
        lateinit var boja: String
        var counter:Int = 0
      //  lateinit var slika: String
        lateinit var broj_sedista: String

        private lateinit var delegate:Task
        override fun onPreExecute() {
            super.onPreExecute()
          var progressBar=ProgressBar(getActivity())
           // progressBar.setProgress(0);
            progressBar.indeterminateDrawable
        }


        override fun doInBackground(vararg params: MyTaskParams): RecyclerViewAdapter? {

            val broj = params[0].broj


            var adapter: RecyclerViewAdapter = params[0].automobiliAdapter
            var jsonString=prefs?.getString("count","100")
            var myObject:Int = gson.fromJson(jsonString, Int::class.java)

            try {

                for (i in 0..myObject-1) {

                    var json_auto = prefs?.getString(i.toString(), "1000")
                    //
                    var jsonObject=JSONObject(json_auto)
                    // println(json_auto)
                    //  Log.e("Createe view",json_auto)

                    var auto: Auto = gson.fromJson(jsonObject.toString(), Auto::class.java)
                    adapter.add(auto)
                    Thread.sleep(500)


                }


                return adapter


            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return null

        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)


         //   counter++
        //    var gson = Gson()
          //  var editor = getActivity()?.getSharedPreferences("MyPrefsIgor", MODE_PRIVATE)?.edit()

        //   var jsonString = gson.toJson(values)
            // Save the serialized data into a shared preference


       //  editor?.putString(counter.toString(), jsonString)
        //   editor?.apply()


        }


        override fun onPostExecute(result: RecyclerViewAdapter) {
            super.onPostExecute(result)
            rec_view.setAdapter(result)
           rec_view.setLayoutManager(LinearLayoutManager(context))










         //   editor?.apply();

          /*  var obj=MainActivityModel()

            var complexPreferences = ComplexPreferences.getComplexPreferences(ctx, "object_prefs", 0);
    complexPreferences.putObject("object_value", obj);
    complexPreferences.commit();

*/
            //   Toast.makeText(context,result.count.toString(),Toast.LENGTH_SHORT).show()
            //list_view.setAdapter(result)
            // Thread.sleep(3000)
           // textBeju.setText("sdsd")
           // var pc =  context.
          //  pc.setText("SSSSSSSSSSSSS")
           /* activity.runOnUiThread(Runnable() {
                fun run() {
                  //  pc.setText("SDsd" + " %");
                    Toast.makeText(context?.applicationContext,result.count.toString(),Toast.LENGTH_SHORT).show()

                }
            });
             // Toast.makeText(context,result.count.toString(),Toast.LENGTH_SHORT).show()
          var handler = Handler()
            var bus=TextView(context);
           var data = "hello, world!";
            handler.post( Runnable() {
                bus.post(Runnable()
                {
                    bus.setText(data)
                });
            });*/
            //activity.setContentView(R.layout.automobili_content)
            //context.setContentView(R.layout.main);
            /*   activity.runOnUiThread(Runnable() {
                Toast.makeText(activity, result.count.toString(), Toast.LENGTH_SHORT).show()
                if(result==null)
                    textBeju.setText("prazno")
                else
                textBeju.setText("radiii")
            })
            /*   var pc =  TextView(context);
                var t =Thread(){
                  fun run() {
                      activity.runOnUiThread( Runnable() {
                            fun run() {
                                // pc.setText("test");
                                Toast.makeText(activity,result.count.toString(),Toast.LENGTH_SHORT).show()
                                 pc.setText(result.count.toString())
                             }
                        });
                    }
                }
            t.start();
        }*/


        }*/
        }
    }
}

