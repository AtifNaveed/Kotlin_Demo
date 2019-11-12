package com.atif.livedatanbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.atif.livedatanbinding.databinding.AvocadoActivityBinding


class AvocadoActivity : AppCompatActivity() {

    private val vm by lazy { getViewModel { AvocadoViewModel() } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<AvocadoActivityBinding>(this, R.layout.avocado_activity).apply {
            vmAvocado = vm
            lifecycleOwner = this@AvocadoActivity
            //setLifecycleOwner(this@AvocadoActivity)
        }

        addObserver()
        val item = Avocado(name = "Naveed", count=0)
        vm.copyItemToLive(item)
    }


    private fun addObserver() {
        vm.liveItem.name.observe(this, Observer {
            it?.also {
                vm.item.name = it
            }
        })
    }
}
