package com.mukesh.easydatastoremethods.calldatastore

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.Preferences
import com.mukesh.easydatastoremethods.easydatastore.EasyDataStore
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

object CallDataStore {

    private var easyDataStore: WeakReference<EasyDataStore>? = null

    /**
     * Coroutine Exception Handler is user to handle any
     * coroutine exception handle in IO thread
     *
     * when any exception occur in IO thread then it goes to
     * coroutineExceptionHandler and in this automatically
     * comes back in main thread.
     * */
    private val coroutineExceptionHandler by lazy {
        CoroutineExceptionHandler { _, throwable ->
            CoroutineScope(Dispatchers.Main).launch {
                Log.e("Error Occur", "Something Went Wrong. ${throwable.localizedMessage}")
            }
        }
    }

    /**
     * Create a DataStore instance using the function createDataStore().
     * This function takes the preference name (that is a String) as a parameter
     * */
    @Deprecated(
        message = "New data store not available this method.",
        replaceWith = ReplaceWith("build(context, databaseName)"),
        level = DeprecationLevel.ERROR
    )
    fun initializeDataStore(context: Context, dataBaseName: Any) {
//        EasyDataStore.initializeDataStore(context,dataBaseName)
    }


    /**
     * Create a DataStore instance using the function createDataStore().
     * This function takes the preference name (that is a String) as a parameter
     * */
    fun build(context: Context, dataBaseName: String) {
        if (easyDataStore != null) easyDataStore =
            WeakReference(EasyDataStore.get(databaseName = dataBaseName, context = context))
    }

    /**
     * GetPreferenceData() function call when you get data from preferences
     * and all data get in Dispatcher.IO thread for get data without
     * effecting to main thread and without blocking main thread.
     *
     * key is used to store preference data in Data Store for this
     * you need to pass any type of keys means any data type key
     *
     * Value: (T) can return data according to key data type. it is
     * a unit function which can return data. when data comes then
     * put data into this function it will automatically show the
     * data where u call this methods.
     *
     * When data comes then automatically comes in main thread
     * and pass this value to unit function.
     * */
    fun <T> getPreferenceData(key: Preferences.Key<T>, value: (T?) -> Unit) {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler + Job()).launch {
            easyDataStore?.get()?.getPreferenceData(key) { data ->
                CoroutineScope(Dispatchers.Main).launch {
                    value(data)
                }
            }
        }
    }


    /**
     * StoreData() is a function only used for store the data in preference.
     * you just need to pass key and value in parameters.
     *
     * key is any type of DataType key Like: String, Boolean etc....
     * this key only Preferences.Key<T> types. It is a generic type function
     * which can automatically convert data into any type of key
     *
     * This all work done in background IO thread with coroutine exception handler
     * if any exception occur then automatically go to main thread without
     * effecting main thread or app performance.
     * */
    fun <T> storeData(
        key: Preferences.Key<T>,
        storeData: T
    ) {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler + Job()).launch {
            easyDataStore?.get()?.storeData(key, storeData)
        }
    }


    /**
     * ClearKeyData() function call when you need to clear any key data.
     * In this function you just need to pass a key in parameters.
     *
     * This all work done in background thread with coroutine exception handler
     * When you call this function it will automatically clear all data from
     * Data Store Preferences files.
     *
     * <T> is a generic type you just need to pass any data type key and it
     * will automatically get the key and data and clear all data of particular key
     * */
    fun <T> clearKeyData(key: Preferences.Key<T>) {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler + Job()).launch {
            easyDataStore?.get()?.clearKeyData(key)
        }
    }


    /**
     * ClearAllData() is a function where you just need to call this
     * function without pass any parameter in the function parameters.
     *
     * This function work in background IO thread with coroutine exception handler
     * if any error occur then it will automatically return in main thread.
     * and show error message in your logcat.
     * */
    fun clearAllData() {
        CoroutineScope(Dispatchers.IO + coroutineExceptionHandler + Job()).launch {
            easyDataStore?.get()?.clearAllData()
        }
    }

}