package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test.databinding.ActivityMainBinding
import com.example.test.navigation.Navigation
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    @Inject
    lateinit var navigation: Navigation

    private val navigationHolder by lazy { navigation.navigationHolder() }
    private val navigationRouter by lazy { navigation.navigationRouter() }
    private val navigator by lazy { AppNavigator(this, R.id.main_container) }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        App.appComponent.inject(this)

        /*
         *
         * TODO в этом месте есть проблема ЖЦ,при повороте экрана, открывается стартовый фрагмент
         *
         */
        navigationRouter.newRootScreen(Screen.enterRequestScreen())
    }

    override fun onResume() {
        super.onResume()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()
        super.onPause()
    }
}