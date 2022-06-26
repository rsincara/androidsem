package com.zotreex.sample_project.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zotreex.sample_project.databinding.ProductItemBinding
import com.zotreex.sample_project.domain.data.Product

class ProductsListAdapter() :
    ListAdapter<Product, ProductsListAdapter.ViewHolder>(SampleDiffCallBack()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product: Product = currentList[position]
        holder.bind(product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Product) {
            binding.cardTitle.text = item.title
            binding.cardDesc.text = item.description
            binding.cardPrice.text = item.price.toString() + "$"
            Picasso.get().load(item.image).into(binding.cardImg)
        }
    }

}

class SampleDiffCallBack : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
        oldItem == newItem

}

