package com.example.yuxuan.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yuxuan.home.bean.ProductBean
import com.example.yuxuan.home.vh.advertisement.AdvertisementItemVH
import com.example.yuxuan.home.vh.banner.BannerItemVH
import com.example.yuxuan.home.vh.recommend.RecommendItemVH

/**
 * RecyclerView多种类型view 适配器
 */
class HomeFragmentAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>{
    //=========================  ================================
    //轮播图
    private val banner:Int = 0
    //广告 跑马灯
    private val advertisement:Int = 1
    //推荐
    private val recommend:Int = 2
    //当前的类型
    private var currentType:Int = banner

    //=========================  =================================
    private var mContext:Context?
    private var mlayoutInflate:LayoutInflater
    private var data:List<ProductBean>?=null

    //=========================  =================================
    constructor(Context: Context?,data:List<ProductBean>?){
        this.mContext = Context
        this.data = data
        mlayoutInflate = LayoutInflater.from(mContext)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            banner -> return BannerItemVH(parent)
            advertisement -> return AdvertisementItemVH(parent)
            else  ->return RecommendItemVH(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == banner){
            var bannerViewHolder:BannerItemVH = holder as BannerItemVH
            bannerViewHolder.setData()

        }else if(getItemViewType(position) == recommend){
            var RecommendViewHolder:RecommendItemVH = holder as RecommendItemVH
            RecommendViewHolder.setData(data)

        }else if(getItemViewType(position) == advertisement){

        }
        return
    }

    //=========================  =================================
    override fun getItemCount(): Int {
        return 3
    }

    //获取当前view类型
    override fun getItemViewType(position: Int): Int {
        when(position){
            banner -> currentType = banner
            recommend -> currentType = recommend
            advertisement -> currentType = advertisement

        }
        return currentType
    }

}