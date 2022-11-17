package com.vishnevskiypro.wild.screens


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.vishnevskiypro.wild.MyWebViewClient
import com.vishnevskiypro.wild.databinding.FragmentWebBinding

class WebFragment : Fragment() {


    private lateinit var binding: FragmentWebBinding
    private lateinit var webView: WebView
    private var urlToGo = "https://tinypng.com/"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentWebBinding.inflate(layoutInflater, container, false)
        webView = binding.webView
        webView.webViewClient = MyWebViewClient()
        webView.settings.javaScriptEnabled
        webView.settings.domStorageEnabled
        webView.settings.allowFileAccess
        webView.loadUrl(urlToGo)
        saveToRealtimeDb(urlToGo)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Toast.makeText(requireActivity(), "Back Pressed", Toast.LENGTH_LONG).show()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        return binding.root
    }

    private fun saveToRealtimeDb(urlToSave: String){
        val database = Firebase.database
        val myRef = database.getReference("message")
        myRef.setValue(urlToSave)


    }

}