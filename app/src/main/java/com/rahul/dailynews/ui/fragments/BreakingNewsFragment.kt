package com.rahul.dailynews.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.dailynews.R
import com.rahul.dailynews.adapters.NewsAdapter
import com.rahul.dailynews.ui.NewsActivity
import com.rahul.dailynews.util.Resource
import com.rahul.dailynews.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_breaking_news.*
import retrofit2.Response


class BreakingNewsFragment : Fragment() {
lateinit var viewModel: NewsViewModel
lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_breaking_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setRecyclerView()
        //onItemClick()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer {
            response ->
            when(response){
                is Resource.Success ->{
                    hideProgressbar()
                    response.data?.let {
                        newsResponse ->  newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error ->{
                    hideProgressbar()
                    response.message?.let {
                        message ->
                        Log.d("BreakingNews","something went wrong $message")
                    }
                }

                is Resource.Loading ->{
                    showProgressbar()
                }
            }
        })
    }

    private fun hideProgressbar() {
        progressBar.visibility =  View.INVISIBLE
    }
    private fun showProgressbar() {
        progressBar.visibility =  View.VISIBLE
    }

    private fun setRecyclerView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }

  /*  private fun onItemClick(){
        newsAdapter.setOnItemClickListener {
            val bundle =Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(
                R.id.action_breakingNewsFragment_to_articleFragment,bundle
            )
        }
    }*/

}