package com.example.myapplicationmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationmvvm.model.QuoteModel

class QuoteViewModel : ViewModel() {

    // MutableLiveData to hold the current quote data. It will notify observers when the value changes.
    val quoteModel = MutableLiveData<QuoteModel>()

    // Function to fetch a random quote and update the quoteModel LiveData.
    fun randomQuote() {
        // Fetch a random quote from the QuoteProvider (not shown in this code).
        val currentQuote: QuoteModel = QuoteProvider.random()

        // Update the quoteModel LiveData with the new quote.
        quoteModel.postValue(currentQuote)
        // Using postValue to update LiveData from a background thread (if required).
        // This ensures that any registered observers will be notified on the main thread.
    }
}
