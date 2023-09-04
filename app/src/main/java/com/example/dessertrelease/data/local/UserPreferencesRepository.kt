package com.example.dessertrelease.data.local

import android.widget.LinearLayout
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.preferencesOf
import java.util.concurrent.Flow
import java.util.prefs.Preferences

class UserPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {
    private companion object {
        val IS_LINEAR_LAYOUT = booleanPreferencesKey("is_linear_layout")


    }

    suspend fun saveLayoutPreference(isLinearLayout: Boolean) {
        dataStore.edit { preferences ->
            preferences[isLinearLayout] = isLinearLayout

        }
    }

    val isLinearLayout : Flow<Boolean> = dataStore.data
}