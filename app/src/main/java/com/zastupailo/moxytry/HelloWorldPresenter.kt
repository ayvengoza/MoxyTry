package com.zastupailo.moxytry

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

/**
 * Created by ang on 27.02.18.
 */
@InjectViewState
class HelloWorldPresenter : MvpPresenter<HelloWorldView> {

    constructor(){
        viewState.showMessage(R.string.hello_world)
    }
}