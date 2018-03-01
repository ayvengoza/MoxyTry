package com.zastupailo.moxytry

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), HelloWorldView {

    @InjectPresenter
    lateinit var mHelloWorldPresenter : HelloWorldPresenter

    var mTimerTextView : TextView? = null
    var mMessageDialog : AlertDialog? = null

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
        mMessageDialog = AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setOnDismissListener(DialogInterface.OnDismissListener { mHelloWorldPresenter.onDismissMessage() })
                .show()
    }

    override fun hideMessage() {
        mMessageDialog?.dismiss()
    }

}
