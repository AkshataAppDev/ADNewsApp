package com.example.newsapplication.fragments

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.newsapplication.R
import com.example.newsapplication.adapters.NewsAdapter
import com.example.newsapplication.databinding.FragmentNewsListBinding
import com.example.newsapplication.di.ViewModelProviderFactory
import com.example.newsapplication.listeners.NewsItemClickListener
import com.example.newsapplication.network.NewsItem
import com.example.newsapplication.viewmodels.NewsListViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

// Fragment to show recycler view news listpublic
// Use of DaggerFragment class
  class NewsListFragment : DaggerFragment() {

    private val TAG = "NewsListFragment"

    // Use of custom ViewModelFactory class as work around to inject dependency into ViewModels
    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    private lateinit var newsListViewModel : NewsListViewModel

    // TODO : Not sure if this is the right way to declare binding
    private lateinit var  binding : FragmentNewsListBinding;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsListViewModel = ViewModelProvider(this,providerFactory).get(NewsListViewModel::class.java)

        binding.viewModel = newsListViewModel

//        binding.newsRecyclerView.adapter =
//            NewsAdapter(
//                NewsItemClickListener { newsItem ->
//                    openUrl(newsItem)
//                })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNewsListBinding.inflate(inflater)

        //allows data binding to observe live data with lifecycle of this fragment
        binding.lifecycleOwner = this

//        binding.viewModel = newsListViewModel

        binding.newsRecyclerView.adapter =
            NewsAdapter(
                NewsItemClickListener { newsItem ->
                    openUrl(newsItem)
                })


        return binding.root
    }

    private fun openUrl(newsItem: NewsItem) {

        // use of safe args to pass arguments to destination fragment
        this.findNavController().navigate(
            R.id.action_newsListFragment_to_browserFragment, bundleOf(
                EXTRA_URL to newsItem.url
            )
        )

        // OR an actiivty can be started instead.

        //val urlToOpen = newsItem.url
        //val intent = Intent(context, BrowserActivity::class.java).apply {
        //    putExtra(EXTRA_URL, urlToOpen)
        //}
        //startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    companion object {
        const val EXTRA_URL = "URL_TO_OPEN"
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}