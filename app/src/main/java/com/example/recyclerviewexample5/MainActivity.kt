package com.example.recyclerviewexample5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private  var mList = ArrayList<LanguageData>()
    private lateinit var adapter: LanguageAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView=findViewById(R.id.recyclerView)
        searchView=findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager=LinearLayoutManager(this)

        addDataToList()
        adapter= LanguageAdapter(mList)
        recyclerView.adapter=adapter

        searchView.setOnQueryTextListener(object : OnQueryTextListener,
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true

            }


        })
    }
    private fun filterList(query : String?){
        if (query!=null){
            val filteredList=ArrayList<LanguageData>()
            for (i in mList){
                if (i.title.toLowerCase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()){
                Toast.makeText(this,"No Data Found" , Toast.LENGTH_SHORT).show()
            }else{
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList(){
        mList.add(LanguageData( R.drawable.ar,"R","R, veri analizi ve grafikleri oluşturmak için kullanılan açık kaynak kodlu bir programlama dili ve çevreleyici ortamdır."))
        mList.add(LanguageData( R.drawable.cplusplus,"C++" , "C++ nesne yönelimli bir programlama dilidir. Yüksek performanslı uygulamalar geliştirmek için kullanılır. Oyun, tarayıcılar ve işletim sistemleri gibi birçok uygulama C++ ile yazılır."))
        mList.add(LanguageData( R.drawable.csharp,"C#" ," Microsoft tarafından geliştirilen C#, nesne yönelimli bir programlama dilidir ve Microsoft .NET Framework platformunda kullanılır. Web uygulamaları, oyunlar, masaüstü uygulamaları ve mobil uygulamalar geliştirmek için kullanılabilir."))
        mList.add(LanguageData( R.drawable.go,"GO ","Go, açık kaynaklı bir programlama dilidir ve Google tarafından geliştirilmiştir. Sistem programlama ve ağ programlama için tasarlanan Go, hafıza yönetimi, çoklu iş parçacığı desteği ve paralellik gibi özellikleriyle öne çıkmaktadır. Ayrıca, Go dilinde yazılan programlar hemen hemen her platformda çalışabilir ve kolayca derlenebilir. Go'nun diğer dillere göre avantajları arasında hızlı ve verimli bir şekilde çalışması, basit sözdizimi ve güçlü standart kütüphaneler bulunmaktadır."))
        mList.add(LanguageData( R.drawable.java,"Java ","Java, çoklu platform desteği sağlayan ve nesne yönelimli programlama konusunda öne çıkan bir programlama dilidir. Java, güvenli bir şekilde çalışabilen ve büyük ölçekli uygulamalar için ideal bir seçimdir."))
        mList.add(LanguageData( R.drawable.javascript,"Javascript" , "JavaScript, web sayfalarının etkileşimli hale getirilmesinde kullanılan bir programlama dilidir. JavaScript, tarayıcıda çalışır ve HTML ve CSS ile birlikte web sayfalarının işlevselliğini arttırmaya yardımcı olur. JavaScript, açık kaynak kodlu bir dildir ve web geliştirme alanında oldukça yaygın olarak kullanılmaktadır."))
        mList.add(LanguageData( R.drawable.kotlin,"Kotlin", "Kotlin, genel amaçlı bir programlama dilidir ve Java Virtual Machine (JVM) üzerinde çalışır. Kotlin, Java ile uyumlu olması nedeniyle Android uygulama geliştirme alanında sıkça kullanılmaktadır. Ayrıca Kotlin, temiz ve okunaklı bir kod yazımını teşvik eden modern bir dil olarak da öne çıkmaktadır. "))
        mList.add(LanguageData( R.drawable.php,"PHP","PHP, web sitelerinin dinamik olarak oluşturulması için kullanılan bir programlama dilidir. PHP, sunucu taraflı bir dil olduğu için, web sunucusunda çalışır ve HTML sayfaları dinamik hale getirir. PHP, açık kaynak kodlu bir dildir ve web geliştirme alanında oldukça yaygın olarak kullanılmaktadır."))
        mList.add(LanguageData( R.drawable.python,"Python","Python, genel amaçlı bir programlama dilidir ve kolay okunabilirlik, basit sözdizimi ve geniş kütüphane desteği ile öne çıkmaktadır. Python, veri analizi, makine öğrenmesi, yapay zeka ve web geliştirme alanlarında sıkça kullanılmaktadır. Ayrıca açık kaynak kodlu bir dil olduğu için, geniş bir topluluğa sahiptir ve ücretsizdir."))
        mList.add(LanguageData( R.drawable.ruby,"Ruby","Ruby, dinamik, nesne yönelimli bir programlama dilidir ve Ruby on Rails web uygulama çatısı ile birlikte sıkça kullanılır. Ruby, basit ve okunaklı bir sözdizimine sahiptir ve hızlı uygulama geliştirme için birçok hazır kütüphane sunar. Ayrıca Ruby, açık kaynak kodlu bir dil olduğu için, geniş bir topluluğa sahiptir ve ücretsizdir."))
        mList.add(LanguageData( R.drawable.swift,"Swift","Swift, Apple tarafından geliştirilen bir programlama dilidir ve iOS, macOS ve watchOS uygulama geliştirme için kullanılır. Swift, güçlü bir tip kontrolü ve hızlı performans sunar ve açık kaynak kodlu bir dildir. Swift, Apple'ın Xcode entegre geliştirme ortamı ile birlikte kullanılır ve modern uygulama geliştirme tekniklerini destekler."))
    }
}