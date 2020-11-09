package com.example.imagination

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import com.example.imagination.Result as Result


class MainActivity : AppCompatActivity() {

    companion object{
        const val IMAGE_URI = "image_uri"
    }



    private var option = "en"
    var result = Result(
        Ratings = listOf(),
        Title = "",
        Released = "",
        Genre = "",
        Director = "",
        Writer = "",
        Actors = "",
        Plot = "",
        Language = "",
        Country = "",
        Awards = "",
        Poster = "",
        Production = "",
        Type = "",
        Runtime = ""
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        video_rating_list.layoutManager = LinearLayoutManager(this)
        find()

        search_video.queryHint = Html.fromHtml("<font color = #c0c0c0>" + resources.getString(R.string.hint_video_title) + "</font>")

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        R.id.menu_main_kaz ->{
            translateText(result.Plot.toString(), option, "kk")
            translateGenre(result.Genre.toString(), option, "kk")
            option = "kk"

            true
        }
        R.id.menu_main_rus ->{
            translateText(result.Plot.toString(), option, "ru")
            translateGenre(result.Genre.toString(), option, "ru")
            option = "ru"

            true
        }R.id.menu_main_usa ->{
            translateText(result.Plot.toString(), option, "en")
            translateGenre(result.Genre.toString(), option, "en")
            option = "en"
            true
        }
        else -> false
    }



    private fun find(){
        val search = findViewById<SearchView>(R.id.search_video)
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                loadVideo(query)
//                translateText(query,"en", "ru")
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }
    private fun loadVideo(t: String){
        DataLoader(
            onSuccess = { response ->
                if (response != null) {
                    displayVideo(response)
                }

            },
            onError = {
                Log.d("taaag", it.message.toString())
            },
            t = t,
            apikey = "a59690d8"
        ).loadData()
    }

    @SuppressLint("ResourceType")
    private fun displayVideo(response: Result){
        if (response != null){
            setLabel()
            result = response
            Log.d("reeeeee", "$result")
            item_released.text = response.Released.toString()
            item_country.text = response.Country.toString()
            item_title.text = response.Title.toString()
            item_language.text = response.Language.toString()
            item_actors.text = response.Actors.toString()
            item_awards.text = response.Awards.toString()
            item_plot.text = response.Plot.toString()
            item_type.text = response.Type.toString()
            item_genre.text = response.Genre.toString()
            item_runtime.text = response.Runtime.toString()
            item_production.text = response.Production.toString()

            item_poster.setOnClickListener {
                val intent = Intent(this, ImaginaionVideoPlayer::class.java)
                intent.putExtra(IMAGE_URI, response.Poster)
                startActivity(intent)
            }

            if (response.Poster != null || response.Poster != ""){
                Picasso
                    .get()
                    .load(response.Poster)
                    .into(item_poster)
            }else{
                item_poster.setImageResource(R.drawable.noimage)
            }

            video_rating_list.adapter = response.Ratings?.let { MyAdapter(it) }
            val v: View = findViewById<View>(R.id.divider_line)
            val v1: View = findViewById<View>(R.id.divider1_line)
            val v2: View = findViewById<View>(R.id.divider2_line)
            val v3: View = findViewById<View>(R.id.divider3_line)
            val v4: View = findViewById<View>(R.id.divider4_line)
            val v5: View  = findViewById<View>(R.id.divider5_line)
            val v6: View  = findViewById<View>(R.id.divider6_line)
            val v7: View  = findViewById<View>(R.id.divider7_line)
            val v8: View  = findViewById<View>(R.id.divider8_line)
            val v9: View  = findViewById<View>(R.id.divider9_line)
            v.visibility = View.VISIBLE
            v1.visibility = View.VISIBLE
            v2.visibility = View.VISIBLE
            v3.visibility = View.VISIBLE
            v4.visibility = View.VISIBLE
            v5.visibility = View.VISIBLE
            v6.visibility = View.VISIBLE
            v7.visibility = View.VISIBLE
            v8.visibility = View.VISIBLE
            v9.visibility = View.VISIBLE
        }
    }

    private fun translateText(text: String, lang_from: String, lang_to: String){
        TranslaterLoader(
            onSuccess = { response ->
                if (response != null) {
                    if (response.text != null){
                        if (response.text.isNotEmpty())
                        {
                            item_plot.text = response.text.toString()
                            result.Plot = response.text.toString()
                        }
                    }

                }

            },
            onError = {
                Log.d("taaag", it.message.toString())
            },
            text = text,
            lang_from = lang_from,
            lang_to = lang_to
        ).loadData()
    }
    private fun translateGenre(text: String, lang_from: String, lang_to: String){
        TranslaterLoader(
            onSuccess = { response ->
                if (response != null) {
                    if (response.text != null){
                        if (response.text.isNotEmpty())
                        {
                            item_genre_text.text = "Жанры"
                            item_genre.text = response.text.toString()
                            result.Genre = response.text.toString()
                        }
                    }

                }

            },
            onError = {
                Log.d("taaag", it.message.toString())
            },
            text = text,
            lang_from = lang_from,
            lang_to = lang_to
        ).loadData()
    }

    private fun setLabel(){
        item_released_text.text = getString(R.string.released_string)
        item_country_text.text = getString(R.string.country_string)
        item_title_text.text = getString(R.string.title_string)
        item_language_text.text = getString(R.string.language_string)
        item_actors_text.text = getString(R.string.actors_string)
        item_awards_text.text = getString(R.string.awards_string)
        item_type_text.text = getString(R.string.type_string)
        item_genre_text.text = getString(R.string.genre_string)
        item_runtime_text.text = getString(R.string.runtime)
        item_production_text.text = getString(R.string.production_string)
    }
}