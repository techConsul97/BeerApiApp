package com.sebqv97.scratchmvvmroomimplementation.domain.BeersViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sebqv97.scratchmvvmroomimplementation.data.model.Beers
import com.sebqv97.scratchmvvmroomimplementation.data.roomdb.BeerEntity
import com.sebqv97.scratchmvvmroomimplementation.domain.beers_repository.BeersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeersViewModel @Inject constructor(
   var repository : BeersRepository
) : ViewModel() {


   //FOR API
   var _beersLiveData: MutableLiveData<Beers> = MutableLiveData(Beers())

   //FOR DB
   var readBeers: LiveData<List<BeerEntity>> = repository.localAccess.readBeersFromDb().asLiveData()



   fun getBeersFromApi(){

      CoroutineScope(Dispatchers.IO).launch {

         val response = repository.remoteAccess.getBeersFromAPI()
         Log.d("Data",response.body().toString())
         if(response.isSuccessful){
            response.body().let {data->

               //SAVE DATA TO DB
               insertApiDataIntoDb(data!!)

               //Update LiveData
               _beersLiveData.postValue(data)
            }
         }
      }
   }

   fun insertApiDataIntoDb(beers:Beers){

      val beersEntity = BeerEntity(beers)
      CoroutineScope(Dispatchers.IO).launch {
          repository.localAccess.insertBeersIntoDb(beersEntity)
      }

   }

   fun readDataFromDB(){

   }
}