package com.example.lab51.presenter

import com.example.lab51.contract.ContractInterface.*
import com.example.lab51.api.Todo
import com.example.lab51.model.TodoModel

class TodoListFragmentPresenter(_view: View): Presenter {
    private var view: View = _view
    private var model: Model = TodoModel()

    init {
        view.initView()
    }

    override fun getData(): Any = model.getData()
}