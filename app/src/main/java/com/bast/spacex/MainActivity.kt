package com.bast.spacex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val firstPresenter: Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = firstPresenter.hello()

        val list1 = GlobalScope.async { numbers( 2 ) }

        val list2 = GlobalScope.async { numbers( 10 ) }

        runBlocking {
            val lis1 = list1.await()

            val lis2 = list2.await()

            Timber.d( "Timber Count : (${lis1.size} + ${lis2.size})")
        }

    }

    private fun numbers( count: Int ) : List<Int> {
        val list = ArrayList<Int>()

        for ( i in 1..count ) {
            list.add(i)
        }

        return list
    }
}
