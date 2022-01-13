package com.rahul.dailynews.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.rahul.dailynews.R
import com.rahul.dailynews.model.remote.Article
import com.rahul.dailynews.ui.NewsActivity
import com.rahul.dailynews.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*


class ArticleFragment : Fragment() {

    lateinit var viewModel: NewsViewModel
   // val args: ArticleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       viewModel = (activity as NewsActivity).viewModel
      /*  val articles = args.article

        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(articles.url)
        }*/
    }

}