package com.example.yuxuan.home

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.yuxuan.R
import com.example.yuxuan.home.adapter.HomeFragmentAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yuxuan.databinding.HomeFragmentBinding
import com.example.yuxuan.home.base.BaseFragment
import com.example.yuxuan.home.bean.ProductBean
import kotlinx.android.synthetic.main.activity_main.*

class HomeFragment : BaseFragment<HomeFragmentBinding,HomeFragmentVM>(){

    //=========================  =================================
    override fun getLayoutId() = R.layout.home_fragment

    override fun getViewModelCls(): Class<HomeFragmentVM> {
        return HomeFragmentVM::class.java
    }

    override fun setViewModel() {
        mViewDataBinding.vm = mViewModel
    }

    //=========================  =================================
    var recyclerView: RecyclerView?=null
    var adapter:HomeFragmentAdapter?=null

    //=========================  =================================

    override fun onInitView() {
        super.onInitView()
        //加载数据
        mViewModel.getProducts()

        //
        var manager:GridLayoutManager = GridLayoutManager(mContext,1)
        mViewDataBinding.recyclerview.layoutManager = manager

        //
        mViewModel.watcher = object :HomeFragmentVM.Watcher{
            override fun setData(data: List<ProductBean>?) {
                adapter = HomeFragmentAdapter(mContext,data)
                mViewDataBinding.recyclerview.adapter = adapter
                adapter?.notifyDataSetChanged()
            }
        }

        //recyclerView的滑动监听
        rvClick()
    }


    //========================= onclick =================================

    fun rvClick(){
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
    }


//    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
//        super.setUserVisibleHint(isVisibleToUser)
//        if(isVisibleToUser){
//            Log.e("eee","homeFragment")
//        }
//    }
}