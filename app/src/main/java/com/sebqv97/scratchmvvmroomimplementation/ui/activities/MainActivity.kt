package com.sebqv97.scratchmvvmroomimplementation.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sebqv97.scratchmvvmroomimplementation.data.model.Beers
import com.sebqv97.scratchmvvmroomimplementation.databinding.ActivityMainBinding
import com.sebqv97.scratchmvvmroomimplementation.domain.BeersViewModel.BeersViewModel
import com.sebqv97.scratchmvvmroomimplementation.utils.checkForInternet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val beersViewModel: BeersViewModel by lazy {
        ViewModelProvider(this).get(BeersViewModel::class.java)
    }
    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        if (checkForInternet(this)) {

            // IF Connected
            //Get data from api and save it locally(done in viewModel)
            getBeersFromApi()
            Toast.makeText(this,"Data from API",Toast.LENGTH_SHORT).show()
        } else {

            //No Internet Connection
            // Get data from DB
            getBeersFromDB()
            Toast.makeText(this,"Data from DB",Toast.LENGTH_SHORT).show()
        }

        setContentView(binding.root)
    }

    private fun getBeersFromApi() {
        beersViewModel.getBeersFromApi()
        beersViewModel._beersLiveData.observe(this) { beers ->
            updateUi(beers as Beers)
        }
    }

    private fun getBeersFromDB() {
        beersViewModel.readBeers.observe(this) { database ->
            if (database.isNotEmpty()) {
                Log.d("Beers", "Data from database")
                updateUi(database[0].beerEntityModel)

            } else {
                throw Throwable("No data in the DB")
            }
        }
    }

    private fun updateUi(beers: Beers) {
        var text = ""
        for (beer in beers) {
            text += "${beer.id}  ->    ${beer.name}\n"
        }

        binding.textViewTesting.text = text
    }


}