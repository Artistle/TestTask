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

    private lateinit var binding: ActivityMainBinding

    private lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        App.appComponent.inject(this)

        navigator = AppNavigator(this, R.id.main_container)
        navigation.navigationRouter().newRootScreen(Screen.enterRequestScreen())
    }

    override fun onResume() {
        super.onResume()
        navigation.navigationHolder().setNavigator(navigator)
    }

    override fun onPause() {
        navigation.navigationHolder().removeNavigator()
        super.onPause()
    }
}