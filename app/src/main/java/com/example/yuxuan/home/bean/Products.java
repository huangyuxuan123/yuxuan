package com.example.yuxuan.home.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

import java.util.List;

public class Products {
    /**
     * code : 1000
     * msg : 处理成功
     * result : {"dimension":2,"flowNode":"04","hit":true,"isLock":0,"isPopup":0,"lockActionCode":0,"popupType":0,"userProductTypeCards":[{"actionCode":15,"actionName":"引导登陆","amount":15000,"buttonName":"立即申请","productKeywords":"360天,12期,年息最低仅35.8%","productLogoUrl":"http://hzedcom.oss-cn-shenzhen.aliyuncs.com/hyj/consumer_voucher/20181022/1042244576508551168/b4d27067-5035-41b0-82b7-0960eac045f3","productTypeCode":"P001","productTypeName":"爱分期"}]}
     */

    private int code;
    private String msg;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {

        public ResultBean(){

        }

        public ResultBean(int dimension, String flowNode, boolean hit, int isLock, int isPopup, int lockActionCode, int popupType, List<UserProductTypeCardsBean> userProductTypeCards) {
            this.dimension = dimension;
            this.flowNode = flowNode;
            this.hit = hit;
            this.isLock = isLock;
            this.isPopup = isPopup;
            this.lockActionCode = lockActionCode;
            this.popupType = popupType;
            this.userProductTypeCards = userProductTypeCards;
        }

        /**
         * dimension : 2
         * flowNode : 04
         * hit : true
         * isLock : 0
         * isPopup : 0
         * lockActionCode : 0
         * popupType : 0
         * userProductTypeCards : [{"actionCode":15,"actionName":"引导登陆","amount":15000,"buttonName":"立即申请","productKeywords":"360天,12期,年息最低仅35.8%","productLogoUrl":"http://hzedcom.oss-cn-shenzhen.aliyuncs.com/hyj/consumer_voucher/20181022/1042244576508551168/b4d27067-5035-41b0-82b7-0960eac045f3","productTypeCode":"P001","productTypeName":"爱分期"}]
         */

        private int dimension;
        private String flowNode;
        private boolean hit;
        private int isLock;
        private int isPopup;
        private int lockActionCode;
        private int popupType;
        private List<UserProductTypeCardsBean> userProductTypeCards;

        public int getDimension() {
            return dimension;
        }

        public void setDimension(int dimension) {
            this.dimension = dimension;
        }

        public String getFlowNode() {
            return flowNode;
        }

        public void setFlowNode(String flowNode) {
            this.flowNode = flowNode;
        }

        public boolean isHit() {
            return hit;
        }

        public void setHit(boolean hit) {
            this.hit = hit;
        }

        public int getIsLock() {
            return isLock;
        }

        public void setIsLock(int isLock) {
            this.isLock = isLock;
        }

        public int getIsPopup() {
            return isPopup;
        }

        public void setIsPopup(int isPopup) {
            this.isPopup = isPopup;
        }

        public int getLockActionCode() {
            return lockActionCode;
        }

        public void setLockActionCode(int lockActionCode) {
            this.lockActionCode = lockActionCode;
        }

        public int getPopupType() {
            return popupType;
        }

        public void setPopupType(int popupType) {
            this.popupType = popupType;
        }

        public List<UserProductTypeCardsBean> getUserProductTypeCards() {
            return userProductTypeCards;
        }

        public void setUserProductTypeCards(List<UserProductTypeCardsBean> userProductTypeCards) {
            this.userProductTypeCards = userProductTypeCards;
        }

        public static class UserProductTypeCardsBean extends BaseObservable {

            public UserProductTypeCardsBean(){

            }

            public UserProductTypeCardsBean(int actionCode, String actionName, int amount, String buttonName, String productKeywords, String productLogoUrl, String productTypeCode, String productTypeName) {
                this.actionCode = actionCode;
                this.actionName = actionName;
                this.amount = amount;
                this.buttonName = buttonName;
                this.productKeywords = productKeywords;
                this.productLogoUrl = productLogoUrl;
                this.productTypeCode = productTypeCode;
                this.productTypeName = productTypeName;
            }

            /**
             * actionCode : 15
             * actionName : 引导登陆
             * amount : 15000
             * buttonName : 立即申请
             * productKeywords : 360天,12期,年息最低仅35.8%
             * productLogoUrl : http://hzedcom.oss-cn-shenzhen.aliyuncs.com/hyj/consumer_voucher/20181022/1042244576508551168/b4d27067-5035-41b0-82b7-0960eac045f3
             * productTypeCode : P001
             * productTypeName : 爱分期
             */

            private int actionCode;
            private String actionName;
            private int amount;
            private String buttonName;
            private String productKeywords;
            private String productLogoUrl;
            private String  productTypeCode;
            private String productTypeName;

            public int getActionCode() {
                return actionCode;
            }

            public void setActionCode(int actionCode) {
                this.actionCode = actionCode;
            }

            public String getActionName() {
                return actionName;
            }

            public void setActionName(String actionName) {
                this.actionName = actionName;
            }

            @Bindable
            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
                notifyPropertyChanged(BR.amount);
            }

            @Bindable
            public String getButtonName() {
                return buttonName;
            }

            public void setButtonName(String buttonName) {
                this.buttonName = buttonName;
                notifyPropertyChanged(BR.buttonName);
            }

            @Bindable
            public String getProductKeywords() {
                return productKeywords;
            }

            public void setProductKeywords(String productKeywords) {
                this.productKeywords = productKeywords;
                notifyPropertyChanged(BR.productKeywords);
            }

            public String getProductLogoUrl() {
                return productLogoUrl;
            }

            public void setProductLogoUrl(String productLogoUrl) {
                this.productLogoUrl = productLogoUrl;
            }

            public String getProductTypeCode() {
                return productTypeCode;
            }

            public void setProductTypeCode(String productTypeCode) {
                this.productTypeCode = productTypeCode;
            }

            @Bindable
            public String getProductTypeName() {
                return productTypeName;
            }

            public void setProductTypeName(String productTypeName) {
                this.productTypeName = productTypeName;
                notifyPropertyChanged(BR.productTypeName);
            }

        }
    }
}
