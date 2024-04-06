package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    UnitConverter()

                }
            }
        }
    }
}


@Composable
fun UnitConverter() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpended by remember { mutableStateOf(false) }
    var oExpended by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableStateOf(1.00) }
    var oConversionFactor = remember { mutableStateOf(1.00) }

    fun convertUnits(){

        //?: - elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oConversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {

        Text("Unit Converter", style = MaterialTheme.typography.headlineSmall,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold



            )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnits()
            },
            label = { Text("Enter Value") })
        Spacer(modifier = Modifier.height(16.dp))


        Row {
            //Input Box
            Box {
                //Input Button
                Button(onClick = { iExpended = true }) {
                    Text(text = inputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(expanded = iExpended, onDismissRequest = { iExpended = false }) {

                    DropdownMenuItem(text = { Text("Centimeters") },
                        onClick = {
                            iExpended = false
                            inputUnit = "Centimeters"
                            conversionFactor.value = 0.1
                            convertUnits()

                        })
                    DropdownMenuItem(text = { Text("Meters") },
                        onClick = {
                            iExpended = false
                            inputUnit = "Meters"
                            conversionFactor.value = 1.0
                            convertUnits()

                        })
                    DropdownMenuItem(text = { Text("Feet") },
                        onClick = {
                            iExpended = false
                            inputUnit = "Feet"
                            conversionFactor.value = 0.3048
                            convertUnits()

                        })
                    DropdownMenuItem(text = { Text("Millimeters") },
                        onClick = {
                            iExpended = false
                            inputUnit = "Millimeters"
                            conversionFactor.value = 0.001
                            convertUnits()

                        })

                }

            }

            Spacer(modifier = Modifier.width(16.dp))
            //Output Box
            Box {
                //Output Button
                Button(onClick = { oExpended = true }) {
                    Text(text = outputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }
                DropdownMenu(expanded = oExpended, onDismissRequest = { oExpended = false }) {

                    DropdownMenuItem(text = { Text("Centimeters") },
                        onClick = {
                            oExpended = false
                            outputUnit = "Centimeters"
                            oConversionFactor.value = 0.01
                            convertUnits()



                        })
                    DropdownMenuItem(text = { Text("Meters") },
                        onClick = {
                            oExpended = false
                            outputUnit = "Meters"
                            oConversionFactor.value = 1.0
                            convertUnits()



                        })
                    DropdownMenuItem(text = { Text("Feet") },
                        onClick = {
                            oExpended = false
                            outputUnit = "Feet"
                            oConversionFactor.value = 0.3048
                            convertUnits()


                        })
                    DropdownMenuItem(text = { Text("Millimeters") },
                        onClick = {
                            oExpended = false
                            outputUnit = "Millimeters"
                            oConversionFactor.value = 0.001
                            convertUnits()


                        })

                }


            }


        }
        Text("Result: $outputValue $outputUnit",
            //Result Text
            style = MaterialTheme.typography.labelLarge,
            fontFamily = FontFamily.SansSerif,
            fontSize = 16.sp


            )

    }

}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {

    UnitConverter()

}
