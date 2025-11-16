package com.example.nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nav.data.Datasource

private object Route {
    const val HOME = "home"
    const val CONTACT = "contact" }

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                val nav = rememberNavController()

                NavHost(navController = nav, startDestination = Route.HOME) {
                    composable(Route.HOME) {
                        Scaffold(
                            topBar = {
                                TopAppBar(
                                    title = { Text("Home") },
                                    actions = {
                                        TextButton(
                                            onClick = { nav.navigate(Route.CONTACT) },
                                            colors = ButtonDefaults.textButtonColors(
                                                containerColor = Color(0xFF6A1B9A),
                                                contentColor = Color.White
                                            ),
                                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                                        ) {
                                            Text("Contact")
                                        }
                                    }

                                )
                            }
                        ) { pad ->
                            ScrollableList(
                                slides = Datasource.loadSlides(),
                                modifier = Modifier.padding(pad)
                            )
                        }
                    }

                    composable(Route.CONTACT) {
                        Scaffold(
                            topBar = {
                                TopAppBar(
                                    title = { Text("Contact") },
                                    actions = {
                                        IconButton(
                                            onClick = { nav.popBackStack() }) {
                                            Icon(
                                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                                contentDescription = "Back"
                                            )
                                        }
                                    }
                                )
                            }
                        ) { pad ->
                            ContactPage(modifier = Modifier.padding(pad))
                        }
                    }
                }
            }
        }
    }
}
