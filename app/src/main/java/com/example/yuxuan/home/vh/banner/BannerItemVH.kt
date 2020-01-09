package com.example.yuxuan.home.vh.banner

import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.yuxuan.R
import com.example.yuxuan.databinding.BannerItemBinding
import com.example.yuxuan.home.base.BaseVH
import com.example.yuxuan.home.glide.GlideImageLoader
import com.youth.banner.Transformer
import com.youth.banner.listener.OnBannerListener

class BannerItemVH(vg: ViewGroup) : BaseVH<BannerItemBinding, BannerItemVM>(vg, R.layout.banner_item){
    override fun setViewModel() {
        ui.vm = vm
    }

    override fun getViewModelCls(): Class<BannerItemVM> {
        return BannerItemVM::class.java
    }

    fun setData(){
        var imageUrl:List<String> = listOf("http://img.meitumeixiu.com/Images/DongWu/Images/9/113.jpg"
            ,"http://picture.ik123.com/uploads/allimg/160606/3-160606154P6.jpg"
            ,"http://i0.hdslb.com/bfs/archive/914254126985bd65213f580f7bae1c09ddba5154.jpg")
        //设置图片加载器
        ui.banner.setImageLoader(GlideImageLoader())
        //设置图片集合
        ui.banner.setImages(imageUrl)
        //设置banner动画效果
        ui.banner.setBannerAnimation(Transformer.ZoomOutSlide);
        //设置点击事件
       ui.banner.setOnBannerListener(object: OnBannerListener {
            override fun OnBannerClick(position: Int) {
//                Toast.makeText(mContext,"选中了位置="+position, Toast.LENGTH_SHORT).show()
            }
        })
        //banner设置方法全部调完毕时最后调用
        ui.banner.start()
    }

}