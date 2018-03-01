package com.zastupailo.moxytry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), HelloWorldView {

    @InjectPresenter
    lateinit var mHelloWorldPresenter : HelloWorldPresenter

    var mTimerTextView : TextView? = null
    var mMessageView : View? = null

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
        val rootView : ViewGroup = findViewById<ViewGroup>(R.id.activity_main)
        mMessageView = LayoutInflater.from(this).inflate(R.layout.item_message, rootView, false)
        rootView.addView(mMessageView)

        mMessageView?.findViewById<TextView>(R.id.message_text_view)?.setText(message)
        mMessageView?.findViewById<TextView>(R.id.close_button)?.setOnClickListener{mHelloWorldPresenter.onDismissMessage()}
    }

    override fun hideMessage() {
        val rootView = findViewById<ViewGroup>(R.id.activity_main)
        rootView.removeView(mMessageView)
    }

}
