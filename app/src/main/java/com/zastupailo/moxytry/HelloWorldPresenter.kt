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
        val asyncTask = object : AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg params: Void?): Void? {
                sleepSecond()
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                viewState.showMessage(R.string.hello_world)
            }

            fun sleepSecond(){
                try {
                    TimeUnit.SECONDS.sleep(3)
                } catch (ignore : InterruptedException){

                }
            }
        }

        asyncTask.execute()
    }
}