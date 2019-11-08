package com.example.yuxuan.home.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;


public class ProductsBean {
    private ObservableField<String> productTypeName = new ObservableField<>();
    private ObservableField<String> Keyword_One = new ObservableField<>();
    private ObservableField<String> Keyword_Two = new ObservableField<>();
    private ObservableField<String> Keyword_Three = new ObservableField<>();
    private ObservableField<String> amount = new ObservableField<>();
    private ObservableField<String> buttonName = new ObservableField<>();

    public ProductsBean(){

    }

    public ProductsBean(ObservableField<String> productTypeName, ObservableField<String> keyword_One, ObservableField<String> keyword_Two, ObservableField<String> keyword_Three, ObservableField<String> amount, ObservableField<String> buttonName) {
        this.productTypeName = productTypeName;
        Keyword_One = keyword_One;
        Keyword_Two = keyword_Two;
        Keyword_Three = keyword_Three;
        this.amount = amount;
        this.buttonName = buttonName;
    }

    public ObservableField<String> getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(ObservableField<String> productTypeName) {
        this.productTypeName = productTypeName;
    }

    public ObservableField<String> getKeyword_One() {
        return Keyword_One;
    }

    public void setKeyword_One(ObservableField<String> keyword_One) {
        Keyword_One = keyword_One;
    }

    public ObservableField<String> getKeyword_Two() {
        return Keyword_Two;
    }

    public void setKeyword_Two(ObservableField<String> keyword_Two) {
        Keyword_Two = keyword_Two;
    }

    public ObservableField<String> getKeyword_Three() {
        return Keyword_Three;
    }

    public void setKeyword_Three(ObservableField<String> keyword_Three) {
        Keyword_Three = keyword_Three;
    }

    public ObservableField<String> getAmount() {
        return amount;
    }

    public void setAmount(ObservableField<String> amount) {
        this.amount = amount;
    }

    public ObservableField<String> getButtonName() {
        return buttonName;
    }

    public void setButtonName(ObservableField<String> buttonName) {
        this.buttonName = buttonName;
    }

}
