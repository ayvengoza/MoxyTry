package com.zastupailo.moxytry

import com.arellomobile.mvp.MvpView

/**
 * Created by ang on 27.02.18.
 */
interface HelloWorldView : MvpView {
    fun showMessage(message: Int)
}