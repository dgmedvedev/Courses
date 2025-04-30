package com.medvedev.courses.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.medvedev.courses.R
import com.medvedev.courses.databinding.CustomBottomNavBinding

class CustomBottomNavigationView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 1
) : FrameLayout(context, attributeSet, defStyleAttr) {

    private val binding = CustomBottomNavBinding.inflate(LayoutInflater.from(context), this, true)

    private var selectedIndex = 0

    private val itemsLinearLayout by lazy {
        listOf(binding.itemMain, binding.itemFavorite, binding.itemAccount)
    }

    private val itemsImageView by lazy {
        listOf(binding.ivMain, binding.ivFavorite, binding.ivAccount)
    }

    private val itemsTextView by lazy {
        listOf(binding.tvMain, binding.tvFavorite, binding.tvAccount)
    }

    private var onNavItemClickListener: ((Int) -> Unit)? = null

    init {
        updateUi()
        initClickListeners()
    }

    fun setOnNavItemClickListener(listener: (Int) -> Unit) {
        onNavItemClickListener = listener
    }

    private fun initClickListeners() = itemsLinearLayout.forEachIndexed { index, item ->
        item.setOnClickListener {
            onItemClick(index)
        }
    }

    private fun onItemClick(index: Int) {
        selectedIndex = index
        updateUi()
        onNavItemClickListener?.invoke(selectedIndex)
    }

    private fun updateUi() {
        itemsLinearLayout.forEach {
            itemsImageView.forEachIndexed { index, imageView ->
                updateImageView(index, imageView)
            }
            itemsTextView.forEachIndexed { index, textView ->
                updateTextView(index, textView)
            }
        }
    }

    private fun updateImageView(index: Int, imageView: ImageView) {
        if (index == selectedIndex) {
            val drawable = imageView.drawable
            drawable?.let { drawable ->
                val wrapperDrawable = DrawableCompat.wrap(drawable).mutate()
                DrawableCompat.setTint(
                    wrapperDrawable,
                    ContextCompat.getColor(context, R.color.green)
                )
                imageView.setImageDrawable(wrapperDrawable)
            }
            imageView.setBackgroundResource(R.drawable.icon_container)
        } else {
            val drawable = imageView.drawable
            drawable?.let { drawable ->
                val wrapperDrawable = DrawableCompat.wrap(drawable).mutate()
                DrawableCompat.setTint(
                    wrapperDrawable,
                    ContextCompat.getColor(context, R.color.white)
                )
                imageView.setImageDrawable(wrapperDrawable)
            }
            imageView.setBackgroundColor(resources.getColor(R.color.dark_gray, context.theme))
        }
    }

    private fun updateTextView(index: Int, textView: TextView) {
        if (index == selectedIndex) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.green))
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.white))
        }
    }
}