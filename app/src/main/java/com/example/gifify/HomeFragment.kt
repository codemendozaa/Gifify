package com.example.gifify

import android.annotation.SuppressLint
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gifify.adapter.GifAdapter
import com.example.gifify.data.model.DataResponse
import com.example.gifify.data.network.APIService
import com.example.gifify.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


private lateinit var adapter: GifAdapter
private val gifImages = mutableListOf<DataResponse>()
class HomeFragment : Fragment(),androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private var binding:FragmentHomeBinding? = null
    private val homeViewModel:HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        binding!!.svGifs.setOnQueryTextListener(this)
        binding!!.rvGifs.setOnClickListener {
            showDialog()
        }

    }


    private fun showDialog() {

    Toast.makeText(context,"seleccionado",Toast.LENGTH_LONG).show()
    }


    private fun initRecyclerView() {
        adapter = GifAdapter(gifImages)
        binding?.rvGifs?.layoutManager = LinearLayoutManager(activity)
        binding?.rvGifs?.adapter = adapter


    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.giphy.com/v1/gifs/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @SuppressLint("NotifyDataSetChanged")
   private fun searchByName(query:String){

        CoroutineScope(Dispatchers.IO).launch {
            val url = "search?q="+query+"&api_key=ek7rK0Eh2sbmBGwOFVsFBe93Stt4xQTB"
            val call = getRetrofit().create(APIService::class.java).getGifsByName(url)
            val puppies = call.body()

            activity?.runOnUiThread {
                if(call.isSuccessful){
                    val images = puppies?.data ?: emptyList()
                    gifImages.clear()
                    gifImages.addAll(images)
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
                hideKeyboard()
            }
        }
    }

    private fun showError() {
        Toast.makeText(activity,"Ha ocurrido un Error",Toast.LENGTH_SHORT).show()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query.lowercase(Locale.getDefault()))
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding?.viewRoot?.windowToken, 0)
    }
}







