package com.example.yuxuan.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.yuxuan.R
import com.example.yuxuan.databinding.RecommendItemBinding
import com.example.yuxuan.home.GlideImageLoader
import com.example.yuxuan.utils.OnClickHandle
import com.example.yuxuan.home.bean.ProductsBean
import com.youth.banner.Banner
import com.youth.banner.Transformer
import com.youth.banner.listener.OnBannerListener

/**
 * RecyclerView多种类型view 适配器
 */
class HomeFragmentAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>{
    //类型
    //轮播图
    private val banner:Int = 0
    //广告 跑马灯
    private val advertisement:Int = 1
    //推荐
    private val recommend:Int = 2


    //当前的类型
    private var currentType:Int = banner

    private var mContext:Context?
    private var mlayoutInflate:LayoutInflater
    private var data:ProductsBean?=null


    constructor(mContext: Context?,data:ProductsBean?){
        this.mContext = mContext
        this.data = data
        mlayoutInflate = LayoutInflater.from(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            banner -> return BannerViewHolder(parent.context,mlayoutInflate.inflate(R.layout.banner_item,null))
            advertisement -> return AdvertisementViewHolder(parent.context,mlayoutInflate.inflate(R.layout.advertisement_item,null))
            else  ->return RecommendViewHolder(DataBindingUtil.inflate(mlayoutInflate,R.layout.recommend_item,parent,false))
        }
    }


    override fun getItemCount(): Int {
        return 3
    }

    
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position) == banner){
            var bannerViewHolder:BannerViewHolder = holder as BannerViewHolder
            bannerViewHolder.setData()
        }else if(getItemViewType(position) == recommend){
            var RecommendViewHolder:RecommendViewHolder = holder as RecommendViewHolder
            //绑定数据
            RecommendViewHolder.setData(data)
        }else if(getItemViewType(position) == advertisement){
            var advertisementViewHolder:AdvertisementViewHolder = holder as AdvertisementViewHolder
        }
        return
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


    class BannerViewHolder: RecyclerView.ViewHolder {
        private var mContext:Context?=null
        private var banner: Banner?=null

        //图片地址
        var imageUrl:List<String> = listOf("http://img.meitumeixiu.com/Images/DongWu/Images/9/113.jpg"
            ,"http://picture.ik123.com/uploads/allimg/160606/3-160606154P6.jpg"
            ,"http://i0.hdslb.com/bfs/archive/914254126985bd65213f580f7bae1c09ddba5154.jpg")

        constructor(mContext:Context,view: View) : super(view) {
            this.mContext = mContext
            this.banner = view.findViewById(R.id.banner)
        }

        //放置图片
        public fun setData(){
            //设置图片加载器
            banner?.setImageLoader(GlideImageLoader())
            //设置图片集合
            banner?.setImages(imageUrl)
            //设置banner动画效果
            banner?.setBannerAnimation(Transformer.ZoomOutSlide);
            //设置点击事件
            banner?.setOnBannerListener(object:OnBannerListener{
                override fun OnBannerClick(position: Int) {
                    Toast.makeText(mContext,"选中了位置="+position,Toast.LENGTH_SHORT).show()
                }
            })
            //banner设置方法全部调完毕时最后调用
            banner?.start()
        }



    }

    class RecommendViewHolder:RecyclerView.ViewHolder{
        var RecommendItemBinding:RecommendItemBinding? = null


        constructor(RecommendItemBinding: RecommendItemBinding) : super(RecommendItemBinding.getRoot()) {
            this.RecommendItemBinding = RecommendItemBinding
            //绑定点击事件
            RecommendItemBinding.click = OnClickHandle()
        }

        //绑定数据
        public fun setData(data:ProductsBean?){
            //Log.e("eee",""+data?.amount)
            var bean:ProductsBean = ProductsBean(data?.productTypeName,data?.keyword_One,data?.keyword_Two,data?.keyword_Three,data?.amount,data?.buttonName)
            RecommendItemBinding?.products = bean

        }


    }

    class AdvertisementViewHolder: RecyclerView.ViewHolder{
        private var mContext:Context?=null
        constructor(mContext:Context,view: View) : super(view) {
            this.mContext = mContext
        }
    }


}