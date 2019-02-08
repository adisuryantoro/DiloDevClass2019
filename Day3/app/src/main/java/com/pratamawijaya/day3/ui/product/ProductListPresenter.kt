package com.pratamawijaya.day3.ui.product

import android.util.Log
import com.pratamawijaya.day3.data.entity.Product
import com.pratamawijaya.day3.data.repository.ProductRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductListPresenter(
    val view: ProductListView,
    val productRepo: ProductRepository
) {

    fun getProducts() {

        view.showLoading()
        // 2xx, 3xx, 4xx, 5xx

        productRepo.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                // ketika http response code 200
                view.hideLoading()

                if (response.isSuccessful) {
                    view.showData(response.body()!!)
                } else {
                    Log.e("error", "response not success ${response.message()}")
                }

            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                // ketika http response bukan 200
                view.hideLoading()

                Log.e("error", "error ${t.message}")
            }


        })

    }

}