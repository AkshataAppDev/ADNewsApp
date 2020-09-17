package com.example.newsapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.newsapplication.R
import com.example.newsapplication.databinding.FragmentBrowserBinding

// To open Url of news item tapped by user.
class BrowserFragment : Fragment() {
    lateinit var webView: WebView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentBrowserBinding>(
            inflater,
            R.layout.fragment_browser, container, false
        )

        binding.lifecycleOwner = this

        webView = binding.browser

        // using safeargs
        val urlToOpen = arguments?.getString(NewsListFragment.EXTRA_URL)

        val webviewSettings = webView.settings
        webviewSettings.javaScriptEnabled = true //required for proper webview experience.

        webView.webViewClient = object : WebViewClient() {
            // to enable custom behaviour before loading a url in webview.
            // in this case simply load the url that user clicks.
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url);
                return true;
            }
        }
        webView.loadUrl(urlToOpen)
        return binding.root
    }
}