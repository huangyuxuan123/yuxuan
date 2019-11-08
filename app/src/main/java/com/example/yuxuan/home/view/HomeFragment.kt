package com.example.yuxuan.home.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.yuxuan.R
import com.example.yuxuan.base.BaseFragment
import com.example.yuxuan.databinding.HomeFragmentBinding
import com.example.yuxuan.home.adapter.HomeFragmentAdapter
import com.example.yuxuan.home.bean.ProductsBean
import com.example.yuxuan.home.interfaces.DataListener
import com.example.yuxuan.home.viewmodel.ProductsViewModel
import androidx.recyclerview.widget.LinearLayoutManager


class HomeFragment :BaseFragment(){
    var recyclerView: RecyclerView?=null
    var adapter:HomeFragmentAdapter?=null
    var homeFragmentBinding:HomeFragmentBinding?=null
    var productsViewModel:ProductsViewModel?=null


    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{
        var view:View = inflater.inflate(R.layout.home_fragment,container,false)
        recyclerView = view.findViewById(R.id.recyclerview)


        //设置DataBinding、viewModel
        homeFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.home_fragment,container,false)
        productsViewModel = ProductsViewModel(this)
        homeFragmentBinding?.viewModel = productsViewModel


        var manager:GridLayoutManager = GridLayoutManager(mContext,1)
        recyclerView?.layoutManager = manager

        //加载数据
        productsViewModel?.loadProducts(object :DataListener<ProductsBean>{
            override fun getData(data: ProductsBean) {
                adapter = HomeFragmentAdapter(mContext,data)
                recyclerView?.adapter = adapter
                //刷新数据
                adapter?.notifyDataSetChanged()
            }

        })


        //上拉回到顶部
        recyclerView?.addOnScrollListener(object :OnScrollListener(){
            //标记是否正在向最后一个滑动
            var isSlidingToLast : Boolean = false

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                //dx是横向滑动 dy是纵向滑动

                if(dy > 0){
                    isSlidingToLast = true
                }else{
                    isSlidingToLast = false
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                var manager:LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager

                //当不滚动时
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    //获取最先一个完全显示的itemPosition
                    var firstVisibleItem = manager.findFirstCompletelyVisibleItemPosition()
                    //获取最后一个完全显示的itemPosition
                    var lastVisibleItem = manager.findLastCompletelyVisibleItemPosition()
                    //item总数
                    var totalItemCount = manager.itemCount


                    //判断是否到达顶部
                    if(firstVisibleItem == 0){
                        Log.e("ttt","到顶部")
                        //下拉刷新
                    }

                    //判断是否滚动到底部
                    if(lastVisibleItem == (totalItemCount - 1) && isSlidingToLast){
                        Log.e("ttt","到底部")
                        //回到顶部
                        recyclerView.scrollToPosition(0)
                    }

               }
            }
        })

        return view
    }



}














