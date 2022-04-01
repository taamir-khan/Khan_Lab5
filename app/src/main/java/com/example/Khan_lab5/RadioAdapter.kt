package com.example.Khan_lab5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.Khan_lab5.R
import com.example.Khan_lab5.model.MyMediaPlayer
import com.example.Khan_lab5.model.RadioStation
import com.example.Khan_lab5.model.RadioStations


private var radioOn: Boolean = false

lateinit var allStations : MutableList<RadioStation>
var myMediaPlayer: MyMediaPlayer = MyMediaPlayer()

class RadioAdapter() : RecyclerView.Adapter<RadioAdapter.RadioViewHolder> () {
    var radioStations = RadioStations()
    init {
        allStations = radioStations.getStations()

    }

    class RadioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var name : TextView = itemView.findViewById(R.id.name_text)
        var uri : TextView = itemView.findViewById(R.id.uri_text)
        var radioImage: ImageView = itemView.findViewById(R.id.radioImage)

        var whichCard: Int = 0

        init {
            itemView.setOnClickListener(this)

        }

        fun bind(position: Int) {
            name.text = allStations[position].name
            uri.text = allStations[position].uri

            whichCard = position
        }

        override fun onClick(p0: View?) {
            Toast.makeText(p0?.context, "Hello: " + whichCard.toString(), Toast.LENGTH_LONG).show()
//

            var url =  allStations[whichCard]?.uri.toString()


            if (radioOn) {
                myMediaPlayer?.pause()
            }
            else {
                myMediaPlayer?.setAndPrepareRadioLink(url)
            }
            radioOn = ! radioOn


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.radio_card, parent, false)

        return RadioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return allStations.size
    }
}