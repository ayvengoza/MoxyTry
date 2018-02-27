package com.zastupailo.moxytry

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), HelloWorldView {

    @InjectPresenter
    lateinit var mHelloWorldPresenter : HelloWorldPresenter

    var mHelloView : TextView? = null

    override fun showMessage(message: Int) {
        if (mHelloView != null) {
            mHelloView!!.setText(message)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mHelloView = findViewById(R.id.hello_view)
    }
}
