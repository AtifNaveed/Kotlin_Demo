package com.atif.livedatanbinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Avocado(var name: String, val count: Int = 0)

class AvocadoViewModel: ViewModel() {
    inner class LiveItem {
        val name = MutableLiveData<String>()
    }
    var item: Avocado = Avocado(name="Atif")
    val liveItem: LiveItem = LiveItem()

    fun copyItemToLive(item: Avocado) {
        //this.item = item
        liveItem.apply {
            name.value = item.name
        }
    }
    fun save() {}
}