package com.example.homefoods.presenter

import com.example.homefoods.Connectivity


class Presenter(private val view: Connectivity) {

    fun loadUser() {
        //once data get display in the view
        view.display()
    }
}
