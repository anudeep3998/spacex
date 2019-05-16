package com.bast.spacex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list1 = GlobalScope.async { numbers( 2 ) }

        val list2 = GlobalScope.async { numbers( 10 ) }

        runBlocking {
            val lis1 = list1.await()

            val lis2 = list2.await()

            Timber.d( "Timber Count : %d",lis1.size + lis2.size )
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
