package com.example.deliveryapp.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.deliveryapp.data.datastore.model.UserDataStoreModel
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_data_store")

class DataStoreManager(val context: Context) {

    suspend fun saveUser(userDataStoreModel: UserDataStoreModel) {
        context.dataStore.edit { pref ->
            pref[stringPreferencesKey("refresh_token")] = userDataStoreModel.refreshToken
            pref[stringPreferencesKey("access_token")] = userDataStoreModel.accessToken
            pref[stringPreferencesKey("number")] = userDataStoreModel.number
        }
    }

    fun getUser() = context.dataStore.data.map { pref ->
        return@map UserDataStoreModel(
            refreshToken = pref[stringPreferencesKey("refresh_token")] ?: "",
            accessToken = pref[stringPreferencesKey("access_token")] ?: "",
            number = pref[stringPreferencesKey("number")] ?: ""
        )
    }

    suspend fun deleteUser() {
        context.dataStore.edit { pref ->
            pref[stringPreferencesKey("refresh_token")] = ""
            pref[stringPreferencesKey("access_token")] = ""
            pref[stringPreferencesKey("number")] = ""
        }
    }

}