package com.grebnev.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.grebnev.shoppinglist.R
import com.grebnev.shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.deleteShopItem(viewModel.shopList.value!![0])
        viewModel.changeEnabledState(viewModel.shopList.value!![1])
        viewModel.shopList.observe(this) {
            Log.d("MainViewModel", it.toString())
        }
    }
}