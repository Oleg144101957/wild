package com.vishnevskiypro.wild.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.vishnevskiypro.wild.R
import com.vishnevskiypro.wild.databinding.FragmentSplashBinding
import kotlinx.coroutines.*


class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)

        goToMainScreen()
        return binding.root
    }

    private fun goToMainScreen(){
        uiScope.launch {
            withContext(Dispatchers.IO){
                val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig
                val configSettings = remoteConfigSettings {
                    minimumFetchIntervalInSeconds = 20
                }
                remoteConfig.setConfigSettingsAsync(configSettings)

                uiScope.launch {
                    remoteConfig.fetchAndActivate()
                    Thread.sleep(3000)
                    var gamePass = true
                    withContext(Dispatchers.IO){
                        gamePass = remoteConfig.getBoolean("game_pass")
                        withContext(Dispatchers.Main){
                            binding.progressBar.isVisible = false
                            if (gamePass){
                                findNavController().navigate(R.id.action_splashFragment_to_menuFragment)

                            } else {
                                findNavController().navigate(R.id.action_splashFragment_to_webFragment)
                            }
                        }
                    }
                }
            }
        }
    }
}