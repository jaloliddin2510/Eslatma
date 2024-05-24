package com.example.eslatma.Options

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eslatma.databinding.ItemVhBinding

class Adapter(
    private val onClick: (NoteEntity) -> Unit
) : ListAdapter<NoteEntity, Adapter.ViewHolder>(diffUtil) {

    var onLongClickListener: ((NoteEntity) -> Unit)? = null

    inner class ViewHolder(
        private val bindin: ItemVhBinding
    ) : RecyclerView.ViewHolder(bindin.root) {
        fun bind(taskModel: NoteEntity) {
            with(bindin) {
                with(taskModel) {
                    tvTitle.text = title
                    tvDesc.text = desc
                    tvFormattedDate.text = formattedTime

                    root.setOnClickListener {
                        onClick(taskModel)
                    }
                    root.setOnLongClickListener {
                        onLongClickListener?.invoke(taskModel)
                        true
                    }
                }
            }
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<NoteEntity>() {
            override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemVhBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}