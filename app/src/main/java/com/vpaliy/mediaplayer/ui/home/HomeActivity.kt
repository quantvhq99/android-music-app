package com.vpaliy.mediaplayer.ui.home

import android.os.Bundle
import butterknife.ButterKnife
import com.vpaliy.mediaplayer.FitnessSound
import com.vpaliy.mediaplayer.R
import com.vpaliy.mediaplayer.ui.base.BaseActivity
import com.vpaliy.mediaplayer.ui.base.BaseFragment
import com.vpaliy.mediaplayer.ui.home.history.HistoryFragment
import com.vpaliy.mediaplayer.ui.home.loved.LovedFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        navigation.setNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.history->load(HistoryFragment())
                R.id.loved->load(LovedFragment())
                else ->false
            }
        }
        load(HistoryFragment())
    }

    private fun load(fragment: BaseFragment):Boolean{
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame,fragment)
                .commit()
        drawer.closeDrawers()
        return true
    }

    override fun inject()=FitnessSound.app().component().inject(this)
    override fun handleEvent(event: Any){}
}