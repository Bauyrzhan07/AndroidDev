package com.example.lab51.contract

interface ContractInterface {
    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun getData(): List<Any>
    }

    interface Model {
        fun getData(id: Int): List<Any>
    }
}