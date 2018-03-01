package com.zastupailo.moxytry

import android.os.AsyncTask
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import java.util.concurrent.TimeUnit

/**
 * Created by ang on 27.02.18.
 */
@InjectViewState
class HelloWorldPresenter : MvpPresenter<HelloWorldView> {

    constructor(){
        val asyncTask = object : AsyncTask<Void, Int, Void>(){

            override fun onPreExecute() {
                viewState.showTimer()
            }

            override fun doInBackground(vararg params: Void?): Void? {
                for (i in 5 downTo 0){
                    publishProgress(i)
                    sleepSecond()
                }
                sleepSecond()
                return null
            }

            override fun onProgressUpdate(vararg values: Int?) {
                values[0]?.let { viewState.setTimer(it) }
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                viewState.hideTimer()
                viewState.showMessage(R.string.hello_world)
            }

            fun sleepSecond(){
                try {
                    TimeUnit.SECONDS.sleep(1)
                } catch (ignore : InterruptedException){

                }
            }
        }

        asyncTask.execute()
    }

    fun onDismissMessage(){
        viewState.hideMessage()
    }
}