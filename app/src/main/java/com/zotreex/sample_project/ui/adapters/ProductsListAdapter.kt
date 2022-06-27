package com.zotreex.sample_project.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.ProductItemBinding
import com.zotreex.sample_project.domain.data.Product
import com.zotreex.sample_project.state.Products

class ProductsListAdapter() :
    ListAdapter<Product, ProductsListAdapter.ViewHolder>(SampleDiffCallBack()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product: Product = currentList[position]
        holder.bind(product)

        holder.itemView.setOnClickListener {
            Products.currentProduct = product
            Navigation.findNavController(it).navigate(
                    R.id.action_productListFragment_to_productCardFragment,
                    bundleOf(Pair("id", product.id))
            )
        }
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

