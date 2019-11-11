package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.*
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightBinding

class SleepNightAdapter : ListAdapter<SleepNight, SleepNightAdapter.ViewHolder>(SleepNightDiffCallback()) {
    // var data = listOf<SleepNight>()
    //     set(value) {
    //         field = value
    //         notifyDataSetChanged() // will redraw the whole list, not good.
    //     }
    // override fun getItemCount() = data.size

    // Elliot: similiar as Windows owner-draw list view.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // val item = data[position]
        val item = getItem(position)
        holder.bind(item)
        // holder.textView.text = item.sleepQuality.toString()
        //
        // if (item.sleepQuality <= 1) {
        //     holder.textView.setTextColor(Color.RED)
        // } else {
        //     holder.textView.setTextColor(Color.BLACK)
        // }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    // for one item to display
    class ViewHolder private constructor(val binding: ListItemSleepNightBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SleepNight) {
            // val res = itemView.context.resources
            // binding.sleepLength.text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
            // binding.qualityString.text = convertNumericQualityToString(item.sleepQuality, res)
            // binding.qualityImage.setImageResource(when (item.sleepQuality) {
            //     0 -> R.drawable.ic_sleep_0
            //     1 -> R.drawable.ic_sleep_1
            //     2 -> R.drawable.ic_sleep_2
            //     3 -> R.drawable.ic_sleep_3
            //     4 -> R.drawable.ic_sleep_4
            //     5 -> R.drawable.ic_sleep_5
            //     else -> R.drawable.ic_sleep_active
            // })

            binding.sleep = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                // val view = layoutInflater.inflate(R.layout.list_item_sleep_night, parent, false)
                val binding = ListItemSleepNightBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {
    override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem.nightId == newItem.nightId
    }

    override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
        return oldItem == newItem
    }

}