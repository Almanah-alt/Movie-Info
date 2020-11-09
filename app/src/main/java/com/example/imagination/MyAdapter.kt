package com.example.imagination

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rating_item.view.*

class MyAdapter(
private val ratingList: List<Ratings> = listOf()
) : RecyclerView.Adapter<MyAdapter.HintViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HintViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rating_item, parent, false)
        return HintViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ratingList.count()
    }

    override fun onBindViewHolder(holder: HintViewHolder, position: Int) {
        holder.bindHint(ratingList[position])
    }


    inner class HintViewHolder(
        private val view: View
    ):RecyclerView.ViewHolder(view){
        fun bindHint(rating: Ratings){
            view.rating_source.text = rating.Source
            view.rating_value.text = rating.Value
        }
    }


//
//    private fun translateText(text: String, lang_from: String, lang_to: String, view: View){
//        TranslaterLoader(
//            onSuccess = { response ->
//                if (response != null) {
//                    if (response.text != null){
//                        if (response.text.isNotEmpty())
//                        {
//                            for (t in response.text) {
//                                view.video_title.text = t.toString()
//                            }
//
//                        }
//                    }
//
//                }
//
//            },
//            onError = {
//                Log.d("taaag", it.message.toString())
//            },
//            text = text,
//            lang_from = lang_from,
//            lang_to = lang_to
//        ).loadData()
//    }
}