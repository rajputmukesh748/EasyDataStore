package com.mukesh.easydatastoremethods.easydatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest


object EasyDataStore {

    /**
     * DataStore is a in-build method which is
     * Preferences type for store data in preference.
     * */
    private lateinit var dataStore: DataStore<Preferences>


    /**
     * Create a DataStore instance using the function createDataStore().
     * This function takes the preference name (that is a String) as a parameter
     * */
    fun initializeDataStore(context: Context, dataBaseName: Any) {
        dataStore = context.createDataStore(
            name = dataBaseName.toString()
        )
    }


    /**
     * getData() is a function which can used to get data from
     * Data store preference with then help of preference key
     *
     * <T> is a generic type which can used to declare which
     * type of data you need to get from data store.
     * */
    suspend fun <T> getPreferenceData(key: Preferences.Key<T>, value: (T?) -> Unit) =
        dataStore.edit { preferences ->
            value(preferences[key])
        }


    /**
     * <T> only pass for which data type of data.
     * You can store in data store preferences
     *
     * dataStore.edit is in build method which return MutablePreferences
     *
     * storeData is which data you can store in data store
     * key is used for unique key for store and get data with same key
     * */
    suspend fun <T> storeData(
        key: Preferences.Key<T>,
        storeData: T
    ) {
        dataStore.edit { preferences ->
            preferences[key] = storeData
        }
    }


    /**
     * Clear Key Data function used for clear all preferences data
     * <T> is a generic type you can pass any type of key for
     * delete the particular key data.
     *
     * preferences.remove(key) is in-build method where
     * you need to pass a key for delete the value of
     * particular key data in app.
     * */
    suspend fun <T> clearKeyData(key: Preferences.Key<T>) {
        dataStore.edit { preferences ->
            preferences.remove(key)
        }
    }


    /**
     * clearDllData() function call when you need to
     * clear all preference data without any key.
     *
     * preferences.clear() is in-build method where
     * you will need to call and they clear all data.
     * */
    suspend fun clearAllData() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

}