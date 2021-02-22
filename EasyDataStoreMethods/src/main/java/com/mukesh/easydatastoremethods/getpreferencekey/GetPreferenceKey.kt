package com.mukesh.easydatastoremethods.getpreferencekey

import androidx.datastore.preferences.core.*

/**
 * In getDataPreferenceKey() function call when you need
 * to get a preference key according to type.
 *
 * Key is only in string type because key only accept a
 * string key names in PreferencesKeys.
 *
 * Any is used for get which type of key user need
 * there is all type of keys available. It can verify
 * according to data types.
 * It can detect a data type and return a preference key
 * according to user requirements.
 * */


/**
 * In this you just need to call first which data type you want to need
 * in this user need int type of preferences key for store int data in data store.
 * */
fun Int.Companion.getDataPreferenceKey(key: String): Preferences.Key<Int> = intPreferencesKey(key)

/**
 * In this you just need to call first which data type you want to need
 * in this user need double type of preferences key for store double data in data store.
 * */
fun Double.Companion.getDataPreferenceKey(key: String): Preferences.Key<Double> = doublePreferencesKey(key)

/**
 * In this you just need to call first which data type you want to need
 * in this user need string type of preferences key for store string data in data store.
 * */
fun String.Companion.getDataPreferenceKey(key: String): Preferences.Key<String> = stringPreferencesKey(key)

/**
 * In this you just need to call first which data type you want to need
 * in this user need boolean type of preferences key for store boolean data in data store.
 * */
fun Boolean.Companion.getDataPreferenceKey(key: String): Preferences.Key<Boolean> = booleanPreferencesKey(key)

/**
 * In this you just need to call first which data type you want to need
 * in this user need float type of preferences key for store float data in data store.
 * */
fun Float.Companion.getDataPreferenceKey(key: String): Preferences.Key<Float> = floatPreferencesKey(key)

/**
 * In this you just need to call first which data type you want to need
 * in this user need long type of preferences key for store long data in data store.
 * */
fun Long.Companion.getDataPreferenceKey(key: String): Preferences.Key<Long> = longPreferencesKey(key)