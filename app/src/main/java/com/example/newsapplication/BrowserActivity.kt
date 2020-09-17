package com.example.newsapplication

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapplication.fragments.NewsListFragment

// could be used instead of BrowserFragment to open url
class BrowserActivity : AppCompatActivity() {

    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        val urlToOpen = intent.getStringExtra(NewsListFragment.EXTRA_URL)

        webView = findViewById(R.id.browser)

        val webviewSettings = webView.settings
        webviewSettings.javaScriptEnabled = true // required for proper webview experience.

        webView.webViewClient = object : WebViewClient() {
            // to enable custom behaviour before loading webview.
            // in this case simply load the url that user clicks.
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url);
                return true;
            }
        }
        webView.loadUrl(urlToOpen)
    }

    // to handle the "back" button press.
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                // if its a back button and if webview has history then go back to prev page.
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    super.onKeyDown(keyCode, event)
                }
                true
            }
            else -> super.onKeyDown(keyCode, event)
        }
    }
}