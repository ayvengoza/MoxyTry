package com.zastupailo.moxytry

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), HelloWorldView {

    @InjectPresenter
    lateinit var mHelloWorldPresenter : HelloWorldPresenter

    override fun showMessage(message: Int) {
        val messageTextView = TextView(this)
        messageTextView.setText(message)
        messageTextView.setTextSize(40f)
        messageTextView.setGravity(Gravity.CENTER_HORIZONTAL)
        val layout: ViewGroup = findViewById(R.id.activity_main)
        layout.addView(messageTextView)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
