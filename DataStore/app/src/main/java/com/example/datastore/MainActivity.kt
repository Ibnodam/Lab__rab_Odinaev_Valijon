package com.example.datastore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.datastore.ui.theme.Blue
import com.example.datastore.ui.theme.DataStoreTheme
import com.example.datastore.ui.theme.Green
import com.example.datastore.ui.theme.Red
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import android.content.Context
import androidx.compose.material3.Surface
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.collectAsState
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataStoreManager = ProtoDataStoreManager(this)
        setContent {
            DataStoreTheme {

                val settingsState = dataStoreManager.getAll()
                    .collectAsState(initial = SettingsData())

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(settingsState.value.backgroundColor)
                ){
                    MainScreen(dataStoreManager, settingsState.value.textSize)
                }
            }
        }
    }
}

@Composable
fun MainScreen(dataStoreManager: ProtoDataStoreManager, textSize: Int) {
    val coroutine = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


    ){
        Text(text = "Some text", fontSize = textSize.sp, color = Color.White)
        Spacer(modifier = Modifier.height(30.dp))


        Button(onClick = {
            coroutine.launch {
                dataStoreManager.saveTextSize(40)
                dataStoreManager.saveColor(Blue.value)
            }
        }){Text("Blue")}
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            coroutine.launch {
                dataStoreManager.saveColor(Red.value)
                dataStoreManager.saveTextSize(80)

            }
        }){Text("Red")}
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            coroutine.launch {
            dataStoreManager.saveAll(
                SettingsData(
                    120,
                    Green.value
                )
            )}
        }){Text("Green")}
        Spacer(modifier = Modifier.height(10.dp))
    }
}
