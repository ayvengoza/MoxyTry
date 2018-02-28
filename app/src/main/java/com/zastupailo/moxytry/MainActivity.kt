package com.zastupailo.moxytry

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), HelloWorldView {

    @InjectPresenter
    lateinit var mHelloWorldPresenter : HelloWorldPresenter

    var mTimerTextView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTimerTextView = findViewById(R.id.tv_timer)
    }

    override fun showTimer() {
        mTimerTextView?.setVisibility(View.VISIBLE)
    }

    override fun hideTimer() {
        mTimerTextView?.setVisibility(View.GONE)
    }

    override fun setTimer(seconds: Int) {
        mTimerTextView?.setText(seconds.toString())
    }

    override fun showMessage(message: Int) {
        val messageTextView = TextView(this)
        messageTextView.setText(message)
        messageTextView.setTextSize(40f)
        messageTextView.setGravity(Gravity.CENTER_HORIZONTAL)
        val layout: ViewGroup = findViewById(R.id.activity_main)
        layout.addView(messageTextView)

    }

}
