package com.covidnews.newsapp

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.squareup.okhttp.OkHttpClient


class MainActivity : AppCompatActivity(), OnItemClicked {

    private lateinit var mAdaptor: NewsListAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()
        mAdaptor = NewsListAdaptor(this)
        recyclerView.adapter = mAdaptor

    }

    fun fetchData(){
        val url = "https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/news/get-vaccine-news"

        val client = OkHttpClient()

        val request: Request<*> = Builder()
            .url("https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/news/get-vaccine-news/0")
            .get()
            .addHeader("x-rapidapi-key", "194b92f1b9msh29351ca8c43dfe2p12b53bjsn92848eb3d3ed")
            .addHeader(
                "x-rapidapi-host",
                "vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com"
            )
            .build()

        val response: Response<*> = client.newCall(request).execute()
        )
    }

    override fun ItemClick(items: News) {
        val builder = CustomTabsIntent.Builder();
        val customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(items.url));
    }

}

private fun OkHttpClient.newCall(request: Request<*>) {

}

